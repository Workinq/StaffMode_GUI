package kr.kieran;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import kr.kieran.cmds.Fly;
import kr.kieran.cmds.Gamemode;
import kr.kieran.cmds.GodMode;
import kr.kieran.cmds.Heal;
import kr.kieran.cmds.JumpBoost;
import kr.kieran.cmds.SpeedBoost;
import kr.kieran.cmds.StaffMode;
import kr.kieran.cmds.Vanish;
import kr.kieran.guis.GUI;
import kr.kieran.guis.PlayerOptionsGUI;
import kr.kieran.listeners.InteractListener;
import kr.kieran.listeners.JoinListener;
import kr.kieran.listeners.QuitListener;

public class InventoryGUI extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§a§lSatffMode GUI has been enabled.");

		registerEvents();
		registerCommands();
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§c§lStaffMode GUI has been disabled.");
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new GUI(), this);
		pm.registerEvents(new PlayerOptionsGUI(), this);
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new InteractListener(), this);
	}
	
	public void registerCommands() {
		getCommand("staffmode").setExecutor(new StaffMode());
		getCommand("fly").setExecutor(new Fly());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("speed").setExecutor(new SpeedBoost());
		getCommand("jump").setExecutor(new JumpBoost());
		getCommand("god").setExecutor(new GodMode());
		getCommand("heal").setExecutor(new Heal());
	}
}