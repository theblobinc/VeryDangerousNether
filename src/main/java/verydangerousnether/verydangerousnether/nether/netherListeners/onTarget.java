package verydangerousnether.verydangerousnether.nether.netherListeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.plugin.Plugin;
import verydangerousnether.verydangerousnether.main;
import verydangerousnether.verydangerousnether.nether.nether;

import static verydangerousnether.verydangerousnether.utils.exists.exists;

public class onTarget implements Listener {

    Plugin plugin = main.getPlugin(main.class);

    public boolean hasName(String n, Entity e) {
        if(exists(e)) {
            if(e.hasMetadata(n)) {
                return true;
            }
            if(e.getCustomName() != null) {
                String name = ChatColor.stripColor(e.getCustomName());
                if((!name.equals("")) && (!name.equals(" "))) {
                    if(name.equals(n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {
        //System.out.println("onTarget has been called");
        if(event.isCancelled() || (!exists(event.getTarget()))) {
            //System.out.println("Event it either cancelled or target doesnt exist");
            return;
        }
        if(nether.caveEnts==true) {
            if(event.getEntity() instanceof Monster) {
                //System.out.println("entity is instance of monster");
                Monster e = (Monster) event.getEntity();
                if(e.getCustomName()!=null || hasName("nethermob", e)) {
                    //System.out.println("getcustomname is not null and mob hasName nethernom");
                    if(hasName(plugin.getConfig().getString("inferno"), e)) {
                        nether.effectEnts.add(event.getEntity());
                    }
                    else if(hasName(plugin.getConfig().getString("old_shadow"), e)) {
                        nether.effectEnts.add(event.getEntity());
                    }
                    else if(hasName(plugin.getConfig().getString("fireball"), e)) {
                        nether.effectEnts.add(event.getEntity());
                    }
                    else if(hasName(plugin.getConfig().getString("molten"), e)) {
                        nether.effectEnts.add(event.getEntity());
                    }
                    else if(hasName(plugin.getConfig().getString("sadness"), e)) {
                        nether.effectEnts.add(event.getEntity());
                    }
                    else if(hasName(plugin.getConfig().getString("sherogath"), e)) {
                        nether.effectEnts.add(event.getEntity());
                    }
                }
            }
        }
        if(plugin.getConfig().getBoolean("enable_mean_ghasts ")==true) {
            if(event.getEntity() instanceof Ghast) {
                nether.effectEnts.add(event.getEntity());
            }
        }
    }
}
