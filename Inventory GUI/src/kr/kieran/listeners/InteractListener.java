package kr.kieran.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import kr.kieran.guis.GUI;

public class InteractListener implements Listener {

	public GUI gui = new GUI();

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack is = e.getItem();

		if (a == Action.PHYSICAL || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK || is == null
				|| is.getType() == Material.AIR)
			return;

		if (is.getType() == Material.COMPASS)
			gui.openGUI(e.getPlayer());
		return;
	}
}
