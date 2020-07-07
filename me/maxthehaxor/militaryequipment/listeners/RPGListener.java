package me.maxthehaxor.militaryequipment.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.maxthehaxor.militaryequipment.Main;

public class RPGListener extends Weapon implements Listener {
	
	ArrayList<Player> fired = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		ItemStack rpg = new ItemStack(Material.DIAMOND_HORSE_ARMOR);
		ItemMeta rpgmeta = rpg.getItemMeta();
		rpgmeta.setDisplayName(ChatColor.DARK_RED + "RPG");
		rpg.setItemMeta(rpgmeta);
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (pi.getItemInMainHand() == rpg) {
				if (fired.contains(p)) return;
				Fireball f = p.launchProjectile(Fireball.class);
				Player pl = (Player) f.getShooter();
				f.setCustomName(ChatColor.DARK_RED + "RPG Rocket");
				f.getWorld().playSound(pl.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0F, 1.0F);
				fired.add(pl);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(new Main(), new Runnable() {
					@Override
					public void run() {
						fired.remove(pl);
					}
				}, 60);
			}
			else {
				return;
			}
		}
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		Projectile p = event.getEntity();
		
		if (!(p instanceof Fireball)) return;
		if (p.getCustomName() == null) return;
		if (!(p.getCustomName() == ChatColor.DARK_RED + "RPG Rocket")) return;
		
		p.getWorld().createExplosion(p.getLocation(), 2.0F);
	}
}