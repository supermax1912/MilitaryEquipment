package me.maxthehaxor.militaryequipment.listeners;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.maxthehaxor.militaryequipment.Main;

public class ShotgunListener extends Weapon implements Listener {
	
	ArrayList<Player> fired = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		ItemStack shotgun = new ItemStack(Material.GOLDEN_HORSE_ARMOR);
		ItemMeta shotgunmeta = shotgun.getItemMeta();
		shotgunmeta.setDisplayName(ChatColor.GOLD + "Shotgun");
		shotgun.setItemMeta(shotgunmeta);
		
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (pi.getItemInMainHand().equals(shotgun)) {
				if (fired.contains(p)) {
					return;
				}
				for (int i = 0; i < 5; i++) {
					Random rand = new Random();
					// Vectorize the location
					Vector vec = p.getLocation().getDirection();

					// Spread the snowballs randomly
					vec.setX(vec.getX() + rand.nextDouble() / 4 - .125);
					vec.setY(vec.getY() + rand.nextDouble() / 4 - .125);
					vec.setZ(vec.getZ() + rand.nextDouble() / 4 - .125);

					// Launch the snowball
					Snowball s = p.launchProjectile(Snowball.class, vec);
					Player pl = (Player) s.getShooter();
					s.setCustomName(ChatColor.GOLD + "Shotgun Bullet");
					s.getWorld().playSound(pl.getLocation(), Sound.ENTITY_WITHER_SHOOT, 2.0F, 2.0F);
					s.setVelocity(vec.multiply(3.0));
				}
				fired.add(p);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(new Main(), new Runnable() {
					public void run() {
						fired.remove(p);
					}
				}, 20);
			}
		}
	}
	
	@EventHandler
	public void onEntityHit(EntityDamageByEntityEvent event) {
		Entity d = event.getDamager();
		
		if (!(d instanceof Snowball)) return;
		if (d.getCustomName() == null) return;
		if (!(d.getCustomName().equals(ChatColor.GOLD + "Shotgun Bullet"))) return;
		
		event.setDamage(4.0);
	}
	
}