package com.utaria.utariahub.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.utaria.utariaapi.menus.VirtualMenu;
import com.utaria.utariaapi.menus.VirtualMenuItem;
import com.utaria.utariaapi.menus.VirtualMenuItemClick;
import com.utaria.utariahub.UtariaHub;

public class VirtualShopMenu extends VirtualMenu{

	public VirtualShopMenu() {
		super("§0La boutique d'Utaria - §10 UC", 3);
	}
	
	
	public void load(final Player p){
		VirtualMenuItem buyonline = new VirtualMenuItem("§6§l§kkk§r §e§lBoutique en ligne§r §6§l§kkk§r", Material.GOLD_NUGGET);
		
		buyonline.setDescriptions(Arrays.asList(" ", "§aAchetez plus de coins !", "§2§lCliquez-ici !"));
		buyonline.setItemClickBehavior(new VirtualMenuItemClick() {@Override public void onClick(Player arg0) {Bukkit.getScheduler().runTask(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
			close(p);
			
			p.sendMessage(" ");
			p.sendMessage("§e >> Adresse de la boutique: §6http://boutique.utaria.com/§e <<");
			p.sendMessage(" ");
			p.playSound(p.getLocation(), Sound.CAT_MEOW, 1f, 1f);
		}});}});
		
		addItem(26, buyonline);
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
		
		open(p);
	}

}
