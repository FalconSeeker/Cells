package me.falconseeker.cells.utils.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Menu {

	private Inventory inv;
	
	public Menu(Player holder, int size) {
		this.inv = Bukkit.createInventory(null, size);
	}
	public Menu(String name, int size) {
		this.inv = Bukkit.createInventory(null, size, name);
	}
	public Menu(String name, int size, Player holder) {
		this.inv = Bukkit.createInventory(holder, size, name);
	}
	
	public Menu setItem(int slot, ItemStack is) {
		inv.setItem(slot, is);
		return this;
	}
	public Menu addItem(int slot, ItemStack is) {
		inv.setItem(slot, is);
		return this;
	}
	public Menu open(Player p) {
		p.openInventory(inv);
		return this;
	}
	public Inventory getInventory() {
		return inv;
	}
}
