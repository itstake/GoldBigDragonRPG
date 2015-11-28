package GBD.GoldBigDragon_Advanced.Event;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.*;

import GBD.GoldBigDragon_Advanced.Main.*;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class Interact
{
	//�� ��Ŭ/��Ŭ �� ��//
	public void PlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction()==Action.RIGHT_CLICK_AIR||event.getAction()==Action.RIGHT_CLICK_BLOCK)
		{ItemUse(event);}
		if(event.getPlayer().isOp())
			AreaChecker(event);
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			CustomMonsterSpawnEggUse(event);
			if(event.getClickedBlock().getLocation().getWorld().getName().equals("Dungeon"))
				Dungeon(event);
		}
		if(Main.UserData.containsKey(event.getPlayer()))
		{OPwork(event);}
		return;
	}
	
	//NPC �� ����
	public void PlayerInteractEntity (PlayerInteractEntityEvent event)
	{
		Entity target = event.getRightClicked();
		Player player = event.getPlayer();

		if(target.getType() == EntityType.PLAYER)
		{
			Player t = (Player)target;
			if(t.isOnline()==true)
			{
				GBD.GoldBigDragon_Advanced.GUI.EquipGUI EGUI = new GBD.GoldBigDragon_Advanced.GUI.EquipGUI();
				EGUI.EquipWatchGUI(player, t);
			}
		}
	    if(Main.UserData.containsKey(player))
		{
		    if(Main.UserData.get(player).getType()=="Quest")
			{
		    	GBD.GoldBigDragon_Advanced.ETC.Quest Q = new GBD.GoldBigDragon_Advanced.ETC.Quest();
		    	Q.EntityInteract(event);
			}
		}
	    return;
	}
	
	private void OPwork(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		if(Main.UserData.get(player).getType()=="Quest")
			OPwork_Quest(event);
		if(Main.UserData.get(player).getType()=="Area")
			OPwork_Area(event);
		return;
	}
	
	private void ItemUse(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		//������ ���
		if(player.getItemInHand() != null)
		{
			if(player.getItemInHand().hasItemMeta() == true)
			{
				if(player.getItemInHand().getItemMeta().hasLore()==true)
				{
					if(player.getItemInHand().getTypeId() == 395
						|| player.getItemInHand().getTypeId() == 358)
					{
						Object[] lore = player.getItemInHand().getItemMeta().getLore().toArray();
							for(int counter = 0; counter < lore.length; counter ++)
								if(lore[counter].toString().contains("����") == true)
									//������ �̹��� �ִ� �۾�
									if(Main.UserData.containsKey(player))
									{
										Main.UserData.get(player).setType("Map");
										Main.UserData.get(player).setString((byte)1, ChatColor.stripColor(lore[counter].toString()).split(" : ")[1]);
										Main.Mapping = true;
										return;
									}
					}
					String LoreString = player.getItemInHand().getItemMeta().getLore().toString();
					if(LoreString.contains("��ȯ��")||LoreString.contains("�ֹ���")||LoreString.contains("��ų��")||LoreString.contains("�Һ�"))
					{
						String type = null;
						for(int counter = 0; counter < player.getItemInHand().getItemMeta().getLore().size(); counter++)
						{
							if(type != null)
							{
								event.setCancelled(true);
								UseUseableItem UU = new UseUseableItem();
								UU.UseAbleItemUse(player, type);
								return;
							}
							if(player.getItemInHand().getItemMeta().getLore().get(counter).contains("��ȯ��"))
								type = "��ȯ��";
							else if(player.getItemInHand().getItemMeta().getLore().get(counter).contains("�ֹ���"))
								type = "�ֹ���";
							else if(player.getItemInHand().getItemMeta().getLore().get(counter).contains("��ų��"))
								type = "��ų��";
							else if(player.getItemInHand().getItemMeta().getLore().get(counter).contains("�Һ�"))
								type = "�Һ�";
						}
					}
				}
			}
		}
		return;
	}
	
	private void CustomMonsterSpawnEggUse(PlayerInteractEvent event)
	{
		YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
		Player player = event.getPlayer();
		if(player.getItemInHand() != null && player.getItemInHand().hasItemMeta() == true)
		{
			if(event.getItem().getTypeId() == 383 && event.getItem().getData().getData() == 0)
			{
				YamlManager Monster  = Event_YC.getNewConfig("Monster/MonsterList.yml");

				Object[] monsterlist = Monster.getConfigurationSection("").getKeys(false).toArray();
				
				for(int count = 0; count < monsterlist.length;count++)
		    	{
		    		if(monsterlist[count].toString().equalsIgnoreCase(ChatColor.stripColor(event.getItem().getItemMeta().getDisplayName())) == true)
		    		{
		    			new GBD.GoldBigDragon_Advanced.ETC.Monster().SpawnMob(event.getClickedBlock().getLocation(), ChatColor.stripColor(event.getItem().getItemMeta().getDisplayName()));
						return;
		    		}
		    	}
				new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(player, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
		    	player.sendMessage(ChatColor.RED+"[SYSTEM] : �ش� �̸��� ���Ͱ� �������� �ʽ��ϴ�!");
		    	return;
			}
		}
		return;
	}
	
	private void Dungeon(PlayerInteractEvent event)
	{
		Block block = event.getClickedBlock();
		GBD.GoldBigDragon_Advanced.ETC.Monster MC = new GBD.GoldBigDragon_Advanced.ETC.Monster();
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		GBD.GoldBigDragon_Advanced.Effect.Particle p = new GBD.GoldBigDragon_Advanced.Effect.Particle();
		if(block.getType().getId()==146)
		{
			MC.SpawnMob(block.getLocation(), "��ٱ�");
			s.SL(block.getLocation(), org.bukkit.Sound.CHEST_OPEN, 1.0F, 0.5F);
            block.setTypeIdAndData(0, (byte)0, true);
		}
		if(block.getType().getId()==95)
		{
			if(block.getData()==15||block.getData()==14||block.getData()==13||
				block.getData()==11||block.getData()==8)
			{
				switch(block.getData())
				{
	    			case 15: block.setTypeIdAndData(95, (byte)7, true);break;
	    			case 14: block.setTypeIdAndData(95, (byte)6, true);break;
	    			case 13: block.setTypeIdAndData(95, (byte) 5, true);break;
	    			case 11: block.setTypeIdAndData(95, (byte)3, true);break;
	    			case 8: block.setTypeIdAndData(95, (byte)0, true);break;
				}
				for(int counter=0;counter<50;counter++)
					p.PL(block.getLocation(), Effect.MAGIC_CRIT, 0);
				s.SL(block.getLocation(), org.bukkit.Sound.SUCCESSFUL_HIT, 1.0F, 0.5F);
			}
			else if(block.getData()==0||block.getData()==3||block.getData()==5||block.getData()==6||block.getData()==7)
			{
				for(int counter=0;counter<31;counter++)
					p.PL(block.getLocation(), Effect.CRIT, 0);
				s.SL(block.getLocation(), org.bukkit.Sound.HURT_FLESH, 0.5F, 0.5F);
			}
		}
		return;
	}
	
	private void OPwork_Quest(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();

		event.setCancelled(true);
		if(event.getAction()==Action.LEFT_CLICK_BLOCK)
		{
			if(Main.UserData.get(player).getString((byte)1)=="TelePort")
			{
				String QuestName = Main.UserData.get(player).getString((byte)3);
		    	GBD.GoldBigDragon_Advanced.GUI.QuestGUI QGUI = new GBD.GoldBigDragon_Advanced.GUI.QuestGUI();

				YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
				YamlManager QuestConfig=Config_YC.getNewConfig("Quest/QuestList.yml");
				int	size = QuestConfig.getConfigurationSection(QuestName+".FlowChart").getKeys(false).toArray().length;
				
				QuestConfig.set(QuestName+".FlowChart."+size+".Type", "TelePort");
				QuestConfig.set(QuestName+".FlowChart."+size+".World", block.getLocation().getWorld().getName());
				QuestConfig.set(QuestName+".FlowChart."+size+".X", block.getLocation().getX());
				QuestConfig.set(QuestName+".FlowChart."+size+".Y", block.getLocation().getY());
				QuestConfig.set(QuestName+".FlowChart."+size+".Z", block.getLocation().getZ());
				QuestConfig.set(QuestName+".FlowChart."+size+".NPCname", " ");
				QuestConfig.saveConfig();
		    	QGUI.FixQuestGUI(player, 0, QuestName);
		    	Main.UserData.get(player).clearAll();
		    	new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(event.getPlayer(), org.bukkit.Sound.ITEM_PICKUP, 0.5F,1.2F);
		    	player.sendMessage(ChatColor.GREEN + "[SYSTEM] : ���������� ��ϵǾ����ϴ�!");
		    	return;
			}
		}
		if(event.getAction() ==Action.RIGHT_CLICK_BLOCK)
		{
			if(Main.UserData.get(player).getString((byte)1)!=null&&
				Main.UserData.get(player).getString((byte)3)!=null)
			{
				if(Main.UserData.get(player).getString((byte)1)=="Harvest")
				{
					Main.UserData.get(player).setInt((byte)1, block.getTypeId());
					Main.UserData.get(player).setInt((byte)2,(int)block.getData());
			    	player.sendMessage(ChatColor.GREEN + "[SYSTEM] : " + ChatColor.GREEN + "����� �����ͱ��� �Ϻ��� ���ƾ� �ϳ���? ("+ChatColor.RED + "X"+ChatColor.GREEN +" Ȥ�� "+ChatColor.DARK_AQUA +"O"+ChatColor.GREEN +")");
			    	player.closeInventory();
			    	return;
				}
				else if(Main.UserData.get(player).getString((byte)1)=="BlockPlace")
				{
					String QuestName = Main.UserData.get(player).getString((byte)2);
					YamlController Config_YC = GBD.GoldBigDragon_Advanced.Main.Main.Config_YC;
					YamlManager QuestConfig=Config_YC.getNewConfig("Quest/QuestList.yml");
					int	size = QuestConfig.getConfigurationSection(QuestName+".FlowChart").getKeys(false).toArray().length;
					
					QuestConfig.set(QuestName+".FlowChart."+size+".Type", "BlockPlace");
					QuestConfig.set(QuestName+".FlowChart."+size+".World", block.getLocation().getWorld().getName());
					QuestConfig.set(QuestName+".FlowChart."+size+".X", block.getLocation().getX());
					QuestConfig.set(QuestName+".FlowChart."+size+".Y", block.getLocation().getY());
					QuestConfig.set(QuestName+".FlowChart."+size+".Z", block.getLocation().getZ());
					QuestConfig.set(QuestName+".FlowChart."+size+".ID", 1);
					QuestConfig.set(QuestName+".FlowChart."+size+".DATA", 0);
					QuestConfig.saveConfig();
			    	Main.UserData.get(player).setString((byte)3, null);
			    	Main.UserData.get(player).setString((byte)1, "BPID");
			    	Main.UserData.get(player).setInt((byte)1, size);
			    	new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(event.getPlayer(), org.bukkit.Sound.ITEM_PICKUP, 0.5F,1.2F);
			    	player.sendMessage(ChatColor.GREEN + "[����Ʈ] : ��ġ �� ��� ID�� �Է� �� �ּ���!");
					return;
				}
			}
		}
		return;
	}
	
	private void OPwork_Area(PlayerInteractEvent event)
	{
		event.setCancelled(true);
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager AreaConfig =GUI_YC.getNewConfig("Area/AreaList.yml");
		String AreaName = Main.UserData.get(player).getString((byte)2);
		if(event.getAction()==Action.LEFT_CLICK_BLOCK)
		{
			if(Main.UserData.get(player).getString((byte)3)=="ANBI")
			{
				String BlockData = block.getTypeId()+":"+block.getData();
				ItemStack item = new MaterialData(block.getTypeId(), (byte) block.getData()).toItemStack(1);
				AreaConfig.set(AreaName+".Mining."+BlockData,item);
				AreaConfig.saveConfig();
				GBD.GoldBigDragon_Advanced.GUI.AreaGUI AGUI = new GBD.GoldBigDragon_Advanced.GUI.AreaGUI();
				new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(player, Sound.HORSE_SADDLE, 1.0F, 1.8F);
				AGUI.AreaBlockItemSettingGUI(player, AreaName, BlockData);
		    	Main.UserData.get(player).clearAll();
			}
		}
		else if(event.getAction()==Action.RIGHT_CLICK_BLOCK)
		{
			if(Main.UserData.get(player).getString((byte)3)=="MLS")//MonsterLocationSetting
			{
				String count = Main.UserData.get(player).getString((byte)1);
				AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".loc.world", block.getLocation().getWorld().getName());
				AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".loc.x", (int)block.getLocation().getX());
				AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".loc.y", (int)block.getLocation().getY()+1);
				AreaConfig.set(AreaName+".MonsterSpawnRule."+count+".loc.z", (int)block.getLocation().getZ());
				AreaConfig.saveConfig();
				new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(player, Sound.ITEM_PICKUP, 1.0F, 1.8F);
		    	Main.UserData.get(player).clearAll();
				Main.UserData.get(player).setType("Area");
				Main.UserData.get(player).setString((byte)1, count);
				Main.UserData.get(player).setString((byte)2, "AMSC");
				Main.UserData.get(player).setString((byte)3, AreaName);
				player.sendMessage(ChatColor.GREEN+"[����] : �� ���� �� ���� �� ���� �ұ��?");
				player.sendMessage(ChatColor.YELLOW+"(�ּ� 1���� ~ �ִ� 100����)");
			}
		}
		return;
	}
	
	private void AreaChecker(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
		YamlManager Config = Event_YC.getNewConfig("config.yml");
		if(player.getInventory().getItemInHand().getTypeId() == Config.getInt("Server.AreaSettingWand"))
		{
			if(event.getAction()==Action.LEFT_CLICK_BLOCK)
			{
				event.setCancelled(true);
				Main.catchedLocation1.put(player, block.getLocation());
				player.sendMessage(ChatColor.YELLOW + "[SYSTEM] : ù ��° ���� ���� �Ϸ�! (" + block.getLocation().getBlockX() + ","
						+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+")");
				return;
			}
			else if(event.getAction()==Action.RIGHT_CLICK_BLOCK)
			{
				event.setCancelled(true);
				Main.catchedLocation2.put(player, event.getClickedBlock().getLocation());
				player.sendMessage(ChatColor.YELLOW + "[SYSTEM] : �� ��° ���� ���� �Ϸ�! (" + event.getClickedBlock().getLocation().getBlockX() + ","
						+event.getClickedBlock().getLocation().getBlockY()+","+event.getClickedBlock().getLocation().getBlockZ()+")");
				return;
			}
		}
		return;
	}
	
	public void PlayerGetItem(PlayerPickupItemEvent event)
	{
		YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
	  	if(Event_YC.isExit("Stats/" + event.getPlayer().getUniqueId()+".yml") == false)
	  		new GBD.GoldBigDragon_Advanced.Config.StatConfig().CreateNewStats(event.getPlayer());
		YamlManager YM = Event_YC.getNewConfig("Stats/" + event.getPlayer().getUniqueId()+".yml");
		String ItemName = null;
		if((event.getItem().getItemStack().hasItemMeta() == true && event.getItem().getItemStack().getItemMeta().hasDisplayName()))
		{
			ItemName = event.getItem().getItemStack().getItemMeta().getDisplayName();
			if(ItemName.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.Money) == true && event.getItem().getItemStack().getEnchantmentLevel(Enchantment.LUCK) == 500)
			{
			  	if(Event_YC.isExit("Stats/" + event.getPlayer().getUniqueId()+".yml") == false)
			  		new GBD.GoldBigDragon_Advanced.Config.StatConfig().CreateNewStats(event.getPlayer());

				YM = Event_YC.getNewConfig("Stats/" + event.getPlayer().getUniqueId()+".yml");
				
				YM.set("Stat.Money", YM.getLong("Stat.Money") + Long.parseLong(ItemName.split("��f��f��f��l")[1]));
				YM.saveConfig();
				event.setCancelled(true);
				event.getItem().remove();
				new GBD.GoldBigDragon_Advanced.Effect.Sound().SP(event.getPlayer(), org.bukkit.Sound.ITEM_PICKUP, 0.5F,1.2F);
			}
		}
		else
		{
			ItemName = SetItemDefaultName(event.getItem().getItemStack().getTypeId(),event.getItem().getItemStack().getData().getData());
		}
	  	if(YM.getBoolean("Alert.ItemPickUp") == true)
		{
			if(ItemName.contains(GBD.GoldBigDragon_Advanced.Main.ServerOption.Money) == true)
				new GBD.GoldBigDragon_Advanced.Effect.PacketSender().sendActionBar(event.getPlayer(), ChatColor.GRAY+""+ChatColor.BOLD+""+""+ChatColor.BOLD+ChatColor.BOLD+""+ChatColor.BOLD+"("+""+ChatColor.BOLD+ItemName+""+ChatColor.GRAY+""+ChatColor.BOLD+")");
			else
				new GBD.GoldBigDragon_Advanced.Effect.PacketSender().sendActionBar(event.getPlayer(), ChatColor.GRAY+""+ChatColor.BOLD+""+""+ChatColor.BOLD+ChatColor.BOLD+""+ChatColor.BOLD+"("+""+ChatColor.BOLD+ItemName+""+" "+ChatColor.GRAY+""+ChatColor.BOLD+event.getItem().getItemStack().getAmount()+"��)");
		}
	  	return;
	}

	public String SetItemDefaultName(int itemCode,byte itemData)
	{
		String name = "�������� ���� ������";
		switch (itemCode)
		{
			case 1:
				switch(itemData)
				{
				case 0:
					return ChatColor.GRAY+""+ChatColor.BOLD+"��";
				case 1:
					return ChatColor.RED+""+ChatColor.BOLD+"ȭ����";
				case 2:
					return ChatColor.RED+""+ChatColor.BOLD+"�ε巯�� ȭ����";
				case 3:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���Ͼ�";
				case 4:
					return ChatColor.WHITE+""+ChatColor.BOLD+"�ε巯�� ���Ͼ�";
				case 5:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�Ȼ��";
				case 6:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�ε巯�� �Ȼ��";
				}
				break;
			case 2: return ChatColor.GREEN+""+ChatColor.BOLD+"�ܵ� ���";
			case 3:
				switch(itemData)
				{
				case 0:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��";
				case 1:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��ģ ��";
				case 2:
					return ChatColor.GOLD+""+ChatColor.BOLD+"ȸ����";
				}
				break;
			case 4: return ChatColor.GRAY+""+ChatColor.BOLD+"���൹";
			case 5:
				switch(itemData)
				{
				case 0:
					return ChatColor.GOLD+""+ChatColor.BOLD+"������ ����";
				case 1:
					return ChatColor.BLACK+""+ChatColor.BOLD+"�����񳪹� ����";
				case 2:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���۳��� ����";
				case 3:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ����";
				case 4:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þƳ��� ����";
				case 5:
					return ChatColor.BLACK+""+ChatColor.BOLD+"£�� ������ ����";
				}
				break;
			case 6:
				switch(itemData)
				{
				case 0:
					return ChatColor.GOLD+""+ChatColor.BOLD+"������ ����";
				case 1:
					return ChatColor.BLACK+""+ChatColor.BOLD+"�����񳪹� ����";
				case 2:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���۳��� ����";
				case 3:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ����";
				case 4:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þƳ��� ����";
				case 5:
					return ChatColor.BLACK+""+ChatColor.BOLD+"£�� ������ ����";
				}
				break;
			case 7: return ChatColor.BLACK+""+ChatColor.BOLD+"��ݾ�";
			case 8: return ChatColor.BLUE+""+ChatColor.BOLD+"��";
			case 9: return ChatColor.BLUE+""+ChatColor.BOLD+"�帣�� �ʴ� ��";
			case 10: return ChatColor.RED+""+ChatColor.BOLD+"���";
			case 11: return ChatColor.RED+""+ChatColor.BOLD+"�帣�� �ʴ� ���";
			case 12:
				switch(itemData)
				{
				case 0:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"��";
				case 1:
					return ChatColor.RED+""+ChatColor.BOLD+"���� ��";
				}
				break;
			case 13: return ChatColor.GRAY+""+ChatColor.BOLD+"�ڰ�";
			case 14: return ChatColor.YELLOW+""+ChatColor.BOLD+"�ݱ���";
			case 15: return ChatColor.GRAY+""+ChatColor.BOLD+"ö����";
			case 16: return ChatColor.BLACK+""+ChatColor.BOLD+"��ź ����";
			case 17:
				switch(itemData%4)
				{
				case 0:
					return ChatColor.GOLD+""+ChatColor.BOLD+"������";
				case 1:
					return ChatColor.BLACK+""+ChatColor.BOLD+"�����񳪹�";
				case 2:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���۳���";
				case 3:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
				}
				break;
			case 18:
				switch(itemData)
				{
				case 0:
					return ChatColor.GREEN+""+ChatColor.BOLD+"������ ��";
				case 1:
					return ChatColor.GREEN+""+ChatColor.BOLD+"�����񳪹� ��";
				case 2:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���۳��� ��";
				case 3:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���� ���� ��";
				}
				break;
			case 19:
				switch(itemData)
				{
				case 0:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"������";
				case 1:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"���� ������";
				}
				break;
			case 20: return ChatColor.WHITE+""+ChatColor.BOLD+"����";
			case 21: return ChatColor.BLUE+""+ChatColor.BOLD+"û�ݼ� ����";
			case 22: return ChatColor.BLUE+""+ChatColor.BOLD+"û�ݼ� ���";
			case 23: return ChatColor.GRAY+""+ChatColor.BOLD+"�߻��";
			case 24:
				switch(itemData)
				{
				case 0:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"���";
				case 1:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"������ ���";
				case 2:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"�ε巯�� ���";
				}
				break;
			case 25: return ChatColor.GOLD+""+ChatColor.BOLD+"��Ʈ ���";
			case 26: return ChatColor.RED+""+ChatColor.BOLD+"���丷 ħ��";
			case 27: return ChatColor.YELLOW+""+ChatColor.BOLD+"�Ŀ� ����";
			case 28: return ChatColor.GRAY+""+ChatColor.BOLD+"������ ����";
			case 29: return ChatColor.GREEN+""+ChatColor.BOLD+"������ �ǽ���";
			case 30: return ChatColor.WHITE+""+ChatColor.BOLD+"�Ź���";
			case 31:
				switch(itemData)
				{
				case 1:
					return ChatColor.GREEN+""+ChatColor.BOLD+"�ܵ�";
				case 2:
					return ChatColor.GREEN+""+ChatColor.BOLD+"��縮";
				}
				break;
			case 32: return ChatColor.GREEN+""+ChatColor.BOLD+"���� ����";
			case 33: return ChatColor.GOLD+""+ChatColor.BOLD+"�ǽ���";
			case 34: return ChatColor.GOLD+""+ChatColor.BOLD+"�ǽ��� �Ӹ�";
			case 35:
				switch(itemData)
				{
				case 0:
					return ChatColor.WHITE+""+ChatColor.BOLD+"�� ����";
				case 1:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ����";
				case 2:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ����";
				case 3:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�ϴû� ����";
				case 4:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"����� ����";
				case 5:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���λ� ����";
				case 6:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ����";
				case 7:
					return ChatColor.DARK_GRAY+""+ChatColor.BOLD+"ȸ�� ����";
				case 8:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ȸ�� ����";
				case 9:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"û�ϻ� ����";
				case 10:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"����� ����";
				case 11:
					return ChatColor.DARK_BLUE+""+ChatColor.BOLD+"�Ķ��� ����";
				case 12:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
				case 13:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"�ʷϻ� ����";
				case 14:
					return ChatColor.DARK_RED+""+ChatColor.BOLD+"������ ����";
				case 15:
					return ChatColor.BLACK+""+ChatColor.BOLD+"������ ����";
				}
				break;
			case 37: return ChatColor.YELLOW+""+ChatColor.BOLD+"�ε鷹";
			case 38:
				switch(itemData)
				{
				case 0:
					return ChatColor.RED+""+ChatColor.BOLD+"��ͺ�";
				case 1:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�Ķ� ����";
				case 2:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"�Ĳ�";
				case 3:
					return ChatColor.WHITE+""+ChatColor.BOLD+"Ǫ�� �����";
				case 4:
					return ChatColor.RED+""+ChatColor.BOLD+"������ ƫ��";
				case 5:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ƫ��";
				case 6:
					return ChatColor.WHITE+""+ChatColor.BOLD+"�Ͼ�� ƫ��";
				case 7:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ƫ��";
				case 8:
					return ChatColor.WHITE+""+ChatColor.BOLD+"������";
				}
				break;
			case 39: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 40: return ChatColor.RED+""+ChatColor.BOLD+"���� ����";
			case 41: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ���";
			case 42: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ���";
			case 43: return ChatColor.GRAY+""+ChatColor.BOLD+"������ �� �� ���";
			case 44:
				switch(itemData%7)
				{
				case 0:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�� �� ���";
				case 1:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"��� �� ���";
				case 2:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���൹ �� ���";
				case 3:
					return ChatColor.RED+""+ChatColor.BOLD+"���� �� ���";
				case 4:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ���� �� ���";
				case 5:
					return ChatColor.DARK_RED+""+ChatColor.BOLD+"�״� ���� �� ���";
				case 6:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���� �� ���";
				}
				break;
			case 45: return ChatColor.RED+""+ChatColor.BOLD+"����";
			case 46: return ChatColor.DARK_RED+""+ChatColor.BOLD+"TNT";
			case 47: return ChatColor.GOLD+""+ChatColor.BOLD+"å��";
			case 48: return ChatColor.GREEN+""+ChatColor.BOLD+"�̳� �� ��";
			case 49: return ChatColor.BLACK+""+ChatColor.BOLD+"��伮";
			case 50: return ChatColor.YELLOW+""+ChatColor.BOLD+"ȶ��";
			case 51: return ChatColor.RED+""+ChatColor.BOLD+"��";
			case 52: return ChatColor.GRAY+""+ChatColor.BOLD+"���� ������";
			case 53: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���";
			case 54: return ChatColor.GOLD+""+ChatColor.BOLD+"����";
			case 55: return ChatColor.RED+""+ChatColor.BOLD+"���彺��";
			case 56: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ����";
			case 57: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ���";
			case 58: return ChatColor.GOLD+""+ChatColor.BOLD+"�۾���";
			case 59: return ChatColor.GREEN+""+ChatColor.BOLD+"���۹�";
			case 60: return ChatColor.GOLD+""+ChatColor.BOLD+"�� ���";
			case 61: return ChatColor.GRAY+""+ChatColor.BOLD+"ȭ��";
			case 62: return ChatColor.YELLOW+""+ChatColor.BOLD+"��Ÿ�� ȭ��";
			case 63: return ChatColor.GOLD+""+ChatColor.BOLD+"ǥ����";
			case 64: return ChatColor.GOLD+""+ChatColor.BOLD+"��¦ ��";
			case 65: return ChatColor.GOLD+""+ChatColor.BOLD+"��ٸ�";
			case 66: return ChatColor.GRAY+""+ChatColor.BOLD+"����";
			case 67: return ChatColor.GRAY+""+ChatColor.BOLD+"���� ���";
			case 68: return ChatColor.GOLD+""+ChatColor.BOLD+"�پ��ִ� ǥ����";
			case 69: return ChatColor.GRAY+""+ChatColor.BOLD+"����";
			case 70: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ������";
			case 71: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ��¦ ��";
			case 72: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ������";
			case 73: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� ����";
			case 74: return ChatColor.RED+""+ChatColor.BOLD+"������ ���彺�� ����";
			case 75: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ���� ���彺�� ȶ��";
			case 76: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� ȶ��";
			case 77: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ��ư";
			case 78: return ChatColor.WHITE+""+ChatColor.BOLD+"��";
			case 79: return ChatColor.AQUA+""+ChatColor.BOLD+"����";
			case 80: return ChatColor.WHITE+""+ChatColor.BOLD+"�� ���";
			case 81: return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"������";
			case 82: return ChatColor.GRAY+""+ChatColor.BOLD+"����";
			case 83: return ChatColor.GREEN+""+ChatColor.BOLD+"���� ����";
			case 84: return ChatColor.GOLD+""+ChatColor.BOLD+"��ũ �ڽ�";
			case 85: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ��Ÿ��";
			case 86: return ChatColor.GOLD+""+ChatColor.BOLD+"ȣ��";
			case 87: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"�״���";
			case 88: return ChatColor.GOLD+""+ChatColor.BOLD+"�ҿ� ����";
			case 89: return ChatColor.YELLOW+""+ChatColor.BOLD+"�߱���";
			case 90: return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"�״� ��Ż";
			case 91: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� �� ����";
			case 92: return ChatColor.WHITE+""+ChatColor.BOLD+"����ũ ���";
			case 93: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ���� ���彺�� �߰��";
			case 94: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� �߰��";
			case 95:
				switch(itemData)
				{
				case 0:
					return ChatColor.WHITE+""+ChatColor.BOLD+"�Ͼ�� ������ ����";
				case 1:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ������ ����";
				case 2:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ������ ����";
				case 3:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�ϴû� ������ ����";
				case 4:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"����� ������ ����";
				case 5:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���λ� ������ ����";
				case 6:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ������ ����";
				case 7:
					return ChatColor.DARK_GRAY+""+ChatColor.BOLD+"ȸ�� ������ ����";
				case 8:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ȸ�� ������ ����";
				case 9:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"û�ϻ� ������ ����";
				case 10:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"����� ������ ����";
				case 11:
					return ChatColor.DARK_BLUE+""+ChatColor.BOLD+"�Ķ��� ������ ����";
				case 12:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ������ ����";
				case 13:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"�ʷϻ� ������ ����";
				case 14:
					return ChatColor.DARK_RED+""+ChatColor.BOLD+"������ ������ ����";
				case 15:
					return ChatColor.BLACK+""+ChatColor.BOLD+"������ ������ ����";
				}
				break;
			case 96: return ChatColor.GOLD+""+ChatColor.BOLD+"�ٶ���";
			case 97:
				switch(itemData)
				{
				case 0:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�� ���� ��";
				case 1:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���൹ ���� ��";
				case 2:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ���� ���� ��";
				case 3:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�̳� �� ���� ���� ���� ��";
				case 4:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�� �� ���� ���� ���� ��";
				case 5:
					return ChatColor.GRAY+""+ChatColor.BOLD+"������ ���� ���� ���� ��";
				}
				break;
			case 98:
				switch(itemData)
				{
				case 0:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ����";
				case 1:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�̳� �� ���� ����";
				case 2:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�� �� ���� ����";
				case 3:
					return ChatColor.GRAY+""+ChatColor.BOLD+"������ ���� ����";
				}
				break;
			case 99: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ���� �� ���";
			case 100: return ChatColor.RED+""+ChatColor.BOLD+"���� ���� ���� �� ���";
			case 101: return ChatColor.GRAY+""+ChatColor.BOLD+"öâ";
			case 102: return ChatColor.WHITE+""+ChatColor.BOLD+"������";
			case 103: return ChatColor.GREEN+""+ChatColor.BOLD+"���� ���";
			
			
			case 106: return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"����";
			case 107: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ��Ÿ�� ��";
			case 108: return ChatColor.RED+""+ChatColor.BOLD+"���� ���";
			case 109: return ChatColor.GRAY+""+ChatColor.BOLD+"���� ���� ���";
			case 110: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"�ջ�ü";
			case 111: return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"������";
			case 112: return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"�״� ����";
			case 113: return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"�״� ���� ��Ÿ��";
			case 114: return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"�״� ���� ���";
			case 115: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"�״� ��Ʈ";
			case 116: return ChatColor.AQUA+""+ChatColor.BOLD+"��æƮ ���̺�";
			case 117: return ChatColor.YELLOW+""+ChatColor.BOLD+"������";
			case 118: return ChatColor.GRAY+""+ChatColor.BOLD+"������";
			case 119: return ChatColor.BLACK+""+ChatColor.BOLD+"�������� ��Ż";
			case 120: return ChatColor.YELLOW+""+ChatColor.BOLD+"���� ��Ż";
			case 121: return ChatColor.YELLOW+""+ChatColor.BOLD+"���� ����";
			case 122: return ChatColor.BLACK+""+ChatColor.BOLD+"�巡�� ��";
			case 123: return ChatColor.GOLD+""+ChatColor.BOLD+"���彺�� ����";
			case 124: return ChatColor.YELLOW+""+ChatColor.BOLD+"������ ���彺�� ����";
			case 125: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���� �� ���";
			case 126:
				switch(itemData%6)
				{
				case 0:
					return ChatColor.GOLD+""+ChatColor.BOLD+"������ �� ���";
				case 1:
					return ChatColor.BLACK+""+ChatColor.BOLD+"�����񳪹� �� ���";
				case 2:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���۳��� �� ���";
				case 3:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� �� ���";
				case 4:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þƳ��� �� ���";
				case 5:
					return ChatColor.BLACK+""+ChatColor.BOLD+"£�� ������ �� ���";
				}
				break;
			case 127: return ChatColor.GOLD+""+ChatColor.BOLD+"���ھ� ����";
			case 128: return ChatColor.YELLOW+""+ChatColor.BOLD+"��� ���";
			case 129: return ChatColor.GREEN+""+ChatColor.BOLD+"���޶��� ����";
			case 130: return ChatColor.BLACK+""+ChatColor.BOLD+"���� ����";
			case 131: return ChatColor.GRAY+""+ChatColor.BOLD+"ö�� �� ����";
			case 132: return ChatColor.GRAY+""+ChatColor.BOLD+"ö�� �� ���� ��";
			case 133: return ChatColor.GREEN+""+ChatColor.BOLD+"���޶��� ���";
			case 134: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���� ���";
			case 135: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ���";
			case 136: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ���";
			case 137: return ChatColor.RED+""+ChatColor.BOLD+"Ŀ"+""+ChatColor.BOLD+ChatColor.GOLD+""+ChatColor.BOLD+"��"+""+ChatColor.BOLD+ChatColor.YELLOW+""+ChatColor.BOLD+"��"+""+ChatColor.BOLD+ChatColor.DARK_GREEN+""+ChatColor.BOLD+" ��"+""+ChatColor.BOLD+ChatColor.BLUE+""+ChatColor.BOLD+"��";
			case 138: return ChatColor.AQUA+""+ChatColor.BOLD+"��ȣ��";
			case 139: return ChatColor.GRAY+""+ChatColor.BOLD+"���൹ ����";
			case 140: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"ȭ��";
			case 141: return ChatColor.GREEN+""+ChatColor.BOLD+"���۹�";
			case 142: return ChatColor.GREEN+""+ChatColor.BOLD+"���۹�";
			case 143: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ��ư";
			case 144: return ChatColor.WHITE+""+ChatColor.BOLD+"�̽��׸� �ذ�";
			case 145:
				switch(itemData)
				{
				case 0:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���";
				case 1:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�ణ �ջ�� ���";
				case 2:
					return ChatColor.GRAY+""+ChatColor.BOLD+"�ɰ��ϰ� �ջ�� ���";
				}
				break;
			case 146: return ChatColor.RED+""+ChatColor.BOLD+"�� ����";
			case 147: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ������(����)";
			case 148: return ChatColor.WHITE+""+ChatColor.BOLD+"���� ������(����)";
			case 149: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� �񱳱�";
			case 150: return ChatColor.YELLOW+""+ChatColor.BOLD+"������ ���彺�� �񱳱�";
			case 151: return ChatColor.RED+""+ChatColor.BOLD+"�޺� ������";
			case 152: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� ���";
			case 153: return ChatColor.WHITE+""+ChatColor.BOLD+"�״� ���� ����";
			case 154: return ChatColor.GRAY+""+ChatColor.BOLD+"�򶧱�";
			case 155:
				switch(itemData)
				{
				case 0:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���� ���";
				case 1:
					return ChatColor.WHITE+""+ChatColor.BOLD+"������ ���� ���";
				default:
					return ChatColor.WHITE+""+ChatColor.BOLD+"���� ��� ���";
				}
			case 156: return ChatColor.WHITE+""+ChatColor.BOLD+"���� ���";
			case 157: return ChatColor.GRAY+""+ChatColor.BOLD+"Ȱ��ȭ ����";
			case 158: return ChatColor.GRAY+""+ChatColor.BOLD+"���ޱ�";
			case 159:
				switch(itemData)
				{
				case 0:
					return ChatColor.WHITE+""+ChatColor.BOLD+"��� ������ ����";
				case 1:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ������ ����";
				case 2:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ������ ����";
				case 3:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�ϴû� ������ ����";
				case 4:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"����� ������ ����";
				case 5:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���λ� ������ ����";
				case 6:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ������ ����";
				case 7:
					return ChatColor.DARK_GRAY+""+ChatColor.BOLD+"ȸ�� ������ ����";
				case 8:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ȸ�� ������ ����";
				case 9:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"û�ϻ� ������ ����";
				case 10:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"����� ������ ����";
				case 11:
					return ChatColor.DARK_BLUE+""+ChatColor.BOLD+"�Ķ��� ������ ����";
				case 12:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ������ ����";
				case 13:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"�ʷϻ� ������ ����";
				case 14:
					return ChatColor.DARK_RED+""+ChatColor.BOLD+"������ ������ ����";
				case 15:
					return ChatColor.BLACK+""+ChatColor.BOLD+"������ ������ ����";
				}
				break;
			case 160:
				switch(itemData)
				{
				case 0:
					return ChatColor.WHITE+""+ChatColor.BOLD+"�Ͼ�� ������ ������";
				case 1:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ������ ������";
				case 2:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ������ ������";
				case 3:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�ϴû� ������ ������";
				case 4:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"����� ������ ������";
				case 5:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���λ� ������ ������";
				case 6:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ������ ������";
				case 7:
					return ChatColor.DARK_GRAY+""+ChatColor.BOLD+"ȸ�� ������ ������";
				case 8:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ȸ�� ������ ������";
				case 9:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"û�ϻ� ������ ������";
				case 10:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"����� ������ ������";
				case 11:
					return ChatColor.DARK_BLUE+""+ChatColor.BOLD+"�Ķ��� ������ ������";
				case 12:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ������ ������";
				case 13:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"�ʷϻ� ������ ������";
				case 14:
					return ChatColor.DARK_RED+""+ChatColor.BOLD+"������ ������ ������";
				case 15:
					return ChatColor.BLACK+""+ChatColor.BOLD+"������ ������ ������";
				}
				break;
			case 161:
				switch(itemData)
				{
				case 0:
					return ChatColor.GREEN+""+ChatColor.BOLD+"��ī�þ� ��";
				case 1:
					return ChatColor.GREEN+""+ChatColor.BOLD+"£�� ������ ��";
				}
				break;
			case 162:
				switch(itemData%2)
				{
				case 0:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þ� ����";
				case 1:
					return ChatColor.BLACK+""+ChatColor.BOLD+"£�� ������";
				}
				break;
			case 163: return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þ� ���� ���";
			case 164: return ChatColor.GOLD+""+ChatColor.BOLD+"£�� ������ ���";
			case 165: return ChatColor.GREEN+""+ChatColor.BOLD+"������ ���";
			case 166: return ChatColor.WHITE+""+ChatColor.BOLD+"�ٸ�����Ʈ(������)";
			case 167: return ChatColor.WHITE+""+ChatColor.BOLD+"ö �ٶ���";
			case 168:
				switch(itemData)
				{
				case 0:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�������";
				case 1:
					return ChatColor.AQUA+""+ChatColor.BOLD+"������� ����";
				case 2:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"��ο� ������� ����";
				}
				break;
			case 169: return ChatColor.AQUA+""+ChatColor.BOLD+"�ٴ� ����";
			case 170: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 171:
				switch(itemData)
				{
				case 0:
					return ChatColor.WHITE+""+ChatColor.BOLD+"��� ��ź��";
				case 1:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ��ź��";
				case 2:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ��ź��";
				case 3:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�ϴû� ��ź��";
				case 4:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"����� ��ź��";
				case 5:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���λ� ��ź��";
				case 6:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ��ź��";
				case 7:
					return ChatColor.DARK_GRAY+""+ChatColor.BOLD+"ȸ�� ��ź��";
				case 8:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ȸ�� ��ź��";
				case 9:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"û�ϻ� ��ź��";
				case 10:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"����� ��ź��";
				case 11:
					return ChatColor.DARK_BLUE+""+ChatColor.BOLD+"�Ķ��� ��ź��";
				case 12:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���� ��ź��";
				case 13:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"�ʷϻ� ��ź��";
				case 14:
					return ChatColor.DARK_RED+""+ChatColor.BOLD+"������ ��ź��";
				case 15:
					return ChatColor.BLACK+""+ChatColor.BOLD+"������ ��ź��";
				}
				break;
			case 172: return ChatColor.GRAY+""+ChatColor.BOLD+"���� ����";
			case 173: return ChatColor.BLACK+""+ChatColor.BOLD+"��ź ���";
			case 174: return ChatColor.MAGIC+""+ChatColor.BOLD+"�ܴ��� ����";
			case 175:
				switch(itemData)
				{
				case 0:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"�عٶ��";
				case 1:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"���϶�";
				case 2:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"ū �ܵ�";
				case 3:
					return ChatColor.AQUA+""+ChatColor.BOLD+"ū ��縮";
				case 4:
					return ChatColor.RED+""+ChatColor.BOLD+"��� ����";
				case 5:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"���";
				}
				break;
			case 176: return ChatColor.WHITE+""+ChatColor.BOLD+"������(�Ʒ� ���)";
			case 177: return ChatColor.WHITE+""+ChatColor.BOLD+"������(�� ���)";
			case 178: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ���� �޺� ������";
			case 179:
				switch(itemData)
				{
				case 0:
					return ChatColor.RED+""+ChatColor.BOLD+"���� ���";
				case 1:
					return ChatColor.RED+""+ChatColor.BOLD+"������ ���� ���";
				case 2:
					return ChatColor.RED+""+ChatColor.BOLD+"�ε巯�� ���� ���";
				}
				break;
			case 180: return ChatColor.RED+""+ChatColor.BOLD+"���� ��� ���";
			case 181: return ChatColor.RED+""+ChatColor.BOLD+"������ ���� ��� �� ���";
			case 182: return ChatColor.RED+""+ChatColor.BOLD+"���� ��� �� ���";
			case 183: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���� ��Ÿ�� ��";
			case 184: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��Ÿ�� ��";
			case 185: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��Ÿ�� ��";
			case 186: return ChatColor.GOLD+""+ChatColor.BOLD+"£�� ������ ��Ÿ�� ��";
			case 187: return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þ� ���� ��Ÿ�� ��";
			case 188: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���� ��Ÿ��";
			case 189: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��Ÿ��";
			case 190: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��Ÿ��";
			case 191: return ChatColor.GOLD+""+ChatColor.BOLD+"£�� ������ ��Ÿ��";
			case 192: return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þ� ���� ��Ÿ��";
			case 193: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���� ��¦ ��";
			case 194: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��¦ ��";
			case 195: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��¦ ��";
			case 196: return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þ� ���� ��¦ ��";
			case 197: return ChatColor.GOLD+""+ChatColor.BOLD+"£�� ������ ��¦ ��";
			
			case 256: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ��";
			case 257: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ���";
			case 258: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ����";
			case 259: return ChatColor.WHITE+""+ChatColor.BOLD+"������";
			case 260: return ChatColor.RED+""+ChatColor.BOLD+"���";
			case 261: return ChatColor.GOLD+""+ChatColor.BOLD+"Ȱ";
			case 262: return ChatColor.GOLD+""+ChatColor.BOLD+"ȭ��";
			case 263:
				switch(itemData)
				{
				case 0:
					return ChatColor.BLACK+""+ChatColor.BOLD+"��ź";
				case 1:
					return ChatColor.BLACK+""+ChatColor.BOLD+"��ź";
				}
				break;
			case 264: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ��";
			case 265: return ChatColor.WHITE+""+ChatColor.BOLD+"ö��";
			case 266: return ChatColor.YELLOW+""+ChatColor.BOLD+"�ݱ�";
			case 267: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ��";
			case 268: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ��";
			case 269: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ��";
			case 270: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���";
			case 271: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 272: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ��";
			case 273: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ��";
			case 274: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ���";
			case 275: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ����";
			case 276: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ��";
			case 277: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ��";
			case 278: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ���";
			case 279: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ����";
			case 280: return ChatColor.GOLD+""+ChatColor.BOLD+"�����";
			case 281: return ChatColor.GOLD+""+ChatColor.BOLD+"�׸�";
			case 282: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"���� ��Ʃ";
			case 283: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ��";
			case 284: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ��";
			case 285: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ���";
			case 286: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ����";
			case 287: return ChatColor.WHITE+""+ChatColor.BOLD+"��";
			case 288: return ChatColor.WHITE+""+ChatColor.BOLD+"����";
			case 289: return ChatColor.GRAY+""+ChatColor.BOLD+"ȭ��";
			case 290: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 291: return ChatColor.GRAY+""+ChatColor.BOLD+"�� ����";
			case 292: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ����";
			case 293: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ����";
			case 294: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ����";
			case 295: return ChatColor.GREEN+""+ChatColor.BOLD+"����";
			case 296: return ChatColor.GOLD+""+ChatColor.BOLD+"��";
			case 297: return ChatColor.GOLD+""+ChatColor.BOLD+"��";
			case 298: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 299: return ChatColor.GOLD+""+ChatColor.BOLD+"���� Ʃ��";
			case 300: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 301: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ��ȭ";
			case 302: return ChatColor.WHITE+""+ChatColor.BOLD+"�罽 ����";
			case 303: return ChatColor.WHITE+""+ChatColor.BOLD+"�罽 ����";
			case 304: return ChatColor.WHITE+""+ChatColor.BOLD+"�罽 ���뽺";
			case 305: return ChatColor.WHITE+""+ChatColor.BOLD+"�罽 ����";
			case 306: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ����";
			case 307: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ����";
			case 308: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ���뽺";
			case 309: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ����";
			case 310: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ����";
			case 311: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ����";
			case 312: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ���뽺";
			case 313: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� ����";
			case 314: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ����";
			case 315: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ����";
			case 316: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ���뽺";
			case 317: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ����";
			case 318: return ChatColor.BLACK+""+ChatColor.BOLD+"�ν˵�";
			case 319: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"������ ���� �������";
			case 320: return ChatColor.GOLD+""+ChatColor.BOLD+"���� �������";
			case 321: return ChatColor.GRAY+""+ChatColor.BOLD+"�׸�";
			case 322:
				switch(itemData)
				{
				case 0:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"Ȳ�ݻ��";
				case 1:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"��æƮ�� Ȳ�ݻ��";
				}
				break;
			case 323: return ChatColor.GOLD+""+ChatColor.BOLD+"ǥ����";
			case 324: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ��";
			case 325: return ChatColor.GRAY+""+ChatColor.BOLD+"�絿��";
			case 326: return ChatColor.BLUE+""+ChatColor.BOLD+"�� �絿��";
			case 327: return ChatColor.RED+""+ChatColor.BOLD+"��� �絿��";
			case 328: return ChatColor.GRAY+""+ChatColor.BOLD+"����īƮ";
			case 329: return ChatColor.GOLD+""+ChatColor.BOLD+"����";
			case 330: return ChatColor.WHITE+""+ChatColor.BOLD+"ö ��";
			case 331: return ChatColor.RED+""+ChatColor.BOLD+"���彺��";
			case 332: return ChatColor.WHITE+""+ChatColor.BOLD+"������";
			case 333: return ChatColor.GOLD+""+ChatColor.BOLD+"��Ʈ";
			case 334: return ChatColor.GOLD+""+ChatColor.BOLD+"����";
			case 335: return ChatColor.WHITE+""+ChatColor.BOLD+"����";
			case 336: return ChatColor.RED+""+ChatColor.BOLD+"����";
			case 337: return ChatColor.GRAY+""+ChatColor.BOLD+"����";
			case 338: return ChatColor.GREEN+""+ChatColor.BOLD+"��������";
			case 339: return ChatColor.WHITE+""+ChatColor.BOLD+"����";
			case 340: return ChatColor.GOLD+""+ChatColor.BOLD+"å";
			case 341: return ChatColor.GREEN+""+ChatColor.BOLD+"������ ��";
			case 342: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����īƮ";
			case 343: return ChatColor.GRAY+""+ChatColor.BOLD+"ȭ�� ����īƮ";
			case 344: return ChatColor.WHITE+""+ChatColor.BOLD+"�ް�";
			case 345: return ChatColor.GRAY+""+ChatColor.BOLD+"��ħ��";
			case 346: return ChatColor.GOLD+""+ChatColor.BOLD+"���˴�";
			case 347: return ChatColor.YELLOW+""+ChatColor.BOLD+"�ð�";
			case 348: return ChatColor.YELLOW+""+ChatColor.BOLD+"�߱��� ����";
			case 349:
				switch(itemData)
				{
				case 0:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�� ����";
				case 1:
					return ChatColor.RED+""+ChatColor.BOLD+"�� ����";
				case 2:
					return ChatColor.GOLD+""+ChatColor.BOLD+"�򵿰���";
				case 3:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"����";
				}
				break;
			case 350:
				switch(itemData)
				{
				case 0:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ����";
				case 1:
					return ChatColor.RED+""+ChatColor.BOLD+"���� ����";
				}
				break;
			case 351:
				switch(itemData)
				{
				case 0:
					return ChatColor.BLACK+""+ChatColor.BOLD+"�Թ�";
				case 1:
					return ChatColor.RED+""+ChatColor.BOLD+"���� ��� ����";
				case 2:
					return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"�ʷ� ������ ����";
				case 3:
					return ChatColor.GOLD+""+ChatColor.BOLD+"���ھ� ��";
				case 4:
					return ChatColor.DARK_BLUE+""+ChatColor.BOLD+"û�ݼ�";
				case 5:
					return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"����� ����";
				case 6:
					return ChatColor.DARK_AQUA+""+ChatColor.BOLD+"û�ϻ� ����";
				case 7:
					return ChatColor.GRAY+""+ChatColor.BOLD+"���� ȸ�� ����";
				case 8:
					return ChatColor.DARK_GRAY+""+ChatColor.BOLD+"ȸ�� ����";
				case 9:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ����";
				case 10:
					return ChatColor.GREEN+""+ChatColor.BOLD+"���λ� ����";
				case 11:
					return ChatColor.YELLOW+""+ChatColor.BOLD+"��� �ε鷹 ����";
				case 12:
					return ChatColor.AQUA+""+ChatColor.BOLD+"�ϴû� ����";
				case 13:
					return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȫ�� ����";
				case 14:
					return ChatColor.GOLD+""+ChatColor.BOLD+"��Ȳ�� ����";
				case 15:
					return ChatColor.WHITE+""+ChatColor.BOLD+"�İ���";
				}
				break;
			case 352: return ChatColor.WHITE+""+ChatColor.BOLD+"��";
			case 353: return ChatColor.WHITE+""+ChatColor.BOLD+"����";
			case 354: return ChatColor.WHITE+""+ChatColor.BOLD+"����ũ";
			case 355: return ChatColor.RED+""+ChatColor.BOLD+"ħ��";
			case 356: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� �߰��";
			case 357: return ChatColor.GOLD+""+ChatColor.BOLD+"��Ű";
			
			case 359: return ChatColor.WHITE+""+ChatColor.BOLD+"����";
			case 360: return ChatColor.GREEN+""+ChatColor.BOLD+"����";
			case 361: return ChatColor.WHITE+""+ChatColor.BOLD+"ȣ�ھ�";
			case 362: return ChatColor.BLACK+""+ChatColor.BOLD+"���ھ�";
			case 363: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"������ ���� �Ұ��";
			case 364: return ChatColor.GOLD+""+ChatColor.BOLD+"������ũ";
			case 365: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"������ ���� �߰��";
			case 366: return ChatColor.GOLD+""+ChatColor.BOLD+"���� �߰��";
			case 367: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"���� ���";
			case 368: return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"���� ����";
			case 369: return ChatColor.YELLOW+""+ChatColor.BOLD+"������ ����";
			case 370: return ChatColor.WHITE+""+ChatColor.BOLD+"����Ʈ�� ����";
			case 371: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� ����";
			case 372: return ChatColor.RED+""+ChatColor.BOLD+"�״� ��Ʈ";
			case 373: return ChatColor.BLUE+""+ChatColor.BOLD+"����";
			case 374: return ChatColor.WHITE+""+ChatColor.BOLD+"������";
			case 375: return ChatColor.DARK_RED+""+ChatColor.BOLD+"�Ź� ��";
			case 376: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"��ȿ�� �Ź� ��";
			case 377: return ChatColor.YELLOW+""+ChatColor.BOLD+"������ ����";
			case 378: return ChatColor.YELLOW+""+ChatColor.BOLD+"���׸� ũ��";
			case 379: return ChatColor.YELLOW+""+ChatColor.BOLD+"������";
			case 380: return ChatColor.GRAY+""+ChatColor.BOLD+"������";
			case 381: return ChatColor.DARK_GREEN+""+ChatColor.BOLD+"������ ��";
			case 382: return ChatColor.YELLOW+""+ChatColor.BOLD+"��¦�̴� ����";
			case 383: return ChatColor.GRAY+""+ChatColor.BOLD+"���� ���� ����";
			case 384: return ChatColor.GREEN+""+ChatColor.BOLD+"����ġ ��";
			case 385: return ChatColor.BLACK+""+ChatColor.BOLD+"ȭ����";
			case 386: return ChatColor.WHITE+""+ChatColor.BOLD+"å�� ����";
			case 388: return ChatColor.GREEN+""+ChatColor.BOLD+"���޶���";
			case 389: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ����";
			case 390: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"ȭ��";
			case 391: return ChatColor.GOLD+""+ChatColor.BOLD+"���";
			case 392: return ChatColor.GOLD+""+ChatColor.BOLD+"����";
			case 393: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 394: return ChatColor.GREEN+""+ChatColor.BOLD+"���� �� ����";
			case 395: return ChatColor.WHITE+""+ChatColor.BOLD+"�� ����";
			case 396: return ChatColor.YELLOW+""+ChatColor.BOLD+"Ȳ�� ���";
			case 397: return ChatColor.WHITE+""+ChatColor.BOLD+"�Ӹ�";
			case 398: return ChatColor.GOLD+""+ChatColor.BOLD+"��� ���˴�";
			case 399: return ChatColor.AQUA+""+ChatColor.BOLD+"�״��� ��";
			case 400: return ChatColor.GOLD+""+ChatColor.BOLD+"ȣ�� ����";
			case 402: return ChatColor.GRAY+""+ChatColor.BOLD+"�Ҳɳ��� ź��";
			case 403: return ChatColor.YELLOW+""+ChatColor.BOLD+"������ �ο��� å";
			case 404: return ChatColor.RED+""+ChatColor.BOLD+"���彺�� �񱳱�";
			case 405: return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"�״� ����";
			case 406: return ChatColor.WHITE+""+ChatColor.BOLD+"�״� ����";
			case 407: return ChatColor.DARK_RED+""+ChatColor.BOLD+"TNT ����īƮ";
			case 408: return ChatColor.GRAY+""+ChatColor.BOLD+"�򶧱� ����īƮ";
			case 409: return ChatColor.AQUA+""+ChatColor.BOLD+"������� ����";
			case 410: return ChatColor.AQUA+""+ChatColor.BOLD+"������� ����";
			case 411: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"������ ���� �䳢���";
			case 412: return ChatColor.GOLD+""+ChatColor.BOLD+"���� �䳢���";
			case 413: return ChatColor.GOLD+""+ChatColor.BOLD+"�䳢 ��Ʃ";
			case 414: return ChatColor.GOLD+""+ChatColor.BOLD+"�䳢 ��";
			case 415: return ChatColor.GOLD+""+ChatColor.BOLD+"�䳢 ����";
			case 416: return ChatColor.WHITE+""+ChatColor.BOLD+"���� ��ġ��";
			case 417: return ChatColor.WHITE+""+ChatColor.BOLD+"ö �� ����";
			case 418: return ChatColor.YELLOW+""+ChatColor.BOLD+"�� �� ����";
			case 419: return ChatColor.AQUA+""+ChatColor.BOLD+"���̾Ƹ�� �� ����";
			case 420: return ChatColor.GOLD+""+ChatColor.BOLD+"��";
			case 421: return ChatColor.GOLD+""+ChatColor.BOLD+"�̸�ǥ";
			case 423: return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"������ ���� ����";
			case 424: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ����";
			case 425: return ChatColor.WHITE+""+ChatColor.BOLD+"������";
			case 427: return ChatColor.GOLD+""+ChatColor.BOLD+"������ ���� ��";
			case 428: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��";
			case 429: return ChatColor.GOLD+""+ChatColor.BOLD+"���� ���� ��";
			case 430: return ChatColor.GOLD+""+ChatColor.BOLD+"��ī�þ� ���� ��";
			case 431: return ChatColor.GOLD+""+ChatColor.BOLD+"£�� ������ ��";
			case 2256: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.YELLOW+""+ChatColor.BOLD+"13"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2257: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.GREEN+""+ChatColor.BOLD+"cat"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2258: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.RED+""+ChatColor.BOLD+"blocks"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2259: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.DARK_RED+""+ChatColor.BOLD+"chirp"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2260: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.GREEN+""+ChatColor.BOLD+"far"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2261: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.MAGIC+""+ChatColor.BOLD+"mall"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2262: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"mellohi"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2263: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.BLACK+""+ChatColor.BOLD+"stal"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2264: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.WHITE+""+ChatColor.BOLD+"strad"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2265: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.DARK_GREEN+""+ChatColor.BOLD+"ward"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2266: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.BLACK+""+ChatColor.BOLD+"11"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
			case 2267: return ChatColor.GRAY+""+ChatColor.BOLD+"[����] [�� �� : "+""+ChatColor.BOLD+ChatColor.AQUA+""+ChatColor.BOLD+"wait"+""+ChatColor.BOLD+ChatColor.GRAY+""+ChatColor.BOLD+"]";
		}
		return name;
	}
}
