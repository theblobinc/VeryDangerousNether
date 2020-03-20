package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import verydangerousnether.verydangerousnether.nether.nether;

import static verydangerousnether.verydangerousnether.utils.removeItemNaturally.removeItemNaturally;

public class onMobName implements Listener {

    @EventHandler
    public void onMobName(PlayerInteractEntityEvent event) {
        if(!nether.worlds.contains(event.getRightClicked().getWorld().getName())) {
            return;
        }
        try {
            World wor = event.getRightClicked().getWorld();
            if(!(event.getRightClicked() instanceof Player)) {
                ItemStack i = event.getPlayer().getInventory().getItemInMainHand();
                if(i.getType()== Material.NAME_TAG) {
                    if(i.hasItemMeta()) {
                        if(i.getItemMeta().hasDisplayName()) {
                            String s = i.getItemMeta().getDisplayName();
                            if(nether.mobNames.contains(s)) {
                                removeItemNaturally(event.getPlayer());
                                if(event.getRightClicked() instanceof LivingEntity && (!(event.getRightClicked() instanceof Player))) {
                                    ((LivingEntity) event.getRightClicked()).setCustomName("");
                                    event.setCancelled(true);
                                }
                                else {
                                    event.getRightClicked().remove();
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println(ChatColor.RED + "Uh oh error inside onmobname.");
        }
    }
}
