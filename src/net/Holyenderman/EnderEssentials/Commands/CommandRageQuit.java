package net.Holyenderman.EnderEssentials.Commands;

import net.Holyenderman.EnderEssentials.EnderEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRageQuit extends EnderEssentials implements CommandExecutor {
	
	public void CommandRagequit(EnderEssentials plugin){
    }
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if ((cmd.getName().equalsIgnoreCase("ragequit") || cmd.getName().equalsIgnoreCase("rq"))){
			if (args.length >= 1)
				{
				StringBuilder sb = new StringBuilder();
			
				for (int i = 0; i < args.length; i++)
					{
					sb.append(args[i]).append(" ");
					}
			    final Player p = (Player)sender;
				String rageReason = sb.toString().trim();
				Bukkit.broadcastMessage(ChatColor.GRAY + sender.getName() + ChatColor.DARK_RED + " ragequit from the server (" + ChatColor.RED + rageReason + ChatColor.DARK_RED  + ")" + ChatColor.RESET);
				p.kickPlayer("You ragequit from the server (" + rageReason + ")");
				}
			else
				{
				final Player p = (Player)sender;
				Bukkit.broadcastMessage(ChatColor.GRAY + sender.getName() + ChatColor.DARK_RED + " ragequit from the server (" + ChatColor.RED + "RageQuit" + ChatColor.DARK_RED  + ")" + ChatColor.RESET);
				p.kickPlayer("You ragequit from the server (RageQuit)");
				}
			return true;
		} 
		return false; 
	}

}
