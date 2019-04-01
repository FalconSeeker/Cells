package me.falconseeker.cells;

import org.bukkit.entity.Player;

import me.falconseeker.cells.cell.Cell;
import me.falconseeker.cells.cell.CellManager;
import net.md_5.bungee.api.ChatColor;

public class CellsAPI {

	private CellManager cellManager;
	
	public CellsAPI(CellPlugin main) {
		this.cellManager = main.getCellManager();
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

	public void rentCell(Player p, Cell cell) {
		if (cell.getOwner() != null) {
			p.sendMessage(ChatColor.RED + "A player already owns this cell!");
			return;
		}
		if (!canRent(p)) {
			p.sendMessage(ChatColor.RED + "You cannot rent more cells!");
			return;
		}
		cell.setOwner(p.getUniqueId());
		p.sendMessage(ChatColor.GREEN + "You have rented this cell!");
	}

	public void unRentCell(Player p, Cell cell) {
		if (!cell.getOwner().equals(p.getUniqueId())) {
			p.sendMessage(ChatColor.RED + "You do not own this cell!");
			return;
		}
		cell.setOwner(null);
	}
}