package com.utaria.utariahub;

import org.bukkit.plugin.java.JavaPlugin;

import com.utaria.utariaapi.managers.FlagManager;
import com.utaria.utariaapi.managers.FlagManager.FlagType;
import com.utaria.utariaapi.managers.FlagManager.FlagValue;
import com.utaria.utariahub.commands.ShopExecutor;
import com.utaria.utariahub.listeners.PlayerFoodListener;
import com.utaria.utariahub.listeners.PlayerInventoryListener;
import com.utaria.utariahub.listeners.PlayerLoginListener;
import com.utaria.utariahub.listeners.PlayerWorldListener;

public class UtariaHub extends JavaPlugin{
	
	private static UtariaHub instance;

	public void onEnable(){
		instance = this;
			
		loadFlags();
		
		// Load listeners
		getServer().getPluginManager().registerEvents(new PlayerLoginListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInventoryListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerFoodListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerWorldListener(), this);
		
		// Load commands
		getCommand("shop").setExecutor(new ShopExecutor());
	}
	
	public void onDisable(){
		
	}
	
	
	public void loadFlags(){
		FlagManager.setFlag(FlagType.PVP, FlagValue.DENY);
		FlagManager.setFlag(FlagType.WEATHER, FlagValue.SUN);
		FlagManager.setFlag(FlagType.TIME, FlagValue.DAY);
		FlagManager.setFlag(FlagType.BLOCK_BREAK, FlagValue.DENY);
		FlagManager.setFlag(FlagType.BLOCK_PLACE, FlagValue.DENY);
	}
	
	
	
	public static UtariaHub getInstance(){
		return instance;
	}
}
