package com.goldbigdragon.rpg.event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Teleport
{
	public com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();
	public com.goldbigdragon.rpg.effect.Potion p = new com.goldbigdragon.rpg.effect.Potion();
	
	public void TeleportPlayer (Player player, String world, double X, double Y, double Z, float NEWS, float eye)
	{
		Location loc = new Location(Bukkit.getServer().getWorld(world), X, Y,Z, NEWS, eye);
		player.teleport(loc);
		p.givePotionEffect(player, PotionEffectType.BLINDNESS, 1, 15);
		s.SL(player.getLocation(), Sound.ENDERMAN_TELEPORT, 0.8F, 1.0F);
		return;
	}
}
