package me.falconseeker.cells.auctions;

import java.util.List;
import org.bukkit.Location;

public interface IAuctionHouse {

	public List<Location> getLocationSet();
	public void setLocationSet(List<Location> locationSet);
	public String getGroup();
	public void setGroup(String id);
	
}
