package me.falconseeker.cells;

import org.bukkit.plugin.java.JavaPlugin;

import me.falconseeker.cells.auctions.AuctionHouseManager;
import me.falconseeker.cells.cell.CellManager;
import me.falconseeker.cells.cell.signs.listeners.CellRent;
import me.falconseeker.cells.commands.*;
import me.falconseeker.cells.commands.subcommands.*;

public class CellPlugin extends JavaPlugin {

	private CellsAPI cellsAPI;
	private CellManager cellManager;
	private AuctionHouseManager auctionManager;
	
	@Override
	public void onEnable() {
		this.cellsAPI = new CellsAPI(this);
		this.cellManager = new CellManager(this);
		this.auctionManager = new AuctionHouseManager(this);
		
		new CellRent(this);
		
        CommandHandler handler = new CommandHandler(this);

        handler.register("cells", new BaseCommand());
        //handler.register("mute", new CommandClanMute());
        handler.register("sethologram", new CommandAddSign());
 
        getCommand("clan").setExecutor(handler);
        
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
	public AuctionHouseManager getAuctionManager() {
		return auctionManager;
	}
}
