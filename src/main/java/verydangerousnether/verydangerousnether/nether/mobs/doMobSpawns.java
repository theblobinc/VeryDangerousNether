package verydangerousnether.verydangerousnether.nether.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.defaults.*;
import verydangerousnether.verydangerousnether.nether.mobs.defaults.Fireball;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

import static verydangerousnether.verydangerousnether.utils.exists.exists;


public class doMobSpawns implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void deleteLightLevel(CreatureSpawnEvent event) {
        if(event.isCancelled()) {
            return;
        }
        Entity e = event.getEntity();
        if (exists(e)) {
            if(!nether.worlds.contains(e.getWorld().getName())) {
                return;
            }
            World wor = event.getEntity().getWorld();
            if(nether.caveEnts) {
                Block b = e.getLocation().subtract(0, 1, 0).getBlock();
                if(b==null) {
                    return;
                }
                if(nether.caveEnts) {
                    if (e instanceof PigZombie) {
                        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && (b.getType()== Material.NETHERRACK || b.getType()== Material.SOUL_SAND)) {
                            if(randint.nextInt(100) < nether.mob_spawn_chance) {
                                doMobSpawns(e);
                            }
                        }
                    }
                }
                else {
                    return;
                }
            }
        }
    }

    public void doMobSpawns(Entity entitye) {
        LivingEntity e = (LivingEntity) entitye;
        String name = mobTypes();
        Random spawntype = new Random();
        if (e != null && !e.isDead()) {
            try {
                if(name.equals(plugin.getConfig().getString("fireball")) && plugin.getConfig().getBoolean("spawn_fireball")) {
                    Mob m = new Fireball(e);
                }
                else if(name.equals(plugin.getConfig().getString("necromancer")) && plugin.getConfig().getBoolean("spawn_necromancer")) {
                    Mob m = new Necromancer(e);
                }
                else if(name.equals(plugin.getConfig().getString("alpha_pigman")) && plugin.getConfig().getBoolean("spawn_alpha_pigman")) {
                    Mob m = new AlphaPigman(e);
                }
                else if(name.equals(plugin.getConfig().getString("sherogath"))) {
                    Mob m = new Sherogath(e);
                }
                else if(name.equals(plugin.getConfig().getString("molten")) && plugin.getConfig().getBoolean("spawn_molten")) {
                    Mob m = new Molten(e);
                }
                else if(name.equals(plugin.getConfig().getString("sadness")) && plugin.getConfig().getBoolean("spawn_sadness")) {
                    Mob m = new Sadness(e);
                }
                else if(name.equals(plugin.getConfig().getString("old_shadow")) && plugin.getConfig().getBoolean("spawn_old_shadow")) {
                    Mob m = new OldShadow(e);
                }
                else if(name.equals(plugin.getConfig().getString("inferno")) && plugin.getConfig().getBoolean("spawn_inferno")) {
                    Mob m = new Inferno(e);
                }
            }
            catch(Exception error) {
                System.out.println(ChatColor.RED + "Uh oh error inside dressing mob.");
            }
        }

        return;
    }

    public String mobTypes() {
        int choice = randint.nextInt(8);
        try {
            if(choice == 0) {
                if(plugin.getConfig().getBoolean("spawn_molten")) {
                    return plugin.getConfig().getString("molten");
                }
                else {
                    return "";
                }
            }
            else if(choice == 1) {
                if(plugin.getConfig().getBoolean("spawn_fireball")) {
                    return plugin.getConfig().getString("fireball");
                }
                else {
                    return "";
                }
            }
            else if(choice == 2) {
                if(plugin.getConfig().getBoolean("spawn_inferno")) {
                    return plugin.getConfig().getString("inferno");
                }
                else {
                    return "";
                }
            }
            else if(choice == 3) {
                if(plugin.getConfig().getBoolean("spawn_old_shadow")) {
                    return plugin.getConfig().getString("old_shadow");
                }
                else {
                    return "";
                }
            }
            else if(choice == 4) {
                if(plugin.getConfig().getBoolean("spawn_sadness")) {
                    return plugin.getConfig().getString("sadness");
                }
                else {
                    return "";
                }
            }
            else if(choice == 5) {
                if(plugin.getConfig().getBoolean("spawn_sherogath")) {
                    return plugin.getConfig().getString("sherogath");
                }
                else {
                    return "";
                }
            }
            else if(choice == 6) {
                if(plugin.getConfig().getBoolean("spawn_necromancer")) {
                    return plugin.getConfig().getString("necromancer");
                }
                else {
                    return "";
                }
            }
            else if(choice == 7) {
                if(plugin.getConfig().getBoolean("spawn_alpha_pigman")) {
                    return plugin.getConfig().getString("alpha_pigman");
                }
                else {
                    return "";
                }
            }
            return "";
        }
        catch(Exception error) {
            System.out.println(ChatColor.RED + "Uh oh error inside mob names.");
            return "";
        }
    }
}
