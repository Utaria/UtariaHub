package com.utaria.utariahub.listeners;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.utaria.utariaapi.menus.VirtualMenu;
import com.utaria.utariaapi.menus.VirtualMenuItem;
import com.utaria.utariaapi.menus.VirtualMenuItemClick;
import com.utaria.utariahub.Config;
import com.utaria.utariahub.UtariaHub;
import com.utaria.utariahub.menus.MenusItems;
import com.utaria.utariahub.menus.VirtualCosmeticsMenu;
import com.utaria.utariahub.menus.VirtualShopMenu;

public class PlayerInventoryListener implements Listener{

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(!(e.getWhoClicked() instanceof Player)) return;
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getItem() == null) return;
		
		final Player p = e.getPlayer();
		ItemStack i = e.getItem();
		
		for(MenusItems item : MenusItems.values()){
			if(i.getType().equals(item.getMaterial()) && i.getItemMeta().getDisplayName().equalsIgnoreCase(item.getText())){
				
				if(i.getType().equals(Material.WATCH)){ // Menu des modes de jeu
					VirtualMenu menu = new VirtualMenu("§0Les modes de jeu", 3);
					
					VirtualMenuItem worlds = new VirtualMenuItem("§6Worlds", Material.GRASS);
					worlds.setDescriptions(Arrays.asList(" ", "§7Survivez dans des mondes", "§7aléatoires et parcemés d'embûches !", "§7Devenez le plus fort et", "§7le plus aventurier !", " ", "§fRejoignez les §a0 §fjoueurs."));
					worlds.setItemClickBehavior(new VirtualMenuItemClick() {@Override public void onClick(Player arg0) {Bukkit.getScheduler().runTask(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
						p.teleport(Config.worldsPlace);
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					}});}});
					
					VirtualMenuItem onevsone = new VirtualMenuItem("§61 VS 1", Material.DIAMOND_SWORD);
					onevsone.setDescriptions(Arrays.asList(" ", "§7Devenez un vrai combattant", "§7en terminant des défis PVP", "§7plus épiques les uns", "§7que les autres !", " ", "§fRejoignez les §a0 §fjoueurs."));
					onevsone.setItemClickBehavior(new VirtualMenuItemClick() {@Override public void onClick(Player arg0) {Bukkit.getScheduler().runTask(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
						p.teleport(Config.oneVsOnePlace);
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					}});}});
					
					VirtualMenuItem arcade = new VirtualMenuItem("§6Jeux arcade", Material.GOLDEN_APPLE);
					arcade.setDescriptions(Arrays.asList(" ", "§7Venez vous divertir en", "§7jouant à nos jeux originaux", "§7et pleins de fun !", " ", "§fRejoignez les §a0 §fjoueurs."));
					arcade.setItemClickBehavior(new VirtualMenuItemClick() {@Override public void onClick(Player arg0) {Bukkit.getScheduler().runTask(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
						p.teleport(Config.arcadePlace);
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					}});}});
					
					
					menu.addItem(11, worlds);
					menu.addItem(13, onevsone);
					menu.addItem(15, arcade);
					
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
					menu.open(p);
				}
				
			}else if(i.getType().equals(Material.ENDER_CHEST)){ // Menu des cosmétiques
				VirtualCosmeticsMenu menu = new VirtualCosmeticsMenu("§0Le coffre à cosmétique", 3);
				menu.load(p);
			}else if(i.getType().equals(Material.EMERALD)){  // Menu de la boutique
				VirtualShopMenu menu = new VirtualShopMenu();
				menu.load(p);
			}
		}
		
	}
	
}
