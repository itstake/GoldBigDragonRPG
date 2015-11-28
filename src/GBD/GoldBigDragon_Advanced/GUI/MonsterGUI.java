package GBD.GoldBigDragon_Advanced.GUI;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import GBD.GoldBigDragon_Advanced.Main.Main;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class MonsterGUI extends GUIutil
{

	public void MonsterListGUI(Player player, int page)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");
		GBD.GoldBigDragon_Advanced.Event.Damage d = new GBD.GoldBigDragon_Advanced.Event.Damage();
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ��� : " + (page+1));

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
			Lore = Lore+"%enter%"+ChatColor.YELLOW+""+ChatColor.BOLD+"[Shift + �� Ŭ���� ������ ����]"+"%enter%"+ChatColor.RED+""+ChatColor.BOLD+"[Shift + �� Ŭ���� ���� ����]";

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

		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ����", 339,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ���͸� �����մϴ�."), 49, inv);
		
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�."), 53, inv);
		player.openInventory(inv);
	}
	
	public void MonsterOptionSettingGUI(Player player,String MonsterName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");

		GBD.GoldBigDragon_Advanced.Event.Damage d = new GBD.GoldBigDragon_Advanced.Event.Damage();
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ����");

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

		
		String[] scriptA = Lore.split("%enter%");
		for(int counter = 0; counter < scriptA.length; counter++)
			scriptA[counter] =  " "+scriptA[counter];

		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 9, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 10, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 11, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 18, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 20, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 27, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 28, inv);
		Stack2(ChatColor.RED + "[    ����    ]", 52,0,1,null, 29, inv);
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
			case "�����" :id = 332; data=0; break;
			case "��" :id = 265; data=0; break;
			case "����" : id=399; break;
			case "�����巡��" : id=122; break;
			case "����ũ����Ż" : id=46; break;
		}

		Stack2(ChatColor.WHITE + MonsterName, id,data,1,Arrays.asList(scriptA), 19, inv);
		
		
		Stack2(ChatColor.DARK_AQUA + "[    �̸� ����    ]", 421,0,1,Arrays.asList(ChatColor.WHITE+"������ �̸���",ChatColor.WHITE+"�����մϴ�.","",ChatColor.WHITE+"[    ���� �̸�    ]"," "+ChatColor.WHITE+MobList.getString(MonsterName+".Name"),""), 13, inv);
		Stack2(ChatColor.DARK_AQUA + "[    Ÿ�� ����    ]", 383,0,1,Arrays.asList(ChatColor.WHITE+"������ Ÿ����",ChatColor.WHITE+"�����մϴ�.","",ChatColor.WHITE+"[    ���� Ÿ��    ]"," "+ChatColor.WHITE+MobList.getString(MonsterName+".Type"),""), 14, inv);

		data = 0;
		switch(MobList.getString(MonsterName+".Biome"))
		{
		case "BEACH" : id=337;break;
		case "DESERT" : id=12;break;
		case "EXTREME_HILLS" : id=129;break;
		case "FOREST" : id=17;break;
		case "HELL" : id=87;break;
		case "JUNGLE" : id=6;data=3;break;
		case "MESA" : id=159;break;
		case "OCEAN" : id=410;break;
		case "PLAINS" : id=2;break;
		case "RIVER" : id=346;break;
		case "SAVANNA" : id=32;break;
		case "SKY" : id=121;break;
		case "SMALL_MOUNTAINS" : id=6;data=0;break;
		case "SWAMPLAND" : id=111;break;
		case "TAIGA" : id=78;break;
		default : id=166;break;
		}
		
		Stack2(ChatColor.DARK_AQUA + "[ ���� ���̿� ���� ]", id,data,1,Arrays.asList(ChatColor.WHITE+"���Ͱ� �����ϴ�",ChatColor.WHITE+"���̿��� �����մϴ�.","",ChatColor.WHITE+"[    ���� ���̿�    ]"," "+ChatColor.WHITE+MobList.getString(MonsterName+".Biome"),""), 15, inv);
		Stack2(ChatColor.DARK_AQUA + "[    ����� ����    ]", 351,1,1,Arrays.asList(ChatColor.WHITE+"������ �������",ChatColor.WHITE+"�����մϴ�.","",ChatColor.WHITE+"[    ���� �����    ]"," "+ChatColor.WHITE+""+MobList.getInt(MonsterName+".HP"),""), 16, inv);
		Stack2(ChatColor.DARK_AQUA + "[    ����ġ ����    ]", 384,0,1,Arrays.asList(ChatColor.WHITE+"���� ��ɽ� ���",ChatColor.WHITE+"����ġ ���� �����մϴ�.","",ChatColor.WHITE+"[    ���� ����ġ    ]"," "+ChatColor.WHITE+""+MobList.getInt(MonsterName+".EXP"),""), 22, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ��� �ݾ� ����  ]", 266,0,1,Arrays.asList(ChatColor.WHITE+"���� ��ɽ� ���",ChatColor.WHITE+"�ݾ��� �����մϴ�.","",ChatColor.WHITE+"[    ���� �ݾ�    ]"," "+ChatColor.WHITE+""+MobList.getInt(MonsterName+".MIN_Money")+" ~ "+MobList.getInt(MonsterName+".MAX_Money"),""), 23, inv);
		Stack2(ChatColor.DARK_AQUA + "[    ��� ����    ]", 307,0,1,Arrays.asList(ChatColor.WHITE+"������ ���",ChatColor.WHITE+"���� �մϴ�.","",ChatColor.YELLOW+"[    ��Ŭ���� ����    ]",""), 24, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ��� ����� ����  ]", 54,0,1,Arrays.asList(ChatColor.WHITE+"���� ��ɽ� ����Ǵ�",ChatColor.WHITE+"��� Ȯ���� �����մϴ�.","",ChatColor.WHITE+"[    ���� �����    ]"," "+ChatColor.WHITE+"�Ӹ� : "+MobList.getInt(MonsterName+".Head.DropChance")/10.0+"%"
				," "+ChatColor.WHITE+"���� : "+MobList.getInt(MonsterName+".Chest.DropChance")/10.0+"%"
				," "+ChatColor.WHITE+"���� : "+MobList.getInt(MonsterName+".Leggings.DropChance")/10.0+"%"
				," "+ChatColor.WHITE+"�Ź� : "+MobList.getInt(MonsterName+".Boots.DropChance")/10.0+"%"
				," "+ChatColor.WHITE+"���� : "+MobList.getInt(MonsterName+".Hand.DropChance")/10.0+"%","",ChatColor.YELLOW+"[    ��Ŭ���� ����   ]",""), 25, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ���� ���� ����  ]", 399,0,1,Arrays.asList(ChatColor.WHITE+"������ �⺻ ������",ChatColor.WHITE+"�����մϴ�.",""), 31, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ���� ��� ����  ]", 310,0,1,Arrays.asList(ChatColor.WHITE+"������ ��� �� ��ȣ��",ChatColor.WHITE+"�����մϴ�.",""), 32, inv);
		
		Lore = ChatColor.WHITE+"������ AI�� �����մϴ�.%enter%%enter%"+ChatColor.WHITE+"[    ���� AI    ]%enter%"+ChatColor.WHITE+MobList.getString(MonsterName+".AI")+"%enter%%enter%";
		
		switch(MobList.getString(MonsterName+".AI"))
		{
		case "�Ϲ� �ൿ" :
			Lore = Lore+ChatColor.WHITE+"�Ϲ����� �ൿ�� �մϴ�.%enter%";
			break;
			
		case "���� ����" :
			Lore = Lore+ChatColor.WHITE+"������ ���� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%";break;
		case "���� �񼱰�" :
			Lore = Lore+ChatColor.WHITE+"���ݹ޾ƾ߸� ���� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%";break;

		case "���� ����" :
			Lore = Lore+ChatColor.WHITE+"������ ���� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.RED+"[������/��ȣ��/��/���� ��ȯ �Ұ�]%enter%"+
					ChatColor.GREEN+"[    ũ���� �Ҹ��� ���ϴ�.    ]%enter%";break;
		case "���� �񼱰�" :
			Lore = Lore+ChatColor.WHITE+"���ݹ޾ƾ߸� ���� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.RED+"[������/��ȣ��/��/���� ��ȯ �Ұ�]%enter%"+
					ChatColor.GREEN+"[    ũ���� �Ҹ��� ���ϴ�.    ]%enter%";break;

		case "���Ÿ� ����" :
			Lore = Lore+ChatColor.WHITE+"������ ���Ÿ� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���Ÿ� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.GRAY+"[   ���̷��� �Ҹ��� ���ϴ�.   ]%enter%"+
						ChatColor.YELLOW+"[���� �տ� Ȱ�� ���� ���Ѿ� �մϴ�.]%enter%";break;
		case "���Ÿ� �񼱰�" :
			Lore = Lore+ChatColor.WHITE+"���ݹ޾ƾ߸� ���Ÿ� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���Ÿ� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.GRAY+"[   ���̷��� �Ҹ��� ���ϴ�.   ]%enter%"+
					ChatColor.YELLOW+"[���� �տ� Ȱ�� ���� ���Ѿ� �մϴ�.]%enter%";break;
		case "����Ʈ ���Ÿ� ����" :
			Lore = Lore+ChatColor.WHITE+"������ ���Ÿ� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���Ÿ� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.GRAY+"[   ���̷��� �Ҹ��� ���ϴ�.   ]%enter%"+
						ChatColor.YELLOW+"[���� �տ� Ȱ�� ���� ���Ѿ� �մϴ�.]%enter%"+
			ChatColor.LIGHT_PURPLE+"[�� ���� 5���� ȭ���� �߻��մϴ�.]%enter%";break;
		case "����Ʈ ���Ÿ� �񼱰�" :
			Lore = Lore+ChatColor.WHITE+"���ݹ޾ƾ߸� ���Ÿ� �������մϴ�.%enter%"+
		ChatColor.WHITE+"���Ÿ� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.GRAY+"[   ���̷��� �Ҹ��� ���ϴ�.   ]%enter%"+
					ChatColor.YELLOW+"[���� �տ� Ȱ�� ���� ���Ѿ� �մϴ�.]%enter%"+
					ChatColor.LIGHT_PURPLE+"[�� ���� 5���� ȭ���� �߻��մϴ�.]%enter%";break;
		case "����" :
			Lore = Lore+ChatColor.WHITE+"�����ϰ� �����ϸ� ���ƴٴմϴ�..%enter%"+
		ChatColor.WHITE+"���� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�������� �ʽ��ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%"+
					ChatColor.RED+"[������/��ȣ��/�� ��ȯ �Ұ�]%enter%"+
					ChatColor.YELLOW+"[     ���� �Ҹ��� ���ϴ�.     ]%enter%";break;

		case "������" :
			Lore = Lore+ChatColor.WHITE+"���ݹ� �̵��� ���� �ʽ��ϴ�.%enter%"+
		ChatColor.WHITE+"������ AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%";break;
		case "����" :
			Lore = Lore+ChatColor.WHITE+"���ݹ��� ��� ����ġ�� �ٻڸ�,%enter%"+ChatColor.WHITE+"����� �������� �ʽ��ϴ�.%enter%"+
		ChatColor.WHITE+"���� AI�� ����ϴ� ���ʹ�%enter%"+ChatColor.WHITE+"�ϴ��� �� �� ���� �˴ϴ�.%enter%"+
					ChatColor.RED+"[AI���� �������� ������ ����]%enter%";break;
		}
		
		scriptA = Lore.split("%enter%");
		for(int counter = 0; counter < scriptA.length; counter++)
			scriptA[counter] =  " "+scriptA[counter];
		
		
		Stack2(ChatColor.DARK_AQUA + "[  ���� AI ����  ]", 137,0,1,Arrays.asList(scriptA), 33, inv);
		Stack2(ChatColor.DARK_AQUA + "[    ���� ȿ��    ]", 373,0,1,Arrays.asList(ChatColor.WHITE+"���Ϳ��� ���� ȿ����",ChatColor.WHITE+"�ο��մϴ�.",""), 34, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+MonsterName), 53, inv);
		player.openInventory(inv);
	}
	
	public void MonsterPotionGUI(Player player, String MonsterName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");

		GBD.GoldBigDragon_Advanced.Event.Damage d = new GBD.GoldBigDragon_Advanced.Event.Damage();
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "���� ����");

		
		Stack2(ChatColor.DARK_AQUA + "[  ���  ]", 373,8193,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.Regenerate")), 10, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ��  ]", 373,8196,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.Poison")), 11, inv);
		Stack2(ChatColor.DARK_AQUA + "[  �ż�  ]", 373,8194,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.Speed")), 12, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ����  ]", 373,8234,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.Slow")), 13, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ��  ]", 373,8201,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.Strength")), 14, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ������  ]", 373,8232,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.Weak")), 15, inv);
		Stack2(ChatColor.DARK_AQUA + "[  ����  ]", 373,8267,1,Arrays.asList(ChatColor.WHITE+"[  ���� ��  ]",ChatColor.YELLOW+" "+MobList.getInt(MonsterName+".Potion.JumpBoost")), 16, inv);

		if(MobList.getInt(MonsterName+".Potion.FireRegistance")!=0)
			Stack2(ChatColor.DARK_AQUA + "[  ȭ�� ����  ]", 373,8227,1,Arrays.asList(ChatColor.GREEN+"[  ���� ����  ]"), 19, inv);
		else
			Stack2(ChatColor.DARK_AQUA + "[  ȭ�� ����  ]", 166,0,1,Arrays.asList(ChatColor.RED+"[  ���� ������  ]"), 19, inv);
		if(MobList.getInt(MonsterName+".Potion.WaterBreath")!=0)
			Stack2(ChatColor.DARK_AQUA + "[  ���� ȣȩ  ]", 373,8237,1,Arrays.asList(ChatColor.GREEN+"[  ���� ����  ]"), 20, inv);
		else
			Stack2(ChatColor.DARK_AQUA + "[  ���� ȣȩ  ]", 166,0,1,Arrays.asList(ChatColor.RED+"[  ���� ������  ]"), 20, inv);
		if(MobList.getInt(MonsterName+".Potion.Invisible")!=0)
			Stack2(ChatColor.DARK_AQUA + "[  ����  ]", 373,8238,1,Arrays.asList(ChatColor.GREEN+"[  ���� ����  ]"), 21, inv);
		else
			Stack2(ChatColor.DARK_AQUA + "[  ����  ]", 166,0,1,Arrays.asList(ChatColor.RED+"[  ���� ������  ]"), 21, inv);
			

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+MonsterName), 53, inv);
		player.openInventory(inv);
	}
	
	
	
	public void MonsterListGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI OPGUI = new OPBoxGUI();
			OPGUI.OPBoxGUI_Main(player, 1);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MonsterListGUI(player, page-1);
			return;
		case 49://�� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[����] : ���ο� ���� �̸��� ���� �ּ���!");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "NM");
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MonsterListGUI(player, page+1);
			return;
		default :
			if(event.isLeftClick() == true&&event.isShiftClick()==false)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				MonsterOptionSettingGUI(player, ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
			}
			else if(event.isLeftClick() == true&&event.isShiftClick())
			{
				GBD.GoldBigDragon_Advanced.ETC.Monster MC = new GBD.GoldBigDragon_Advanced.ETC.Monster();
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				MC.SpawnEggGive(player,ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
			}
			else if(event.isRightClick()&&event.isShiftClick())
			{
				s.SP(player, Sound.LAVA_POP, 1.0F, 1.0F);
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");
				MobList.removeKey(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
				MobList.saveConfig();
				MonsterListGUI(player, page);
			}
			return;
		}
	}

	public void MonsterOptionSettingGUIClick(InventoryClickEvent event)
	{
		if(event.getInventory().getTitle().contains("���")&&
			event.getInventory().getTitle().contains("����"))
		{
			new GBD.GoldBigDragon_Advanced.ETC.Monster().ArmorGUIClick(event);
			return;
		}
		String MonsterName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");
		
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 13://�� �̸� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[����] : ������ �����ִ� �̸��� �����ϼ���!");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "CN");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 14://�� Ÿ�� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			if(event.isLeftClick())
			switch(MobList.getString(MonsterName+".Type"))
			{
				case "ũ����" : MobList.set(MonsterName+".Type", "����ũ����");break;
				case "����ũ����" : MobList.set(MonsterName+".Type", "���̷���");break;
				case "���̷���" : MobList.set(MonsterName+".Type", "�״����̷���");break;
				case "�״����̷���" : MobList.set(MonsterName+".Type", "�Ź�");break;
				case "�Ź�" : MobList.set(MonsterName+".Type", "����");break;
				case "����" : MobList.set(MonsterName+".Type", "���̾�Ʈ");break;
				case "���̾�Ʈ" : MobList.set(MonsterName+".Type", "����������");break;
				case "����������" : MobList.set(MonsterName+".Type", "���뽽����");break;
				case "���뽽����" : MobList.set(MonsterName+".Type", "ū������");break;
				case "ū������" : MobList.set(MonsterName+".Type", "Ư�뽽����");break;
				case "Ư�뽽����" : MobList.set(MonsterName+".Type", "�ʴ���������");break;
				case "�ʴ���������" : MobList.set(MonsterName+".Type", "����Ʈ");break;
				case "����Ʈ" : MobList.set(MonsterName+".Type", "�����Ǳ׸�");break;
				case "�����Ǳ׸�" : MobList.set(MonsterName+".Type", "������");break;
				case "������" : MobList.set(MonsterName+".Type", "�����Ź�");break;
				case "�����Ź�" : MobList.set(MonsterName+".Type", "������");break;
				case "������" : MobList.set(MonsterName+".Type", "������");break;
				case "������" : MobList.set(MonsterName+".Type", "�������׸�ť��");break;
				case "�������׸�ť��" : MobList.set(MonsterName+".Type", "���븶�׸�ť��");break;
				case "���븶�׸�ť��" : MobList.set(MonsterName+".Type", "ū���׸�ť��");break;
				case "ū���׸�ť��" : MobList.set(MonsterName+".Type", "Ư�븶�׸�ť��");break;
				case "Ư�븶�׸�ť��" : MobList.set(MonsterName+".Type", "����");break;
				case "����" : MobList.set(MonsterName+".Type", "����");break;
				case "����" : MobList.set(MonsterName+".Type", "���������");break;
				case "���������" : MobList.set(MonsterName+".Type", "��ȣ��");break;
				case "��ȣ��" : MobList.set(MonsterName+".Type", "����");break;
				case "����" : MobList.set(MonsterName+".Type", "��");break;
				case "��" : MobList.set(MonsterName+".Type", "��");break;
				case "��" : MobList.set(MonsterName+".Type", "��");break;
				case "��" : MobList.set(MonsterName+".Type", "��¡��");break;
				case "��¡��" : MobList.set(MonsterName+".Type", "����"); break;
				case "����" : MobList.set(MonsterName+".Type", "������"); break;
				case "������" : MobList.set(MonsterName+".Type", "������"); break;
				case "������" : MobList.set(MonsterName+".Type", "��"); break;
				case "��" : MobList.set(MonsterName+".Type", "�䳢"); break;
				case "�䳢" : MobList.set(MonsterName+".Type", "�ֹ�"); break;
				case "�ֹ�" : MobList.set(MonsterName+".Type", "�����"); break;
				case "�����" : MobList.set(MonsterName+".Type", "��"); break;
				case "��" : MobList.set(MonsterName+".Type", "����"); break;
				case "����" : MobList.set(MonsterName+".Type", "�����巡��"); break;
				case "�����巡��" : MobList.set(MonsterName+".Type", "����ũ����Ż"); break;
				case "����ũ����Ż" : MobList.set(MonsterName+".Type", "ũ����"); break;
				default : MobList.set(MonsterName+".Type", "����");break;
			}
			else
				switch(MobList.getString(MonsterName+".Type"))
				{
					case "ũ����" : MobList.set(MonsterName+".Type", "����ũ����Ż");break;
					case "����ũ����" : MobList.set(MonsterName+".Type", "ũ����");break;
					case "���̷���" : MobList.set(MonsterName+".Type", "����ũ����");break;
					case "�״����̷���" : MobList.set(MonsterName+".Type", "���̷���");break;
					case "�Ź�" : MobList.set(MonsterName+".Type", "�״����̷���");break;
					case "����" : MobList.set(MonsterName+".Type", "�Ź�");break;
					case "���̾�Ʈ" : MobList.set(MonsterName+".Type", "����");break;
					case "����������" : MobList.set(MonsterName+".Type", "���̾�Ʈ");break;
					case "���뽽����" : MobList.set(MonsterName+".Type", "����������");break;
					case "ū������" : MobList.set(MonsterName+".Type", "���뽽����");break;
					case "Ư�뽽����" : MobList.set(MonsterName+".Type", "ū������");break;
					case "�ʴ���������" : MobList.set(MonsterName+".Type", "Ư�뽽����");break;
					case "����Ʈ" : MobList.set(MonsterName+".Type", "�ʴ���������");break;
					case "�����Ǳ׸�" : MobList.set(MonsterName+".Type", "����Ʈ");break;
					case "������" : MobList.set(MonsterName+".Type", "�����Ǳ׸�");break;
					case "�����Ź�" : MobList.set(MonsterName+".Type", "������");break;
					case "������" : MobList.set(MonsterName+".Type", "�����Ź�");break;
					case "������" : MobList.set(MonsterName+".Type", "������");break;
					case "�������׸�ť��" : MobList.set(MonsterName+".Type", "������");break;
					case "���븶�׸�ť��" : MobList.set(MonsterName+".Type", "�������׸�ť��");break;
					case "ū���׸�ť��" : MobList.set(MonsterName+".Type", "���븶�׸�ť��");break;
					case "Ư�븶�׸�ť��" : MobList.set(MonsterName+".Type", "ū���׸�ť��");break;
					case "����" : MobList.set(MonsterName+".Type", "Ư�븶�׸�ť��");break;
					case "����" : MobList.set(MonsterName+".Type", "����");break;
					case "���������" : MobList.set(MonsterName+".Type", "����");break;
					case "��ȣ��" : MobList.set(MonsterName+".Type", "���������");break;
					case "����" : MobList.set(MonsterName+".Type", "��ȣ��");break;
					case "��" : MobList.set(MonsterName+".Type", "����");break;
					case "��" : MobList.set(MonsterName+".Type", "��");break;
					case "��" : MobList.set(MonsterName+".Type", "��");break;
					case "��¡��" : MobList.set(MonsterName+".Type", "��"); break;
					case "����" : MobList.set(MonsterName+".Type", "��¡��"); break;
					case "������" : MobList.set(MonsterName+".Type", "����"); break;
					case "������" : MobList.set(MonsterName+".Type", "������"); break;
					case "��" : MobList.set(MonsterName+".Type", "������"); break;
					case "�䳢" : MobList.set(MonsterName+".Type", "��"); break;
					case "�ֹ�" : MobList.set(MonsterName+".Type", "�䳢"); break;
					case "�����" : MobList.set(MonsterName+".Type", "�ֹ�"); break;
					case "��" : MobList.set(MonsterName+".Type", "�����"); break;
					case "����" : MobList.set(MonsterName+".Type", "��"); break;
					case "�����巡��" : MobList.set(MonsterName+".Type", "����"); break;
					case "����ũ����Ż" : MobList.set(MonsterName+".Type", "�����巡��"); break;
					default : MobList.set(MonsterName+".Type", "����");break;
				}
			MobList.saveConfig();
			MonsterOptionSettingGUI(player, MonsterName);
			break;
		case 15://���� ���̿� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			if(event.isLeftClick())
			switch(MobList.getString(MonsterName+".Biome"))
			{
				case "NULL" : MobList.set(MonsterName+".Biome", "BEACH");break;
				case "BEACH" : MobList.set(MonsterName+".Biome", "DESERT");break;
				case "DESERT" : MobList.set(MonsterName+".Biome", "EXTREME_HILLS");break;
				case "EXTREME_HILLS" : MobList.set(MonsterName+".Biome", "FOREST");break;
				case "FOREST" : MobList.set(MonsterName+".Biome", "HELL");break;
				case "HELL" : MobList.set(MonsterName+".Biome", "JUNGLE");break;
				case "JUNGLE" : MobList.set(MonsterName+".Biome", "MESA");break;
				case "MESA" : MobList.set(MonsterName+".Biome", "OCEAN");break;
				case "OCEAN" : MobList.set(MonsterName+".Biome", "PLAINS");break;
				case "PLAINS" : MobList.set(MonsterName+".Biome", "RIVER");break;
				case "RIVER" : MobList.set(MonsterName+".Biome", "SAVANNA");break;
				case "SAVANNA" : MobList.set(MonsterName+".Biome", "SKY");break;
				case "SKY" : MobList.set(MonsterName+".Biome", "SMALL_MOUNTAINS");break;
				case "SMALL_MOUNTAINS" : MobList.set(MonsterName+".Biome", "SWAMPLAND");break;
				case "SWAMPLAND" : MobList.set(MonsterName+".Biome", "TAIGA");break;
				case "TAIGA" : MobList.set(MonsterName+".Biome", "NULL");break;
				default : MobList.set(MonsterName+".Biome", "NULL");break;
			}
			else
				switch(MobList.getString(MonsterName+".Biome"))
				{
					case "NULL" : MobList.set(MonsterName+".Biome", "TAIGA");break;
					case "BEACH" : MobList.set(MonsterName+".Biome", "NULL");break;
					case "DESERT" : MobList.set(MonsterName+".Biome", "BEACH");break;
					case "EXTREME_HILLS" : MobList.set(MonsterName+".Biome", "DESERT");break;
					case "FOREST" : MobList.set(MonsterName+".Biome", "EXTREME_HILLS");break;
					case "HELL" : MobList.set(MonsterName+".Biome", "FOREST");break;
					case "JUNGLE" : MobList.set(MonsterName+".Biome", "HELL");break;
					case "MESA" : MobList.set(MonsterName+".Biome", "JUNGLE");break;
					case "OCEAN" : MobList.set(MonsterName+".Biome", "MESA");break;
					case "PLAINS" : MobList.set(MonsterName+".Biome", "OCEAN");break;
					case "RIVER" : MobList.set(MonsterName+".Biome", "PLAINS");break;
					case "SAVANNA" : MobList.set(MonsterName+".Biome", "RIVER");break;
					case "SKY" : MobList.set(MonsterName+".Biome", "SAVANNA");break;
					case "SMALL_MOUNTAINS" : MobList.set(MonsterName+".Biome", "SKY");break;
					case "SWAMPLAND" : MobList.set(MonsterName+".Biome", "SMALL_MOUNTAINS");break;
					case "TAIGA" : MobList.set(MonsterName+".Biome", "SWAMPLAND");break;
					default : MobList.set(MonsterName+".Biome", "NULL");break;
				}
			MobList.saveConfig();
			MonsterOptionSettingGUI(player, MonsterName);
			break;
		case 16://����� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[����] : �ش� ������ ������� ���� �� �ּ���!");
			player.sendMessage(ChatColor.DARK_AQUA+"(1 ~ "+Integer.MAX_VALUE+")");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "HP");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 22://����ġ ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[����] : �ش� ������ ����ġ�� ���� �� �ּ���!");
			player.sendMessage(ChatColor.DARK_AQUA+"(1 ~ "+Integer.MAX_VALUE+")");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "EXP");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 23://��� �ݾ� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[����] : �ش� ���Ͱ� ����ϴ� �ּ� ��差�� ������ �ּ���!");
			player.sendMessage(ChatColor.DARK_AQUA+"(1 ~ "+Integer.MAX_VALUE+")");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "MIN_Money");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 24://��� ����
			GBD.GoldBigDragon_Advanced.ETC.Monster MC = new GBD.GoldBigDragon_Advanced.ETC.Monster();
			s.SP(player, Sound.HORSE_ARMOR, 1.0F, 1.0F);
			MC.ArmorGUI(player, MonsterName);
			break;
		case 25://��� ����� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GRAY+"(Ȯ�� ��� : 1000 = 100%, 1 = 0.1%)");
			player.sendMessage(ChatColor.GREEN+"[����] : ������ ���� ������� ������ �ּ���!");
			player.sendMessage(ChatColor.DARK_AQUA+"(1 ~ 1000)");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "Head.DropChance");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 31://���� ���� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GRAY+"("+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"�� ������ ���� ���ݷ��� ��½��� �ݴϴ�.)");
			player.sendMessage(ChatColor.GREEN+"[����] : ������ "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"�� ������ �ּ���!");
			player.sendMessage(ChatColor.DARK_AQUA+"(1 ~ "+Integer.MAX_VALUE+")");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "STR");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 32://���� ��� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GRAY+"(�������� ������ �������� ������ ��½��� �ݴϴ�.)");
			player.sendMessage(ChatColor.GREEN+"[����] : ������ ���� ������ ������ �ּ���!");
			player.sendMessage(ChatColor.DARK_AQUA+"(1 ~ "+Integer.MAX_VALUE+")");
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "DEF");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getInventory().getItem(19).getItemMeta().getDisplayName()));
			return;
		case 33://���� AI ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			if(event.isLeftClick())
			switch(MobList.getString(MonsterName+".AI"))
			{
				case "�Ϲ� �ൿ" : MobList.set(MonsterName+".AI", "���� ����");break;
				case "���� ����" : MobList.set(MonsterName+".AI", "���� �񼱰�");break;
				case "���� �񼱰�" : MobList.set(MonsterName+".AI", "���� ����");break;
				case "���� ����" : MobList.set(MonsterName+".AI", "���� �񼱰�");break;
				case "���� �񼱰�" : MobList.set(MonsterName+".AI", "���Ÿ� ����");break;
				case "���Ÿ� ����" : MobList.set(MonsterName+".AI", "���Ÿ� �񼱰�");break;
				case "���Ÿ� �񼱰�" : MobList.set(MonsterName+".AI", "����Ʈ ���Ÿ� ����");break;
				case "����Ʈ ���Ÿ� ����" : MobList.set(MonsterName+".AI", "����Ʈ ���Ÿ� �񼱰�");break;
				case "����Ʈ ���Ÿ� �񼱰�" : MobList.set(MonsterName+".AI", "����");break;
				case "����" : MobList.set(MonsterName+".AI", "����");break;
				case "����" : MobList.set(MonsterName+".AI", "������");break;
				case "������" : MobList.set(MonsterName+".AI", "�Ϲ� �ൿ");break;
				default : MobList.set(MonsterName+".AI", "�Ϲ� �ൿ");break;
			}
			else
			switch(MobList.getString(MonsterName+".AI"))
			{
				case "�Ϲ� �ൿ" : MobList.set(MonsterName+".AI", "������");break;
				case "���� ����" : MobList.set(MonsterName+".AI", "�Ϲ� �ൿ");break;
				case "���� �񼱰�" : MobList.set(MonsterName+".AI", "���� ����");break;
				case "���� ����" : MobList.set(MonsterName+".AI", "���� �񼱰�");break;
				case "���� �񼱰�" : MobList.set(MonsterName+".AI", "���� ����");break;
				case "���Ÿ� ����" : MobList.set(MonsterName+".AI", "���� �񼱰�");break;
				case "���Ÿ� �񼱰�" : MobList.set(MonsterName+".AI", "���Ÿ� ����");break;
				case "����Ʈ ���Ÿ� ����" : MobList.set(MonsterName+".AI", "���Ÿ� �񼱰�");break;
				case "����Ʈ ���Ÿ� �񼱰�" : MobList.set(MonsterName+".AI", "����Ʈ ���Ÿ� ����");break;
				case "����" : MobList.set(MonsterName+".AI", "����Ʈ ���Ÿ� �񼱰�");break;
				case "����" : MobList.set(MonsterName+".AI", "����");break;
				case "������" : MobList.set(MonsterName+".AI", "����");break;
				default : MobList.set(MonsterName+".AI", "�Ϲ� �ൿ");break;
			}
		MobList.saveConfig();
		MonsterOptionSettingGUI(player, MonsterName);
		return;

		case 34://���� ���� ȿ��
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			MonsterPotionGUI(player, MonsterName);
			return;
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MonsterListGUI(player, 0);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}

	public void MonsterPotionGUIClick(InventoryClickEvent event)
	{
		String MonsterName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager MobList = GUI_YC.getNewConfig("Monster/MonsterList.yml");
		
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		if(event.getSlot()>=10&&event.getSlot()<=16)
		{
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			Main.UserData.get(player).setType("Monster");
			Main.UserData.get(player).setString((byte)1, "Potion");
			Main.UserData.get(player).setString((byte)3, MonsterName);
		}
		switch (event.getSlot())
		{
		case 10://���
			player.sendMessage(ChatColor.GREEN+"[����] : ������ ��� ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Regenerate");
			return;
		case 11://��
			player.sendMessage(ChatColor.GREEN+"[����] : ������ �� ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Poision");
			return;
		case 12://�ż�
			player.sendMessage(ChatColor.GREEN+"[����] : ������ �ż� ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Speed");
			return;
		case 13://����
			player.sendMessage(ChatColor.GREEN+"[����] : ������ ���� ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Slow");
			return;
		case 14://��
			player.sendMessage(ChatColor.GREEN+"[����] : ������ �� ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Strength");
			return;
		case 15://������
			player.sendMessage(ChatColor.GREEN+"[����] : ������ ������ ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Weak");
			return;
		case 16://����
			player.sendMessage(ChatColor.GREEN+"[����] : ������ ���� ȿ���� �� ���� �����Ͻǰǰ���?");
			player.sendMessage(ChatColor.YELLOW+"(0 ~ 100)");
			Main.UserData.get(player).setString((byte)2, "Jump");
			return;
			
		case 19://ȭ�� ����
			if(MobList.getInt(MonsterName+".Potion.FireRegistance")==0)
				MobList.set(MonsterName+".Potion.FireRegistance", 1);
			else
				MobList.set(MonsterName+".Potion.FireRegistance", 0);
			MobList.saveConfig();
			s.SP(player, Sound.DRINK, 1.0F, 1.0F);
			MonsterPotionGUI(player, MonsterName);
			return;
		case 20://���� ȣȩ
			if(MobList.getInt(MonsterName+".Potion.WaterBreath")==0)
				MobList.set(MonsterName+".Potion.WaterBreath", 1);
			else
				MobList.set(MonsterName+".Potion.WaterBreath", 0);
			MobList.saveConfig();
			s.SP(player, Sound.DRINK, 1.0F, 1.0F);
			MonsterPotionGUI(player, MonsterName);
			return;
		case 21://����
			if(MobList.getInt(MonsterName+".Potion.Invisible")==0)
				MobList.set(MonsterName+".Potion.Invisible", 1);
			else
				MobList.set(MonsterName+".Potion.Invisible", 0);
			MobList.saveConfig();
			s.SP(player, Sound.DRINK, 1.0F, 1.0F);
			MonsterPotionGUI(player, MonsterName);
			return;
			
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MonsterOptionSettingGUI(player, MonsterName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}
}
