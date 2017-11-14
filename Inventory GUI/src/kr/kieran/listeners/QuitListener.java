package kr.kieran.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import kr.kieran.guis.PlayerOptionsVoids;

public class QuitListener implements Listener {

	public PlayerOptionsVoids voids = new PlayerOptionsVoids();

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (!voids.vanished.contains(e.getPlayer()))
			return;
		voids.vanished.remove(e.getPlayer());
	}
}
