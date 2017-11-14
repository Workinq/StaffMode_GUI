package kr.kieran.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly in-game players can use this command.");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("heal")) {
			p.setHealth(20);
			p.setFoodLevel(20);
			p.sendMessage("§c§lStaff §r§8>> §aYou have been §c§lhealed§r§a.");
			for (PotionEffect effect : p.getActivePotionEffects())
				p.removePotionEffect(effect.getType());
			return true;
		}
		return true;
	}
}
