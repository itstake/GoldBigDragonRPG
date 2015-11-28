package GBD.GoldBigDragon_Advanced.GUI;

import java.util.Arrays;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import GBD.GoldBigDragon_Advanced.Main.Main;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class JobGUI extends GUIutil
{
	public void ChooseSystemGUI(Player player)
	{
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLACK + "�ý��� ����");
		
		Stack2(ChatColor.GOLD + "" + ChatColor.BOLD + "������", 346,0,1,Arrays.asList(ChatColor.GRAY + "������ ���丮�ʹ� �ٸ���",ChatColor.GRAY + "�����Ӱ� ��ų�� ���� �� �� �ֽ��ϴ�.",ChatColor.GRAY+"���� ������ ���� ������",ChatColor.GRAY+"ī�װ����� ��ų�� �����ϴ�.","",ChatColor.GREEN+"������ : "+ChatColor.YELLOW+"||||||||||||||||||||",ChatColor.GREEN+"�밡�� : "+ChatColor.YELLOW+"||||||||||||||||||||","",ChatColor.RED+"[���� ������ �������� ��츸 ����]"), 12, inv);
		Stack2(ChatColor.RED + "" + ChatColor.BOLD + "������ ���丮", 40,0,1,Arrays.asList(ChatColor.GRAY + "������ʹ� �ٸ���",ChatColor.GRAY + "�������� ��ų�� �����Ǿ� �ֽ��ϴ�.",ChatColor.GRAY+"���� ������ �����ϱ� ������",ChatColor.GRAY+"������ �� �±޺��� ��ų�� �����ϴ�.","",ChatColor.GREEN+"������ : "+ChatColor.YELLOW+"||||||"+ChatColor.GRAY+"||||||||||||||",ChatColor.GREEN+"�밡�� : "+ChatColor.YELLOW+"|||||||||||"+ChatColor.GRAY+"|||||||||","",ChatColor.RED+"[���� ������ ������ ���丮�� ��츸 ����]"), 14, inv);
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 18, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ â�� �ݽ��ϴ�."), 26, inv);
		player.openInventory(inv);
	}

	public void MapleStory_ChooseJob(Player player, int page)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager JobList  = GUI_YC.getNewConfig("Skill/JobList.yml");
		YamlManager Config = GUI_YC.getNewConfig("config.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "[MapleStory] ��ü ���� ��� : " + (page+1));

		Set<String> b= JobList.getConfigurationSection("MapleStory").getKeys(false);
		Object[] a = b.toArray();
		
		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			String JobName = a[count].toString();
			Set<String> JobLevel= JobList.getConfigurationSection("MapleStory."+JobName).getKeys(false);
			
			if(count > a.length || loc >= 45) break;
			
			if(JobName.equalsIgnoreCase(Config.getString("Server.DefaultJob")))
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + JobName, 403,0,1,Arrays.asList(ChatColor.DARK_AQUA+"�ִ� �±� : " + ChatColor.WHITE+JobLevel.size()+ChatColor.DARK_AQUA+"�� �±�","",ChatColor.YELLOW+"[��Ŭ���� �±� ����]",ChatColor.YELLOW+""+ChatColor.BOLD+"[���� �⺻ ����]"), loc, inv);
			else
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + JobName, 340,0,1,Arrays.asList(ChatColor.DARK_AQUA+"�ִ� �±� : " + ChatColor.WHITE+JobLevel.size()+ChatColor.DARK_AQUA+"�� �±�","",ChatColor.YELLOW+"[��Ŭ���� �±� ����]",ChatColor.YELLOW+"[Shift + ��Ŭ���� ���� �⺻ ���� ����]",ChatColor.RED+"[Shift + ��Ŭ���� ���� ����]",ChatColor.RED+"�÷��̾� ���� �������� ���� �������ϴ�."), loc, inv);
			
			loc=loc+1;
		}
		
		if(a.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ����", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ������ �����մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�."), 53, inv);
		player.openInventory(inv);
	}
	
	public void MapleStory_JobSetting(Player player, String JobName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager JobList  = GUI_YC.getNewConfig("Skill/JobList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLACK + "[MapleStory] ���� ����");

		Set<String> b= JobList.getConfigurationSection("MapleStory."+JobName).getKeys(false);
		Object[] a = b.toArray();

		for(int count = 0; count < b.size();count++)
		{
			String JobNick =  a[count].toString();
			int JobSkillList= JobList.getConfigurationSection("MapleStory."+JobName+"."+JobNick+".Skill").getKeys(false).size();
			
			int IconID = JobList.getInt("MapleStory."+JobName+"."+JobNick+".IconID");
			int IconData = JobList.getInt("MapleStory."+JobName+"."+JobNick+".IconData");
			int IconAmount = JobList.getInt("MapleStory."+JobName+"."+JobNick+".IconAmount");

			int NeedLevel = JobList.getInt("MapleStory."+JobName+"."+JobNick+".NeedLV");
			int NeedSTR = JobList.getInt("MapleStory."+JobName+"."+JobNick+".NeedSTR");
			int NeedDEX = JobList.getInt("MapleStory."+JobName+"."+JobNick+".NeedDEX");
			int NeedINT = JobList.getInt("MapleStory."+JobName+"."+JobNick+".NeedINT");
			int NeedWILL = JobList.getInt("MapleStory."+JobName+"."+JobNick+".NeedWILL");
			int NeedLUK = JobList.getInt("MapleStory."+JobName+"."+JobNick+".NeedLUK");
			String PrevJob = JobList.getString("MapleStory."+JobName+"."+JobNick+".PrevJob");
			if(PrevJob.equalsIgnoreCase("null") == true)
				PrevJob = "����";
			

			if(count == 0)
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + JobNick , IconID,IconData,IconAmount,Arrays.asList(ChatColor.DARK_AQUA+"��ϵ� ��ų �� : "+ChatColor.WHITE+JobSkillList+ ChatColor.DARK_AQUA+"��",ChatColor.GREEN+"�±� �ʿ� ���� : "+ChatColor.WHITE+NeedLevel+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : "+ChatColor.WHITE+NeedSTR+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : "+ChatColor.WHITE+NeedDEX+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : "+ChatColor.WHITE+NeedINT+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : "+ChatColor.WHITE+NeedWILL+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : "+ChatColor.WHITE+NeedLUK+ChatColor.GREEN+" �̻�"	,ChatColor.GREEN+"���� �±� �ܰ� : "+ChatColor.WHITE+PrevJob,"",ChatColor.YELLOW+"[�� Ŭ���� ���� ��ų ���]",ChatColor.YELLOW+"[�� Ŭ���� ���� ��ų Ȯ��]",ChatColor.YELLOW+"[Shift + �� Ŭ���� �±� ���� ����]",ChatColor.YELLOW+""+ChatColor.BOLD+"[�⺻ Ŭ����]"), count, inv);
			else
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + JobNick, IconID,IconData,IconAmount,Arrays.asList(ChatColor.DARK_AQUA+"��ϵ� ��ų �� : "+ChatColor.WHITE+JobSkillList+ ChatColor.DARK_AQUA+"��",ChatColor.GREEN+"�±� �ʿ� ���� : "+ChatColor.WHITE+NeedLevel+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : "+ChatColor.WHITE+NeedSTR+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : "+ChatColor.WHITE+NeedDEX+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : "+ChatColor.WHITE+NeedINT+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : "+ChatColor.WHITE+NeedWILL+ChatColor.GREEN+" �̻�",ChatColor.GREEN+"�±� �ʿ� "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : "+ChatColor.WHITE+NeedLUK+ChatColor.GREEN+" �̻�"	,ChatColor.GREEN+"���� �±� �ܰ� : "+ChatColor.WHITE+PrevJob,"",ChatColor.YELLOW+"[�� Ŭ���� ���� ��ų ���]",ChatColor.YELLOW+"[�� Ŭ���� ���� ��ų Ȯ��]",ChatColor.YELLOW+"[Shift + �� Ŭ���� �±� ���� ����]",ChatColor.RED+"[Shift + ��Ŭ���� �±� ����]",ChatColor.RED+"�÷��̾ �������� ���� �������ϴ�."), count, inv);
		}
		
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� �±�", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� �±� Ŭ������ ����ϴ�."), 22, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 18, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+JobName), 26, inv);
		player.openInventory(inv);
	}
	
	public void Mabinogi_ChooseCategory(Player player, int page)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager JobList  = GUI_YC.getNewConfig("Skill/JobList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "[Mabinogi] ��ü ī�װ� ��� : " + (page+1));

		Set<String> b= JobList.getConfigurationSection("Mabinogi").getKeys(false);
		Object[] a = b.toArray();
		
		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			String CategoryName = a[count].toString();
			if(CategoryName.equals("Added") == false)
			{
				if(count > a.length || loc >= 45) break;
				int SkillNumber = JobList.getConfigurationSection("Mabinogi."+CategoryName).getKeys(false).size();
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + CategoryName, 403,0,1,Arrays.asList(ChatColor.DARK_AQUA+"��ϵ� ��ų : " +ChatColor.WHITE+SkillNumber+ChatColor.DARK_AQUA+" ��","",ChatColor.YELLOW+"[�� Ŭ���� ��ų ���]",ChatColor.YELLOW+"[Shift + �� Ŭ���� ��ų ����]",ChatColor.RED+"[Shift + ��Ŭ���� ī�װ� ����]"), loc, inv);
				loc=loc+1;
			}
		}
		
		if(a.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�� ī�װ�", 386,0,1,Arrays.asList(ChatColor.GRAY + "���ο� ī�װ��� �����մϴ�."), 49, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�."), 53, inv);
		player.openInventory(inv);
	}
	
	public void Mabinogi_SkillSetting(Player player, int page, String CategoriName)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager JobList  = GUI_YC.getNewConfig("Skill/JobList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "[Mabinogi] ��ų ���� ��� : " + (page+1));

		Set<String> b= JobList.getConfigurationSection("Mabinogi."+CategoriName).getKeys(false);
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		Object[] a = b.toArray();
		
		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			String SkillName = a[count].toString();
			boolean SkillPublic = JobList.getBoolean("Mabinogi."+CategoriName+"."+SkillName);
			if(count > a.length || loc >= 45) break;

			int IconID = SkillList.getInt(SkillName+".ID");
			int IconData = SkillList.getInt(SkillName+".DATA");
			int IconAmount = SkillList.getInt(SkillName+".Amount");
			
			if(SkillPublic == true)
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + SkillName, IconID,IconData,IconAmount,Arrays.asList("",ChatColor.DARK_AQUA+"[   �⺻ ��ų   ]",ChatColor.GRAY+"���� ���ӽ� �⺻������",ChatColor.GRAY+"�־����� ��ų�Դϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� ���� ��ų ��ȯ]",ChatColor.RED+"[Shift + ��Ŭ���� ��ų ����]","",ChatColor.RED+"     ��  ����  ��     ",ChatColor.RED+"���� ��ų���� ��ȯ �ϴ���",ChatColor.RED+"���� �ش� ��ų�� �˰� �ִ�",ChatColor.RED+"������ ��ų�� �������� ������,",ChatColor.RED+"�ű� �������� ��ų �ڵ� ���游",ChatColor.RED+"�Ұ��� �ϰ� �˴ϴ�."), loc, inv);
			else
				Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + SkillName, IconID,IconData,IconAmount,Arrays.asList("",ChatColor.DARK_PURPLE+"[   ���� ��ų   ]",ChatColor.GRAY+"å�� �аų� ����Ʈ ������ ���Ͽ�",ChatColor.GRAY+"���� �� �ִ� ��ų�Դϴ�.","",ChatColor.YELLOW+"[�� Ŭ���� �⺻ ��ų ��ȯ]",ChatColor.RED+"[Shift + ��Ŭ���� ��ų ����]","",ChatColor.RED+"     ��  ����  ��     ",ChatColor.RED+"�⺻ ��ų���� ��ȯ ��ų ���",ChatColor.RED+"���� ������ ��� �ο�����,",ChatColor.RED+"�׸��� ��ȯ ���Ŀ� ������ ���",ChatColor.RED+"�ű� �����鿡�� �ش� ��ų�� �־����ϴ�.",ChatColor.RED+"[���� ������ ���� ����� �� �߻�]"), loc, inv);

			loc=loc+1;
		}
		
		if(a.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�."), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK + CategoriName), 53, inv);
		player.openInventory(inv);
	}
	
	public void AddedSkillsListGUI(Player player, int page, String JobName, String JobNick)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
		YamlManager JobList  = GUI_YC.getNewConfig("Skill/JobList.yml");
		
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "��ϵ� ��ų ��� : " + (page+1));

		Set<String> b= JobList.getConfigurationSection("MapleStory."+JobName+"."+JobNick+".Skill").getKeys(false);
		Object[] a = b.toArray();
		
		int loc=0;
		for(int count = page*45; count < a.length;count++)
		{
			if(count > a.length || loc >= 45) break;
			
			Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + a[count].toString(),  SkillList.getInt(a[count].toString()+".ID"),SkillList.getInt(a[count].toString()+".DATA"),SkillList.getInt(a[count].toString()+".Amount"),Arrays.asList("",ChatColor.RED+"[Shift + �� Ŭ���� ��ų ����]"), loc, inv);

			loc=loc+1;
		}
		
		if(a.length-(page*44)>45)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 50, inv);
		if(page!=0)
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ������", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� �������� �̵� �մϴ�."), 48, inv);

		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "���� ȭ������ ���ư��ϴ�.",ChatColor.BLACK+JobNick), 45, inv);
		Stack2(ChatColor.WHITE + "" + ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "â�� �ݽ��ϴ�.",ChatColor.BLACK+JobName), 53, inv);
		player.openInventory(inv);
	}
	
	
	
	
	public void ChooseSystemGUIClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 12:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Mabinogi_ChooseCategory(player,0);
			return;
		case 14:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MapleStory_ChooseJob(player,0);
			return;
		case 18:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OPBoxGUI OGUI = new OPBoxGUI();
			OGUI.OPBoxGUI_Main(player,2);
			return;
		case 26:
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}

	public void MapleStory_ChooseJobClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			ChooseSystemGUI(player);
			break;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			break;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MapleStory_ChooseJob(player,Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-2);
			break;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MapleStory_ChooseJob(player,Integer.parseInt(event.getInventory().getTitle().split(" : ")[1]));
			break;
		case 49://�� ����
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[����] : ���ο� ���� �̸��� ������ �ּ���!");
			Main.UserData.get(player).setType("Job");
			Main.UserData.get(player).setString((byte)1, "CJ");
			break;
		default :
			if(event.isLeftClick()==true&&event.isRightClick()==false)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				MapleStory_JobSetting(player, ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
			}
			if(event.getCurrentItem().getItemMeta().getLore().toString().contains("����")==true&&event.isShiftClick()==true
			&&event.isLeftClick()==true)
			{
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager Config = GUI_YC.getNewConfig("config.yml");
				Config.set("Server.DefaultJob", ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
				Config.saveConfig();
				MapleStory_ChooseJob(player, Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1);
			}
			else if(event.getCurrentItem().getItemMeta().getLore().toString().contains("����")==true&&event.isShiftClick()==true
			&&event.isRightClick()==true)
			{
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager Config  = GUI_YC.getNewConfig("config.yml");
				if(Config.getString("Server.DefaultJob").equalsIgnoreCase(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())))
				{
					s.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
					player.sendMessage(ChatColor.RED + "[����] : ���� �⺻ ������ ������ �� �����ϴ�!");
				}
				else
				{
					s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
					YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
					YamlManager SkillList  = Config_YC.getNewConfig("Skill/JobList.yml");
					SkillList.removeKey("MapleStory."+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
					SkillList.saveConfig();
					MapleStory_ChooseJob(player, Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1);
					GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
					J.AllPlayerFixAllSkillAndJobYML();
				}
			}
			return;
		}
	}

	public void MapleStory_JobSettingClick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		String JobName = ChatColor.stripColor(event.getInventory().getItem(26).getItemMeta().getLore().get(1));
		String JobNick = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

		YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
		YamlManager SkillList  = Config_YC.getNewConfig("Skill/JobList.yml");
		int NowJobLV = SkillList.getConfigurationSection("MapleStory."+JobName).getKeys(false).size();
		switch (event.getSlot())
		{
		case 18://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MapleStory_ChooseJob(player, 0);
			return;
		case 26://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 22://�� �±�
			if(NowJobLV == 18)
			{
				s.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
				player.sendMessage(ChatColor.RED + "[����] : �ִ� �±��� 18�� ���� �Դϴ�!");
				return;
			}
			else
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.LIGHT_PURPLE+"[����] : "+ChatColor.YELLOW + JobName+ChatColor.LIGHT_PURPLE+"�� �� �±� ���� �̸��� ������ �ּ���!");

				Main.UserData.get(player).setType("Job");
				Main.UserData.get(player).setString((byte)1, "CJL");
				Main.UserData.get(player).setString((byte)2, JobName);
			}
			break;
		default :
			if(event.isLeftClick()==true&&event.isShiftClick()==false)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI SKGUI = new GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI();
				Main.UserData.get(player).setType("Job");
				Main.UserData.get(player).setString((byte)2, JobNick);
				Main.UserData.get(player).setString((byte)3, JobName);
				SKGUI.AllSkillsGUI(player,0, true,"Maple");
			}
			else if(event.isShiftClick()==true&&event.isLeftClick()==true)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				player.closeInventory();
				player.sendMessage(ChatColor.LIGHT_PURPLE+"[����] : "+ChatColor.YELLOW + JobNick+ChatColor.LIGHT_PURPLE+"�� �±� �ʿ� ������ �Է� �ϼ���!");

				Main.UserData.get(player).setType("Job");
				Main.UserData.get(player).setString((byte)1, "JNL");
				Main.UserData.get(player).setString((byte)2, JobName);
				Main.UserData.get(player).setString((byte)3, JobNick);
				
			}
			else if(event.isShiftClick()==false&&event.isRightClick()==true)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				AddedSkillsListGUI(player, 0, JobName, JobNick);
			}
			else if(event.isShiftClick()==true&&event.isRightClick()==true)
			{
				if(event.getSlot() == 0)
				{
					s.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
					player.sendMessage(ChatColor.RED + "[����] : �⺻ Ŭ������ ������ �� �����ϴ�!");
					return;
				}
				else
				{
					s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
					SkillList.removeKey("MapleStory."+JobName+"."+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
					SkillList.saveConfig();
					MapleStory_JobSetting(player, JobName);
					GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
					J.AllPlayerFixAllSkillAndJobYML();
				}
			}
			return;
		}
	}

	public void AddedSkillsListGUIClick(InventoryClickEvent event)
	{

		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		
		String JobName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));
		String JobNick = ChatColor.stripColor(event.getInventory().getItem(45).getItemMeta().getLore().get(1));

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			MapleStory_JobSetting(player, JobName);
			return;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AddedSkillsListGUI(player, page-1, JobName, JobNick);
			return;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			AddedSkillsListGUI(player, page+1, JobName, JobNick);
			return;
		default :
			if(event.isShiftClick()==true&&event.isRightClick()==true)
			{
				YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
				YamlManager JobList  = GUI_YC.getNewConfig("Skill/JobList.yml");
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				JobList.removeKey("MapleStory."+JobName+"."+JobNick+".Skill."+ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
				JobList.saveConfig();
				AddedSkillsListGUI(player, page, JobName, JobNick);
				GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
				J.AllPlayerFixAllSkillAndJobYML();
			}
			return;
		}
	}
	
	public void Mabinogi_ChooseCategoryClick(InventoryClickEvent event)
	{
		String CategoriName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			ChooseSystemGUI(player);
			break;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			break;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Mabinogi_ChooseCategory(player,page-1);
			break;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Mabinogi_ChooseCategory(player,page+1);
			break;
		case 49://�� ī�װ�
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.LIGHT_PURPLE+"[ī�װ�] : �� ī�װ��� �̸��� ������ �ּ���!");
			Main.UserData.get(player).setType("Job");
			Main.UserData.get(player).setString((byte)1, "CC");
			break;
		default :
			if(event.isLeftClick()==true)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				if(event.isShiftClick() == false)
				{
					GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI OGUI = new GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI();
					OGUI.AllSkillsGUI(player, 0, true, ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
				}
				else
				{
					Mabinogi_SkillSetting(player, 0, CategoriName);
				}
			}
			else if(event.isShiftClick()==true&&event.isRightClick()==true)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
				YamlManager SkillList  = Config_YC.getNewConfig("Skill/JobList.yml");
				Object[] AddedSkillList = SkillList.getConfigurationSection("Mabinogi.Added").getKeys(false).toArray();
				for(int count = 0; count <AddedSkillList.length;count++)
				{
					if(SkillList.getString("Mabinogi.Added."+AddedSkillList[count]).equals(CategoriName))
						SkillList.removeKey("Mabinogi.Added."+AddedSkillList[count]);
				}
				SkillList.removeKey("Mabinogi."+CategoriName);
				SkillList.saveConfig();
				Mabinogi_ChooseCategory(player,page);
				GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
				J.AllPlayerFixAllSkillAndJobYML();
			}
			return;
		}
	}
	
	public void Mabinogi_SkillSettingClick(InventoryClickEvent event)
	{
		String SkillName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		String CategoriName = ChatColor.stripColor(event.getInventory().getItem(53).getItemMeta().getLore().get(1));

		int page =  Integer.parseInt(event.getInventory().getTitle().split(" : ")[1])-1;
		
		switch (event.getSlot())
		{
		case 45://���� ���
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Mabinogi_ChooseCategory(player,0);
			break;
		case 53://������
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			break;
		case 48://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Mabinogi_SkillSetting(player,page,CategoriName);
			break;
		case 50://���� ������
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			Mabinogi_SkillSetting(player,page,CategoriName);
			break;
		default :
			YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
			YamlManager SkillList  = Config_YC.getNewConfig("Skill/JobList.yml");
			if(event.isLeftClick()==true)
			{
				s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				if(SkillList.getBoolean("Mabinogi."+CategoriName+"."+SkillName) == true)
				{
					SkillList.set("Mabinogi."+CategoriName+"."+SkillName, false);
					SkillList.saveConfig();
					Mabinogi_SkillSetting(player,page,CategoriName);
				}
				else
				{
					SkillList.set("Mabinogi."+CategoriName+"."+SkillName, true);
					SkillList.saveConfig();
					Mabinogi_SkillSetting(player,page,CategoriName);
					GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
					J.AllPlayerFixAllSkillAndJobYML();
				}
			}
			else if(event.isShiftClick()==true&&event.isRightClick()==true)
			{
				s.SP(player, Sound.LAVA_POP, 0.8F, 1.0F);
				SkillList.removeKey("Mabinogi.Added."+SkillName);
				SkillList.removeKey("Mabinogi."+CategoriName+"."+SkillName);
				SkillList.saveConfig();
				Mabinogi_SkillSetting(player, page, CategoriName);
				GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
				J.AllPlayerFixAllSkillAndJobYML();
			}
			return;
		}
	}
	
}