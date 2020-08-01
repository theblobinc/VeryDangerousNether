package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class Molten extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("molten"));

    public Molten(Entity e) {
        if(e.getType()!= EntityType.ZOMBIE) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
            e.remove();
            e = (LivingEntity) e2;
        }
        EntityEquipment ee = ((LivingEntity)e).getEquipment();
        ((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 100, false, false));
        ((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 100, false, false));
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
        e.setMetadata("vdn", new FixedMetadataValue(plugin, 0));
        e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
        ((LivingEntity)e).setRemoveWhenFarAway(true);
    }
}
