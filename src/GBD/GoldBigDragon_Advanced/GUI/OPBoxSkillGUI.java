package GBD.GoldBigDragon_Advanced.GUI;

import java.util.Arrays;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;

import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.Spell;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import GBD.GoldBigDragon_Advanced.Main.Main;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class OPBoxSkillGUI extends GUIutil
{
	public void AllSkillsGUI(Player player, int page, boolean isJobGUI,String WhatJob)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "��ü ��ų ��� : " + (page+1));

		Object[] a = SkillList.getKeys().toArray();
		
		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			String SkillName = a[count].toString();
			int JobLevel=0;
			if(SkillList.contains(a[count].toString()+".SkillRank"))
				JobLevel= SkillList.getConfigurationSection(a[count].toString()+".SkillRank").getKeys(false).size();
			if(count > a.length || loc >= 45) break;
			
			if(isJobGUI == true)
			{
				YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
				YamlManager JobList  = Config_YC.getNewConfig("Skill/JobList.yml");
				if(WhatJob.equals("Maple")==true)
				{
					if(JobList.contains("MapleStory."+Main.UserData.get(player).getString((byte)3)+"."+Main.UserData.get(player).getString((byte)2)+".Skill."+SkillName)==false)
					{
						Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + SkillName,  SkillList.getInt(a[count].toString()+".ID"),SkillList.getInt(a[count].toString()+".DATA"),SkillList.getInt(a[count].toString()+".Amount"),Arrays.asList(ChatColor.DARK_AQUA+"�ִ� ��ų ���� : " + ChatColor.WHITE+JobLevel,"",ChatColor.YELLOW+"[�� Ŭ���� ��ų ���]"), loc, inv);
						loc=loc+1;	
					}
				}
				else
				{
					if(JobList.contains("Mabinogi.Added."+SkillName)==false)
					{
						Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + SkillName,  SkillList.getInt(a[count].toString()+".ID"),SkillList.getInt(a[count].toString()+".DATA"),SkillList.getInt(a[count].toString()+".Amount"),Arrays.asList(ChatColor.DARK_AQUA+"�ִ� ��ų ���� : " + ChatColor.WHITE+JobLevel,"",ChatColor.YELLOW+"[�� Ŭ���� ��ų ���]"), loc, inv);
						loc=loc+1;	
					}
				}

			}
			else
			{
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + SkillName,  SkillList.getInt(a[count].toString()+".ID"),SkillList.getInt(a[count].toString()+".DATA"),SkillList.getInt(a[count].toString()+".Amount"),Arrays.asList(ChatColor.DARK_AQUA+"�ִ� ��ų ���� : " + ChatColor.WHITE+JobLevel,"",ChatColor.YELLOW+"[�� Ŭ���� ��ų ���� ����]",ChatColor.YELLOW+"[Shift + �� Ŭ���� ������ ����]",ChatColor.RED+"[Shift + �� Ŭ���� ��ų ����]"), loc, inv);
				loc=loc+1;	
			}
		}
		
		if(a.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		if(isJobGUI == false)
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ��ų", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ��ų�� �����մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�.",ChatColor.BLACK+WhatJob), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+""+isJobGUI), 53, inv);
		player.openInventory(inv);
	}

	public void IndividualSkillOptionGUI(Player player, int page, String SkillName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "��ų ���� : " + (page+1));

		Set<String> b= SkillList.getConfigurationSection(SkillName+".SkillRank").getKeys(false);
		
		int loc=0;
		for(int count = page*45; count < b.size();count++)
		{
			if(count > b.size() || loc >= 45) break;
			
			String lore = "";

			if(SkillList.getString(SkillName+".SkillRank."+(count+1)+".Command").equalsIgnoreCase("null"))
				lore = ChatColor.GRAY+"[������ Ŀ�ǵ� ����]%enter%";
			else
			{
				lore = ChatColor.DARK_AQUA+"Ŀ�ǵ� : "+ChatColor.WHITE+SkillList.getString(SkillName+".SkillRank."+(count+1)+".Command")+"%enter%";
				if(SkillList.getBoolean(SkillName+".SkillRank."+(count+1)+".BukkitPermission") == false)
					lore = lore + ChatColor.WHITE+"[���� ���� ���]%enter%";
				else
					lore = lore + ChatColor.LIGHT_PURPLE+"[�ܼ� ���� ���]%enter%";
			}
			
			if(SkillList.getString(SkillName+".SkillRank."+(count+1)+".MagicSpells").equalsIgnoreCase("null"))
				lore = lore + ChatColor.GRAY+"[���� �������� ����]%enter%";
			else
				lore = lore + ChatColor.DARK_AQUA+"�������� : "+ChatColor.WHITE+SkillList.getString(SkillName+".SkillRank."+(count+1)+".MagicSpells")+"%enter%";

			if((page*45)+count != 0)
			{
				lore = lore + ChatColor.AQUA+"�±޽� �ʿ� ��ų ����Ʈ : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".SkillPoint")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusHP")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ����� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusHP")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusHP")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ����� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusHP")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMP")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ���� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMP")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMP")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ���� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMP")+"%enter%";
			
			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusSTR")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusSTR")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusSTR")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusSTR")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEX")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEX")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEX")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEX")+"%enter%";
				
			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusINT")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusINT")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusINT")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusINT")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusWILL")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusWILL")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusWILL")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusWILL")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusLUK")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusLUK")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusLUK")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusLUK")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusBAL")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� �뷱�� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusBAL")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusBAL")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� �뷱�� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusBAL")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusCRI")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ũ��Ƽ�� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusCRI")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusCRI")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ũ��Ƽ�� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusCRI")+"%enter%";
			
			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEF")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ��� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEF")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEF")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ��� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusDEF")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusPRO")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ��ȣ : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusPRO")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusPRO")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ��ȣ : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusPRO")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMDEF")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ���� ��� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMDEF")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMDEF")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ���� ��� : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMDEF")+"%enter%";

			if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMPRO")<0)
				lore = lore + ChatColor.RED+"�±޽� ���ʽ� ���� ��ȣ : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMPRO")+"%enter%";
			else if(SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMPRO")>0)
				lore = lore + ChatColor.AQUA+"�±޽� ���ʽ� ���� ��ȣ : "+SkillList.getInt(SkillName+".SkillRank."+(count+1)+".BonusMPRO")+"%enter%";
			
			}
			if((page*45)+count ==0)
				lore = lore + "%enter%"+ChatColor.YELLOW+"[�� Ŭ���� ��ũ ���� ����]%enter%"+ChatColor.RED+"[1���� ��ų�� ���� �Ұ���]";
			else if((count +1) == b.size())
				lore = lore + "%enter%"+ChatColor.YELLOW+"[�� Ŭ���� ��ũ ���� ����]%enter%"+ChatColor.RED+"[Shift + �� Ŭ���� ����]";
			else
				lore = lore + "%enter%"+ChatColor.YELLOW+"[�� Ŭ���� ��ũ ���� ����]%enter%"+ChatColor.RED+"[���� ��ũ ���� �� ���� ����]";
			
			String[] scriptA = lore.split("%enter%");
			for(int counter = 0; counter < scriptA.length; counter++)
				scriptA[counter] =  scriptA[counter];
			
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + SkillName +" ���� "+(count +1) , 340,0,1,Arrays.asList(scriptA), loc, inv);

				
			loc=loc+1;
		}
		
		if(b.size()-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ��ũ", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ��ų ��ũ�� ���� �մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+SkillName), 53, inv);
		player.openInventory(inv);
	}
	
	public void SkillRankOptionGUI(Player player, String SkillName, int SkillLevel)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "��ũ "+SkillLevel);

		String lore = "";
		if(SkillList.getString(SkillName+".SkillRank."+SkillLevel+".Command").equalsIgnoreCase("null"))
			lore = ChatColor.GRAY+"[  ����  ]";
		else
			lore = ChatColor.WHITE+SkillList.getString(SkillName+".SkillRank."+SkillLevel+".Command");
			
			Stack2(ChatColor.DARK_AQUA + "[Ŀ�ǵ� ����]", 137,0,1,Arrays.asList("",ChatColor.DARK_AQUA + "[���� ��ϵ� Ŀ�ǵ�]",lore,"",ChatColor.YELLOW + "[�� Ŭ���� Ŀ�ǵ� ����]"), 11, inv);

			if(SkillList.getBoolean(SkillName+".SkillRank."+SkillLevel+".BukkitPermission")==false)
				Stack2(ChatColor.DARK_AQUA + "[Ŀ�ǵ� ����]", 397,3,1,Arrays.asList("",ChatColor.DARK_AQUA + "[Ŀ�ǵ� ����� ���� ����]",ChatColor.GRAY+"[  ����  ]","",ChatColor.YELLOW + "[�� Ŭ���� ���� ����]"), 13, inv);
			else
				Stack2(ChatColor.DARK_AQUA + "[Ŀ�ǵ� ����]", 137,3,1,Arrays.asList("",ChatColor.DARK_AQUA + "[Ŀ�ǵ� ����� ���� ����]",ChatColor.LIGHT_PURPLE+"[  ��Ŷ  ]","",ChatColor.YELLOW + "[�� Ŭ���� ���� ����]"), 13, inv);

			if(Bukkit.getPluginManager().isPluginEnabled("MagicSpells") == true)
			{
				if(SkillList.getString(SkillName+".SkillRank."+SkillLevel+".MagicSpells").equalsIgnoreCase("null"))
					Stack2(ChatColor.DARK_AQUA + "[���� ����]", 280,0,1,Arrays.asList("",ChatColor.DARK_AQUA + "[���� ��ϵ� ����]",ChatColor.GRAY + "[  ����  ]","",ChatColor.YELLOW + "[�� Ŭ���� ���� ����]"), 15, inv);
				else
					Stack2(ChatColor.DARK_AQUA + "[���� ����]", 369,0,1,Arrays.asList("",ChatColor.DARK_AQUA + "[���� ��ϵ� ����]",ChatColor.WHITE+SkillList.getString(SkillName+".SkillRank."+SkillLevel+".MagicSpells"),"",ChatColor.YELLOW + "[�� Ŭ���� ���� ����]"), 15, inv);

				if(SkillList.contains(SkillName+".SkillRank."+SkillLevel+".AffectStat")==false)
				{
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", "����");
					SkillList.saveConfig();
				}
				String IncreaseDamage = SkillList.getString(SkillName+".SkillRank."+SkillLevel+".AffectStat");
				
				if(IncreaseDamage.compareTo("����")==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 166,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "[��ų ���� �������� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo("�����")==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 351,1,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "[���� ����¿� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo("����")==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 351,12,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "[���� �������� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.STR)==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 267,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"�� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX)==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 261,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"�� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.INT)==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 369,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"�� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL)==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 370,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"�� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else if(IncreaseDamage.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK)==0)
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 322,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+IncreaseDamage+"  ]",ChatColor.RED + "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"�� ����Ͽ� ����� ���]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				else
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ���ݷ� ���]", 322,0,1,Arrays.asList("",ChatColor.RED+"[�� ������ �ʿ��մϴ�!]","",ChatColor.YELLOW + "[�� Ŭ���� ���� �ִ� ���� ����]"), 21, inv);
				
			}
			else
			{
				Stack2(ChatColor.RED + "[���� ����]", 166,0,1,Arrays.asList("",ChatColor.RED + "[MagicSpells �÷������� ã�� �� ����]",ChatColor.GRAY + "MagicSpells �÷������� ���� ���",ChatColor.GRAY + "����� �� �ִ� �ɼ��Դϴ�.",""), 15, inv);
				Stack2(ChatColor.RED + "[��ų ���ݷ� ���]", 166,0,1,Arrays.asList("",ChatColor.RED + "[MagicSpells �÷������� ã�� �� ����]",ChatColor.GRAY + "MagicSpells �÷������� ���� ���",ChatColor.GRAY + "����� �� �ִ� �ɼ��Դϴ�.",""), 21, inv);
			}

			if(SkillList.contains(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon")==false)
			{
				SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "����");
				SkillList.saveConfig();
			}
			String WeaponType = SkillList.getString(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon");
			switch(WeaponType)
			{
				case "����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 166,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.AQUA + "[���� ���� ��ų �ߵ� ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "���� ����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 267,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[�ش�Ǵ� ������ ������ �־�� �ߵ�]",ChatColor.RED + "  �Ѽ� ��",ChatColor.RED + "  ��� ��",ChatColor.RED + "  ����",ChatColor.RED + "  ��",ChatColor.RED + "  ���� ����",ChatColor.LIGHT_PURPLE + "  �Ϲ� ��/����/���� ������","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "�Ѽ� ��":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 267,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '�Ѽ� ��'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� �� ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "��� ��":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 267,0,2,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '��� ��'�� �־�� �ߵ�]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 258,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '����'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� ���� ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "��":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 292,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '��'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� ���� ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "���Ÿ� ����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 261,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[�ش�Ǵ� ������ ������ �־�� �ߵ�]",ChatColor.RED + "  Ȱ",ChatColor.RED + "  ����",ChatColor.RED + "  ���Ÿ� ����",ChatColor.LIGHT_PURPLE + "  �Ϲ� Ȱ, �߻�� ������","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "Ȱ":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 261,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� 'Ȱ'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� Ȱ ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 23,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '����'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� �߻�� ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "���� ����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 280,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[�ش�Ǵ� ������ ������ �־�� �ߵ�]",ChatColor.RED + "  ����",ChatColor.RED + "  ������",ChatColor.RED + "  ���� ����",ChatColor.LIGHT_PURPLE + "  �Ϲ� �����/��/������ ���� ������","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "����":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 280,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '����'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� �����/�� ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
				case "������":
					Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���� Ÿ�� ����]", 369,0,1,Arrays.asList("",ChatColor.WHITE+"[  "+WeaponType+"  ]",ChatColor.RED + "[������ ���� '������'�� �־�� �ߵ�]",ChatColor.LIGHT_PURPLE + "[Ȥ�� �Ϲ� ������ ���� ������ ����]","",ChatColor.YELLOW + "[�� Ŭ���� ��� ���� ����]"), 19, inv);
					break;
			}

			if(SkillList.contains(SkillName+".SkillRank."+SkillLevel+".Lore")==false)
			{
				SkillList.set(SkillName+".SkillRank."+SkillLevel+".Lore", ChatColor.GRAY + "     [���� ����]     ");
				SkillList.saveConfig();
			}
			
			String lore2 = SkillList.getString(SkillName+".SkillRank."+SkillLevel+".Lore");

			String[] scriptA = lore2.split("%enter%");
			for(int counter = 0; counter < scriptA.length; counter++)
				scriptA[counter] =  scriptA[counter];
			Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[��ų ����]", 386,0,1,Arrays.asList(scriptA), 23, inv);
			
			if(SkillLevel != 1)
			{
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[�ʿ� ��ų ����Ʈ]", 399,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��ϴµ� �ʿ��� ��ų ����Ʈ]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".SkillPoint") +"����Ʈ","",ChatColor.YELLOW + "[�� Ŭ���� ��ų ����Ʈ ����]"), 4, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� �����]", 351,1,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� �����]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusHP") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 28, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� ����]", 351,12,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� ����]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusMP"),"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 29, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"]", 267,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusSTR"),"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 30, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"]", 261,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusDEX") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 31, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"]", 369,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusINT"),"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 32, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"]", 370,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusWILL") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 33, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"]", 322,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusLUK") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 34, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� �뷱��]", 283,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� �뷱��]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusBAL") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 37, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� ũ��Ƽ��]", 262,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� ũ��Ƽ��]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusCRI") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 38, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� ���]", 307,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� ���]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusDEF") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 39, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� ��ȣ]", 306,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� ��ȣ]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusPRO") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 40, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� ���� ���]", 311,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� ���� ���]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusMDEF") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 41, inv);
				Stack2(ChatColor.WHITE+""+ChatColor.BOLD + "[���ʽ� ���� ��ȣ]", 310,0,1,Arrays.asList("",ChatColor.AQUA + "["+SkillName+" "+(SkillLevel-1)+" ��������",ChatColor.AQUA +"���� ������ �±��� �� ��� ���� ��ȣ]",ChatColor.WHITE +"     "+ChatColor.BOLD+SkillList.getInt(SkillName+".SkillRank."+SkillLevel+".BonusMPRO") ,"",ChatColor.YELLOW + "[�� Ŭ���� ���ʽ� ���� ����]"), 42, inv);
			}
				
			
			
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�.",ChatColor.BLACK+""+SkillLevel), 45, inv);
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+SkillName), 53, inv);
			player.openInventory(inv);
	}
	
	
	
	
	
	public void AllSkillsGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		String WhatJob = ChatColor.stripColor(event.getInventory().getItem(45).getItemMeta().getLore().get(1));
		boolean isJobGUI = Boolean.parseBoolean(ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1)));
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(isJobGUI==true)
			{
				if(WhatJob.equals("Maple"))
				{
					GBD.GoldBigDragon_Advanced.GUI.JobGUI JGUI = new GBD.GoldBigDragon_Advanced.GUI.JobGUI();
					JGUI.MapleStory_JobSetting(player, Main.UserData.get(player).getString((byte)3));
					Main.UserData.get(player).clearAll();
				}
				else
				{
					GBD.GoldBigDragon_Advanced.GUI.JobGUI JGUI = new GBD.GoldBigDragon_Advanced.GUI.JobGUI();
					JGUI.Mabinogi_ChooseCategory(player, 0);
					Main.UserData.get(player).clearAll();
				}
			}
			else
			{
				OPBoxGUI OGUI = new OPBoxGUI();
				OGUI.OPBoxGUI_Main(player, 2);
				Main.UserData.get(player).clearAll();
			}
			break;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			if(isJobGUI == true && WhatJob.equals("Maple"))
				Main.UserData.get(player).clearAll();
			break;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AllSkillsGUI(player,page-1,isJobGUI,WhatJob);
			break;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AllSkillsGUI(player,page+1,isJobGUI,WhatJob);
			break;
		case 49://�� ��ų
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ο� ��ų �̸��� ������ �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "CS");
			break;
		default :
			if(isJobGUI == true)
			{
				String SkillName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
				if(WhatJob.equals("Maple"))
				{
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
					YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
					YamlManager JobList  = Config_YC.getNewConfig("Skill/JobList.yml");
					JobList.set("MapleStory."+Main.UserData.get(player).getString((byte)3)+"."+Main.UserData.get(player).getString((byte)2)+".Skill."+SkillName+".1", null);
					JobList.saveConfig();
					GBD.GoldBigDragon_Advanced.GUI.JobGUI JGUI = new GBD.GoldBigDragon_Advanced.GUI.JobGUI();
					JGUI.MapleStory_JobSetting(player, Main.UserData.get(player).getString((byte)3));
					Main.UserData.get(player).clearAll();
					GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
					J.AllPlayerFixAllSkillAndJobYML();
				}
				else
				{
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
					YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
					YamlManager JobList  = Config_YC.getNewConfig("Skill/JobList.yml");
					JobList.set("Mabinogi.Added."+SkillName, WhatJob);
					JobList.set("Mabinogi."+WhatJob + "."+SkillName, false);
					JobList.saveConfig();
					AllSkillsGUI(player, page, isJobGUI, WhatJob);
				}
				return;
			}
			else
			{
				if(event.isShiftClick()==true&&event.isLeftClick()==true)
				{
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
					player.closeInventory();
					player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ��ų �������� ID���� �Է� �� �ּ���!!");
					Main.UserData.get(player).setType("Skill");
					Main.UserData.get(player).setString((byte)1, "CSID");
					Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
					break;
				}
				else if(event.isLeftClick()==true&&event.isRightClick()==false)
				{
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
					IndividualSkillOptionGUI(player, 0, ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
				}
				else if(event.isShiftClick()==true&&event.isRightClick()==true)
				{
					s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
					YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
					YamlManager SkillList  = Config_YC.getNewConfig("Skill/SkillList.yml");
					SkillList.removeKey(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
					SkillList.saveConfig();
					AllSkillsGUI(player, Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1,false,"Maple");
					GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
					J.AllPlayerFixAllSkillAndJobYML();
				}
			}
			return;
		}
	}

	public void IndividualSkillOptionGUIClick(InventoryClickEvent event)
	{
		String SkillName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();

		int size= SkillList.getConfigurationSection(SkillName+".SkillRank").getKeys(false).size();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AllSkillsGUI(player, 0,false,"Maple");
			break;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			break;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			IndividualSkillOptionGUI(player,page-1,SkillName);
			break;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			IndividualSkillOptionGUI(player,page+1,SkillName);
			break;
		case 49://�� ��ũ
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			SkillList.set(SkillName+".SkillRank."+(size+1)+".Command","null");
			SkillList.set(SkillName+".SkillRank."+(size+1)+".BukkitPermission",false);
			SkillList.set(SkillName+".SkillRank."+(size+1)+".MagicSpells","null");
			SkillList.set(SkillName+".SkillRank."+(size+1)+".SkillPoint",1000);
			SkillList.saveConfig();
			IndividualSkillOptionGUI(player,  page, SkillName);
			break;
		default :
			if(event.isLeftClick()==true&&event.isRightClick()==false)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				SkillRankOptionGUI(player,SkillName,(page*45)+event.getSlot()+1);
			}
			else if(event.isShiftClick()==true&&event.isRightClick()==true&&(page*45)+event.getSlot()!=0&&(page*45)+event.getSlot()+1==size)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				SkillList.removeKey(SkillName+".SkillRank."+(size));
				SkillList.saveConfig();
				IndividualSkillOptionGUI(player, page,SkillName);
				GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
				J.AllPlayerSkillRankFix();
			}
			return;
		}
	}
	
	public void SkillRankOptionGUIClick(InventoryClickEvent event)
	{
		String SkillName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		int SkillLevel = Integer.parseInt(ChatColor.stripColor(event.getInventory().getItem(45).getItemMeta().getLore().get(1)));
		
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();

		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 4://�ʿ� ��ų ����Ʈ
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : �ʿ��� ��ų ����Ʈ�� ������ �ּ���!");
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[�ּ� : 0] [�ִ� : "+Byte.MAX_VALUE+"]");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "SP");
			Main.UserData.get(player).setString((byte)2, SkillName);
			Main.UserData.get(player).setInt((byte)4,SkillLevel);
			return;
		case 11://Ŀ�ǵ� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.sendMessage(ChatColor.DARK_AQUA+"[��ų] : /Ŀ�ǵ� [������ Ŀ�ǵ� �Է�]");
			player.sendMessage(ChatColor.LIGHT_PURPLE+"  /Ŀ�ǵ� ����"+ChatColor.WHITE+" �Է½� Ŀ�ǵ� ����");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "SKC");
			Main.UserData.get(player).setString((byte)2, SkillName);
			Main.UserData.get(player).setInt((byte)4,SkillLevel);
			player.closeInventory();
			return;
		case 13://Ŀ�ǵ� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(SkillList.getBoolean(SkillName+".SkillRank."+SkillLevel+".BukkitPermission") == true)
				SkillList.set(SkillName+".SkillRank."+SkillLevel+".BukkitPermission", false);
			else
				SkillList.set(SkillName+".SkillRank."+SkillLevel+".BukkitPermission", true);
			SkillList.saveConfig();
			SkillRankOptionGUI(player, SkillName, SkillLevel);
			return;
		case 15://���� ����
			if(Bukkit.getPluginManager().isPluginEnabled("MagicSpells") == true)
			{
				s.SP(player, Sound.HORSE_ARMOR, 0.8F, 1.9F);
				player.closeInventory();
				new OtherPlugins.SpellMain().ShowAllMaigcGUI(player, 0,SkillName,SkillLevel,0);
			}
			else
				s.SP(player, Sound.ANVIL_LAND, 1.0F, 1.8F);
			return;
		case 19://���� ���� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			switch(SkillList.getString(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon") )
			{
				case "����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "���� ����");
					break;
				case "���� ����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "�Ѽ� ��");
					break;
				case "�Ѽ� ��":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "��� ��");
					break;
				case "��� ��":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "����");
					break;
				case "����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "��");
					break;
				case "��":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "���Ÿ� ����");
					break;
				case "���Ÿ� ����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "Ȱ");
					break;
				case "Ȱ":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "����");
					break;
				case "����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "���� ����");
					break;
				case "���� ����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "����");
					break;
				case "����":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "������");
					break;
				case "������":
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".DistrictWeapon", "����");
					break;
			}
			SkillList.saveConfig();
			SkillRankOptionGUI(player, SkillName, SkillLevel);
			return;
		case 21://��ų ����� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(Bukkit.getPluginManager().isPluginEnabled("MagicSpells") == true)
			{
				String switchNeed = SkillList.getString(SkillName+".SkillRank."+SkillLevel+".AffectStat");
				if(switchNeed.compareTo("����")==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", "�����");
				else if(switchNeed.compareTo("�����")==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", "����");
				else if(switchNeed.compareTo("����")==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", GBD.GoldBigDragon_Advanced.Main.ServerOption.STR);
				else if(switchNeed.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.STR)==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX);
				else if(switchNeed.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX)==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", GBD.GoldBigDragon_Advanced.Main.ServerOption.INT);
				else if(switchNeed.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.INT)==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL);
				else if(switchNeed.compareTo(GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL)==0)
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK);
				else
					SkillList.set(SkillName+".SkillRank."+SkillLevel+".AffectStat", "����");

				SkillList.saveConfig();
				SkillRankOptionGUI(player, SkillName, SkillLevel);
			}
			else
			{
				s.SP(player, Sound.ANVIL_LAND, 1.0F, 1.8F);
			}
			return;

		case 23://��ų ����
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ��ų ������ �ۼ� �� �ּ���!");
			player.sendMessage(ChatColor.GOLD + "%enter%"+ChatColor.WHITE + " - ���� ��� ���� -");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c" +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "SKL");
			Main.UserData.get(player).setString((byte)2, SkillName);
			Main.UserData.get(player).setInt((byte)4,SkillLevel);
			player.closeInventory();
			return;
		case 28://���ʽ� �����
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ����� ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BH");
			break;
		case 29://���ʽ� ����
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ���� ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BM");
			break;
		case 30://���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BSTR");
			break;
		case 31://���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BDEX");
			break;
		case 32://���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BINT");
			break;
		case 33://���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BWILL");
			break;
		case 34://���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BLUK");
			break;
		case 37://���ʽ� �뷱��
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� �뷱�� ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BBAL");
			break;
		case 38://���ʽ� ũ��Ƽ��
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ũ��Ƽ�� ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BCRI");
			break;
		case 39://���ʽ� ���
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ��� ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BDEF");
			break;
		case 40://���ʽ� ��ȣ
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ��ȣ ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BPRO");
			break;
		case 41://���ʽ� ���� ���
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ���� ��� ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BMDEF");
			break;
		case 42://���ʽ� ���� ��ȣ
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[��ų] : ���ʽ� ���� ��ȣ ��ġ�� �Է��� �ּ���!");
			Main.UserData.get(player).setType("Skill");
			Main.UserData.get(player).setString((byte)1, "BMPRO");
			break;
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			IndividualSkillOptionGUI(player, 0, SkillName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
		player.closeInventory();
		player.sendMessage(ChatColor.LIGHT_PURPLE+"[�ּ� : "+Byte.MIN_VALUE+"] [�ִ� : "+Byte.MAX_VALUE+"]");
		s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
		Main.UserData.get(player).setType("Skill");
		Main.UserData.get(player).setString((byte)2, SkillName);
		Main.UserData.get(player).setInt((byte)4,SkillLevel);
	}

}
