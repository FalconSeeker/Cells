package me.falconseeker.cells.cell;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

public class Cell implements ICell {

	private List<Location> locationSet;
	private UUID owner;
	private String id;
	private Location home;
	private String group;
	private int price;
	
	public Cell(String id, String group, UUID owner, Location home, List<Location> locationSet, int price) {
		this.setId(id);
		this.setLocationSet(locationSet);
		this.setOwner(owner);
		this.setHome(home);
		this.setGroup(group);
		this.setPrice(price);
	}
	public Cell(String id, String group, Location home, List<Location> locationSet, int price) {
		this.setId(id);
		this.setLocationSet(locationSet);
		this.setOwner(null);
		this.setHome(home);
		this.setGroup(group);
		this.setPrice(price);
	}
	public Cell(String id, String group, List<Location> locationSet, int price) {
		this.setId(id);
		this.setLocationSet(locationSet);
		this.setOwner(null);
		this.setHome(null);
		this.setGroup(group);
		this.setPrice(price);
	}
	@Override public List<Location> getLocationSet() {
		return Collections.unmodifiableList(locationSet);
	}

	@Override public void setLocationSet(List<Location> locationSet) {
		this.locationSet = locationSet;
	}

	@Override public UUID getOwner() {
		return owner;
	}

	@Override public void setOwner(UUID owner) {
		this.owner = owner;
	}

	@Override public Location getHome() {
		return home;
	}

	@Override public void setHome(Location home) {
		this.home = home;
	}

	@Override public String getId() {
		return id;
	}

	@Override public void setId(String id) {
		this.id = id;
	}

	@Override public String getGroup() {
		return group;
	}

	@Override public void setGroup(String group) {
		this.group = group;
	}

	@Override public int getPrice() {
		return price;
	}

	@Override public void setPrice(int price) {
		this.price = price;
	}
}
