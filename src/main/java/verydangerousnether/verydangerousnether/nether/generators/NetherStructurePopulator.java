package verydangerousnether.verydangerousnether.nether.generators;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

public class NetherStructurePopulator implements Listener {

    Plugin plugin = main.getPlugin(main.class);

    @EventHandler
    public void deploySchem(BlockBreakEvent e) {
        Block b = e.getBlock();
        Material material = b.getType();
        Player player = e.getPlayer();
        World w = player.getWorld();
        int x = b.getX();
        int y = b.getY();
        int z = b.getZ();

        if (material.equals(Material.EMERALD_BLOCK)) {
            if (player.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                Material below1 = w.getBlockAt(x, y - 1, z).getType();
                Material below2 = w.getBlockAt(x, y - 2, z).getType();
                Material below3 = w.getBlockAt(x, y - 3, z).getType();
                if (below1.equals(Material.DIAMOND_BLOCK) && below2.equals(Material.EMERALD_BLOCK) && below3.equals(Material.DIAMOND_BLOCK)) {
                    Clipboard c = getSchematics(w);
                    Location l = getLocation(player);
                    pasteSchematics(c, w, l);
                }
            }
        }
    }

    private Location getLocation(Player p) {
        Location l = null;
        World w = p.getWorld();

        int x = p.getLocation().getBlockX();
        int z = p.getLocation().getBlockZ();
        int newZ = z + 150;

        int y = getAirInLine(x, newZ, w);

        while (y == 0) {
            newZ += 10;
            y = getAirInLine(x, newZ, w);
        }

        Block b = w.getBlockAt(x, y, newZ);

        l = b.getLocation();

        return l;
    }

    private Clipboard getSchematics(World world) {

        World w = world;

        WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");

        File schematic = null;

        Random random = new Random();

        int type = random.nextInt(2);

        if (type == 0) {
            int r1 = random.nextInt(8);
            if (r1 == 0) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom1.schem");
            } else if (r1 == 1) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom2.schem");
            } else if (r1 == 2) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom3.schem");
            } else if (r1 == 3) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom4.schem");
            } else if (r1 == 4) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom5.schem");
            } else if (r1 == 5) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom6.schem");
            } else if (r1 == 6) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom7.schem");
            } else if (r1 == 7) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom8.schem");
            } else if (r1 == 8) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/mushroom9.schem");
            }
        } else if (type == 1) {
            int r2 = random.nextInt(2);
            if (r2 == 0) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/town1.schem");
            } else if (r2 == 1) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/town2.schem");
            } else if (r2 == 2) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/town3.schem");
            }
        } else if (type == 2) {
            int r3 = random.nextInt(1);
            if (r3 == 0) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/boat1.schem");
            } else if (r3 == 1) {
                schematic = new File(plugin.getDataFolder() + File.separator + "/schematics/boat2.schem");
            }
        }

        ClipboardFormat format = ClipboardFormats.findByFile(schematic);

        Clipboard c = null;

        try(ClipboardReader reader = format.getReader(new FileInputStream(schematic))) {
            Clipboard clipboard = reader.read();
            c = clipboard;
        } catch (Exception e) {
            System.out.println("Problem reading WE/Schematic");
        }

        //System.out.println("Schem file returned");

        return c;

    }

    private void pasteSchematics(Clipboard clipboard, World world, Location l) {

        com.sk89q.worldedit.world.World w = BukkitAdapter.adapt(world);

        int x = l.getBlockX();
        int y = l.getBlockY();
        int z = l.getBlockZ();

        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(w, -1)) {
            Operation operation = new ClipboardHolder(clipboard).createPaste(editSession).to(BlockVector3.at(x, y, z)).ignoreAirBlocks(false).build();
            Operations.complete(operation);
        } catch (Exception e) {
            System.out.println("Problem pasting WE/Schematic");
            e.printStackTrace();

        }
        //System.out.println("Schem pasted");
    }

    private int getAirInLine(int x, int z, World w) {
        for (int i = 0; i < 100; i++) {
            if (w.getBlockAt(x, i, z).getType().equals(Material.AIR)) {
                if (!w.getBlockAt(x, i-1, z).equals(Material.AIR)) {
                    return i;
                }
            }
        }
        return 0;
    }
}
