package verydangerousnether.verydangerousnether;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import verydangerousnether.verydangerousnether.nether.commands.VDN;
import verydangerousnether.verydangerousnether.nether.commands.VDNTabCompleter;
import verydangerousnether.verydangerousnether.nether.generators.NetherStructurePopulator;
import verydangerousnether.verydangerousnether.nether.mobs.SpawnHandler;
import verydangerousnether.verydangerousnether.nether.mobs.doMobSpawns;
import verydangerousnether.verydangerousnether.nether.nether;
import verydangerousnether.verydangerousnether.nether.netherListeners.*;
import verydangerousnether.verydangerousnether.utils.utils;

import java.util.Random;

import static verydangerousnether.verydangerousnether.nether.nether.worlds;

public class main extends JavaPlugin implements Listener {

    BukkitScheduler scheduler = null;

    //Declarations
    public static main plugin;
    boolean netherEnabled = false;

    @Override
    public void onEnable() {

        //Config creation
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //Check if veryDangerousNether is enabled
        netherEnabled = getConfig().getBoolean("nm-enabled");

        //Register general events
        Bukkit.getPluginManager().registerEvents(this, this);

        //Register events for nether mechanics
        if(netherEnabled) {
            Bukkit.getConsoleSender().sendMessage(utils.chat("&6VeryDangerousNether have been enabled"));
            Bukkit.getPluginManager().registerEvents(new nether(), this);
            Bukkit.getPluginManager().registerEvents(new WIElistener(), this);
            Bukkit.getPluginManager().registerEvents(new ambiendSounds(), this);
            Bukkit.getPluginManager().registerEvents(new doSpook(), this);
            Bukkit.getPluginManager().registerEvents(new lavaBucketFill(), this);
            Bukkit.getPluginManager().registerEvents(new lavaBucketEmpty(), this);
            Bukkit.getPluginManager().registerEvents(new onLavaHeld(), this);
            Bukkit.getPluginManager().registerEvents(new LavaSpout(), this);
            Bukkit.getPluginManager().registerEvents(new netherFire(), this);
            Bukkit.getPluginManager().registerEvents(new onBreakBlock(), this);
            Bukkit.getPluginManager().registerEvents(new onCoralFade(), this);
            Bukkit.getPluginManager().registerEvents(new onEntityHit(), this);
            Bukkit.getPluginManager().registerEvents(new onGhastLaunch(), this);
            Bukkit.getPluginManager().registerEvents(new onLavaHeld(), this);
            Bukkit.getPluginManager().registerEvents(new onMobName(), this);
            Bukkit.getPluginManager().registerEvents(new onPotionDrops(), this);
            Bukkit.getPluginManager().registerEvents(new onTarget(), this);
            Bukkit.getPluginManager().registerEvents(new NetherStructurePopulator(), this);
            Bukkit.getPluginManager().registerEvents(new soulsandSlowness(), this);
            Bukkit.getPluginManager().registerEvents(new Shoot(), this);
            if (getConfig().getBoolean("enable_custom_mobs")) {
                Bukkit.getPluginManager().registerEvents(new SpawnHandler(), this);
            }
            //Bukkit.getPluginManager().registerEvents(new doMobSpawns(), this);
            if(getConfig().getBoolean("encrypted_chat")) {
                Bukkit.getPluginManager().registerEvents(new ChatEditing(), this);
            }
        }

        //Register command
        this.getCommand("vdn").setExecutor(new VDN());
        this.getCommand("vdn").setTabCompleter(new VDNTabCompleter());

        nether n = new nether();
        ambiendSounds a = new ambiendSounds();
        LavaSpout l = new LavaSpout();
        Random randor = new Random();
        boolean ambients = getConfig().getBoolean("enable_ambient_sounds");
        boolean caveents = getConfig().getBoolean("enable_custom_mobs");

        scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if(caveents==true||getConfig().getBoolean("enable_lava_burns")==true) {
                    n.betterEffectLooper();
                }
            }
        }, 0L, /* 600 */((long) 3));
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                n.fireLoop();
            }
        }, 0L, /* 600 */((long) 1));
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                try {
                    if(ambients == true) {
                        for(String namew : worlds) {
                            World wor = Bukkit.getWorld(namew);
                            if (wor != null) {
                                for (Player p : wor.getPlayers()) {
                                    a.doSound(p);
                                }
                            }
                        }
                    }
                }
                catch(Exception e) {
                }
            }
        }, 0L, /* 600 */10L);

    }



    @Override
    public void onDisable() {

    }
}
