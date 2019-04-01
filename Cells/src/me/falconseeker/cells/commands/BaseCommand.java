package me.falconseeker.cells.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.falconseeker.cells.CellPlugin;
 
public class BaseCommand implements ICommand
{
 
    @Override
    public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, CellPlugin main) {        
        p.sendMessage(ChatColor.GREEN + "Plugin made by Falcon_Seeker");
        return true;
    }
}