package com.extfar.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.extfar.animals.entity.EntityGoat;
import com.extfar.core.ExtendedFarming;
import com.extfar.tractor.EntityTractor;
import com.extfar.tractor.entity.EntityPlow;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ExtendedFarmingEntities 
{
	public static void init()
	{
		String mobid = "extfar_";
		
		EntityRegistry.registerModEntity(EntityTractor.class, "tractor", EntityRegistry.findGlobalUniqueEntityId(), ExtendedFarming.instance, 80, 10, true);
		EntityRegistry.registerModEntity(EntityPlow.class, "plow", EntityRegistry.findGlobalUniqueEntityId(), ExtendedFarming.instance, 80, 10, true);
		
        EntityRegistry.registerGlobalEntityID(EntityGoat.class, mobid + "Goat", EntityRegistry.findGlobalUniqueEntityId(), 0xb1b1b1, 0x423424);
        EntityRegistry.addSpawn(EntityGoat.class, 15, 5, 15, EnumCreatureType.creature, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.jungleHills, BiomeGenBase.iceMountains, BiomeGenBase.taigaHills});
        EntityRegistry.addSpawn(EntityGoat.class, 15, 3, 5, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.HILLS));
	}

}
