package me.maxthehaxor.militaryequipment.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class M16Listener extends Weapon implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		ItemStack m16 = new ItemStack(Material.GOLDEN_HORSE_ARMOR);
		ItemMeta m16meta = m16.getItemMeta();
		m16meta.setDisplayName(ChatColor.RED + "M16");
		m16.setItemMeta(m16meta);
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (pi.getItemInMainHand().equals(m16)) {
				for (int i = 0; i < 2; i++) {
					
				}
				fire(Snowball.class, 0L, ChatColor.RED + "M16 Bullet", p, 3.0, 2.0, 2);
			}
		}
	}
}
