package GBD.GoldBigDragon_Advanced.Event;

import java.text.DecimalFormat;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import GBD.GoldBigDragon_Advanced.Util.Number;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class Damage
{
	//�÷��̾��� �����ּ� ���ݷ��� �� ���� �޼ҵ�//
	public int CombatMinDamageGet(Entity entity, int DefaultDamage, int STR)
	{
		if(entity.getType() == EntityType.PLAYER)
		{
			Player player = (Player) entity;
			if(player.getItemInHand().hasItemMeta() == true)
			{
				if(player.getItemInHand().getItemMeta().hasLore() == true)
				if(player.getItemInHand().getItemMeta().getLore().toString().contains("����� : ") == true)
				{
					switch(player.getItemInHand().getType())
					{
					case WOOD_SPADE :
					case GOLD_SPADE :
						DefaultDamage = DefaultDamage -1;
						break;
					case WOOD_PICKAXE :
					case GOLD_PICKAXE:
					case STONE_SPADE:
						DefaultDamage = DefaultDamage -2;
						break;
					case WOOD_AXE:
					case GOLD_AXE:
					case STONE_PICKAXE:
					case IRON_SPADE:
						DefaultDamage = DefaultDamage -3;
						break;
					case WOOD_SWORD:
					case GOLD_SWORD:
					case STONE_AXE:
					case IRON_PICKAXE:
					case DIAMOND_SPADE:
						DefaultDamage = DefaultDamage -4;
						break;
					case STONE_SWORD:
					case IRON_AXE:
					case DIAMOND_PICKAXE:
						DefaultDamage = DefaultDamage -5;
						break;
					case IRON_SWORD:
					case DIAMOND_AXE:
						DefaultDamage = DefaultDamage -6;
						break;
					case DIAMOND_SWORD:
						DefaultDamage = DefaultDamage -7;
						break;
					}
				}
			}
			STR = STR + getPlayerEquipmentStat((Player)entity, "STR")[0];
			DefaultDamage = DefaultDamage + getPlayerEquipmentStat((Player)entity, "Damage")[0];
		}

		int dam=((STR/5) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}

	public int CombatMinDamageGet(int DefaultDamage, int STR)
	{
		int dam=((STR/5) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	//�÷��̾��� �����ִ� ���ݷ��� �� ���� �޼ҵ�//
	public int CombatMaxDamageGet(Entity entity, int DefaultDamage, int STR)
	{
		if(entity.getType() == EntityType.PLAYER)
		{
			Player player = (Player) entity;
			if(player.getItemInHand().hasItemMeta() == true)
			{
				if(player.getItemInHand().getItemMeta().hasLore() == true)
				if(player.getItemInHand().getItemMeta().getLore().toString().contains("����� : ") == true)
				{
					switch(player.getItemInHand().getType())
					{
					case WOOD_SPADE :
					case GOLD_SPADE :
						DefaultDamage = DefaultDamage -1;
						break;
					case WOOD_PICKAXE :
					case GOLD_PICKAXE:
					case STONE_SPADE:
						DefaultDamage = DefaultDamage -2;
						break;
					case WOOD_AXE:
					case GOLD_AXE:
					case STONE_PICKAXE:
					case IRON_SPADE:
						DefaultDamage = DefaultDamage -3;
						break;
					case WOOD_SWORD:
					case GOLD_SWORD:
					case STONE_AXE:
					case IRON_PICKAXE:
					case DIAMOND_SPADE:
						DefaultDamage = DefaultDamage -4;
						break;
					case STONE_SWORD:
					case IRON_AXE:
					case DIAMOND_PICKAXE:
						DefaultDamage = DefaultDamage -5;
						break;
					case IRON_SWORD:
					case DIAMOND_AXE:
						DefaultDamage = DefaultDamage -6;
						break;
					case DIAMOND_SWORD:
						DefaultDamage = DefaultDamage -7;
						break;
					}
				}
			}
			STR =  STR + getPlayerEquipmentStat((Player)entity, "STR")[0];
			DefaultDamage = DefaultDamage + getPlayerEquipmentStat((Player)entity, "Damage")[1];
		}
		int dam=((STR/3) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	public int CombatMaxDamageGet(int DefaultDamage, int STR)
	{
		int dam=((STR/3) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	
	public int ExplosionMinDamageGet(Entity entity, int DefaultDamage, int INT)
	{
		return (int)(INT/4)+DefaultDamage;
	}
	public int ExplosionMaxDamageGet(Entity entity, int DefaultDamage, int INT)
	{
		return (int)(INT/2.5)+DefaultDamage;
	}
	
	
	//�÷��̾��� ���Ÿ��ּ� ���ݷ��� �� ���� �޼ҵ�//
	public int RangeMinDamageGet(Entity entity, int DefaultDamage, int DEX)
	{
		if(entity.getType() == EntityType.PLAYER)
		{
			DEX = DEX + getPlayerEquipmentStat((Player)entity, "DEX")[0];
			DefaultDamage = DefaultDamage + getPlayerEquipmentStat((Player)entity, "Damage")[0];
		}
		int dam=((DEX/5) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	public int RangeMinDamageGet(int DefaultDamage, int DEX)
	{
		int dam=((DEX/5) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	//�÷��̾��� ���Ÿ��ִ� ���ݷ��� �� ���� �޼ҵ�//
	public int RangeMaxDamageGet(Entity entity, int DefaultDamage, int DEX)
	{
		if(entity.getType() == EntityType.PLAYER)
		{
			DEX = DEX + getPlayerEquipmentStat((Player)entity, "DEX")[0];
			DefaultDamage = DefaultDamage + getPlayerEquipmentStat((Player)entity, "Damage")[1];
		}
		int dam=((DEX/3) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	public int RangeMaxDamageGet(int DefaultDamage, int DEX)
	{
		int dam=((DEX/3) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	//�÷��̾��� ���� ���ݷ��� �� ���� �޼ҵ�//
	public int MagicDamageGet(int DefaultDamage, int INT)
	{
		int dam=((INT/21) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	public int MagicMaxDamageGet(int DefaultDamage, int INT)
	{
		int dam=((INT/21) + DefaultDamage);
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
	//�������� ����� ���ʽ�
	public int MagicSpellsDamageBonus(int Stat)
	{
		int dam=Stat/25;
		if(dam <= 0)
			return 0;
		else
			return dam;
	}
    //�÷��̾��� �뷱���� ���ϰ�, �����ϰ� �������� ���� �� �ִ� �޼ҵ�//
	public int damagerand(Entity entity, int min, int max, int balance)
	{
		Number num = new Number();
		if(min > max)
		{
			int temp = max;
			max = min;
			min = temp;
		}
		if (num.RandomNum(1, 100) >= balance)
		{
			return num.RandomNum(num.RandomNum(num.RandomNum(min, max), max), max);
		}
		else
		{
			return num.RandomNum(min, max);
		}
	}
	public int damagerand(Player player, int min, int max, int player_dex,int player_balance)
	{
		Number num = new Number();
		if(min > max)
		{
			int temp = max;
			max = min;
			min = temp;
		}
		int balance = getBalance(player, player_dex,player_balance);
		if (num.RandomNum(1, 100) >= balance)
		{
			return num.RandomNum(num.RandomNum(num.RandomNum(min, max), max), max);
		}
		else
		{
			return num.RandomNum(min, max);
		}
	}
	//�÷��̾��� ũ��Ƽ�� Ȯ���� ����ϰ�, ũ��Ƽ�� ���θ� �����ϴ� �޼ҵ�//
	public int criticalrend(Entity entity, int attacker_luk, int attacker_will, int attacker_damage, int defenser_protect)
	{
		Number num = new Number();
		 int critical;
		if((int)defenser_protect/2 <= 1) 
			critical= getCritical(entity, attacker_luk, attacker_will);
		else
			critical= (int)(getCritical(entity, attacker_luk, attacker_will)/100)*(100-(defenser_protect/2));
	  if (critical > 90) critical = 90;
	  if (critical < 2) critical = 2;
	  int getcritical = (int) num.RandomNum(0, 100);
		if (getcritical <= critical)
		{
		return (int)(attacker_damage*1.5);
		}
		else
		{
		return 0;
		}
	}
	public int criticalrend(int attacker_luk, int attacker_will, int attacker_damage, int defenser_protect, int attacker_critical)
	{
		Number num = new Number();
		 int critical;
		if((int)defenser_protect/2 <= 1) 
			critical= getCritical(attacker_luk, attacker_will,attacker_critical);
		else
			critical= (int)(getCritical(attacker_luk, attacker_will,attacker_critical)/100)*(100-(defenser_protect/2));
	  if (critical > 90) critical = 90;
	  if (critical < 2) critical = 2;
	  int getcritical = (int) num.RandomNum(0, 100);
		if (getcritical <= critical)
			return (int)(attacker_damage*1.5);
		else
		return 0;
	}
	//�뷱�� ����//
	public int getBalance(Entity entity,int player_dex)
	{
		int balance = 0;
		if(entity.getType() == EntityType.PLAYER)
		{
			player_dex = player_dex + getPlayerEquipmentStat((Player)entity, "DEX")[0];
			balance = balance + getPlayerEquipmentStat((Player)entity, "Balance")[0];
		}
		 balance = balance + (int)player_dex/10;
		if (balance > 80) balance = 80;
		if (balance < 0) balance = 0;
		return balance;
	}
	public int getBalance(Player player, int player_dex, int player_balance)
	{
		int balance = player_balance;
		player_dex = player_dex + getPlayerEquipmentStat(player, "DEX")[0];
		balance = balance + getPlayerEquipmentStat(player, "Balance")[0];
		balance = balance + (int)player_dex/10;
		if (balance > 80) balance = 80;
		if (balance < 0) balance = 0;
		return balance;
	}
	//ũ��Ƽ���� ����//
	public int getCritical(Entity entity, int player_luk, int player_will)
	{
		int critical = 0;
		if(entity.getType() == EntityType.PLAYER)
		{
			player_luk = player_luk + getPlayerEquipmentStat((Player)entity, "LUK")[0];
			player_will = player_will + getPlayerEquipmentStat((Player)entity, "WILL")[0];
			critical = critical + getPlayerEquipmentStat((Player)entity, "Critical")[0];
		}
		critical = critical + (int)(player_luk/5 + player_will/10);
		return critical;
	}
	public int getCritical(int player_luk, int player_will)
	{
		return (int)(player_luk/5 + player_will/10);
	}
	public int getCritical(int player_luk, int player_will, int playerCritical)
	{
		return (int)(player_luk/5 + player_will/10)+playerCritical;
	}
	//���� ����//
	public int getMagicDEF(Entity entity, int player_int)
	{
		int Magic_DEF = 0;
		if(entity.getType() == EntityType.PLAYER)
		{
			player_int = player_int + getPlayerEquipmentStat((Player)entity, "INT")[0];
			Magic_DEF = Magic_DEF + getPlayerEquipmentStat((Player)entity, "Magic_DEF")[0];
		}
		Magic_DEF = Magic_DEF + (int)(player_int/20);
		return Magic_DEF;
	}
	//���� ����//
	public int getMagicProtect(Entity entity, int player_int)
	{
		int Magic_Protect = 0;
		if(entity.getType() == EntityType.PLAYER)
		{
			player_int = player_int + getPlayerEquipmentStat((Player)entity, "INT")[0];
			Magic_Protect = Magic_Protect + getPlayerEquipmentStat((Player)entity, "Magic_Protect")[0];
		}
		Magic_Protect = Magic_Protect + (int)(player_int/100);
		return Magic_Protect;
	}
	//��� ���� ����//
	public int getDEFcrash(Entity entity, int player_dex)
	{
		int DEFcrash = 0;
		if(entity.getType() == EntityType.PLAYER)
		{
			player_dex = player_dex + getPlayerEquipmentStat((Player)entity, "DEX")[0];
			DEFcrash = DEFcrash + getPlayerEquipmentStat((Player)entity, "DEFcrash")[0];
		}
		DEFcrash = DEFcrash + (int)(player_dex/40);
		return DEFcrash;
	}
	//���� ���� ����//
	public int getMagicDEFcrash(Entity entity, int player_int)
	{
		int MagicDEFcrash = 0;
		if(entity.getType() == EntityType.PLAYER)
		{
			player_int = player_int + getPlayerEquipmentStat((Player)entity, "INT")[0];
			MagicDEFcrash = MagicDEFcrash + getPlayerEquipmentStat((Player)entity, "MagicDEFcrash")[0];
		}
		MagicDEFcrash = MagicDEFcrash + (int)(player_int/40);
		return MagicDEFcrash;
	}

	public int[] getPlayerEquipmentStat(Player player, String type)
	{
		int bonus[] = new int[2];
		String Lore[];
		switch(type)
		{
			case "Damage":type = "�����";break;
			case "DEF":type = "���";break;
			case "DEFcrash":type = "������";break;
			case "Protect":type = "��ȣ";break;
			case "MagicDamage":type = "���� �����";break;
			case "Magic_DEF":type = "���� ���";break;
			case "MagicDEFcrash":type = "���� ������";break;
			case "Magic_Protect":type = "���� ��ȣ";break;
			case "STR":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.STR;break;
			case "DEX":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX;break;
			case "INT":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.INT;break;
			case "WILL":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL;break;
			case "LUK":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK;break;
			case "HP":type = "�����";break;
			case "MP":type = "����";break;
			case "Critical":type = "ũ��Ƽ��";break;
			case "Balance":type = "�뷱��";break;
			case "Upgrade":type = "���׷��̵�";break;
			default : break;
		}
		ItemStack item[] = player.getInventory().getArmorContents();
		for(int counter = 0; counter < item.length; counter++)
		{
			boolean ExitDurability = true;
			if(item[counter] != null)
			{
				if(item[counter].hasItemMeta() == true)
				{
					if(item[counter].getItemMeta().hasLore() == true)
					{
						if(item[counter].getItemMeta().getLore().toString().contains(type) == true)
						{
							if(!(item[counter].getItemMeta().getLore().toString().contains("[�ֹ���]")||item[counter].getItemMeta().getLore().toString().contains("[��]")||item[counter].getItemMeta().getLore().toString().contains("[�Һ�]")))
							{
								for(int count = 0; count < item[counter].getItemMeta().getLore().size(); count++)
								{
									String nowlore=ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count));
									if(nowlore.contains(" : "))
									{
										if(nowlore.contains("������") == true)
										{
											String[] Lore2 = nowlore.split(" : ");
											String[] SubLore = Lore2[1].split(" / ");
											if(Integer.parseInt(SubLore[0]) <= 0)
											{
												ExitDurability = false;
												break;
											}
										}
									}
								}
								for(int count = 0; count < item[counter].getItemMeta().getLore().size(); count++)
								{
									if(item[counter].getItemMeta().getLore().get(count).contains(type) == true)
									{
										if(item[counter].getItemMeta().getLore().get(count).contains(" : "))
										{
											if(ExitDurability == true)
											{
												Lore = ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count)).split(" : ");
												if(type.equalsIgnoreCase("�����")||type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
												{
													if(type.equals("�����")&&ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count)).contains("����")==false)
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
													else if(type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
												}
												else
												{
													bonus[0] = bonus[0] + Integer.parseInt(Lore[1]);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		item[0] = player.getItemInHand();
		boolean ExitDurability = true;
		if(item[0] !=null)
		{
			if(item[0].hasItemMeta() == true)
			{
				if(item[0].getItemMeta().hasLore() == true)
				{
					if(item[0].getItemMeta().getLore().toString().contains(type) == true)
					{
						if(!(item[0].getItemMeta().getLore().toString().contains("[�ֹ���]")||item[0].getItemMeta().getLore().toString().contains("[��]")||item[0].getItemMeta().getLore().toString().contains("[�Һ�]")))
						{
							for(int count = 0; count < item[0].getItemMeta().getLore().size(); count++)
							{
								String nowlore=ChatColor.stripColor(item[0].getItemMeta().getLore().get(count));
								if(nowlore.contains(" : "))
								{
									if(item[0].getItemMeta().getLore().get(count).contains("������") == true)
									{
										String[] Lore2 = nowlore.split(" : ");
										String[] SubLore = Lore2[1].split(" / ");
										if(Integer.parseInt(SubLore[0]) <= 0)
										{
											ExitDurability = false;
											break;
										}
									}
								}
							}
							for(int count = 0; count < item[0].getItemMeta().getLore().size(); count++)
							{
								if(item[0].getItemMeta().getLore().get(count).contains(type) == true)
								{
									if(item[0].getItemMeta().getLore().get(count).contains(" : "))
									{
										if(ExitDurability == true)
										{
											if(item[0].getItemMeta().getLore().get(count).contains(":") == true||item[0].getItemMeta().getLore().get(count).contains("/") == true)
											{
												Lore = ChatColor.stripColor(item[0].getItemMeta().getLore().get(count)).split(" : ");
												if(type.equalsIgnoreCase("�����")||type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
												{
													if(type.equals("�����")&&ChatColor.stripColor(item[0].getItemMeta().getLore().get(count)).contains("����")==false)
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
													else if(type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
													return bonus;
												}
												else
												{
													bonus[0] = bonus[0] + Integer.parseInt(Lore[1]);
													return bonus;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return bonus;
	}


	public int[] getSlotChangedPlayerEquipmentStat(Player player, String type,ItemStack newSlot)
	{
		int bonus[] = new int[2];
		String Lore[];
		switch(type)
		{
			case "Damage":type = "�����";break;
			case "DEF":type = "���";break;
			case "DEFcrash":type = "������";break;
			case "Protect":type = "��ȣ";break;
			case "MagicDamage":type = "���� �����";break;
			case "Magic_DEF":type = "���� ���";break;
			case "MagicDEFcrash":type = "���� ������";break;
			case "Magic_Protect":type = "���� ��ȣ";break;
			case "STR":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.STR;break;
			case "DEX":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.DEX;break;
			case "INT":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.INT;break;
			case "WILL":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.WILL;break;
			case "LUK":type = GBD.GoldBigDragon_Advanced.Main.ServerOption.LUK;break;
			case "HP":type = "�����";break;
			case "MP":type = "����";break;
			case "Critical":type = "ũ��Ƽ��";break;
			case "Balance":type = "�뷱��";break;
			case "Upgrade":type = "���׷��̵�";break;
			default : break;
		}
		ItemStack item[] = player.getInventory().getArmorContents();
		for(int counter = 0; counter < item.length; counter++)
		{
			boolean ExitDurability = true;
			if(item[counter] != null)
			{
				if(item[counter].hasItemMeta() == true)
				{
					if(item[counter].getItemMeta().hasLore() == true)
					{
						if(item[counter].getItemMeta().getLore().toString().contains(type) == true)
						{
							if(!(item[counter].getItemMeta().getLore().toString().contains("[�ֹ���]")||item[counter].getItemMeta().getLore().toString().contains("[��]")||item[counter].getItemMeta().getLore().toString().contains("[�Һ�]")))
							{
								for(int count = 0; count < item[counter].getItemMeta().getLore().size(); count++)
								{
									String nowlore=ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count));
									if(nowlore.contains(" : "))
									{
										if(nowlore.contains("������") == true)
										{
											String[] Lore2 = nowlore.split(" : ");
											String[] SubLore = Lore2[1].split(" / ");
											if(Integer.parseInt(SubLore[0]) <= 0)
											{
												ExitDurability = false;
												break;
											}
										}
									}
								}
								for(int count = 0; count < item[counter].getItemMeta().getLore().size(); count++)
								{
									if(item[counter].getItemMeta().getLore().get(count).contains(type) == true)
									{
										if(item[counter].getItemMeta().getLore().get(count).contains(" : "))
										{
											if(ExitDurability == true)
											{
												Lore = ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count)).split(" : ");
												if(Lore[0].contains(type))
												if(type.equalsIgnoreCase("�����")||type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
												{
													if(type.equals("�����")&&ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count)).contains("����")==false)
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
													else if(type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
												}
												else
												{
													bonus[0] = bonus[0] + Integer.parseInt(Lore[1]);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		item[0] = newSlot;
		boolean ExitDurability = true;
		if(item[0] !=null)
		{
			if(item[0].hasItemMeta() == true)
			{
				if(item[0].getItemMeta().hasLore() == true)
				{
					if(item[0].getItemMeta().getLore().toString().contains(type) == true)
					{
						if(!(item[0].getItemMeta().getLore().toString().contains("[�ֹ���]")||item[0].getItemMeta().getLore().toString().contains("[��]")||item[0].getItemMeta().getLore().toString().contains("[�Һ�]")))
						{
							for(int count = 0; count < item[0].getItemMeta().getLore().size(); count++)
							{
								String nowlore=ChatColor.stripColor(item[0].getItemMeta().getLore().get(count));
								if(nowlore.contains(" : "))
								{
									if(item[0].getItemMeta().getLore().get(count).contains("������") == true)
									{
										String[] Lore2 = nowlore.split(" : ");
										String[] SubLore = Lore2[1].split(" / ");
										if(Integer.parseInt(SubLore[0]) <= 0)
										{
											ExitDurability = false;
											break;
										}
									}
								}
							}
							for(int count = 0; count < item[0].getItemMeta().getLore().size(); count++)
							{
								if(item[0].getItemMeta().getLore().get(count).contains(type) == true)
								{
									if(item[0].getItemMeta().getLore().get(count).contains(" : "))
									{
										if(ExitDurability == true)
										{
											if(item[0].getItemMeta().getLore().get(count).contains(":") == true||item[0].getItemMeta().getLore().get(count).contains("/") == true)
											{
												Lore = ChatColor.stripColor(item[0].getItemMeta().getLore().get(count)).split(" : ");
												if(type.equalsIgnoreCase("�����")||type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
												{
													if(type.equals("�����")&&ChatColor.stripColor(item[0].getItemMeta().getLore().get(count)).contains("����")==false)
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
													else if(type.equalsIgnoreCase("���� �����")||type.equalsIgnoreCase("���׷��̵�"))
													{
														String[] SubLore = Lore[1].split(" ~ ");
														bonus[0] = bonus[0] + Integer.parseInt(SubLore[0]);
														bonus[1] = bonus[1] + Integer.parseInt(SubLore[1]);
													}
													return bonus;
												}
												else
												{
													bonus[0] = bonus[0] + Integer.parseInt(Lore[1]);
													return bonus;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return bonus;
	}
	
	public int getPlayerEquipmentDurability(Player player, String part)
	{
		int durability = -1;
		String Lore[];
		ItemStack item = null;
		switch(part)
		{
			case "�Ӹ�":item = player.getInventory().getHelmet();break;
			case "����":item = player.getInventory().getChestplate();break;
			case "�ٸ�":item = player.getInventory().getLeggings();break;
			case "����":item = player.getInventory().getBoots();break;
			case "��":item = player.getItemInHand();break;
			default : break;
		}
		if(item.hasItemMeta() == true)
		{
			if(item.getItemMeta().hasLore() == true)
			{
				if(!(item.getItemMeta().getLore().toString().contains("[�ֹ���]")||item.getItemMeta().getLore().toString().contains("[��]")||item.getItemMeta().getLore().toString().contains("[�Һ�]")))
				{
					for(int count = 0; count < item.getItemMeta().getLore().size(); count++)
					{
						String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(count));
						if(nowlore.contains(" : ")&&nowlore.contains(" / "))
						{
							if(item.getItemMeta().getLore().get(count).contains("������") == true)
							{
								Lore = nowlore.split(" : ");
								durability = Integer.parseInt(Lore[0].split(" / ")[0]);
							}
						}
					}
				}
			}
		}
		return durability;
	}

	public void decreaseDurabilityArmor(Player player)
	{
		boolean DurabilityExit = false;
		ItemStack item[] = player.getInventory().getArmorContents();
		for(int counter = 0; counter < item.length; counter++)
		{
			if(item[counter].hasItemMeta() == true)
			{
				if(item[counter].getItemMeta().hasLore() == true)
				{
					if(item[counter].getItemMeta().getLore().toString().contains("������"))
					{
						if(!(item[counter].getItemMeta().getLore().toString().contains("[�ֹ���]")||item[counter].getItemMeta().getLore().toString().contains("[��]")||item[counter].getItemMeta().getLore().toString().contains("[�Һ�]")))
						{
							for(int count = 0; count < item[counter].getItemMeta().getLore().size(); count++)
							{
								String nowlore=ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count));
								if(nowlore.contains(" : "))
								{
									ItemMeta Meta = item[counter].getItemMeta();
									if(nowlore.contains(" / "))
									{
										if(Meta.getLore().get(count).contains("������") == true)
										{
											item[counter].setDurability((short) (item[counter].getDurability()-1));
											String[] Lore = ChatColor.stripColor(Meta.getLore().get(count)).split(" : ");
											String[] SubLore = Lore[1].split(" / ");
											List<String> PLore = Meta.getLore();
											if((Integer.parseInt(SubLore[0])-1) <= 0)
											{
												YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
												YamlManager Config =GUI_YC.getNewConfig("config.yml");
												if(Config.getBoolean("Server.CustomWeaponBreak"))
												{
													new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(player, Sound.ITEM_BREAK, 1.2F, 1.0F);
													if(item[counter].getItemMeta().hasDisplayName())
														player.sendMessage(ChatColor.RED+"[��� �ı�] : "+ ChatColor.YELLOW+item[counter].getItemMeta().getDisplayName()+ChatColor.RED+ " ��� �ı��Ǿ����ϴ�!");
													else
														player.sendMessage(ChatColor.RED+"[��� �ı�] : ��� �ı��Ǿ����ϴ�!");
													item[counter] = new ItemStack(0);
													player.getInventory().setArmorContents(item);
													break;
												}
												else
													PLore.set(count,ChatColor.WHITE +  Lore[0] + " : "+ 0 +" / "+SubLore[1]);
											}
											else
											{
												PLore.set(count,ChatColor.WHITE +  Lore[0] + " : "+(Integer.parseInt(SubLore[0])-1) +" / "+SubLore[1]);
												DurabilityExit = true;
											}
											Meta.setLore(PLore);
											item[counter].setItemMeta(Meta);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(DurabilityExit == true)
		{
			for(int counter = 0; counter < item.length; counter++)
			{
				if(item[counter].hasItemMeta() == true)
				{
					if(item[counter].getItemMeta().hasLore() == true)
					{
						if(item[counter].getItemMeta().getLore().toString().contains("���õ�"))
						{
							for(int count = 0; count < item[counter].getItemMeta().getLore().size(); count++)
							{
								String nowlore=ChatColor.stripColor(item[counter].getItemMeta().getLore().get(count));
								if(nowlore.contains(" : "))
								{
									ItemMeta Meta = item[counter].getItemMeta();
									if(Meta.getLore().get(count).contains("���õ�") == true)
									{
										String[] Lore = ChatColor.stripColor(Meta.getLore().get(count)).split(" : ");
										String[] SubLore = Lore[1].split("%");
										List<String> PLore = Meta.getLore();
										DecimalFormat format = new DecimalFormat(".##");
										String str = format.format((Float.parseFloat(SubLore[0])+0.07F));
										if(str.charAt(0)=='.')
											str = "0"+str;
										if((Float.parseFloat(SubLore[0])+0.07F) >= 100.0F)
											PLore.set(count,ChatColor.WHITE +  Lore[0] + " : "+ 100.0 +"%"+ChatColor.WHITE);
										else
											PLore.set(count,ChatColor.WHITE +  Lore[0] + " : "+ str +"%"+ChatColor.WHITE);
										Meta.setLore(PLore);
										item[counter].setItemMeta(Meta);
									}
								}
							}
						}
					}
				}
			}
		}
		return;
	}
	
	public void decreaseDurabilityWeapon(Player player)
	{
		boolean DurabilityExit = false;
		ItemStack item = player.getInventory().getItemInHand();
		if(item.hasItemMeta() == true)
		{
			if(item.getItemMeta().hasLore() == true)
			{
				if(item.getItemMeta().getLore().toString().contains("������"))
				{
					if(!(item.getItemMeta().getLore().toString().contains("[�ֹ���]")||item.getItemMeta().getLore().toString().contains("[��]")||item.getItemMeta().getLore().toString().contains("[�Һ�]")))
					{
						for(int count = 0; count < item.getItemMeta().getLore().size(); count++)
						{
							String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(count));
							if(nowlore.contains(" : ")&&nowlore.contains(" / "))
							{
								ItemMeta Meta = item.getItemMeta();
								if(Meta.getLore().get(count).contains("������") == true)
								{
									item.setDurability((short) (item.getDurability()-1));
									String[] Lore = ChatColor.stripColor(Meta.getLore().get(count)).split(" : ");
									String[] SubLore = Lore[1].split(" / ");
									List<String> PLore = Meta.getLore();
									if((Integer.parseInt(SubLore[0])-1) <= 0)
									{
										

										YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
										YamlManager Config =GUI_YC.getNewConfig("config.yml");
										if(Config.getBoolean("Server.CustomWeaponBreak"))
										{
											new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(player, Sound.ITEM_BREAK, 1.2F, 1.0F);
											if(item.getItemMeta().hasDisplayName())
												player.sendMessage(ChatColor.RED+"[��� �ı�] : "+ ChatColor.YELLOW+item.getItemMeta().getDisplayName()+ChatColor.RED+ " ��� �ı��Ǿ����ϴ�!");
											else
												player.sendMessage(ChatColor.RED+"[��� �ı�] : ��� �ı��Ǿ����ϴ�!");
											player.setItemInHand(new ItemStack(0));
											break;
										}
										else
											PLore.set(count, ChatColor.WHITE + Lore[0] + " : "+ 0 +" / "+SubLore[1]);
									}
									else
									{
										PLore.set(count, ChatColor.WHITE + Lore[0] + " : "+(Integer.parseInt(SubLore[0])-1) +" / "+SubLore[1]);
										DurabilityExit = true;
									}
									Meta.setLore(PLore);
									item.setItemMeta(Meta);
								}
							}
						}
					}
				}
			}
		}
		if(DurabilityExit == true)
		{
			if(item.hasItemMeta() == true)
			{
				if(item.getItemMeta().hasLore() == true)
				{
					if(item.getItemMeta().getLore().toString().contains("���õ�"))
					{
						for(int count = 0; count < item.getItemMeta().getLore().size(); count++)
						{
							String nowlore=ChatColor.stripColor(item.getItemMeta().getLore().get(count));
							if(nowlore.contains(" : "))
							{
								ItemMeta Meta = item.getItemMeta();
								if(Meta.getLore().get(count).contains("���õ�") == true)
								{
									String[] Lore = ChatColor.stripColor(Meta.getLore().get(count)).split(" : ");
									String[] SubLore = Lore[1].split("%");
									List<String> PLore = Meta.getLore();
									DecimalFormat format = new DecimalFormat(".##");
									String str = format.format((Float.parseFloat(SubLore[0])+0.07F));
									if(str.charAt(0)=='.')
										str = "0"+str;
									if((Float.parseFloat(SubLore[0])+0.07F) >= 100.0F)
										PLore.set(count,ChatColor.WHITE +  Lore[0] + " : "+ 100.0 +"%"+ChatColor.WHITE);
									else
										PLore.set(count,ChatColor.WHITE +  Lore[0] + " : "+ str +"%"+ChatColor.WHITE);
									Meta.setLore(PLore);
									item.setItemMeta(Meta);
								}
							}
						}
					}
				}
			}
		}
		return;
	}
}
