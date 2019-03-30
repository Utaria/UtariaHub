package com.utaria.utariahub.menus;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.utaria.utariaapi.menus.VirtualMenu;

public class VirtualCosmeticsMenu extends VirtualMenu{

	public VirtualCosmeticsMenu(String title, Integer rows) {
		super(title, rows);
	}

	public void load(final Player p){
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
		
		open(p);
	}
	
}
