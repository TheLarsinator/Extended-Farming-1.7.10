package com.extfar.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.extfar.blocks.BlockCropSupport;
import com.extfar.blocks.BlockMyCrops;
import com.extfar.blocks.nether.BlockFarmSoulSand;
import com.extfar.blocks.nether.hose.BlockActiveNetherHose;
import com.extfar.blocks.nether.hose.BlockNetherHose;
import com.extfar.blocks.nether.hose.BlockPassiveNetherHose;
import com.extfar.blocks.nether.hose.TileEntityActiveNetherHose;
import com.extfar.blocks.nether.hose.TileEntityNetherHose;
import com.extfar.blocks.nether.hose.TileEntityPassiveNetherHose;
import com.extfar.blocks.nether.pump.BlockNetherPump;
import com.extfar.blocks.nether.pump.TileEntityNetherPump;
import com.extfar.blocks.nether.sprayer.BlockActiveNetherSprayer;
import com.extfar.blocks.nether.sprayer.BlockNetherSprayer;
import com.extfar.blocks.nether.sprayer.TileEntityActiveNetherSprayer;
import com.extfar.blocks.nether.sprayer.TileEntityNetherSprayer;
import com.extfar.blocks.overworld.hose.BlockActiveHose;
import com.extfar.blocks.overworld.hose.BlockHose;
import com.extfar.blocks.overworld.hose.BlockPassiveHose;
import com.extfar.blocks.overworld.hose.TileEntityActiveHose;
import com.extfar.blocks.overworld.hose.TileEntityHose;
import com.extfar.blocks.overworld.hose.TileEntityPassiveHose;
import com.extfar.blocks.overworld.pump.BlockPump;
import com.extfar.blocks.overworld.pump.TileEntityPump;
import com.extfar.blocks.overworld.sprayer.BlockActiveSprayer;
import com.extfar.blocks.overworld.sprayer.BlockSprayer;
import com.extfar.blocks.overworld.sprayer.TileEntityActiveSprayer;
import com.extfar.blocks.overworld.sprayer.TileEntitySprayer;
import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtendedFarmingBlocks 
{
	private static String modid = ExtendedFarming.modid;
	//CropSupport
	public static Block BambooSticks;
	public static Block Net;
	
	
	//WateringSystem
	public static Block Hose;
	public static Block ActiveHose;
	public static Block PassiveHose;
	public static Block Pump;
	public static Block Sprayer;
	public static Block ActiveSprayer;
	
	//LavaSystem
	public static Block NetherHose;
	public static Block ActiveNetherHose;
	public static Block PassiveNetherHose;
	public static Block NetherPump;
	public static Block NetherSprayer;
	public static Block ActiveNetherSprayer;
	public static Block FarmSoulSand;
	
	//Crops
	public static Block Beans;
	public static Block Peas;
	public static Block ChilliPepper;
	
	public static Block NetherBeans;
	public static Block NetherPeas;
	public static Block NetherPeppers;
	
	public static Block NetherPotatoes;
	public static Block NetherCarrots;
	public static Block NetherWheat;
	
	public static Block Rice;
	
	public static void init()
	{

		BambooSticks = new BlockCropSupport(Material.plants, 6, 1).setBlockTextureName("BambooSticks").setBlockName("BambooSticks");
		Net = new BlockCropSupport(Material.plants, 6, 2).setBlockTextureName("Net").setBlockName("Net");
		
		Hose = new BlockHose(Material.wood).setBlockName("Hose").setBlockTextureName("Hose");
		ActiveHose = new BlockActiveHose(Material.wood).setBlockName("ActiveHose").setBlockTextureName("ActiveHose");
		PassiveHose = new BlockPassiveHose(Material.wood).setBlockName("PassiveHose").setBlockTextureName("Hose");
		Pump = new BlockPump(Material.iron).setBlockName("Pump").setBlockTextureName("Pump");
		Sprayer = new BlockSprayer(Material.wood).setBlockName("Sprayer").setBlockTextureName("Sprayer");
		ActiveSprayer = new BlockActiveSprayer(Material.water).setBlockName("ActiveSprayer").setBlockTextureName("Sprayer");
		
		NetherHose = new BlockNetherHose(Material.wood).setBlockName("NetherHose").setBlockTextureName("NetherHose");
		ActiveNetherHose = new BlockActiveNetherHose(Material.wood).setBlockName("ActiveNetherHose").setBlockTextureName("ActiveNetherHose");
		PassiveNetherHose = new BlockPassiveNetherHose(Material.wood).setBlockName("PassiveNetherHose").setBlockTextureName("NetherHose");
		NetherPump = new BlockNetherPump(Material.iron).setBlockName("NetherPump").setBlockTextureName("NetherPump");
		NetherSprayer = new BlockNetherSprayer(Material.wood).setBlockName("NetherSprayer").setBlockTextureName("NetherSprayer");
		ActiveNetherSprayer = new BlockActiveNetherSprayer(Material.lava).setBlockName("ActiveNetherSprayer").setBlockTextureName("NetherSprayer");
		FarmSoulSand = new BlockFarmSoulSand().setBlockName("FarmSoulSand").setBlockTextureName("FarmSoulSand");
		
		Beans = new BlockMyCrops(1, 1, 6, 4, 1).setBlockName("Beans").setBlockTextureName("Beans");
		Peas = new BlockMyCrops(2, 2, 6, 4, 2).setBlockName("Peas").setBlockTextureName("Peas");
		ChilliPepper = new BlockMyCrops(3, 3, 6, 4, 1).setBlockName("ChilliPepper").setBlockTextureName("ChilliPepper");
		
		NetherBeans = new BlockMyCrops(101, 1, 6, 4, 1).setBlockName("NetherBeans").setBlockTextureName("Beans");
		NetherPeas = new BlockMyCrops(102, 2, 6, 4, 2).setBlockName("NetherPeas").setBlockTextureName("Peas");
		NetherPeppers = new BlockMyCrops(103, 3, 6, 4, 1).setBlockName("NetherPepper").setBlockTextureName("ChilliPepper");

		NetherPotatoes = new BlockMyCrops(104, 4, 6, 4, 0).setBlockName("NetherBeans").setBlockTextureName("Potato");
		NetherCarrots = new BlockMyCrops(105, 5, 6, 4, 0).setBlockName("NetherPeas").setBlockTextureName("Carrot");
		NetherWheat = new BlockMyCrops(106, 6, 6, 4, 0).setBlockName("NetherPepper").setBlockTextureName("Wheat");
		
		
		
		GameRegistry.registerBlock(BambooSticks, "BambooSticks");
		GameRegistry.registerBlock(Net, "Net");

		GameRegistry.registerBlock(Hose, "Hose");
	    GameRegistry.registerTileEntity(TileEntityHose.class, "HoseTE");
		GameRegistry.registerBlock(ActiveHose, "ActiveHose");
	    GameRegistry.registerTileEntity(TileEntityActiveHose.class, "ActiveHoseTE");
		GameRegistry.registerBlock(PassiveHose, "PassiveHose");
	    GameRegistry.registerTileEntity(TileEntityPassiveHose.class, "PassiveHoseTE");
		GameRegistry.registerBlock(Pump, "Pump");
	    GameRegistry.registerTileEntity(TileEntityPump.class, "PumpTE");
		GameRegistry.registerBlock(Sprayer, "Sprayer");
	    GameRegistry.registerTileEntity(TileEntitySprayer.class, "SprayerTE");
		GameRegistry.registerBlock(ActiveSprayer, "ActiveSprayer");
	    GameRegistry.registerTileEntity(TileEntityActiveSprayer.class, "ActiveSprayerTE");
	    
		GameRegistry.registerBlock(NetherHose, "NetherHose");
	    GameRegistry.registerTileEntity(TileEntityNetherHose.class, "NetherHoseTE");
		GameRegistry.registerBlock(ActiveNetherHose, "ActiveNetherHose");
	    GameRegistry.registerTileEntity(TileEntityActiveNetherHose.class, "ActiveNetherHoseTE");
		GameRegistry.registerBlock(PassiveNetherHose, "PassiveNetherHose");
	    GameRegistry.registerTileEntity(TileEntityPassiveNetherHose.class, "PassiveNetherHoseTE");
		GameRegistry.registerBlock(NetherPump, "NetherPump");
	    GameRegistry.registerTileEntity(TileEntityNetherPump.class, "NetherPumpTE");
		GameRegistry.registerBlock(NetherSprayer, "NetherSprayer");
	    GameRegistry.registerTileEntity(TileEntityNetherSprayer.class, "NetherSprayerTE");
		GameRegistry.registerBlock(ActiveNetherSprayer, "ActiveNetherSprayer");
	    GameRegistry.registerTileEntity(TileEntityActiveNetherSprayer.class, "ActiveNetherSprayerTE");
		GameRegistry.registerBlock(FarmSoulSand, "FarmSoulSand");


		GameRegistry.registerBlock(Beans, "Beans");
		GameRegistry.registerBlock(Peas, "Peas");
		GameRegistry.registerBlock(ChilliPepper, "ChilliPepper");
		
		GameRegistry.registerBlock(NetherBeans, "NetherBeans");
		GameRegistry.registerBlock(NetherPeas, "NetherPeas");
		GameRegistry.registerBlock(NetherPeppers, "NetherPeppers");
		GameRegistry.registerBlock(NetherPotatoes, "NetherPotatoes");
		GameRegistry.registerBlock(NetherCarrots, "NetherCarrots");
		GameRegistry.registerBlock(NetherWheat, "NetherWheat");
		/*Rice = new BlockMyWaterCrops(ExtendedFarmingItems.RiceSeeds, ExtendedFarmingItems.Rice, 6, 4).setHardness(0.1F).setBlockName("RicePlant");

		GameRegistry.registerBlock(Rice, "RiceBlock");
		 */	
	}
}
