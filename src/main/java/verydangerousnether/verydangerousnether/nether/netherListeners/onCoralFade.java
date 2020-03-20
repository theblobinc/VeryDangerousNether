package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import verydangerousnether.verydangerousnether.nether.nether;

public class onCoralFade implements Listener {
    @EventHandler
    public void onCoralFade(BlockFadeEvent e) {
        if (nether.inHell(e.getBlock())) {
            if(e.getBlock().getType().name().toLowerCase().contains("coral")) {
                e.setCancelled(true);
            }
        }
    }
}
