package verydangerousnether.verydangerousnether;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import verydangerousnether.verydangerousnether.nether.mobs.doMobSpawns;
import verydangerousnether.verydangerousnether.nether.nether;
import verydangerousnether.verydangerousnether.nether.netherListeners.*;
import verydangerousnether.verydangerousnether.utils.utils;

public class main extends JavaPlugin implements Listener {

    //Declarations
    public static main plugin;
    boolean netherEnabled = false;

    @Override
    public void onEnable() {

        //Config creation
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //Check if veryDangerousNether is enabled


        //Register general events
        Bukkit.getPluginManager().registerEvents(this, this);

        //Register events for nether mechanics
        if(netherEnabled) {
            Bukkit.getConsoleSender().sendMessage(utils.chat("&6VeryDangerousCraft have been enabled"));
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
            Bukkit.getPluginManager().registerEvents(new soulsandSlowness(), this);
            Bukkit.getPluginManager().registerEvents(new doMobSpawns(), this);
        }
    }

    @Override
    public void onDisable() {

    }
}
