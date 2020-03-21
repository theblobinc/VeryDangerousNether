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
        Player player = (Player)sender;
        if(command.getName().equalsIgnoreCase("getworldname")) {
            if (sender instanceof Player && player.hasPermission("verydangerousnether.getworldname")) {
                (player).getWorld().generateTree((player).getLocation(), TreeType.RED_MUSHROOM);
                console.sendMessage(ChatColor.GREEN + "World Name = " + ChatColor.RESET + " " + (player.getWorld().getName()));
                return true;
            }
        } else {
            player.sendMessage(ChatColor.GOLD + "[VeryDangerousNether]" + ChatColor.DARK_RED + " You don't have the required permission to do this!");
        }
        return true;
    }
}
