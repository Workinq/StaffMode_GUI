package kr.kieran.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!sender.hasPermission("staffmode.fly")) {
				sender.sendMessage("§cYou do not have permission to use this command.");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("fly")) {
				if (!p.getAllowFlight()) {
					p.setAllowFlight(true);
					p.closeInventory();
					p.sendMessage("§c§lStaff §r§8>> §aYour flight has been §c§lenabled§r§a.");
					return true;
				} else {
					p.setAllowFlight(false);
					p.closeInventory();
					p.sendMessage("§c§lStaff §r§8>> §aYour flight has been §c§ldisabled§r§a.");
					return true;
				}
			}
		}
		return true;
	}
}
