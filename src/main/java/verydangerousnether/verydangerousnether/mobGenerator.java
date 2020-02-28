package verydangerousnether.verydangerousnether;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


//trying to access config thru this
public class mobGenerator {
    //rewrite some of the VeryDangerousNether main class

    public VeryDangerousNether plugin;

    public void VariableManager(VeryDangerousNether plugin){
        this.plugin = plugin;
    }

// Then use:

    plugin.getConfig("yes ")

// To get configuration stuff

    public void doMobSpawns(Entity entitye) {
        LivingEntity e = (LivingEntity) entitye;
        String name = mobTypes();
        if (e != null && !e.isDead()) {
            //Test that prints to console
            //console.sendMessage(ChatColor.GREEN + "You are inside the doMobSpawns method");
            try {
                if(name.equals(config.getString("Fireball = "))) {
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
                    /*ee.setHelmet(getSkull("http://textures.minecraft.net/texture/b6965e6a58684c277d18717cec959f2833a72dfa95661019dbcdf3dbf66b048"));
                     */
                    ee.setHelmetDropChance(0);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Something with fireballs");
                }

                //HIGH PRIORITY
                else if(name.equals(config.getString("Necromancer = "))) {
                    if(e.getType()!=EntityType.WITHER_SKELETON) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.WITHER_SKELETON);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
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
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Necromancer");
                    /*ee.setHelmet(getSkull("http://textures.minecraft.net/texture/ee280cefe946911ea90e87ded1b3e18330c63a23af5129dfcfe9a8e166588041"));
                    ee.setChestplate(lchest);
                    ee.setBoots(lchest3);
                    ee.setItemInMainHand(new ItemStack(Material.BOW));

                     */
                }
                else if(name.equals(config.getString("Alpha Pigman = "))) {
                    if(e.getType()!=EntityType.PIG_ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.PIG_ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    EntityEquipment ee = (e).getEquipment();
                    ee.setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Alpha Pigman");
                }
                else if(name.equals(config.getString("Sherogath = "))) {
                    if(e.getType()!=EntityType.ZOMBIE_VILLAGER) {
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
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Sherogath");
                }
                else if(name.equals(config.getString("Molten = "))) {
                    if(e.getType()!=EntityType.ZOMBIE) {
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
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Necromancer");
                }
                else if(name.equals(config.getString("Sadness = "))) {
                    if(e.getType()!=EntityType.ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 200));
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 2));
                    e.setSilent(true);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Sadness");
                }
                else if(name.equals(config.getString("Old Shadow = "))) {
                    if(e.getType()!=EntityType.ZOMBIE) {
                        Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                        e.remove();
                        e = (LivingEntity) e2;
                    }
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
                    e.setSilent(true);
                    e.setCustomName(name);
                    e.setMetadata(name, new FixedMetadataValue(this, 0));
                    e.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Old shadow");
                }
                else if(name.equals(config.getString("Inferno = "))) {
                    Entity scream = e.getWorld().spawnEntity(e.getLocation().add(0, 1, 0), EntityType.ZOMBIE_VILLAGER);
                    ((ZombieVillager) scream).setBaby(true);
                    EntityEquipment ee = ((Monster) scream).getEquipment();
                    ItemStack myAwesomeSkull = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
                    myAwesomeSkullMeta.setOwner("crolin");
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
                    scream.setMetadata(name, new FixedMetadataValue(this, 0));
                    scream.setMetadata("R", new FixedMetadataValue(this, 0));
                    e.setMetadata("nethermob", new FixedMetadataValue(this, 0));
                    //Test that prints to console
                    //console.sendMessage(ChatColor.GREEN + "No idea what this does.. but it runs! Maybe it spawns a Inferno");
                }
            }
            catch(Exception error) {
                console.sendMessage(ChatColor.RED + "Uh oh error inside dressing mob.");
            }
        }

        return;
    }
}
