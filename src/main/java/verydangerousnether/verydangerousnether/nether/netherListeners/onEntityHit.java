package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

import static verydangerousnether.verydangerousnether.utils.exists.exists;

public class onEntityHit implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void entityHit(EntityDamageByEntityEvent event) {
        if(event.isCancelled()) {
            return;
        }
        if(!nether.worlds.contains(event.getEntity().getWorld().getName())) {
            return;
        }
        World wor = event.getEntity().getWorld();
        if (event.getDamager() instanceof Monster && event.getEntity() instanceof Player) {
            if(hasName(plugin.getConfig().getString("molten"), event.getDamager())) {
                if (randint.nextInt(2) == 1) {
                    ((LivingEntity) event.getEntity()).setFireTicks(60);
                }
                return;
            }
            else if(hasName(plugin.getConfig().getString("alpha_pigman"), event.getDamager())) {
                ((LivingEntity) event.getEntity())
                        .addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 75, 1));
                return;
            }
            else if(hasName(plugin.getConfig().getString("sherogath"), event.getDamager())) {
                lagPlayer((LivingEntity) event.getEntity(), 0, randint.nextInt(10)+5);
                return;
            }
        }
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Monster) {
            if(randint.nextInt(6)==1) {
                if(hasName(plugin.getConfig().getString("sadness"), event.getEntity())) {
                    if(randint.nextInt(3)==1) {
                        event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_WOLF_DEATH, 1, 0);
                    }
                    if(((LivingEntity) event.getEntity()).hasPotionEffect(PotionEffectType.SLOW)) {
                        ((LivingEntity) event.getEntity()).removePotionEffect(PotionEffectType.SLOW);
                    }
                    return;
                }
            }
        }
    }

    public boolean hasName(String n, Entity e) {
        if(exists(e)) {
            if(e.hasMetadata(n)) {
                return true;
            }
            if(e.getCustomName() != null) {
                String name = ChatColor.stripColor(e.getCustomName());
                if((!name.equals("")) && (!name.equals(" "))) {
                    if(name.equals(n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void lagPlayer(LivingEntity p, int time, int maxTime) {
        if((!exists(p)) || (time >= maxTime)) {
            return;
        }
        else {
            p.teleport(p.getLocation().add(coinFlip()*(randint.nextInt(5)/30.0), 0, coinFlip()*(randint.nextInt(5)/30.0)));
            Bukkit.getScheduler().runTaskLater(plugin, () -> lagPlayer(p, time + 1, maxTime), randint.nextInt(6)+2);
        }
    }

    public int coinFlip() {
        if(randint.nextBoolean()) {
            return -1;
        }
        return 1;
    }
}
