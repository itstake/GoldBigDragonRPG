﻿package com.goldbigdragon.rpg.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;


import com.goldbigdragon.rpg.Main;
import com.goldbigdragon.rpg.UserDataObject;

public class InventoryClose
{
	public void InventoryCloseRouter(InventoryCloseEvent event)
	{
		Player player = (Player) event.getPlayer();
		String InventoryName = event.getInventory().getTitle();
		if(InventoryName.contains("전체")&&InventoryName.contains("스킬")&&InventoryName.contains("목록")&&InventoryName.contains(" : ")&&
			((Main.UserData.get(player).getType()=="Job"&&Main.UserData.get(player).getString((byte)2) != null&&Main.UserData.get(player).getString((byte)3) != null)||
			Main.UserData.get(player).getType()=="Skill"&&Main.UserData.get(player).getString((byte)1)==null&&Main.UserData.get(player).getString((byte)2)==null
			&&Main.UserData.get(player).getString((byte)3)==null&&Main.UserData.get(player).getString((byte)4)==null))
			Main.UserData.get(player).clearAll();
		if(InventoryName.contains("전체") &&InventoryName.contains("지급")==false&&InventoryName.contains("[MapleStory]")==false&&InventoryName.contains("[Mabinogi]")==false
				&&InventoryName.contains("스킬")==false&&InventoryName.contains("영역")==false)
		{
			boolean ChooseQuestGUI = Boolean.parseBoolean(ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1)));
			if(ChooseQuestGUI==true)
				Main.UserData.get(player).setString((byte)1, null);
		}
		else if(InventoryName.contains("몬스터") == true)
		{InventoryClose_Monster(event, InventoryName);return;	}
		else if(InventoryName.contains("영역")||InventoryName.contains("블록을"))
		{InventoryClose_Area(event, InventoryName);return;}
		else if(InventoryName.contains("NPC")== true)
		{InventoryClose_NPC(event, InventoryName);return;}
		else if(InventoryName.contains("초심자")== true)
		{InventoryClose_NewBie(event, InventoryName);return;}
		if(player.isOp())
			if(Main.UserData.containsKey(player)==false)
				Main.UserData.put(player, new UserDataObject(player));
			else
				if(Main.UserData.get(player).getType() == "Quest")
				{
					InventoryClose_Quest(event, InventoryName, player);
					return;
				}
		return;
	}

	private void InventoryClose_Quest(InventoryCloseEvent event, String InventoryName, Player player)
	{
		if(Main.UserData.get(player).getString((byte)1)!=null)
		{
			if(Main.UserData.get(player).getString((byte)1)!=null
				&&Main.UserData.get(player).getString((byte)2)!=null
				&&Main.UserData.get(player).getString((byte)3)!=null)
			{
				com.goldbigdragon.rpg.gui.QuestGUI QGUI = new com.goldbigdragon.rpg.gui.QuestGUI();
				if(InventoryName.contains("모아야"))
				{
					QGUI.ItemAddInvnetoryClose(event);
    		    	Main.UserData.get(player).setBoolean((byte)1, false);
				}
				else if(InventoryName.contains("보상"))
				{
					QGUI.PresentAddInvnetoryClose(event);
				}
			}
			else if(InventoryName.contains("전체"))
			{
				Main.UserData.get(player).clearAll();
			}
			return;
		}
		return;
	}

	private void InventoryClose_Monster(InventoryCloseEvent event, String InventoryName)
	{
	    com.goldbigdragon.rpg.etc.Monster MC = new com.goldbigdragon.rpg.etc.Monster();
		if(InventoryName.contains("장비") == true)
			MC.InventorySetting(event);
		return;
	}
	
	private void InventoryClose_Area(InventoryCloseEvent event, String InventoryName)
	{
	    com.goldbigdragon.rpg.etc.Area A = new com.goldbigdragon.rpg.etc.Area();
		 if(InventoryName.contains(ChatColor.stripColor("블록을")) == true)
			A.BlockItemSettingInventoryClose(event);
		 else if(InventoryName.contains(ChatColor.stripColor("어류")) == true)
			A.FishingSettingInventoryClose(event);
		return;
	}
	
	private void InventoryClose_NPC(InventoryCloseEvent event, String InventoryName)
	{
	    com.goldbigdragon.rpg.etc.NPC NP = new com.goldbigdragon.rpg.etc.NPC();
		 if(InventoryName.contains(ChatColor.stripColor("룬")) == true)
			 NP.InventoryClose_NPC(event);
		return;
	}

	private void InventoryClose_NewBie(InventoryCloseEvent event,String InventoryName)
	{
	    com.goldbigdragon.rpg.gui.NewBieGUI NGUI = new com.goldbigdragon.rpg.gui.NewBieGUI();
		 if(InventoryName.contains(ChatColor.stripColor("가이드"))
			 ||InventoryName.contains(ChatColor.stripColor("지원")))
			 NGUI.InventoryClose_NewBie(event);
		return;
	}
	
}
