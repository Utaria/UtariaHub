package com.utaria.utariahub.menus;

import org.bukkit.Material;

public enum MenusItems {

	COMPASS("§6Les modes de jeu", Material.WATCH),
	COSMENU("§bCoffre à cosmétique", Material.ENDER_CHEST),
	SHOPMENU("§aLa boutique", Material.EMERALD);
	
	
	private String text;
	private Material material;
	
	MenusItems(String text, Material material){
		this.text = text;
		this.material = material;
	}
	
	
	public String getText(){
		return this.text;
	}
	public Material getMaterial(){
		return this.material;
	}
	
}
