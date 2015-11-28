package com.goldbigdragon.rpg.config;

import com.goldbigdragon.rpg.Main;
import org.bukkit.entity.Player;

import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;

public class QuestConfig
{
    public void CreateNewQuestConfig()
	{
	    YamlManager QuestConfig;
		YamlController Config_YC = Main.Config_YC;
		QuestConfig=Config_YC.getNewConfig("Quest/QuestList.yml");

    	if(Config_YC.isExit("Quest/QuestList.yml")==false)
    	{
    		QuestConfig.set("Do_not_Touch_This", true);
    		QuestConfig.saveConfig();
    	}
	  	return;
	}
    public void CreateNewPlayerConfig(Player player)
	{
	    YamlManager QuestConfig;
		YamlController Location_YC = Main.Location_YC;
		QuestConfig=Location_YC.getNewConfig("Quest/PlayerData/"+player.getUniqueId()+".yml");

		QuestConfig.set("PlayerName", player.getName());
		QuestConfig.set("PlayerUUID", player.getUniqueId().toString());
		QuestConfig.set("Started.1", null);
		QuestConfig.set("Ended.1", null);
		QuestConfig.saveConfig();
	  	return;
	}
	
}
