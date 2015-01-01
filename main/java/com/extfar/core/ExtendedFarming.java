package com.extfar.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.extfar.core.handler.ConfigHandler;
import com.extfar.init.ExtendedFarmingAchievementsBook;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;
import com.extfar.init.ExtendedFarmingRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = "extfar", name = "ExtendedFarming", version = "1.7.10-1.0", guiFactory = "com.extfar.core.ExtendedFarmingGUIFactory")

public class ExtendedFarming
{
	public static String modid = "extfar";	
	@SidedProxy(clientSide = "com.extfar.core.ExtendedFarmingClient", serverSide = "com.extfar.core.ExtendedFarmingProxy")
	public static ExtendedFarmingProxy proxy;

	@Mod.Instance("extfar")
	public static ExtendedFarming instance;	
	
	public static CreativeTabs ItemsTab = new MyItemsTab(CreativeTabs.getNextID(),"ExtendedFarmingItems");

	//PreInit
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{    
	 ConfigHandler.LoadFile(event.getSuggestedConfigurationFile());

     ExtendedFarmingBlocks.init();
     ExtendedFarmingItems.init();
     ExtendedFarmingAchievementsBook.init();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{	
		ExtendedFarmingRecipes.RecipeBook();
		proxy.registerRenderInformation();
     	
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.BeanSeeds, 0, 1, 4, 10));
     	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.PeaSeeds, 0, 1, 4, 10));
	}
}
