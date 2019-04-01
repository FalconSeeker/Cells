package me.falconseeker.cells.cell;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.bukkit.Location;

public interface ICell {

	public List<Location> getLocationSet();
	public void setLocationSet(List<Location> locationSet);
	@Nullable public UUID getOwner();
	public void setOwner(UUID owner);
	@Nullable public Location getHome();
	public void setHome(Location home);
	public String getId();
	public void setId(String id);
	public String getGroup();
	public void setGroup(String group);
	public int getPrice();
	public void setPrice(int price);
	
}
