package kr.kieran.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import kr.kieran.guis.GUI;
import kr.kieran.guis.PlayerOptionsVoids;

public class JoinListener implements Listener {

	public GUI gui;
	public PlayerOptionsVoids voids;

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		if (!player.getInventory().contains(Material.COMPASS)) {
			gui.giveCompass(player);
		} else {
			return;
		}
		for (Player p : voids.vanished) {
			e.getPlayer().hidePlayer(p);
			return;
		}
	}

}
