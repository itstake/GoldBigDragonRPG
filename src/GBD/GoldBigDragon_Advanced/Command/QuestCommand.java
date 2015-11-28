package GBD.GoldBigDragon_Advanced.Command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class QuestCommand extends HelpMessage
{
	public void onCommand(CommandSender talker, Command command, String string, String[] args)
	{
	    GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		Player player = (Player) talker;
		if(talker.isOp() == true)
		{
			if(args.length==0)
			{
				s.SP(player, Sound.HORSE_ARMOR, 1.0F, 0.8F);
				new GBD.GoldBigDragon_Advanced.GUI.QuestGUI().MyQuestListGUI(player, 0);
				return;
			}
			
			if(player.isOp() == true)
			{
			    YamlManager QuestConfig;
				YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
				QuestConfig=Config_YC.getNewConfig("Quest/QuestList.yml");
		    	if(Config_YC.isExit("Quest/QuestList.yml")==false)
		    	{
		    		QuestConfig.set("Do_not_Touch_This", true);
		    		QuestConfig.saveConfig();
		    	}

			    
				switch(ChatColor.stripColor(args[0]))
				{
		  			case "����" :
		  			{
		  					s.SP(player, Sound.HORSE_ARMOR, 1.0F, 0.8F);
		  					new GBD.GoldBigDragon_Advanced.GUI.QuestGUI().AllOfQuestListGUI(player, 0,false);
		  			}
		  			break;
			  		case "����" :
				  		{
				  			if(args.length <= 2)
				  			{
								HelpMessager((Player)talker,8);
							  	return;
				  			}
				  			if(args[1].equalsIgnoreCase("�Ϲ�")||args[1].equalsIgnoreCase("�ݺ�")||args[1].equalsIgnoreCase("����")
				  			||args[1].equalsIgnoreCase("����")||args[1].equalsIgnoreCase("�Ѵ�"))
				  			{
				  				Object[] questList = QuestConfig.getConfigurationSection("").getKeys(false).toArray();
							  	StringBuffer QN = new StringBuffer();
							    for(int i =2; i<args.length-1;i++)
						    	{
							    	QN.append(args[i]+" ");
						    	}
							    QN.append(args[args.length-1]);
							    String QuestName = QN.toString().replace(".", "");
							    String QuestNameString = ChatColor.stripColor(QuestName);
								for(int count = 0; count < questList.length;count++)
							    {
									if(questList[count].toString().equalsIgnoreCase(QuestNameString) == true)
							    	{
									  	s.SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
								    	player.sendMessage(ChatColor.RED+"[SYSTEM] : �ش� �̸��� ����Ʈ�� �̹� �����մϴ�!");
									    return;
							    	}
							    }
								String QuestType = null;
								switch(args[1])
								{
									case "�Ϲ�" : QuestType = "N"; break;
									case "�ݺ�" : QuestType = "R"; break;
									case "����" : QuestType = "D"; break;
									case "����" : QuestType = "W"; break;
									case "�Ѵ�" : QuestType = "M"; break;
								}
								QuestConfig.set(QuestNameString + ".QuestMaker", player.getName());
								QuestConfig.set(QuestNameString + ".Type", QuestType);
								QuestConfig.set(QuestNameString + ".Server.Limit", 0);
								QuestConfig.set(QuestNameString + ".Need.LV", 0);
								QuestConfig.set(QuestNameString + ".Need.Love", 0);
								QuestConfig.set(QuestNameString + ".Need.Skill.0", null);
								QuestConfig.set(QuestNameString + ".Need.STR", 0);
								QuestConfig.set(QuestNameString + ".Need.DEX", 0);
								QuestConfig.set(QuestNameString + ".Need.INT", 0);
								QuestConfig.set(QuestNameString + ".Need.WILL", 0);
								QuestConfig.set(QuestNameString + ".Need.LUK", 0);
								QuestConfig.set(QuestNameString + ".Need.PrevQuest", "null");
								QuestConfig.set(QuestNameString + ".FlowChart.0", null);
								QuestConfig.saveConfig();
							    player.sendMessage(ChatColor.GREEN+"[SYSTEM] : "+ChatColor.YELLOW+QuestNameString+ChatColor.DARK_AQUA+" ����Ʈ�� �����Ǿ����ϴ�!");
			  					s.SP(player, Sound.HORSE_ARMOR, 1.0F, 0.8F);
			  					new GBD.GoldBigDragon_Advanced.GUI.QuestGUI().FixQuestGUI(player, 0, QuestNameString);
				  			}
				  			else
							HelpMessager((Player)talker,8);
				  		}
				  		return;
				    default:
						{
							HelpMessager((Player)talker,8);
						}
				  		return;
				}
			}
			else
			{
				talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
				s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
	  			return;
			}
		}
	}
}