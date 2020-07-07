package me.maxthehaxor.militaryequipment.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class GrenadeListener implements Listener {
	
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		ItemStack grenade = new ItemStack(Material.SNOWBALL);
		ItemMeta gmeta = grenade.getItemMeta();
		gmeta.setDisplayName(ChatColor.GOLD + "Grenade");
		grenade.setItemMeta(gmeta);
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (pi.getItemInMainHand().equals(grenade)) {
				Snowball s = p.launchProjectile(Snowball.class);
				s.setCustomName(ChatColor.GOLD + "Grenade");
				s.setBounce(true);
			}
			else
			{
				return;
			}
		}
	}
	
	public void onProjectileHit(ProjectileHitEvent event) {
		Projectile p = event.getEntity();
		if (!(p instanceof Snowball)) return;
		if (!(p.getCustomName() == null)) return;
		if (!(p.getCustomName() == ChatColor.GOLD + "Grenade")) return;
		
		p.getWorld().createExplosion(p.getLocation(), 1.0F);
	}

}