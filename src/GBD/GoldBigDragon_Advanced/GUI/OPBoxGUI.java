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

public class OPBoxGUI extends GUIutil
{
	public void OPBoxGUI_Main (Player player, int page)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "������ ���� : "+page+" / 2");
		
		Stack2(ChatColor.BLACK +""+page, 160,11,1,null, 0, inv);
		Stack2(" ", 160,11,1,null, 1, inv);
		Stack2(ChatColor.RED +""+ ChatColor.BOLD + "[���� �ð� ���� -��-]", 160,4,1,Arrays.asList(ChatColor.WHITE +"���� ���� �ð��� ������",ChatColor.WHITE +"���� ��ŵ�ϴ�."), 2, inv);
		Stack2(ChatColor.GRAY +""+ ChatColor.BOLD + "[���� �ð� ���� -��-]", 160,4,1,Arrays.asList(ChatColor.WHITE +"���� ���� �ð��� ������",ChatColor.WHITE +"���� ��ŵ�ϴ�."), 3, inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "[���� ��ġ�� ��������]", 160,4,1,Arrays.asList(ChatColor.WHITE +"���� ��ġ�� ���� ��������",ChatColor.WHITE +"���� ��ŵ�ϴ�."), 4, inv);
		Stack2(ChatColor.DARK_AQUA +""+ ChatColor.BOLD + "[���� ���� ���� -����-]", 160,4,1,Arrays.asList(ChatColor.WHITE +"���� ���� ������ ����",ChatColor.WHITE +"���� ��ŵ�ϴ�."), 5, inv);
		Stack2(ChatColor.GRAY +""+ ChatColor.BOLD + "[���� ���� ���� -�帲-]", 160,4,1,Arrays.asList(ChatColor.WHITE +"���� ���� ������ �帮��",ChatColor.WHITE +"���� ��ŵ�ϴ�."), 6, inv);
		Stack2(" ", 160,11,1,null, 7, inv);
		Stack2(" ", 160,11,1,null, 8, inv);
		Stack2(" ", 160,11,1,null, 9, inv);
		Stack2(" ", 160,11,1,null, 18, inv);
		Stack2(" ", 160,11,1,null, 17, inv);
		Stack2(" ", 160,11,1,null, 26, inv);
		Stack2(" ", 160,11,1,null, 27, inv);
		Stack2(" ", 160,11,1,null, 36, inv);
		Stack2(" ", 160,11,1,null, 35, inv);
		Stack2(" ", 160,11,1,null, 36, inv);
		Stack2(" ", 160,11,1,null, 37, inv);
		Stack2(" ", 160,11,1,null, 38, inv);
		Stack2(" ", 160,11,1,null, 39, inv);
		Stack2(" ", 160,11,1,null, 40, inv);
		Stack2(" ", 160,11,1,null, 41, inv);
		Stack2(" ", 160,11,1,null, 42, inv);
		Stack2(" ", 160,11,1,null, 43, inv);
		Stack2(" ", 160,11,1,null, 44, inv);

		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�÷����� ���̵�", 340,0,1,Arrays.asList(ChatColor.YELLOW + "GoldBigDragonAdvanced",ChatColor.WHITE +"�÷����ο� ����",ChatColor.WHITE +"������ ���ϴ�."), 22, inv);
		
		switch(page)
		{
			case 1:
				ItemStackStack(getPlayerSkull(ChatColor.WHITE+""+ChatColor.BOLD+"GoldBigDragonRPG", 1, Arrays.asList("",ChatColor.YELLOW+"[����]",ChatColor.WHITE+""+ChatColor.BOLD+Main.serverVersion,"",ChatColor.YELLOW+"[��ġ]",ChatColor.WHITE+""+ChatColor.BOLD+Main.serverUpdate), "GoldBigDragon"), 10, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� ����", 137,0,1,Arrays.asList(ChatColor.GRAY +"������ ���� �������� ������ �մϴ�."), 12, inv);
				//Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "����", 52,0,1,Arrays.asList(ChatColor.GRAY +"������ ������ ������ ����,",ChatColor.GRAY +"���� ���� �� ������ �����մϴ�."), 14, inv);
				Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "����", 397,4,1,Arrays.asList(ChatColor.GRAY +"Ŀ���� ���͸� �����ϰų�",ChatColor.GRAY +"���� ���׸� ����ϴ�."), 14, inv);
				Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�̺�Ʈ", 401,0,1,Arrays.asList(ChatColor.GRAY +"�̺�Ʈ ���ֽ� ���ӵ� ���",ChatColor.GRAY +"�÷��̾�鿡�� �˷�����,",ChatColor.GRAY +"���� �����ϴ� ��� �÷��̾��",ChatColor.GRAY +"�̺�Ʈ ������ �˷��ݴϴ�."), 16, inv);
				if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == true)
				{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ����", 346,0,1,Arrays.asList(ChatColor.WHITE + "[������]",ChatColor.GRAY+"ȯ���� ���������� �����ϸ�,",ChatColor.GRAY+"������ ���Ƿ� �ø� �� �����ϴ�.",ChatColor.RED+"�÷��̾��� ���� �����Ͱ� �̾����Ƿ�",ChatColor.RED+"����� ���ǰ� �ʿ��մϴ�."), 28, inv);}
				else
				{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ����", 40,0,1,Arrays.asList(ChatColor.GOLD + "[������ ���丮]",ChatColor.GRAY+"������ ���Ƿ� �ø� �� ������,",ChatColor.GRAY+"���������� ȯ���� �������� �ʽ��ϴ�.",ChatColor.RED+"�÷��̾��� ���� �����Ͱ� �̾����Ƿ�",ChatColor.RED+"����� ���ǰ� �ʿ��մϴ�."), 28, inv);}	}
				Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "Ŀ���� ������", 389,0,1,Arrays.asList(ChatColor.WHITE + "Ŀ���� �������� �����ϰų�",ChatColor.WHITE+"Ŭ���Ͽ� ���� �޽��ϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� ������ �ޱ�]",ChatColor.YELLOW+"[Shift + �� Ŭ���� ������ ����]",ChatColor.RED+"[Shift + �� Ŭ���� ������ ����]"), 30, inv);
				Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�׺���̼�", 358,120,1,Arrays.asList(ChatColor.WHITE + "��ã�� �ý����� �����մϴ�."), 32, inv);
				Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "����Ʈ", 403,0,1,Arrays.asList(ChatColor.WHITE + "����Ʈ�� ���� ����ų�",ChatColor.WHITE+"�����ϰų� �����մϴ�."), 34, inv);
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
				break;

			case 2:
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "��ų", 403,0,1,Arrays.asList(ChatColor.GRAY +"���� Ȥ�� ī�װ��� ��� ������",ChatColor.GRAY+"��ų���� ����մϴ�."), 10, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "ī�װ� �� ����", 397,3,1,Arrays.asList(ChatColor.GRAY +"��ų�� ������ ���� ������ �մϴ�."), 12, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "�Һ� ������", 260,0,1,Arrays.asList(ChatColor.GRAY +"�� Ŭ�� Ȥ�� ����Ű�� ����",ChatColor.GRAY+"��� ������ �������� �����մϴ�."), 14, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "����", 395,0,1,Arrays.asList(ChatColor.GRAY +"���� ������ ���Ͽ� ��������",ChatColor.GRAY+"Ư���� �ɼ��� ������ �� �ֽ��ϴ�."), 16, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "������", 145,2,1,Arrays.asList(ChatColor.GRAY +"������ ���� ����� ���� ����ų�",ChatColor.GRAY+"������ �� �ֽ��ϴ�."), 28, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "�ʽ���", 54,0,1,Arrays.asList(ChatColor.GRAY +"������ ó�� ���� �÷��̾",ChatColor.GRAY+"���Ͽ� ������ �մϴ�."), 30, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� ����", 2,0,1,Arrays.asList(ChatColor.GRAY +"���ο� ���带 �����մϴ�."), 32, inv);
				Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "����", 345,0,1,Arrays.asList(ChatColor.GRAY +"���� ������ �����ϰų�, �̵��մϴ�."), 34, inv);

				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);
				break;
			
		}

		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ â�� �ݽ��ϴ�."), 53, inv);
		
		player.openInventory(inv);
	}
	
	public void OPBoxGUI_Setting(Player player)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "������ �ɼ�");
		
		Stack2(" ", 160,11,1,null, 0, inv);
		Stack2(" ", 160,11,1,null, 1, inv);
		Stack2(" ", 160,11,1,null, 2, inv);
		Stack2(" ", 160,11,1,null, 3, inv);
		Stack2(" ", 160,11,1,null, 4, inv);
		Stack2(" ", 160,11,1,null, 5, inv);
		Stack2(" ", 160,11,1,null, 6, inv);
		Stack2(" ", 160,11,1,null, 7, inv);
		Stack2(" ", 160,11,1,null, 8, inv);
		Stack2(" ", 160,11,1,null, 9, inv);
		Stack2(" ", 160,11,1,null, 18, inv);
		Stack2(" ", 160,11,1,null, 17, inv);
		Stack2(" ", 160,11,1,null, 26, inv);
		Stack2(" ", 160,11,1,null, 27, inv);
		Stack2(" ", 160,11,1,null, 36, inv);
		Stack2(" ", 160,11,1,null, 35, inv);
		Stack2(" ", 160,11,1,null, 36, inv);
		Stack2(" ", 160,11,1,null, 37, inv);
		Stack2(" ", 160,11,1,null, 38, inv);
		Stack2(" ", 160,11,1,null, 39, inv);
		Stack2(" ", 160,11,1,null, 40, inv);
		Stack2(" ", 160,11,1,null, 41, inv);
		Stack2(" ", 160,11,1,null, 42, inv);
		Stack2(" ", 160,11,1,null, 43, inv);
		Stack2(" ", 160,11,1,null, 44, inv);

		if(Config.getBoolean("Server.EntitySpawn") == true)
		{Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "��ƼƼ ����", 52,0,1,Arrays.asList(ChatColor.GREEN+"[Ȱ��ȭ]",ChatColor.GRAY +"�ش� �ɼ��� ��Ȱ��ȭ ������ ���",ChatColor.GRAY+"���̻� ��ƼƼ���� ��ȯ���� �ʽ��ϴ�."), 10, inv);}
		else
		{{Stack2(ChatColor.RED +""+ ChatColor.BOLD + "��ƼƼ ����", 166,0,1,Arrays.asList(ChatColor.RED+"[�� Ȱ��ȭ]",ChatColor.GRAY +"�ش� �ɼ��� ��Ȱ��ȭ ������ ���",ChatColor.GRAY+"���̻� ��ƼƼ���� ��ȯ���� �ʽ��ϴ�."), 10, inv);}	}
		
		if(Config.getBoolean("Server.AttackDelay") == true)
		{Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� ������", 276,0,1,Arrays.asList(ChatColor.GREEN+"[Ȱ��ȭ]",ChatColor.GRAY +"�ش� �ɼ��� Ȱ��ȭ ������ ���",ChatColor.GRAY+"���ݽ� �����̰� ����ϴ�."), 11, inv);}
		else
		{{Stack2(ChatColor.RED +""+ ChatColor.BOLD + "���� ������", 166,0,1,Arrays.asList(ChatColor.RED+"[�� Ȱ��ȭ]",ChatColor.GRAY +"�ش� �ɼ��� Ȱ��ȭ ������ ���",ChatColor.GRAY+"���ݽ� �����̰� ����ϴ�."), 11, inv);}	}
		switch(Config.getInt("Server.MonsterSpawnEffect"))
		{
			case 0 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,0,1,Arrays.asList(ChatColor.WHITE + "[����]"), 12, inv); break;
			case 1 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,66,1,Arrays.asList(ChatColor.BLUE + "[����]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
			case 2 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,58,1,Arrays.asList(ChatColor.DARK_PURPLE + "[����]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
			case 3 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,50,1,Arrays.asList(ChatColor.GREEN+ "[����]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
			case 4 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,61,1,Arrays.asList(ChatColor.DARK_RED + "[ȭ��]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
			case 5 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,120,1,Arrays.asList(ChatColor.RED + "[ȭ��]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
			case 6 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 383,90,1,Arrays.asList(ChatColor.LIGHT_PURPLE + "[����]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
			case 7 : Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ���� ȿ��", 50,0,1,Arrays.asList(ChatColor.GOLD + "[���]",ChatColor.RED + "�� ���� �� ������ ������ �˴ϴ�!"), 12, inv); break;
		}

		if(Config.getBoolean("Server.CustomWeaponBreak") == true)
		{Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "Ŀ���� ���� �ı�", 268,50,1,Arrays.asList(ChatColor.GREEN+"[Ȱ��ȭ]",ChatColor.GRAY +"Ŀ���� ������ �������� 0�� �� ���",ChatColor.GRAY+"�Ϲ� ����� ���� �ı��˴ϴ�."), 13, inv);}
		else
		{{Stack2(ChatColor.RED +""+ ChatColor.BOLD + "Ŀ���� ���� �ı�", 166,0,1,Arrays.asList(ChatColor.RED+"[�� Ȱ��ȭ]",ChatColor.GRAY +"Ŀ���� ����� �������� 0�� �Ǿ",ChatColor.GRAY+"�ı����� �ʽ��ϴ�."), 13, inv);}	}

		if(Config.getString("Server.JoinMessage") != null)
			Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� �޽���", 386,0,1,Arrays.asList(ChatColor.GREEN+"[����]",ChatColor.GRAY +Config.getString("Server.JoinMessage"),"",ChatColor.YELLOW+"[�� Ŭ���� ���� �޽��� ����]"), 14, inv);
		else
			Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� �޽���", 166,0,1,Arrays.asList(ChatColor.RED+"[����]",ChatColor.GRAY + "���� �޽����� �����ϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� ���� �޽��� ���]"), 14, inv);

		if(Config.getString("Server.QuitMessage") != null)
			Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� �޽���", 386,0,1,Arrays.asList(ChatColor.GREEN+"[����]",ChatColor.GRAY +Config.getString("Server.QuitMessage"),"",ChatColor.YELLOW+"[�� Ŭ���� ���� �޽��� ����]"), 15, inv);
		else
			Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� �޽���", 166,0,1,Arrays.asList(ChatColor.RED+"[����]",ChatColor.GRAY + "���� �޽����� �����ϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� ���� �޽��� ���]"), 15, inv);
		Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "��������", 323,0,1,Arrays.asList(ChatColor.GRAY + "������ ���� �ð�����",ChatColor.GRAY+"���������� �˸��ϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� �������� ����]"), 16, inv);

		if(Config.getString("Server.ChatPrefix")==null)
			ItemStackStack(getPlayerSkull(ChatColor.GREEN +""+ ChatColor.BOLD + "ä�� ����", 1, Arrays.asList(ChatColor.GRAY+"ä�� ���¸� �����մϴ�.",ChatColor.GRAY+"��, ���¸� ������ ���",ChatColor.GRAY+"��� �Ϲ� ä���� ��ε�",ChatColor.GRAY+"ĳ��Ʈ �������� ����ǹǷ�",ChatColor.GRAY+"�����ؾ� �մϴ�.","",ChatColor.DARK_AQUA+"[���� ä�� ����]",ChatColor.WHITE+"[   ����   ]","",ChatColor.YELLOW+"[�� Ŭ���� ���λ� ����]",ChatColor.RED+"[�� Ŭ���� ���λ� ����]","",ChatColor.GREEN+"[�ڵ� ����]",ChatColor.WHITE+""+ChatColor.BOLD+"B4TT3RY"), "B4TT3RY__"), 19, inv);
		else
		{
			String Prefix = Config.getString("Server.ChatPrefix");
			Prefix=Prefix.replace("%t%","[�ð�]");
			Prefix=Prefix.replace("%gm%","[���� ���]");
			Prefix=Prefix.replace("%ct%","[ä�� Ÿ��]");
			Prefix=Prefix.replace("%lv%","[����]");
			Prefix=Prefix.replace("%rlv%","[���� ����]");
			Prefix=Prefix.replace("%job%","[����]");
			Prefix=Prefix.replace("%player%","[�г���]");
			Prefix=Prefix.replace("%message%", "[����]");
			ItemStackStack(getPlayerSkull(ChatColor.GREEN +""+ ChatColor.BOLD + "ä�� ����", 1, Arrays.asList(ChatColor.GRAY+"ä�� ���¸� �����մϴ�.",ChatColor.GRAY+"��, ���¸� ������ ���",ChatColor.GRAY+"��� �Ϲ� ä���� ��ε�",ChatColor.GRAY+"ĳ��Ʈ �������� ����ǹǷ�",ChatColor.GRAY+"�����ؾ� �մϴ�.","",ChatColor.DARK_AQUA+"[���� ä�� ����]",ChatColor.WHITE+Prefix,"",ChatColor.YELLOW+"[�� Ŭ���� ���λ� ����]",ChatColor.RED+"[�� Ŭ���� ���λ� ����]","",ChatColor.GREEN+"[�ڵ� ����]",ChatColor.WHITE+""+ChatColor.BOLD+"B4TT3RY"), "B4TT3RY__"), 19, inv);
		}

		if(Config.getBoolean("Server.CustomBlockPlace") == true)
		{Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "Ŀ���� ��� ��ġ", 1,0,1,Arrays.asList(ChatColor.GREEN+"[����]",ChatColor.GRAY +"�����ۿ� ������ �پ� �ְų�",ChatColor.GRAY+"�̸��� ����� ��������",ChatColor.GRAY+"��ġ�Ǵ� ���� ���� �ʽ��ϴ�."), 20, inv);}
		else
		{{Stack2(ChatColor.RED +""+ ChatColor.BOLD + "Ŀ���� ��� ��ġ", 166,0,1,Arrays.asList(ChatColor.RED+"[�Ұ���]",ChatColor.GRAY +"�����ۿ� ������ �پ� �ְų�",ChatColor.GRAY+"�̸��� ����� ��������",ChatColor.GRAY+"��ġ�Ǵ� ���� �����ϴ�."), 20, inv);}	}

		Stack2(ChatColor.GREEN +""+ ChatColor.BOLD + "���� �̸� ����", 323,0,1,Arrays.asList(ChatColor.GRAY + "������ ���� �̸���",ChatColor.GRAY+"������� �����մϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� ���� �̸� ����]","",ChatColor.RED+"[       ����       ]",ChatColor.RED+"���� �̸� ����� ������ �ѷ���",ChatColor.RED+"Ŀ���� �������� �ɷ�ġ��",ChatColor.RED+"��ȿ ó���� �Ǹ�,",ChatColor.RED+"��ų�� ���� ���� �ɼ���",ChatColor.RED+"�� ���� �Ͽ��� �մϴ�."), 21, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ â�� �ݽ��ϴ�."), 53, inv);
		
		player.openInventory(inv);
	}
	
	public void OPBoxGUI_BroadCast(Player player, int page)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager BroadCast =GUI_YC.getNewConfig("BroadCast.yml");

		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "������ �������� : " + (page+1));

		if(BroadCast.contains("0"))
		{
			Object[] BroadCastList= BroadCast.getConfigurationSection("").getKeys(false).toArray();
			int loc=0;
			for(int count = page*45; count < BroadCastList.length;count++)
			{
				String AreaName = BroadCastList[count].toString();
				
				Stack2(ChatColor.BLACK + "" + ChatColor.BOLD + count, 340,0,1,Arrays.asList(BroadCast.getString(count+"")
						,"",ChatColor.RED+"[Shift + ��Ŭ���� �˸� ����]"), loc, inv);
				
				loc=loc+1;
			}

			if(BroadCastList.length-(page*44)>45)
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
			if(page!=0)
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);
		}
		YamlManager Config =GUI_YC.getNewConfig("config.yml");

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ����", 152,0,1,Arrays.asList(ChatColor.GRAY + "�� "+ChatColor.GOLD+Config.getInt("Server.BroadCastSecond")+ChatColor.GRAY+"�ʸ��� ����"), 46, inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ����", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ���������� �����մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�."), 53, inv);
		player.openInventory(inv);
	}
	
	public void OPBoxGUI_StatChange(Player player)
	{
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "������ ���� ����");

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "ü��", 267,0,1,Arrays.asList(ChatColor.GRAY + "[  ���� �̸�  ]",ChatColor.WHITE+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR), 0, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ؾ�", 261,0,1,Arrays.asList(ChatColor.GRAY + "[  ���� �̸�  ]",ChatColor.WHITE+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX), 1, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "����", 369,0,1,Arrays.asList(ChatColor.GRAY + "[  ���� �̸�  ]",ChatColor.WHITE+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT), 2, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "����", 370,0,1,Arrays.asList(ChatColor.GRAY + "[  ���� �̸�  ]",ChatColor.WHITE+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL), 3, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���", 322,0,1,Arrays.asList(ChatColor.GRAY + "[  ���� �̸�  ]",ChatColor.WHITE+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK), 4, inv);
<<<<<<< HEAD
		
		String lore = GBD.GoldBigDragon_Advanced.Main.ServerOption.STR_Lore;
		lore = lore.replace("%stat%", GBD.GoldBigDragon_Advanced.Main.ServerOption.STR);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "ü�� ����", 323,0,1,Arrays.asList(lore.split("%enter%")), 9, inv);
		lore = GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX_Lore;
		lore = lore.replace("%stat%", GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ؾ� ����", 323,0,1,Arrays.asList(lore.split("%enter%")), 10, inv);
		lore = GBD.GoldBigDragon_Advanced.Main.ServerOption.INT_Lore;
		lore = lore.replace("%stat%", GBD.GoldBigDragon_Advanced.Main.ServerOption.INT);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ����", 323,0,1,Arrays.asList(lore.split("%enter%")), 11, inv);
		lore = GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL_Lore;
		lore = lore.replace("%stat%", GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ����", 323,0,1,Arrays.asList(lore.split("%enter%")), 12, inv);
		lore = GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK_Lore;
		lore = lore.replace("%stat%", GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "��� ����", 323,0,1,Arrays.asList(lore.split("%enter%")), 13, inv);
=======
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "ȭ��", 266,0,1,Arrays.asList(ChatColor.GRAY + "[  ���� �̸�  ]",ChatColor.WHITE+GBD.GoldBigDragon_Advanced.Main.ServerOption.Money), 6, inv);
>>>>>>> origin/GoldBigDragonRPG_Advanced
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�."), 53, inv);
		player.openInventory(inv);
	}
	
	
	//���� GUIâ ���� �������� ������ ��, �ش� �����ܿ� ����� �ִ� �޼ҵ�1   -���� GUI, ���ǹڽ�, Ŀ���� ����GUI-//
	public void OPBoxGUIInventoryclick(InventoryClickEvent event)
	{

		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		if(event.getSlot() >= 2 && event.getSlot()<=6)
		{
			switch(event.getSlot())
			{
			case 2:
				{
					s.SP(player, Sound.CHICKEN_IDLE, 0.8F, 1.0F);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setTime(0);
					player.sendMessage(ChatColor.GOLD+"[System] : "+player.getLocation().getWorld().getName()+" ���� �ð��� ������ �����Ͽ����ϴ�!");
				}
				return;
			case 3:
				{
					s.SP(player, Sound.WOLF_HOWL, 0.8F, 1.0F);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setTime(14000);
					player.sendMessage(ChatColor.GOLD+"[System] : "+player.getLocation().getWorld().getName()+" ���� �ð��� ������ �����Ͽ����ϴ�!");
				}
				return;
			case 4:
				{
					s.SP(player, Sound.VILLAGER_YES, 0.8F, 1.0F);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setSpawnLocation((int)player.getLocation().getX(), (int)player.getLocation().getY(), (int)player.getLocation().getZ());
					player.sendMessage(ChatColor.GOLD+"[System] : "+player.getLocation().getWorld().getName()+" ������ ���� ������ "+(int)player.getLocation().getX()+","+(int)player.getLocation().getY()+","+(int)player.getLocation().getZ()+" �� �����Ͽ����ϴ�!");
				}
				return;
			case 5:
				{
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setStorm(false);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setWeatherDuration(180000);
					player.sendMessage(ChatColor.GOLD+"[System] : "+player.getLocation().getWorld().getName()+" ���� ������ �������� �����Ͽ����ϴ�!");
				}
				return;
			case 6:
				{
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setStorm(true);
					Bukkit.getServer().getWorld(player.getLocation().getWorld().getName()).setWeatherDuration(180000);
					player.sendMessage(ChatColor.GOLD+"[System] : "+player.getLocation().getWorld().getName()+" ���� ������ �帲���� �����Ͽ����ϴ�!");
				}
				return;
			}
		}
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		switch ((ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())))
		{
		case"�׺���̼�":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new NavigationGUI().NavigationListGUI(player,0);
			break;
		case"GoldBigDragonRPG":
			if(Main.serverVersion.equals(Main.currentServerVersion)&&
				Main.serverUpdate == Main.currentServerUpdate)
			{
				s.SP(player,Sound.ANVIL_USE, 0.8F, 1.0F);
				player.sendMessage(ChatColor.YELLOW + "[���� üũ] : ���� GoldBigDragonRPG�� �ֽ� �����Դϴ�!");
			}
			else
			{
				s.SP(player,Sound.ANVIL_USE, 0.8F, 1.0F);
				player.sendMessage(ChatColor.RED + "[���� üũ] : ���� GoldBigDragonRPG�� ������Ʈ�� �ʿ��մϴ�!");
				player.sendMessage(ChatColor.RED + "[���� ����] : "+Main.serverVersion);
				player.sendMessage(ChatColor.RED + "[�ֽ� ����] : "+Main.currentServerVersion);
				player.sendMessage(ChatColor.RED + "[���� ��ġ] : "+Main.serverUpdate);
				player.sendMessage(ChatColor.RED + "[�ֽ� ��ġ] : "+Main.currentServerUpdate);
			}
			break;
		case "���� ����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Setting(player);
			return;
		case "����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new GBD.GoldBigDragon_Advanced.GUI.WarpGUI().WarpListGUI(player, 0);
			return;
		case "���� ����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new GBD.GoldBigDragon_Advanced.GUI.WorldCreateGUI().WorldCreateGUIMain(player);
			return;
		case "����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new MonsterGUI().MonsterListGUI(player, 0);
			return;
		case "�ʽ���":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new NewBieGUI().NewBieGUIMain(player);
			return;
		case "������":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new UpGradeGUI().UpgradeRecipeGUI(player,0);
			return;
		case "��ƼƼ ����":
			if(Config.getBoolean("Server.EntitySpawn") == true) {Config.set("Server.EntitySpawn", false);}
			else{Config.set("Server.EntitySpawn", true);}
			Config.saveConfig();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Main(player,1);
			return;
		case "���� ������":
			if(Config.getBoolean("Server.AttackDelay")==true) {Config.set("Server.AttackDelay", false);}
			else{Config.set("Server.AttackDelay", true);}
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Config.saveConfig();
			OPBoxGUI_Main(player,1);
			return;
		case "�̺�Ʈ":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new EventGUI().EventGUI_Main(player);
			return;
		case "���� ����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System")==true) {Config.set("Server.Like_The_Mabinogi_Online_Stat_System", false);}
			else{Config.set("Server.Like_The_Mabinogi_Online_Stat_System", true);}
			Config.saveConfig();
			OPBoxGUI_Main(player,1);
			GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
			J.AllPlayerFixAllSkillAndJobYML();
			return;
		case "Ŀ���� ������":
			ItemGUI IGUI = new ItemGUI();
			IGUI.ItemListGUI(player, 0);
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			return;
		case "���� ���� ȿ��":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(Config.getInt("Server.MonsterSpawnEffect")<7) {Config.set("Server.MonsterSpawnEffect", Config.getInt("Server.MonsterSpawnEffect")+1);}
			else{Config.set("Server.MonsterSpawnEffect", 0);}
			Config.saveConfig();
			OPBoxGUI_Main(player,1);
			return;
		case "�÷����� ���̵�":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Guide_GUI(player);
			return;
		case "����Ʈ":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new QuestGUI().AllOfQuestListGUI(player, 0,false);
			return;
		case "��ų":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new OPBoxSkillGUI().AllSkillsGUI(player,0,false,null);
			return;
		case "ī�װ� �� ����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new JobGUI().ChooseSystemGUI(player);
			return;
		case "�Һ� ������":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new UseableItemGUI().UseableItemListGUI(player, 0);
			return;
		case "����":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			new AreaGUI().AreaListGUI(player, 0);
			return;
		case "���� ������":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Main(player,Integer.parseInt(ChatColor.stripColor(event.getInventory().getItem(0).getItemMeta().getDisplayName()))-1);
			return;
		case "���� ������":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Main(player,Integer.parseInt(ChatColor.stripColor(event.getInventory().getItem(0).getItemMeta().getDisplayName()))+1);
			return;
		case "�ݱ�":
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
		return;
	}
	
	public void OPBoxGUI_SettingInventoryClick(InventoryClickEvent event)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		switch (event.getSlot())
		{
		case 10://��ƼƼ ����
			if(Config.getBoolean("Server.EntitySpawn") == true) {Config.set("Server.EntitySpawn", false);}
			else{Config.set("Server.EntitySpawn", true);}
			Config.saveConfig();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Setting(player);
			return;
		case 11://���� ������
			if(Config.getBoolean("Server.AttackDelay")==true) {Config.set("Server.AttackDelay", false);}
			else{Config.set("Server.AttackDelay", true);}
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Config.saveConfig();
			OPBoxGUI_Setting(player);
			return;
		case 12://���� ���� ȿ��
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			if(Config.getInt("Server.MonsterSpawnEffect")<7) {Config.set("Server.MonsterSpawnEffect", Config.getInt("Server.MonsterSpawnEffect")+1);}
			else{Config.set("Server.MonsterSpawnEffect", 0);}
			Config.saveConfig();
			OPBoxGUI_Setting(player);
			return;
		case 13://Ŀ���� ���� �ı�
			if(Config.getBoolean("Server.CustomWeaponBreak") == true) {Config.set("Server.CustomWeaponBreak", false);}
			else{Config.set("Server.CustomWeaponBreak", true);}
			Config.saveConfig();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Setting(player);
			return;
		case 14://���� �޽��� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			Main.UserData.get(player).setType("System");
			Main.UserData.get(player).setString((byte)1,"JM");
			player.sendMessage(ChatColor.GREEN+"[SYSTEM] : ���� �޽����� �Է� �� �ּ���! ("+ChatColor.WHITE+"����"+ChatColor.GREEN+" �Է½� ���� �޽��� ����)");
			player.sendMessage(ChatColor.GOLD + "%player%"+ChatColor.WHITE + " - �÷��̾� ��Ī�ϱ� -");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			return;
		case 15://���� �޽��� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			Main.UserData.get(player).setType("System");
			Main.UserData.get(player).setString((byte)1,"QM");
			player.sendMessage(ChatColor.GREEN+"[SYSTEM] : ���� �޽����� �Է� �� �ּ���! ("+ChatColor.WHITE+"����"+ChatColor.GREEN+" �Է½� ���� �޽��� ����)");
			player.sendMessage(ChatColor.GOLD + "%player%"+ChatColor.WHITE + " - �÷��̾� ��Ī�ϱ� -");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			return;
		case 16://��������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_BroadCast(player, 0);
			return;
		case 19://ä�� ���� ����
			if(event.isLeftClick())
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				Main.UserData.get(player).setType("System");
				Main.UserData.get(player).setString((byte)1,"CCP");
				player.sendMessage(ChatColor.GREEN+"[SYSTEM] : ä�� ���¸� �Է� �� �ּ���!");
				player.sendMessage(ChatColor.GOLD + "%t%"+ChatColor.WHITE + " - ���� �ð� ��Ī�ϱ� -");
				player.sendMessage(ChatColor.GOLD + "%gm%"+ChatColor.WHITE + " - ���Ӹ�� ��Ī�ϱ� -");
				player.sendMessage(ChatColor.GOLD + "%ct%"+ChatColor.WHITE + " - ä�� Ÿ�� ��Ī�ϱ� -");
				player.sendMessage(ChatColor.GOLD + "%lv%"+ChatColor.WHITE + " - ���� ��Ī�ϱ� -");
				player.sendMessage(ChatColor.GOLD + "%rlv%"+ChatColor.WHITE + " - ���� ���� ��Ī�ϱ� - (���� ������ �����ý��丮�� ��� ���� ����.)");
				player.sendMessage(ChatColor.GOLD + "%job%"+ChatColor.WHITE + " - ���� ��Ī�ϱ� - (���� ������ �������� ��� ���� ����.)");
				player.sendMessage(ChatColor.GOLD + "%player%"+ChatColor.WHITE + " - �÷��̾� ��Ī�ϱ� -");
				player.sendMessage(ChatColor.GOLD + "%message%"+ChatColor.WHITE + " - ä�� ���� ��Ī�ϱ� -");
				player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
				ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
						ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
				ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
						ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			}
			else if(event.isRightClick())
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				Config.removeKey("Server.ChatPrefix");
				Config.saveConfig();
				player.sendMessage(ChatColor.RED+"[SYSTEM] : ���λ縦 �����Ͽ����ϴ�!");
				OPBoxGUI_Setting(player);
			}
			return;
		case 20://Ŀ���� ��� ��ġ/��ġ ����
			if(Config.getBoolean("Server.CustomBlockPlace") == true) {Config.set("Server.CustomBlockPlace", false);}
			else{Config.set("Server.CustomBlockPlace", true);}
			Config.saveConfig();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Setting(player);
			return;
		case 21: //���� �̸� ����
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				OPBoxGUI_StatChange(player);
			}
			return;
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.8F);
			OPBoxGUI_Main(player, 1);
			return;
		case 53://�ݱ�
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
		return;
	}
	
	
	public void Guide_GUI (Player player)
	{
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "������ ���̵�");
		
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "���� �ý���", 340,0,1,Arrays.asList(ChatColor.GRAY+ "�÷����ο��� 5���� ������ �ֽ��ϴ�.",ChatColor.RED +"["+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"]",ChatColor.GRAY+""+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"�� �÷��̾���",ChatColor.GRAY+"������ �������� �����մϴ�.",ChatColor.GREEN +  "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"]",ChatColor.GRAY+""+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"�� �÷��̾��� �뷱�� ��",ChatColor.GRAY+"���� �������� ���� ǰ��,",ChatColor.GRAY+"���Ÿ� �������� �����մϴ�.",ChatColor.BLUE+"["+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"]",ChatColor.GRAY+""+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"�� ������� �� ������ȣ,",ChatColor.GRAY+"���� ���ݷ¿� �����մϴ�.",ChatColor.WHITE+"["+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"]",ChatColor.GRAY + ""+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"�� �÷��̾���",ChatColor.GRAY + "ũ��Ƽ�ÿ� �����մϴ�.",ChatColor.YELLOW + "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"]",ChatColor.GRAY + ""+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"�� ũ��Ƽ�� ��",ChatColor.GRAY +"��Ű �ǴϽ�, ��Ű ���ʽ� ��",ChatColor.GRAY +"���� 'Ȯ��'�� �����մϴ�."), 0,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "��Ű �ǴϽ�", 340,0,1,Arrays.asList(ChatColor.GRAY+ "���͸� ����Ͽ��� ���",ChatColor.GRAY+"���� Ȯ���� ���� �� ������ �˴ϴ�."), 1,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "��Ű ���ʽ�", 340,0,1,Arrays.asList(ChatColor.GRAY+ "ä���� �� ��� ���� Ȯ����",ChatColor.GRAY+"ä�� ǰ���� �� ������ �˴ϴ�."), 2,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "Ŀ���� ������ [1]", 340,0,1,Arrays.asList(ChatColor.GRAY+ "���� Ŀ���� ��������",ChatColor.GRAY+"�����ϰų� ����Ͽ�",ChatColor.GRAY+"������ �ҷ��� �� �ֽ��ϴ�.","",ChatColor.GOLD+"[��ɾ�]",ChatColor.YELLOW+"/������"), 3,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "Ŀ���� ������ [2]", 340,0,1,Arrays.asList(ChatColor.GRAY+ "�����, ���, ��ȣ ����",ChatColor.GRAY+"Ư�� �ɼ��� ���� ��������",ChatColor.GRAY+"�������� 0�� �� �� ȿ����",ChatColor.GRAY+"������� �ʽ��ϴ�.",ChatColor.GRAY+"�׷� ���, ���� �����ϰų�",ChatColor.GRAY+"�������� NPC�� ����",ChatColor.GRAY+"���� �޾ƾ� �մϴ�.","",ChatColor.GOLD+"[��ɾ�]",ChatColor.YELLOW+"/������ ����"), 4,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "���� ����", 340,0,1,Arrays.asList(ChatColor.GRAY+ "������ �����Ͽ� ���� Ȥ��",ChatColor.GRAY+"PVP��, ���� ����� ���� ������",ChatColor.GRAY+"������ �� �ֽ��ϴ�.",ChatColor.GRAY+"���� ������ ���� �ֱ� �湮��",ChatColor.GRAY+"�������� ��Ȱ �ϰų�,",ChatColor.GRAY+"���� ����� Ư�� �޽�����",ChatColor.GRAY+"���� �� �ֽ��ϴ�.","",ChatColor.GOLD+"[��ɾ�]",ChatColor.YELLOW+"/����"), 5,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "NPC", 340,0,1,Arrays.asList(ChatColor.GRAY+ "NPC ������ "+ChatColor.YELLOW+ "Citizens2 "+ChatColor.GRAY+ "�÷�������",ChatColor.GRAY+ "����Ͻô� ���� �����մϴ�.",ChatColor.GRAY+ "NPC ���� ��, �ش� NPC�� ��Ŭ�� �Ͽ�",ChatColor.GRAY+ "NPC�� ���� ���� ������ �� �� �ֽ��ϴ�."), 6,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����Ʈ", 340,0,1,Arrays.asList(ChatColor.GRAY+ "���ǹڽ����� ���� ���� ����Ʈ��",ChatColor.GRAY+"���� ������ �����Ͻ� �� �ֽ��ϴ�.","",ChatColor.GOLD+"[��ɾ�]",ChatColor.YELLOW+"/���ǹڽ�",ChatColor.YELLOW+"/����Ʈ ����"+ChatColor.DARK_AQUA+" [Ÿ��]"+ChatColor.YELLOW+" [����Ʈ �̸�]","",ChatColor.DARK_AQUA+"[�Ϲ�/�ݺ�/����/����/�Ѵ�]"), 7,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "�̺�Ʈ", 340,0,1,Arrays.asList(ChatColor.GRAY+ "���ǹڽ� 1�������� �ִ� "+ChatColor.YELLOW+"'�̺�Ʈ'",ChatColor.GRAY+ "�������� Ŭ���Ͽ� ���ٸ�",ChatColor.GRAY+ "������ Ư�� �̺�Ʈ��",ChatColor.GRAY+"���� �Ͻ� �� �ֽ��ϴ�.",ChatColor.GRAY+"�����鰣 �뷱���� �����ϸ�",ChatColor.GRAY+"������ �̺�Ʈ�� ���� �ݽô�."), 8,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "��ų [1]", 340,0,1,Arrays.asList(ChatColor.GRAY+ "���ǹڽ� 2�������� �ִ� "+ChatColor.YELLOW+"'��ų'",ChatColor.GRAY+ "�������� Ŭ���Ͽ� ���ٸ�",ChatColor.GRAY+ "���� ��ų�� �����ϰų� �����ϴ�",ChatColor.GRAY+"GUI ȭ���� ��Ÿ���ϴ�.",ChatColor.GRAY+"�̰����� ������ ���� ��ų����",ChatColor.GRAY+"������ �ֵ� �ý��ۿ� ���� �з��Ͽ�",ChatColor.GRAY+"���� ������ ��� �����ϰ� �Ǹ�",ChatColor.GRAY+"��ų�� "+ChatColor.LIGHT_PURPLE+"Ŀ�ǵ�"+ChatColor.GRAY+"�� ����� �� ������,",ChatColor.DARK_AQUA+"MagicSpells �÷�����"+ChatColor.GRAY+"��"+ChatColor.DARK_AQUA+" ����"+ChatColor.GRAY+"�մϴ�."), 9,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "��ų [2]", 340,0,1,Arrays.asList(ChatColor.GRAY+ "��ų�� ���� �ϼ̴ٸ�",ChatColor.GRAY+ "��ų ��ũ�� ����� �����Դϴ�.",ChatColor.GRAY+ "��ų ��ũ�� ����̴ٸ�",ChatColor.GRAY+ "������ ��ų ��ũ�� �´�",ChatColor.GRAY+ "Ŀ�ǵ� Ȥ�� ���������� ����,",ChatColor.GRAY+ "��ũ���� ��� ���� ���ʽ� ����,",ChatColor.GRAY+ "��ũ���� �ʿ��� ��ų ����Ʈ ��",ChatColor.GRAY+ "�پ��� �ɼ��� �����Ͻ� �� �ֽ��ϴ�."), 10,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����, �׸��� �ý��� [1]", 340,0,1,Arrays.asList(ChatColor.YELLOW+ "GoldBigDragon_Advanced",ChatColor.GRAY+ "(���� GBD_A)",ChatColor.GRAY+ "�÷����ο��� �� ���� ���� �ý�����",ChatColor.GRAY+ "�����մϴ�. "+ChatColor.STRIKETHROUGH+"(���̺긮�� �÷�����)",ChatColor.GRAY+ "�� ���� Ư���� ����ϸ鼭��",ChatColor.GRAY+ "���� �ٸ��⿡, �ý��� �����",ChatColor.GRAY+ "���Ǹ� ���մϴ�."), 11,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����, �׸��� �ý��� [2]", 340,0,1,Arrays.asList(ChatColor.RED+""+ChatColor.BOLD+ "[������ ���丮]",ChatColor.GRAY+ "ù ��°�� �˾ƺ��� �ý�����",ChatColor.GRAY+ "�����в� ģ���� ������",ChatColor.GRAY+ "�����ý��丮�� ������",ChatColor.GRAY+ "�����ý��丮�� �ý����Դϴ�.",ChatColor.GRAY+ "���� ���� ���� ���� Ŭ������",ChatColor.GRAY+ "�����Ͻ� �� ������,",ChatColor.GRAY+ "���� Ŭ���� ������ �Ǵٽ�",ChatColor.GRAY+ "2�� ����, 3�� ������ ����",ChatColor.GRAY+ "�±� ������ �����մϴ�.",ChatColor.GRAY+ "���� ���� �� �±޺��� ��������",ChatColor.GRAY+ "��ų�� �ο��� �� �ְ� �Ǹ�,",ChatColor.GRAY+ "������ ��, ���� ����Ʈ�� �����ϸ�",ChatColor.GRAY+ "������ ������ ���ϴ� ����",ChatColor.GRAY+ "���������ν� �������ϴ�.",ChatColor.GRAY+ "������ "+ChatColor.DARK_PURPLE+"Citizens �÷�����"+ChatColor.GRAY+"����",ChatColor.GRAY+ "NPC�� ������ ��, �� Ŭ����",ChatColor.GRAY+ "NPC���� â�� ������ �װ�����",ChatColor.GOLD+ "[���� ����]"+ChatColor.GRAY+"��ư�� ���� ����",ChatColor.GOLD+ "[���� ����]"+ChatColor.GRAY+"�� ������ ���",ChatColor.GRAY+ "�������� �ش� NPC�� ����",ChatColor.GRAY+ "������ Ŭ������ ������ ������ ���ϴ�."), 12,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����, �׸��� �ý��� [3]", 340,0,1,Arrays.asList(ChatColor.WHITE+""+ChatColor.BOLD+ "[������]",ChatColor.GRAY+ "�� ��°�� �˾ƺ��� �ý�����",ChatColor.GRAY+ "���� ���� �����̾���",ChatColor.GRAY+ "������ ������ �ý����Դϴ�.",ChatColor.GRAY+ "������ �ý����� ���",ChatColor.GRAY+ "�����ý��丮 ó�� ������",ChatColor.GRAY+ "���� ����Ʈ ������ ������",ChatColor.GRAY+ "������ ������ ���� ����",ChatColor.GRAY+ "��� ��ų�� ��� �� �ִ�",ChatColor.GRAY+ "������ �������� ������ �ֽ��ϴ�.",ChatColor.GRAY+ "������ ������ ���丮ó��",ChatColor.GRAY+ "������ ������ ��ų�� ��� �ִ�",ChatColor.GRAY+ "������ �ƴ϶�, �ڽ��� ����",ChatColor.DARK_PURPLE+ "NPC�� ��ȭ"+ChatColor.GRAY+"�� �ϰų�",ChatColor.DARK_PURPLE+ "Ư���� å"+ChatColor.GRAY+"�� �������ν�",ChatColor.GRAY+ "��ų�� �͵��� �� �ֽ��ϴ�.",ChatColor.GRAY+ "��ų�� ���������� ������",ChatColor.GRAY+ "�����ǿ� ����� ��ų��",ChatColor.GRAY+ "�����ǿ� ����� �� �����ϴ�.",ChatColor.AQUA+ "ȯ��"+ChatColor.GRAY+" ��"+ChatColor.DARK_PURPLE+" Ư���� å"+ChatColor.GRAY+"�� ���� ������",ChatColor.GRAY+"���� ���̵忡�� �����ϰڽ��ϴ�."), 13,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����, �׸��� �ý��� [4]", 340,0,1,Arrays.asList(ChatColor.WHITE+""+ChatColor.BOLD+"[������]",ChatColor.AQUA+ "<ȯ��>",ChatColor.GRAY+ "������ ���丮�� ������ ������ �ֽ��ϴ�.",ChatColor.GRAY+ "������ �����⿡�� ������ �ִٸ�",ChatColor.GRAY+ "��� ��ų�� ������ ���� ������.",ChatColor.GRAY+ "�̷� ���� �غ��ϱ� ���� ��ġ��",ChatColor.AQUA+ "'ȯ��'"+ChatColor.GRAY+"�Դϴ�.",ChatColor.GRAY+ "ȯ���� �� ���, ���ݱ��� ����",ChatColor.GRAY+ "��� ������ '���� ����'�� ��������,",ChatColor.GRAY+ "�Ϲ����� ������ 1�� �ʱ�ȭ �˴ϴ�.",ChatColor.GRAY+ "�̴� ������ �ƴ�, ��ų ����Ʈ��",ChatColor.GRAY+ "���� ������ ���� �� �ִ� ��ġ�Դϴ�.",ChatColor.GRAY+ "������ 1�� �ȴٸ� �ڽ��� ��ƾ� ��",ChatColor.GRAY+ "����ġ ���� �������״ϱ��.",ChatColor.GRAY+ "���� ĳ������ ���̰� 20���� �Ǹ�",ChatColor.GRAY+ "ȯ���� ����������, �� �÷����ο�����",ChatColor.GRAY+ "�Һ� �������� "+ChatColor.YELLOW+"ȯ�� ����"+ChatColor.GRAY+"��",ChatColor.GRAY+ "�����ϰ� �ֽ��ϴ�."), 14,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����, �׸��� �ý��� [5]", 340,0,1,Arrays.asList(ChatColor.WHITE+""+ChatColor.BOLD+ "[������]",ChatColor.DARK_PURPLE+ "<Ư���� å>",ChatColor.GRAY+ "���ǹڽ� 2�������� �ִ�",ChatColor.GREEN+ "�Һ� ������"+ChatColor.GRAY + " �������� Ŭ���ϸ�",ChatColor.GRAY+ "��ų ����Ʈ �ֹ������� ����",ChatColor.GRAY+ "ȯ������ ������ ����",ChatColor.GRAY+ "��κ��� �Һ� �������� ����ų�",ChatColor.GRAY+ "������ �� ������, ���� ����帱",ChatColor.DARK_PURPLE+ "Ư���� å"+ChatColor.GRAY+" ���� ������ �����մϴ�.",ChatColor.GRAY+ "Ư����å�� ���, ������ �ٷ� �Ҹ� ������",ChatColor.GRAY+ "�÷��̾ �𸣴� ��ų��",ChatColor.GRAY+ "���� �� �ֵ��� �ϰų�,",ChatColor.GRAY+ "Ư�� ������ �������ִ�",ChatColor.GRAY+ "�ɷ��� ������ �ֽ��ϴ�.",ChatColor.GRAY+ "�׷��⿡ ���� ������ �翬",ChatColor.GRAY+ "�߿� �ŷ� ǰ���� �� ���ɼ���",ChatColor.GRAY+ "���� �������̹Ƿ�, �����",ChatColor.GRAY+ "������ �뷱�� �������� �ʿ���",ChatColor.GRAY+ "������ 1������� ���Ƶ�",ChatColor.GRAY+ "������ �ƴմϴ�.",ChatColor.GRAY+ "�뷱���� ���� �����,",ChatColor.GRAY+ "�̺�Ʈ�� ���� ����,",ChatColor.GRAY+ "���� ���� ������ ������",ChatColor.GRAY+ "������ ���Դϴ�."), 15,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "����", 340,0,1,Arrays.asList(ChatColor.GRAY+ "Ŀ���� ���������� ����",ChatColor.GRAY+ "������ ��, ���� �ɼ���",ChatColor.GRAY+ "���� �������� ��츸",ChatColor.GRAY+ "������ �����ϸ�, ������",ChatColor.DARK_AQUA+ "[���� ����]"+ChatColor.GRAY+"�� �������� ����",ChatColor.GRAY+ "NPC���� ���� �� �ֽ��ϴ�.",ChatColor.GRAY+ "���� ���ο��� ���ǹڽ����� ����",ChatColor.GRAY+ "�������� ��Ͻ�Ű��",ChatColor.GRAY+ "�ش� NPC���Լ� �ش� ������",ChatColor.GRAY+ "�����ϰ� �˴ϴ�."), 16,inv);
		Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "��", 340,0,1,Arrays.asList(ChatColor.GRAY+ "������ ����� ����������",ChatColor.GRAY+ "���� Ȯ���� ������,",ChatColor.BLUE+ "��"+ChatColor.GRAY+" �̶�� �������� �ʿ��մϴ�.",ChatColor.GRAY+ "���� ���ǹڽ� 2����������",ChatColor.GRAY+ "���� ���� �� �ֽ��ϴ�."), 17,inv);
		//Stack2(ChatColor.YELLOW +""+ ChatColor.BOLD + "", 340,0,1,Arrays.asList(ChatColor.GRAY+ ""), 18,inv);
		Stack2(ChatColor.RED +"            "+ChatColor.BOLD +"��"+ChatColor.BLUE +""+ChatColor.BOLD +"��"+ChatColor.GREEN +""+ChatColor.BOLD +"��"+ChatColor.YELLOW +""+ChatColor.BOLD +"��"+ChatColor.WHITE +""+ChatColor.BOLD +"Ʈ            ", 403,0,1,Arrays.asList("",
				ChatColor.GRAY+ "�ɰ��� : "+ChatColor.DARK_RED+"|||||||||||||||||||||||||||||||||||||||| [�ְ�]",ChatColor.RED+ "�� ������ �������� ���� ������ȣ ���� ��",ChatColor.RED+ "���� ���/��ȣ�� �������� Pain ��ų",ChatColor.RED+ "Ŭ������ ������� �����","",
				ChatColor.GRAY+ "�ɰ��� : "+ChatColor.GOLD+"||||||||||||||||||||"+ChatColor. GRAY+"||||||||||||||||||||"+ChatColor.GOLD+" [����]",ChatColor.YELLOW+"�� ���� ���� �𸣴� ������ ��. ����","",
				ChatColor.GRAY+ "�ɰ��� : "+ChatColor.DARK_GREEN+"||||||||||"+ChatColor. GRAY+"||||||||||||||||||||||||||||||"+ChatColor.DARK_GREEN+" [����]",ChatColor.GREEN+"�� ������ ����� ���ʽ��� ����",ChatColor.GREEN+"�ٷιٷ� ������Ʈ�� ���� ������",ChatColor.GREEN+"�°ų� �ֹٸ� �����̸� ���ΰ�����."), 22,inv);

		Stack2(ChatColor.DARK_RED +""+ ChatColor.BOLD + "[������ ���̵�]", 389,0,1,Arrays.asList("",ChatColor.AQUA+ "[Ŭ���� ������ URL�� �������ϴ�.]"), 36,inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ â�� �ݽ��ϴ�."), 53, inv);
		
		player.openInventory(inv);
	}
	
	public void OPBoxGuideInventoryclick(InventoryClickEvent event)
	{
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		switch ((ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())))
		{
		case "[������ ���̵�]":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			event.setCancelled(true);
			player.sendMessage(ChatColor.DARK_RED+""+ChatColor.BOLD+"[YouTube] "+ChatColor.WHITE+""+ChatColor.BOLD+": "+ChatColor.DARK_AQUA+""+ChatColor.BOLD+"https://www.youtube.com/playlist?list=PLxqihkJXVJABIlxU3n6bNhhC8x6xPbORP   "+ChatColor.YELLOW+""+ChatColor.BOLD+"[Ŭ���� ���̵� �������� ����˴ϴ�]");
			break;
		case "���� ���":
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			event.setCancelled(true);
			OPBoxGUI_Main(player,1);
			break;
		case "�ݱ�":
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			event.setCancelled(true);
			player.closeInventory();
			return;
			default : return;
		}
		return;
	}

	public void OPBoxGUI_BroadCastClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;

		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager BroadCast =GUI_YC.getNewConfig("BroadCast.yml");
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Setting(player);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_BroadCast(player, page-1);
			return;
		case 49://�� ����
			int BCnumber = BroadCast.getConfigurationSection("").getKeys(false).size();
			BroadCast.set(BCnumber+"", ChatColor.YELLOW+"[���ο� �������� ���� ��]");
			BroadCast.saveConfig();
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.DARK_AQUA+"[����] : ���ο� ���� ������ �Է� �� �ּ���!");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
			Main.UserData.get(player).setType("System");
			Main.UserData.get(player).setString((byte)1, "NBM");
			Main.UserData.get(player).setInt((byte)0, BCnumber);
			return;
		case 46://���� ����
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.DARK_AQUA+"[����] : �� �ʸ��� ������ �����?");
			player.sendMessage(ChatColor.YELLOW+"(�ּ� 1�� ~ �ִ� 3600��(1�ð�) ���� ���ڸ� �Է� �ϼ���!)");
			Main.UserData.get(player).setType("System");
			Main.UserData.get(player).setString((byte)1, "BMT");
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_BroadCast(player, page+1);
			return;
		default :
			if(event.isShiftClick() == true && event.isRightClick() == true)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				int Acount =  BroadCast.getConfigurationSection("").getKeys(false).toArray().length-1;
				int number = ((page*45)+event.getSlot());
				for(int counter = number;counter <Acount;counter++)
					BroadCast.set(counter+"", BroadCast.get((counter+1)+""));
				BroadCast.removeKey(Acount+"");
				BroadCast.saveConfig();
				OPBoxGUI_BroadCast(player, page);
			}
			return;
		}
	}

	public void OPBoxGUI_StatChangeClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI_Setting(player);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		default:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
<<<<<<< HEAD

			if(event.getSlot()>=9&&event.getSlot()<=13)
			{
				player.sendMessage(ChatColor.DARK_AQUA+"[System] : ���ο� "+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())+"�� �Է� �� �ּ���!");
				player.sendMessage(ChatColor.GOLD + "%enter%"+ChatColor.WHITE + " - ���� ��� ���� -");
				player.sendMessage(ChatColor.GOLD + "%stat%"+ChatColor.WHITE + " - ���� �̸� ���� -");
			}
			else
			{
				player.sendMessage(ChatColor.DARK_AQUA+"[System] : ���ο� "+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())+" ���� �̸��� �Է� �� �ּ���!");
				player.sendMessage(ChatColor.GRAY+"(��� ���� �� ��ȣ ��� �Ұ�)");
			}
=======
			player.sendMessage(ChatColor.DARK_AQUA+"[System] : ���ο� "+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())+" ���� �̸��� �Է� �� �ּ���!");
			player.sendMessage(ChatColor.GRAY+"(��� ���� �� ��ȣ ��� �Ұ�)");
			player.sendMessage(ChatColor.WHITE + ""+ChatColor.BOLD + "&l " + ChatColor.BLACK + "&0 "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+
			ChatColor.DARK_AQUA + "&3 " +ChatColor.DARK_RED + "&4 " + ChatColor.DARK_PURPLE + "&5 " +
					ChatColor.GOLD + "&6 " + ChatColor.GRAY + "&7 " + ChatColor.DARK_GRAY + "&8 " +
			ChatColor.BLUE + "&9 " + ChatColor.GREEN + "&a " + ChatColor.AQUA + "&b " + ChatColor.RED + "&c " +
					ChatColor.LIGHT_PURPLE + "&d " + ChatColor.YELLOW + "&e "+ChatColor.WHITE + "&f");
>>>>>>> origin/GoldBigDragonRPG_Advanced
			Main.UserData.get(player).setType("System");
			Main.UserData.get(player).setString((byte)1, "CSN");
			Main.UserData.get(player).setString((byte)2, ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
			return;
		}
	}
}
