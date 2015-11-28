package GBD.GoldBigDragon_Advanced.Event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClick
{
	public void InventoryClickRouter(InventoryClickEvent event, String InventoryName)
	{
		if(event.getClickedInventory() == null)
			return;
		if(event.getClickedInventory().getTitle().equalsIgnoreCase("container.inventory") == true)
			return;
		if (event.getCurrentItem() == null||event.getCurrentItem().getType() == Material.AIR||event.getCurrentItem().getAmount() == 0)
		{return;}
		
		if(InventoryName.equals("����"))
		{
		    if(event.getClickedInventory().getType() != InventoryType.CHEST)
		    {
		    	event.setCancelled(true);
		    	return;
		    }
		    GBD.GoldBigDragon_Advanced.GUI.StatsGUI SGUI = new GBD.GoldBigDragon_Advanced.GUI.StatsGUI();
			SGUI.StatusInventoryclick(event); 
			return;
		}
		else if(InventoryName.equals("���� ��� ����"))
		{
	    	GBD.GoldBigDragon_Advanced.ETC.Monster MC = new GBD.GoldBigDragon_Advanced.ETC.Monster();
			MC.ArmorGUIClick(event);return;
	    }
		else if(InventoryName.equals("��� ����"))
	    {
		    GBD.GoldBigDragon_Advanced.GUI.EquipGUI EqGUI = new GBD.GoldBigDragon_Advanced.GUI.EquipGUI();
			EqGUI.optionInventoryclick(event);return;
	    }
		else if(InventoryName.equals("�ɼ�"))
	    {
		    GBD.GoldBigDragon_Advanced.GUI.OptionGUI OGUI = new GBD.GoldBigDragon_Advanced.GUI.OptionGUI();
			OGUI.optionInventoryclick(event);return;
	    }
		else if(InventoryName.equals("�ش� ����� ĳ�� ���� ������"))
	    {
		    GBD.GoldBigDragon_Advanced.GUI.AreaGUI AGUI = new GBD.GoldBigDragon_Advanced.GUI.AreaGUI();
		    AGUI.AreaBlockItemSettingGUIClick(event);return;
	    }

	    GBD.GoldBigDragon_Advanced.GUI.ETCGUI EGUI = new GBD.GoldBigDragon_Advanced.GUI.ETCGUI();
	    GBD.GoldBigDragon_Advanced.GUI.QuestGUI QGUI = new GBD.GoldBigDragon_Advanced.GUI.QuestGUI();
	    GBD.GoldBigDragon_Advanced.GUI.JobGUI JGUI = new GBD.GoldBigDragon_Advanced.GUI.JobGUI();
	    GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI SKGUI = new GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI();
	    GBD.GoldBigDragon_Advanced.GUI.PlayerSkillGUI PSKGUI = new GBD.GoldBigDragon_Advanced.GUI.PlayerSkillGUI();
		switch(InventoryName)
		{
			case "������ ���":
				PSKGUI.AddQuickBarGUIClick(event);
			break;
			case "�ý��� ����":
				JGUI.ChooseSystemGUIClick(event);
			break;
			case "��� ��� �Ͻðڽ��ϱ�?":
				QGUI.KeepGoingClick(event);
				break;
			case "���� ���":
			case "ä�� �ؾ� �� ��� ���":
			case "��� �ؾ� �� ���� ���":
				QGUI.ShowItemGUIInventoryClick(event); return;
			case "��Ÿ" : 
				EGUI.ETCInventoryclick(event);return;
			case "���̵�" : 
				EGUI.ETCInventoryclick(event); return;
			case "������Ʈ �߰�":
				QGUI.ObjectAddInventoryClick(event);return;
			default :
				if(InventoryName.contains("NPC"))
				{IC_NPC(event, InventoryName);return;}
				else if(InventoryName.contains("��Ƽ"))
				{IC_Party(event, InventoryName); return;}
				else if(InventoryName.contains("������"))
				{IC_Item(event, InventoryName);return;}
				else if(InventoryName.contains("����Ʈ"))
				{IC_Quest(event, InventoryName);return;}
				else if(InventoryName.contains("��ϵ�"))
				{JGUI.AddedSkillsListGUIClick(event);return;}
				else if(InventoryName.contains("[MapleStory]"))
				{IC_MapleStory(event, InventoryName);return;}
				else if(InventoryName.contains("[Mabinogi]"))
				{IC_Mabinogi(event, InventoryName);return;}
				else if(InventoryName.contains("��ų"))
				{IC_Skill(event, InventoryName);return;}
				else if(InventoryName.contains("��ũ"))
				{SKGUI.SkillRankOptionGUIClick(event);return;}
				else if(InventoryName.contains("������"))
				{PSKGUI.MapleStory_MainSkillsListGUIClick(event);return;}
				else if(InventoryName.contains("ī�װ�"))
				{PSKGUI.Mabinogi_MainSkillsListGUIClick(event);return;}
				else if(InventoryName.contains("������"))
				{IC_OP(event, InventoryName);return;}
				else if(InventoryName.contains("�̺�Ʈ"))
				{IC_Event(event, InventoryName);return;}
				else if(InventoryName.contains("����"))
				{IC_Area(event, InventoryName);return;}
				else if(InventoryName.contains("������"))
				{IC_Upgrade(event, InventoryName);return;}
				else if(InventoryName.contains("�ʽ���"))
				{IC_NewBie(event, InventoryName);return;}
				else if(InventoryName.contains("����"))
				{IC_Monster(event, InventoryName);return;}
				else if(InventoryName.contains("����"))
				{IC_World(event, InventoryName);return;}
				else if(InventoryName.contains("����"))
				{IC_Warp(event, InventoryName);return;}
				else if(InventoryName.contains("��������"))
				{new OtherPlugins.SpellMain().ShowAllMaigcGUIClick(event);return;}
				else if(InventoryName.contains("ģ��"))
				{IC_Friend(event, InventoryName);return;}
				else if(InventoryName.contains("�׺�"))
				{IC_Navi(event, InventoryName);return;}
				return;
		}
		return;
	}
	
	private void IC_NPC(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.NPC_GUI NPGUI = new GBD.GoldBigDragon_Advanced.GUI.NPC_GUI();
    	if(InventoryName.equals("NPC ���� ����"))
    		NPGUI.NPCJobClick(event, ChatColor.stripColor(event.getInventory().getItem(18).getItemMeta().getLore().get(1)));
    	else if(InventoryName.contains("NPC"))
	    {
        	if(InventoryName.contains("[NPC]"))
    	    {
    			if(event.getInventory().getSize() <= 9)
    				NPGUI.NPCclickMain(event, InventoryName.split("C] ")[1]);
    			else if(event.getInventory().getSize() <= 27)
    				NPGUI.NPCclickMain(event, InventoryName.split("C] ")[1]);
    			else if(event.getInventory().getSize() <= 54)
    				NPGUI.NPCclickMain(event,InventoryName.split("C] ")[1]);	
    	    }
        	else if(InventoryName.contains("����"))
			{
    			if(InventoryName.contains("����"))
    				NPGUI.WarpMainGUIClick(event);
    			else if(InventoryName.contains("���"))
    				NPGUI.WarperGUIClick(event);
			}
        	else if(InventoryName.contains("����"))
        	{
    			if(InventoryName.contains("����"))
    				NPGUI.UpgraderGUIClick(event);
    			else
    				NPGUI.SelectUpgradeRecipeGUIClick(event);
    				
        	}
        	else if(InventoryName.contains("����ĥ"))
				NPGUI.AddAbleSkillsGUIClick(event);
        	else if(InventoryName.contains("��"))
				NPGUI.RuneEquipGUIClick(event);
        	else if(InventoryName.contains("���"))
        	{
        		if(InventoryName.contains("����"))
            		NPGUI.TalkSettingGUIClick(event);
        		else
        			NPGUI.TalkGUIClick(event);
        	}
	    }
		return;
	}

	private void IC_Quest(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.NPC_GUI NPGUI = new GBD.GoldBigDragon_Advanced.GUI.NPC_GUI();
	    GBD.GoldBigDragon_Advanced.GUI.QuestGUI QGUI = new GBD.GoldBigDragon_Advanced.GUI.QuestGUI();

		if(InventoryName.equals("����Ʈ �ɼ�"))
			QGUI.QuestOptionClick(event);
		else if(InventoryName.equals("[����Ʈ]"))
			QGUI.QuestScriptTypeGUIClick(event);
		else if(InventoryName.contains("����"))
			NPGUI.QuestAcceptclickMain(event);
		else if(InventoryName.contains("��ü"))
			QGUI.OPboxAllQuestListInventoryclick(event);
		else if(InventoryName.contains("���"))
			NPGUI.NPCQuestclickMain(event);
		else if(InventoryName.contains("�帧��"))
			QGUI.FixQuestListInventoryclick(event);
		else if(InventoryName.contains("�׺�"))
			QGUI.Quest_NavigationListGUIClick(event);
		else if(InventoryName.contains("����"))
		{
			if(InventoryName.contains("Ȯ��"))
				QGUI.Quest_OPChoiceClick(event);
			else
				QGUI.Quest_UserChoiceClick(event);
		}
		else
			QGUI.MyQuestListInventoryclick(event);
		return;
	}

	private void IC_MapleStory(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.JobGUI JGUI = new GBD.GoldBigDragon_Advanced.GUI.JobGUI();

		if(InventoryName.contains("��ü"))
			JGUI.MapleStory_ChooseJobClick(event);
		else if(InventoryName.contains("����"))
			JGUI.MapleStory_JobSettingClick(event);
		return;
	}

	private void IC_Mabinogi(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.JobGUI JGUI = new GBD.GoldBigDragon_Advanced.GUI.JobGUI();

		if(InventoryName.contains("��ü"))
			JGUI.Mabinogi_ChooseCategoryClick(event);
		else if(InventoryName.contains("����"))
			JGUI.MapleStory_JobSettingClick(event);
		else if(InventoryName.contains("����"))
			JGUI.Mabinogi_SkillSettingClick(event);
		return;
	}

	private void IC_Skill(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI SKGUI = new GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI();
	    GBD.GoldBigDragon_Advanced.GUI.PlayerSkillGUI PSKGUI = new GBD.GoldBigDragon_Advanced.GUI.PlayerSkillGUI();

		if(InventoryName.contains("��ü"))
			SKGUI.AllSkillsGUIClick(event);
		else if(InventoryName.contains("����"))
			SKGUI.IndividualSkillOptionGUIClick(event);
		else if(InventoryName.contains("����"))
			PSKGUI.SkillListGUIClick(event);
	    else if(InventoryName.contains("����"))
	    {
	    	GBD.GoldBigDragon_Advanced.GUI.UseableItemGUI UIGUI = new GBD.GoldBigDragon_Advanced.GUI.UseableItemGUI();
	    	UIGUI.SelectSkillGUIClick(event);
	    }
		return;
	}

	private void IC_OP(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.OPBoxGUI OPGUI = new GBD.GoldBigDragon_Advanced.GUI.OPBoxGUI();

	    if(InventoryName.contains("���̵�"))
	    	OPGUI.OPBoxGuideInventoryclick(event);
	    else if(InventoryName.contains("����"))
	    	OPGUI.OPBoxGUIInventoryclick(event);
	    else if(InventoryName.contains("�ɼ�"))
	    	OPGUI.OPBoxGUI_SettingInventoryClick(event);
	    else if(InventoryName.contains("��������"))
	    	OPGUI.OPBoxGUI_BroadCastClick(event);
	    else if(InventoryName.contains("����"))
	    	OPGUI.OPBoxGUI_StatChangeClick(event);
	    return;
	}

	private void IC_Party(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.PartyGUI PGUI = new GBD.GoldBigDragon_Advanced.GUI.PartyGUI();

	    if(InventoryName.equals("��Ƽ"))
	    	PGUI.partyInventoryclick(event);
		else if(InventoryName.contains("���"))
			PGUI.PartyListInventoryclick(event);
		else if(InventoryName.contains("���")||InventoryName.contains("��ü"))
			PGUI.PartyMemberInformationClick(event);
		return;
	}
	
	private void IC_Item(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.QuestGUI QGUI = new GBD.GoldBigDragon_Advanced.GUI.QuestGUI();
	    GBD.GoldBigDragon_Advanced.GUI.ItemGUI IGUI = new GBD.GoldBigDragon_Advanced.GUI.ItemGUI();

	    if(InventoryName.contains("�Ҹ�")==true)
	    {
	    	GBD.GoldBigDragon_Advanced.GUI.UseableItemGUI UIGUI = new GBD.GoldBigDragon_Advanced.GUI.UseableItemGUI();
			if(InventoryName.contains("���"))
		    	UIGUI.UseableItemListGUIClick(event);
			else if(InventoryName.contains("Ÿ��"))
		    	UIGUI.ChooseUseableItemTypeGUIClick(event);
			else if(InventoryName.contains("��"))
		    	UIGUI.NewUseableItemGUIclick(event);
	    }
	    else
	    {
		    if(InventoryName.equals("��ƾ� �� ������ ���")||InventoryName.equals("������ ������ ���"))
		    {
				if(event.getSlot() == 8)
					event.getWhoClicked().closeInventory();
		    }
		    else  if(InventoryName.equals("���� ������ ���"))
				QGUI.SettingPresentClick(event);
		    else  if(InventoryName.contains("��"))
				IGUI.NewItemGUIclick(event);
		    else  if(InventoryName.equals("��ƾ� �� ������ ���"))
				QGUI.ShowItemGUIInventoryClick(event);
			else if(InventoryName.contains("���"))
				IGUI.ItemListInventoryclick(event);
	    }
		return;
	}

	private void IC_Area(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.AreaGUI AGUI = new GBD.GoldBigDragon_Advanced.GUI.AreaGUI();
	    if(InventoryName.contains("����"))
			AGUI.AreaGUIInventoryclick(event);
	    else if(InventoryName.contains("��ü"))
	    	AGUI.AreaListGUIClick(event);
	    else if(InventoryName.contains("����"))
	    {
		    if(InventoryName.contains("��ü"))
		    	AGUI.AreaMonsterSettingGUIClick(event);
		    else if(InventoryName.contains("����"))
		    	AGUI.AreaAddMonsterListGUIClick(event);
		    else if(InventoryName.contains("����"))
		    	AGUI.AreaAddMonsterSpawnRuleGUIClick(event);
		    else if(InventoryName.contains("Ư��"))
		    	AGUI.AreaSpawnSpecialMonsterListGUIClick(event);
	    }
	    else if(InventoryName.contains("Ư��ǰ"))
	    	AGUI.AreaBlockSettingGUIClick(event);
	    else if(InventoryName.contains("���"))
	    	AGUI.AreaFishSettingGUIClick(event);
	    else if(InventoryName.contains("�����"))
	    	AGUI.AreaMusicSettingGUIClick(event);
		return;
	}

	private void IC_Upgrade(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.UpGradeGUI UGUI = new GBD.GoldBigDragon_Advanced.GUI.UpGradeGUI();
	    if(InventoryName.contains("���"))
	    	UGUI.UpgradeRecipeGUIClick(event);
	    else if(InventoryName.contains("����"))
	    	UGUI.UpgradeRecipeSettingGUIClick(event);
		return;
	}	
	
	private void IC_NewBie(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.NewBieGUI NGUI = new GBD.GoldBigDragon_Advanced.GUI.NewBieGUI();
	    if(InventoryName.contains("�ɼ�"))
	    	NGUI.NewBieGUIMainInventoryclick(event);
	    else if(InventoryName.contains("����")||InventoryName.contains("���̵�"))
	    	NGUI.NewBieSupportItemGUIInventoryclick(event);
	    else if(InventoryName.contains("�⺻��"))
	    	NGUI.NewBieQuestGUIInventoryclick(event);
		return;
	}
	
	private void IC_Monster(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.MonsterGUI MGUI = new GBD.GoldBigDragon_Advanced.GUI.MonsterGUI();
	    if(InventoryName.contains("���"))
	    	MGUI.MonsterListGUIClick(event);
	    else if(InventoryName.contains("����"))
	    	MGUI.MonsterOptionSettingGUIClick(event);
	    else if(InventoryName.contains("����"))
	    	MGUI.MonsterPotionGUIClick(event);
		return;
	}	
	
	private void IC_World(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.WorldCreateGUI WGUI = new GBD.GoldBigDragon_Advanced.GUI.WorldCreateGUI();
	    if(InventoryName.contains("����"))
	    	WGUI.WorldCreateGUIClick(event);
		return;
	}	

	private void IC_Warp(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.WarpGUI WGUI = new GBD.GoldBigDragon_Advanced.GUI.WarpGUI();
	    if(InventoryName.contains("���"))
	    	WGUI.WarpListGUIInventoryclick(event);
		return;
	}
	
	private void IC_Event(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.EventGUI EGUI = new GBD.GoldBigDragon_Advanced.GUI.EventGUI();
	    if(InventoryName.contains("����"))
	    	EGUI.AllPlayerGiveEventGUIclick(event);
		else if(InventoryName.contains("����"))
			EGUI.EventGUIInventoryclick(event);
		return;
	}		

	private void IC_Friend(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.ETCGUI EGUI = new GBD.GoldBigDragon_Advanced.GUI.ETCGUI();
	    if(InventoryName.contains("���"))
	    	EGUI.FriendsGUIclick(event);
	    if(InventoryName.contains("��û"))
	    	EGUI.WaittingFriendsGUIclick(event);
		return;
	}

	private void IC_Navi(InventoryClickEvent event, String InventoryName)
	{
	    GBD.GoldBigDragon_Advanced.GUI.NavigationGUI NGUI = new GBD.GoldBigDragon_Advanced.GUI.NavigationGUI();
	    if(InventoryName.contains("���"))
	    	NGUI.NavigationListGUIClick(event);
	    else if(InventoryName.contains("����"))
	    	NGUI.NavigationOptionGUIClick(event);
	    else if(InventoryName.contains("���"))
	    	NGUI.UseNavigationGUIClick(event);
		return;
	}
}