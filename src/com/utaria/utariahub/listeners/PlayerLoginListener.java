package com.utaria.utariahub.listeners;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.utaria.utariaapi.PlayerInfo;
import com.utaria.utariaapi.utils.ScoreboardUtils;
import com.utaria.utariaapi.utils.TitleUtils;
import com.utaria.utariahub.Config;
import com.utaria.utariahub.UtariaHub;
import com.utaria.utariahub.menus.MenusItems;

public class PlayerLoginListener implements Listener{

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e){
		final Player p = e.getPlayer();
		
		// Give hub items
		final ItemStack compass  = new ItemStack(MenusItems.COMPASS.getMaterial());
		final ItemStack cosmenu  = new ItemStack(MenusItems.COSMENU.getMaterial());
		final ItemStack shopmenu = new ItemStack(MenusItems.SHOPMENU.getMaterial());
		
		ItemMeta im = compass.getItemMeta();
		im.setDisplayName(MenusItems.COMPASS.getText());
		compass.setItemMeta(im);
		
		im = cosmenu.getItemMeta();
		im.setDisplayName(MenusItems.COSMENU.getText());
		cosmenu.setItemMeta(im);
		
		im = shopmenu.getItemMeta();
		im.setDisplayName(MenusItems.SHOPMENU.getText());
		im.addEnchant(Enchantment.DURABILITY, 0, false);
		shopmenu.setItemMeta(im);
		
		
		Bukkit.getScheduler().runTaskLaterAsynchronously(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
			Bukkit.getScheduler().runTask(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
				p.getInventory().setItem(0, compass);
				p.getInventory().setItem(7, cosmenu);
				p.getInventory().setItem(8, shopmenu);
				
				p.updateInventory();
				
				
				p.setGameMode(GameMode.ADVENTURE);
				p.setHealth(20);
				p.setFoodLevel(20);
				p.setExp(0.0f);
				p.setLevel(0);
				
				String gradePrefix = PlayerInfo.get(p).getGradePrefix();
				String gradeName   = PlayerInfo.get(p).getGradeName();
				String gradeBoard  = (gradeName.equalsIgnoreCase("member")) ? "Aucun grade" : gradeName;
				
				ScoreboardUtils.defineTag(p, gradePrefix.substring(0, gradePrefix.length()-1));
				ScoreboardUtils.sendScoreboard(p, "§b§lUTARIA", Arrays.asList("§e", "§e§lCoins", "0", "§c", "§6§lGrade", gradeBoard, "§6", "§c§lSite internet", "§fwww.utaria.com"));
				
				TitleUtils.displayTabTitleToPlayer("§bUtaria §8- §6Alpha-test", "§emc.utaria.com", p);
				TitleUtils.displayTitleToPlayer("§b§lUtaria", "§6Amusez-vous bien !", p);
				
				// Prepare to spawn
				int level = PlayerInfo.get(p).getModerationLevel();
				
				if(level > 2){
					Bukkit.broadcastMessage(PlayerInfo.get(p).getGradePrefix() + p.getName() + "§r§e§o a rejoint le Hub !");
					
					p.setAllowFlight(true);
					p.setFlying(true);
				}
				
				Bukkit.getScheduler().runTaskLaterAsynchronously(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
					Bukkit.getScheduler().runTask(UtariaHub.getInstance(), new Runnable() {@Override public void run() {
						p.teleport(Config.spawn);
						p.setBedSpawnLocation(Config.spawn);
					}});
				}}, 5L);
			}});
		}}, 5L);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		e.setJoinMessage("");
	}
}
