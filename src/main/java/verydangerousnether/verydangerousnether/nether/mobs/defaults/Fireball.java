package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class Fireball extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("fireball"));

    public Fireball(Entity e) {
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
        ((LivingEntity)e).setRemoveWhenFarAway(true);
    }
}
