package kr.kieran.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodMode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly in-game players can use this command.");
			return true;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("staffmode.god")) {
			sender.sendMessage("§cYou do not have permission to use this command.");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("god")) {
			if (!p.isInvulnerable()) {
				p.setInvulnerable(true);
				p.sendMessage("§c§lStaff §r§8>> §aYour §c§lgod mode §r§ahas been §c§lenabled§r§a.");
				return true;
			} else {
				p.setInvulnerable(false);
				p.sendMessage("§c§lStaff §r§8>> §aYour §c§lgod mode §r§ahas been §c§ldisabled§r§a.");
				return true;
			}
		}
		return true;

	}
}