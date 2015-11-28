package com.goldbigdragon.rpg.event;

import com.goldbigdragon.rpg.Main;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;

public class MonsterSpawn
{
	public void EntitySpawn(CreatureSpawnEvent event)
	{
	    YamlController Monster_YC= Main.Monster_YC;
	    YamlManager Config = Monster_YC.getNewConfig("config.yml");
		if(Config.getString("Server.EntitySpawn") == "false")
		{
			event.setCancelled(true);
			return;
		}
		com.goldbigdragon.rpg.etc.Area A = new com.goldbigdragon.rpg.etc.Area();

		String[] Area = A.getAreaName(event.getEntity());
		if(Area != null)
		{
			if(A.getAreaOption(Area[0], (char) 3) == false)
			{
				event.setCancelled(true);
				return;
			}
			YamlManager AreaList = Monster_YC.getNewConfig("Area/AreaList.yml");
			YamlManager Monster  = Monster_YC.getNewConfig("Monster/MonsterList.yml");
			String AreaName = A.getAreaName(event.getEntity())[0];
			Object[] MobNameList = AreaList.getConfigurationSection(AreaName+".Monster").getKeys(false).toArray();
			boolean isExit = false;
			for(int count = 0;count<10;count++)
			{
				if(isExit==true) break;
				if(MobNameList.length != 0)
				{
					int RandomMob = new com.goldbigdragon.rpg.util.Number().RandomNum(0, MobNameList.length-1);
					if(Monster.contains(MobNameList[RandomMob].toString()) == true)
					{
						new com.goldbigdragon.rpg.etc.Monster().SpawnMob(event.getLocation(), MobNameList[RandomMob].toString());
						if(Main.spawntime==true)
							event.setCancelled(true);
						isExit = true;
					}
					else
					{
						AreaList.removeKey(AreaName+".Monster."+MobNameList[RandomMob]);
						AreaList.saveConfig();
					}
				}
				else
				{
					break;
				}
			}
		}
		if(event.getEntity().getWorld().getName().equalsIgnoreCase("Dungeon") == true)
		{
			if(event.getSpawnReason()== SpawnReason.NATURAL || event.getSpawnReason() == SpawnReason.CHUNK_GEN
					|| event.getSpawnReason() == SpawnReason.MOUNT|| event.getSpawnReason() == SpawnReason.JOCKEY)
			{
				event.setCancelled(true);
				return;
			}
		}
		new com.goldbigdragon.rpg.etc.Monster().SpawnEffect(event.getEntity(),event.getLocation(), Config.getInt("Server.MonsterSpawnEffect"));
		return;
	}
}
