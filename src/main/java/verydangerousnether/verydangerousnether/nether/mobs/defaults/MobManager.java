package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;

import java.util.Random;

public class MobManager {

    Plugin plugin = main.getPlugin(main.class);

    Random r = new Random();

    public MobManager(Entity e, String type){
        int chance = r.nextInt(100);
        if (type.equalsIgnoreCase("wastes")) {
            int rand = r.nextInt(5);
            if (rand == 0) {
                if (chance < plugin.getConfig().getInt("molten_chance") && plugin.getConfig().getBoolean("spawn_molten")) {
                    Mob m = new Molten(e);
                }
            } else if (rand == 1) {
                if (chance < plugin.getConfig().getInt("fireball_chance") && plugin.getConfig().getBoolean("spawn_fireball")) {
                    Mob m = new Fireball(e);
                }
            } else if (rand == 2) {
                if (chance < plugin.getConfig().getInt("inferno_chance") && plugin.getConfig().getBoolean("spawn_inferno")) {
                    Mob m = new Inferno(e);
                }
            } else if (rand == 3) {
                return;
            } else if (rand == 4) {
                if (chance < plugin.getConfig().getInt("alpha_pigman_chance") && plugin.getConfig().getBoolean("spawn_alpha_pigman")) {
                    Mob m = new AlphaPigman(e);
                }
            }
        } else if (type.equalsIgnoreCase("valley")) {
            int rand = r.nextInt(3);
            if (rand == 0) {
                if (chance < plugin.getConfig().getInt("old_shadow_chance") && plugin.getConfig().getBoolean("spawn_old_shadow")) {
                    Mob m = new OldShadow(e);
                }
            } else if (rand == 1) {
                if (chance < plugin.getConfig().getInt("sadness_chance") && plugin.getConfig().getBoolean("spawn_sadness")) {
                    Mob m = new Sadness(e);
                }
            } else if (rand == 2) {
                if (chance < plugin.getConfig().getInt("sherogath_chance") && plugin.getConfig().getBoolean("spawn_sherogath")) {
                    Mob m = new Sherogath(e);
                }
            }
        } else if (type.equalsIgnoreCase("crimson")) {
            int rand = r.nextInt(2);
            if (rand == 0) {
                if (chance < plugin.getConfig().getInt("alpha_pigman_chance") && plugin.getConfig().getBoolean("spawn_alpha_pigman")) {
                    Mob m = new AlphaPigman(e);
                }
            } else if (rand == 1) {
                if (chance < plugin.getConfig().getInt("necromancer_chance") && plugin.getConfig().getBoolean("spawn_necromancer")) {
                    Mob m = new Necromancer(e);
                }
            }
        } else if (type.equalsIgnoreCase("warped")) {
            int rand = r.nextInt(2);
            if (rand == 0) {
                if (chance < plugin.getConfig().getInt("alpha_pigman_chance") && plugin.getConfig().getBoolean("spawn_alpha_pigman")) {
                    Mob m = new AlphaPigman(e);
                }
            } else if (rand == 1) {
                if (chance < plugin.getConfig().getInt("necromancer_chance") && plugin.getConfig().getBoolean("spawn_necromancer")) {
                    Mob m = new Necromancer(e);
                }
            }
        } else if (type.equalsIgnoreCase("deltas")) {
            int rand = r.nextInt(3);
            if (rand == 0) {
                if (chance < plugin.getConfig().getInt("molten_chance") && plugin.getConfig().getBoolean("spawn_molten")) {
                    Mob m = new Molten(e);
                }
            } else if (rand == 1) {
                if (chance < plugin.getConfig().getInt("fireball_chance") && plugin.getConfig().getBoolean("spawn_fireball")) {
                    Mob m = new Fireball(e);
                }
            } else if (rand == 2) {
                if (chance < plugin.getConfig().getInt("inferno_chance") && plugin.getConfig().getBoolean("spawn_inferno")) {
                    Mob m = new Inferno(e);
                }
            }
        }
    }
}
