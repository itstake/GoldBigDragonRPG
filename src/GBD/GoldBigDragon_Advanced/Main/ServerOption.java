package GBD.GoldBigDragon_Advanced.Main;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;

=======
>>>>>>> origin/GoldBigDragonRPG_Advanced
import org.bukkit.ChatColor;

import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class ServerOption
{
	public static String STR = "ü��";
	public static String DEX = "�ؾ�";
	public static String INT = "����";
	public static String WILL = "����";
	public static String LUK = "���";
	public static String Money = ChatColor.YELLOW+""+ChatColor.BOLD+"Gold";

<<<<<<< HEAD
	public static String STR_Lore = "%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+"�� �÷��̾���%enter%"+ChatColor.GRAY + " ������ ���ݷ���%enter%"+ChatColor.GRAY + " ��½��� �ݴϴ�.%enter%";
	public static String DEX_Lore = "%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+"�� �÷��̾���%enter%"+ChatColor.GRAY + " ���Ÿ� ���ݷ���%enter%"+ChatColor.GRAY + " ��½��� �ݴϴ�.%enter%";
	public static String INT_Lore = "%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+"�� �÷��̾%enter%"+ChatColor.GRAY + " ����ϴ� ��ų ��%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" ������ �޴�%enter%"+ChatColor.GRAY+" ��ų ���ݷ���%enter%"+ChatColor.GRAY + " ��½��� �ݴϴ�.%enter%";
	public static String WILL_Lore = "%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+"�� �÷��̾���%enter%"+ChatColor.GRAY + " ũ��Ƽ�� �� ��ų ��%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" ������ �޴�%enter%"+ChatColor.GRAY + " ��ų ���ݷ���%enter%"+ChatColor.GRAY+" ��½��� �ݴϴ�.%enter%";
	public static String LUK_Lore = "%enter%"+ChatColor.GRAY+" "+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+"�� �÷��̾��%enter%"+ChatColor.GRAY+" ������ ���� ���� �Ͼ%enter%"+ChatColor.GRAY + " Ȯ���� ������ŵ�ϴ�.%enter%";
	
=======
>>>>>>> origin/GoldBigDragonRPG_Advanced
	public void Initialize()
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
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
<<<<<<< HEAD
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
=======
>>>>>>> origin/GoldBigDragonRPG_Advanced
		return;
	}
}
