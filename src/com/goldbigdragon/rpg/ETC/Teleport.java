﻿package com.goldbigdragon.rpg.etc;

import com.goldbigdragon.rpg.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;

public class Teleport
{
	public void CreateNewTeleportSpot(Player player, String TeleportName)
	{
		com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();

		if(player.isOp() == false)
		{
			s.SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
			player.sendMessage(ChatColor.RED + "[SYSTEM] : 해당 명령어를 실행하기 위해서는 관리자 권한이 필요합니다!");
			return;
		}
		else
		{
			YamlController GUI_YC = Main.GUI_YC;
			YamlManager TeleportList = GUI_YC.getNewConfig("Teleport/TeleportList.yml");
			
			Object[] teleportlist = TeleportList.getConfigurationSection("").getKeys(false).toArray();

			for(int count =0; count <teleportlist.length;count++)
			{
				if(teleportlist[count].toString().equalsIgnoreCase(TeleportName) == true)
				{
					s.SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
					player.sendMessage(ChatColor.RED + "[SYSTEM] : 해당 워프 지점은 이미 등록되어 있습니다!");
					return;
				}
			}
			TeleportList.set(TeleportName+".World", player.getLocation().getWorld().getName());
			TeleportList.set(TeleportName+".X", player.getLocation().getX());
			TeleportList.set(TeleportName+".Y", player.getLocation().getY());
			TeleportList.set(TeleportName+".Z", player.getLocation().getZ());
			TeleportList.set(TeleportName+".Pitch", player.getLocation().getPitch());
			TeleportList.set(TeleportName+".Yaw", player.getLocation().getYaw());
			TeleportList.set(TeleportName+".OnlyOpUse", true);
			TeleportList.saveConfig();
			
			s.SP(player, org.bukkit.Sound.CHICKEN_EGG_POP, 2.0F, 1.7F);
			player.sendMessage(ChatColor.GREEN + "[SYSTEM] : 현재 위치로 워프 지점이 등록되었습니다!");
			
			return;
	      }
	}
	
	public void setTeleportPermission(Player player, String TeleportSpotName)
	{
		if(player.isOp() == true)
		{
			YamlController GUI_YC = Main.GUI_YC;
			YamlManager TeleportList = GUI_YC.getNewConfig("Teleport/TeleportList.yml");
			
			Object[] teleportlist = TeleportList.getConfigurationSection("").getKeys(false).toArray();

			for(int count =0; count <teleportlist.length;count++)
			{
				if(teleportlist[count].toString().equalsIgnoreCase(TeleportSpotName) == true)
				{
					if(TeleportList.getBoolean(TeleportSpotName+".OnlyOpUse") == true)
					{
						TeleportList.set(TeleportSpotName+".OnlyOpUse", false);
						player.sendMessage(ChatColor.GREEN + "[SYSTEM] : 해당 지역은 일반 유저도 워프할 수 있게 되었습니다!");
					}
					else
					{
						TeleportList.set(TeleportSpotName+".OnlyOpUse", true);
						player.sendMessage(ChatColor.RED + "[SYSTEM] : 해당 지역은 일반 유저가 워프할 수 없게 되었습니다!");
						
					}
					TeleportList.saveConfig();
					new com.goldbigdragon.rpg.effect.Sound().SP(player, org.bukkit.Sound.CHICKEN_EGG_POP, 2.0F, 1.7F);
					return;
				}
			}
			new com.goldbigdragon.rpg.effect.Sound().SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
	  		player.sendMessage(ChatColor.RED+"[SYSTEM] : 해당 이름으로 등록된 워프 지점이 없습니다!");
	  		return;
		}
		else
		{
			new com.goldbigdragon.rpg.effect.Sound().SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
			player.sendMessage(ChatColor.RED + "[SYSTEM] : 해당 명령어를 실행하기 위해서는 관리자 권한이 필요합니다!");
			return;	
		}
	}
	
	
	public void RemoveTeleportList(Player player, String TeleportName)
	{
		if(player.isOp() == false)
		{
			new com.goldbigdragon.rpg.effect.Sound().SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
			player.sendMessage(ChatColor.RED + "[SYSTEM] : 해당 명령어를 실행하기 위해서는 관리자 권한이 필요합니다!");
			return;
		}
		else
		{
			YamlController GUI_YC = Main.GUI_YC;
			YamlManager TeleportList = GUI_YC.getNewConfig("Teleport/TeleportList.yml");
			
			Object[] teleportlist = TeleportList.getConfigurationSection("").getKeys(false).toArray();

			for(int count =0; count <teleportlist.length;count++)
			{
				if(teleportlist[count].toString().equalsIgnoreCase(TeleportName) == true)
				{
					TeleportList.removeKey(TeleportName+".World");
					TeleportList.removeKey(TeleportName+".X");
					TeleportList.removeKey(TeleportName+".Y");
					TeleportList.removeKey(TeleportName+".Z");
					TeleportList.removeKey(TeleportName+".Pitch");
					TeleportList.removeKey(TeleportName+".Yaw");
					TeleportList.removeKey(TeleportName+".OnlyOpUse");
					TeleportList.removeKey(TeleportName+"");
					TeleportList.saveConfig();

					new com.goldbigdragon.rpg.effect.Sound().SP(player,org.bukkit.Sound.ITEM_BREAK,0.7F,1.0F);
		    		player.sendMessage(ChatColor.GREEN+"[SYSTEM] : "+ChatColor.YELLOW+TeleportName+ChatColor.GREEN+" 워프 지점을 성공적으로 삭제하였습니다!");
					return;
				}
			}
			new com.goldbigdragon.rpg.effect.Sound().SP(player,org.bukkit.Sound.ITEM_BREAK,0.7F,1.0F);
	  		player.sendMessage(ChatColor.RED+"[SYSTEM] : 해당 이름으로 등록된 워프 지점이 없습니다!");
		}
		return;
	}
	
	public void TeleportUser(Player player, String TeleportSpotName)
	{
		com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();
		com.goldbigdragon.rpg.effect.Potion p = new com.goldbigdragon.rpg.effect.Potion();

		YamlController GUI_YC = Main.GUI_YC;
		YamlManager TeleportList = GUI_YC.getNewConfig("Teleport/TeleportList.yml");

		Object[] teleportlist = TeleportList.getConfigurationSection("").getKeys(false).toArray();

		for(int count =0; count <teleportlist.length;count++)
		{
			if(teleportlist[count].toString().equalsIgnoreCase(TeleportSpotName) == true)
			{
				if(TeleportList.getBoolean(TeleportSpotName+".OnlyOpUse")== true  && player.isOp() == false)
				{
					s.SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
					player.sendMessage(ChatColor.RED+"[SYSTEM] : 해당 구역은 제한된 지역입니다!");
					return;
				}
				else
				{
					s.SP(player, org.bukkit.Sound.ENDERMAN_TELEPORT, 0.8F, 1.0F);
					Location loc = new Location(Bukkit.getWorld(TeleportList.getString(TeleportSpotName+".World")), TeleportList.getInt(TeleportSpotName+".X")+0.5,  TeleportList.getInt(TeleportSpotName+".Y")+0.5,  TeleportList.getInt(TeleportSpotName+".Z")+0.5,  TeleportList.getInt(TeleportSpotName+".Yaw"),  TeleportList.getInt(TeleportSpotName+".Pitch"));
					player.teleport(loc);
					s.SP(player, org.bukkit.Sound.ENDERMAN_TELEPORT, 0.8F, 1.0F);
					p.givePotionEffect(player, PotionEffectType.BLINDNESS, 1, 15);
					return;
				}
			}
		}
		for(int counter=0;counter<Bukkit.getServer().getWorlds().size();counter++)
		{
			if(Bukkit.getServer().getWorlds().get(counter).getName().equalsIgnoreCase(TeleportSpotName))
			{
				if(player.isOp()==true)
				{
					s.SP(player, org.bukkit.Sound.ENDERMAN_TELEPORT, 0.8F, 1.0F);
					player.teleport(Bukkit.getServer().getWorld(TeleportSpotName).getSpawnLocation());
					p.givePotionEffect(player, PotionEffectType.BLINDNESS, 1, 15);
					s.SP(player, org.bukkit.Sound.ENDERMAN_TELEPORT, 0.8F, 1.0F);
					return;
				}
				else
				{
					s.SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
					player.sendMessage(ChatColor.RED+"[SYSTEM] : 월드간 이동은 관리자만 허용됩니다!");
				}
				return;
			}
		}
		s.SP(player,org.bukkit.Sound.ITEM_BREAK,0.7F,1.0F);
  		player.sendMessage(ChatColor.RED+"[SYSTEM] : 해당 이름으로 등록된 워프 지점이 없습니다!");
		return;
	}

	public void showTeleportList(Player player)
	{
		YamlController GUI_YC = Main.GUI_YC;
		YamlManager TeleportList = GUI_YC.getNewConfig("Teleport/TeleportList.yml");

		Object[] teleportlist = TeleportList.getConfigurationSection("").getKeys(false).toArray();
		if(teleportlist.length <= 0)
		{
			new com.goldbigdragon.rpg.effect.Sound().SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
			  player.sendMessage(ChatColor.RED+"[SYSTEM] : 현재 등록된 워프 장소가 없습니다!");
			  player.sendMessage("─────────────────────────");
			  String worldname="";
			  for(int count=0;count<Bukkit.getServer().getWorlds().size();count++)
			  {
				  worldname = worldname + Bukkit.getServer().getWorlds().get(count).getName()+"  ";
			  }
			  player.sendMessage(ChatColor.GOLD+"[월드] : "+worldname);
			  player.sendMessage("─────────────────────────");
			  return;
		}
		if(player.isOp() == false)
		{
			for(int count = 0; count < teleportlist.length; count++)
			{
				if(TeleportList.getBoolean(teleportlist[count].toString()+".OnlyOpUse") == true)
					  player.sendMessage(ChatColor.RED + "[이동 불가] " + ChatColor.DARK_GRAY + teleportlist[count].toString());
				else
					  player.sendMessage(ChatColor.GREEN + "[이동 가능] " + ChatColor.GRAY + teleportlist[count].toString());
			}
		}
		else
		{
			for(int count = 0; count < teleportlist.length; count++)
				  player.sendMessage(ChatColor.GREEN + "[이동 가능] " + ChatColor.GRAY + teleportlist[count].toString());
		}
		String worldname="";
		for(int count=0;count<Bukkit.getServer().getWorlds().size();count++)
				worldname = worldname +Bukkit.getServer().getWorlds().get(count).getName()+"  ";
		player.sendMessage(ChatColor.GOLD+"[월드] : "+worldname);
		player.sendMessage("─────────────────────────");
		return;
	}
}
