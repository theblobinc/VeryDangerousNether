package verydangerousnether.verydangerousnether.nether.mobs.defaults;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.utils.utils;

public class Sadness extends Mob {

    Plugin plugin = main.getPlugin(main.class);
    String name = utils.chat(plugin.getConfig().getString("sadness"));

    public Sadness(Entity e) {
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
        e.setMetadata("vdn", new FixedMetadataValue(plugin, 0));
        e.setMetadata("nethermob", new FixedMetadataValue(plugin, 0));
        ((LivingEntity) e).setRemoveWhenFarAway(true);
    }
}
