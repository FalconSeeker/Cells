package me.falconseeker.cells.commands.subcommands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.falconseeker.cells.CellPlugin;
import me.falconseeker.cells.commands.ICommand;
import net.md_5.bungee.api.ChatColor;

public class CommandGroupAdd implements ICommand {

	@Override
	public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, CellPlugin main) {
		if (args.length < 1) {
			p.sendMessage(ChatColor.RED + "Args");
			return true;
		}
		
		return false;
	}

}
