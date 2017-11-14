package kr.kieran.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerOptionsVoids {

	public ArrayList<Player> vanished = new ArrayList<Player>();

	public void setHeal(Player p) {
		if (!p.hasPermission("staffmode.heal")) {
			p.sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		for (PotionEffect effect : p.getActivePotionEffects())
			p.removePotionEffect(effect.getType());
		p.setHealth(20);
		p.setFoodLevel(20);
		p.sendMessage("§c§lStaff §r§8>> §aYou have been §c§lhealed§r§a.");
		return;
	}

	public void setFlight(Player p) {
		if (!p.hasPermission("staffmode.flight")) {
			p.sendMessage("§cYou do not have permission to use this command!");
			return;
		}

		if (!p.getAllowFlight()) {
			p.setAllowFlight(true);
			p.sendMessage("§c§lStaff §r§8>> §aYour flight has been §c§lenabled§r§a.");
			return;
		} else {
			p.setAllowFlight(false);
			p.sendMessage("§c§lStaff §r§8>> §aYour flight has been §c§ldisabled§r§a.");
			return;
		}
	}

	public void setGameMode(Player p) {
		if (!p.hasPermission("staffmode.gamemode")) {
			p.sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		if (!(p.getGameMode() == GameMode.CREATIVE)) {
			p.setGameMode(GameMode.CREATIVE);
			p.sendMessage("§c§lStaff §r§8>> §aYour game mode has been updated to §c§lcreative§r§a.");
			return;
		} else {
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage("§c§lStaff §r§8>> §aYour game mode has been updated to §c§lsurvival§r§a.");
			return;
		}
	}

	public void setJumpBoost(Player p) {
		if (!p.hasPermission("staffmode.jumpboost")) {
			p.sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		if (!p.hasPotionEffect(PotionEffectType.JUMP)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 86400, 2));
			p.sendMessage("§c§lStaff §r§8>> §aYour §c§ljump boost §r§ahas been §c§lenabled§r§a.");
			return;
		} else {
			p.removePotionEffect(PotionEffectType.JUMP);
			p.sendMessage("§c§lStaff §r§8>> §aYour §c§ljump boost §r§ahas been §c§ldisabled§r§a.");
			return;
		}
	}

	public void setSpeedBoost(Player p) {
		if (!p.hasPermission("staffmode.speedboost")) {
			p.sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		if (!p.hasPotionEffect(PotionEffectType.SPEED)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 86400, 2));
			p.sendMessage("§c§lStaff §r§8>> §aYour §c§lspeed boost §r§ahas been §c§lenabled§r§a.");
			return;
		} else {
			p.removePotionEffect(PotionEffectType.SPEED);
			p.sendMessage("§c§lStaff §r§8>> §aYour §c§lspeed boost §r§ahas been §c§ldisabled§r§a.");
			return;
		}
	}

	public void setVanish(Player p) {
		if (!p.hasPermission("staffmode.vanish")) {
			p.sendMessage("§cYou do not have permission to use this command!");
			return;
		}

		if (!vanished.contains(p)) {
			for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
				pl.hidePlayer(p);
			}
			vanished.add(p);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 86400, 0));
			p.sendMessage("§c§lStaff §r§8>> §aYou have been §c§lvanished§r§a.");
			return;
		} else {
			for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
				pl.showPlayer(p);
			}
			vanished.remove(p);
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			p.sendMessage("§c§lStaff §r§8>> §aYou have been §c§lun-vanished§r§a.");
			return;
		}
	}

	public void setGod(Player p) {
		if (!p.hasPermission("staffmode.god")) {
			p.sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		if (!p.isInvulnerable()) {
			p.setInvulnerable(true);
			p.sendMessage("§c§lStaff §r§8>> §aYour §c§lgod mode §r§ahas been §c§lenabled§r§a.");
			return;
		} else {
			p.setInvulnerable(false);
			p.sendMessage("§c§lStaff §r§8>> §aYour §c§lgod mode §r§ahas been §c§ldisabled§r§a.");
			return;
		}
	}
}
