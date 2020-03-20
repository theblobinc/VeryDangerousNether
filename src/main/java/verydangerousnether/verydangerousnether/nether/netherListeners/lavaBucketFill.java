package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class lavaBucketFill implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void onFill(PlayerBucketFillEvent e) {
        if(!e.isCancelled()) {
            if(plugin.getConfig().getBoolean("enable_lava_placement")==true) {
                Player p = e.getPlayer();
                try {
                    if(nether.worlds.contains(p.getWorld().getName())) {
                        if(e.getBlockClicked()!=null) {
                            if(e.getBlockClicked().getType()== Material.LAVA) {
                                Location loc = e.getBlockClicked().getLocation();
                                int radius = 2;
                                int cx = loc.getBlockX();
                                int cy = loc.getBlockY();
                                int cz = loc.getBlockZ();
                                for (int x = cx - radius; x <= cx + radius; x++) {
                                    for (int z = cz - radius; z <= cz + radius; z++) {
                                        for (int y = (cy - radius); y < (cy + radius); y++) {
                                            double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));

                                            if (dist < radius * radius) {
                                                Location l2 = new Location(loc.getWorld(), x, y, z);
                                                if(l2.getBlock().getType()== Material.LAVA) {
                                                    l2.getBlock().setType(Material.AIR);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                catch(Exception ee) {
                    System.out.println(ChatColor.RED + "Uh oh error inside onFill.");
                }
            }
        }
    }
}
