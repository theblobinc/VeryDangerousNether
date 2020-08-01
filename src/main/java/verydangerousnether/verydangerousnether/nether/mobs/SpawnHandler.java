package verydangerousnether.verydangerousnether.nether.mobs;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.mobs.defaults.MobManager;

import java.util.List;

public class SpawnHandler implements Listener {

    Plugin plugin = main.getPlugin(main.class);

    List<String> worlds = plugin.getConfig().getStringList("enabled_worlds");

    @EventHandler
    public void spawnMobs(CreatureSpawnEvent event) {
        Entity e = event.getEntity();
        Biome b = e.getLocation().getBlock().getBiome();

        MobManager m;

        for (int i = 0; i < worlds.size(); i++) {
            if (e.getWorld().getName().equalsIgnoreCase(worlds.get(i))) {
                if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL) && isSurface(e.getLocation().subtract(0,-1,0).getBlock().getType())) {
                    if (!e.hasMetadata("vdn")) {
                        if (b.equals(Biome.NETHER_WASTES)) {
                            m = new MobManager(e, "wastes");
                        } else if (b.equals(Biome.SOUL_SAND_VALLEY)) {
                            m = new MobManager(e, "valley");
                        } else if (b.equals(Biome.CRIMSON_FOREST)) {
                            m = new MobManager(e, "crimson");
                        } else if (b.equals(Biome.WARPED_FOREST)) {
                            m = new MobManager(e, "warped");
                        } else if (b.equals(Biome.BASALT_DELTAS)) {
                            m = new MobManager(e, "deltas");
                        }
                    }
                }
             }
        }
    }

    public boolean isSurface(Material m) {
        if (m.equals(Material.AIR)) {
            return true;
        }
        return false;
    }
}
