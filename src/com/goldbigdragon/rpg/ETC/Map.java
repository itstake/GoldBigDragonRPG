package com.goldbigdragon.rpg.etc;

import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import com.goldbigdragon.rpg.Main;

public class Map
{
	public void onMap(MapInitializeEvent event)
	{
		if(Main.Mapping)
		{
			MapView MV = event.getMap();
			for(MapRenderer MR : MV.getRenderers())
				MV.removeRenderer(MR);
			MV.addRenderer(new MapList());
			return;
		}
	}
}
