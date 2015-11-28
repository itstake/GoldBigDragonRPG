﻿package com.goldbigdragon.rpg.gui;

import java.util.Arrays;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.goldbigdragon.rpg.Main;
import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;

public class EventGUI extends GUIutil
{
	public void EventGUI_Main (Player player)
	{
		YamlController GUI_YC = Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "이벤트 진행");
		
		if(Config.getInt("Event.Multiple_Level_Up_SkillPoint") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "스킬 포인트 추가 획득", 340,0,1,Arrays.asList(ChatColor.RED + "[비 활성화]",ChatColor.GRAY + "레벨 업당 얻는 스킬 포인트 : " + Config.getInt("Server.Level_Up_SkillPoint")), 10, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "스킬 포인트 추가 획득", 403,0,Config.getInt("Event.Multiple_Level_Up_SkillPoint"),Arrays.asList(ChatColor.GREEN + "[활성화]",ChatColor.YELLOW +""+Config.getInt("Event.Multiple_Level_Up_SkillPoint") +ChatColor.GRAY +"배",ChatColor.GRAY + "레벨 업당 얻는 스킬 포인트 : " + (Config.getInt("Server.Level_Up_SkillPoint") * Config.getInt("Event.Multiple_Level_Up_SkillPoint"))), 10, inv);}	}

		if(Config.getInt("Event.Multiple_Level_Up_StatPoint") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "스텟 포인트 추가 획득", 351,15,1,Arrays.asList(ChatColor.RED + "[비 활성화]",ChatColor.GRAY + "레벨 업당 얻는 스텟 포인트 : " + Config.getInt("Server.Level_Up_StatPoint")), 12, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "스텟 포인트 추가 획득", 399,0,Config.getInt("Event.Multiple_Level_Up_StatPoint"),Arrays.asList(ChatColor.GREEN + "[활성화]",ChatColor.YELLOW +""+Config.getInt("Event.Multiple_Level_Up_StatPoint") +ChatColor.GRAY +"배",ChatColor.GRAY + "레벨 업당 얻는 스텟 포인트 : " + (Config.getInt("Server.Level_Up_StatPoint")*Config.getInt("Event.Multiple_Level_Up_StatPoint"))), 12, inv);}	}

		if(Config.getInt("Event.Multiple_EXP_Get") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "경험치 추가 획득", 374,0,1,Arrays.asList(ChatColor.RED + "[비 활성화]",ChatColor.GRAY + "경험치 획득률 : " + Config.getInt("Event.Multiple_EXP_Get")+"배"), 14, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "경험치 추가 획득", 384,0,Config.getInt("Event.Multiple_EXP_Get"),Arrays.asList(ChatColor.GREEN + "[활성화]",ChatColor.GRAY + "경험치 획득률 : "+ChatColor.YELLOW +""+Config.getInt("Event.Multiple_EXP_Get") +ChatColor.GRAY +"배"), 14, inv);}	}
		
		if(Config.getInt("Event.DropChance") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "드롭률 향상", 265,0,1,Arrays.asList(ChatColor.RED + "[비 활성화]",ChatColor.GRAY + "드롭률 : " + Config.getInt("Event.DropChance")+"배"), 16, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "드롭률 향상", 266,0,Config.getInt("Event.DropChance"),Arrays.asList(ChatColor.GREEN + "[활성화]",ChatColor.GRAY + "드롭률 : "+ChatColor.YELLOW +""+Config.getInt("Event.DropChance") +ChatColor.GRAY +"배"), 16, inv);}	}
		
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "전체 주기", 54,0,1,Arrays.asList(ChatColor.GRAY + "현재 접속한 모든 유저에게",ChatColor.GRAY+"아이템을 선물합니다."), 28, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "랜덤 주기", 130,0,1,Arrays.asList(ChatColor.GRAY + "현재 접속한 유저들 중,",ChatColor.GRAY+"한 사람에게만 지정된",ChatColor.GRAY+"아이템을 선물합니다."), 30, inv);

		
		Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "이전 목록", 323,0,1,Arrays.asList(ChatColor.GRAY + "작업 관리자 메뉴로 돌아갑니다."), 36, inv);

		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "닫기", 324,0,1,Arrays.asList(ChatColor.GRAY + "작업 관리자 창을 닫습니다."), 44, inv);
		
		player.openInventory(inv);
	}

	public void AllPlayerGiveEventGUI(Player player, boolean All)
	{
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "이벤트 전체 지급");
		if(All==false)
			inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "이벤트 랜덤 지급");
		for(int count = 0; count <10;count++)
			Stack2(ChatColor.YELLOW+"[ 지급 할 아이템 ]", 160, 4, 1, null, count, inv);
		Stack2(ChatColor.YELLOW+"[ 지급 할 아이템 ]", 160, 4, 1, null, 17, inv);
		Stack2(ChatColor.YELLOW+"[ 지급 할 아이템 ]", 160, 4, 1, null, 18, inv);
		for(int count = 26; count <36;count++)
			Stack2(ChatColor.YELLOW+"[ 지급 할 아이템 ]", 160, 4, 1, null, count, inv);

		for(int count = 36; count <44;count++)
			Stack2(ChatColor.YELLOW+" ", 160, 8, 1, null, count, inv);

		if(All)
			Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "[지급 개시!]", 54,0,1,Arrays.asList(ChatColor.GRAY + "노란 테두리 속의 아이템을",ChatColor.GRAY+"모든 플레이어에게 지급합니다!"), 40, inv);
		else
			Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "[지급 개시!]", 130,0,1,Arrays.asList(ChatColor.GRAY + "노란 테두리 속의 아이템을",ChatColor.GRAY+"누가 받을지 모릅니다!"), 40, inv);
			
		Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "이전 목록", 323,0,1,Arrays.asList(ChatColor.GRAY + "이벤트 메뉴로 돌아갑니다."), 36, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "닫기", 324,0,1,Arrays.asList(ChatColor.GRAY + "작업 관리자 창을 닫습니다."), 44, inv);
		player.openInventory(inv);
	}
	
	
	
	
	//각종 GUI창 속의 아이콘을 눌렸을 때, 해당 아이콘에 기능을 넣는 메소드1   -스텟 GUI, 오피박스, 커스텀 몬스터GUI-//
	public void EventGUIInventoryclick(InventoryClickEvent event)
	{
		com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 28://전체 주기
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			AllPlayerGiveEventGUI(player,true);
			return;
		case 30://랜덤 주기
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			AllPlayerGiveEventGUI(player,false);
			return;
		case 10:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[이벤트] : 스킬 포인트 추가 획득량을 몇 배로 하실래요?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1일 경우 이벤트 종료)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "SKP");
			return;
		case 12:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[이벤트] : 스텟 포인트 추가 획득량을 몇 배로 하실래요?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1일 경우 이벤트 종료)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "STP");
			return;
		case 14:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[이벤트] : 경험치 획득량 추가 획득량을 몇 배로 하실래요?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1일 경우 이벤트 종료)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "EXP");
			return;
		case 16:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[이벤트] : 경험치 획득량 추가 획득량을 몇 배로 하실래요?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1일 경우 이벤트 종료)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "DROP");
			return;
		case 36:
			OPBoxGUI OGUI = new OPBoxGUI();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OGUI.OPBoxGUI_Main(player,1);
			return;
		case 44:
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
		return;
	}

	public void AllPlayerGiveEventGUIclick(InventoryClickEvent event)
	{
		com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();

		Player player = (Player) event.getWhoClicked();
		if(event.getSlot()>=0&&event.getSlot()<=9)
			event.setCancelled(true);
		if(event.getSlot()>=27&&event.getSlot()<=35)
			event.setCancelled(true);
		if(event.getSlot()>=35)
			event.setCancelled(true);
		switch (event.getSlot())
		{
		case 17:
		case 18:
		case 26:
			event.setCancelled(true);
			break;
		case 36:
			event.setCancelled(true);
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			EventGUI_Main(player);
			return;
		case 40://지급 시작
			event.setCancelled(true);
			com.goldbigdragon.rpg.event.Interact IT = new com.goldbigdragon.rpg.event.Interact();
			if(event.getInventory().getTitle().contains("랜덤"))
			{
				boolean ItemExit = false;
  		    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
  		    	Player[] a = new Player[playerlist.size()];
  		    	playerlist.toArray(a);
  		    	int LuckyGuy = new com.goldbigdragon.rpg.util.Number().RandomNum(0, a.length-1);
				for(int count = 10; count < 17;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
		  		    	a[LuckyGuy].getInventory().addItem(item);
					}
				}
				for(int count = 19; count < 26;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
						a[LuckyGuy].getInventory().addItem(item);
					}
				}
				if(ItemExit)
				{
					s.SP(a[LuckyGuy], Sound.ITEM_PICKUP, 1.0F, 1.9F);
					Bukkit.broadcastMessage(ChatColor.YELLOW+"[이벤트] : "+ChatColor.GOLD+""+ChatColor.BOLD+a[LuckyGuy].getName()+ChatColor.YELLOW+"님께서 랜덤 아이템 지급에 당첨 되셨습니다!");
					EventGUI_Main(player);
				}
			}
			else
			{
				boolean ItemExit = false;
				for(int count = 10; count < 17;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
		  		    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
		  		    	Player[] a = new Player[playerlist.size()];
		  		    	playerlist.toArray(a);
		  	  			for(int counter = 0; counter<a.length;counter++)
		  	  			{
		  	  				a[counter].getInventory().addItem(item);
		  	  				if(item.hasItemMeta())
		  	  				{
		  	  					if(item.getItemMeta().hasDisplayName())
		  	  						a[counter].sendMessage(ChatColor.YELLOW+"[이벤트] : "+item.getItemMeta().getDisplayName()+ChatColor.YELLOW+" 아이템을 "+item.getAmount()+"개 지급 받았습니다!");
		  	  				}
		  	  				else
	  	  						a[counter].sendMessage(ChatColor.YELLOW+"[이벤트] : "+IT.SetItemDefaultName(item.getTypeId(), item.getData().getData())+ChatColor.YELLOW+" 아이템을 "+item.getAmount()+"개 지급 받았습니다!");
		  	  				s.SP(a[counter], Sound.ITEM_PICKUP, 0.7F, 1.8F);
		  	  			}
					}
				}
				for(int count = 19; count < 26;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
		  		    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
		  		    	Player[] a = new Player[playerlist.size()];
		  		    	playerlist.toArray(a);
		  	  			for(int counter = 0; counter<a.length;counter++)
		  	  			{
		  	  				a[counter].getInventory().addItem(item);
		  	  				if(item.hasItemMeta())
		  	  				{
		  	  					if(item.getItemMeta().hasDisplayName())
		  	  						a[counter].sendMessage(ChatColor.YELLOW+"[이벤트] : "+item.getItemMeta().getDisplayName()+ChatColor.YELLOW+" 아이템을 "+item.getAmount()+"개 지급 받았습니다!");
		  	  				}
		  	  				else
	  	  						a[counter].sendMessage(ChatColor.YELLOW+"[이벤트] : "+IT.SetItemDefaultName(item.getTypeId(), item.getData().getData())+ChatColor.YELLOW+" 아이템을 "+item.getAmount()+"개 지급 받았습니다!");
		  	  				s.SP(a[counter], Sound.ITEM_PICKUP, 0.7F, 1.8F);	
		  	  			}
					}
				}
				if(ItemExit)
					EventGUI_Main(player);
			}
			return;
		case 44:
			event.setCancelled(true);
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}
}
