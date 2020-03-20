package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class onPotionDrops implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void onPotionDrops(EntityDeathEvent event) {
        World wor = event.getEntity().getWorld();
        try {
            if(nether.worlds.contains(wor.getName())) {
                if (event.getEntity() instanceof PigZombie) {
                    if(plugin.getConfig().getBoolean("Haste Potion Drops ")) {
                        if (randint.nextInt(plugin.getConfig().getInt("Haste Potion Drop Chance ")+1) == 0) {
                            int choice = randint.nextInt(3);
                            if (choice == 0) {
                                int choice2 = randint.nextInt(3);
                                if(choice2 == 0) {
                                    ItemStack item = new ItemStack(Material.POTION);
                                    PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                    potionMeta.setColor(Color.YELLOW);
                                    potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 0), true);
                                    potionMeta.setDisplayName("�fPotion of Haste");
                                    item.setItemMeta(potionMeta);
                                    if (wor != null) {
                                        wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                    }
                                }
                                else if(choice2 == 1) {
                                    ItemStack item = new ItemStack(Material.POTION);
                                    PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                    potionMeta.setColor(Color.YELLOW);
                                    potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 1), true);
                                    potionMeta.setDisplayName("�fPotion of Haste");
                                    item.setItemMeta(potionMeta);
                                    if (wor != null) {
                                        wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                    }
                                }
                                else if(choice2 == 2) {
                                    if(randint.nextInt(2)==1) {
                                        ItemStack item = new ItemStack(Material.POTION);
                                        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                        potionMeta.setColor(Color.YELLOW);
                                        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 4800, 3), true);
                                        potionMeta.setDisplayName("�fPotion of Haste");
                                        item.setItemMeta(potionMeta);
                                        if (wor != null) {
                                            wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                        }
                                    }
                                }
                            } else if (choice == 1) {
                                ItemStack item = new ItemStack(Material.LINGERING_POTION);
                                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                potionMeta.setColor(Color.YELLOW);
                                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 0), true);
                                potionMeta.setDisplayName("�fLingering Potion of Haste");
                                item.setItemMeta(potionMeta);
                                if (wor != null) {
                                    wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                }
                            } else if (choice == 2) {
                                ItemStack item = new ItemStack(Material.SPLASH_POTION);
                                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                potionMeta.setColor(Color.YELLOW);
                                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 0), true);
                                potionMeta.setDisplayName("�fSplash Potion of Haste");
                                item.setItemMeta(potionMeta);
                                if (wor != null) {
                                    wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                }
                            }
                        }
                    }
                }else if (event.getEntity() instanceof WitherSkeleton) {
                    if(plugin.getConfig().getBoolean("Wither Potion Drops ")) {
                        if (randint.nextInt(plugin.getConfig().getInt("Wither Potion Drop Chance ")+1) == 0) {
                            int choice = randint.nextInt(4);
                            if (choice == 0) {
                                ItemStack item = new ItemStack(Material.LINGERING_POTION);
                                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                potionMeta.setColor(Color.BLACK);
                                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1800, 0), true);
                                potionMeta.setDisplayName("�fLingering Potion of Wither");
                                item.setItemMeta(potionMeta);
                                if (wor != null) {
                                    wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                }
                            } else if (choice == 1) {
                                ItemStack item = new ItemStack(Material.SPLASH_POTION);
                                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                potionMeta.setColor(Color.BLACK);
                                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1800, 0), true);
                                potionMeta.setDisplayName("�fSplash Potion of Wither");
                                item.setItemMeta(potionMeta);
                                if (wor != null) {
                                    wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                }
                            }
                            else if (choice == 2) {
                                ItemStack item = new ItemStack(Material.SPLASH_POTION);
                                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                potionMeta.setColor(Color.BLACK);
                                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1800, 1), true);
                                potionMeta.setDisplayName("�fSplash Potion of Wither");
                                item.setItemMeta(potionMeta);
                                if (wor != null) {
                                    wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                }
                            }
                            else if (choice == 3) {
                                ItemStack item = new ItemStack(Material.LINGERING_POTION);
                                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                                potionMeta.setColor(Color.BLACK);
                                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1800, 1), true);
                                potionMeta.setDisplayName("�fLingering Potion of Wither");
                                item.setItemMeta(potionMeta);
                                if (wor != null) {
                                    wor.dropItemNaturally(event.getEntity().getLocation(), item);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception ee) {
            System.out.println(ChatColor.RED + "Uh oh error inside onPotionDrops.");
        }
    }
}
