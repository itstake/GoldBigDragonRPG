package GBD.GoldBigDragon_Advanced.Command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class HelpMessage
{
	public void HelpMessager(Player player, int what)
	{
		switch(what)
		{
			case 1:
			{
				player.sendMessage(ChatColor.YELLOW+"������������������������[������ ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/������ ����" + ChatColor.YELLOW + " - �տ� ����ִ� �������� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ �̸� <���ڿ�>" + ChatColor.YELLOW + " - �ش� �������� ������ �̸��� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ ID <����>" + ChatColor.YELLOW + " - �ش� �������� ID���� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ DATA <����>" + ChatColor.YELLOW + " - �ش� �������� DATA���� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ ���� <����>" + ChatColor.YELLOW + " - �ش� �������� ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ �±׻���" + ChatColor.YELLOW + " - [1.8.0�� �ȵ�] ���̾Ƹ�� ���� +7 �������ؿ� ���� ������ �±׸� �����մϴ�.");
				//player.sendMessage(ChatColor.GOLD + "/������ ���� [ȿ��] [����]" + ChatColor.YELLOW + " - �����ۿ� ���� ȿ���� ���մϴ�.");
				//player.sendMessage(ChatColor.GOLD + "/������ ��æƮ [��æƮ] [����]" + ChatColor.YELLOW + " - �����ۿ� ��æƮ ȿ���� ���մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ �����߰� <���ڿ�>" + ChatColor.YELLOW + " - �ش� �������� �ξ� �� ���� �߰��մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/������ ��������" + ChatColor.YELLOW + " - �ش� �������� ��� �ξ �����մϴ�.");
				player.sendMessage(ChatColor.GREEN + "[�Ʒ��� ���� ������ �߰��� ��, �����ۿ� ȿ���� ����ϴ�.]");
				player.sendMessage(ChatColor.AQUA + "/������ �����߰� ����� : 3 ~ 6" + ChatColor.RED +" (������ ������ ����� 3 ~ 6 ���)");
				player.sendMessage(ChatColor.AQUA + "/������ �����߰� ��� : 3" + ChatColor.RED +" (������ ������ ��� 3���)");
				player.sendMessage(ChatColor.GREEN + "[�߰� ������ �ɼ� �±�]");
				player.sendMessage(ChatColor.AQUA + "[����� : <����> ~ <����>] [��� : <����>] [��ȣ : <����>]\n"
						+ "[���� ����� : <����> ~ <����>] [���� ��� : <����>] [���� ��ȣ : <����>]\n"
						+ "["+GBD.GoldBigDragon_Advanced.Main.ServerOption.STR+" : <����>] ["+GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX+" : <����>] ["+GBD.GoldBigDragon_Advanced.Main.ServerOption.INT+" : <����>] ["+GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL+" : <����>] ["+GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK+" : <����>]\n"
						+ "[ũ��Ƽ�� : <����>] [�뷱�� : <����>] [������ : <����> / <����>] \n"
						+ "[���׷��̵� : <����> / <����>] [����� : <����>] [���� : <����>]\n"+ChatColor.GREEN+"[������ Ÿ�� �±�] - ������ ��ϵ� ��ų�� ���� ���� �ɼǿ� ����"+ChatColor.AQUA+"\n[�Һ�] [���� ����] [�Ѽ� ��] [��� ��] [���Ÿ� ����] [Ȱ] [����] [����] [��] [���� ����] [����] [������]");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
			case 3:
			{
				YamlController Main_YC = GBD.GoldBigDragon_Advanced.Main.Main.Main_YC;
			  	YamlManager Config = Main_YC.getNewConfig("config.yml");
				player.sendMessage(ChatColor.YELLOW+"������������������������[��Ƽ ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ ���� <�̸�>" + ChatColor.YELLOW + " - �ش� �̸��� ��Ƽ�� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ Ż��" + ChatColor.YELLOW + " - ���� ��Ƽ�� Ż���մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ ���" + ChatColor.YELLOW + " - ���� ������ ��Ƽ ����� ���ϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ ����" + ChatColor.YELLOW + " - ���� ��Ƽ ������ ���ϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ ���� <��Ƽ����>" + ChatColor.YELLOW + " - ���� ��Ƽ�� ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ ���� <�г���>" + ChatColor.YELLOW + " - �ش� �÷��̾�� ���� ������ �Ѱ��ݴϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ �ο� <2-" + Config.getInt("Party.MaxPartyUnit") + ">" + ChatColor.YELLOW + " - ���� �ο��� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/��Ƽ ���"+ChatColor.YELLOW+" - ��Ƽ ���� ��û�� �ްų� ���� �ʽ��ϴ�.");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
			case 4:
			{
				player.sendMessage(ChatColor.YELLOW+"������������������������[���� ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/����" + ChatColor.YELLOW + " - ���� ���� GUI â�� ���ϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ���" + ChatColor.YELLOW + " - ���� ������ ���� ����� ���ϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ���� <�̸�>" + ChatColor.YELLOW + " - ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ���� <�̸�>" + ChatColor.YELLOW + " - ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� �̸� <�����̸�> <�̸�>" + ChatColor.YELLOW + " - ���� �̸��� �����մϴ�.");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
			case 5:
			{
				player.sendMessage(ChatColor.YELLOW+"������������������������[�ڷ���Ʈ ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/���� ���" + ChatColor.YELLOW + " - ���� ���� ���� ����� ���ϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� <���� �̸�>" + ChatColor.YELLOW + " - �ش� �̸����� ��ϵ� �������� �̵��մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ��� <���� �̸�>" + ChatColor.YELLOW + " - ���� ��ġ�� ���� �������� ����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ���� <���� �̸�>" + ChatColor.YELLOW + " - �ش� ���� ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ���� <���� �̸�>" + ChatColor.YELLOW + " - �Ϲ� ������ �̵� ����/�Ұ��� �ϵ��� �����մϴ�.");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
			case 6:
			{
				player.sendMessage(ChatColor.YELLOW+"������������������������[���� ���� ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/���� ���" + ChatColor.YELLOW + " - ���� ����� Ȯ���մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� <���� �̸�>" + ChatColor.YELLOW + " - �ش� ���� ����â�� ���ϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� <���� �̸�> ����" + ChatColor.YELLOW + " - �ش� �̸��� ���� ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� <���� �̸�> ����" + ChatColor.YELLOW + " - �ش� �̸��� ���� ������ �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� <���� �̸�> �̸� <���ڿ�>" + ChatColor.YELLOW + " - �ش� ������ �˸� �޽����� ���� �̸��� ���մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� <���� �̸�> ���� <���ڿ�>" + ChatColor.YELLOW + " - �ش� ������ �˸� �޽����� ���� �ΰ� ������ ���մϴ�.");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
			case 7:
			{
				player.sendMessage(ChatColor.YELLOW+"������������������������[���� ���� ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/���� �Ǹ� [����]" + ChatColor.YELLOW + " - ��ó�� �ִ� NPC���� ����� �տ��� ������ �ش� ���ݿ� �Ǹ��ϵ��� �մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/���� ���� [����]" + ChatColor.YELLOW + " - ��ó�� �ִ� NPC���� ����� �տ��� ������ �ش� ���ݿ� �����ϵ��� �մϴ�.");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
			case 8:
			{
				player.sendMessage(ChatColor.YELLOW+"������������������������[����Ʈ ��ɾ�]������������������������");
				player.sendMessage(ChatColor.GOLD + "/����Ʈ" + ChatColor.YELLOW + " - ���� �ڽ��� �������� ����Ʈ ����� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/����Ʈ ����" + ChatColor.YELLOW + " - ���ο� ����Ʈ�� ����ų�, ������ ����Ʈ�� �����մϴ�.");
				player.sendMessage(ChatColor.GOLD + "/����Ʈ ���� [Ÿ��] [�̸�]" + ChatColor.YELLOW + " - ���ο� ����Ʈ�� �����ϸ�, ����â���� �ٷ� �Ѿ�ϴ�.");
				player.sendMessage(ChatColor.GREEN + "[�Ϲ� / �ݺ� / ���� / ���� / �Ѵ�]");
				player.sendMessage(ChatColor.YELLOW+"����������������������������������������������������������������");
			}
			break;
		}
	}
}
