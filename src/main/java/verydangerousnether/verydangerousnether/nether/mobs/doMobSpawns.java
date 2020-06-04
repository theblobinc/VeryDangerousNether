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
                    Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.SKELETON);
                    e.remove();
                    e = (LivingEntity) e2;
                    e.setSilent(true);
                    EntityEquipment ee = ((LivingEntity) e).getEquipment();
                    ItemStack myAwesomeSkull = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
                    myAwesomeSkullMeta.setOwner("Spe");
                    myAwesomeSkull.setItemMeta(myAwesomeSkullMeta);
                    ee.setHelmet(myAwesomeSkull);
                    ee.setHelmetDropChance(0);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
                }

                //HIGH PRIORITY
                else if(name.equals(plugin.getConfig().getString("necromancer")) && plugin.getConfig().getBoolean("spawn_necromancer")) {
                    if(e.getType()!= EntityType.WITHER_SKELETON) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.WITHER_SKELETON);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    EntityEquipment ee = (e).getEquipment();
                    ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                    LeatherArmorMeta lch6 = (LeatherArmorMeta) lchest.getItemMeta();
                    lch6.setColor(Color.fromRGB(38, 33, 36));
                    lchest.setItemMeta(lch6);
                    ItemStack lchest3 = new ItemStack(Material.LEATHER_BOOTS, 1);
                    LeatherArmorMeta lch62 = (LeatherArmorMeta) lchest3.getItemMeta();
                    lch62.setColor(Color.fromRGB(38, 33, 36));
                    lchest3.setItemMeta(lch62);
                    ItemStack myAwesomeSkull = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
                    myAwesomeSkullMeta.setOwner("MHF_WSkeleton");
                    myAwesomeSkull.setItemMeta(myAwesomeSkullMeta);
                    ee.setHelmet(myAwesomeSkull);
                    ee.setChestplate(lchest);
                    ee.setBoots(lchest3);
                    ee.setItemInMainHand(new ItemStack(Material.BOW));
                    e.setRemoveWhenFarAway(true);

                }
                else if(name.equals(plugin.getConfig().getString("alpha_pigman")) && plugin.getConfig().getBoolean("spawn_alpha_pigman")) {
                    if(e.getType()!= EntityType.PIG_ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.PIG_ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    EntityEquipment ee = (e).getEquipment();
                    ee.setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
                }
                else if(name.equals(plugin.getConfig().getString("sherogath"))) {
                    if(e.getType()!= EntityType.ZOMBIE_VILLAGER) {
                        //Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                        //((Zombie) e2).setBaby(true);
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE_VILLAGER);
                        ((ZombieVillager) e2).setBaby(true);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 1));
                    e.setSilent(true);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
                }
                else if(name.equals(plugin.getConfig().getString("molten")) && plugin.getConfig().getBoolean("spawn_molten")) {
                    if(e.getType()!= EntityType.ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    EntityEquipment ee = (e).getEquipment();
                    e.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 100, false, false));
                    e.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 100, false, false));
                    ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                    LeatherArmorMeta lch6 = (LeatherArmorMeta) lchest.getItemMeta();
                    lch6.setColor(Color.fromRGB(252, 115, 69));
                    lchest.setItemMeta(lch6);
                    ItemStack lchest2 = new ItemStack(Material.LEATHER_BOOTS, 1);
                    LeatherArmorMeta lch61 = (LeatherArmorMeta) lchest2.getItemMeta();
                    lch61.setColor(Color.fromRGB(252, 115, 69));
                    lchest2.setItemMeta(lch61);
                    ItemStack lchest3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                    LeatherArmorMeta lch62 = (LeatherArmorMeta) lchest3.getItemMeta();
                    lch62.setColor(Color.fromRGB(252, 115, 69));
                    lchest3.setItemMeta(lch62);
                    ee.setItemInMainHand(new ItemStack(Material.FIRE, 1));
                    ee.setItemInOffHand(new ItemStack(Material.FIRE, 1));
                    ee.setChestplate(lchest);
                    ee.setLeggings(lchest3);
                    ee.setBoots(lchest2);
                    e.setFireTicks(999999);
                    e.setCustomName(name);
                    e.setSilent(true);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
                }
                else if(name.equals(plugin.getConfig().getString("sadness")) && plugin.getConfig().getBoolean("spawn_sadness")) {
                    if(e.getType()!= EntityType.ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 200));
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 2));
                    e.setSilent(true);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
                }
                else if(name.equals(plugin.getConfig().getString("old_shadow")) && plugin.getConfig().getBoolean("spawn_old_shadow")) {
                    if(e.getType()!= EntityType.ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    e.setSilent(true);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
                }
                else if(name.equals(plugin.getConfig().getString("inferno")) && plugin.getConfig().getBoolean("spawn_inferno")) {
                    Entity scream = e.getWorld().spawnEntity(e.getLocation().add(0, 1, 0), EntityType.ZOMBIE_VILLAGER);
                    ((ZombieVillager) scream).setBaby(true);
                    EntityEquipment ee = ((Monster) scream).getEquipment();
                    ItemStack myAwesomeSkull = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
                    myAwesomeSkullMeta.setOwner("Balabix");
                    myAwesomeSkull.setItemMeta(myAwesomeSkullMeta);
                    ee.setHelmet(myAwesomeSkull);
                    //ee.setHelmet(getSkull("http://textures.minecraft.net/texture/f142a35ac0b055ed50a5cbf870b6ef1cc1f94e2642b9ba650c9e0385e6cbe36"));
                    Entity scream2 = e.getWorld().spawnEntity(e.getLocation().add(0, 1, 0), EntityType.BAT);
                    ((LivingEntity) scream).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    ((LivingEntity) scream).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 200));
                    ((LivingEntity) scream2).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    scream2.setSilent(true);
                    scream2.setPassenger(scream);
                    ((LivingEntity) scream).setHealth(3);
                    e.remove();
                    scream.setCustomName(name);
                    scream.setSilent(true);
                    scream.setMetadata(name, new FixedMetadataValue(plugin, 0));
                    scream.setMetadata("R", new FixedMetadataValue(plugin, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
                    e.setRemoveWhenFarAway(true);
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
