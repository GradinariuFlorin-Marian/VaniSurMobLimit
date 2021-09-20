package ro.ang3l.mob;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JavaPlugin {
    static Map<String, Integer> mobs = new HashMap<>();
    static List<String> eggs = new ArrayList<>();
    static String maxMob;

    @Override
    public void onEnable() {
        loadConfig();
        Bukkit.getPluginManager().registerEvents(new Evnts(), this);
    }

    public void loadConfig() {
        File f = new File(getDataFolder(), "config.yml");
        if (!f.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        maxMob = getConfig().getString("MaxMob");
        for (String s : getConfig().getStringList("Mobs")) {
            String[] splitter = s.split(":");
            if (Utils.checkEntity(splitter[0].toUpperCase())) {
                if (Utils.checkNumber(splitter[1])) {
                    mobs.put(splitter[0].toUpperCase(), Integer.parseInt(splitter[1]));
                    eggs.add(splitter[0].toUpperCase() + "_SPAWN_EGG");
                } else {
                    System.out.println("[VaniSurMobLimit] Not a number on entity " + splitter[0]);
                }
            } else {
                System.out.println("[VaniSurMobLimit] Wrong entity " + splitter[0]);
            }
        }

        for (World w : Bukkit.getWorlds()) {
            Map<EntityType, Integer> entit = new HashMap<>();
            for (Entity ent2 : w.getEntities()) {
                entit.clear();
                for (Entity ent : ent2.getLocation().getChunk().getEntities()) {
                    if (mobs.containsKey(ent.getType().name())) {
                        if (!entit.containsKey(ent.getType())) {
                            entit.put(ent.getType(), 1);
                        } else {
                            if (entit.get(ent.getType()) >= mobs.get(ent.getType().name())) {
                                ent.remove();
                            } else {
                                entit.replace(ent.getType(), entit.get(ent.getType()) + 1);
                            }
                        }
                    }
                }
            }
        }
    }
}
