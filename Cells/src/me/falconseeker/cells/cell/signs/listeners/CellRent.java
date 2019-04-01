package me.falconseeker.cells.cell.signs.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.falconseeker.cells.CellPlugin;
import me.falconseeker.cells.CellsAPI;
import me.falconseeker.cells.cell.Cell;
import me.falconseeker.cells.cell.CellManager;
import me.falconseeker.cells.utils.XTags;

public class CellRent implements Listener {

	private CellManager cellManager;
	private CellsAPI cellAPI;
	
	public CellRent(CellPlugin main) {
		this.cellManager = main.getCellManager();
		this.cellAPI = main.getAPI();
	}
	
	@EventHandler
	public void onClickEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		
		Block b = e.getClickedBlock();
		
		if (b.getType() != Material.SIGN) return;
		if (XTags.getBlockTag(b, "cell") == null) return;
		
		String tag = (String) XTags.getBlockTag(b, "cell");
		
		if (cellManager.getCell(tag) == null) return;
		
		Cell cell = cellManager.getCell(tag);
		
		if (p.isSneaking())	{
			cellAPI.unRentCell(p, cell);
			return;
		}
		cellAPI.rentCell(p, cell);
	}
}
