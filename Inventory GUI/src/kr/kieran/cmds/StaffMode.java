package kr.kieran.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kr.kieran.guis.GUI;

public class StaffMode implements CommandExecutor {

	public GUI gui = new GUI();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!sender.hasPermission("staffmode.gui")) {
				sender.sendMessage("§cYou do not have permission to use this command.");
				return true;
			}
			if (args.length == 0) {
				if (cmd.getName().equalsIgnoreCase("staffmode")) {
					gui.openGUI(p);
					return true;
				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("give")) {
					gui.giveCompass(p);
					return true;
				}
			}
		}
		return true;
	}

}
