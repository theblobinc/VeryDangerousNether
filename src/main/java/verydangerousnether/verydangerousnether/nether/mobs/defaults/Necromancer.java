package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class Necromancer extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("necromancer"));

    public Necromancer(Entity e) {

        if(e.getType()!= EntityType.WITHER_SKELETON) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.WITHER_SKELETON);
            e.remove();
            e = (LivingEntity) e2;
        }

        EntityEquipment ee = ((LivingEntity) e).getEquipment();
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();
        skullmeta.setOwner("MHF_WSkeleton");
        skull.setItemMeta(skullmeta);
        ee.setHelmet(skull);
        ee.setHelmetDropChance(0);

        ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lch6 = (LeatherArmorMeta) lchest.getItemMeta();
        lch6.setColor(Color.fromRGB(38, 33, 36));
        lchest.setItemMeta(lch6);
        ItemStack lchest3 = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lch62 = (LeatherArmorMeta) lchest3.getItemMeta();
        lch62.setColor(Color.fromRGB(38, 33, 36));
        lchest3.setItemMeta(lch62);

        ee.setChestplate(lchest);
        ee.setBoots(lchest3);
        ee.setItemInMainHand(new ItemStack(Material.BOW));

        e.setCustomName(name);
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("vdn", new FixedMetadataValue(plugin, 0));
        e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));

        ((LivingEntity) e).setRemoveWhenFarAway(true);

    }
}
