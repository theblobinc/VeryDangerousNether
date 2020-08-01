package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class Inferno extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("inferno"));

    public Inferno(Entity e) {
        if (!e.equals(EntityType.SKELETON)) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.SKELETON);
            e.remove();
            e = (LivingEntity) e2;
            e.setSilent(true);

            //Skull
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();
            skullmeta.setOwner("Spe");
            skull.setItemMeta(skullmeta);

            //Entity Equipment
            EntityEquipment ee = ((LivingEntity)e).getEquipment();
            ee.setHelmet(skull);
            ee.setHelmetDropChance(0);
            e.setCustomName(name);
            e.setMetadata(name, new FixedMetadataValue(plugin, 0));
            e.setMetadata("vdn", new FixedMetadataValue(plugin, 0));
            e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
            ((LivingEntity) e).setRemoveWhenFarAway(true);

        }
    }
}
