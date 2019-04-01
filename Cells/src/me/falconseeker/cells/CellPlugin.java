package me.falconseeker.cells;

import org.bukkit.plugin.java.JavaPlugin;

import me.falconseeker.cells.cell.CellManager;

public class CellPlugin extends JavaPlugin {

	private CellsAPI cellsAPI;
	private CellManager cellManager;
	
	@Override
	public void onEnable() {
		this.cellsAPI = new CellsAPI(this);
		this.cellManager = new CellManager(this);
	}
	@Override
	public void onDisable() {
		
	}
	
	public CellsAPI getAPI() {
		return cellsAPI;
	}
	public CellManager getCellManager() {
		return cellManager;
	}
}
