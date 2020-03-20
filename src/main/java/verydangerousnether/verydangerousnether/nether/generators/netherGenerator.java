package verydangerousnether.verydangerousnether.nether.generators;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.generator.BlockPopulator;
import verydangerousnether.verydangerousnether.nether.nether;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class netherGenerator extends BlockPopulator {

    //create random integer
    Random randint = new Random();

    int[][][] rock1 = { { {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0} },
            { {1, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock2 = { { {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 1, 0}, {0, 1, 0} },
            { {0, 1, 1}, {0, 1, 1}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock3 = { { {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}},
            { {0, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock4 = { { {1, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0} },
            { {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock5 = { { {0, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0} },
            { {1, 1, 0}, {1, 1, 0}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock6 = { { {1, 1, 1}, {0, 1, 1}, {0, 1, 1}, {0, 1, 1}, {0, 1, 1}, {0, 0, 1}, {0, 0, 1} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock7 = { { {1, 1, 0}, {1, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {0, 1, 0} },
            { {1, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock8 = { { {0, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            {     {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0} },
            {     {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };

    int[][][] mush1 = { { {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 2, 2, 0}, {0, 0, 0, 0, 0} },
            {    	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 3, 3, 3, 2}, {0, 2, 2, 2, 0} },
            {    	  {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {2, 3, 1, 3, 2}, {0, 2, 2, 2, 0} },
            {    	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 3, 3, 3, 2}, {0, 2, 2, 2, 0} },
            {     	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 2, 2, 0}, {0, 0, 0, 0, 0} } };
    int[][][] mush2 = { { {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 2, 2, 0}, {0, 0, 0, 0, 0}},
            {    	  	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 3, 3, 3, 2}, {0, 2, 2, 2, 0}},
            {    	  	  {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {2, 3, 1, 3, 2}, {0, 2, 2, 2, 0}},
            {    	 	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 3, 3, 3, 2}, {0, 2, 2, 2, 0}},
            {     	 	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 2, 2, 0}, {0, 0, 0, 0, 0}} };
    int[][][] mush3 = { { {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 2, 2, 0}, {0, 0, 0, 0, 0}},
            {    	  	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 3, 3, 3, 2}, {0, 2, 2, 2, 0}},
            {    	  	  {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {2, 3, 1, 3, 2}, {0, 2, 2, 2, 0}},
            {    	 	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 3, 3, 3, 2}, {0, 2, 2, 2, 0}},
            {     	 	  {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 2, 2, 0}, {0, 0, 0, 0, 0}} };

    @Override
    public void populate(World world, Random random, Chunk source) {
        //System.out.println("Sir, we are inside the netherGenerator populator.");
        if((random.nextInt(100) < nether.structure_chance) && nether.nether_structures) {
            //System.out.println("Sir, we are inside the if statement in netherGenerator populator.");
            int typeC = random.nextInt(1);
            //sendCaveMessage(typeC);
            int cX = source.getX() * 16;
            int cZ = source.getZ() * 16;
            int cXOff = cX;
            int cZOff = cZ;
            if(randint.nextInt(100) < nether.nspike_chance) {
                //System.out.println("Created spike");
                createSpike(cXOff + 7, cZOff + 7, world);
            }
            if(randint.nextInt(100) < nether.mush_chance) {
                //System.out.println("Created mushroom");
                createMushroom(cXOff + random.nextInt(6) + 2, cZOff + random.nextInt(6) + 2, world);
            }
            if(randint.nextInt(100) < nether.burnt_trees_chance) {
                //System.out.println("Created burnt trees");
                createBurntTrees(cXOff + 7, cZOff + 7, world);
            }
            if(randint.nextInt(100) < nether.web_chance) {
                //System.out.println("Created webs");
                createWebs(cXOff + 7, cZOff + 7, world);
            }
            if(randint.nextInt(100) < nether.mushroom_chance) {
                //System.out.println("Created mushroom");
                createMushroom(cXOff + random.nextInt(5) + 5, cZOff + random.nextInt(5) + 5, world);
            }
            if(randint.nextInt(100) < nether.coral_chance) {
                //System.out.println("Created coral grass");
                createCoralGrass(cXOff + random.nextInt(2) + 6, cZOff + random.nextInt(2) + 6, world);
            }
        }

    }

    public List<Integer> getClosestAirA(int cXOff, int cZOff, World world) {
        List<Integer> yvals = new ArrayList<Integer>();
        try {
            Location loc = new Location(world, cXOff, 20, cZOff);
            while(loc.getY()<nether.nheight) {
                loc.add(0, 1, 0);
                if(loc.getBlock()!=null) {
                    if(loc.getBlock().getType()== Material.AIR) {
                        Location loc2 = new Location(world, loc.getX(), loc.getY() + 1, loc.getZ());
                        if(loc2.getBlock().getType()== Material.NETHERRACK) {
                            yvals.add((int) loc.clone().getY());
                        }
                    }
                }
            }
            return yvals;
        } catch(Exception error) {
            System.out.println("Couldn't get closest air.");
            return null;
        }
    }

    public List<Integer> getClosestAirB(int cXOff, int cZOff, World w) {
        List<Integer> yvals = new ArrayList<Integer>();
        try {
            Location loc = new Location(w, cXOff, 20, cZOff);
            while(loc.getY() < nether.nheight) {
                loc.add(0, 1, 0);
                if(loc.getBlock()!=null) {
                    if(loc.getBlock().getType()== Material.AIR) {
                        Location loc2 = new Location(w, loc.getX(), loc.getY() - 1, loc.getZ());
                        if(loc2.getBlock().getType()== Material.NETHERRACK) {
                            yvals.add((int) loc.clone().getY());
                        }
                    }
                }
            }
            return yvals;
        }
        catch(Exception error) {
            System.out.println("Couldn't get closest air.");
            return null;
        }
    }

    public void createWebs(int cXOff, int cZOff, World world) {
        //System.out.println("CreateWebs have been called by the lords");
        try {
            List<Integer> yvals = getClosestAirA(cXOff, cZOff, world);
            if(yvals!=null) {
                //System.out.println("Passed yvals check");
                for(int y : yvals) {
                    for(int count = 0; count < 35; count++) {
                        Location org = new Location(world, cXOff, y, cZOff);
                        Location l = getRandLoc(new Location(world, cXOff, y, cZOff), 9);
                        if(canPlaceBlock(l, org.getChunk())) {
                            if(isAir(l.getBlock().getType()) && (!l.clone().add(0, 1, 0).getBlock().isPassable())) {
                                int length = randint.nextInt(10)+7;
                                for(int count2 = 0; count2 < length; count2++) {
                                    if(isAir(l.getBlock().getType())==false || isAir(l.clone().subtract(0, 1, 0).getBlock().getType())==false) {
                                        break;
                                    }
                                    else {
                                        l.getBlock().setType(Material.COBWEB, false);
                                    }
                                    l.subtract(0, 1, 0);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception error) {
            System.out.println("Couldn't create webs.");
        }
    }

    public void createBurntTrees(int cXOff, int cZOff, World w) {
        List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
        if(yvals!=null) {
            for(int y : yvals) {
                for(int count = 0; count < 12; count++) {
                    if(randint.nextInt(7)!=0) {
                        Location org = new Location(w, cXOff, y, cZOff);
                        Location l = getRandLoc(new Location(w, cXOff, y, cZOff), 9);
                        if(canPlaceBlock(l, org.getChunk())) {
                            boolean canCreate = false;
                            if(isAir(l.getBlock().getType())) {
                                if(l.getBlock().getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK || l.getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND) {
                                    if(l.getBlock().getRelative(BlockFace.UP).isPassable()) {
                                        canCreate = true;
                                    }
                                }
                            }
                            if(canCreate) {
                                int height = randint.nextInt(6) + 2;
                                for(int count2 = 0; count2 < height; count2++) {
                                    if(randint.nextBoolean()) {
                                        l.getBlock().setType(Material.DARK_OAK_LOG, false);
                                    }
                                    else {
                                        l.getBlock().setType(Material.GRAY_CONCRETE_POWDER, false);
                                    }
                                    l.add(0, 1, 0);
                                    if(!isAir(l.getBlock().getRelative(BlockFace.UP).getType())) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void generateMushroom(int[][][] rock, Location loc) {
        try {
            boolean checked = false;
            Material outsideMaterial = null;
            if(randint.nextBoolean()) {
                outsideMaterial = Material.BROWN_MUSHROOM_BLOCK;
            }
            else {
                outsideMaterial = Material.RED_MUSHROOM_BLOCK;
            }
            for(int y = 0; y < rock[0].length; y++) {
                for(int x = -1; x < rock.length-1; x++) {
                    for(int z = -1; z < rock[0][0].length-1; z++) {
                        Location loc2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()+z);
                        int num = rock[x+1][y][z+1];
                        if(canPlaceBlock(loc2, loc.getChunk())) {
                            if(num == 1) {
                                if(checked == false) {
                                    if(!canPlaceMushroom(loc2.clone(), loc.getChunk())) {
                                        return;
                                    }
                                    boolean canCreate = false;
                                    if(isAir(loc2.getBlock().getType())) {
                                        if(loc2.getBlock().getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK || loc2.getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND) {
                                            if(loc2.getBlock().getRelative(BlockFace.UP).isPassable()) {
                                                canCreate = true;
                                            }
                                        }
                                    }
                                    if(!canCreate) {
                                        return;
                                    }
                                    checked = true;
                                }
                                loc2.getBlock().setType(Material.MUSHROOM_STEM, false);
                            }
                            else if(num == 2){
                                loc2.getBlock().setType(outsideMaterial, false);
                            }
                            else if(num == 3){
                                loc2.getBlock().setType(Material.AIR, false);
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {
        }
    }

    public void createMushroom(int cXOff, int cZOff, World w) {
        List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
        if(yvals!=null) {
            for(int y : yvals) {
                for(int count = 0; count < 10; count++) {
                    if(randint.nextInt(7)!=0) {
                        Location org = new Location(w, cXOff, y, cZOff);
                        Location l = getRandLoc(new Location(w, cXOff, y, cZOff), 9);
                        if(canPlaceBlock(l, org.getChunk())) {
                            if(!nextToEdge(l, org.getChunk(), false)) {
                                boolean canCreate = false;
                                if(isAir(l.getBlock().getType())) {
                                    if(l.getBlock().getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK || l.getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND) {
                                        if(l.getBlock().getRelative(BlockFace.UP).isPassable()) {
                                            canCreate = true;
                                        }
                                    }
                                }
                                if(canCreate) {
                                    int stemHeight = randint.nextInt(7) + 2;
                                    int mushroomType = randint.nextInt(2);
                                    if(mushroomType == 0) {
                                        int outsideStart = randint.nextInt(stemHeight) + 1;
                                        if(outsideStart == stemHeight) {
                                            outsideStart -= 1;
                                        }
                                        Material outsideMaterial = null;
                                        if(randint.nextBoolean()) {
                                            outsideMaterial = Material.BROWN_MUSHROOM_BLOCK;
                                        }
                                        else {
                                            outsideMaterial = Material.RED_MUSHROOM_BLOCK;
                                        }
                                        for(int stemCount = 0; stemCount < stemHeight; stemCount++) {
                                            l.getBlock().setType(Material.MUSHROOM_STEM, false);
                                            if(stemCount >= outsideStart) {
                                                surroundStem(l, org.getChunk(), outsideMaterial);
                                            }
                                            l.add(0, 1, 0);
                                            if(!isAir(l.clone().add(0, 1, 0).getBlock().getType())) {
                                                surroundStem(l.clone().subtract(0, 1, 0), org.getChunk(), outsideMaterial);
                                                break;
                                            }
                                        }
                                        l.getBlock().setType(outsideMaterial, false);
                                    }
                                    else if(mushroomType == 1) {
                                        int capType = randint.nextInt(3);
                                        if(capType == 0) {
                                            generateMushroom(mush1, l);
                                        }
                                        else if(capType == 1) {
                                            generateMushroom(mush2, l);
                                        }
                                        else if(capType == 2) {
                                            generateMushroom(mush3, l);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void createSpike(int cXOff, int cZOff, World w) {
        try {
            List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
            if(yvals!=null) {
                for(int y : yvals) {
                    int ammount = randint.nextInt(6)+12;
                    for(int count = 0; count < ammount; count++) {
                        Location org = new Location(w, cXOff, y, cZOff);
                        Location l = getRandLoc(new Location(w, cXOff, y, cZOff), 6);
                        if(canPlaceBlock(l, org.getChunk())) {
                            if(isAir(l.getBlock().getType()) && (l.clone().subtract(0, 1, 0).getBlock().getType() == Material.NETHERRACK)) {
                                createBase(l);
                                int type = randint.nextInt(8);
                                if(type==0) {
                                    generateBoulder(rock1, l);
                                }
                                else if(type==1) {
                                    generateBoulder(rock2, l);
                                }
                                else if(type==2) {
                                    generateBoulder(rock3, l);
                                }
                                else if(type==3) {
                                    generateBoulder(rock4, l);
                                }
                                else if(type==4) {
                                    generateBoulder(rock5, l);
                                }
                                else if(type==5) {
                                    generateBoulder(rock6, l);
                                }
                                else if(type==6) {
                                    generateBoulder(rock7, l);
                                }
                                else if(type==7) {
                                    generateBoulder(rock8, l);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {

        }
    }

    public void createCoralGrass(int cXOff, int cZOff, World w) {
        try {
            List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
            if(yvals!=null) {
                for(int y : yvals) {
                    //if(randor.nextInt(5)!=0) {
                    for(int count = 0; count < 40; count++) {
                        if(randint.nextInt(7)!=0) {
                            Location org = new Location(w, cXOff, y, cZOff);
                            Location l = getRandLoc(new Location(w, cXOff, y, cZOff), 9);
                            if(canPlaceBlock(l, org.getChunk())) {
                                Block b = l.clone().subtract(0, 1, 0).getBlock();
                                if(l.getBlock().getType() == Material.AIR && (b.getType() == Material.NETHERRACK || b.getType() == Material.SOUL_SAND)) {
                                    if(randint.nextBoolean()==true) {
                                        l.getBlock().setType(Material.FIRE_CORAL, false);
                                    }
                                    else {
                                        l.getBlock().setType(Material.FIRE_CORAL_FAN, false);
                                    }
                                    Waterlogged wl = (Waterlogged) l.getBlock().getBlockData();
                                    wl.setWaterlogged(false);
                                    l.getBlock().setBlockData(wl, false);
                                }
                            }
                        }
                    }
                    //}
                }
            }
        }
        catch(Exception error) {

        }
    }

    public void generateBoulder(int[][][] rock, Location loc) {
        try {
            int randDirection = randint.nextInt(4);
            if(randDirection==0) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()+z);
                                if(canPlaceBlock(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.NETHERRACK, false);
                                }
                            }
                        }
                    }
                }
            }
            else if(randDirection==1) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()-x, loc.getY()+y, loc.getZ()+z);
                                if(canPlaceBlock(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.NETHERRACK, false);
                                }
                            }
                        }
                    }
                }
            }
            else if(randDirection==2) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()-z);
                                if(canPlaceBlock(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.NETHERRACK, false);
                                }
                            }
                        }
                    }
                }
            }
            else if(randDirection==3) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()-x, loc.getY()+y, loc.getZ()-z);
                                if(canPlaceBlock(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.NETHERRACK, false);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {
        }
    }

    public Location getRandLoc(Location l, int radi) {
        if(l!=null) {
            double radius = radi;
            double x0 = l.getX();
            double y0 = l.getY();
            double z0 = l.getZ();
            double u = Math.random();
            double v = Math.random();
            double theta = 2 * Math.PI * u;
            double phi = Math.acos(2 * v - 1);
            double x = x0 + (radius * Math.sin(phi) * Math.cos(theta));
            double y = y0;
            double z = z0 + (radius * Math.cos(phi));
            return new Location(l.getWorld(), x, y, z, randint.nextInt(360), randint.nextInt(360));
        }
        return null;
    }

    public boolean canPlaceBlock(Location l, Chunk org) {
        if(outsideChunk(l, org)) {
            return false;
        }
        if(l.getX() <= 0 || l.getZ() <= 0) {
            if(nextToEdge(l, org, true)) {
                return false;
            }
        }
        return true;
    }

    public boolean outsideChunk(Location l, Chunk org) {
        Chunk c = org;
        int cX = c.getX() * 16;
        int cZ = c.getZ() * 16;
        int x = ((int) l.getX());
        int z = ((int) l.getZ());
        if((cX) > x) {
            return true;
        }
        else if((cX+15) < x) {
            return true;
        }
        if((cZ) > z) {
            return true;
        }
        else if((cZ+15) < z) {
            return true;
        }
        return false;
    }

    public boolean isAir(Material m) {
        if(m == Material.AIR || m == Material.CAVE_AIR || m == Material.VOID_AIR) {
            return true;
        }
        return false;
    }

    public boolean canPlaceMushroom(Location l, Chunk org) {
        Chunk c = org;
        if(nextToEdge(l.clone().add(1, 0, 0), c, false)) {
            return false;
        }
        if(nextToEdge(l.clone().subtract(1, 0, 0), c, false)) {
            return false;
        }
        if(nextToEdge(l.clone().subtract(0, 0, 1), c, false)) {
            return false;
        }
        if(nextToEdge(l.clone().add(0, 0, 1), c, false)) {
            return false;
        }
        return true;
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

    public void surroundStem(Location l, Chunk org, Material outside) {
        if(canPlaceBlock(l.clone().subtract(0, 0, 1), org)) {
            l.clone().subtract(0, 0, 1).getBlock().setType(outside, false);
        }
        if(canPlaceBlock(l.clone().add(0, 0, 1), org)) {
            l.clone().add(0, 0, 1).getBlock().setType(outside, false);
        }
        if(canPlaceBlock(l.clone().subtract(1, 0, 0), org)) {
            l.clone().subtract(1, 0, 0).getBlock().setType(outside, false);
        }
        if(canPlaceBlock(l.clone().add(1, 0, 0), org)) {
            l.clone().add(1, 0, 0).getBlock().setType(outside, false);
        }
    }

    public void createBase(Location l) {
        Location l2 = l.clone().subtract(0, 1, 0);
        Block b = l2.getBlock();
        b.getRelative(BlockFace.EAST).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.NORTH).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.SOUTH).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.SELF).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.WEST).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.NORTH_EAST).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.SOUTH_EAST).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.SOUTH_WEST).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.NORTH_WEST).setType(Material.NETHERRACK, false);
        b.getRelative(BlockFace.DOWN).setType(Material.NETHERRACK, false);
    }
}
