package GBD.GoldBigDragon_Advanced.Config;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;
import net.md_5.bungee.api.ChatColor;

public class NewBieConfig
{
    public void CreateNewConfig()
	{
		YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
    	YamlManager YM = Event_YC.getNewConfig("ETC/NewBie.yml");
	  	YM.set("TelePort.World", Bukkit.getWorlds().get(0).getSpawnLocation().getWorld().getName().toString());
	  	YM.set("TelePort.X", Bukkit.getWorlds().get(0).getSpawnLocation().getX());
	  	YM.set("TelePort.Y", Bukkit.getWorlds().get(0).getSpawnLocation().getY());
	  	YM.set("TelePort.Z", Bukkit.getWorlds().get(0).getSpawnLocation().getZ());
	  	YM.set("TelePort.Pitch", Bukkit.getWorlds().get(0).getSpawnLocation().getPitch());
	  	YM.set("TelePort.Yaw", Bukkit.getWorlds().get(0).getSpawnLocation().getYaw());

		ItemStack Icon = new MaterialData(340, (byte) 0).toItemStack(1);
		ItemMeta Icon_Meta = Icon.getItemMeta();
		Icon_Meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"[���� ���̵�]");
		Icon_Meta.setLore(Arrays.asList(ChatColor.BLUE+""+ChatColor.BOLD+"[�Ϲ� ����]",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/����",
				ChatColor.WHITE+" �ڽ��� ������ Ȯ���մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/��ų",
				ChatColor.WHITE+" �ڽ��� ��ų�� Ȯ���մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/�ɼ�",
				ChatColor.WHITE+" ���� �ɼ��� �����մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/����Ʈ",
				ChatColor.WHITE+" ���� �������� ����Ʈ�� Ȯ���մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/��",
				ChatColor.WHITE+" ���� �������� ���� Ȯ���մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/��Ÿ",
				ChatColor.WHITE+" ��Ÿ �ý����� Ȯ���մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/��Ƽ",
				ChatColor.WHITE+" ��Ƽ�� ���� ����� �����մϴ�."
				));
		Icon.setItemMeta(Icon_Meta);
	  	YM.set("SupportItem.0", Icon);

	  	Icon = new MaterialData(340, (byte) 0).toItemStack(1);
	  	Icon_Meta = Icon.getItemMeta();
	  	Icon_Meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"[���� ���̵�]");
	  	Icon_Meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"[���۷�����]",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/���ǹڽ�",
				ChatColor.WHITE+" ���� ���� ����â�� ���ϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/����",
				ChatColor.WHITE+" ������ �����մϴ�.",
				ChatColor.YELLOW+""+ChatColor.BOLD+"/��ƼƼ���� [1~10000]",
				ChatColor.WHITE+" �ڽ��� �������� �ش� ���� ����",
				ChatColor.WHITE+" ��� ��ƼƼ�� �����մϴ�."
				));
	  	Icon.setItemMeta(Icon_Meta);
	  	YM.set("SupportItem.1", Icon);
	  	
	  	YM.set("SupportMoney", 1000);
	  	YM.set("FirstQuest", "null");

	  	GBD.GoldBigDragon_Advanced.Main.ServerOption SO = new GBD.GoldBigDragon_Advanced.Main.ServerOption();
	  	
	  	Icon = new MaterialData(340, (byte) 0).toItemStack(1);
	  	Icon_Meta = Icon.getItemMeta();
	  	Icon_Meta.setDisplayName(ChatColor.YELLOW +""+ ChatColor.BOLD + "���� �ý���");
	  	Icon_Meta.setLore(Arrays.asList(ChatColor.GRAY+ "�÷����ο��� 5���� ������ �ֽ��ϴ�.",ChatColor.RED +"["+SO.STR+"]",ChatColor.GRAY+""+SO.STR+"�� �÷��̾���",ChatColor.GRAY+"������ �������� �����մϴ�.",ChatColor.GREEN +  "["+SO.DEX+"]",ChatColor.GRAY+""+SO.DEX+"�� �÷��̾��� �뷱�� ��",ChatColor.GRAY+"���� �������� ���� ǰ��,",ChatColor.GRAY+"���Ÿ� �������� �����մϴ�.",ChatColor.BLUE+"["+SO.INT+"]",ChatColor.GRAY+""+SO.INT+"�� ������� �� ������ȣ,",ChatColor.GRAY+"���� ���ݷ¿� �����մϴ�.",ChatColor.WHITE+"["+SO.WILL+"]",ChatColor.GRAY + ""+SO.WILL+"�� �÷��̾���",ChatColor.GRAY + "ũ��Ƽ�ÿ� �����մϴ�.",ChatColor.YELLOW + "["+SO.LUK+"]",ChatColor.GRAY + ""+SO.LUK+"�� ũ��Ƽ�� ��",ChatColor.GRAY +"��Ű �ǴϽ�, ��Ű ���ʽ� ��",ChatColor.GRAY +"���� 'Ȯ��'�� �����մϴ�."));
	  	Icon.setItemMeta(Icon_Meta);
	  	YM.set("Guide.0", Icon);

		Icon = new MaterialData(340, (byte) 0).toItemStack(1);
		Icon_Meta = Icon.getItemMeta();
		Icon_Meta.setDisplayName(ChatColor.YELLOW +""+ ChatColor.BOLD + "����Ű �ý���");
		Icon_Meta.setLore(Arrays.asList(ChatColor.WHITE+ "/��ų"+ChatColor.GRAY+" ��ɾ ���Ͽ�",ChatColor.GRAY+"���� �ڽ��� �˰� �ִ� ��ų��",ChatColor.GRAY+"������ �� ������, Ŭ���� ����",ChatColor.GRAY+"�ش� ��ų�� �ֹٿ� ��� ��Ŵ���� ��",ChatColor.GRAY+"����Ű�� ���� ���� ��ų �����",ChatColor.GRAY+"�����մϴ�.",ChatColor.GRAY+"���� ���� ���� Ư�� �����۵���",ChatColor.GRAY+"����Ű�� ���� ������ �����",ChatColor.GRAY+"�����ϰ� �Ǿ� �ֽ��ϴ�."));
		Icon.setItemMeta(Icon_Meta);
	  	YM.set("Guide.1", Icon);
	  	YM.saveConfig();
	  	return;
	}
}
