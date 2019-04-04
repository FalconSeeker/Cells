package me.falconseeker.cells;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cells.auctions.AuctionHouseManager;
import me.falconseeker.cells.cell.Cell;
import me.falconseeker.cells.cell.CellManager;
import me.falconseeker.cells.utils.gui.ItemBuilders;

public class CellsAPI {

	private CellManager cellManager;
	private AuctionHouseManager auctionManager;
	
	public CellsAPI(CellPlugin main) {
		this.cellManager = main.getCellManager();
		this.auctionManager = main.getAuctionManager();
	}
	
	/**
	 * Checks if a player owns a cell
	 * 
	 * @param p
	 * the player to check if they own a cell
	 * @return
	 * returns true if a player owns a cell
	 */
	public boolean hasCell(Player p) {
		for (Cell cell : cellManager.getCells()) {
			if (cell.getOwner().equals(p.getUniqueId())) return true;
		}
		return false;
	}
	
	/**
	 * Checks if a player can rent another cell
	 * 
	 * @param p
	 * The player to check if they can rent
	 * @return
	 * returns true if the player can rent another cell
	 */
	public boolean canRent(Player p) {
		if (cellManager.getCells(p).size() < getMaxCells(p)) return true;
		return false;
	}
	
	/**
	 * Get how many cells a player can own
	 * 
	 * @param p
	 * The player to check how many cells they can own
	 * @return
	 * returns an int of how many cells the player can own
	 */
	public int getMaxCells(Player p) {
		for (int i = 10; i >= 0; i--) {
			if (p.hasPermission("cells.rent." + i)) return i;
		}
		return 0;
	}

	/**
	 * Make a player rent a cell / Click sign
	 * 
	 * @param p
	 * Purchaser of cell
	 * @param cell 
	 * Cell to check if it can be rented
	 */
	public void rentCell(Player p, Cell cell) {
		if (cell.getOwner() != null) {
			p.sendMessage(ChatColor.RED + "You do not own this cell!");
			return;
		}
		if (!canRent(p)) {
			p.sendMessage(ChatColor.RED + "You cannot rent more cells!");
			return;
		}
		cell.setOwner(p.getUniqueId());
		p.sendMessage(ChatColor.GREEN + "You have rented this cell!");
	}

	/**
	 * Unrents a cell / Shift + Click sign
	 * 
	 * @param p
	 * Player to unrent cell
	 * @param cell
	 * Cell to check if player can unrent
	 */
	public void unRentCell(Player p, Cell cell) {
		if (!cell.getOwner().equals(p.getUniqueId())) {
			p.sendMessage(ChatColor.RED + "You do not own this cell!");
			return;
		}
		cell.setOwner(null);
		p.sendMessage(ChatColor.RED + "Cell unrented");
	}
	
	/**
	 * Resets a cell back to it's default state and sends its items to an auction chest
	 * @param cell
	 */
	public void startAH(Cell cell) {
		if (auctionManager.getAuction(cell.getGroup()) == null) {
			Bukkit.getConsoleSender().sendMessage(cell.getId() + " auction house was not found! Group: " + cell.getGroup());
			return;
		}
		ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
		
		for (Location loc : cell.getLocationSet()) {
			if (loc.getBlock() == null) continue;
			
			Block b = loc.getBlock();
			
			if (b.getType() == Material.CHEST || b.getType() == Material.TRAPPED_CHEST) {
				Chest chest = (Chest) b.getState();
				itemList.addAll(Arrays.asList(chest.getBlockInventory().getContents()));
				b.setType(Material.AIR);
				continue;
			}
			
			itemList.add(new ItemBuilders(b.getType()).buildItem());
			b.setType(Material.AIR);
		}
		
	}
}