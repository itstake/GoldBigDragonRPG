package GBD.GoldBigDragon_Advanced.Main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class Main extends JavaPlugin implements Listener
{
	public static YamlController Main_YC,GUI_YC,Party_YC,Config_YC,Event_YC,Monster_YC,Location_YC,Scheduler_YC;

	public static String serverUpdate = "2015-11-22-14:24";
	public static String serverVersion = "Advanced";
	private static String updateCheckURL = "https://goldbigdragon.github.io/";
	
	public static String currentServerUpdate = "2015-11-22-14:24";
	public static String currentServerVersion = "Advanced";
	
	public static String SpawnMobName;
	
	public static HashMap<Player, String> TEMP = new HashMap<Player, String>();
	public static java.util.Map<Player, UserDataObject> UserData = new LinkedHashMap<Player, UserDataObject>();
	public static java.util.Map<Long, PartyDataObject> Party = new LinkedHashMap<Long, PartyDataObject>();
	public static java.util.Map<Player, Long> PartyJoiner = new LinkedHashMap<Player, Long>();
	
	public static HashMap<Player, Location> catchedLocation1 = new HashMap<Player, Location>();
	public static HashMap<Player, Location> catchedLocation2 = new HashMap<Player, Location>();
	
	public static HashMap<Player, String> PlayerUseSpell = new HashMap<Player, String>();
	public static HashMap<Player, ItemStack> PlayerlastItem = new HashMap<Player, ItemStack>();
	public static HashMap<Player, String> PlayerClickedNPCuuid = new HashMap<Player, String>();
	public static HashMap<Player, String> PlayerCurrentArea = new HashMap<Player, String>();
	
	public static boolean MagicSpellsCatched = false;
	public static boolean CitizensCatched = false;
	public static boolean NoteBlockAPI = false;
	public static boolean NoteBlockAPIAble = false;
	
	public static boolean spawntime = true;
	public static boolean Mapping = false;
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
	  	Main_YC = new YamlController(this);
	  	GUI_YC = new YamlController(this);
	  	Config_YC = new YamlController(this);
	  	Party_YC = new YamlController(this);
	  	Event_YC = new YamlController(this);
	  	Monster_YC = new YamlController(this);
	  	Location_YC = new YamlController(this);
	  	Scheduler_YC = new YamlController(this);
	  	File MusicFolder = new File(this.getDataFolder().getAbsolutePath() + "/NoteBlockSound/");
		if(!MusicFolder.exists())
			MusicFolder.mkdirs();

	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "��������������������������������������������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "I changed My Symbol!");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Like this Oriental Dragon...");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Because some peoples claimed");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "my original Dragon symbol...");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "(They said my original symbol");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "looks like the 'Nazi''s Hakenkreuz)");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "��");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "����������"); 
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ߡ���");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�����ߡ�������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "���������ߡ�������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ߡ������ߡ���");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�����ߡ������ߡ�������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "���ߡ������ߡ�����������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�����ߡ��ߡ���������������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ߡ�������������������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "��GoldBigDragon Advanced");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "http://cafe.naver.com/goldbigdragon");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "��������");
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "��������������������������������������������");

	  	GBD.GoldBigDragon_Advanced.Config.configConfig config = new GBD.GoldBigDragon_Advanced.Config.configConfig();
	  	config.CreateNewConfig(Main_YC);
	  	config.CreateMapImageConfig(Main_YC);
	  	if(Main_YC.isExit("Skill/SkillList.yml") == false)
	  	  new GBD.GoldBigDragon_Advanced.Config.SkillConfig().CreateNewSkillList();
	  	if(Main_YC.isExit("Skill/JobList.yml") == false)
	  		new GBD.GoldBigDragon_Advanced.Config.SkillConfig().CreateNewJobList();
	  	if(Main_YC.isExit("ETC/NewBie.yml") == false)
	  		new GBD.GoldBigDragon_Advanced.Config.NewBieConfig().CreateNewConfig();
	  	new GBD.GoldBigDragon_Advanced.Config.NPCconfig().NPCscriptExample();
	  	
	  	new UserDataManager().loadCategoriFile();
	  	new PartyDataManager().loadParty();
	  	
		YamlManager WorldConfig =GUI_YC.getNewConfig("WorldList.yml");
		Object[] worldname = WorldConfig.getKeys().toArray();
		for(int count = 0; count < WorldConfig.getKeys().size();count++)
			if(Bukkit.getWorld(worldname[count].toString()) == null)
				WorldCreator.name(worldname[count].toString()).createWorld();
		
		VersionCheck();
		UpdateConfig();
		NoteBlockAPICatch();
		
		new GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain(this);
		new GBD.GoldBigDragon_Advanced.ServerTick.ServerTickScheduleManager().loadCategoriFile();
		new GBD.GoldBigDragon_Advanced.Main.ServerOption().Initialize();
	  	return;
	}
	public void onDisable()
	{
		if(Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI"))
		{
	    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
	    	Player[] a = new Player[playerlist.size()];
	    	playerlist.toArray(a);
	    	for(int count = 0; count <a.length;count++)
	    		new OtherPlugins.NoteBlockAPIMain().Stop(a[count]);
		}
	  	new UserDataManager().saveCategoriFile();
	  	new PartyDataManager().saveParty();

		new GBD.GoldBigDragon_Advanced.ServerTick.ServerTickScheduleManager().saveCategoriFile();
	  	Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[Clossing GoldBigDragon Advanced...]");
	  	return;
	}
	
	public void VersionCheck()
	{
		BufferedInputStream in = null;
		StringBuffer sb = new StringBuffer();
		try
		{
			URL url = new URL(updateCheckURL);
			URLConnection urlConnection = url.openConnection();
			in = new BufferedInputStream(urlConnection.getInputStream());
			byte[] bufRead = new byte[10];
			int lenRead = 0;
			
			while ((lenRead = in.read(bufRead)) >0)
				sb.append(new String(bufRead, 0, lenRead));
			String[] Parsed = sb.toString().split("<br>");
			
			String Version = Parsed[1].split(": ")[1];
			String Update = Parsed[2].split(": ")[1];
			
		  	Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "�ֽ� ���� : "+Version);
		  	Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "���� ���� : "+serverVersion);
		  	Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "�ֽ� ��ġ : "+Update);
		  	Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "���� ��ġ : "+serverUpdate);

			currentServerUpdate = Update;
			currentServerVersion = Version;
			if(serverVersion.compareTo(Version)==0&&serverUpdate.compareTo(Update)==0)
			  	Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "���� GoldBigDragonRPG�� �ֽ� �����Դϴ�!");
			else
			{
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "�ֽ� ������ �ƴմϴ�! �Ʒ� �ּҿ��� �ٿ�ε� ��������!");
		  		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "http://cafe.naver.com/goldbigdragon/40109");
			}
			
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		  	Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[���� üũ ����] ���ͳ� ������ Ȯ�� �� �ּ���!");
		}
	}
	
	public void UpdateConfig()
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		if(Config.contains("Server.CustomWeaponBreak")==false)
		{
			Config.set("Server.CustomWeaponBreak", true);
			Config.saveConfig();
		}
	}
	
	@EventHandler
	private void PlayerJoin(PlayerJoinEvent event)
	{
		NoteBlockAPICatchPJ();
		Player player = event.getPlayer();
		MagicSpellCatch();
		CitizensCatch();
		YamlManager Config = GUI_YC.getNewConfig("config.yml");
		if(Config.getInt("Event.DropChance")>=2||Config.getInt("Event.Multiple_EXP_Get")>=2||Config.getInt("Event.Multiple_Level_Up_StatPoint")>=2||Config.getInt("Event.Multiple_Level_Up_SkillPoint")>=2)
		{
			GBD.GoldBigDragon_Advanced.Effect.PacketSender PS = new GBD.GoldBigDragon_Advanced.Effect.PacketSender();
			String alert = "[";
			if(Config.getInt("Event.DropChance")>=2)
				alert =alert+ "��ӷ� ���� "+Config.getInt("Event.DropChance")+"��";
			if(Config.getInt("Event.DropChance")>=2)
				alert = alert+", ";
			if(Config.getInt("Event.Multiple_EXP_Get")>=2)
				alert = alert + "����ġ " + Config.getInt("Event.Multiple_EXP_Get")+"�� ȹ��";
			if(Config.getInt("Event.Multiple_EXP_Get")>=2)
				alert = alert+", ";
			if(Config.getInt("Event.Multiple_Level_Up_StatPoint")>=2)
				alert = alert +"���� ����Ʈ "+Config.getInt("Event.Multiple_Level_Up_StatPoint")+"�� ȹ��";
			if(Config.getInt("Event.Multiple_Level_Up_StatPoint")>=2)
				alert = alert+", ";
			if(Config.getInt("Event.Multiple_Level_Up_SkillPoint")>=2)
				alert = alert +"��ų ����Ʈ " +Config.getInt("Event.Multiple_Level_Up_SkillPoint")+"�� ȹ��";
			alert = alert+"]";
			PS.sendTitleSubTitle(player, "\'���� �̺�Ʈ�� �������Դϴ�.\'", "\'"+alert+"\'", 1, 10, 1);
		}

		if(player.isOp() == true)
		{
			Main.UserData.put(player, new UserDataObject(player));
			GBD.GoldBigDragon_Advanced.Effect.PacketSender PS = new GBD.GoldBigDragon_Advanced.Effect.PacketSender();
			PS.sendTitleSubTitle(player,"\'��e/���ǹڽ�\'", "\'��eGoldBigDragonAdvanced ���̵� �� ���� ������ �����մϴ�.\'", 1,10, 1);
		}
	  	if(Main_YC.isExit("Stats/" + player.getUniqueId()+".yml") == false)
	  	{
	  	    GBD.GoldBigDragon_Advanced.Config.StatConfig stat = new GBD.GoldBigDragon_Advanced.Config.StatConfig();
	  		stat.CreateNewStats(player);
	  	}
	  	if(Main_YC.isExit("Quest/PlayerData/" + player.getUniqueId()+".yml") == false)
	  	{
	  	    GBD.GoldBigDragon_Advanced.Config.QuestConfig quest = new GBD.GoldBigDragon_Advanced.Config.QuestConfig();
	  	    quest.CreateNewPlayerConfig(player);
	
			YamlController Location_YC = GBD.GoldBigDragon_Advanced.Main.Main.Location_YC;
			YamlManager QuestConfig=Location_YC.getNewConfig("Quest/PlayerData/"+player.getUniqueId()+".yml");
			YamlManager QuestList=Location_YC.getNewConfig("Quest/QuestList.yml");
			YamlManager NewBieYM = Location_YC.getNewConfig("ETC/NewBie.yml");
			
			QuestConfig.set("PlayerName", player.getName());
			QuestConfig.set("PlayerUUID", player.getUniqueId().toString());
			Object[] Quest = QuestList.getKeys().toArray();
			String QuestName = NewBieYM.getString("FirstQuest");
			if(QuestName.equals("null") ==false)
			{
				for(int count = 0; count < Quest.length; count++)
				{
					if(QuestName.compareTo(Quest[count].toString())==0)
					{
						if(QuestList.getConfigurationSection(QuestName+".FlowChart").getKeys(false).toArray().length != 0)
						{
							QuestConfig.set("Started."+QuestName+".Flow", 0);
							QuestConfig.set("Started."+QuestName+".Type", QuestList.getString(QuestName+".FlowChart."+0+".Type"));
							QuestConfig.saveConfig();
							player.sendMessage(ChatColor.YELLOW+"[����Ʈ] : ���ο� ����Ʈ�� �����߽��ϴ�! " +ChatColor.GOLD+""+ChatColor.BOLD+"/����Ʈ");
							if(QuestList.getString(QuestName+".FlowChart."+0+".Type").compareTo("Nevigation")==0||
								QuestList.getString(QuestName+".FlowChart."+0+".Type").compareTo("Whisper")==0||
								QuestList.getString(QuestName+".FlowChart."+0+".Type").compareTo("BroadCast")==0||
								QuestList.getString(QuestName+".FlowChart."+0+".Type").compareTo("BlockPlace")==0||
								QuestList.getString(QuestName+".FlowChart."+0+".Type").compareTo("VarChange")==0||
								QuestList.getString(QuestName+".FlowChart."+0+".Type").compareTo("TelePort")==0)
								new GBD.GoldBigDragon_Advanced.GUI.QuestGUI().QuestTypeRouter(player, QuestName);
							
						}
						break;
					}
				}
			}
			Object[] a= NewBieYM.getConfigurationSection("SupportItem").getKeys(false).toArray();
			for(int count = 0; count < a.length;count++)
				if(NewBieYM.getItemStack("SupportItem."+count) != null)
					player.getInventory().addItem(NewBieYM.getItemStack("SupportItem."+count));
			player.teleport(new Location(Bukkit.getWorld(NewBieYM.getString("TelePort.World")), NewBieYM.getInt("TelePort.X"), NewBieYM.getInt("TelePort.Y"), NewBieYM.getInt("TelePort.Z"), NewBieYM.getInt("TelePort.Yaw"), NewBieYM.getInt("TelePort.Pitch")));
	  	}
	  	if(Main_YC.isExit("Skill/PlayerData/" + player.getUniqueId()+".yml") == false)
	  	{
	  	    GBD.GoldBigDragon_Advanced.Config.SkillConfig skill = new GBD.GoldBigDragon_Advanced.Config.SkillConfig();
	  	  skill.CreateNewPlayerSkill(player);
	  	}
		GBD.GoldBigDragon_Advanced.ETC.Job J = new GBD.GoldBigDragon_Advanced.ETC.Job();
		J.FixJobList();
		J.FixPlayerJobList(player);
		J.FixPlayerSkillList(player);
		
    	GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
    	ETC.UpdatePlayerHPMP(event.getPlayer());
    	new GBD.GoldBigDragon_Advanced.GUI.EquipGUI().FriendJoinQuitMessage(player, true);

		if(Config.getString("Server.JoinMessage") != null)
		{
			String message = Config.getString("Server.JoinMessage").replace("%player%",event.getPlayer().getName());
			event.setJoinMessage(message);
		}
		else
			event.setJoinMessage(null);
	}
	@EventHandler
	private void PlayerQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
		if(PartyJoiner.containsKey(player))
			Party.get(PartyJoiner.get(player)).QuitParty(player);
		
		if(NoteBlockAPIAble == true)
		{
			OtherPlugins.NoteBlockAPIMain NBAPIM = new OtherPlugins.NoteBlockAPIMain();
			NBAPIM.Stop(event.getPlayer());
		}
		PlayerClickedNPCuuid.remove(event.getPlayer());
		Main.UserData.remove(event.getPlayer());
		PlayerCurrentArea.remove(player);
		catchedLocation1.remove(event.getPlayer());
		catchedLocation2.remove(event.getPlayer());
    	new GBD.GoldBigDragon_Advanced.GUI.EquipGUI().FriendJoinQuitMessage(player, false);

		YamlManager Config = GUI_YC.getNewConfig("config.yml");
		if(Config.getString("Server.QuitMessage") != null)
		{
			String message = Config.getString("Server.QuitMessage").replace("%player%",event.getPlayer().getName());
			event.setQuitMessage(message);
		}
		else
			event.setQuitMessage(null);
	}
	
	@EventHandler
	private void PlayerRespawn(PlayerRespawnEvent event)
	{
		Player player = event.getPlayer();
	  	if(Config_YC.isExit("Stats/" + player.getUniqueId()+".yml") == false)
	  	{
	  	    GBD.GoldBigDragon_Advanced.Config.StatConfig stat = new GBD.GoldBigDragon_Advanced.Config.StatConfig();
	  		stat.CreateNewStats(player);
	  	}
	  	YamlManager YM = Config_YC.getNewConfig("Stats/" + player.getUniqueId()+".yml");
		YM.set("ETC.Death", true);
		YM.saveConfig();
    	GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
    	ETC.UpdatePlayerHPMP(event.getPlayer());
		GBD.GoldBigDragon_Advanced.Config.StatConfig stat = new GBD.GoldBigDragon_Advanced.Config.StatConfig();

	  	if(Config_YC.isExit("Stats/" + player.getUniqueId()+".yml") == false)
	  		stat.CreateNewStats(player);
		YM = Config_YC.getNewConfig("Stats/" + player.getUniqueId()+".yml");
		
		if(YM.getBoolean("ETC.Death") == true)
		{
			YamlController Event_YC = GBD.GoldBigDragon_Advanced.Main.Main.Event_YC;
			YamlManager AreaList = Event_YC.getNewConfig("Area/AreaList.yml");

			if(YM.getString("ETC.LastVisited")=="null")
			{
				YM.set("ETC.Death", false);
				YM.saveConfig();
				return;
			}
			else
			{
				String respawnCity = YM.getString("ETC.LastVisited");

				Object[] arealist = AreaList.getConfigurationSection("").getKeys(false).toArray();

				for(int count =0; count <arealist.length;count++)
				{
					if(arealist[count].toString().equalsIgnoreCase(respawnCity) == true)
					{
						if(AreaList.getBoolean(arealist[count].toString()+".SpawnPoint") == true)
						{
							double X = AreaList.getDouble(arealist[count].toString()+".SpawnLocation.X");
							double Y = AreaList.getDouble(arealist[count].toString()+".SpawnLocation.Y");
							double Z = AreaList.getDouble(arealist[count].toString()+".SpawnLocation.Z");

					    	event.setRespawnLocation(new Location(Bukkit.getServer().getWorld(AreaList.getString(arealist[count].toString()+".World")), X, Y, Z, (float)AreaList.getDouble(arealist[count].toString()+".SpawnLocation.Yaw"), (float)AreaList.getDouble(arealist[count].toString()+".SpawnLocation.Pitch")));
						}
					}
				}
				YM.set("ETC.Death", false);
				YM.saveConfig();
				return;
			}
		}
		return;
	}
	@EventHandler
	private void Move(PlayerMoveEvent event){GBD.GoldBigDragon_Advanced.Event.PlayerAction PA = new GBD.GoldBigDragon_Advanced.Event.PlayerAction();PA.PlayerMove(event);return;}

	@EventHandler
	private void HotBarMove(PlayerItemHeldEvent event)
	{
		if(MagicSpellsCatched == false)
			MagicSpellCatch();
		 new GBD.GoldBigDragon_Advanced.Event.ChangeHotBar().HotBarMove(event);
		 return;
	}
	
	@EventHandler
	private void PlayerItemDrop(PlayerDropItemEvent event)
	{
		ItemStack IT = event.getItemDrop().getItemStack();
		if(IT.hasItemMeta() == true)
		{
			if(IT.getItemMeta().hasLore() == true)
			{
				if(IT.getItemMeta().getLore().size() == 4)
				{
					if(IT.getItemMeta().getLore().get(3).equals(ChatColor.YELLOW+"[Ŭ���� �����Կ��� ����]")==true)
					{
						event.setCancelled(true);
					}
				}
			}
		}
		return;
	}
	
	@EventHandler
	private void PlayerChatting(PlayerChatEvent event)
	{
		if(event.getMessage().contains("&") == true)
		{
			event.setMessage(event.getMessage().replaceAll("&l", ChatColor.BOLD+""));
			event.setMessage(event.getMessage().replaceAll("&0", ChatColor.BLACK+""));
			event.setMessage(event.getMessage().replaceAll("&1", ChatColor.DARK_BLUE+""));
			event.setMessage(event.getMessage().replaceAll("&2", ChatColor.DARK_GREEN+""));
			event.setMessage(event.getMessage().replaceAll("&3", ChatColor.DARK_AQUA+""));
			event.setMessage(event.getMessage().replaceAll("&4", ChatColor.DARK_RED+""));
			event.setMessage(event.getMessage().replaceAll("&5", ChatColor.DARK_PURPLE+""));
			event.setMessage(event.getMessage().replaceAll("&6", ChatColor.GOLD+""));
			event.setMessage(event.getMessage().replaceAll("&7", ChatColor.GRAY+""));
			event.setMessage(event.getMessage().replaceAll("&8", ChatColor.DARK_GRAY+""));
			event.setMessage(event.getMessage().replaceAll("&9", ChatColor.BLUE+""));
			event.setMessage(event.getMessage().replaceAll("&a", ChatColor.GREEN+""));
			event.setMessage(event.getMessage().replaceAll("&b", ChatColor.AQUA+""));
			event.setMessage(event.getMessage().replaceAll("&c", ChatColor.RED+""));
			event.setMessage(event.getMessage().replaceAll("&d", ChatColor.LIGHT_PURPLE+""));
			event.setMessage(event.getMessage().replaceAll("&e", ChatColor.YELLOW+""));
			event.setMessage(event.getMessage().replaceAll("&f", ChatColor.WHITE+""));
		}
		GBD.GoldBigDragon_Advanced.Event.PlayerAction PA = new GBD.GoldBigDragon_Advanced.Event.PlayerAction();
		PA.PlayerChatting(event);
		return;
	}

	@EventHandler
	private void PlayerFishing(PlayerFishEvent event)
	{
		GBD.GoldBigDragon_Advanced.Event.Fishing F = new GBD.GoldBigDragon_Advanced.Event.Fishing();
		F.PlayerFishing(event);
		return;
	}
	
	@EventHandler
	private void Map(MapInitializeEvent event)
	{
		new GBD.GoldBigDragon_Advanced.ETC.Map().onMap(event);
		return;
	}
	
	@EventHandler
	private void PlayerDeath(PlayerDeathEvent event)
	{
		List<ItemStack> Ilist = event.getDrops();
		for(int count = 0; count < Ilist.size(); count++)
		{
			ItemStack IT = Ilist.get(count);
			if(IT.hasItemMeta() == true)
			{
				if(IT.getItemMeta().hasLore() == true)
				{
					if(IT.getItemMeta().getLore().size() >= 4)
					{
						if(IT.getItemMeta().getLore().get(3).equals(ChatColor.YELLOW+"[Ŭ���� �����Կ��� ����]")==true)
						{
							Ilist.set(count,new ItemStack(0));
						}
					}
				}
			}
		}
		return;
	}
	
	
	
	public void MagicSpellCatch()
	{
		if(MagicSpellsCatched == false)
		{
			MagicSpellsCatched = true;
			if(Bukkit.getPluginManager().isPluginEnabled("MagicSpells") == false)
			{
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������۰桡���");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������"); 
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "��������ᡡ���");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ᡡ����");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ᡡ����");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������ᡡ�����"); 
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[�÷��̿� ������ �����ϴ�]");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "MagicSpells �÷������� ã�� �� �����ϴ�!");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "MagicSpells �ٿ�ε� URL");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "http://nisovin.com/magicspells/Start");
			}
			else
			{
				OtherPlugins.SpellMain MS = new OtherPlugins.SpellMain(this);
			}
		}
		return;
	}
	
	public void CitizensCatch()
	{
		if(CitizensCatched == false)
		{
			CitizensCatched = true;
			if(Bukkit.getPluginManager().isPluginEnabled("Citizens") == false)
			{
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������۰桡���");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������"); 
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "��������ᡡ���");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ᡡ����");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ᡡ����");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������ᡡ�����"); 
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[�÷��̿� ������ �����ϴ�]");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Citizens �÷������� ã�� �� �����ϴ�!");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Citizens �ٿ�ε� URL");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "http://www.curse.com/bukkit-plugins/minecraft/citizens#t1:other-downloads");
			}
			else
			{
				OtherPlugins.CitizensMain CZ = new OtherPlugins.CitizensMain(this);
			}
		}
		return;
	}
	
	public void NoteBlockAPICatch()
	{
		if(Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI"))
			new OtherPlugins.NoteBlockAPIMain(this);
		return;
	}
	
	public void NoteBlockAPICatchPJ()
	{
		if(NoteBlockAPI == false)
		{
			NoteBlockAPI = true;
			if(Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI") == false)
			{
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������۰桡���");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������"); 
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "��������ᡡ���");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ᡡ����");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "�������ᡡ����");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������ᡡ�����"); 
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "������������");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[�÷��̿� ������ �����ϴ�]");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "��Ʈ��� ��� �÷������� ã�� �� �����ϴ�!");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "NoteBlockAPI �ٿ�ε� URL");
			  	  Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "http://www.curse.com/bukkit-plugins/minecraft/noteblockapi");
			}
			else
			{
				new OtherPlugins.NoteBlockAPIMain(this);
			}
		}
		return;
	}
	
	@EventHandler
	private void RA(EntityShootBowEvent event) {new GBD.GoldBigDragon_Advanced.Event.Attack().RangeAttack(event);return;}
    @EventHandler
    private void Attack(EntityDamageByEntityEvent event) {new GBD.GoldBigDragon_Advanced.Event.Attack().AttackRouter(event);return;}
    @EventHandler
	private void EntitySpawn(CreatureSpawnEvent event) {new GBD.GoldBigDragon_Advanced.Event.MonsterSpawn().EntitySpawn(event);return;}
    @EventHandler
    private void ITBlock(PlayerInteractEvent event)
    {
    	GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
    	ETC.UpdatePlayerHPMP(event.getPlayer());
    	new GBD.GoldBigDragon_Advanced.Event.Interact().PlayerInteract(event);
    	return;
    }
    @EventHandler
    private void ITEnity(PlayerInteractEntityEvent event)
    {
    	GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
    	ETC.UpdatePlayerHPMP(event.getPlayer());
    	CitizensCatch();
    	new GBD.GoldBigDragon_Advanced.Event.Interact().PlayerInteractEntity(event);
    	return;
    }
    @EventHandler
    private void ItemGetMessage(PlayerPickupItemEvent event) {new GBD.GoldBigDragon_Advanced.Event.Interact().PlayerGetItem(event);}
	@EventHandler
	private void MonsterKill(EntityDeathEvent event)	{new GBD.GoldBigDragon_Advanced.Event.MonsterKill().MonsterKill(event);return;}
	@EventHandler
	private void BBreak(BlockBreakEvent event)
	{
	    GBD.GoldBigDragon_Advanced.Event.BlockBreak BB = new GBD.GoldBigDragon_Advanced.Event.BlockBreak();
		BB.BlockBreaking(event);return;
	}
	@EventHandler
	private void BlockPlace(BlockPlaceEvent event){GBD.GoldBigDragon_Advanced.Event.BlockPlace BP = new GBD.GoldBigDragon_Advanced.Event.BlockPlace();BP.BlockPlace(event);return;}
	
	@EventHandler
	private void applyHealthRegen(EntityRegainHealthEvent event)
	{
		if (event.isCancelled())
			return;
		if (((event.getEntity() instanceof Player)) &&(event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED))
	    {
	    	GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
	    	ETC.UpdatePlayerHPMP((Player)event.getEntity());
	    }
		return;
	}
	
	@EventHandler
	private void InventoryClick(InventoryClickEvent event)
	{
		if(Bukkit.getPluginManager().isPluginEnabled("MagicSpells") == true
		&&MagicSpellsCatched==true)
		{
			GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
			ETC.UpdatePlayerHPMP((Player)event.getWhoClicked());
		}
		if(event.getClickedInventory() == null)
			return;
		if(event.getCurrentItem().hasItemMeta() == true)
		{
			if(event.getCurrentItem().getItemMeta().hasLore() == true)
			{
				if(event.getCurrentItem().getItemMeta().getLore().size() == 4)
				{
					if(event.getCurrentItem().getItemMeta().getLore().get(3).equals((ChatColor.YELLOW+"[Ŭ���� �����Կ��� ����]")))
					{
						event.setCancelled(true);
						event.getWhoClicked().getInventory().setItem(event.getSlot(), new ItemStack(0));
						GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
						s.SP((Player)event.getWhoClicked(), Sound.ANVIL_LAND, 1.0F, 1.9F);
					}
				}
			}
		}

		if(event.getInventory().getName().length() >= 3)
		{
			if(event.getInventory().getName().charAt(0)=='��'
			&&event.getInventory().getName().charAt(1)=='0')
			{
				String InventoryName = ChatColor.stripColor(event.getInventory().getName().toString());
				if(event.getInventory().getType()==InventoryType.CHEST)
				{
					if(!(InventoryName.equals("���� ��� ����")||InventoryName.equals("��ƾ� �� ������ ���")
					||InventoryName.equals("���� ������ ���")||InventoryName.equals("�ʽ��� ����")
					||InventoryName.equals("�ش� ����� ĳ�� ���� ������")||InventoryName.equals("���� �߰� ���")
					||InventoryName.equals("NPC �� ����")||InventoryName.equals("container.chest")
					||InventoryName.equals("container.chestDouble")||InventoryName.equals("�ʽ��� ���̵�")
					||InventoryName.equals("container.minecart")||InventoryName.equals("�̺�Ʈ ��ü ����")
					||InventoryName.equals("�̺�Ʈ ���� ����") ))
					{
						event.setCancelled(true);
					}
				}
				
				if(InventoryName.contains("����")||InventoryName.contains("�ɼ�")||InventoryName.contains("������")||
				   InventoryName.equals("��Ÿ")||InventoryName.contains("���̵�")||
				   InventoryName.contains("��Ƽ")||InventoryName.contains("NPC")
				   ||InventoryName.contains("����")||InventoryName.equals("�̺�Ʈ ����")
				   ||InventoryName.contains("���")||InventoryName.contains("����Ʈ")||
				   InventoryName.contains("������")||InventoryName.contains("���")||InventoryName.equals("������Ʈ �߰�")
				   ||InventoryName.contains("���")||InventoryName.contains("����")||InventoryName.contains("������")
				    ||InventoryName.contains("[MapleStory]")||InventoryName.contains("[Mabinogi]")
				    ||InventoryName.contains("��ų")||InventoryName.contains("��ũ")||InventoryName.contains("����")
				    ||InventoryName.contains("��ϵ�")||InventoryName.contains("������")||InventoryName.contains("�ʽ���")
				    ||InventoryName.contains("ī�װ�")||InventoryName.equals("�ش� ����� ĳ�� ���� ������")||InventoryName.contains("����")
				    ||InventoryName.contains("����")||InventoryName.contains("����")||InventoryName.contains("��������")
				    ||InventoryName.contains("�̺�Ʈ")||InventoryName.contains("ģ��")||InventoryName.contains("�׺�"))
				{
					GBD.GoldBigDragon_Advanced.Event.InventoryClick IC = new GBD.GoldBigDragon_Advanced.Event.InventoryClick();
					IC.InventoryClickRouter(event, InventoryName);
				}
			}
		}
		return;
	}
	
	@EventHandler
	private void InventoryClose(InventoryCloseEvent event)
	{

		if(Bukkit.getPluginManager().isPluginEnabled("MagicSpells") == true
		&&MagicSpellsCatched==true)
		{
			GBD.GoldBigDragon_Advanced.Util.ETC ETC = new GBD.GoldBigDragon_Advanced.Util.ETC();
			ETC.UpdatePlayerHPMP((Player)event.getPlayer());
		}
		new GBD.GoldBigDragon_Advanced.Event.InventoryClose().InventoryCloseRouter(event);
		return;
	}

	public boolean onCommand(CommandSender talker, Command command, String string, String[] args)
    {
		MagicSpellCatch();
    	CitizensCatch();
		for(int count = 0; count <args.length; count++)
		{
			if(args[count].contains("&"))
			{
				args[count]=args[count].replaceAll("&l", ChatColor.BOLD+"");
				args[count]=args[count].replaceAll("&0", ChatColor.BLACK+"");
				args[count]=args[count].replaceAll("&1", ChatColor.DARK_BLUE+"");
				args[count]=args[count].replaceAll("&2", ChatColor.DARK_GREEN+"");
				args[count]=args[count].replaceAll("&3", ChatColor.DARK_AQUA+"");
				args[count]=args[count].replaceAll("&4", ChatColor.DARK_RED+"");
				args[count]=args[count].replaceAll("&5", ChatColor.DARK_PURPLE+"");
				args[count]=args[count].replaceAll("&6", ChatColor.GOLD+"");
				args[count]=args[count].replaceAll("&7", ChatColor.GRAY+"");
				args[count]=args[count].replaceAll("&8", ChatColor.DARK_GRAY+"");
				args[count]=args[count].replaceAll("&9", ChatColor.BLUE+"");
				args[count]=args[count].replaceAll("&a", ChatColor.GREEN+"");
				args[count]=args[count].replaceAll("&b", ChatColor.AQUA+"");
				args[count]=args[count].replaceAll("&c", ChatColor.RED+"");
				args[count]=args[count].replaceAll("&d", ChatColor.LIGHT_PURPLE+"");
				args[count]=args[count].replaceAll("&e", ChatColor.YELLOW+"");
				args[count]=args[count].replaceAll("&f", ChatColor.WHITE+"");
			}
		}
		
		if(talker instanceof Player)
		{
			Player player = (Player) talker;
			GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();

			if(player.isOp() == true&&UserData.containsKey(player)==false)
				UserData.put(player, new UserDataObject(player));
			
			switch(string)
			{
			case"�׽�Ʈ":
				if(player.isOp() == true)
				{
					/*
				    for(int count= 0; count < GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.MobSpawningAreaList.size(); count++)
				    	player.sendMessage(ChatColor.GREEN+"���� ���� ���� ���� ���� : "+GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.MobSpawningAreaList.get(count));
				    for(int count= 0; count < GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.size(); count++)
				    {
				    	long UTC = Long.parseLong(GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.keySet().toArray()[count].toString());
				    	player.sendMessage(ChatColor.GREEN+"["+UTC+"] : "+GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.get(UTC).getType());
				    	player.sendMessage(ChatColor.GREEN+"["+UTC+"] : "+GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.get(UTC).getString((byte)0));
				    	player.sendMessage(ChatColor.GREEN+"["+UTC+"] : "+GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.get(UTC).getString((byte)1));
				    	player.sendMessage(ChatColor.GREEN+"["+UTC+"] : "+GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.get(UTC).getString((byte)2));
				    	player.sendMessage(ChatColor.GREEN+"["+UTC+"] : "+GBD.GoldBigDragon_Advanced.ServerTick.ServerTickMain.Schedule.get(UTC).getString((byte)3));
				    	player.sendMessage(ChatColor.BLUE+"��������������������������������������������������������");
				    }
				    */
				}
				else
				{
					talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
					s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
				}
				return true;
				case"gui���":
					if(player.isOp() == true)
					{
					 	s.SP((Player)talker, org.bukkit.Sound.VILLAGER_HAGGLE, 1.0F, 1.8F);
					    player.sendMessage(ChatColor.GREEN+"[NPC] : GUI�� Ȱ��ȭ ��ų NPC�� ��Ŭ�� �ϼ���!");
					    UserData.get(player).setInt((byte)4, 114);
					}
					else
					{
						talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
						s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
					}
					return true;
				case"ģ��":
				 	s.SP((Player)talker, org.bukkit.Sound.HORSE_SADDLE, 1.0F, 1.8F);
				 	new GBD.GoldBigDragon_Advanced.GUI.ETCGUI().FriendsGUI(player, 0);
					return true;
				case"��ų":
				 	s.SP((Player)talker, org.bukkit.Sound.HORSE_SADDLE, 1.0F, 1.8F);
				    GBD.GoldBigDragon_Advanced.GUI.PlayerSkillGUI PSKGUI = new GBD.GoldBigDragon_Advanced.GUI.PlayerSkillGUI();
					PSKGUI.MainSkillsListGUI(player, 0);
					return true;
				case "��ƼƼ����":
					if(args.length != 1 ||Integer.parseInt(args[0]) > 10000)
					{
						talker.sendMessage(ChatColor.RED + "[SYSTEM] : /��ƼƼ���� [1~10000]");
						s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
						return true;
					}
					if(player.isOp() == true)
					{
					    List<Entity> entities = player.getNearbyEntities(Integer.parseInt(args[0]), Integer.parseInt(args[0]), Integer.parseInt(args[0]));
					    int amount = 0;
					    for(int count = 0; count < entities.size(); count++)
					    {
					    	if(entities.get(count).getType() != EntityType.PLAYER &&entities.get(count).getType() != EntityType.ITEM_FRAME)
					    	{
					    		entities.get(count).remove();
					    		amount = amount+1;
					    	}
					    }
					    player.sendMessage(ChatColor.GREEN + "[SYSTEM] : �ݰ� "+args[0]+"��� �̳��� �ִ� "+amount+"������ ��ƼƼ�� �����Ͽ����ϴ�!");
					}
					else
					{
						talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
						s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
						return true;
					}
					return true;
				case "����������":
					if(args.length != 1 ||Integer.parseInt(args[0]) > 10000)
					{
						talker.sendMessage(ChatColor.RED + "[SYSTEM] : /���������� [1~10000]");
						s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
						return true;
					}
					if(player.isOp() == true)
					{
					    List<Entity> entities = player.getNearbyEntities(Integer.parseInt(args[0]), Integer.parseInt(args[0]), Integer.parseInt(args[0]));
					    int amount = 0;
					    for(int count = 0; count < entities.size(); count++)
					    {
					    	if(entities.get(count).getType() == EntityType.DROPPED_ITEM)
					    	{
					    		entities.get(count).remove();
					    		amount = amount+1;
					    	}
					    }
					    player.sendMessage(ChatColor.GREEN + "[SYSTEM] : �ݰ� "+args[0]+"��� �̳��� �ִ� "+amount+"���� �������� �����Ͽ����ϴ�!");
					}
					else
					{
						talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
						s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
						return true;
					}
					return true;
		  		case "������" :
		  			GBD.GoldBigDragon_Advanced.Command.ItemsCommand ItemC = new GBD.GoldBigDragon_Advanced.Command.ItemsCommand();
		  			if(args.length <= 0)
		  			{
		  				if(args.length <=0)
		  				{
		  					GBD.GoldBigDragon_Advanced.Command.HelpMessage HM = new GBD.GoldBigDragon_Advanced.Command.HelpMessage();
			  				HM.HelpMessager(player, 1);
			  				return true;	
		  				}
		  				if(ChatColor.stripColor(args[0]).equalsIgnoreCase("��������") ==true)
		  				 ItemC.onCommand2(talker, command, string, args);
		  				else
		  				{
		  					GBD.GoldBigDragon_Advanced.Command.HelpMessage HM = new GBD.GoldBigDragon_Advanced.Command.HelpMessage();
			  				HM.HelpMessager(player, 1);
			  				return true;	
		  				}
		  			}
		  			 if(ChatColor.stripColor(args[0]).equalsIgnoreCase("���") == false&& ChatColor.stripColor(args[0]).equalsIgnoreCase("���") == false&& ChatColor.stripColor(args[0]).equalsIgnoreCase("����") == false&& ChatColor.stripColor(args[0]).equalsIgnoreCase("�ޱ�") == false&&ChatColor.stripColor(args[0]).equalsIgnoreCase("�ֱ�") == false)
		  				 ItemC.onCommand2(talker, command, string, args);
		  			 else
				  		ItemC.onCommand1(talker, command, string, args);
		  			break;
		  		case "��Ƽ":
		  			GBD.GoldBigDragon_Advanced.Command.PartyCommand PartyC = new GBD.GoldBigDragon_Advanced.Command.PartyCommand();
		  			PartyC.onCommand(talker, command, string, args);
		  			return true;
		  		case "��":
				 	s.SP((Player)talker, org.bukkit.Sound.LAVA_POP, 0.8F, 1.8F);
				 	YamlManager YM = Main_YC.getNewConfig("Stats/" + player.getUniqueId()+".yml");
				 	player.sendMessage(ChatColor.YELLOW + "[���� ���� �ݾ�] " + ChatColor.YELLOW+ChatColor.BOLD +"" +YM.getInt("Stat.Money") + " "+ServerOption.Money);
					return true;
		  		case "����":
		  			GBD.GoldBigDragon_Advanced.GUI.StatsGUI sgui = new GBD.GoldBigDragon_Advanced.GUI.StatsGUI();
				 	s.SP((Player)talker, org.bukkit.Sound.HORSE_ARMOR, 0.8F, 1.8F);
				 	sgui.StatusGUI((Player)talker);
					return true;
		  		case "�ɼ�":
		  			GBD.GoldBigDragon_Advanced.GUI.OptionGUI ogui = new GBD.GoldBigDragon_Advanced.GUI.OptionGUI();
				 	s.SP((Player)talker, org.bukkit.Sound.HORSE_ARMOR, 0.8F, 1.8F);
				 	ogui.optionGUI((Player)talker);
					return true;
		  		case "��Ÿ":
		  			GBD.GoldBigDragon_Advanced.GUI.ETCGUI egui = new GBD.GoldBigDragon_Advanced.GUI.ETCGUI();
				 	s.SP((Player)talker, org.bukkit.Sound.HORSE_ARMOR, 0.8F, 1.8F);
				 	egui.ETCGUI_Main((Player) talker);
					return true;
		  		case "���ǹڽ�":
					  if(talker.isOp() == true)
					  {
						  Main.UserData.get(player).clearAll();
				  		  GBD.GoldBigDragon_Advanced.GUI.OPBoxGUI opgui = new GBD.GoldBigDragon_Advanced.GUI.OPBoxGUI();
						  s.SP((Player)talker, org.bukkit.Sound.HORSE_ARMOR, 0.8F, 1.8F);
						  opgui.OPBoxGUI_Main((Player)talker,1);
						  return true;
					  }
					  else
					  {
						  talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
						  s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
						  return true;
					  }
		  		case "����" :
					  s.SP((Player)talker, org.bukkit.Sound.HORSE_ARMOR, 0.8F, 1.8F);
		  			new GBD.GoldBigDragon_Advanced.GUI.MonsterGUI().MonsterListGUI(player, 0);
		  			return true;
		  		case "����":
		  			GBD.GoldBigDragon_Advanced.Command.WarpCommand WarpC = new GBD.GoldBigDragon_Advanced.Command.WarpCommand();
		  			WarpC.onCommand(talker, command, string, args);
		  			return true;
		  		case "����":
		  			GBD.GoldBigDragon_Advanced.Command.AreaCommand AreaC = new GBD.GoldBigDragon_Advanced.Command.AreaCommand();
		  			AreaC.onCommand(talker, command, string, args);
		  			return true;
		  		case "����":
		  			GBD.GoldBigDragon_Advanced.Command.NPCcommand NPCC = new GBD.GoldBigDragon_Advanced.Command.NPCcommand();
		  			NPCC.onCommand(talker, command, string, args);
		  			return true;
		  		case "����Ʈ":
		  			GBD.GoldBigDragon_Advanced.Command.QuestCommand QC = new GBD.GoldBigDragon_Advanced.Command.QuestCommand();
		  			QC.onCommand(talker, command, string, args);
		  			return true;
		  		case "Ŀ�ǵ�":
		  			if(player.isOp() == true)
		  			{
		  				if(UserData.containsKey(player)==false)
		  				{
		  					UserData.put(player, new UserDataObject(player));
		  					player.sendMessage(ChatColor.RED+"[��ų ����] : ��ų ������ ���� Ŀ�ǵ� �Դϴ�!");
							s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
		  					return true;
		  				}
						if(UserData.get(player).getType().equals("Skill"))
						{
							if(UserData.get(player).getString((byte)1).equalsIgnoreCase("SKC"))
							{
								String CommandString = "";
								for(int count = 0; count <args.length-1; count ++)
									CommandString = CommandString+args[count]+" ";
								CommandString = CommandString+args[args.length-1];
								YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
								YamlManager SkillList  = GUI_YC.getNewConfig("Skill/SkillList.yml");
								if(CommandString.contains("/")==false)
									CommandString = "/"+CommandString;
								if(CommandString.equalsIgnoreCase("/����"))
									SkillList.set(UserData.get(player).getString((byte)2)+".SkillRank."+UserData.get(player).getInt((byte)4)+".Command","null");
								else
									SkillList.set(UserData.get(player).getString((byte)2)+".SkillRank."+UserData.get(player).getInt((byte)4)+".Command",CommandString);
								SkillList.saveConfig();
								GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI SKGUI = new GBD.GoldBigDragon_Advanced.GUI.OPBoxSkillGUI();
								SKGUI.SkillRankOptionGUI(player, UserData.get(player).getString((byte)2), UserData.get(player).getInt((byte)4));
								UserData.get(player).clearAll();
							}
						}
						else
						{
		  					player.sendMessage(ChatColor.RED+"[��ų ����] : ��ų ������ ���� Ŀ�ǵ� �Դϴ�!");
							s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
		  					return true;
						}
		  			}
					else
					{
						talker.sendMessage(ChatColor.RED + "[SYSTEM] : �ش� ��ɾ �����ϱ� ���ؼ��� ������ ������ �ʿ��մϴ�!");
						s.SP((Player)talker, org.bukkit.Sound.ORB_PICKUP, 2.0F, 1.7F);
					}
					return true;
			}
			return false;
		}
		else
		{
			
		}
		return false;
    }

}