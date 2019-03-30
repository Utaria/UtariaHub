package com.utaria.utariahub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerWorldListener implements Listener{

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	
}
