package me.falconseeker.cells.commands;

import org.bukkit.entity.Player;

import me.falconseeker.cells.CellPlugin;

import org.bukkit.command.Command;
 
public interface ICommand  {
 
    public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, CellPlugin main);
 
}
