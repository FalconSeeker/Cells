package me.falconseeker.cells.cell;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.falconseeker.cells.CellPlugin;
import net.md_5.bungee.api.ChatColor;

public class CellManager {

    private CellPlugin plugin;
    private FileConfiguration config;
    private Set<Cell> cellSet;
    
    public CellManager(CellPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.cellSet = new HashSet<>();
    }

    
    public void serialise() {
    	
        ConfigurationSection configSection = config.getConfigurationSection("cells");        
        if(configSection != null) {
        	
        }
        plugin.saveDefaultConfig();

    }

    public void deserialise() {
    	Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Loading Cells - ");

        if(!cellSet.isEmpty()) {
        
        	
        int totalProgress = cellSet.size();
        int currentProgress = 0;
        int cellNumber = 0;
        
        for (Cell cell : cellSet) {
        	Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "" + Math.round(currentProgress) + "%");

        	cellNumber++;
        	currentProgress = (cellNumber / totalProgress) * 100;
        	
        	plugin.getConfig().set("cells." + cell.getId() + ".owner", cell.getOwner().toString());
        	plugin.getConfig().set("cells." + cell.getId() + ".home", cell.getHome());

        }
        
        plugin.saveConfig();

        plugin.saveDefaultConfig();
        }
    }

    public List<Cell> getCells(Player owner) {
        return cellSet.stream().filter(cell -> cell.getOwner().equals(owner.getUniqueId())).collect(Collectors.toList());
    }
    public Cell getCell(Location location) {
        return cellSet.stream().filter(cell -> cell.getLocationSet().contains(location)).findFirst().orElse(null);
    }
    public Cell getCell(String id) {
        return cellSet.stream().filter(cell -> cell.getId().equals(id)).findFirst().orElse(null);
    }
    public Set<Cell> getCells() {
        return Collections.unmodifiableSet(cellSet);
    }
    public void addCell(Cell cell) {
        this.cellSet.add(cell);
    }
    public void removeCell(Cell cell) {
        this.cellSet.remove(cell);
    }
}