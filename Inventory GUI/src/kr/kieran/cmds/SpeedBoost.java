package kr.kieran.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedBoost implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly in-game players can use this command.");
			return true;
		}

		Player p = (Player) sender;

		if (!sender.hasPermission("staffmode.effects.speed")) {
			sender.sendMessage("§cYou do not have permission to use this command.");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("speed")) {
			if (p.hasPotionEffect(PotionEffectType.SPEED)) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.sendMessage("§c§lStaff §r§8>> §aYour §c§lspeed boost §r§ahas been §c§lenabled§r§a.");
				return true;
			} else {
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 86400, 2));
				p.sendMessage("§c§lStaff §r§8>> §aYour §c§lspeed boost §r§ahas been §c§ldisabled§r§a.");
				return true;
			}
		}
		return true;
	}
}
