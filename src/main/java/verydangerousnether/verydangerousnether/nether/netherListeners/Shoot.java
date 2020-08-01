package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import verydangerousnether.verydangerousnether.main;

public class Shoot implements Listener {

    Plugin plugin = main.getPlugin(main.class);

    @EventHandler
    public void shoot(EntityShootBowEvent event) {
        LivingEntity shooter = event.getEntity();
        if (shooter.hasMetadata(plugin.getConfig().getString("fireball"))) {
            Vector v = event.getProjectile().getVelocity();
            event.getProjectile().remove();
            shooter.launchProjectile(SmallFireball.class, v);
            return;
        } else if (shooter.hasMetadata(plugin.getConfig().getString("necromancer"))) {
            Vector v = event.getProjectile().getVelocity();
            event.getProjectile().remove();
            shooter.launchProjectile(WitherSkull.class, v);
        }
    }
}
