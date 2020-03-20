package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Ghast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class onGhastLaunch implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void onGhastLaunch(ProjectileLaunchEvent event) {
        try {
            if(plugin.getConfig().getBoolean("enable_mean_ghasts")==true) {
                Entity e = event.getEntity();
                if(nether.worlds.contains(e.getWorld().getName())) {
                    if(e instanceof Fireball) {
                        if(((Fireball) e).getShooter() instanceof Ghast) {
                            Location newL = ((Fireball) e).getLocation().clone();
                            ((Fireball) e).setYield(((Fireball) e).getYield()*3);
                            e.setVelocity(e.getVelocity().add(new Vector(e.getVelocity().getX()*2, 0, e.getVelocity().getZ()*2)));
                            if(randint.nextBoolean()==true) {
                                ((Ghast) ((Fireball) e).getShooter()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 100, false, false));
                                (((Fireball) e)).getWorld().spawnParticle(Particle.CLOUD,((Ghast) ((Fireball) e).getShooter()).getLocation(), 100);
                            }
                        }
                    }
                }
            }
        }
        catch(Exception ee) {
            System.out.println(ChatColor.RED + "Uh oh error inside onGhastLaunch.");
        }
    }
}
