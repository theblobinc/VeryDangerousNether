package verydangerousnether.verydangerousnether.nether;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import verydangerousnether.verydangerousnether.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static verydangerousnether.verydangerousnether.utils.exists.exists;
import static verydangerousnether.verydangerousnether.utils.removeItemNaturally.removeItemNaturally;

public class nether implements Listener {

    //Plugin reference
    Plugin plugin = main.getPlugin(main.class);
    Random randint = new Random();

    //Set standard nether config values - also declares variables
    //set default config values
    public static List<String> worlds = new ArrayList<String>();
    public static List<Entity> effectEnts = new ArrayList<Entity>();
    public static List<String> mobNames = new ArrayList<String>();
    static boolean ambients = false;
    static boolean hasWorlds = false;
    static boolean newFire = false;
    public static boolean nether_structures = true;
    public static boolean caveEnts = false;
    public boolean canSave = false;
    public static int structure_chance = 0; // goes from 0-100%
    public static int web_chance = 0; // goes from 0-100%
    public static int mush_chance = 0; //goes from 0-100%
    public static int nspike_chance = 0; //goes from 0-100%
    public static int coral_chance = 0; //goes from 0-100%
    public static int rose_chance = 0; //goes from 0-100%
    public static int mushroom_chance = 0; //goes from 0-100%
    public static int replacerack_chance = 0; //goes from 0-100%
    public static int burnt_trees_chance = 0; //goes from 0-100%
    public static int mob_spawn_chance = 0; //goes from 0-100%
    public static int lava_spout_chance = 0; //goes from 0-100%
    public static int nheight = 120;
    static int damage = 0;

    //Get configs for nether
    @EventHandler
    public void getNetherConfigs(WorldInitEvent event) {
        //System.out.println("Reading configs for the netherModule");
        ambients = plugin.getConfig().getBoolean("enable_ambient_nether_sounds");
        caveEnts = plugin.getConfig().getBoolean("enable_custom_mobs");
        web_chance = plugin.getConfig().getInt("web_vine_chance");
        mush_chance = plugin.getConfig().getInt("mushroom_chance");
        nether_structures = plugin.getConfig().getBoolean("enable_nether_structures");
        structure_chance = plugin.getConfig().getInt("all_structures_chance");
        nspike_chance = plugin.getConfig().getInt("nether_spike_chance");
        coral_chance = plugin.getConfig().getInt("coral_chance");
        rose_chance = plugin.getConfig().getInt("rose_chance");
        newFire = plugin.getConfig().getBoolean("enable_better_fire");
        lava_spout_chance = plugin.getConfig().getInt("lava_spout_chance");
        mushroom_chance = plugin.getConfig().getInt("mushrooms_chance");
        replacerack_chance = plugin.getConfig().getInt("replace_netherrack_chance");
        burnt_trees_chance = plugin.getConfig().getInt("burnt_trees_chance");
        mob_spawn_chance = plugin.getConfig().getInt("mob_spawn_chance");
        nheight = plugin.getConfig().getInt("nether_world_height");
        mobNames.add(plugin.getConfig().getString("molten"));
        mobNames.add(plugin.getConfig().getString("fireball"));
        mobNames.add(plugin.getConfig().getString("inferno"));
        mobNames.add(plugin.getConfig().getString("old_shadow"));
        mobNames.add(plugin.getConfig().getString("sherogath"));
        mobNames.add(plugin.getConfig().getString("sadness"));
        mobNames.add(plugin.getConfig().getString("necromancer"));
        mobNames.add(plugin.getConfig().getString("alpha_pigman"));
        worlds = (List<String>) plugin.getConfig().getList("enabled_worlds");
        int d = plugin.getConfig().getInt("hungering_darkness_damage");

        //Control values
        if (d > 200) {
            damage = 200;
        } else if (d < 0) {
            damage = 0;
        } else {
            damage = d;
        }
        if (worlds.size() == 0) {
            boolean hasWorldR = false;
            for (World w : Bukkit.getWorlds()) {
                if (w.getName().toLowerCase().contains("nether")) {
                    hasWorldR = true;
                    worlds.add(w.getName());
                }
            }
            if (hasWorldR == true) {
            } else {
                worlds.add(Bukkit.getWorlds().get(0).getName());
            }
        }
    }



    public void betterEffectLooper() {
        if(!effectEnts.isEmpty()) {
            List<Entity> tempEntss = new ArrayList<Entity>(effectEnts);
            for(Entity e : tempEntss) {
                LivingEntity e2 = (LivingEntity) e;
                if(!worlds.contains(e2.getWorld().getName())) {
                    effectEnts.remove(e);
                }
                else {
                    if(exists(e)) {
                        if(e instanceof Monster) {
                            if(exists(((Monster) e).getTarget())) {
                                String name = e2.getCustomName();
                                if(name!=null || hasName("nethermob", e)) {
                                    if(hasName(plugin.getConfig().getString("inferno"), e)) {
                                        e2.getWorld().spawnParticle(Particle.FLAME, e2.getEyeLocation(), 1, 0, 0, 0, 0.001);
                                        e2.getWorld().playSound(e2.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1, 2);
                                        if(getLookingAt((LivingEntity) e2, (LivingEntity) ((Monster) e).getTarget())) {
                                            int radius = 1;
                                            if(((Player) ((Monster) e).getTarget()).isSneaking()){

                                            }
                                            else {
                                                Location loc = ((Monster) e).getTarget().getLocation();
                                                if(loc.getBlock().getType()==Material.AIR) {
                                                    loc.getBlock().setType(Material.FIRE, false);
                                                }
                                            }
                                        }
                                    }
                                    else if(hasName(plugin.getConfig().getString("molten"), e)) {
                                        if(randint.nextInt(14)==1) {
                                            e.getLocation().getBlock().setType(Material.FIRE);
                                        }
                                        if(randint.nextInt(28)==1) {
                                            e.getLocation().subtract(0, 1, 0).getBlock().setType(Material.MAGMA_BLOCK);
                                        }
                                        e2.getWorld().spawnParticle(Particle.LAVA, e2.getLocation().add(0, 1, 0), 2, 0.2, 0.5, 0.2, 0.005);
                                        if(Bukkit.getServer().getVersion().contains("1.15")) {
                                            e2.getWorld().spawnParticle(Particle.valueOf("FALLING_LAVA"), e2.getLocation().add(0, 1, 0), 6, 0.2, 0.5, 0.2, 0.005);
                                        }
                                    }
                                    else if(hasName(plugin.getConfig().getString("old_shadow"), e)) {
                                        e2.getWorld().playSound(e2.getLocation(), Sound.ENTITY_GUARDIAN_ATTACK, 1, 1);
                                        if(e2.getLocation().getBlock().getLightLevel()>=12) {
                                            int radius = 4;
                                            Location loc = e2.getLocation();
                                            int cx = loc.getBlockX();
                                            int cy = loc.getBlockY();
                                            int cz = loc.getBlockZ();
                                            for (int x = cx - radius; x <= cx + radius; x++) {
                                                for (int z = cz - radius; z <= cz + radius; z++) {
                                                    for (int y = (cy - radius); y < (cy + radius); y++) {
                                                        double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));
                                                        Block b = new Location(loc.getWorld(), x, y, z).getBlock();
                                                        if(b.getType()==Material.TORCH||b.getType()==Material.FIRE||b.getType()==Material.GLOWSTONE||b.getType()==Material.JACK_O_LANTERN||b.getType()==Material.REDSTONE_LAMP||b.getType()==Material.SEA_LANTERN || b.getType()==Material.REDSTONE_LAMP || b.getType()==Material.REDSTONE_TORCH || b.getType()==Material.CAMPFIRE || b.getType()==Material.SOUL_CAMPFIRE || b.getType()==Material.SOUL_FIRE || b.getType()==Material.SOUL_TORCH || b.getType()==Material.LANTERN || b.getType()==Material.SOUL_LANTERN) {
                                                            b.setType(Material.AIR);
                                                            ((Monster) e2).setTarget(null);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            List<Entity> ents = e2.getNearbyEntities(6, 6, 5);
                                            for(Entity ez : ents) {
                                                if(ez instanceof LivingEntity) {
                                                    if (ez instanceof Player) {
                                                        Player p = (Player) ez;
                                                        if (p.getGameMode().equals(GameMode.SURVIVAL)) {
                                                            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,120,1));
                                                            p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,120,0));
                                                            if (p.getHealth() > 2.0) {
                                                                p.damage(1);
                                                                e2.getWorld().spawnParticle(Particle.SMOKE_LARGE, e2.getLocation().add(0, 1, 0), 10, 1,1,1,0.001);
                                                                e2.getWorld().spawnParticle(Particle.SMOKE_NORMAL, e2.getLocation(), 2);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            e2.getWorld().spawnParticle(Particle.SUSPENDED, e2.getLocation().add(0, 1, 0), 230, 1,1,1,0.001);
                                            e2.getWorld().spawnParticle(Particle.SMOKE_LARGE, e2.getLocation().add(0, 1, 0), 10, 1,1,1,0.001);
                                        }
                                    }
                                    else if(hasName(plugin.getConfig().getString("sadness"), e)) {
                                        if(e2.hasPotionEffect(PotionEffectType.SLOW)) {
                                            Entity e3 = ((Monster) e2).getTarget();
                                            if(e3 != null) {
                                                double blocksAway = Math.sqrt((Math.pow(Math.abs(e3.getLocation().getX()-e2.getLocation().getX()), 2) + (Math.pow(Math.abs(e3.getLocation().getZ()-e2.getLocation().getZ()), 2))));
                                                if(blocksAway <= 6) {
                                                    if(randint.nextInt(8)==1) {
                                                        e2.getWorld().playSound(e2.getLocation(), Sound.ENTITY_WOLF_GROWL, 1, 0);
                                                    }
                                                }
                                                else {
                                                    if(randint.nextInt(14)==1) {
                                                        e2.getWorld().playSound(e2.getLocation(), Sound.ENTITY_WOLF_HURT, 1, 0);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else if(hasName(plugin.getConfig().getString("fireball"), e)) {
                                        e2.getWorld().spawnParticle(Particle.FLAME, e2.getLocation().add(0, e2.getEyeHeight(), 0), 5, 0.1, 0.1, 0.1, 0.005);
                                        e2.getWorld().spawnParticle(Particle.LAVA, e2.getLocation().add(0, e2.getEyeHeight(), 0), 1, 0.1, 0.1, 0.1, 0.005);
                                    }
                                    else if(hasName(plugin.getConfig().getString("sherogath"), e)) {
                                        e2.getWorld().spawnParticle(Particle.BARRIER, e2.getLocation() ,1);
                                        if(randint.nextInt(14)==1) {
                                            ((Player) ((Monster) e2).getTarget()).playSound(((Player) ((Monster) e2).getTarget()).getLocation(), Sound.ENCHANT_THORNS_HIT, (float) .04, (float) .2);
                                        }
                                    }
                                }
                            }
                            else {
                                effectEnts.remove(e);
                            }
                        }
                        else if(e instanceof Player) {
                            Player p = (Player) e;
                            boolean isCarry = false;
                            try {
                                if(p.getInventory().getItemInMainHand()!=null) {
                                    if(p.getInventory().getItemInMainHand().getType()==Material.LAVA_BUCKET) {
                                        if(randint.nextInt(10)==0) {
                                            p.damage(1);
                                            p.setFireTicks(20);
                                        }
                                        isCarry = true;
                                    }
                                }
                                else if(p.getInventory().getItemInOffHand()!=null) {
                                    if(p.getInventory().getItemInOffHand().getType()==Material.LAVA_BUCKET) {
                                        if(randint.nextInt(10)==0) {
                                            p.damage(1);
                                            p.setFireTicks(20);
                                        }
                                        isCarry = true;
                                    }
                                }
                                if(isCarry == false) {
                                    effectEnts.remove(e);
                                }
                            }
                            catch(Exception except) {
                                System.out.println(ChatColor.RED + "Uh oh error inside getItemInMainHand.");
                            }
                        }
                        else {
                            effectEnts.remove(e);
                        }
                    }
                    else {
                        effectEnts.remove(e);
                    }
                }
            }
        }
    }

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

    private static boolean getLookingAt(LivingEntity player, LivingEntity player1) {
        Location eye = player.getEyeLocation();
        Vector toEntity = ((LivingEntity) player1).getEyeLocation().toVector().subtract(eye.toVector());
        double dot = toEntity.normalize().dot(eye.getDirection());

        return dot > 0.99D;
    }

    @EventHandler
    public void doLightning(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        try {
            if(inHell(p.getLocation().getBlock())) {
                if(randint.nextDouble() < plugin.getConfig().getDouble("lightning_chance")) {
                    Location l = p.getLocation();
                    l.getWorld().strikeLightning(l.add((getRandValue() * randint.nextInt(160)), 1, (getRandValue() * randint.nextInt(160))));
                }
            }
        }
        catch(Exception ex) {
            System.out.println(ChatColor.RED + "Uh oh error inside doLightning.");
        }
    }

    public int getRandValue() {
        if(randint.nextBoolean()==true) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public static boolean inHell(Block b) {
        try {
            if(b.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception e) {
            try{
                if(b.getBiome()==Biome.valueOf("NETHER")) {
                    return true;
                }
                else {
                    return false;
                }
            }
            catch(Exception e2) {
                return false;
            }
        }
    }

    public Block getNetherBlock(Player p) {
        try {
            Block b = null;
            Location l = p.getLocation().clone();
            int ammount = randint.nextInt(3)+1;
            int direction = randint.nextInt(4);
            for(int i = 80; i > 0; i--) {
                if(l.getBlock().getType()==Material.NETHERRACK||l.getBlock().getType()==Material.SOUL_SAND||l.getBlock().getType()==Material.GLOWSTONE) {
                    Location l2 = l.clone();
                    if(l2.subtract(0, 1, 0).getBlock().getType()==Material.AIR) {
                        b = l.getBlock();
                        return b;
                    }
                }
                if(direction == 0) {
                    l.add(ammount, 0, 0);
                }
                else if(direction == 1) {
                    l.subtract(ammount, 0, 0);
                }
                else if(direction == 2) {
                    l.add(0, 0, ammount);
                }
                else if(direction == 3) {
                    l.subtract(0, 0, ammount);
                }
                l.add(0, 1, 0);
            }
            return b;
        }
        catch(Exception ee) {
            System.out.println(ChatColor.RED + "Uh oh error inside getNetherBlock.");
            return null;
        }
    }

    //Collapse nether

    @EventHandler
    public void collapseNether(BlockBreakEvent event) {
        Player p = event.getPlayer();
        try {
            if(!worlds.contains(p.getWorld().getName())) {
                return;
            }
            World wor = p.getWorld();
            if(plugin.getConfig().getBoolean("enable_falling_nether")) {
                try {
                    if(randint.nextInt(100) < plugin.getConfig().getInt("falling_nether_chance")) {
                        Block b1 = getNetherBlock(p);
                        if(b1 == null) {
                            return;
                        }
                        if(b1.getLocation().distanceSquared(p.getLocation())<70) {
                            return;
                        }
                        Location loc = b1.getLocation();
                        int radius = 5;
                        int cx = loc.getBlockX();
                        int cy = loc.getBlockY();
                        int cz = loc.getBlockZ();
                        for (int x = cx - radius; x <= cx + radius; x++) {
                            for (int z = cz - radius; z <= cz + radius; z++) {
                                for (int y = (cy - radius); y < (cy + radius); y++) {
                                    double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));

                                    if (dist < radius * radius) {
                                        Location l = new Location(loc.getWorld(), x, y + 2, z);
                                        Block b = l.getBlock();
                                        if(b.getType()==Material.AIR||b.getType()==Material.BEDROCK) {
                                        }
                                        else {
                                            b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
                                            l.getBlock().setType(Material.AIR);
                                        }
                                    }
                                }
                            }
                        }
                        p.getWorld().playSound(b1.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                        p.getWorld().createExplosion(b1.getLocation(), 5);
                    }
                }
                catch(Exception error) {
                    System.out.println(ChatColor.RED + "Uh oh error inside collapse nether trigger.");
                }
            }
        }
        catch(Exception ee) {
            System.out.println(ChatColor.RED + "Uh oh error inside collapse nether.");
        }
    }

    @EventHandler
    public void entityOnFireNether(EntityCombustEvent e) {
        if(e.getEntity() instanceof LivingEntity) {
            if(worlds.contains(e.getEntity().getWorld().getName())) {
                if(e.getEntity().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                    e.setDuration(e.getDuration() * 2);
                }
            }
        }
    }

    public void testPlayerHandItem() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(worlds.contains(p.getWorld().getName())) {
                ItemStack i = p.getInventory().getItemInMainHand();
                ItemStack i2 = p.getInventory().getItemInOffHand();
                if(i != null) {
                    if(i.getType() == Material.WATER_BUCKET || i.getType().name().toLowerCase().contains("snow") || i.getType().name().toLowerCase().contains("ice")) {
                        if(p.getFireTicks() > 0) {
                            if(p.getLocation().getBlock().getType() != Material.LAVA || p.getLocation().getBlock().getType() != Material.FIRE) {
                                p.setFireTicks(0);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
                            }
                        }
                        if(randint.nextInt(3) == 0) {
                            if(i.getType() == Material.WATER_BUCKET) {
                                if(randint.nextInt(3) == 0) {
                                    p.getInventory().getItemInMainHand().setType(Material.BUCKET);
                                    p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                                }
                            }
                            else {
                                removeItemNaturally(p, true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, (float) 0.1, 1);
                            }
                        }
                    }
                }
                if(i2 != null) {
                    if(i2.getType() == Material.WATER_BUCKET || i2.getType().name().toLowerCase().contains("snow") || i2.getType().name().toLowerCase().contains("ice")) {
                        if(p.getFireTicks() > 0) {
                            if(p.getLocation().getBlock().getType() != Material.LAVA || p.getLocation().getBlock().getType() != Material.FIRE) {
                                p.setFireTicks(0);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
                            }
                        }
                        if(randint.nextInt(3) == 0) {
                            if(i2.getType() == Material.WATER_BUCKET) {
                                if(randint.nextInt(3) == 0) {
                                    p.getInventory().getItemInMainHand().setType(Material.BUCKET);
                                    p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                                }
                            }
                            else {
                                removeItemNaturally(p, false);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, (float) 0.1, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    List<LivingEntity> onFire = new ArrayList<LivingEntity>();

    @EventHandler
    public void onSetOnFire(EntityCombustEvent e) {
        if(worlds.contains(e.getEntity().getWorld().getName()) && newFire) {
            if(e.getEntity().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                if(e.getEntity() instanceof LivingEntity && (!(e.getEntity().hasMetadata("player")))) {
                    if((e instanceof Blaze || e instanceof Ghast || e instanceof WitherSkeleton || e instanceof PigZombie) || hasName(plugin.getConfig().getString("Molten = "), e.getEntity())) {
                        return;
                    }
                    onFire.add((LivingEntity) e.getEntity());
                }
            }
        }
    }

    public boolean isValid(LivingEntity e) {
        if(e == null) {
            return false;
        }
        if(e.isDead()) {
            return false;
        }
        return true;
    }

    public void fireLoop() {
        List<LivingEntity> onFireCopy = new ArrayList<LivingEntity>(onFire);
        for(LivingEntity e : onFireCopy) {
            if(isValid(e)) {
                if(e.getFireTicks() > 0) {
                    if(e instanceof Blaze || e instanceof Ghast || e instanceof WitherSkeleton || e instanceof PigZombie) {
                        onFire.remove(e);
                    }
                    else if(e instanceof Enderman || e instanceof Player || e instanceof Zombie || e instanceof Skeleton || e instanceof Illager || e instanceof Creeper || e instanceof Witch) {
                        if(randint.nextInt(2)==0) {
                            e.getWorld().spawnParticle(Particle.FLAME, e.getLocation().add(0, 1, 0), (randint.nextInt(3)+1), 0.2, 0.5, 0.2, 0.01);
                        }
                        if(randint.nextInt(3)==0) {
                            e.getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getLocation().add(0, 1, 0), (randint.nextInt(3)+1), 0.2, 0.5, 0.2, 0.01);
                        }
                        if(randint.nextInt(5)==0) {
                            e.getWorld().spawnParticle(Particle.LAVA, e.getLocation(), (randint.nextInt(2)+1), 0.1, 0, 0.1, 0.01);
                        }
                        if(randint.nextInt(10)==0) {
                            e.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, e.getLocation().add(0, 1, 0), (randint.nextInt(2)+1), 0.2, 0.5, 0.2, 0.01);
                        }
                    }
                    else {
                        BoundingBox bb = e.getBoundingBox();
                        double heightAdd = bb.getHeight() / 2.0;
                        double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
                        if(randint.nextInt(2)==0) {
                            e.getWorld().spawnParticle(Particle.FLAME, e.getLocation().add(0, heightAdd, 0), (randint.nextInt(3)+1), width/3.0, heightAdd/2.0, width/3.0, 0.015);
                        }
                        if(randint.nextInt(3)==0) {
                            e.getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getLocation().add(0, heightAdd, 0), (randint.nextInt(3)+1), width/3.0, heightAdd/2.0, width/3.0, 0.015);
                        }
                        if(randint.nextInt(5)==0) {
                            e.getWorld().spawnParticle(Particle.LAVA, e.getLocation(), (randint.nextInt(2)+1), width/4.0, 0, width/4.0, 0.015);
                        }
                        if(randint.nextInt(10)==0) {
                            e.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, e.getLocation().add(0, heightAdd, 0), (randint.nextInt(2)+1), width/3.0, heightAdd/2.0, width/3.0, 0.015);
                        }
                    }
                }
                else {
                    onFire.remove(e);
                }
            }
            else {
                onFire.remove(e);
            }
        }
    }

    public boolean nextToEdge(Location l, Chunk org, boolean skipMinus) {
        int minus = 0;
        if(!skipMinus) {
            if(l.getX() <= 0 || l.getZ() <=0) {
                minus = 1;
            }
        }
        Chunk c = org;
        int cX = c.getX() * 16;
        int cZ = c.getZ() * 16;
        if((cX + minus) >= l.getBlockX()) {
            return true;
        }
        else if(((cX + 15) - minus) <= l.getBlockX()) {
            return true;
        }
        if((cZ + minus) >= l.getBlockZ()) {
            return true;
        }
        else if(((cZ + 15) - minus) <= l.getBlockZ()) {
            return true;
        }
        return false;
    }
}
