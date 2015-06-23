package com.extfar.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.extfar.animals.entity.EntityGoat;
import com.extfar.core.ExtendedFarming;
import com.extfar.items.ItemCreatureEgg;
import com.extfar.tractor.EntityTractor;
import com.extfar.tractor.entity.EntityPlow;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExtendedFarmingEntities 
{
	private static int modEntityID = 0;

	public static void init()
	{
		String mobid = "extfar_";
		
		EntityRegistry.registerModEntity(EntityTractor.class, "tractor", EntityRegistry.findGlobalUniqueEntityId(), ExtendedFarming.instance, 80, 10, true);
		EntityRegistry.registerModEntity(EntityPlow.class, "plow", EntityRegistry.findGlobalUniqueEntityId(), ExtendedFarming.instance, 80, 10, true);
		
		registerModEntityWithEgg(EntityGoat.class, "Goat", 0xb1b1b1, 0x423424);
        EntityRegistry.addSpawn(EntityGoat.class, 15, 5, 15, EnumCreatureType.creature, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.jungleHills, BiomeGenBase.iceMountains, BiomeGenBase.taigaHills});
        EntityRegistry.addSpawn(EntityGoat.class, 15, 3, 5, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.HILLS));
	}
	
    // can't use vanilla spawn eggs with entities registered with modEntityID, so use custom eggs.
    // name passed must match entity name string
    public static void registerSpawnEgg(String parSpawnName, int parEggColor, int parEggSpotsColor)
    {
      Item itemSpawnEgg = new ItemCreatureEgg(parSpawnName, parEggColor, parEggSpotsColor).setUnlocalizedName("spawn_egg_"+parSpawnName.toLowerCase()).setTextureName("extfar:spawn_egg").setCreativeTab(ExtendedFarming.ItemsTab);
      GameRegistry.registerItem(itemSpawnEgg, "spawnEgg"+parSpawnName);
    }
    
    public static void registerModEntityWithEgg(Class parEntityClass, String parEntityName, int parEggColor, int parEggSpotsColor)
    {
    	EntityRegistry.registerGlobalEntityID(parEntityClass, parEntityName, EntityRegistry.findGlobalUniqueEntityId(), parEggColor, parEggSpotsColor);
		//EntityRegistry.registerModEntity(parEntityClass, parEntityName, ++modEntityID , ExtendedFarming.instance, 80, 3, false);
        //registerSpawnEgg(parEntityName, parEggColor, parEggSpotsColor);
    }

}
