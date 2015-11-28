﻿package com.goldbigdragon.rpg.custom;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSkeleton;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.goldbigdragon.rpg.Main;
import com.goldbigdragon.rpg.util.YamlController;
import com.goldbigdragon.rpg.util.YamlManager;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.World;

import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_8_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_8_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_8_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_8_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_8_R3.PathfinderGoalRandomStroll;

public class AI_Hunter extends EntitySkeleton
{
	public AI_Hunter(World world)
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
	        
	        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
	        if(AI.equals("선공"))
		        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, false, true));

			Main.SpawnMobName = null;
		}
	}
	

	public static Skeleton spawn(Location location)
	{
		World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
		final AI_Hunter customEntity = new AI_Hunter(mcWorld);
		customEntity.setLocation(location.getX(), location.getY(),
				location.getZ(), location.getYaw(), location.getPitch());
		((CraftLivingEntity) customEntity.getBukkitEntity())
				.setRemoveWhenFarAway(true);
		mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
		return (CraftSkeleton) customEntity.getBukkitEntity();
	}
}