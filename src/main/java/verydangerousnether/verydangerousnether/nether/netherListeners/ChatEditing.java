package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.utils.utils;

import java.util.Iterator;
import java.util.Set;

import static org.bukkit.Bukkit.getPlayer;

public class ChatEditing implements Listener {

    Plugin plugin = main.getPlugin(main.class);

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player sender = e.getPlayer();
        if (isInNether(sender)) {
            Set r = e.getRecipients();
            Iterator i = r.iterator();
            while (i.hasNext()) {
                Player p = getPlayer(i.next().toString());
                if (p == null) {
                    return;
                }
                //System.out.println(p);
                if (!isInNether(p)) {
                    r.remove(i.next());
                    p.sendMessage(sender.getDisplayName() + utils.chat(": $kadfgras"));
                }
            }
        }
    }

    public boolean isInNether(Player p) {
        Biome b = p.getLocation().getBlock().getBiome();
        if (b.equals(Biome.BASALT_DELTAS) || b.equals(Biome.BADLANDS) || b.equals(Biome.CRIMSON_FOREST) || b.equals(Biome.SOUL_SAND_VALLEY) || b.equals(Biome.NETHER_WASTES)) {
            return true;
        }

        return false;
    }
}
