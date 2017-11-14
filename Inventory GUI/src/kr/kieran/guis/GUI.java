package kr.kieran.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI implements Listener {
	
	public PlayerOptionsGUI playerOptionsGUI = new PlayerOptionsGUI();

	public void giveCompass(Player p) {
		if (!p.hasPermission("staffmode.gui")) {
			p.sendMessage("§You do not have permission to use this command.");
			return;
		}
		ArrayList<String> compassLore = new ArrayList<String>();
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta compassMeta = compass.getItemMeta();
		compassMeta.setDisplayName("§c§lStaff GUI");
		compassLore.add("§7Right click to open");
		compassLore.add("§7the staff mode GUI.");
		compassMeta.setLore(compassLore);
		compass.setItemMeta(compassMeta);

		p.getInventory().addItem(new ItemStack(compass));
	}

	public void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, "§c§lStaffMode §r§8>> §c§lMain Menu");
		
		ArrayList<String> playerLore = new ArrayList<String>();
		ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (byte)3);
		ItemMeta playerMeta = player.getItemMeta();

		playerMeta.setDisplayName("§a§lPlayer Options");
		playerLore.add("");
		playerLore.add("§7Click to open player options.");
		playerMeta.setLore(playerLore);
		player.setItemMeta(playerMeta);

		inv.setItem(0, player);

		p.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!e.getWhoClicked().hasPermission("staffmode.gui.use")) {
			e.getWhoClicked().sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		if (!e.getInventory().getName().equals("§c§lStaffMode §r§8>> §c§lMain Menu"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR
				|| !e.getCurrentItem().hasItemMeta()) {
			return;
		}

		switch (e.getCurrentItem().getType()) {

		case SKULL_ITEM:
			p.closeInventory();
			playerOptionsGUI.playerOptionsGUI(p);
			break;
		default:
			p.closeInventory();
			break;
		}
	}
}
