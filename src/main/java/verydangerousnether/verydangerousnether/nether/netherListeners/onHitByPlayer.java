package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class onHitByPlayer implements Listener {

    @EventHandler
    public void onHitByPlayer(EntityDamageByEntityEvent event) {
        if(!event.isCancelled()) {
            try {
                if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
                    ItemStack it = ((Player) event.getDamager()).getInventory().getItemInMainHand();
                    if(it != null) {
                        if(it.hasItemMeta()) {
                            if(it.getItemMeta().hasLore()) {
                                LivingEntity e = ((LivingEntity) event.getEntity());
                                List<String> lore = it.getItemMeta().getLore();
                                if(lore.contains(ChatColor.GRAY + "Blinding I")) {
                                    e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 200));
                                    return;
                                }
                                else if(lore.contains(ChatColor.GRAY + "Blinding II")) {
                                    e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 200));
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            catch(Exception ee) {
                System.out.println(ChatColor.RED + "Uh oh error inside onHitByPlayer");
            }
        }
    }
}
