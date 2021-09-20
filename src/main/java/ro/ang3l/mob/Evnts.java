package ro.ang3l.mob;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import java.util.HashMap;
import java.util.Map;


public class Evnts implements Listener {
    @EventHandler
    public void spn(CreatureSpawnEvent e) {
        if (Main.mobs.containsKey(e.getEntityType().name())) {
            int size = 0;
            for (Entity ent : e.getLocation().getChunk().getEntities()) {
                if (ent.getType().equals(e.getEntityType())) {
                    size++;
                }
            }
            if (size >= Main.mobs.get(e.getEntityType().name())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void spn(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && Main.eggs.contains(e.getItem().getType().name())) {
                EntityType et = Utils.getEggType(e.getItem().getType().name());
                if (Main.mobs.containsKey(et.name())) {
                    int size = 0;
                    for (Entity ent : e.getPlayer().getLocation().getChunk().getEntities()) {
                        if (ent.getType().equals(et)) {
                            size++;
                        }
                    }
                    if (size >= Main.mobs.get(et.name())) {
                        Utils.sendMessage(e.getPlayer(), Main.maxMob);
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void chk(ChunkLoadEvent e) {
        Map<EntityType, Integer> entit = new HashMap<>();
        for (Entity ent : e.getChunk().getEntities()) {
            if (Main.mobs.containsKey(ent.getType().name())) {
                if (!entit.containsKey(ent.getType())) {
                    entit.put(ent.getType(), 1);
                } else {
                    if (entit.get(ent.getType()) >= Main.mobs.get(ent.getType().name())) {
                        ent.remove();
                    } else {
                        entit.replace(ent.getType(), entit.get(ent.getType()) + 1);
                    }
                }
            }
        }
    }
}
