package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;

import java.util.Random;

public class LavaSpout implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    @EventHandler
    public void doLavaSpout(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if(randint.nextInt(100) < plugin.getConfig().getInt("lava_spout_chance")) {
            for (int direction = 0; direction < 4; direction++) {
                Location l = p.getLocation();
                int ammount = randint.nextInt(3) + 1;
                Location l3 = l.clone();
                boolean banana = false;
                Location l2 = null;
                for (int i2 = 10; i2 > 0; i2--) {
                    if (l3.getBlock().getType() == Material.LAVA) {
                        banana = true;
                        l2 = l3.clone();
                    }
                    if (direction == 0) {
                        l3.add(ammount, 0, 0);
                    } else if (direction == 1) {
                        l3.subtract(ammount, 0, 0);
                    } else if (direction == 2) {
                        l3.add(0, 0, ammount);
                    } else if (direction == 3) {
                        l3.subtract(0, 0, ammount);
                    }
                    if (i2 % 10 == 0) {
                        l3.subtract(0, 1, 0);
                    }
                }
                if (l2 != null) {
                    int height = randint.nextInt(20) + 5;
                    for (int count = 0; count < height; count++) {
                        l2.getWorld().spawnParticle(Particle.LAVA, l2, 2);
                        if (count > height / 2) {
                            l2.getWorld().spawnParticle(Particle.LAVA, l2, 2);
                        }
                        l2.add(0, 1, 0);
                    }
                }
                if (banana == true) {
                    break;
                }
            }
        }
    }
}
