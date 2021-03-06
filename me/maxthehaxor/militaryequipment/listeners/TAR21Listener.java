package me.maxthehaxor.militaryequipment.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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

public class TAR21Listener extends Weapon implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		ItemStack ak47 = new ItemStack (Material.IRON_HORSE_ARMOR);
		ItemMeta ak47meta =  ak47.getItemMeta();
		ak47meta.setDisplayName(ChatColor.GOLD + "TAR-21");
		ak47.setItemMeta(ak47meta);
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (pi.getItemInMainHand().equals(ak47)) {
				Snowball s = p.launchProjectile(Snowball.class);
				Player pl = (Player) s.getShooter();
				s.setCustomName(ChatColor.GOLD + "TAR-21 Bullet");
				s.getWorld().playSound(pl.getLocation(), Sound.ENTITY_ARROW_SHOOT, 2.0F, 1.0F);
				s.setVelocity(pl.getLocation().getDirection().multiply(6.0));
			}
			else
			{
				return;
			}
		}
	}
	@EventHandler
	public void onEntityHit(EntityDamageByEntityEvent event) {
		Entity d = event.getDamager();
		Entity e = event.getEntity();
		
		if (!(d instanceof Snowball)) return;
		if (d.getCustomName() == null) return;
		if (!(d.getCustomName().equals(ChatColor.GOLD + "TAR-21 Bullet"))) return;
		if (e instanceof LivingEntity) {
			Location loc = ((LivingEntity) e).getEyeLocation();
			if (d.getLocation() == loc) {
				((LivingEntity) e).setHealth(0);
			}
		}
		
		event.setDamage(8.0);
	}
}