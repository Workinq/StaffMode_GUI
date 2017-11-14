package kr.kieran.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class PlayerOptionsGUI implements Listener {

	public PlayerOptionsVoids voids = new PlayerOptionsVoids();

	public void playerOptionsGUI(Player p) {
		Inventory i = Bukkit.createInventory(null, 54, "§c§lStaffMode §r§8>> §c§lPlayer Options");

		ArrayList<String> healLore = new ArrayList<String>();
		ItemStack heal = new ItemStack(Material.APPLE);
		ItemMeta healMeta = heal.getItemMeta();

		healMeta.setDisplayName("§c§lHeal");
		healLore.add("");
		healLore.add("§7Click to heal yourself.");
		healMeta.setLore(healLore);
		heal.setItemMeta(healMeta);

		ArrayList<String> flightLore = new ArrayList<String>();
		ItemStack flight = new ItemStack(Material.FEATHER);
		ItemMeta flightMeta = flight.getItemMeta();

		ArrayList<String> speedLore = new ArrayList<String>();
		ItemStack speed = new ItemStack(Material.SUGAR);
		ItemMeta speedMeta = speed.getItemMeta();

		ArrayList<String> jumpLore = new ArrayList<String>();
		ItemStack jump = new ItemStack(Material.POTION, 1, (byte) 8235);
		ItemMeta jumpMeta = jump.getItemMeta();

		ArrayList<String> gamemodeLore = new ArrayList<String>();
		ItemStack gamemode = new ItemStack(Material.GRASS);
		ItemMeta gamemodeMeta = gamemode.getItemMeta();

		ArrayList<String> vanishLore = new ArrayList<String>();
		ItemStack vanish = new ItemStack(Material.GLASS_BOTTLE);
		ItemMeta vanishMeta = vanish.getItemMeta();

		ArrayList<String> godLore = new ArrayList<String>();
		ItemStack god = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta godMeta = god.getItemMeta();

		flightMeta.setDisplayName("§f§lFlight");
		flightLore.add("");
		flightLore.add("§7Click to enable/disable flight.");
		flightMeta.setLore(flightLore);
		flight.setItemMeta(flightMeta);

		speedMeta.setDisplayName("§3§lSpeed Boost");
		speedLore.add("");
		speedLore.add("§7Click to enable/disable speed boost.");
		speedMeta.setLore(speedLore);
		speed.setItemMeta(speedMeta);

		jumpMeta.setDisplayName("§b§lJump Boost");
		jumpLore.add("");
		jumpLore.add("§7Click to enable/disable jump boost.");
		jumpMeta.setLore(jumpLore);
		jumpMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		jump.setItemMeta(jumpMeta);

		gamemodeMeta.setDisplayName("§a§lGamemode");
		gamemodeLore.add("");
		gamemodeLore.add("§7Click to switch between creative and survival.");
		gamemodeMeta.setLore(gamemodeLore);
		gamemode.setItemMeta(gamemodeMeta);

		vanishMeta.setDisplayName("§5§lVanish");
		vanishLore.add("");
		vanishLore.add("§7Click to enable/disable vanish.");
		vanishMeta.setLore(vanishLore);
		vanish.setItemMeta(vanishMeta);

		godMeta.setDisplayName("§6§lGod");
		godMeta.addEnchant(Enchantment.LURE, 1, true);
		godLore.add("");
		godLore.add("§7Click to enable/disable god mode.");
		godMeta.setLore(godLore);
		godMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		god.setItemMeta(godMeta);

		ItemStack on = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta onMeta = on.getItemMeta();
		onMeta.setDisplayName("§a§lEnabled");
		on.setItemMeta(onMeta);

		ItemStack off = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta offMeta = off.getItemMeta();
		offMeta.setDisplayName("§7§lDisabled");
		off.setItemMeta(offMeta);

		ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
		ItemMeta paneMeta = pane.getItemMeta();
		paneMeta.setDisplayName(" ");
		pane.setItemMeta(paneMeta);

		i.setItem(0, pane);
		i.setItem(1, pane);
		i.setItem(2, pane);
		i.setItem(3, pane);
		i.setItem(4, pane);
		i.setItem(5, pane);
		i.setItem(6, pane);
		i.setItem(7, pane);
		i.setItem(8, pane);
		i.setItem(9, pane);
		i.setItem(10, flight);
		if (p.getAllowFlight()) {
			i.setItem(19, on);
		} else {
			i.setItem(19, off);
		}
		i.setItem(11, pane);
		i.setItem(12, vanish);
		if (voids.vanished.contains(p)) {
			i.setItem(21, on);
		} else {
			i.setItem(21, off);
		}
		i.setItem(13, pane);
		i.setItem(14, jump);
		if (p.hasPotionEffect(PotionEffectType.JUMP)) {
			i.setItem(23, on);
		} else {
			i.setItem(23, off);
		}
		i.setItem(15, pane);
		i.setItem(16, speed);
		if (p.hasPotionEffect(PotionEffectType.SPEED)) {
			i.setItem(25, on);
		} else {
			i.setItem(25, off);
		}
		i.setItem(17, pane);
		i.setItem(18, pane);
		i.setItem(20, pane);
		i.setItem(22, pane);
		i.setItem(24, pane);
		i.setItem(26, pane);
		i.setItem(27, pane);
		i.setItem(28, pane);
		i.setItem(29, gamemode);
		i.setItem(40, god);
		if (p.isInvulnerable()) {
			i.setItem(49, on);
		} else {
			i.setItem(49, off);
		}
		i.setItem(30, pane);
		i.setItem(31, pane);
		i.setItem(32, pane);
		i.setItem(33, heal);
		i.setItem(34, pane);
		i.setItem(35, pane);
		i.setItem(36, pane);
		i.setItem(37, pane);
		i.setItem(38, pane);
		i.setItem(39, pane);
		i.setItem(41, pane);
		i.setItem(42, pane);
		i.setItem(43, pane);
		i.setItem(44, pane);
		i.setItem(45, pane);
		i.setItem(46, pane);
		i.setItem(47, pane);
		i.setItem(48, pane);
		i.setItem(50, pane);
		i.setItem(51, pane);
		i.setItem(52, pane);
		i.setItem(53, pane);

		p.openInventory(i);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!e.getWhoClicked().hasPermission("staffmode.gui.use")) {
			e.getWhoClicked().sendMessage("§cYou do not have permission to use this command.");
			return;
		}

		if (!e.getInventory().getName().equals("§c§lStaffMode §r§8>> §c§lPlayer Options"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR
				|| !e.getCurrentItem().hasItemMeta() || e.getCurrentItem().getType() == Material.INK_SACK
				|| e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
			return;
		}

		switch (e.getCurrentItem().getType()) {

		case FEATHER:
			p.closeInventory();
			voids.setFlight(p);
			break;
		case SUGAR:
			p.closeInventory();
			voids.setSpeedBoost(p);
			break;
		case POTION:
			p.closeInventory();
			voids.setJumpBoost(p);
			break;
		case GRASS:
			p.closeInventory();
			voids.setGameMode(p);
			break;
		case GLASS_BOTTLE:
			p.closeInventory();
			voids.setVanish(p);
			break;
		case GOLDEN_APPLE:
			p.closeInventory();
			voids.setGod(p);
			break;
		case APPLE:
			p.closeInventory();
			voids.setHeal(p);
			break;
		default:
			p.closeInventory();
			break;
		}
	}
}
