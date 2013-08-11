package net.Holyenderman.EnderEssentials.Commands;

import java.util.Random;

import net.Holyenderman.EnderEssentials.EnderEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.util.Vector;

public class CommandSlap extends EnderEssentials implements CommandExecutor, Listener  {
	private boolean isSlapped = false;
	
	public void slapTarget(Player target) {
		    Random randomGen = new Random();
		    Vector newVelocity = new Vector((randomGen.nextFloat() * 1.5D - 0.75D) * 20, randomGen.nextFloat() / 2.5D + 0.4D * 18, (randomGen.nextFloat() * 1.5D - 0.75D) * 15);
		    target.setVelocity(newVelocity);

		  }

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("slap")) {
			if (args[0] == null)
			{
				sender.sendMessage(ChatColor.RED + "Enter a player name!" + ChatColor.RESET);
			}
				Player targetplayer = Bukkit.getServer().getPlayer(args[0]);
				if (targetplayer.isOnline())
				{
					if (targetplayer.getName() == sender.getName())
					{
						sender.sendMessage(ChatColor.RED + "You can't slap yourself... What's wrong with you?!?" + ChatColor.RESET);
						return true;
					}
				slapTarget(targetplayer);
				String target = targetplayer.getName();
				Bukkit.broadcastMessage(ChatColor.GRAY + target + ChatColor.RED + " was slapped sky high by " + ChatColor.GRAY + sender.getName() + ChatColor.RESET);
				isSlapped = true;
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "That player is not online.");
				}
			return true;
		} 
		return false; 
	}
	 @EventHandler
	 public void onEntityDamage(EntityDamageEvent event){
			if(!(event.getEntity() instanceof Player)) return;
			if(event.getCause().equals(DamageCause.FALL) && (isSlapped == true)) {
				event.setCancelled(true);
			}
	 }
}
