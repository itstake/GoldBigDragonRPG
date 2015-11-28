﻿package com.goldbigdragon.rpg;


import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;
import org.bukkit.ChatColor;

public class ServerOption
{
	public static String STR = "체력";
	public static String DEX = "솜씨";
	public static String INT = "지력";
	public static String WILL = "의지";
	public static String LUK = "행운";
	public static String Money = ChatColor.YELLOW+""+ChatColor.BOLD+"Gold";
	public static String STR_Lore = "%enter%"+ChatColor.GRAY+" "+ ServerOption.STR+"은 플레이어의%enter%"+ChatColor.GRAY + " 물리적 공격력을%enter%"+ChatColor.GRAY + " 상승시켜 줍니다.%enter%";
	public static String DEX_Lore = "%enter%"+ChatColor.GRAY+" "+ ServerOption.DEX+"는 플레이어의%enter%"+ChatColor.GRAY + " 원거리 공격력을%enter%"+ChatColor.GRAY + " 상승시켜 줍니다.%enter%";
	public static String INT_Lore = "%enter%"+ChatColor.GRAY+" "+ ServerOption.INT+"은 플레이어가%enter%"+ChatColor.GRAY + " 사용하는 스킬 중%enter%"+ChatColor.GRAY+" "+ ServerOption.INT+" 영향을 받는%enter%"+ChatColor.GRAY+" 스킬 공격력을%enter%"+ChatColor.GRAY + " 상승시켜 줍니다.%enter%";
	public static String WILL_Lore = "%enter%"+ChatColor.GRAY+" "+ ServerOption.WILL+"는 플레이어의%enter%"+ChatColor.GRAY + " 크리티컬 및 스킬 중%enter%"+ChatColor.GRAY+" "+ ServerOption.WILL+" 영향을 받는%enter%"+ChatColor.GRAY + " 스킬 공격력을%enter%"+ChatColor.GRAY+" 상승시켜 줍니다.%enter%";
	public static String LUK_Lore = "%enter%"+ChatColor.GRAY+" "+ ServerOption.LUK+"은 플레이어에게%enter%"+ChatColor.GRAY+" 뜻하지 않은 일이 일어날%enter%"+ChatColor.GRAY + " 확률을 증가시킵니다.%enter%";

	public void Initialize()
	{
		YamlController GUI_YC = Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		if(Config.contains("Server.STR"))
			STR = Config.getString("Server.STR");
		if(Config.contains("Server.DEX"))
			DEX = Config.getString("Server.DEX");
		if(Config.contains("Server.INT"))
			INT = Config.getString("Server.INT");
		if(Config.contains("Server.WILL"))
			WILL = Config.getString("Server.WILL");
		if(Config.contains("Server.LUK"))
			LUK = Config.getString("Server.LUK");
		if(Config.contains("Server.MoneyName"))
			Money = Config.getString("Server.MoneyName");
		if(Config.contains("Server.STR_Lore"))
			STR_Lore = Config.getString("Server.STR_Lore");
		if(Config.contains("Server.DEX_Lore"))
			DEX_Lore = Config.getString("Server.DEX_Lore");
		if(Config.contains("Server.INT_Lore"))
			INT_Lore = Config.getString("Server.INT_Lore");
		if(Config.contains("Server.WILL_Lore"))
			WILL_Lore = Config.getString("Server.WILL_Lore");
		if(Config.contains("Server.LUK_Lore"))
			LUK_Lore = Config.getString("Server.LUK_Lore");
		return;
	}
}
