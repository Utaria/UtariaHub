package com.utaria.utariahub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodListener implements Listener{
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
}
