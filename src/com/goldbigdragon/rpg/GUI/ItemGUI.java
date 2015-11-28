﻿package com.goldbigdragon.rpg.gui;

import java.util.Arrays;

import com.goldbigdragon.rpg.ServerOption;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.goldbigdragon.rpg.Main;
import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;

public class ItemGUI extends GUIutil
{
	public void ItemListGUI(Player player, int page)
	{
		YamlController GUI_YC = Main.GUI_YC;
		YamlManager ItemList = GUI_YC.getNewConfig("Item/ItemList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "아이템 목록 : " + (page+1));

		Object[] a= ItemList.getKeys().toArray();

		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			int number = ((page*45)+loc);
			if(count > a.length || loc >= 45) break;
			String ItemName = ItemList.getString(number+".DisplayName");
			int ItemID = ItemList.getInt(number+".ID");
			int ItemData = ItemList.getInt(number+".Data");
			Stack2(ItemName, ItemID, ItemData, 1,Arrays.asList(LoreCreater(number)), loc, inv);
			loc=loc+1;
		}
		
		if(a.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "다음 페이지", 323,0,1,Arrays.asList(ChatColor.GRAY + "다음 페이지로 이동 합니다."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "이전 페이지", 323,0,1,Arrays.asList(ChatColor.GRAY + "이전 페이지로 이동 합니다."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "새 아이템", 145,0,1,Arrays.asList(ChatColor.GRAY + "새로운 아이템을 생성합니다."), 49, inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "이전 목록", 323,0,1,Arrays.asList(ChatColor.GRAY + "이전 화면으로 돌아갑니다."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "닫기", 324,0,1,Arrays.asList(ChatColor.GRAY + "창을 닫습니다."), 53, inv);
		player.openInventory(inv);
	}

	public void NewItemGUI(Player player, int number)
	{
		YamlController GUI_YC = Main.GUI_YC;
		YamlManager ItemList = GUI_YC.getNewConfig("Item/ItemList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "아이템 상세 설정");
		String ItemName = ItemList.getString(number+".DisplayName");
		int ItemID = ItemList.getInt(number+".ID");
		int ItemData = ItemList.getInt(number+".Data");

		String Type = "";
		String Grade = "";
		for(int counter =0;counter < 13 - ItemList.getString(number+".Type").length();counter++ )
			Type = Type +" ";
		Type = Type +ItemList.getString(number+".Type");
		Grade = ItemList.getString(number+".Grade");
		
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 9, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 10, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 11, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 18, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 20, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 27, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 28, inv);
		Stack2(ChatColor.DARK_AQUA + "[    결과물    ]", 145,0,1,null, 29, inv);
		Stack2(ItemName, ItemID,ItemData,1,Arrays.asList(LoreCreater(number)), 19, inv);
		
		Stack2(ChatColor.DARK_AQUA + "[    형식 변경    ]", 421,0,1,Arrays.asList(ChatColor.WHITE+"아이템 설명창을",ChatColor.WHITE+"변경합니다.","",ChatColor.WHITE+"[    현재 형식    ]","       "+ ItemList.getString(number+".ShowType"),""), 37, inv);
		Stack2(ChatColor.DARK_AQUA + "[    이름 변경    ]", 421,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 이름을",ChatColor.WHITE+"변경합니다.",""), 13, inv);
		Stack2(ChatColor.DARK_AQUA + "[    설명 변경    ]", 386,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 설명을",ChatColor.WHITE+"변경합니다.",""), 14, inv);
		Stack2(ChatColor.DARK_AQUA + "[    타입 변경    ]", 61,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 타입을",ChatColor.WHITE+"변경합니다.","",ChatColor.WHITE+"[    현재 타입    ]",Type,""), 15, inv);
		Stack2(ChatColor.DARK_AQUA + "[    등급 변경    ]", 266,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 등급을",ChatColor.WHITE+"변경합니다.","",ChatColor.WHITE+"[    현재 등급    ]","       "+Grade,""), 16, inv);
		Stack2(ChatColor.DARK_AQUA + "[        ID        ]", 405,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 ID값을",ChatColor.WHITE+"변경합니다.",""), 22, inv);
		Stack2(ChatColor.DARK_AQUA + "[       DATA       ]", 336,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 DATA값을",ChatColor.WHITE+"변경합니다.",""), 23, inv);
		Stack2(ChatColor.DARK_AQUA + "[       대미지       ]", 267,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 대미지를",ChatColor.WHITE+"변경합니다.",""), 24, inv);
		Stack2(ChatColor.DARK_AQUA + "[     마법 대미지     ]", 403,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 마법 대미지를",ChatColor.WHITE+"변경합니다.",""), 25, inv);
		Stack2(ChatColor.DARK_AQUA + "[        방어        ]", 307,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 방어력을",ChatColor.WHITE+"변경합니다.",""), 31, inv);
		Stack2(ChatColor.DARK_AQUA + "[        보호        ]", 306,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 보호를",ChatColor.WHITE+"변경합니다.",""), 32, inv);
		Stack2(ChatColor.DARK_AQUA + "[      마법 방어      ]", 311,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 마법 방어를",ChatColor.WHITE+"변경합니다.",""), 33, inv);
		Stack2(ChatColor.DARK_AQUA + "[      마법 보호      ]", 310,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 마법 보호를",ChatColor.WHITE+"변경합니다.",""), 34, inv);
		Stack2(ChatColor.DARK_AQUA + "[        스텟        ]", 399,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 보너스 스텟을",ChatColor.WHITE+"설정합니다.",""), 40, inv);
		Stack2(ChatColor.DARK_AQUA + "[       내구도       ]", 145,2,1,Arrays.asList(ChatColor.WHITE+"아이템의 내구력을",ChatColor.WHITE+"조절합니다.","",ChatColor.RED+"[0 설정시 일반 아이템 내구도 사용]",""), 41, inv);
		Stack2(ChatColor.DARK_AQUA + "[        개조        ]", 145,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 최대 개조 횟수를",ChatColor.WHITE+"조절합니다.","",ChatColor.RED+"[0 설정시 개조 불가능]",""), 42, inv);
		Stack2(ChatColor.DARK_AQUA + "[         룬         ]", 381,0,1,Arrays.asList(ChatColor.WHITE+"아이템의 최대 슬롯을",ChatColor.WHITE+"조절합니다.","",ChatColor.WHITE+"최대 "+ItemList.getInt(number+".MaxSocket")+" 개","",ChatColor.RED+"[0 설정시 룬 장착 불가능]",""), 43, inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "이전 목록", 323,0,1,Arrays.asList(ChatColor.GRAY + "이전 화면으로 돌아갑니다."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "닫기", 324,0,1,Arrays.asList(ChatColor.GRAY + "창을 닫습니다.",ChatColor.BLACK+""+number), 53, inv);
		player.openInventory(inv);
	}
	
	public void ItemListInventoryclick(InventoryClickEvent event)
	{
		com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();
		OPBoxGUI OGUI = new OPBoxGUI();
		event.setCancelled(true);
		int page = Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		Player player = (Player) event.getWhoClicked();
		

		YamlController GUI_YC = Main.GUI_YC;
		YamlManager ItemList = GUI_YC.getNewConfig("Item/ItemList.yml");
		switch (event.getSlot())
		{
			case 48:
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				ItemListGUI(player,page-1);
				return;
			case 50:
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				ItemListGUI(player,page+1);
				return;
			case 45:
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				OGUI.OPBoxGUI_Main(player,1);
				return;
			case 53:
				event.setCancelled(true);
				s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
				player.closeInventory();
				return;
			case 49://새 아이템
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				int ItemCounter = ItemList.getConfigurationSection("").getKeys(false).size();
				ItemList.set(ItemCounter+".ShowType",ChatColor.WHITE+"[깔끔]");
				ItemList.set(ItemCounter+".ID",267);
				ItemList.set(ItemCounter+".Data",0);
				ItemList.set(ItemCounter+".DisplayName",ChatColor.WHITE+"방금 만든 따끈한 검");
				ItemList.set(ItemCounter+".Lore",ChatColor.WHITE+"방금 만들어진 무기이다.%enter%"+ChatColor.WHITE+"조금은 허접할지도...");
				ItemList.set(ItemCounter+".Type",ChatColor.RED+"[근접 무기]");
				ItemList.set(ItemCounter+".Grade",ChatColor.WHITE+"[일반]");
				ItemList.set(ItemCounter+".MinDamage",1);
				ItemList.set(ItemCounter+".MaxDamage",7);
				ItemList.set(ItemCounter+".MinMaDamage",0);
				ItemList.set(ItemCounter+".MaxMaDamage",0);
				ItemList.set(ItemCounter+".DEF",0);
				ItemList.set(ItemCounter+".Protect",0);
				ItemList.set(ItemCounter+".MaDEF",0);
				ItemList.set(ItemCounter+".MaProtect",0);
				ItemList.set(ItemCounter+".Durability",256);
				ItemList.set(ItemCounter+".MaxDurability",256);
				ItemList.set(ItemCounter+".STR",0);
				ItemList.set(ItemCounter+".DEX",0);
				ItemList.set(ItemCounter+".INT",0);
				ItemList.set(ItemCounter+".WILL",0);
				ItemList.set(ItemCounter+".LUK",0);
				ItemList.set(ItemCounter+".Balance",10);
				ItemList.set(ItemCounter+".Critical",5);
				ItemList.set(ItemCounter+".MaxUpgrade",5);
				ItemList.set(ItemCounter+".MaxSocket",3);
				ItemList.set(ItemCounter+".HP",0);
				ItemList.set(ItemCounter+".MP",0);
				ItemList.saveConfig();
				NewItemGUI(player, ItemCounter);
				return;
			default:
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				int number = ((page*45)+event.getSlot());
				if(event.isLeftClick() == true&&event.isShiftClick()==false)
				{
					player.sendMessage(ChatColor.GREEN+"[SYSTEM] : 클릭한 아이템을 지급 받았습니다!");
					player.getInventory().addItem(event.getCurrentItem());
				}
				if(event.isLeftClick() == true&&event.isShiftClick()==true)
					NewItemGUI(player, number);
				else if(event.isRightClick()==true&&event.isShiftClick()==true)
				{
					int Acount =  ItemList.getConfigurationSection("").getKeys(false).toArray().length-1;

					for(int counter = number;counter <Acount;counter++)
						ItemList.set(counter+"", ItemList.get((counter+1)+""));
					ItemList.removeKey(Acount+"");
					ItemList.saveConfig();
					ItemListGUI(player, page);
				}
				return;
		}
	}
	
	public void NewItemGUIclick(InventoryClickEvent event)
	{
		com.goldbigdragon.rpg.effect.Sound s = new com.goldbigdragon.rpg.effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		int itemnumber = Integer.parseInt(ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1)));

		YamlController GUI_YC = Main.GUI_YC;
		YamlManager ItemList = GUI_YC.getNewConfig("Item/ItemList.yml");
		switch (event.getSlot())
		{
		case 37://쇼 타입
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(ItemList.getString(itemnumber+".ShowType").contains("[깔끔]"))
				ItemList.set(itemnumber+".ShowType",ChatColor.YELLOW+"[컬러]");
			else if(ItemList.getString(itemnumber+".ShowType").contains("[컬러]"))
				ItemList.set(itemnumber+".ShowType",ChatColor.LIGHT_PURPLE+"[기호]");
			else if(ItemList.getString(itemnumber+".ShowType").contains("[기호]"))
				ItemList.set(itemnumber+".ShowType",ChatColor.BLUE+"[분류]");
			else if(ItemList.getString(itemnumber+".ShowType").contains("[분류]"))
				ItemList.set(itemnumber+".ShowType",ChatColor.WHITE+"[깔끔]");
			ItemList.saveConfig();
			NewItemGUI(player, itemnumber);
			return;
		case 13://이름 변경
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 이름을 입력해 주세요!");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");

			Main.UserData.get(player).setType("Item");
			Main.UserData.get(player).setString((byte)1, "DisplayName");
			Main.UserData.get(player).setInt((byte)3, itemnumber);
			return;
		case 14://설명 변경
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 설명을 입력해 주세요!");
			player.sendMessage(ChatColor.GOLD + "%enter%"+ChatColor.WHITE + " - 한줄 띄워 쓰기 -");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");

			Main.UserData.get(player).setType("Item");
			Main.UserData.get(player).setString((byte)1, "Lore");
			Main.UserData.get(player).setInt((byte)3, itemnumber);
			return;
		case 15://타입 변경
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(ItemList.getString(itemnumber+".Type").contains("[근접 무기]"))
				ItemList.set(itemnumber+".Type",ChatColor.RED+"[한손 검]");
			else if(ItemList.getString(itemnumber+".Type").contains("[한손 검]"))
				ItemList.set(itemnumber+".Type",ChatColor.RED+"[양손 검]");
			else if(ItemList.getString(itemnumber+".Type").contains("[양손 검]"))
				ItemList.set(itemnumber+".Type",ChatColor.RED+"[도끼]");
			else if(ItemList.getString(itemnumber+".Type").contains("[도끼]"))
				ItemList.set(itemnumber+".Type",ChatColor.RED+"[낫]");
			else if(ItemList.getString(itemnumber+".Type").contains("[낫]"))
				ItemList.set(itemnumber+".Type",ChatColor.DARK_GREEN+"[원거리 무기]");
			else if(ItemList.getString(itemnumber+".Type").contains("[원거리 무기]"))
				ItemList.set(itemnumber+".Type",ChatColor.DARK_GREEN+"[활]");
			else if(ItemList.getString(itemnumber+".Type").contains("[활]"))
				ItemList.set(itemnumber+".Type",ChatColor.DARK_GREEN+"[석궁]");
			else if(ItemList.getString(itemnumber+".Type").contains("[석궁]"))
				ItemList.set(itemnumber+".Type",ChatColor.DARK_AQUA+"[마법 무기]");
			else if(ItemList.getString(itemnumber+".Type").contains("[마법 무기]"))
				ItemList.set(itemnumber+".Type",ChatColor.DARK_AQUA+"[원드]");
			else if(ItemList.getString(itemnumber+".Type").contains("[원드]"))
				ItemList.set(itemnumber+".Type",ChatColor.DARK_AQUA+"[스태프]");
			else if(ItemList.getString(itemnumber+".Type").contains("[스태프]"))
				ItemList.set(itemnumber+".Type",ChatColor.WHITE+"[방어구]");
			else if(ItemList.getString(itemnumber+".Type").contains("[방어구]"))
				ItemList.set(itemnumber+".Type",ChatColor.GRAY+"[기타]");
			else if(ItemList.getString(itemnumber+".Type").contains("[기타]"))
				ItemList.set(itemnumber+".Type",ChatColor.RED+"[근접 무기]");
			ItemList.saveConfig();
			NewItemGUI(player, itemnumber);
			return;
		case 16://등급 변경
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(ItemList.getString(itemnumber+".Grade").contains("[일반]"))
				ItemList.set(itemnumber+".Grade",ChatColor.GREEN+"[상급]");
			else if(ItemList.getString(itemnumber+".Grade").contains("[상급]"))
				ItemList.set(itemnumber+".Grade",ChatColor.BLUE+"[매직]");
			else if(ItemList.getString(itemnumber+".Grade").contains("[매직]"))
				ItemList.set(itemnumber+".Grade",ChatColor.YELLOW+"[레어]");
			else if(ItemList.getString(itemnumber+".Grade").contains("[레어]"))
				ItemList.set(itemnumber+".Grade",ChatColor.DARK_PURPLE+"[에픽]");
			else if(ItemList.getString(itemnumber+".Grade").contains("[에픽]"))
				ItemList.set(itemnumber+".Grade",ChatColor.GOLD+"[전설]");
			else if(ItemList.getString(itemnumber+".Grade").contains("[전설]"))
				ItemList.set(itemnumber+".Grade",ChatColor.DARK_RED+""+ChatColor.BOLD+"["+ChatColor.GOLD+""+ChatColor.BOLD+"초"+ChatColor.DARK_GREEN+""+ChatColor.BOLD+"월"+ChatColor.DARK_BLUE+""+ChatColor.BOLD+"]");
			else if(ItemList.getString(itemnumber+".Grade").contains("초"))
				ItemList.set(itemnumber+".Grade",ChatColor.GRAY+"[하급]");
			else if(ItemList.getString(itemnumber+".Grade").contains("[하급]"))
				ItemList.set(itemnumber+".Grade",ChatColor.WHITE+"[일반]");
			ItemList.saveConfig();
			NewItemGUI(player, itemnumber);
			return;
			case 22://ID변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 ID 값을 입력해 주세요!");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "ID");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 23://DATA변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 DATA 값을 입력해 주세요!");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "Data");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 24://대미지 변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 최소 대미지를 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "MinDamage");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 25://마법 대미지 변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 최소 마법 대미지를 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "MinMaDamage");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 31://방어변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 방어력을 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "DEF");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 32://보호변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 보호를 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "Protect");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 33://마법 방어 변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 마법 방어력을 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "MaDEF");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 34://마법 보호 변경
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 마법 보호를 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "MaProtect");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 40://스텟 보너스
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 생명력 보너스를 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(-127 ~ 127)");
				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "HP");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 41://내구도 설정
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 최대 내구력을 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ "+Integer.MAX_VALUE+")");

				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "MaxDurability");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 42://개조 횟수 설정
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_AQUA+"[아이템] : 아이템의 최대 개조 횟수를 입력해 주세요!");
				player.sendMessage(ChatColor.DARK_AQUA+"(0 ~ 127)");
				Main.UserData.get(player).setType("Item");
				Main.UserData.get(player).setString((byte)1, "MaxUpgrade");
				Main.UserData.get(player).setInt((byte)3, itemnumber);
				return;
			case 43://최대 슬롯 설정
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				if(ItemList.getInt(itemnumber+".MaxSocket") < 5)
					ItemList.set(itemnumber+".MaxSocket",ItemList.getInt(itemnumber+".MaxSocket")+1);
				else if(ItemList.getInt(itemnumber+".MaxSocket") == 5)
						ItemList.set(itemnumber+".MaxSocket", 0);
				ItemList.saveConfig();
				NewItemGUI(player, itemnumber);
				return;
			case 45://이전 목록
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				ItemListGUI(player, 0);
				return;
			case 53://나가기
				event.setCancelled(true);
				s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
				player.closeInventory();
				return;
		}
	}

	public String[] LoreCreater(int ItemNumber)
	{
		YamlController GUI_YC = Main.GUI_YC;
		YamlManager ItemList = GUI_YC.getNewConfig("Item/ItemList.yml");
		String lore = "";
		String Type = ChatColor.stripColor(ItemList.getString(ItemNumber+".ShowType"));
		switch(Type)
		{
		case "[분류]":
		{
			lore = lore+ItemList.getString(ItemNumber+".Type");
			for(int count = 0; count<20-ItemList.getString(ItemNumber+".Type").length();count++)
				lore = lore+" ";
			lore = lore+ItemList.getString(ItemNumber+".Grade")+"%enter%%enter%";
			if(ItemList.getInt(ItemNumber+".MinDamage") != 0||ItemList.getInt(ItemNumber+".MaxDamage") != 0)
				lore = lore+ChatColor.RED + " ▩ 대미지 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MinDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxDamage")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MinMaDamage") != 0||ItemList.getInt(ItemNumber+".MaxMaDamage") != 0)
				lore = lore+ChatColor.DARK_AQUA + " ▦ 마법 대미지 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MinMaDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxMaDamage")+"%enter%";
			if(ItemList.getInt(ItemNumber+".DEF") != 0)
				lore = lore+ChatColor.GRAY + " ▧ 방어 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".DEF")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Protect") != 0)
				lore = lore+ChatColor.WHITE + " ■ 보호 : " + ChatColor.WHITE +ItemList.getInt(ItemNumber+".Protect")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaDEF") != 0)
				lore = lore+ChatColor.BLUE + " ◇ 마법 방어 : " + ChatColor.WHITE +ItemList.getInt(ItemNumber+".MaDEF")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaProtect") != 0)
				lore = lore+ChatColor.DARK_BLUE + " ◆ 마법 보호 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MaProtect")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Balance") != 0)
				lore = lore+ChatColor.DARK_GREEN + " △ 밸런스 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Balance")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Critical") != 0)
				lore = lore+ChatColor.YELLOW + " ▲ 크리티컬 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Critical")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxDurability") > 0)
				lore = lore+ChatColor.GOLD + " ▣ 내구도 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Durability")+" / "+ ItemList.getInt(ItemNumber+".MaxDurability")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
				lore = lore + ChatColor.WHITE+" ♣ 숙련도 : 0.0%"+ChatColor.WHITE+ "%enter%";
			
			lore = lore+ChatColor.GOLD+"___--------------------___%enter%"+ChatColor.GOLD+"       [아이템 설명]";
			lore = lore+"%enter%"+ ItemList.getString(ItemNumber+".Lore")+"%enter%";
			lore = lore+ChatColor.GOLD+"---____________________---%enter%";


			if(ItemList.getInt(ItemNumber+".HP")!=0||ItemList.getInt(ItemNumber+".MP")!=0||
					ItemList.getInt(ItemNumber+".STR")!=0||ItemList.getInt(ItemNumber+".DEX")!=0||
					ItemList.getInt(ItemNumber+".INT")!=0||ItemList.getInt(ItemNumber+".WILL")!=0||
					ItemList.getInt(ItemNumber+".LUK")!=0)
			{
				lore = lore+ChatColor.DARK_AQUA+"___--------------------___%enter%"+ChatColor.DARK_AQUA+"       [보너스 옵션]%enter%";
				if(ItemList.getInt(ItemNumber+".HP") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ 생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".HP") < 0)
					lore = lore+ChatColor.RED + " ▼ 생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MP") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ 마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".MP") < 0)
					lore = lore+ChatColor.RED + " ▼ 마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
				if(ItemList.getInt(ItemNumber+".STR") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".STR") < 0)
					lore = lore+ChatColor.RED + " ▼ "+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
				if(ItemList.getInt(ItemNumber+".DEX") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".DEX") < 0)
					lore = lore+ChatColor.RED + " ▼ "+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
				if(ItemList.getInt(ItemNumber+".INT") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".INT") < 0)
					lore = lore+ChatColor.RED + " ▼ "+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
				if(ItemList.getInt(ItemNumber+".WILL") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".WILL") < 0)
					lore = lore+ChatColor.RED + " ▼ "+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
				if(ItemList.getInt(ItemNumber+".LUK") > 0)
					lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".LUK") < 0)
					lore = lore+ChatColor.RED + " ▼ "+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
				lore = lore+ChatColor.DARK_AQUA+"---____________________---%enter%";
			}

			if(ItemList.getInt(ItemNumber+".MaxSocket")!=0||ItemList.getInt(ItemNumber+".MaxUpgrade")!=0)
			{
				lore = lore+ChatColor.LIGHT_PURPLE+"___--------------------___%enter%"+ChatColor.LIGHT_PURPLE+"       [아이템 강화]%enter%";
				if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
					lore = lore+ChatColor.DARK_PURPLE + " ★ 개조 : " + "0 / "+ItemList.getInt(ItemNumber+".MaxUpgrade")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MaxSocket") > 0)
				{
					lore = lore+ChatColor.BLUE + " ⓛ 룬 : ";
					for(int count = 0; count <ItemList.getInt(ItemNumber+".MaxSocket");count++)
						lore = lore+ChatColor.GRAY + "○ ";
				}
				lore = lore+"%enter%"+ChatColor.LIGHT_PURPLE+"---____________________---%enter%";
			}
		}
		break;
		case "[기호]":
		{
			lore = lore+ItemList.getString(ItemNumber+".Type");
			for(int count = 0; count<20-ItemList.getString(ItemNumber+".Type").length();count++)
				lore = lore+" ";
			lore = lore+ItemList.getString(ItemNumber+".Grade")+"%enter%%enter%";
			if(ItemList.getInt(ItemNumber+".MinDamage") != 0||ItemList.getInt(ItemNumber+".MaxDamage") != 0)
				lore = lore+ChatColor.RED + " ▩ 대미지 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MinDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxDamage")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MinMaDamage") != 0||ItemList.getInt(ItemNumber+".MaxMaDamage") != 0)
				lore = lore+ChatColor.DARK_AQUA + " ▦ 마법 대미지 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MinMaDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxMaDamage")+"%enter%";
			if(ItemList.getInt(ItemNumber+".DEF") != 0)
				lore = lore+ChatColor.GRAY + " ▧ 방어 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".DEF")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Protect") != 0)
				lore = lore+ChatColor.WHITE + " ■ 보호 : " + ChatColor.WHITE +ItemList.getInt(ItemNumber+".Protect")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaDEF") != 0)
				lore = lore+ChatColor.BLUE + " ◇ 마법 방어 : " + ChatColor.WHITE +ItemList.getInt(ItemNumber+".MaDEF")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaProtect") != 0)
				lore = lore+ChatColor.DARK_BLUE + " ◆ 마법 보호 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MaProtect")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Balance") != 0)
				lore = lore+ChatColor.DARK_GREEN + " △ 밸런스 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Balance")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Critical") != 0)
				lore = lore+ChatColor.YELLOW + " ▲ 크리티컬 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Critical")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxDurability") > 0)
				lore = lore+ChatColor.GOLD + " ▣ 내구도 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Durability")+" / "+ ItemList.getInt(ItemNumber+".MaxDurability")+"%enter%";

			if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
				lore = lore + ChatColor.WHITE+" ♣ 숙련도 : 0.0%"+ChatColor.WHITE+ "%enter%";
			
			lore = lore+"%enter%"+ ItemList.getString(ItemNumber+".Lore")+"%enter%%enter%";


			if(ItemList.getInt(ItemNumber+".HP") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ 생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".HP") < 0)
				lore = lore+ChatColor.RED + " ▼ 생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MP") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ 마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".MP") < 0)
				lore = lore+ChatColor.RED + " ▼ 마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
			if(ItemList.getInt(ItemNumber+".STR") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".STR") < 0)
				lore = lore+ChatColor.RED + " ▼ "+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
			if(ItemList.getInt(ItemNumber+".DEX") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".DEX") < 0)
				lore = lore+ChatColor.RED + " ▼ "+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
			if(ItemList.getInt(ItemNumber+".INT") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".INT") < 0)
				lore = lore+ChatColor.RED + " ▼ "+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
			if(ItemList.getInt(ItemNumber+".WILL") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".WILL") < 0)
				lore = lore+ChatColor.RED + " ▼ "+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
			if(ItemList.getInt(ItemNumber+".LUK") > 0)
				lore = lore+ChatColor.DARK_AQUA + " ▲ "+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".LUK") < 0)
				lore = lore+ChatColor.RED + " ▼ "+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
			
			if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
				lore = lore+"%enter%"+ChatColor.DARK_PURPLE + " ★ 개조 : " + "0 / "+ItemList.getInt(ItemNumber+".MaxUpgrade")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxSocket") > 0)
			{
				lore = lore+"%enter%"+ChatColor.BLUE + " ⓛ 룬 : ";
				for(int count = 0; count <ItemList.getInt(ItemNumber+".MaxSocket");count++)
					lore = lore+ChatColor.GRAY + "○ ";
			}
		}
		break;
		case "[컬러]":
		{
			lore = lore+ItemList.getString(ItemNumber+".Type");
			for(int count = 0; count<20-ItemList.getString(ItemNumber+".Type").length();count++)
				lore = lore+" ";
			lore = lore+ItemList.getString(ItemNumber+".Grade")+"%enter%%enter%";
			if(ItemList.getInt(ItemNumber+".MinDamage") != 0||ItemList.getInt(ItemNumber+".MaxDamage") != 0)
				lore = lore+ChatColor.RED + "대미지 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MinDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxDamage")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MinMaDamage") != 0||ItemList.getInt(ItemNumber+".MaxMaDamage") != 0)
				lore = lore+ChatColor.DARK_AQUA + "마법 대미지 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MinMaDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxMaDamage")+"%enter%";
			if(ItemList.getInt(ItemNumber+".DEF") != 0)
				lore = lore+ChatColor.GRAY + "방어 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".DEF")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Protect") != 0)
				lore = lore+ChatColor.WHITE + "보호 : " + ChatColor.WHITE +ItemList.getInt(ItemNumber+".Protect")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaDEF") != 0)
				lore = lore+ChatColor.BLUE + "마법 방어 : " + ChatColor.WHITE +ItemList.getInt(ItemNumber+".MaDEF")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaProtect") != 0)
				lore = lore+ChatColor.DARK_BLUE + "마법 보호 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".MaProtect")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Balance") != 0)
				lore = lore+ChatColor.DARK_GREEN + "밸런스 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Balance")+"%enter%";
			if(ItemList.getInt(ItemNumber+".Critical") != 0)
				lore = lore+ChatColor.YELLOW + "크리티컬 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Critical")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxDurability") > 0)
				lore = lore+ChatColor.GOLD + "내구도 : " +ChatColor.WHITE + ItemList.getInt(ItemNumber+".Durability")+" / "+ ItemList.getInt(ItemNumber+".MaxDurability")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
				lore = lore + ChatColor.WHITE+"숙련도 : 0.0%"+ChatColor.WHITE+ "%enter%";
			
			lore = lore+"%enter%"+ ItemList.getString(ItemNumber+".Lore")+"%enter%%enter%";


			if(ItemList.getInt(ItemNumber+".HP") > 0)
				lore = lore+ChatColor.DARK_AQUA + "생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".HP") < 0)
				lore = lore+ChatColor.RED + "생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MP") > 0)
				lore = lore+ChatColor.DARK_AQUA + "마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".MP") < 0)
				lore = lore+ChatColor.RED + "마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
			if(ItemList.getInt(ItemNumber+".STR") > 0)
				lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".STR") < 0)
				lore = lore+ChatColor.RED + ""+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
			if(ItemList.getInt(ItemNumber+".DEX") > 0)
				lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".DEX") < 0)
				lore = lore+ChatColor.RED + ""+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
			if(ItemList.getInt(ItemNumber+".INT") > 0)
				lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".INT") < 0)
				lore = lore+ChatColor.RED + ""+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
			if(ItemList.getInt(ItemNumber+".WILL") > 0)
				lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".WILL") < 0)
				lore = lore+ChatColor.RED + ""+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
			if(ItemList.getInt(ItemNumber+".LUK") > 0)
				lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
			else if(ItemList.getInt(ItemNumber+".LUK") < 0)
				lore = lore+ChatColor.RED + ""+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
			
			if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
				lore = lore+"%enter%"+ChatColor.DARK_PURPLE + "개조 : " + "0 / "+ItemList.getInt(ItemNumber+".MaxUpgrade")+"%enter%";
			if(ItemList.getInt(ItemNumber+".MaxSocket") > 0)
			{
				lore = lore+"%enter%"+ChatColor.BLUE + "룬 : ";
				for(int count = 0; count <ItemList.getInt(ItemNumber+".MaxSocket");count++)
					lore = lore+ChatColor.GRAY + "○ ";
			}
		}
		break;
		
			case "[깔끔]":
			{
				lore = lore+ItemList.getString(ItemNumber+".Type");
				for(int count = 0; count<20-ItemList.getString(ItemNumber+".Type").length();count++)
					lore = lore+" ";
				lore = lore+ItemList.getString(ItemNumber+".Grade")+"%enter%%enter%";
				if(ItemList.getInt(ItemNumber+".MinDamage") != 0||ItemList.getInt(ItemNumber+".MaxDamage") != 0)
					lore = lore+ChatColor.WHITE + "대미지 : " + ItemList.getInt(ItemNumber+".MinDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxDamage")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MinMaDamage") != 0||ItemList.getInt(ItemNumber+".MaxMaDamage") != 0)
					lore = lore+ChatColor.WHITE + "마법 대미지 : " + ItemList.getInt(ItemNumber+".MinMaDamage") + " ~ " + ItemList.getInt(ItemNumber+".MaxMaDamage")+"%enter%";
				if(ItemList.getInt(ItemNumber+".DEF") != 0)
					lore = lore+ChatColor.WHITE + "방어 : " + ItemList.getInt(ItemNumber+".DEF")+"%enter%";
				if(ItemList.getInt(ItemNumber+".Protect") != 0)
					lore = lore+ChatColor.WHITE + "보호 : " + ItemList.getInt(ItemNumber+".Protect")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MaDEF") != 0)
					lore = lore+ChatColor.WHITE + "마법 방어 : " + ItemList.getInt(ItemNumber+".MaDEF")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MaProtect") != 0)
					lore = lore+ChatColor.WHITE + "마법 보호 : " + ItemList.getInt(ItemNumber+".MaProtect")+"%enter%";
				if(ItemList.getInt(ItemNumber+".Balance") != 0)
					lore = lore+ChatColor.WHITE + "밸런스 : " + ItemList.getInt(ItemNumber+".Balance")+"%enter%";
				if(ItemList.getInt(ItemNumber+".Critical") != 0)
					lore = lore+ChatColor.WHITE + "크리티컬 : " + ItemList.getInt(ItemNumber+".Critical")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MaxDurability") > 0)
					lore = lore+ChatColor.WHITE + "내구도 : " + ItemList.getInt(ItemNumber+".Durability")+" / "+ ItemList.getInt(ItemNumber+".MaxDurability")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
					lore = lore + ChatColor.WHITE+"숙련도 : 0.0%"+ChatColor.WHITE+ "%enter%";
				
				lore = lore+"%enter%"+ ItemList.getString(ItemNumber+".Lore")+"%enter%%enter%";


				if(ItemList.getInt(ItemNumber+".HP") > 0)
					lore = lore+ChatColor.DARK_AQUA + "생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".HP") < 0)
					lore = lore+ChatColor.RED + "생명력 : " + ItemList.getInt(ItemNumber+".HP")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MP") > 0)
					lore = lore+ChatColor.DARK_AQUA + "마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".MP") < 0)
					lore = lore+ChatColor.RED + "마나 : " + ItemList.getInt(ItemNumber+".MP")+"%enter%";
				if(ItemList.getInt(ItemNumber+".STR") > 0)
					lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".STR") < 0)
					lore = lore+ChatColor.RED + ""+ ServerOption.STR+" : " + ItemList.getInt(ItemNumber+".STR")+"%enter%";
				if(ItemList.getInt(ItemNumber+".DEX") > 0)
					lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".DEX") < 0)
					lore = lore+ChatColor.RED + ""+ ServerOption.DEX+" : " + ItemList.getInt(ItemNumber+".DEX")+"%enter%";
				if(ItemList.getInt(ItemNumber+".INT") > 0)
					lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".INT") < 0)
					lore = lore+ChatColor.RED + ""+ ServerOption.INT+" : " + ItemList.getInt(ItemNumber+".INT")+"%enter%";
				if(ItemList.getInt(ItemNumber+".WILL") > 0)
					lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".WILL") < 0)
					lore = lore+ChatColor.RED + ""+ ServerOption.WILL+" : " + ItemList.getInt(ItemNumber+".WILL")+"%enter%";
				if(ItemList.getInt(ItemNumber+".LUK") > 0)
					lore = lore+ChatColor.DARK_AQUA + ""+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
				else if(ItemList.getInt(ItemNumber+".LUK") < 0)
					lore = lore+ChatColor.RED + ""+ ServerOption.LUK+" : " + ItemList.getInt(ItemNumber+".LUK")+"%enter%";
				
				if(ItemList.getInt(ItemNumber+".MaxUpgrade") > 0)
					lore = lore+"%enter%"+ChatColor.WHITE + "개조 : " + "0 / "+ItemList.getInt(ItemNumber+".MaxUpgrade")+"%enter%";
				if(ItemList.getInt(ItemNumber+".MaxSocket") > 0)
				{
					lore = lore+"%enter%"+ChatColor.WHITE + "룬 : ";
					for(int count = 0; count <ItemList.getInt(ItemNumber+".MaxSocket");count++)
						lore = lore+ChatColor.GRAY + "○ ";
				}
			}
			break;
		}
		String[] scriptA = lore.split("%enter%");
		for(int counter = 0; counter < scriptA.length; counter++)
			scriptA[counter] =  scriptA[counter];
		return scriptA;
	}
}