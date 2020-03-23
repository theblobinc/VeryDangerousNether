package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class soulsandSlowness implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {
        if(plugin.getConfig().getBoolean("soulsand_slowness") == true) {
            try {
                Player p = event.getPlayer();
                if(!nether.worlds.contains(p.getWorld().getName())) {
                    return;
                }
                World wor = p.getWorld();
                if(randint.nextInt(2)==0) {
                    if(p.isSprinting()) {
                        if(p.getLocation().subtract(0, 1, 0).getBlock().getType()== Material.SOUL_SAND) {
                            if(nether.inHell(p.getLocation().getBlock())) {
                                if (randint.nextBoolean() == true) {
                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_SCREAM, (float) 1, 0);
                                } else {
                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_SCREAM, (float) 1, 2);
                                }
                                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, randint.nextInt(200)+40, 3, false, false));
                            }
                        }
                    }
                }
                if(randint.nextInt(100) < plugin.getConfig().getInt("netherrack_melting_chance")) {
                    if(p.getLocation().subtract(0, 1, 0).getBlock().getType()== Material.NETHERRACK){
                        if(nether.inHell(p.getLocation().getBlock())) {
                            Location newL = p.getLocation().subtract(0, 1, 0);
                            Material xp = newL.clone().add(1, 0, 0).getBlock().getType();
                            Material xn = newL.clone().subtract(1, 0, 0).getBlock().getType();
                            Material zp = newL.clone().add(0, 0, 1).getBlock().getType();
                            Material zn = newL.clone().subtract(0, 0, 1).getBlock().getType();
                            Location newL2 = p.getLocation();
                            Material xp2 = newL2.clone().add(1, 0, 0).getBlock().getType();
                            Material xn2 = newL2.clone().subtract(1, 0, 0).getBlock().getType();
                            Material zp2 = newL2.clone().add(0, 0, 1).getBlock().getType();
                            Material zn2 = newL2.clone().subtract(0, 0, 1).getBlock().getType();
                            if((xp == Material.LAVA)||(xn == Material.LAVA)||(zn == Material.LAVA)||(zp == Material.LAVA)) {
                                p.getLocation().subtract(0,1,0).getBlock().setType(Material.MAGMA_BLOCK);
                            }
                            else if((xp2 == Material.LAVA)||(xn2 == Material.LAVA)||(zn2 == Material.LAVA)||(zp2 == Material.LAVA)) {
                                p.getLocation().subtract(0,1,0).getBlock().setType(Material.MAGMA_BLOCK);
                            }
                        }
                    }
                }
            }
            catch(Exception error) {
                System.out.println(ChatColor.RED + "Uh oh error inside moving.");
            }
        }
    }
}
