package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class AlphaPigman extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("alpha_pigman"));

    public AlphaPigman(Entity e) {
        if(e.getType()!= EntityType.ZOMBIFIED_PIGLIN) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIFIED_PIGLIN);
            e.remove();
            e = (LivingEntity) e2;
        }
        EntityEquipment ee = ((LivingEntity)e).getEquipment();
        ee.setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
        e.setCustomName(name);
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("vdn", new FixedMetadataValue(plugin, 0));
        e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
        ((LivingEntity) e).setRemoveWhenFarAway(true);
    }
}
