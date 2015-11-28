package GBD.GoldBigDragon_Advanced.Event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class UseUseableItem
{
	public void UseAbleItemUse(Player player, String type)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound sound = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		ItemStack item = player.getItemInHand();
		if(type.equals("��ȯ��"))
		{
			YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
			YamlManager YM = Event_YC.getNewConfig("Stats/" + player.getUniqueId()+".yml");
			GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
			if(YM.getLong("Stat.AttackTime")+15000 >= ETC.getSec())
			{
				player.sendMessage(ChatColor.RED+"[�̵� �Ұ�] : "+ChatColor.YELLOW+((YM.getLong("Stat.AttackTime")+15000 - ETC.getSec())/1000)+ChatColor.RED+" �� �Ŀ� �̵� �����մϴ�!");
				sound.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
				return;
			}
			String world = "";
			int X = 0;
			int Y = 0;
			int Z = 0;
			for(int counter = 0; counter < item.getItemMeta().getLore().size();counter++)
			{
				String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(counter));
				if(nowlore.contains(" : "))
				{
					if(nowlore.contains("����"))
					{
						world = nowlore.split(" : ")[1];
					}
					else if(nowlore.contains("X ��ǥ"))
					{
						X = Integer.parseInt(nowlore.split(" : ")[1]);
					}
					else if(nowlore.contains("Y ��ǥ"))
					{
						Y = Integer.parseInt(nowlore.split(" : ")[1]);
					}
					else if(nowlore.contains("Z ��ǥ"))
					{
						Z = Integer.parseInt(nowlore.split(" : ")[1]);
					}
				}
			}
			if(item.getAmount() != 1)
			{
				item.setAmount(item.getAmount()-1);
				player.getInventory().setItem(player.getInventory().getHeldItemSlot(), item);
			}
			else
				player.getInventory().setItem(player.getInventory().getHeldItemSlot(), new ItemStack(0));
			player.teleport(new Location(Bukkit.getWorld(world), X, Y, Z));
		}
		else if(type.equals("�ֹ���"))
		{
			YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
			YamlManager YM = Event_YC.getNewConfig("Stats/" + player.getUniqueId()+".yml");
			
			int StatPoint = 0;
			int SkillPoint = 0;
			int DEF = 0;
			int Protect = 0;
			int MaDEF = 0;
			int MaProtect  = 0;
			int Balance = 0;
			int Critical  = 0;
			int HP  = 0;
			int MP  = 0;
			int STR  = 0;
			int DEX  = 0;
			int INT  = 0;
			int WILL  = 0;
			int LUK  = 0;
			
			for(int counter = 0; counter < item.getItemMeta().getLore().size();counter++)
			{
				String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(counter));
				if(nowlore.contains(" : "))
				{
					if(nowlore.contains("����Ʈ"))
					{
						if(nowlore.contains("����"))
							StatPoint = Integer.parseInt(nowlore.split(" : ")[1]);
						if(nowlore.contains("��ų"))
							SkillPoint = Integer.parseInt(nowlore.split(" : ")[1]);
					}
					if(nowlore.contains("���"))
						if(nowlore.contains("����"))
							MaDEF = Integer.parseInt(nowlore.split(" : ")[1]);
						else
							DEF = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains("��ȣ"))
						if(nowlore.contains("����"))
							MaProtect = Integer.parseInt(nowlore.split(" : ")[1]);
						else
							Protect = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains("�뷱��"))
						Balance = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains("ũ��Ƽ��"))
						Critical = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains("�����"))
						HP = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains("����"))
						MP = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.STR))
						STR = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX))
						DEX = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.INT))
						INT = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL))
						WILL = Integer.parseInt(nowlore.split(" : ")[1]);
					if(nowlore.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK))
						LUK = Integer.parseInt(nowlore.split(" : ")[1]);
				}
			}
			if(SkillPoint!=0)
				YM.set("Stat.SkillPoint", YM.getInt("Stat.SkillPoint")+SkillPoint);
			if(StatPoint!=0)
				YM.set("Stat.StatPoint", YM.getInt("Stat.StatPoint")+StatPoint);
			if(DEF!=0)
				YM.set("Stat.DEF", YM.getInt("Stat.DEF")+DEF);
			if(Protect!=0)
				YM.set("Stat.Protect", YM.getInt("Stat.Protect")+Protect);
			if(MaDEF!=0)
				YM.set("Stat.Magic_DEF", YM.getInt("Stat.Magic_DEF")+MaDEF);
			if(MaProtect!=0)
				YM.set("Stat.Magic_Protect", YM.getInt("Stat.Magic_Protect")+MaProtect);
			if(Balance!=0)
				YM.set("Stat.Balance", YM.getInt("Stat.Balance")+Balance);
			if(Critical!=0)
				YM.set("Stat.Critical", YM.getInt("Stat.Critical")+Critical);
			if(HP!=0)
				YM.set("Stat.MAXHP", YM.getInt("Stat.MAXHP")+HP);
			if(MP!=0)
				YM.set("Stat.MAXMP", YM.getInt("Stat.MAXMP")+MP);
			if(STR!=0)
				YM.set("Stat.STR", YM.getInt("Stat.STR")+STR);
			if(DEX!=0)
				YM.set("Stat.DEX", YM.getInt("Stat.DEX")+DEX);
			if(INT!=0)
				YM.set("Stat.INT", YM.getInt("Stat.INT")+INT);
			if(WILL!=0)
				YM.set("Stat.WILL", YM.getInt("Stat.WILL")+WILL);
			if(LUK!=0)
				YM.set("Stat.LUK", YM.getInt("Stat.LUK")+LUK);
			YM.saveConfig();
			if(item.getAmount() != 1)
			{
				item.setAmount(item.getAmount()-1);
				player.getInventory().setItem(player.getInventory().getHeldItemSlot(), item);
			}
			else
				player.getInventory().setItem(player.getInventory().getHeldItemSlot(), new ItemStack(0));
			
			if(SkillPoint>=0&&StatPoint>=0&&DEF>=0&&Protect>=0&&MaDEF>=0&&MaProtect>=0&&Balance>=0&&Critical>=0&&HP>0
			&&MP>=0&&STR>=0&&DEX>=0&&INT>=0&&WILL>=0&&LUK>0)
			{
				sound.SP(player, Sound.LEVEL_UP, 0.8F, 0.5F);
				player.sendMessage(ChatColor.GREEN+""+ChatColor.BOLD+"[      �ɷ�ġ�� ��� �Ͽ����ϴ�!      ]");
			}
			else if(SkillPoint<0&&StatPoint<0&&DEF<0&&Protect<0&&MaDEF<0&&MaProtect<0&&Balance<0&&Critical<0&&HP>0
					&&MP<0&&STR<0&&DEX<0&&INT<0&&WILL<0&&LUK>0)
			{
				sound.SP(player, Sound.ZOMBIE_METAL, 0.8F, 0.5F);
				player.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[      �ɷ�ġ�� ���� �Ͽ����ϴ�!      ]");
			}
			else
			{
				sound.SP(player, Sound.ORB_PICKUP, 0.8F, 1.5F);
				player.sendMessage(ChatColor.YELLOW+""+ChatColor.BOLD+"[      �ɷ�ġ�� ��ȭ�� ������ϴ�!      ]");
			}
		}
		else if(type.equals("��ų��"))
		{
			YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
			YamlManager Config = Event_YC.getNewConfig("config.yml");
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System")==true)
			{
				String Skillname = null;
				for(int counter = 0; counter < item.getItemMeta().getLore().size();counter++)
				{
					String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(counter));
					if(nowlore.contains("[��"))
					{
						if(nowlore.contains("Ŭ����"))
							if(nowlore.contains("�Ʒ�"))
								if(nowlore.contains("��ų"))
									if(nowlore.contains("ȹ��]"))
									{
										nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(counter+1));
										Skillname = nowlore.replace(" + ", "");
										break;
									}
					}
				}
				if(Skillname == null)
					return;
				YamlManager AllSkills = Event_YC.getNewConfig("Skill/SkillList.yml");
				if(AllSkills.contains(Skillname))
				{
					AllSkills = Event_YC.getNewConfig("Skill/JobList.yml");
					if(AllSkills.contains("Mabinogi.Added."+Skillname)==true)
					{
						YamlManager PlayerSkillList = Event_YC.getNewConfig("Skill/PlayerData/"+player.getUniqueId().toString()+".yml");
						if(PlayerSkillList.contains("Mabinogi."+AllSkills.getString("Mabinogi.Added."+Skillname)+"."+Skillname) == false)
						{
							PlayerSkillList.set("Mabinogi."+AllSkills.getString("Mabinogi.Added."+Skillname)+"."+Skillname, 1);
							PlayerSkillList.saveConfig();
							if(item.getAmount() != 1)
							{
								item.setAmount(item.getAmount()-1);
								player.getInventory().setItem(player.getInventory().getHeldItemSlot(), item);
							}
							else
								player.getInventory().setItem(player.getInventory().getHeldItemSlot(), new ItemStack(0));
							sound.SP(player, Sound.LEVEL_UP, 1.0F, 1.8F);
							player.sendMessage(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"[���ο� ��ų�� ȹ�� �Ͽ����ϴ�!] "+ChatColor.YELLOW+""+ChatColor.BOLD+""+ChatColor.UNDERLINE+Skillname);
							return;
						}
						else
						{
							sound.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
							player.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[         ����� �̹� �ش� ��ų�� �˰� �ֽ��ϴ�!         ]");
							return;
						}
					}
					else
					{
						sound.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
						player.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[�ش� ��ų�� ��� ī�װ����� �������� �ʽ��ϴ�! �����ڿ��� �����ϼ���!]");
						return;
					}
				}
				else
				{
					sound.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
					player.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[������ �ش� ��ų�� �������� �ʽ��ϴ�! �����ڿ��� �����ϼ���!]");
					return;
				}
			}
			else
			{
				sound.SP(player, Sound.ORB_PICKUP, 1.0F, 1.8F);
				player.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[   ���� �ý����� '������'�� ��츸 ��� �����մϴ�!   ]");
				return;
			}
		}
		else if(type.equals("�Һ�"))
		{
			int Health = 0;
			int Mana = 0;
			int Food = 0;
			for(int counter = 0; counter < item.getItemMeta().getLore().size();counter++)
			{
				String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(counter));
				if(nowlore.contains(" : "))
				{
					if(nowlore.contains("�����"))
					{
						Health = Integer.parseInt(nowlore.split(" : ")[1]);
					}
					else if(nowlore.contains("����"))
					{
						Mana = Integer.parseInt(nowlore.split(" : ")[1]);
					}
					else if(nowlore.contains("������"))
					{
						Food = Integer.parseInt(nowlore.split(" : ")[1]);
					}
				}
			}
			if(item.getAmount() != 1)
			{
				item.setAmount(item.getAmount()-1);
				player.getInventory().setItem(player.getInventory().getHeldItemSlot(), item);
			}
			else
				player.getInventory().setItem(player.getInventory().getHeldItemSlot(), new ItemStack(0));
			
			if(Health > 0)
			{
				sound.SL(player.getLocation(), Sound.DRINK, 2.0F, 0.8F);
				Damageable Dp = player;
				if(Dp.getMaxHealth() < Dp.getHealth()+Health)
					Dp.setHealth(Dp.getMaxHealth());
				else
					Dp.setHealth(Dp.getHealth() + Health);
			}
			if(Mana >0)
			{
				
			}
			if(Food > 0)
			{
			sound.SL(player.getLocation(), Sound.EAT, 2.0F, 1.2F);
				if(player.getFoodLevel()+Food > 20)
					player.setFoodLevel(20);
				player.setFoodLevel(player.getFoodLevel()+Food);
			}
		}
		return;
	}
}
