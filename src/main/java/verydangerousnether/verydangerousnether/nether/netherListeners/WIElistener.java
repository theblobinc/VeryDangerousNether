package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.generators.netherAdditionsGenerator;
import verydangerousnether.verydangerousnether.nether.generators.netherGenerator;
import verydangerousnether.verydangerousnether.utils.utils;

public class WIElistener implements Listener {

    Plugin plugin = main.getPlugin(main.class);


    @EventHandler
    public void runNetherGenerator(WorldInitEvent event) {
        World w = event.getWorld();
        //System.out.println(utils.chat("&6checking if netherModule is enabled"));
        if(plugin.getConfig().getBoolean("nm-enabled")) {
            if(isNether(w)) {
                System.out.println(utils.chat("&6VDN enabled"));
                event.getWorld().getPopulators().add(new netherGenerator());
                event.getWorld().getPopulators().add(new netherAdditionsGenerator());
            }
        }
    }
    //Test for Listener & EventHandler
    /*
    @EventHandler
    public void onWalking(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        System.out.println("Well, it sure detects walking atleast..");
    }
     */

    public boolean isNether(World w) {
        if (w.getName().endsWith("_nether")) {
            return true;
        }
        return false;
    }
}
