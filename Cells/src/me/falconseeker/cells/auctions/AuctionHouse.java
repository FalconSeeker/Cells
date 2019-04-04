package me.falconseeker.cells.auctions;

import java.util.Collections;
import java.util.List;
import org.bukkit.Location;

public class AuctionHouse implements IAuctionHouse {

	private List<Location> locationSet;
	private String group;
	
	public AuctionHouse(String group, List<Location> locationSet) {
		this.locationSet = locationSet;
		this.group = group;
	}
	
	@Override public List<Location> getLocationSet() {
		return Collections.unmodifiableList(locationSet);
	}

	@Override public void setLocationSet(List<Location> locationSet) {
		this.locationSet = locationSet;
	}

	@Override public String getGroup() {
		return group;
	}

	@Override public void setGroup(String group) {
		this.group = group;
	}
}
