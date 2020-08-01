package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class Sherogath extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("sherogath"));

    public Sherogath(Entity e) {
        if(e.getType()!= EntityType.ZOMBIE_VILLAGER) {
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
        e.setMetadata("vdn", new FixedMetadataValue(plugin, 0));
        e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
        ((LivingEntity)e).setRemoveWhenFarAway(true);
    }
}
