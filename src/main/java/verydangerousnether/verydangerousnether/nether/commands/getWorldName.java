package verydangerousnether.verydangerousnether.nether.commands;

import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class getWorldName implements CommandExecutor {

    public ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("getworldname")) {
            if (sender instanceof Player) {
                ((Player) sender).getWorld().generateTree(((Player) sender).getLocation(), TreeType.RED_MUSHROOM);
                console.sendMessage(ChatColor.GREEN + "World Name = " + ChatColor.RESET + " " + ((Player) sender).getWorld().getName());
                for(Entity e : ((Player) sender).getNearbyEntities(10, 10, 10)) {
                    if(e instanceof ArmorStand) {
                        e.remove();
                    }
                }
                return true;
            }
        }
        return true;
    }
}
