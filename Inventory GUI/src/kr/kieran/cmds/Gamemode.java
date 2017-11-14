package kr.kieran.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly in-game players can use this command.");
			return true;
		}

		Player p = (Player) sender;
		
		if (!sender.hasPermission("staffmode.gamemode")) {
			sender.sendMessage("§cYou do not have permission to use this command.");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("gamemode")) {
			if (args.length == 0) {
				sender.sendMessage(
						"§cCorrect command usage: /gamemode <survival | creative | adventure | spectator>");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")
						|| args[0].equalsIgnoreCase("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§c§lStaff §r§8>> §aYour game mode has been updated to §lsurvival§r§a.");
					return true;
				} else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")
						|| args[0].equalsIgnoreCase("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§c§lStaff §r§8>> §aYour game mode has been updated to §lcreative§r§a.");
					return true;
				} else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")
						|| args[0].equalsIgnoreCase("2")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§c§lStaff §r§8>> §aYour game mode has been updated to §ladventure§r§a.");
					return true;
				} else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§c§lStaff §r§8>> §aYour game mode has been updated to §lspectator§r§a.");
					return true;
				} else {
					p.sendMessage(
							"§cCorrect command usage: /gamemode <survival | creative | adventure | spectator>");
					return true;
				}
			}
		}
		return true;
	}
}