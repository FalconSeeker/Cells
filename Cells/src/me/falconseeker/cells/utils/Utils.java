package me.falconseeker.cells.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.math.BlockVector3;

public class Utils {

	private Utils() {}
	
	private static HashMap<UUID, Location> positionSet = new HashMap<UUID, Location>();
	
	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
    public static void loadSchematic(Location center, File file) throws IOException {
    	if (!file.exists()) return;
    	
    	boolean allowUndo = false;
    	boolean noAir = false;
    	
    	//LocalWorld lw = BukkitUtil.getLocalWorld(world);
    	BukkitWorld w = new BukkitWorld(center.getWorld());
    	BlockVector3 pos = BlockVector3.at(center.getX(), center.getY(), center.getZ());
    	
    	EditSession editSession = ClipboardFormats.findByFile(file).load(file).paste(w, pos, allowUndo, noAir, null);
    	editSession.flushQueue();
    }
}
