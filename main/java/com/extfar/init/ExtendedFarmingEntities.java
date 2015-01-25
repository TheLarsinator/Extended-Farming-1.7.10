package com.extfar.init;

import com.extfar.core.ExtendedFarming;
import com.extfar.tractor.EntityTractor;
import com.extfar.tractor.entity.EntityPlow;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ExtendedFarmingEntities 
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityTractor.class, "tractor", EntityRegistry.findGlobalUniqueEntityId(), ExtendedFarming.instance, 80, 10, true);
		EntityRegistry.registerModEntity(EntityPlow.class, "plow", EntityRegistry.findGlobalUniqueEntityId(), ExtendedFarming.instance, 80, 10, true);
	}

}
