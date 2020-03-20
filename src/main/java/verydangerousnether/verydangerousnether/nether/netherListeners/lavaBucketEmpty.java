package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class lavaBucketEmpty implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void onPlace(PlayerBucketEmptyEvent e) {
        if(!e.isCancelled()) {
            if(plugin.getConfig().getBoolean("enable_lava_placement")==true) {
                System.out.println("Lava place event triggerd");
                Player p = e.getPlayer();
                try {
                    if(nether.worlds.contains(p.getWorld().getName())) {
                        if(e.getBucket()!=null) {
                            if(e.getBucket()== Material.LAVA_BUCKET) {
                                Location loc = e.getBlockClicked().getRelative(e.getBlockFace()).getLocation();
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
                                                if(l2.getBlock().getType()== Material.NETHERRACK) {
                                                    l2.getBlock().setType(Material.LAVA);
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
                    System.out.println(ChatColor.RED + "Uh oh error inside onPlace.");
                }
            }
        }
    }
}
