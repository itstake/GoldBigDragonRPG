﻿package com.goldbigdragon.rpg.custom;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.Creeper;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.goldbigdragon.rpg.Main;
import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;
import net.minecraft.server.v1_8_R3.EntityCreeper;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.World;

import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_8_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_8_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_8_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_8_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_8_R3.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;

public class AI_KamiKaze extends EntityCreeper
{
	public AI_KamiKaze(World world)
	{
		super(world);
		
		if(Main.SpawnMobName != null)
		{
			YamlController Monster_YC = Main.Monster_YC;
			YamlManager Monster  = Monster_YC.getNewConfig("Monster/MonsterList.yml");
			String AI = Monster.getString(Main.SpawnMobName + ".AI");

	        this.goalSelector.a(0, new PathfinderGoalFloat(this));
	        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
	        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
	        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
	        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
	        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
	        
	        if(AI.equals("자폭 선공"))
	        	this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true, true));
	        else
	        {
		        List targetB = (List)NMSUtils.getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
		        List targetC = (List)NMSUtils.getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
	        }
	        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
			Main.SpawnMobName = null;
		}
	}
	
	public static Creeper spawn(Location location)
	{
		World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
		final AI_KamiKaze customEntity = new AI_KamiKaze(mcWorld);
		customEntity.setLocation(location.getX(), location.getY(),
				location.getZ(), location.getYaw(), location.getPitch());
		((CraftLivingEntity) customEntity.getBukkitEntity())
				.setRemoveWhenFarAway(true);
		mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
		return (Creeper) customEntity.getBukkitEntity();
	}
}