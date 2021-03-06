﻿package com.goldbigdragon.rpg.etc;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;

import com.goldbigdragon.rpg.Main;
import com.goldbigdragon.rpg.util.YamlManager;
import com.goldbigdragon.rpg.util.YamlController;

public class MapList extends MapRenderer
{
	@Override
	public void render(MapView MV, MapCanvas MC, Player player)
	{
		if(Main.Mapping==true)
		{
			Main.Mapping = false;
			String URL = "null";
			int Xcenter = 0;
			int Ycenter  = 0;

			YamlController Config_YC = Main.Config_YC;
			YamlManager MapConfig=Config_YC.getNewConfig("MapImageURL.yml");
			if(Config_YC.isExit("MapImageURL.yml") == false)
				new com.goldbigdragon.rpg.config.configConfig().CreateMapImageConfig(Config_YC);
			String Name = Main.UserData.get(player).getString((byte)1);
			URL = MapConfig.getString(Name+".URL");
			Xcenter = MapConfig.getInt(Name+".Xcenter");
			Ycenter = MapConfig.getInt(Name+".Ycenter");
			Main.UserData.get(player).clearAll();
			if(URL=="null")
				return;
			else
			{
				try
				{
					MC.drawImage(Xcenter, Ycenter, ImageIO.read(new URL(URL)));
					return;
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
