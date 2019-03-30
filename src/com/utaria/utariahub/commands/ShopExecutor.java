package com.utaria.utariahub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.utaria.utariahub.menus.VirtualShopMenu;

public class ShopExecutor implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		
		VirtualShopMenu menu = new VirtualShopMenu();
		menu.load((Player) sender);
		
		return true;
	}

}
