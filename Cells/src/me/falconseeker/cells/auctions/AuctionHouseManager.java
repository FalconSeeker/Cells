package me.falconseeker.cells.auctions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import me.falconseeker.cells.CellPlugin;
import net.md_5.bungee.api.ChatColor;

public class AuctionHouseManager {

    private CellPlugin plugin;
    private FileConfiguration config;
    private Set<AuctionHouse> auctionSet;
    
    public AuctionHouseManager(CellPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.auctionSet = new HashSet<>();
    }

    
    public void loadAuctions() {
    	
        ConfigurationSection configSection = config.getConfigurationSection("auctions");        
        if(configSection != null) {
        	
        }
        plugin.saveDefaultConfig();

    }

    public void saveAuctions() {
    	String prefix = "Auctions.";
    	Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Loading Auctions - ");

        if(!auctionSet.isEmpty()) {
        
        	
        int totalProgress = auctionSet.size();
        int currentProgress = 0;
        
        for (AuctionHouse auction : auctionSet) {
        	Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "" + currentProgress + " / " + ChatColor.GRAY + "" + totalProgress);
        	plugin.getConfig().set(prefix + auction + ".group", auction.getGroup());
        	plugin.getConfig().set(prefix + auction + ".locations", auction.getLocationSet());
        }
        
        plugin.saveDefaultConfig();
        }
    }

    public AuctionHouse getAuction(Location location) {
        return auctionSet.stream().filter(auction -> auction.getLocationSet().contains(location)).findFirst().orElse(null);
    }
    public AuctionHouse getAuction(String group) {
        return auctionSet.stream().filter(auction -> auction.getGroup().equals(group)).findFirst().orElse(null);
    }
    public Set<AuctionHouse> getAuctions() {
        return Collections.unmodifiableSet(auctionSet);
    }
    public void addAuction(AuctionHouse auction) {
        this.auctionSet.add(auction);
    }
    public void removeAuction(AuctionHouse auction) {
        this.auctionSet.remove(auction);
    }
}