package verydangerousnether.verydangerousnether.nether.netherListeners;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Arrays;
import java.util.Random;

public class doSpook implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void doSpook(EntityDeathEvent event) {
        if(event.getEntity() instanceof PigZombie) {
            try {
                if(plugin.getConfig().getBoolean("Enable Alpha Pigman Sword Drop ")==true&& nether.worlds.contains(event.getEntity().getWorld().getName())) {
                    boolean isMagma = false;
                    if((event.getEntity()).hasMetadata(plugin.getConfig().getString("Alpha Pigman = "))) {
                        isMagma = true;
                    }
                    else if(event.getEntity().getCustomName() != null) {
                        if (event.getEntity().getCustomName().equals(plugin.getConfig().getString("Alpha Pigman = "))){
                            isMagma = true;
                        }
                    }
                    if(isMagma == true) {
                        if (randint.nextInt(plugin.getConfig().getInt("Alpha Pigman Sword Drop Chance ")) == 0) {
                            ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
                            ItemMeta itemmeta = item.getItemMeta();
                            if(randint.nextBoolean()==true) {
                                itemmeta.setLore(Arrays.asList(ChatColor.GRAY + "Blinding I"));
                            }
                            else {
                                itemmeta.setLore(Arrays.asList(ChatColor.GRAY + "Blinding II"));
                            }
                            item.setItemMeta(itemmeta);
                            ((LivingEntity) event.getEntity()).getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    item);
                        }
                        return;
                    }
                }
            }
            catch(Exception ee) {
                System.out.println(ChatColor.RED + "Uh oh error inside doSpook.");
            }
        }
    }
}
