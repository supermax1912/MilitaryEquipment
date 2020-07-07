package me.maxthehaxor.militaryequipment.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.maxthehaxor.militaryequipment.Main;

public class Weapon implements Listener {
	
	ArrayList<Player> cool = new ArrayList<Player>();
	
	long cooldown;
	String name;
	double damage;
	Projectile proj;
	Player shooter;
	int timesToFire;

	public void fire(Class<? extends Projectile> p, long cooldown, String projName, Player shooter, double velocity, double dam, int timesFire) {
		if (cool.contains(shooter)) return;
		for (int i = 0; i < timesFire; i++) {
			Projectile project = shooter.launchProjectile(p);
			project.setVelocity(shooter.getLocation().getDirection().multiply(velocity));
			this.proj = project;
		}
		this.cooldown = cooldown;
		this.name = projName;
		
		if (cooldown == 0) return;
		cool.add(shooter);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(new Main(), new Runnable() {
			public void run() {
				cool.remove(shooter);
			}
		}, cooldown);
	}
	
	public void setWeaponDamage(double dam) {
		this.damage = dam;
	}
	
	public double getWeaponDamage() {
		return damage;
	}
	
	public void setCooldown(long cooldown) {
		this.cooldown = cooldown;
	}
	
	public long getCooldown() {
		return cooldown;
	}
	
	public void setProjectileName(String name) {
		this.name = name;
	}
	
	public String getProjectileName() {
		return name;
	}
	
	public Player getShooter() {
		return shooter;
	}
	
	
	
	@EventHandler
	public void onEntityHit(EntityDamageByEntityEvent event) {
		
	}
}
