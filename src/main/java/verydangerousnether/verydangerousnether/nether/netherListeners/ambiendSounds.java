package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.Random;

public class ambiendSounds implements Listener {

    Plugin plugin = main.getPlugin(main.class);

    Random randint = new Random();

    public void onWalke(PlayerMoveEvent event) {
        if (plugin.getConfig().getBoolean("Enable Ambient Sounds ") == true) {
            Player p = event.getPlayer();
            if (nether.worlds.contains(event.getPlayer().getWorld().getName())) {
                if (!(((int) event.getFrom().getX() == (int) event.getTo().getX())
                        && ((int) event.getFrom().getY() == (int) event.getTo().getY())
                        && ((int) event.getFrom().getZ() == (int) event.getTo().getZ()))) {
                    doFootSteps(event.getPlayer());
                }
            }
        }
    }

    public void doFootSteps(Player p) {
        try {
            int var = 2;
            if ((!p.isSneaking())) {
                Block b = p.getLocation().subtract(0, 1, 0).getBlock();
                Material type = b.getType();
                if (type == Material.SOUL_SAND && randint.nextInt(3) == 1) {
                    if (p.isSprinting()) {
                        if (randint.nextInt(2) == 1) {
                            if (randint.nextBoolean() == true) {
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_SCREAM, (float) 1, 0);
                            } else {
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_SCREAM, (float) 1, 2);
                            }
                        }
                    } else if (randint.nextInt(3) == 1) {
                        if (randint.nextBoolean() == true) {
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_AMBIENT, (float) 0.07, 0);
                        } else {
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_AMBIENT, (float) 0.07, 2);
                        }
                    }
                    return;
                } else if ((type == Material.NETHERRACK || type == Material.MOSSY_COBBLESTONE) && randint.nextInt(2) == 1) {
                    if (!plugin.getConfig().getString("netherrack_Step_sound").equals("NONE")) {
                        p.getWorld().playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("netherrack_step_sound")), (float) 0.08, (float) 1.3);
                        return;
                    }
                }
            }
        } catch (Exception ee) {
            System.out.println(ChatColor.RED + "Uh oh error inside doFootSteps.");
        }
    }

    public void doSound(Player p) {
        if (plugin.getConfig().getBoolean("enable_Ambient_sounds")==false) {
            return;
        }
        if (nether.inHell(p.getLocation().getBlock())) {
            Location l = p.getLocation();
            for(int i = 0; i < 10; i++) {
                Material mm = l.add(0, 1, 0).getBlock().getType();
                boolean air = l.getBlock().isPassable();
                if(air == false){
                    if(mm== Material.NETHERRACK||mm== Material.MAGMA_BLOCK||mm== Material.SOUL_SAND) {
                    }
                    else {
                        return;
                    }
                }
            }
            if (randint.nextInt(155) == 1) {
                int random = randint.nextInt(2);
                boolean enderman = plugin.getConfig().getBoolean("rnderman_growl_replace_enderdragon_growl");
                if(enderman == false) {
                    try {
                        if (random == 1) {
                            p.playSound(p.getLocation().add(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                    Sound.valueOf("ENTITY_ENDERDRAGON_GROWL"), (float) getRandLowVolume(), randint.nextInt(2));
                        } else {
                            p.playSound(p.getLocation().subtract(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                    Sound.valueOf("ENTITY_ENDERDRAGON_GROWL"), (float) getRandLowVolume(), randint.nextInt(2));
                        }
                    }
                    catch(Exception e) {
                        try {
                            if (random == 1) {
                                p.playSound(p.getLocation().add(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                        Sound.valueOf("ENTITY_ENDER_DRAGON_GROWL"), (float) getRandLowVolume(), randint.nextInt(2));
                            } else {
                                p.playSound(p.getLocation().subtract(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                        Sound.valueOf("ENTITY_ENDER_DRAGON_GROWL"), (float) getRandLowVolume(), randint.nextInt(2));
                            }
                        }
                        catch(Exception e2) {
                            System.out.println(ChatColor.RED + "Uh oh error inside 962.");
                        }
                    }
                }
                else {
                    try {
                        if (random == 1) {
                            p.playSound(p.getLocation().add(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                    Sound.valueOf("ENTITY_ENDERMAN_STARE"), (float) getRandLowVolume(), randint.nextInt(2));
                        } else {
                            p.playSound(p.getLocation().subtract(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                    Sound.valueOf("ENTITY_ENDERMAN_STARE"), (float) getRandLowVolume(), randint.nextInt(2));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(ChatColor.RED + "Uh oh error inside 977.");
                    }
                }
            }
            if(p.getLocation().getY()<70) {
                if (randint.nextInt(10) == 1) {
                    if (randint.nextInt(2) == 1) {
                        p.playSound(p.getLocation().subtract(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                Sound.BLOCK_FIRE_AMBIENT, (float) (getRandLowVolume() + .6), randint.nextInt(2));
                    } else {
                        p.playSound(p.getLocation().add(8 + (randint.nextInt(2) + 1), 4, 8 + (randint.nextInt(2) + 1)),
                                Sound.BLOCK_FIRE_AMBIENT, (float) (getRandLowVolume() + .6), randint.nextInt(2));
                    }
                }
                if (randint.nextInt(18) == 1) {
                    if (randint.nextInt(2) == 1) {
                        p.playSound(p.getLocation().subtract(8 + (randint.nextInt(2) + 1), 6, 8 + (randint.nextInt(2) + 1)),
                                Sound.BLOCK_LAVA_AMBIENT, (float) (getRandLowVolume() + .4), randint.nextInt(2));
                    } else {
                        p.playSound(p.getLocation().add(8 + (randint.nextInt(2) + 1), 4, 8 + (randint.nextInt(2) + 1)),
                                Sound.BLOCK_LAVA_AMBIENT, (float) (getRandLowVolume() + .4), randint.nextInt(2));
                    }
                }
                if (randint.nextInt(24) == 1) {
                    int time1 = randint.nextInt(20) + 30;
                    int time2 = randint.nextInt(20) + 30 + time1;
                    int time3 = randint.nextInt(20) + 30 + time2;
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(
                                    p.getLocation().add(5 + (randint.nextInt(2) + 1), 1, 5 + (randint.nextInt(2) + 1)),
                                    Sound.BLOCK_FURNACE_FIRE_CRACKLE, (float) (getRandLowVolume() + .8), randint.nextInt(2)),
                            time1);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(
                                    p.getLocation().add(5 + (randint.nextInt(2) + 1), 1, 5 + (randint.nextInt(2) + 1)),
                                    Sound.BLOCK_FURNACE_FIRE_CRACKLE, (float) (getRandLowVolume() + .8), randint.nextInt(2)),
                            time2);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(
                                    p.getLocation().add(5 + (randint.nextInt(2) + 1), 1, 5 + (randint.nextInt(2) + 1)),
                                    Sound.BLOCK_FURNACE_FIRE_CRACKLE, (float) (getRandLowVolume() + .8), randint.nextInt(2)),
                            time3);

                }
                if (randint.nextInt(15) == 1) {
                    //Sound.valueOf("ENTITY_IRON_GOLEM_HURT")
                    try {
                        Sound s = Sound.valueOf("ENTITY_IRONGOLEM_HURT");
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRONGOLEM_HURT"), (float) 0.01, 0), 3);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRONGOLEM_HURT"), (float) 0.01, 0), 9);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRONGOLEM_HURT"), (float) 0.01, 0), 24);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRONGOLEM_HURT"), (float) 0.001, 0), 38);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRONGOLEM_HURT"), (float) 0.01, 0), 50);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRONGOLEM_HURT"), (float) 0.01, 0), 67);
                    }
                    catch(Exception e) {
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRON_GOLEM_HURT"), (float) 0.01, 0), 3);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRON_GOLEM_HURT"), (float) 0.01, 0), 9);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRON_GOLEM_HURT"), (float) 0.01, 0), 24);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRON_GOLEM_HURT"), (float) 0.001, 0), 38);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRON_GOLEM_HURT"), (float) 0.01, 0), 50);
                        Bukkit.getScheduler().runTaskLater(plugin,
                                () -> p.playSound(p.getLocation(), Sound.valueOf("ENTITY_IRON_GOLEM_HURT"), (float) 0.01, 0), 67);
                    }
                }
                if (randint.nextInt(18) == 1) {
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 3);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 15);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 25);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0),
                            35);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 45);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 55);
                }
                if (randint.nextInt(34) == 1) {
                    int time1 = randint.nextInt(20) + 30;
                    int time2 = randint.nextInt(20) + 30 + time1;
                    int time3 = randint.nextInt(20) + 30 + time2;
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(
                                    p.getLocation().add(7 + (randint.nextInt(2) + 1), 1, 7 + (randint.nextInt(2) + 1)),
                                    Sound.ENTITY_GUARDIAN_FLOP, (float) (getRandLowVolume()), 0),
                            time1);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(
                                    p.getLocation().add(7 + (randint.nextInt(2) + 1), 1, 7 + (randint.nextInt(2) + 1)),
                                    Sound.ENTITY_GUARDIAN_FLOP, (float) (getRandLowVolume()), 0),
                            time2);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(
                                    p.getLocation().add(7 + (randint.nextInt(2) + 1), 1, 7 + (randint.nextInt(2) + 1)),
                                    Sound.ENTITY_GUARDIAN_FLOP, (float) (getRandLowVolume()), 0),
                            time3);
                }
                if (randint.nextInt(54) == 1) {
                    p.playSound(p.getLocation().add(1, 1, 1), Sound.ENTITY_HORSE_BREATHE, (float) (.1), 0);
                }
            }
        }
    }

    public double getRandLowVolume() {
        int chose = randint.nextInt(4);
        if (chose == 0) {
            return .1;
        } else if (chose == 1) {
            return .2;
        } else if (chose == 2) {
            return .3;
        } else if (chose == 3) {
            return .4;
        } else {
            return .1;
        }
    }
}