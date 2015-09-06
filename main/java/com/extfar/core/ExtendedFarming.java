package com.extfar.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import com.extfar.core.handler.ConfigHandler;
import com.extfar.core.handler.ExtendedFarmingEventHandler;
import com.extfar.core.handler.GuiHandler;
import com.extfar.init.ExtendedFarmingAchievementsBook;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingEntities;
import com.extfar.init.ExtendedFarmingItems;
import com.extfar.init.ExtendedFarmingRecipes;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod (modid = "extfar", name = "ExtendedFarming", version = "1.7.10-6.0", guiFactory = "com.extfar.core.ExtendedFarmingGUIFactory")

public class ExtendedFarming
{
	public static String modid = "extfar";	
	@SidedProxy(clientSide = "com.extfar.core.ExtendedFarmingClient", serverSide = "com.extfar.core.ExtendedFarmingProxy")
	public static ExtendedFarmingProxy proxy;

	@Mod.Instance("extfar")
	public static ExtendedFarming instance;	
	
	public static CreativeTabs ItemsTab = new MyItemsTab(CreativeTabs.getNextID(),"ExtendedFarmingItems");

	public static ToolMaterial Quartz = EnumHelper.addToolMaterial("QUARTZ", 1, 200, 5.0F, 2, 8);

	//PreInit
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{    
	 ConfigHandler.LoadFile(event.getSuggestedConfigurationFile());

	 ExtendedFarmingEntities.init();

     ExtendedFarmingBlocks.init();
     ExtendedFarmingItems.init();
     ExtendedFarmingAchievementsBook.init();
     
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{	
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		ExtendedFarmingRecipes.RecipeBook();
		proxy.registerRenderInformation();
     	
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.BeanSeeds, 0, 1, 4, 10));
     	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.PeaSeeds, 0, 1, 4, 10));
     	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.ChilliPepperSeeds, 0, 1, 4, 10));
     	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.SugarBeets, 0, 1, 4, 10));
     	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(ExtendedFarmingItems.Beets, 0, 1, 4, 10));
     	
     	MinecraftForge.EVENT_BUS.register(new ExtendedFarmingEventHandler());
     	FMLCommonHandler.instance().bus().register(new ExtendedFarmingEventHandler());
	}
}
