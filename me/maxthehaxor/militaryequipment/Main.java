package me.maxthehaxor.militaryequipment;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.maxthehaxor.militaryequipment.cmd.Cmd_militarykit;
import me.maxthehaxor.militaryequipment.listeners.Ak47_Listener;
import me.maxthehaxor.militaryequipment.listeners.GrenadeListener;
import me.maxthehaxor.militaryequipment.listeners.RPGListener;
import me.maxthehaxor.militaryequipment.listeners.ShotgunListener;
import me.maxthehaxor.militaryequipment.listeners.TAR21Listener;

public class Main extends JavaPlugin {
	
//	private MilitaryKitMenu menu;
	
	public void onEnable() {
//		getConfig().options().copyDefaults(true);
//		saveConfig();
// Null for protection purposes.		if (!(getConfig().getString("code") == "null")) {
//			Bukkit.getServer().getLogger().severe("The code for MilitaryEquipment is either invalid or wrong.");
//			getServer().getPluginManager().disablePlugin(this);
//		}
//		menu = new MilitaryKitMenu(this);
		registerCommands();
		registerListeners();
		registerCrafting();
	}
	
	
	
	public void onDisable() {
		
	}
	
	private void registerCommands() {
		getCommand("militarykit").setExecutor(new Cmd_militarykit());
	}
	
	private void registerListeners() {
		Bukkit.getServer().getPluginManager().registerEvents(new Ak47_Listener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new TAR21Listener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new RPGListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ShotgunListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GrenadeListener(), this);
//		Bukkit.getServer().getPluginManager().registerEvents(menu, this);
	}
	
	private void registerCrafting() {
		Recipes r = new Recipes();
		
		r.ak47();
		r.tar21();
		r.coalOre();
		r.ironOre();
		r.goldOre();
		r.lapisOre();
		r.redstoneOre();
		r.diamondOre();
		r.emeraldOre();
		r.quartzOre();
		r.rpg();
	}

}
