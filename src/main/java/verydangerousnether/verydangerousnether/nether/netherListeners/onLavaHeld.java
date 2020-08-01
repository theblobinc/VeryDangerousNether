package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

import static verydangerousnether.verydangerousnether.nether.nether.inHell;

public class onLavaHeld implements Listener {

    @EventHandler
    public void onLavaHeld(PlayerItemHeldEvent e) {

        Plugin plugin = main.getPlugin(main.class);
        Random randint = new Random();
        try {
            if(plugin.getConfig().getBoolean("enable_lava_burns")==true) {
                Player p = e.getPlayer();
                if(nether.worlds.contains(p.getWorld().getName())) {
                    if(p.getInventory().getItem(e.getNewSlot())!=null) {
                        Material m = p.getInventory().getItem(e.getNewSlot()).getType();
                        if(m == Material.LAVA_BUCKET) {
                            if(inHell(p.getLocation().getBlock())) {
                                if(randint.nextInt(10)==0) {
                                    p.damage(1);
                                    p.setFireTicks(20);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception ee) {
            System.out.println(ChatColor.RED + "Uh oh error inside onLavaHeld.");
        }
    }
}
