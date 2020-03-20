package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class onBreakBlock implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void onBreakB(BlockBreakEvent dr) {
        Player p = dr.getPlayer();
        if(!nether.worlds.contains(p.getWorld().getName())) {
            return;
        }
        World wor = p.getWorld();
        if(plugin.getConfig().getBoolean("netherrack_fires")==true) {
            //System.out.println("netherrack fires activated");
            try {
                if((randint.nextInt(100)) < (plugin.getConfig().getInt("netherrack_fire_chance"))) {
                    if(dr.getBlock().getType()== Material.NETHERRACK) {
                        Bukkit.getScheduler().runTaskLater(plugin, () -> dr.getBlock().setType(Material.FIRE), randint.nextInt(5)+5);
                    }
                }
            } catch(Exception e) {
                System.out.println(ChatColor.RED + "Uh oh error inside cave-in.");
            }
        }
    }
}
