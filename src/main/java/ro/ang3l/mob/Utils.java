package ro.ang3l.mob;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Utils {
    public static void sendMessage(Player p, String message) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static boolean checkEntity(String ent) {
        try {
            EntityType.valueOf(ent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean checkNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static EntityType getEggType(String name) {
        switch (name.toLowerCase()) {
            case "bat_spawn_egg":
                return EntityType.BAT;

            case "bee_spawn_egg":
                return EntityType.BEE;

            case "blaze_spawn_egg":
                return EntityType.BLAZE;

            case "cave_spider_spawn_egg":
                return EntityType.CAVE_SPIDER;

            case "cat_spawn_egg":
                return EntityType.CAT;

            case "chicken_spawn_egg":
                return EntityType.CHICKEN;

            case "cod_spawn_egg":
                return EntityType.COD;

            case "cow_spawn_egg":
                return EntityType.COW;

            case "creeper_spawn_egg":
                return EntityType.CREEPER;

            case "dolphin_spawn_egg":
                return EntityType.DOLPHIN;

            case "donkey_spawn_egg":
                return EntityType.DONKEY;

            case "drowned_spawn_egg":
                return EntityType.DROWNED;

            case "elder_guardian_spawn_egg":
                return EntityType.ELDER_GUARDIAN;

            case "enderman_spawn_egg":
                return EntityType.ENDERMAN;

            case "endermite_spawn_egg":
                return EntityType.ENDERMITE;

            case "evoker_spawn_egg":
                return EntityType.EVOKER;

            case "fox_spawn_egg":
                return EntityType.FOX;

            case "ghast_spawn_egg":
                return EntityType.GHAST;

            case "glow_squid_spawn_egg":
                return EntityType.SQUID;

            case "guardian_spawn_egg":
                return EntityType.GUARDIAN;

            case "hoglin_spawn_egg":
                return EntityType.HOGLIN;

            case "horse_spawn_egg":
                return EntityType.HORSE;

            case "husk_spawn_egg":
                return EntityType.HUSK;

            case "llama_spawn_egg":
                return EntityType.LLAMA;

            case "magma_cube_spawn_egg":
                return EntityType.MAGMA_CUBE;

            case "mooshroom_spawn_egg":
                return EntityType.MUSHROOM_COW;

            case "mule_spawn_egg":
                return EntityType.MULE;

            case "ocelot_spawn_egg":
                return EntityType.OCELOT;

            case "panda_spawn_egg":
                return EntityType.PANDA;

            case "parrot_spawn_egg":
                return EntityType.PARROT;

            case "phantom_spawn_egg":
                return EntityType.PHANTOM;

            case "pig_spawn_egg":
                return EntityType.PIG;

            case "piglin_spawn_egg":
                return EntityType.PIGLIN;

            case "piglin_brute_spawn_egg":
                return EntityType.PIGLIN_BRUTE;

            case "pillager_spawn_egg":
                return EntityType.PILLAGER;

            case "polar_bear_spawn_egg":
                return EntityType.POLAR_BEAR;

            case "pufferfish_spawn_egg":
                return EntityType.PUFFERFISH;

            case "rabbit_spawn_egg":
                return EntityType.RABBIT;

            case "ravager_spawn_egg":
                return EntityType.RAVAGER;

            case "salmon_spawn_egg":
                return EntityType.SALMON;

            case "sheep_spawn_egg":
                return EntityType.SHEEP;

            case "shulker_spawn_egg":
                return EntityType.SHULKER;

            case "silverfish_spawn_egg":
                return EntityType.SILVERFISH;

            case "skeleton_spawn_egg":
                return EntityType.SKELETON;

            case "skeleton_horse_spawn_egg":
                return EntityType.SKELETON_HORSE;

            case "slime_spawn_egg":
                return EntityType.SLIME;

            case "spider_spawn_egg":
                return EntityType.SPIDER;

            case "squid_spawn_egg":
                return EntityType.SQUID;

            case "stray_spawn_egg":
                return EntityType.STRAY;

            case "strider_spawn_egg":
                return EntityType.STRIDER;

            case "trader_llama_spawn_egg":
                return EntityType.TRADER_LLAMA;

            case "tropical_fish_spawn_egg":
                return EntityType.TROPICAL_FISH;

            case "turtle_spawn_egg":
                return EntityType.TURTLE;

            case "vex_spawn_egg":
                return EntityType.VEX;

            case "villager_spawn_egg":
                return EntityType.VILLAGER;

            case "vindicator_spawn_egg":
                return EntityType.VINDICATOR;
            case "wandering_trader_spawn_egg":
                return EntityType.WANDERING_TRADER;

            case "witch_spawn_egg":
                return EntityType.WITCH;

            case "wither_skeleton_spawn_egg":
                return EntityType.WITHER_SKELETON;

            case "wolf_spawn_egg":
                return EntityType.WOLF;

            case "zombie_spawn_egg":
                return EntityType.ZOMBIE;

            case "zombie_horse_spawn_egg":
                return EntityType.ZOMBIE_HORSE;

            case "zombie_villager_spawn_egg":
                return EntityType.ZOMBIE_VILLAGER;

            case "zombified_piglin_spawn_egg":
                return EntityType.ZOMBIFIED_PIGLIN;

            default:
                return EntityType.CHICKEN;
        }
    }
}
