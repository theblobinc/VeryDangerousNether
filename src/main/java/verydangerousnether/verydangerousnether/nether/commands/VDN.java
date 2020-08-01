package verydangerousnether.verydangerousnether.nether.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.Mob;
import verydangerousnether.verydangerousnether.nether.mobs.defaults.*;

import java.util.Collection;
import java.util.Iterator;

public class VDN implements CommandExecutor {

    Plugin plugin = main.getPlugin(main.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length==0) {
            sender.sendMessage(ChatColor.YELLOW + "VeryDangerousNether Info");
            sender.sendMessage(ChatColor.YELLOW + "/vdc spawn to spawn an mob");
            sender.sendMessage(ChatColor.YELLOW + "/vdc reload to reload the plugin");
            sender.sendMessage(ChatColor.YELLOW + "...Thats it");
            return true;
        } else if (args[0].equalsIgnoreCase("spawn") && args[1].isEmpty()) {
            sender.sendMessage(ChatColor.YELLOW + "Please enter a valid mob-name!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("spawn") && !args[1].isEmpty()) {
            Location loc = ((Player) sender).getLocation();
            String mob = args[1];
            if (mob.equalsIgnoreCase("alphapigman")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new AlphaPigman(z);
            } else if (mob.equalsIgnoreCase("fireball")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Fireball(z);
            } else if (mob.equalsIgnoreCase("inferno")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Inferno(z);
            } else if (mob.equalsIgnoreCase("molten")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Molten(z);
            } else if (mob.equalsIgnoreCase("necromancer")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Necromancer(z);
            } else if (mob.equalsIgnoreCase("oldshadow")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new OldShadow(z);
            } else if (mob.equalsIgnoreCase("sadness")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Sadness(z);
            } else if (mob.equalsIgnoreCase("sherogath")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Sherogath(z);
            }
            return true;
        } else if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.YELLOW + "VeryDangerousNether Help");
            sender.sendMessage(ChatColor.YELLOW + "/vdc spawn to spawn an mob");
            sender.sendMessage(ChatColor.YELLOW + "/vdc reload to reload the plugin");
            return true;
        } else if (args[0].equalsIgnoreCase("reload")) {
            plugin.getPluginLoader().disablePlugin(plugin);
            plugin.getPluginLoader().enablePlugin(plugin);
            return true;
        } else if (args[0].equalsIgnoreCase("killall")) {
            if (sender.hasPermission("verydangerousnether.killall")) {
                Collection c = sender.getServer().getPlayer(sender.toString()).getWorld().getNearbyEntities(sender.getServer().getPlayer(sender.toString()).getLocation(), 100, 100, 100);
                Iterator i = c.iterator();
                while (i.hasNext()) {
                    Entity e = (Entity) i.next();
                    if (!e.hasMetadata("vdn")) {
                        i.remove();
                    }
                }
                c.removeAll(c);
            }
            return true;
        }

        return false;
    }
}
