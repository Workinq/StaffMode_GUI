package kr.kieran.cmds;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vanish implements CommandExecutor {

	private ArrayList<Player> vanished = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly in-game players can use this command.");
			return true;
		}

		Player p = (Player) sender;

		if (!sender.hasPermission("staffmode.vanish")) {
			sender.sendMessage("§cYou do not have permission to use this command.");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("vanish")) {
			if (!vanished.contains(p)) {
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					pl.hidePlayer(p);
				}
				vanished.add(p);
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 86400, 0));
				p.sendMessage("§c§lStaff §r§8>> §aYou have been §c§lvanished§r§a.");
				p.closeInventory();
				return true;
			} else {
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					pl.showPlayer(p);
				}
				vanished.remove(p);
				p.removePotionEffect(PotionEffectType.INVISIBILITY);
				p.closeInventory();
				p.sendMessage("§c§lStaff §r§8>> §aYou have been §c§lunvanished§r§a.");
				return true;
			}
		}
		return true;
	}
}
