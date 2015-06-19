package com.extfar.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.extfar.blocks.BlockCropSupport;
import com.extfar.blocks.BlockMyCrops;
import com.extfar.blocks.milking.BlockCheeseBarrel;
import com.extfar.blocks.milking.BlockGoatCheese;
import com.extfar.blocks.milking.BlockMilkLiquid;
import com.extfar.blocks.milking.BlockMilkingStation;
import com.extfar.blocks.milking.TileEntityCheeseBarrel;
import com.extfar.blocks.milking.TileEntityMilkingStation;
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
	public static Block SugarBeet;
	public static Block Beets;
	
	public static Block NetherBeans;
	public static Block NetherPeas;
	public static Block NetherPeppers;
	public static Block NetherBeets;
	
	public static Block NetherPotatoes;
	public static Block NetherCarrots;
	public static Block NetherWheat;
	
	public static Block Rice;
	
	public static Block MilkingStation;
	public static Fluid MilkFluid;
	public static Block MilkLiquid;
	public static Block CheeseBarrel;
	public static Block GoatCheese;
	
	public static void init()
	{

		BambooSticks = new BlockCropSupport(Material.plants, 6, 1).setBlockTextureName("BambooSticks").setBlockName("BambooSticks");
		Net = new BlockCropSupport(Material.plants, 6, 2).setBlockTextureName("Net").setBlockName("Net");
		
		Hose = new BlockHose(Material.wood).setBlockName("Hose").setBlockTextureName("Hose");
		ActiveHose = new BlockActiveHose(Material.wood).setBlockName("ActiveHose").setBlockTextureName("ActiveHose");
		PassiveHose = new BlockPassiveHose(Material.wood).setBlockName("PassiveHose").setBlockTextureName("Hose");
		Pump = new BlockPump(Material.iron).setBlockName("Pump").setBlockTextureName("Pump").setHardness(1.3F);
		Sprayer = new BlockSprayer(Material.wood).setBlockName("Sprayer").setBlockTextureName("Sprayer").setHardness(1.3F);
		ActiveSprayer = new BlockActiveSprayer(Material.water).setBlockName("ActiveSprayer").setBlockTextureName("Sprayer").setHardness(1.3F);
		
		NetherHose = new BlockNetherHose(Material.wood).setBlockName("NetherHose").setBlockTextureName("NetherHose");
		ActiveNetherHose = new BlockActiveNetherHose(Material.wood).setBlockName("ActiveNetherHose").setBlockTextureName("ActiveNetherHose");
		PassiveNetherHose = new BlockPassiveNetherHose(Material.wood).setBlockName("PassiveNetherHose").setBlockTextureName("NetherHose");
		NetherPump = new BlockNetherPump(Material.iron).setBlockName("NetherPump").setBlockTextureName("NetherPump").setHardness(1.6F);
		NetherSprayer = new BlockNetherSprayer(Material.wood).setBlockName("NetherSprayer").setBlockTextureName("NetherSprayer").setHardness(1.6F);
		ActiveNetherSprayer = new BlockActiveNetherSprayer(Material.lava).setBlockName("ActiveNetherSprayer").setBlockTextureName("NetherSprayer").setHardness(1.6F);
		FarmSoulSand = new BlockFarmSoulSand().setBlockName("FarmSoulSand").setBlockTextureName("FarmSoulSand").setHardness(1F);
		
		Beans = new BlockMyCrops(1, 1, 6, 4, 1).setBlockName("Beans").setBlockTextureName("Beans");
		Peas = new BlockMyCrops(2, 2, 6, 4, 2).setBlockName("Peas").setBlockTextureName("Peas");
		ChilliPepper = new BlockMyCrops(3, 3, 6, 4, 1).setBlockName("ChilliPepper").setBlockTextureName("ChilliPepper");
		SugarBeet = new BlockMyCrops(0, 4, 6, 4, 0).setBlockName("SugarBeet").setBlockTextureName("SugarBeet");
		Beets = new BlockMyCrops(4, 5, 6, 4, 0).setBlockName("Beets").setBlockTextureName("Beets");
		
		NetherBeans = new BlockMyCrops(1, 101, 6, 4, 1).setBlockName("NetherBeans").setBlockTextureName("Beans");
		NetherPeas = new BlockMyCrops(2, 102, 6, 4, 2).setBlockName("NetherPeas").setBlockTextureName("Peas");
		NetherPeppers = new BlockMyCrops(3, 103, 6, 4, 1).setBlockName("NetherPepper").setBlockTextureName("ChilliPepper");
		NetherBeets = new BlockMyCrops(4, 107, 6, 4, 0).setBlockName("Beets").setBlockTextureName("Beets");
		
		NetherPotatoes = new BlockMyCrops(100, 104, 6, 4, 0).setBlockName("NetherBeans").setBlockTextureName("potatoes");
		NetherCarrots = new BlockMyCrops(100, 105, 6, 4, 0).setBlockName("NetherPeas").setBlockTextureName("carrots");
		NetherWheat = new BlockMyCrops(101, 106, 6, 8, 0).setBlockName("NetherPepper").setBlockTextureName("extfar:wheat_stage_7");
		
		MilkingStation = new BlockMilkingStation(Material.iron).setBlockName("MilkingStation").setBlockTextureName("extfar:wheat_stage_7").setHardness(1.8F);
		MilkFluid = new Fluid("milk").setLuminosity(0).setViscosity(20);
		FluidRegistry.registerFluid(MilkFluid);
		MilkLiquid = new BlockMilkLiquid(MilkFluid, Material.water).setBlockName("MilkFluid").setCreativeTab(ExtendedFarming.ItemsTab);
		
		CheeseBarrel = new BlockCheeseBarrel(Material.wood).setBlockName("CheeseBarrel");
		GoatCheese = new BlockGoatCheese().setBlockName("GoatCheese").setBlockTextureName("GoatCheese");
		
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

		GameRegistry.registerBlock(MilkingStation, "MilkingStation");
	    GameRegistry.registerTileEntity(TileEntityMilkingStation.class, "MilkingStationTE");
		GameRegistry.registerBlock(MilkLiquid, "MilkLiquid");
	/*	
	    GameRegistry.registerTileEntity(TileEntityCheeseBarrel.class, "CheeseBarrelTE");
		GameRegistry.registerBlock(CheeseBarrel, "CheeseBarrel");
		GameRegistry.registerBlock(GoatCheese, "GoatCheeseBlock");
	 */
		GameRegistry.registerBlock(Beans, "Beans");
		GameRegistry.registerBlock(Peas, "Peas");
		GameRegistry.registerBlock(ChilliPepper, "ChilliPepper");
		GameRegistry.registerBlock(SugarBeet, "SugarBeet");
		GameRegistry.registerBlock(Beets, "Beets");
		
		GameRegistry.registerBlock(NetherBeans, "NetherBeans");
		GameRegistry.registerBlock(NetherPeas, "NetherPeas");
		GameRegistry.registerBlock(NetherPeppers, "NetherPeppers");
		GameRegistry.registerBlock(NetherBeets, "NetherBeets");

		GameRegistry.registerBlock(NetherPotatoes, "NetherPotatoes");
		GameRegistry.registerBlock(NetherCarrots, "NetherCarrots");
		GameRegistry.registerBlock(NetherWheat, "NetherWheat");
		/*Rice = new BlockMyWaterCrops(ExtendedFarmingItems.RiceSeeds, ExtendedFarmingItems.Rice, 6, 4).setHardness(0.1F).setBlockName("RicePlant");

		GameRegistry.registerBlock(Rice, "RiceBlock");
		 */	
	}
}
