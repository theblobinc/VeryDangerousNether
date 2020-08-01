package verydangerousnether.verydangerousnether.nether.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class VDNTabCompleter implements TabCompleter {

    List<String> arguments = new ArrayList<>();
    List<String> mobs = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (arguments.isEmpty()) {
            arguments.add("spawn");
            arguments.add("reload");
        }

        if (args[0].toLowerCase().equalsIgnoreCase("spawn")) {
            mobs.add("AlphaPigman");
            mobs.add("Fireball");
            mobs.add("Inferno");
            mobs.add("Molten");
            mobs.add("Necromancer");
            mobs.add("OldShadow");
            mobs.add("Sadness");
            mobs.add("Sherogath");
            return mobs;
        }

        List<String> result = new ArrayList<String>();

        if(args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }

            return result;
        }

        if(args.length == 2) {
            for (String a : mobs) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }

        return null;
    }
}
