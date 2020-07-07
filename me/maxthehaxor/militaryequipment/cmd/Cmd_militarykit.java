package me.maxthehaxor.militaryequipment.cmd;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Cmd_militarykit implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
	
		//Checking if the sender is a player.
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be used by players.");
			return true;
		}
		
		Player p = (Player) sender;
		PlayerInventory pi = p.getInventory();
		
		// This just means if you put the command by itself.
		if (args.length == 0) {
			p.sendMessage(ChatColor.GREEN + "/mkit <trooper|soldier|sailor>");
		}
		
		// This is the object in the command
		if (args.length == 1) {
		// NOTE: Java starts on 0. This would be the first in the array of arguments.
		if (args[0].equalsIgnoreCase("emperor")) {
			if (!(sender.getName() == "MaxTheHaxor")) {
				sender.sendMessage(ChatColor.RED + "That is not a valid kit.");
				return true;
			}
			
			ItemStack dhat = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemStack dshirt = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemStack dpants = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
			ItemStack dshoes = new ItemStack(Material.DIAMOND_BOOTS, 1);
			ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemStack dpick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemStack daxe = new ItemStack(Material.DIAMOND_AXE, 1);
			ItemStack dshovel = new ItemStack(Material.DIAMOND_SHOVEL, 1);
			ItemStack dhoe = new ItemStack(Material.DIAMOND_HOE, 1);
			ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
			ItemStack godapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 64);
			
			ItemStack ak47 = new ItemStack (Material.IRON_HORSE_ARMOR, 1);
			ItemMeta ak47meta = ak47.getItemMeta();
			ak47meta.setDisplayName(ChatColor.GREEN + "AK-47");
			ak47.setItemMeta(ak47meta);
			
			dhat.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			dhat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
			dhat.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			dhat.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
			dhat.addUnsafeEnchantment(Enchantment.OXYGEN, 32767);
			dhat.addUnsafeEnchantment(Enchantment.WATER_WORKER, 31267);
			dhat.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dhat.getItemMeta().setUnbreakable(true);
			dshirt.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			dshirt.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
			dshirt.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			dshirt.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
			dshirt.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dshirt.getItemMeta().setUnbreakable(true);
			dpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			dpants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
			dpants.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			dpants.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
			dpants.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dpants.getItemMeta().setUnbreakable(true);
			dshoes.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			dshoes.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
			dshoes.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			dshoes.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
			dshoes.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 2);
			dshoes.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
			dshoes.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dshoes.getItemMeta().setUnbreakable(true);
			dsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 31267);
			dsword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 31267);
			dsword.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 31267);
			dsword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			dsword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			dsword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
			dsword.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dsword.getItemMeta().setUnbreakable(true);
			dpick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
			dpick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
			dpick.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dpick.getItemMeta().setUnbreakable(true);
			daxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
			daxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
			daxe.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			daxe.getItemMeta().setUnbreakable(true);
			dshovel.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
			dshovel.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
			dshovel.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dshovel.getItemMeta().setUnbreakable(true);
			dhoe.addUnsafeEnchantment(Enchantment.DURABILITY, 31267);
			dhoe.getItemMeta().setUnbreakable(true);
			
			pi.addItem(dhat);
			pi.addItem(dshirt);
			pi.addItem(dpants);
			pi.addItem(dshoes);
			pi.addItem(dsword);
			pi.addItem(dpick);
			pi.addItem(daxe);
			pi.addItem(dshovel);
			pi.addItem(dhoe);
			pi.addItem(ak47);
			pi.addItem(steak);
			pi.addItem(godapple);
			sender.sendMessage(ChatColor.GREEN + "Here's your kit, soldier!");
			return true;
			
			
			}
		if (args[0].equalsIgnoreCase("soldier")) {
			ItemStack lhat = new ItemStack(Material.LEATHER_HELMET, 1);
			ItemStack lshirt = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			ItemStack lpants = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			ItemStack lshoes = new ItemStack(Material.LEATHER_BOOTS, 1);
			ItemStack ak47 = new ItemStack (Material.IRON_HORSE_ARMOR, 1);
			ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
			
			ItemMeta ak47meta = ak47.getItemMeta();
			ak47meta.setDisplayName(ChatColor.GREEN + "AK-47");
			ak47.setItemMeta(ak47meta);
			
			LeatherArmorMeta lhatmeta = (LeatherArmorMeta) lhat.getItemMeta();
			LeatherArmorMeta lshirtmeta = (LeatherArmorMeta) lshirt.getItemMeta();
			LeatherArmorMeta lpantsmeta = (LeatherArmorMeta) lpants.getItemMeta();
			LeatherArmorMeta lshoesmeta = (LeatherArmorMeta) lshoes.getItemMeta();
			lhat.setItemMeta(lhatmeta);
			lshirt.setItemMeta(lshirtmeta);
			lpants.setItemMeta(lpantsmeta);
			lshoes.setItemMeta(lshoesmeta);
			lhatmeta.setColor(Color.GREEN);
			lshirtmeta.setColor(Color.GREEN);
			lpantsmeta.setColor(Color.GREEN);
			lshoesmeta.setColor(Color.GREEN);
			
			pi.addItem(lhat);
			pi.addItem(lshirt);
			pi.addItem(lpants);
			pi.addItem(lshoes);
			pi.addItem(ak47);
			pi.addItem(steak);
			
			p.sendMessage(ChatColor.GREEN + "Here's your kit, soldier!");
			return true;
		    }
		if (args[0].equalsIgnoreCase("trooper")) {
			ItemStack ihat = new ItemStack(Material.IRON_HELMET, 1);
			ItemStack ishirt = new ItemStack(Material.IRON_CHESTPLATE, 1);
			ItemStack ipants = new ItemStack(Material.IRON_LEGGINGS, 1);
			ItemStack ishoes = new ItemStack(Material.IRON_BOOTS, 1);
			ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
			
            ItemStack ak47 = new ItemStack (Material.IRON_HORSE_ARMOR, 1);
			ItemMeta ak47meta = ak47.getItemMeta();
			ak47meta.setDisplayName(ChatColor.GREEN + "AK-47");
			ak47.setItemMeta(ak47meta);
			
			ihat.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			ishirt.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			ipants.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			ishoes.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			ishoes.addEnchantment(Enchantment.PROTECTION_FALL, 1);
			
			pi.addItem(ihat);
			pi.addItem(ishirt);
			pi.addItem(ipants);
			pi.addItem(ishoes);
			pi.addItem(ak47);
			pi.addItem(steak);
			p.sendMessage(ChatColor.GREEN + "Here's your kit, soldier!");
			return true;
		    }
		
		if (args[0].equalsIgnoreCase("sailor")) {
			p.sendMessage(ChatColor.RED + "That is being worked on.");
			return true;
		}
		else {
			p.sendMessage("That is not a valid kit.");
			return true;
		}
		}	
		return true;
	}
	
	
}
