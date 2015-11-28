package GBD.GoldBigDragon_Advanced.GUI;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import GBD.GoldBigDragon_Advanced.Main.Main;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class AreaGUI extends GUIutil
{
	public void AreaListGUI(Player player, int page)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");

		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "��ü ���� ��� : " + (page+1));

		Object[] AreaList= AreaConfig.getConfigurationSection("").getKeys(false).toArray();
		
		int loc=0;
		for(int count = page*45; count < AreaList.length;count++)
		{
			String AreaName = AreaList[count].toString();
			
			if(count > AreaList.length || loc >= 45) break;
			String world = AreaConfig.getString(AreaName+".World");
			int MinXLoc = AreaConfig.getInt(AreaName+".X.Min");
			int MinYLoc = AreaConfig.getInt(AreaName+".Y.Min");
			int MinZLoc = AreaConfig.getInt(AreaName+".Z.Min");
			int MaxXLoc = AreaConfig.getInt(AreaName+".X.Max");
			int MaxYLoc = AreaConfig.getInt(AreaName+".Y.Max");
			int MaxZLoc = AreaConfig.getInt(AreaName+".Z.Max");
			if(AreaConfig.contains(AreaName+".Priority")==false)
			{
				AreaConfig.set(AreaName+".Priority", 5);
				AreaConfig.saveConfig();
			}
			
			int Priority = AreaConfig.getInt(AreaName+".Priority");
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + AreaName, 395,0,1,Arrays.asList(
					ChatColor.DARK_AQUA+"���� : "+world,ChatColor.DARK_AQUA+"X ���� : "+MinXLoc+" ~ " + MaxXLoc
					,ChatColor.DARK_AQUA+"Y ���� : "+MinYLoc+" ~ " + MaxYLoc
					,ChatColor.DARK_AQUA+"Z ���� : "+MinZLoc+" ~ " + MaxZLoc
					,ChatColor.DARK_AQUA+"�켱 ���� : "+ Priority
					,ChatColor.DARK_GRAY+"�������� ���� ��ĥ ���",
					ChatColor.DARK_GRAY+"�켱 ������ �� ���� ������",
					ChatColor.DARK_GRAY+"����˴ϴ�."
					,"",ChatColor.YELLOW+"[�� Ŭ���� ���� ����]",ChatColor.RED+"[Shift + ��Ŭ���� ���� ����]"), loc, inv);
			
			loc=loc+1;
		}
		
		if(AreaList.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ����", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ������ �����մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�."), 53, inv);
		player.openInventory(inv);
		return;
	}
	
	public void AreaGUI_Main (Player player, String AreaName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "���� ����");

		if(AreaConfig.getBoolean(AreaName+".BlockPlace") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[��� ��ġ]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   �ź�   ]",""), 10, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[��� ��ġ]", 2,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ���   ]",""), 10, inv);

		if(AreaConfig.getBoolean(AreaName+".BlockBreak") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[��� �ı�]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   �ź�   ]",""), 11, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[��� �ı�]", 278,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ���   ]",""), 11, inv);

		if(AreaConfig.getBoolean(AreaName+".PVP") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[   PVP   ]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   �ź�   ]",""), 12, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[   PVP   ]", 267,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ���   ]",""), 12, inv);

		if(AreaConfig.getBoolean(AreaName+".MobSpawn") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� ����]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   �ź�   ]",""), 13, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� ����]", 52,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ���   ]",""), 13, inv);

		if(AreaConfig.getBoolean(AreaName+".Alert") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� �޽���]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   ����   ]",""), 14, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� �޽���]", 340,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ����   ]",""), 14, inv);

		if(AreaConfig.getBoolean(AreaName+".SpawnPoint") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[������ ���]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   �Ұ�   ]",""), 15, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[������ ���]", 397,3,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ����   ]",""), 15, inv);

		if(AreaConfig.getBoolean(AreaName+".Music") == false)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[����� ���]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   ����   ]",""), 16, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[����� ���]", 84,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   ���   ]",""), 16, inv);

		if(AreaConfig.getInt(AreaName+".RegenBlock") == 0)
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[��� ����]", 166,0,1,Arrays.asList("",ChatColor.RED + ""+ChatColor.BOLD+"[   ����   ]",""), 28, inv);
		else
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[��� ����]", 103,0,1,Arrays.asList("",ChatColor.GREEN + ""+ChatColor.BOLD+ "[   Ȱ��   ]","",ChatColor.DARK_AQUA+""+AreaConfig.getInt(AreaName+".RegenBlock")+" �� ���� ����","",ChatColor.RED+"[�÷��̾ ���� ĵ ��ϸ� ���� �˴ϴ�]",""), 28, inv);

		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[Ư��ǰ ����]", 15,0,1,Arrays.asList("",ChatColor.GRAY + "���� �������� ����� ĳ��",ChatColor.GRAY+"������ �������� ������",ChatColor.GRAY+"���� �մϴ�.","",ChatColor.YELLOW + "[Ŭ���� Ư��ǰ ����]"), 19, inv);
		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� ������]", 346,0,1,Arrays.asList("",ChatColor.GRAY + "���� �������� ���ø� �Ͽ�",ChatColor.GRAY+"���� �� �ִ� ������ Ȯ������",ChatColor.GRAY+"�����մϴ�.",ChatColor.YELLOW + "[Ŭ���� ���� ������ ����]"), 20, inv);
		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[�켱���� ����]", 384,0,1,Arrays.asList("",ChatColor.GRAY+"�������� ���� ��ĥ ���",ChatColor.GRAY+"�켱 ������ �� ���� ������",ChatColor.GRAY+"����˴ϴ�.",ChatColor.GRAY+"�� �Ӽ��� �̿��Ͽ� ������ �����,",ChatColor.GRAY+"���� ������ ���� ���� ��",ChatColor.GRAY+"������ ���� �� �ֽ��ϴ�.",ChatColor.BLUE+"[   ���� �켱 ����   ]",ChatColor.WHITE +" "+AreaConfig.getInt(AreaName+".Priority"),"",ChatColor.YELLOW + "[Ŭ���� �켱 ���� ����]"), 21, inv);
		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� ����]", 383,0,1,Arrays.asList("",ChatColor.GRAY + "���� �������� �ڿ�������",ChatColor.GRAY+"�����Ǵ� ���� ��ſ�",ChatColor.GRAY+"Ŀ���� ���ͷ� �����մϴ�.","",ChatColor.YELLOW + "[Ŭ���� Ŀ���� ���� ����]"), 22, inv);
		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� ���� ����]", 52,0,1,Arrays.asList("",ChatColor.GRAY + "���� ������ Ư�� ������",ChatColor.GRAY+"Ư�� �ð����� ���͸�",ChatColor.GRAY+"���� �մϴ�.","",ChatColor.YELLOW + "[Ŭ���� ���� ���� ����]"), 31, inv);
		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[�޽��� ����]", 386,0,1,Arrays.asList("",ChatColor.GRAY + "���� ���� �޽����� �����մϴ�.","",ChatColor.YELLOW + "[Ŭ���� ���� �޽��� ����]"), 23, inv);
		Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[�߽��� ����]", 138,0,1,Arrays.asList("",ChatColor.GRAY + "���� ��ȯ, �ֱ� �湮 ��ġ����",ChatColor.GRAY+"������ ���� ���� ��������",ChatColor.GRAY+"�ڷ���Ʈ �Ǵ� �̺�Ʈ�� �߻��� ���",ChatColor.GRAY+"���� ��ġ�� �߽����� �˴ϴ�.","",ChatColor.DARK_AQUA+"[  ���� �߽���  ]",ChatColor.DARK_AQUA+""+AreaConfig.getString(AreaName+".World")+" : "+AreaConfig.getInt(AreaName+".SpawnLocation.X")+","+AreaConfig.getInt(AreaName+".SpawnLocation.Y")+","+AreaConfig.getInt(AreaName+".SpawnLocation.Z"),"",ChatColor.YELLOW+ "[Ŭ���� ���� ��ġ�� ����]"), 24, inv);
		if(Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI") == true)
		{
			String lore = "";
			int tracknumber = AreaConfig.getInt(AreaName+".BGM");
			lore = " %enter%"+ChatColor.GRAY + "���� ����� �׸� ����%enter%"+ChatColor.GRAY+"��� ��ų �� �ֽ��ϴ�.%enter% %enter%"+ChatColor.BLUE + "[Ŭ���� ��Ʈ��� ���� ����]%enter% %enter%"+ChatColor.DARK_AQUA+"[Ʈ��] "+ChatColor.BLUE +""+ tracknumber+"%enter%"
			+ChatColor.DARK_AQUA+"[����] "+ChatColor.BLUE +""+ new OtherPlugins.NoteBlockAPIMain().getTitle(tracknumber)+"%enter%"
			+ChatColor.DARK_AQUA+"[����] "+ChatColor.BLUE+new OtherPlugins.NoteBlockAPIMain().getAuthor(tracknumber)+"%enter%"+ChatColor.DARK_AQUA+"[����] ";
			
			String Description = new OtherPlugins.NoteBlockAPIMain().getDescription(AreaConfig.getInt(AreaName+".BGM"));
			String lore2="";
			int a = 0;
			for(int count = 0; count <Description.toCharArray().length; count++)
			{
				lore2 = lore2+ChatColor.BLUE+Description.toCharArray()[count];
				a=a+1;
				if(a >= 15)
				{
					a = 0;
					lore2 = lore2+"%enter%      ";
				}
			}
			lore = lore + lore2;
			
			Stack2(ChatColor.WHITE + ""+ChatColor.BOLD+"[���� �����]", 2263,0,1,Arrays.asList(lore.split("%enter%")), 25, inv);
		}
		else
		{
			Stack2(ChatColor.RED + ""+ChatColor.BOLD+"[���� �����]", 2266,0,1,Arrays.asList("",ChatColor.GRAY + "���� ����� �׸� ����",ChatColor.GRAY+"��� ��ų �� �ֽ��ϴ�.","",ChatColor.RED + "[     �ʿ� �÷�����     ]",ChatColor.RED+" - NoteBlockAPI"), 25, inv);
		}
		
		Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "���� �̵�", 368,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� ������ �̵��մϴ�."), 40, inv);
		Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ������� ���ư��ϴ�."), 36, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "���� â�� �ݽ��ϴ�.",ChatColor.BLACK+AreaName), 44, inv);
		
		player.openInventory(inv);
		return;
	}
	
	public void AreaMonsterSpawnSettingGUI(Player player, int page, String AreaName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");

		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ���� ���� �� : " + (page+1));
		if(AreaConfig.contains(AreaName+".MonsterSpawnRule")==false)
		{
			AreaConfig.set(AreaName+".MonsterSpawnRule.1", null);
			AreaConfig.saveConfig();
		}
		Object[] RuleList= AreaConfig.getConfigurationSection(AreaName+".MonsterSpawnRule").getKeys(false).toArray();
		int loc=0;
		for(int count = page*45; count <RuleList.length ;count++)
		{
			if(count > RuleList.length || loc >= 45) break;
			String RuleNumber = RuleList[count].toString();
			if(AreaConfig.contains(AreaName+".MonsterSpawnRule."+RuleNumber+".Monster"))
				Stack2(ChatColor.BLACK + "" + ChatColor.BOLD + (RuleNumber), 383,0,1,Arrays.asList(
						ChatColor.GOLD+"[     ���� �ɼ�     ]",ChatColor.RED+"-������ ������ ���� ���� �۵� -",ChatColor.GOLD+"���� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.world"),
						ChatColor.GOLD+"��ǥ : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.x")+","+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.y")+","+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.z"),
						ChatColor.GOLD+"�ν� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".range")+"���",
						ChatColor.GOLD+"�ð� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".timer")+"�ʸ��� "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".count")+"���� ����",
						ChatColor.GOLD+"�ִ� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".max")+"����",
						ChatColor.GOLD+"���� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".Monster")
						,"",ChatColor.RED+"[Shift + ��Ŭ���� �� ����]"), loc, inv);
			else
				Stack2(ChatColor.BLACK + "" + ChatColor.BOLD + (RuleNumber), 52,0,1,Arrays.asList(
					ChatColor.GOLD+"[     ���� �ɼ�     ]",ChatColor.RED+"-������ ������ ���� ���� �۵� -",ChatColor.GOLD+"���� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.world"),
					ChatColor.GOLD+"��ǥ : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.x")+","+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.y")+","+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".loc.z"),
					ChatColor.GOLD+"�ν� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".range")+"���",
					ChatColor.GOLD+"�ð� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".timer")+"�ʸ��� "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".count")+"���� ����",
					ChatColor.GOLD+"�ִ� : "+AreaConfig.getString(AreaName+".MonsterSpawnRule."+RuleNumber+".max")+"����"
					,"",ChatColor.RED+"[Shift + ��Ŭ���� �� ����]"), loc, inv);
			loc=loc+1;
		}

		if(RuleList.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ��Ģ �߰�", 52,0,1,Arrays.asList(ChatColor.GRAY + "�� ���� ��Ģ�� �߰��մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK + AreaName), 53, inv);
		player.openInventory(inv);
		return;
	}
	
	public void AreaMonsterSettingGUI(Player player, int page, String AreaName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		YamlManager MonsterConfig =GUI_YC.getNewConfig("Monster/MonsterList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ��ü ���� : " + (page+1));

		Object[] MonsterNameList= AreaConfig.getConfigurationSection(AreaName+".Monster").getKeys(false).toArray();
		
		int loc=0;
		int MobNameListLength = MonsterNameList.length;
		for(int count = page*45; count <MobNameListLength ;count++)
		{
			String MonsterName = MonsterNameList[count].toString();
			if(MonsterConfig.contains(MonsterName) == true)
			{
				String Name = MonsterConfig.getString(MonsterName+".Name");
				if(count > MobNameListLength || loc >= 45) break;
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + MonsterName, 383,0,1,Arrays.asList(
						ChatColor.WHITE+"�̸� : " + Name,ChatColor.WHITE+"Ÿ�� : " + MonsterConfig.getString(MonsterName+".Type"),
						ChatColor.WHITE+"����� : " + MonsterConfig.getInt(MonsterName+".HP"),ChatColor.WHITE+"����ġ : " + MonsterConfig.getInt(MonsterName+".EXP"),
						ChatColor.WHITE+"��� : " + MonsterConfig.getInt(MonsterName+".MIN_Money")+" ~ " +MonsterConfig.getInt(MonsterName+".MAX_Money"),
						"",ChatColor.RED+"[Shift + ��Ŭ���� ��� ����]"), loc, inv);
				loc=loc+1;
			}
			else
			{
				AreaConfig.removeKey(AreaName+".Monster."+MonsterName);
				AreaConfig.saveConfig();
			}
		}
		
		if(MobNameListLength-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� �߰�", 52,0,1,Arrays.asList(ChatColor.GRAY + "�� Ŀ���� ���͸� �߰��մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK + AreaName), 53, inv);
		player.openInventory(inv);
		return;
	}
	
	public void AreaFishSettingGUI(Player player, String AreaName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� �߰� ���");
		
		Stack2(ChatColor.GREEN + "" + ChatColor.BOLD + "[     54%     ]", 160,5,1,Arrays.asList(ChatColor.GRAY + "�� �ٿ��� 54% Ȯ���� ���� �������� �ø�����."), 0, inv);
		Stack2(ChatColor.YELLOW + "" + ChatColor.BOLD + "[     30%     ]", 160,4,1,Arrays.asList(ChatColor.GRAY + "�� �ٿ��� 30% Ȯ���� ���� �������� �ø�����."), 9, inv);
		Stack2(ChatColor.GOLD + "" + ChatColor.BOLD + "[     10%     ]", 160,1,1,Arrays.asList(ChatColor.GRAY + "�� �ٿ��� 10% Ȯ���� ���� �������� �ø�����."), 18, inv);
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "[      5%      ]", 160,14,1,Arrays.asList(ChatColor.GRAY + "�� �ٿ��� 5% Ȯ���� ���� �������� �ø�����."), 27, inv);
		Stack2(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[      1%      ]", 160,10,1,Arrays.asList(ChatColor.GRAY + "�� �ٿ��� 1% Ȯ���� ���� �������� �ø�����."), 36, inv);

		Object[] FishingItemList = AreaConfig.getConfigurationSection(AreaName+".Fishing.54").getKeys(false).toArray();
		for(int count = 0; count < FishingItemList.length; count++)
			ItemStackStack(AreaConfig.getItemStack(AreaName+".Fishing.54."+FishingItemList[count]), count+1, inv);
		FishingItemList = AreaConfig.getConfigurationSection(AreaName+".Fishing.30").getKeys(false).toArray();
		for(int count = 0; count < FishingItemList.length; count++)
			ItemStackStack(AreaConfig.getItemStack(AreaName+".Fishing.30."+FishingItemList[count]), count+10, inv);
		FishingItemList = AreaConfig.getConfigurationSection(AreaName+".Fishing.10").getKeys(false).toArray();
		for(int count = 0; count < FishingItemList.length; count++)
			ItemStackStack(AreaConfig.getItemStack(AreaName+".Fishing.10."+FishingItemList[count]), count+19, inv);
		FishingItemList = AreaConfig.getConfigurationSection(AreaName+".Fishing.5").getKeys(false).toArray();
		for(int count = 0; count < FishingItemList.length; count++)
			ItemStackStack(AreaConfig.getItemStack(AreaName+".Fishing.5."+FishingItemList[count]), count+28, inv);
		FishingItemList = AreaConfig.getConfigurationSection(AreaName+".Fishing.1").getKeys(false).toArray();
		for(int count = 0; count < FishingItemList.length; count++)
			ItemStackStack(AreaConfig.getItemStack(AreaName+".Fishing.1."+FishingItemList[count]), count+37, inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK + AreaName), 53, inv);
		player.openInventory(inv);
	}
	
	public void AreaBlockSettingGUI(Player player, int page, String AreaName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		GBD.GoldBigDragon_Advanced.Event.Interact I = new GBD.GoldBigDragon_Advanced.Event.Interact();
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� Ư��ǰ : " + (page+1));

		Object[] BlockIdDataList= AreaConfig.getConfigurationSection(AreaName+".Mining").getKeys(false).toArray();
		
		int loc=0;
		for(int count = page*45; count <BlockIdDataList.length ;count++)
		{
			int ID = Integer.parseInt(BlockIdDataList[count].toString().split(":")[0]);
			int Data = Integer.parseInt(BlockIdDataList[count].toString().split(":")[1]);

			Stack2(I.SetItemDefaultName(ID, (byte) Data), ID,Data,1,Arrays.asList(
					"",ChatColor.RED+"[Shift + ��Ŭ���� ��� ����]"), loc, inv);
				loc=loc+1;
		}
		
		if(BlockIdDataList.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "Ư�깰 �߰�", 52,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ����� �����մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK + AreaName), 53, inv);
		player.openInventory(inv);
	}
	
	public void AreaBlockItemSettingGUI(Player player,String AreaName,String ItemData)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.BLACK + "�ش� ����� ĳ�� ���� ������");

		ItemStack item = AreaConfig.getItemStack(AreaName+".Mining."+ItemData);
		
		ItemStackStack(item, 4, inv);
		
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "[������ �ֱ�>", 166,0,1,null, 1, inv);	
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "[������ �ֱ�>", 166,0,1,null, 2, inv);
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "[������ �ֱ�>", 166,0,1,null, 3, inv);	
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "<������ �ֱ�]", 166,0,1,null, 5, inv);
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "<������ �ֱ�]", 166,0,1,null, 6, inv);	
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "<������ �ֱ�]", 166,0,1,null, 7, inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�.",ChatColor.BLACK+ItemData), 0, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK + AreaName), 8, inv);
		player.openInventory(inv);
		return;
	}
	
	public void AreaAddMonsterListGUI(Player player, int page,String AreaName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");
		GBD.GoldBigDragon_Advanced.Event.Damage d = new GBD.GoldBigDragon_Advanced.Event.Damage();
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ���� ���� : " + (page+1));

		Object[] a= MobList.getKeys().toArray();
		Object[] MonsterNameList= AreaConfig.getConfigurationSection(AreaName+".Monster").getKeys(false).toArray();
		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			if(count > a.length || loc >= 45) break;
			String MonsterName =a[count].toString();
			boolean isExit = false;
			for(int count2 = 0; count2 < MonsterNameList.length; count2++)
			{
				if(MonsterNameList[count2].toString().compareTo(MonsterName)==0)
				{
					isExit=true;
					break;
				}
			}
			
			if(isExit == false)
			{

				String Lore=null;
				
				Lore = "%enter%"+ChatColor.WHITE+""+ChatColor.BOLD+" �̸� : "+ChatColor.WHITE+MobList.getString(MonsterName+".Name")+"%enter%";
				Lore = Lore+ChatColor.WHITE+""+ChatColor.BOLD+" Ÿ�� : "+ChatColor.WHITE+MobList.getString(MonsterName+".Type")+"%enter%";
				Lore = Lore+ChatColor.WHITE+""+ChatColor.BOLD+" ���� ���̿� : "+ChatColor.WHITE+MobList.getString(MonsterName+".Biome")+"%enter%";
				Lore = Lore+ChatColor.RED+""+ChatColor.BOLD+" ����� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".HP")+"%enter%";
				Lore = Lore+ChatColor.AQUA+""+ChatColor.BOLD+" ����ġ : "+ChatColor.WHITE+MobList.getInt(MonsterName+".EXP")+"%enter%";
				Lore = Lore+ChatColor.YELLOW+""+ChatColor.BOLD+" ��� �ݾ� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".MIN_Money")+" ~ "+MobList.getInt(MonsterName+".MAX_Money")+"%enter%";
				Lore = Lore+ChatColor.RED+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".STR")
				+ChatColor.GRAY+ " [���� : " + d.CombatMinDamageGet(0, MobList.getInt(MonsterName+".STR")) + " ~ " + d.CombatMaxDamageGet(0, MobList.getInt(MonsterName+".STR")) + "]%enter%";
				Lore = Lore+ChatColor.GREEN+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".DEX")
				+ChatColor.GRAY+ " [Ȱ�� : " + d.RangeMinDamageGet(0, MobList.getInt(MonsterName+".DEX")) + " ~ " + d.RangeMaxDamageGet(0, MobList.getInt(MonsterName+".DEX")) + "]%enter%";
				Lore = Lore+ChatColor.DARK_AQUA+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".INT")
				+ChatColor.GRAY+ " [���� : " + (MobList.getInt(MonsterName+".INT")/4)+ " ~ "+(int)(MobList.getInt(MonsterName+".INT")/2.5)+"]%enter%";
				Lore = Lore+ChatColor.GRAY+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".WILL")
				+ChatColor.GRAY+ " [ũ�� : " + d.getCritical(MobList.getInt(MonsterName+".LUK"), (int)MobList.getInt(MonsterName+".WILL")) + " %]%enter%";
				Lore = Lore+ChatColor.YELLOW+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".LUK")
				+ChatColor.GRAY+ " [ũ�� : " + d.getCritical(MobList.getInt(MonsterName+".LUK"), (int)MobList.getInt(MonsterName+".WILL")) + " %]%enter%";
				Lore = Lore+ChatColor.GRAY+""+ChatColor.BOLD+" ��� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".DEF")+"%enter%";
				Lore = Lore+ChatColor.AQUA+""+ChatColor.BOLD+" ��ȣ : "+ChatColor.WHITE+MobList.getInt(MonsterName+".Protect")+"%enter%";
				Lore = Lore+ChatColor.BLUE+""+ChatColor.BOLD+" ���� ��� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".Magic_DEF")+"%enter%";
				Lore = Lore+ChatColor.DARK_BLUE+""+ChatColor.BOLD+" ���� ��ȣ : "+ChatColor.WHITE+MobList.getInt(MonsterName+".Magic_Protect")+"%enter%";
				Lore = Lore+"%enter%"+ChatColor.YELLOW+""+ChatColor.BOLD+"[�� Ŭ���� ���� ���]";

				String[] scriptA = Lore.split("%enter%");
				for(int counter = 0; counter < scriptA.length; counter++)
					scriptA[counter] =  " "+scriptA[counter];
				int id = 383;
				int data = 0;
				switch(MobList.getString(MonsterName+".Type"))
				{
					case "����ũ����" : case "ũ����" : data=50; break;
					case "�״����̷���" : case "���̷���" : data=51; break;
					case "�Ź�" : data=52; break;
					case "����" :case "���̾�Ʈ" : data=54; break;
					case "�ʴ���������" :case "Ư�뽽����" : case "ū������" :case "���뽽����" : case "����������" : data=55; break;
					case "����Ʈ" : data=56; break;
					case "�����Ǳ׸�" : data=57; break;
					case "������" : data=58; break;
					case "�����Ź�" : data=59; break;
					case "������" : data=60; break;
					case "������" : data=61; break;
					case "ū���׸�ť��" :case "Ư�븶�׸�ť��" : case "���븶�׸�ť��": case "���׸�ť��" : case "�������׸�ť��" : data=62; break;
					case "����" : data=65; break;
					case "����" : data=66; break;
					case "���������" : data=67; break;
					case "��ȣ��" : data=68; break;
					case "����" : data=90; break;
					case "��" : data=91; break;
					case "��" : data=92; break;
					case "��" : data=93; break;
					case "��¡��" : data=94; break;
					case "����" : data=95; break;
					case "������" : data=96; break;
					case "������" : data=98; break;
					case "��" : data=100; break;
					case "�䳢" : data=101; break;
					case "�ֹ�" : data=120; break;
					case "����" : id=399; break;
					case "�����巡��" : id=122; break;
					case "����ũ����Ż" : id=46; break;
				}
				
				Stack(ChatColor.WHITE+MonsterName, id, data, 1,Arrays.asList(scriptA), loc, inv);
				loc=loc+1;
			}
		}
		
		if(a.length-(page*44)>45)
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+AreaName), 53, inv);
		player.openInventory(inv);
	}
	
	public void AreaSpawnSpecialMonsterListGUI(Player player, int page,String AreaName,String RuleCount)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");
		GBD.GoldBigDragon_Advanced.Event.Damage d = new GBD.GoldBigDragon_Advanced.Event.Damage();
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� Ư�� ����  : " + (page+1));

		Object[] a= MobList.getKeys().toArray();

		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			if(count > a.length || loc >= 45) break;
			String MonsterName =a[count].toString();
			String Lore=null;
			
			Lore = "%enter%"+ChatColor.WHITE+""+ChatColor.BOLD+" �̸� : "+ChatColor.WHITE+MobList.getString(MonsterName+".Name")+"%enter%";
			Lore = Lore+ChatColor.WHITE+""+ChatColor.BOLD+" Ÿ�� : "+ChatColor.WHITE+MobList.getString(MonsterName+".Type")+"%enter%";
			Lore = Lore+ChatColor.WHITE+""+ChatColor.BOLD+" ���� ���̿� : "+ChatColor.WHITE+MobList.getString(MonsterName+".Biome")+"%enter%";
			Lore = Lore+ChatColor.RED+""+ChatColor.BOLD+" ����� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".HP")+"%enter%";
			Lore = Lore+ChatColor.AQUA+""+ChatColor.BOLD+" ����ġ : "+ChatColor.WHITE+MobList.getInt(MonsterName+".EXP")+"%enter%";
			Lore = Lore+ChatColor.YELLOW+""+ChatColor.BOLD+" ��� �ݾ� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".MIN_Money")+" ~ "+MobList.getInt(MonsterName+".MAX_Money")+"%enter%";
			Lore = Lore+ChatColor.RED+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".STR")
			+ChatColor.GRAY+ " [���� : " + d.CombatMinDamageGet(0, MobList.getInt(MonsterName+".STR")) + " ~ " + d.CombatMaxDamageGet(0, MobList.getInt(MonsterName+".STR")) + "]%enter%";
			Lore = Lore+ChatColor.GREEN+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".DEX")
			+ChatColor.GRAY+ " [Ȱ�� : " + d.RangeMinDamageGet(0, MobList.getInt(MonsterName+".DEX")) + " ~ " + d.RangeMaxDamageGet(0, MobList.getInt(MonsterName+".DEX")) + "]%enter%";
			Lore = Lore+ChatColor.DARK_AQUA+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".INT")
			+ChatColor.GRAY+ " [���� : " + (MobList.getInt(MonsterName+".INT")/4)+ " ~ "+(int)(MobList.getInt(MonsterName+".INT")/2.5)+"]%enter%";
			Lore = Lore+ChatColor.GRAY+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".WILL")
			+ChatColor.GRAY+ " [ũ�� : " + d.getCritical(MobList.getInt(MonsterName+".LUK"), (int)MobList.getInt(MonsterName+".WILL")) + " %]%enter%";
			Lore = Lore+ChatColor.YELLOW+""+ChatColor.BOLD+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : "+ChatColor.WHITE+MobList.getInt(MonsterName+".LUK")
			+ChatColor.GRAY+ " [ũ�� : " + d.getCritical(MobList.getInt(MonsterName+".LUK"), (int)MobList.getInt(MonsterName+".WILL")) + " %]%enter%";
			Lore = Lore+ChatColor.GRAY+""+ChatColor.BOLD+" ��� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".DEF")+"%enter%";
			Lore = Lore+ChatColor.AQUA+""+ChatColor.BOLD+" ��ȣ : "+ChatColor.WHITE+MobList.getInt(MonsterName+".Protect")+"%enter%";
			Lore = Lore+ChatColor.BLUE+""+ChatColor.BOLD+" ���� ��� : "+ChatColor.WHITE+MobList.getInt(MonsterName+".Magic_DEF")+"%enter%";
			Lore = Lore+ChatColor.DARK_BLUE+""+ChatColor.BOLD+" ���� ��ȣ : "+ChatColor.WHITE+MobList.getInt(MonsterName+".Magic_Protect")+"%enter%";
			Lore = Lore+"%enter%"+ChatColor.YELLOW+""+ChatColor.BOLD+"[�� Ŭ���� ���� ���]";

			String[] scriptA = Lore.split("%enter%");
			for(int counter = 0; counter < scriptA.length; counter++)
				scriptA[counter] =  " "+scriptA[counter];
			int id = 383;
			int data = 0;
			switch(MobList.getString(MonsterName+".Type"))
			{
				case "����ũ����" : case "ũ����" : data=50; break;
				case "�״����̷���" : case "���̷���" : data=51; break;
				case "�Ź�" : data=52; break;
				case "����" :case "���̾�Ʈ" : data=54; break;
				case "�ʴ���������" :case "Ư�뽽����" : case "ū������" :case "���뽽����" : case "����������" : data=55; break;
				case "����Ʈ" : data=56; break;
				case "�����Ǳ׸�" : data=57; break;
				case "������" : data=58; break;
				case "�����Ź�" : data=59; break;
				case "������" : data=60; break;
				case "������" : data=61; break;
				case "ū���׸�ť��" :case "Ư�븶�׸�ť��" : case "���븶�׸�ť��": case "���׸�ť��" : case "�������׸�ť��" : data=62; break;
				case "����" : data=65; break;
				case "����" : data=66; break;
				case "���������" : data=67; break;
				case "��ȣ��" : data=68; break;
				case "����" : data=90; break;
				case "��" : data=91; break;
				case "��" : data=92; break;
				case "��" : data=93; break;
				case "��¡��" : data=94; break;
				case "����" : data=95; break;
				case "������" : data=96; break;
				case "������" : data=98; break;
				case "��" : data=100; break;
				case "�䳢" : data=101; break;
				case "�ֹ�" : data=120; break;
				case "����" : id=399; break;
				case "�����巡��" : id=122; break;
				case "����ũ����Ż" : id=46; break;
			}
			
			Stack(ChatColor.WHITE+MonsterName, id, data, 1,Arrays.asList(scriptA), loc, inv);
			loc=loc+1;
		}
		
		if(a.length-(page*44)>45)
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���", 166,0,1,Arrays.asList(ChatColor.GRAY + "���� ���� �������",ChatColor.GRAY+"������ ��� �� ���͸�",ChatColor.GRAY+"�����ϰ� ���� �մϴ�.",ChatColor.BLACK+AreaName,ChatColor.BLACK+""+RuleCount), 49, inv);
		player.openInventory(inv);
	}

	public void AreaMusicSettingGUI(Player player, int page,String AreaName)
	{
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ����� : " + (page+1));
		int loc=0;
		int model = new GBD.GoldBigDragon_Advanced.Util.Number().RandomNum(0, 11);
		for(int count = page*45; count < new OtherPlugins.NoteBlockAPIMain().Musics.size();count++)
		{
			if(model<11)
				model=model+1;
			else
				model=0;
			String lore = " %enter%"+ChatColor.DARK_AQUA+"[Ʈ��] "+ChatColor.BLUE +""+ count+"%enter%"
			+ChatColor.DARK_AQUA+"[����] "+ChatColor.BLUE +""+ new OtherPlugins.NoteBlockAPIMain().getTitle(count)+"%enter%"
			+ChatColor.DARK_AQUA+"[����] "+ChatColor.BLUE+new OtherPlugins.NoteBlockAPIMain().getAuthor(count)+"%enter%"+ChatColor.DARK_AQUA+"[����] ";
			String Description = new OtherPlugins.NoteBlockAPIMain().getDescription(count);
			String lore2="";
			int a = 0;
			for(int counter = 0; counter <Description.toCharArray().length; counter++)
			{
				lore2 = lore2+ChatColor.BLUE+Description.toCharArray()[counter];
				a=a+1;
				if(a >= 15)
				{
					a = 0;
					lore2 = lore2+"%enter%      ";
				}
			}
			lore = lore + lore2+"%enter% %enter%"+ChatColor.YELLOW+"[�� Ŭ���� ����� ����]";
			if(count > new OtherPlugins.NoteBlockAPIMain().Musics.size() || loc >= 45) break;
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + count, 2256+model,0,1,Arrays.asList(lore.split("%enter%")), loc, inv);
			
			loc=loc+1;
		}
		
		if(new OtherPlugins.NoteBlockAPIMain().Musics.size()-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+AreaName), 53, inv);
		player.openInventory(inv);
	}
	
	
	public void AreaListGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		String AreaName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI OGUI = new OPBoxGUI();
			OGUI.OPBoxGUI_Main(player, 2);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaListGUI(player, page-1);
			return;
		case 49://�� ����
			YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
			YamlManager Config = Event_YC.getNewConfig("config.yml");
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			GBD.GoldBigDragon_Advanced.Event.Interact IT = new GBD.GoldBigDragon_Advanced.Event.Interact();
			player.sendMessage(ChatColor.DARK_AQUA + "[����] : " + IT.SetItemDefaultName(Config.getInt("Server.AreaSettingWand"),(byte)0) +ChatColor.DARK_AQUA+" ���������� ������ ������ �� ��,");
			player.sendMessage(ChatColor.GOLD +""+ChatColor.BOLD+ " /���� <�����̸�> ���� "+ChatColor.DARK_AQUA+"��ɾ �Է��� �ּ���!");
			s.SP((Player)player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaListGUI(player, page+1);
			return;
		default :
			if(event.isLeftClick() == true)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				AreaGUI_Main(player, AreaName);
			}
			else if(event.isShiftClick() == true && event.isRightClick() == true)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
				AreaConfig.removeKey(AreaName);
				AreaConfig.saveConfig();
				AreaListGUI(player, page);
			}
			return;
		}
	}
	
	public void AreaGUIInventoryclick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(44).getItemMeta().getLore().get(1));

		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getSlot() == 44)//â�ݱ�
		{
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
		s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
		
		if(event.getSlot() == 36)//���� ���
		{
			AreaListGUI(player,0);
			return;
		}
		
		switch (event.getSlot())
		{
		case 10://��� ��ġ
			if(AreaConfig.getBoolean(AreaName+".BlockPlace") == false)
				AreaConfig.set(AreaName+".BlockPlace", true);
			else
				AreaConfig.set(AreaName+".BlockPlace", false);
			break;
		case 11://��� �ı�
			if(AreaConfig.getBoolean(AreaName+".BlockBreak") == false)
				AreaConfig.set(AreaName+".BlockBreak", true);
			else
				AreaConfig.set(AreaName+".BlockBreak", false);
			break;
		case 12://PVP
			if(AreaConfig.getBoolean(AreaName+".PVP") == false)
				AreaConfig.set(AreaName+".PVP", true);
			else
				AreaConfig.set(AreaName+".PVP", false);
			break;
		case 13://���� ����
			if(AreaConfig.getBoolean(AreaName+".MobSpawn") == false)
				AreaConfig.set(AreaName+".MobSpawn", true);
			else
				AreaConfig.set(AreaName+".MobSpawn", false);
			break;
		case 14://���� �޽���
			if(AreaConfig.getBoolean(AreaName+".Alert") == false)
				AreaConfig.set(AreaName+".Alert", true);
			else
				AreaConfig.set(AreaName+".Alert", false);
			break;
		case 15://������ ���
			if(AreaConfig.getBoolean(AreaName+".SpawnPoint") == false)
				AreaConfig.set(AreaName+".SpawnPoint", true);
			else
				AreaConfig.set(AreaName+".SpawnPoint", false);
			break;
		case 16://����� ���
			if(AreaConfig.getBoolean(AreaName+".Music") == false)
				AreaConfig.set(AreaName+".Music", true);
			else
				AreaConfig.set(AreaName+".Music", false);
			break;
		case 19://Ư��ǰ ����
			AreaBlockSettingGUI(player, 0, AreaName);
			return;
		case 20://���� ������
			AreaFishSettingGUI(player, AreaName);
			return;
		case 21://�켱 ���� ����
			player.closeInventory();
			Main.UserData.get(player).setType("Area");
			Main.UserData.get(player).setString((byte)2, "Priority");
			Main.UserData.get(player).setString((byte)3, AreaName);
			player.sendMessage(ChatColor.GREEN + "[����] : "+ChatColor.YELLOW+AreaName+ChatColor.GREEN+" ������ �켱 ������ �Է��ϼ���!");
			player.sendMessage(ChatColor.GRAY + "(�ּ� 0 ~ �ִ� 100)");
			return;
		case 25://���� ����� ����
			if(Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI") == true)
			{
				OtherPlugins.NoteBlockAPIMain NBAPIM = new OtherPlugins.NoteBlockAPIMain();
				if(NBAPIM.SoundList(player,true))
					AreaMusicSettingGUI(player, 0, AreaName);
			}
			else
				s.SP(player, Sound.ANVIL_LAND, 1.0F, 1.9F);
			return;
		case 22://���� ����
			AreaMonsterSettingGUI(player,0, AreaName);
			return;
		case 31://���� ���� ��
			AreaMonsterSpawnSettingGUI(player, 0, AreaName);
			return;
		case 23://�޽��� ����
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.sendMessage(ChatColor.GOLD + "/���� "+AreaName+" �̸� <���ڿ�>" + ChatColor.YELLOW + "\n - "+AreaName+" ������ �˸� �޽����� ���� �̸��� ���մϴ�.");
			player.sendMessage(ChatColor.GOLD + "/���� "+AreaName+" ���� <���ڿ�>" + ChatColor.YELLOW + "\n - "+AreaName+" ������ �˸� �޽����� ���� �ΰ� ������ ���մϴ�.");
			player.sendMessage(ChatColor.GOLD + "%player%"+ChatColor.WHITE + " - �÷��̾� ��Ī�ϱ� -");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			player.closeInventory();
			return;
		case 24://�߽��� ����
			AreaConfig.set(AreaName+".World", player.getLocation().getWorld().getName());
			AreaConfig.set(AreaName+".SpawnLocation.X", player.getLocation().getX());
			AreaConfig.set(AreaName+".SpawnLocation.Y", player.getLocation().getY());
			AreaConfig.set(AreaName+".SpawnLocation.Z", player.getLocation().getZ());
			AreaConfig.set(AreaName+".SpawnLocation.Pitch", player.getLocation().getPitch());
			AreaConfig.set(AreaName+".SpawnLocation.Yaw", player.getLocation().getYaw());
			break;

		case 28://��� ����
			if(AreaConfig.getInt(AreaName+".RegenBlock") == 0)
			{
				player.closeInventory();
				AreaConfig.set(AreaName+".RegenBlock", 1);
				AreaConfig.saveConfig();
				Main.UserData.get(player).setType("Area");
				Main.UserData.get(player).setString((byte)2, "ARR");
				Main.UserData.get(player).setString((byte)3, AreaName);
				player.sendMessage(ChatColor.GREEN + "[����] : "+ChatColor.YELLOW+AreaName+ChatColor.GREEN+" ������ ��� ���� �ӵ��� �����ϼ���!");
				player.sendMessage(ChatColor.GRAY + "(�ּ� 1�� ~ �ִ� 3600��(1�ð�))");
			}
			else
			{
				AreaConfig.set(AreaName+".RegenBlock", 0);
				AreaConfig.saveConfig();
				AreaGUI_Main(player, AreaName);
			}
			return;
		case 40://���� �̵�
			player.closeInventory();
			player.teleport(new Location(Bukkit.getWorld(AreaConfig.getString(AreaName+".World")),AreaConfig.getInt(AreaName+".SpawnLocation.X"), AreaConfig.getInt(AreaName+".SpawnLocation.Y"),AreaConfig.getInt(AreaName+".SpawnLocation.Z"),AreaConfig.getInt(AreaName+".SpawnLocation.Yaw"),AreaConfig.getInt(AreaName+".SpawnLocation.Pitch")));
			break;
		}
		AreaConfig.saveConfig();
		AreaGUI_Main(player, AreaName);
		return;
	}

	public void AreaMonsterSettingGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		String AreaName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		String MonsterName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;

		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaGUI_Main(player, AreaName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMonsterSettingGUI(player, page-1, AreaName);
			return;
		case 49://���� �߰�
			YamlManager MonsterConfig =GUI_YC.getNewConfig("Monster/MonsterList.yml");
			if(MonsterConfig.getConfigurationSection("").getKeys(false).size() == 0)
			{
				s.SP(player,Sound.ORB_PICKUP,1.0F, 1.8F);
				player.sendMessage(ChatColor.RED + "[����] : ���� ��ϵ� Ŀ���� ���Ͱ� �������� �ʽ��ϴ�!");
				player.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD + "/���� <�̸�> ���� " + ChatColor.YELLOW +"�ش� �̸��� ���� ���͸� �����մϴ�.");
			}
			else
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				AreaAddMonsterListGUI(player, page, AreaName);
			}
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMonsterSettingGUI(player, page+1,AreaName);
			return;
		default :
			if(event.isShiftClick() == true && event.isRightClick() == true)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				AreaConfig.removeKey(AreaName+".Monster."+MonsterName);
				AreaConfig.saveConfig();
				AreaMonsterSettingGUI(player, page,AreaName);
			}
			return;
		}
	}

	public void AreaFishSettingGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		Player player = (Player) event.getWhoClicked();

		String AreaName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));

		switch (event.getSlot())
		{
		case 0:
		case 9:
		case 18:
		case 27:
		case 36:
			event.setCancelled(true);
			return;
		case 45://���� ���
			event.setCancelled(true);
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaGUI_Main(player, AreaName);
			return;
		case 53://������
			event.setCancelled(true);
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}

	public void AreaBlockSettingGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		String BlockName = event.getCurrentItem().getTypeId()+":"+event.getCurrentItem().getData().getData();
		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaGUI_Main(player, AreaName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaBlockSettingGUI(player, page-1, AreaName);
			return;
		case 49://Ư�깰 �߰�
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			player.sendMessage(ChatColor.DARK_AQUA + "[����] : ������ ����� ��Ŭ�� �ϼ���!");

			Main.UserData.get(player).setType("Area");
			Main.UserData.get(player).setString((byte)2, AreaName);
			Main.UserData.get(player).setString((byte)3, "ANBI");
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaBlockSettingGUI(player, page+1, AreaName);
			return;
		default :
			if(event.isShiftClick()==false&&event.isLeftClick()==true)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				AreaBlockItemSettingGUI(player, AreaName, BlockName);
			}
			if(event.isShiftClick() == true && event.isRightClick() == true)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
				AreaConfig.removeKey(AreaName+".Mining."+BlockName);
				AreaConfig.saveConfig();
				AreaBlockSettingGUI(player, page, AreaName);
			}
			return;
		}
	}

	public void AreaBlockItemSettingGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		Player player = (Player) event.getWhoClicked();
		
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(8).getItemMeta().getLore().get(1));
		switch(event.getSlot())
		{
		case 1:
		case 2:
		case 3:
		case 5:
		case 6:
		case 7:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			event.setCancelled(true);
			return;
		case 0://���� ���
			event.setCancelled(true);
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaBlockSettingGUI(player, 0, AreaName);
			return;
		case 8://������
			event.setCancelled(true);
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}

	public void AreaAddMonsterSpawnRuleGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaGUI_Main(player, AreaName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMonsterSpawnSettingGUI(player, page-1, AreaName);
			return;
		case 49://�� �߰�
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			long count = new GBD.GoldBigDragon_Advanced.Util.ETC().getNowUTC();
			AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".range", 1);
			AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".count", 4);
			AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".timer", 10);
			AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".max", 10);
			Main.UserData.get(player).setType("Area");
			Main.UserData.get(player).setString((byte)1, count+"");
			Main.UserData.get(player).setString((byte)2, AreaName);
			Main.UserData.get(player).setString((byte)3, "MLS");
			AreaConfig.saveConfig();
			player.sendMessage(ChatColor.GREEN+"[����] : ���Ͱ� ���� �� ��ġ�� ���콺 �� Ŭ�� �ϼ���!");
			player.closeInventory();
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMonsterSpawnSettingGUI(player, page+1, AreaName);
			return;
		default :
			if(event.isRightClick()&&event.isShiftClick())
			{
				s.SP(player, Sound.LAVA_POP, 1.0F, 1.0F);
				AreaConfig.removeKey(AreaName+".MonsterSpawnRule."+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
				AreaConfig.saveConfig();
				AreaMonsterSpawnSettingGUI(player, page, AreaName);
			}
		}
	}
	
	
	public void AreaAddMonsterListGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMonsterSettingGUI(player, 0, AreaName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaAddMonsterListGUI(player, page-1, AreaName);
			return;
		case 49:
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaAddMonsterListGUI(player, page+1, AreaName);
			return;
		default :
			String MobName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
			s.SP(player, Sound.WOLF_BARK, 0.8F, 1.0F);
			YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
			YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
			AreaConfig.set(AreaName+".Monster."+MobName+".1", null);
			AreaConfig.saveConfig();
			AreaAddMonsterListGUI(player, page, AreaName);
			return;
		}
	}

	public void AreaSpawnSpecialMonsterListGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(49).getItemMeta().getLore().get(3));
		String RuleCounter = ChatColor.stripColor(event.getInventory().getItem(49).getItemMeta().getLore().get(4));

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 49://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			AreaMonsterSpawnSettingGUI(player, 0, AreaName);
			new GBD.GoldBigDragon_Advanced.ETC.Area().AreaMonsterSpawnAdd(AreaName, RuleCounter);
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaAddMonsterListGUI(player, page-1, AreaName);
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaAddMonsterListGUI(player, page+1, AreaName);
			return;
		default :
			String MobName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
			s.SP(player, Sound.ANVIL_LAND, 0.8F, 1.0F);
			YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
			YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
			AreaConfig.set(AreaName+".MonsterSpawnRule."+RuleCounter+".Monster", MobName);
			AreaConfig.saveConfig();
			AreaMonsterSpawnSettingGUI(player, 0, AreaName);
			
			new GBD.GoldBigDragon_Advanced.ETC.Area().AreaMonsterSpawnAdd(AreaName, RuleCounter);
			return;
		}
	}

	public void AreaMusicSettingGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		String AreaName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaGUI_Main(player, AreaName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMusicSettingGUI(player, page-1,AreaName);
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AreaMusicSettingGUI(player, page+1,AreaName);
			return;
		default :
			if(event.isLeftClick())
			{
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
				AreaConfig.set(AreaName+".BGM", Integer.parseInt(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())));
				AreaConfig.saveConfig();
				AreaGUI_Main(player, AreaName);
			}
			return;
		}
	}
}
