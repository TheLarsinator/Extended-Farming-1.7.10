package com.extfar.init;

import com.extfar.blocks.ItemMyFoodSeed;
import com.extfar.core.ExtendedFarming;
import com.extfar.items.ItemBowlFood;
import com.extfar.items.ItemCheat;
import com.extfar.items.ItemCropSupport;
import com.extfar.items.ItemCustomCake;
import com.extfar.items.ItemFuelCannisters;
import com.extfar.items.ItemMaterials;
import com.extfar.items.ItemMyFood;
import com.extfar.items.ItemQuartzHoe;
import com.extfar.items.ItemSupportCrop;
import com.extfar.items.ItemTractor;
import com.extfar.items.ItemTractorParts;
import com.extfar.items.ItemWateringCan;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemSeeds;

public class ExtendedFarmingItems 
{
	public static String modid = ExtendedFarming.modid;
	
	public static Item Beans;
	public static Item Peas;
	public static Item ChilliPeppers;
	public static Item SugarBeets;
	public static Item Beets;
	
	public static Item RoastedCarrot;
	public static Item RoastedBeans;
	public static Item BakedPeas;
	public static Item RoastedPeppers;
	public static Item RoastedBeets;

	public static Item BeetSoup;

	public static Item BeanSeeds;
	public static Item PeaSeeds;
	public static Item ChilliPepperSeeds;
	public static Item BeetSeeds;
	public static Item RapeseedSeeds;
	public static Item PileOSeeds;

	public static Item Rice;
	public static Item RiceSeeds;
	
	public static Item BambooSticksItem;
	public static Item NetItem;
	
	public static Item QuartzHoe;
	
	public static Item GoatMilk_Bucket;
	public static Item GoatMeat;
	public static Item RawGoatMeat;
	public static Item GoatCheese;
	
	public static Item Flour;
	public static Item Doug;
	public static Item RawApplePie;
	public static Item ApplePie;	
	
	public static final Item Tractor = new ItemTractor(0);
	
	public static Item Plow;
	public static Item Mower;
	public static Item Sprayer;
	public static Item Seeder;
	public static Item Harvester;

	public static Item Engine;
	public static Item Body;
	public static Item DriveShaft;
	public static Item Wheel;
	public static Item Chair;
	public static Item SteeringWheel;
	
	public static Item Wrench;
	public static Item Spoon;
	public static Item WateringCan;
	public static Item EmptyWateringCan;
	public static Item LavaingCan;

	public static Item UnfilteredFuel;
	public static Item BioFuel;
	public static Item OrganicMaterial;
	public static Item FilterPaper;
	public static Item EmptyCannister;
	public static Item SunFlowerOil;
	public static Item RapeseedOil;

	public static Item FryingOil;
	public static Item DirtyFryingOil;
	public static Item RawPotatoChips;
	public static Item PotatoChips;
	public static Item RawPotatoCrisps;
	public static Item PotatoCrisps;
	public static Item FishAndChips;
	
	public static Item metaCheat;
		
	public static void init()
	{

		BambooSticksItem = new ItemCropSupport(ExtendedFarmingBlocks.BambooSticks).setUnlocalizedName("BambooSticksItem").setTextureName(modid + ":BambooSticks");
		NetItem = new ItemCropSupport(ExtendedFarmingBlocks.Net).setUnlocalizedName("NetItem").setTextureName(modid + ":Net");
				
		BeanSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.Beans_Block, 1).setUnlocalizedName("BeanSeeds").setTextureName(modid + ":BeanSeeds");
		PeaSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.Peas_Block, 2).setUnlocalizedName("PeaSeeds").setTextureName(modid + ":PeaSeeds");
		ChilliPepperSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.ChilliPepper_Block, 1).setUnlocalizedName("ChilliPepperSeeds").setTextureName(modid + ":ChilliPepperSeeds");
		//RapeseedSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.Rapeseed_Block, 0).setUnlocalizedName("RapeseedSeeds").setTextureName(modid + ":RapeseedSeeds");
		RapeseedSeeds = new ItemSeeds(ExtendedFarmingBlocks.Rapeseed_Block, Blocks.farmland).setUnlocalizedName("RapeseedSeeds").setCreativeTab(ExtendedFarming.ItemsTab).setTextureName(modid + ":RapeseedSeeds");
		PileOSeeds = new ItemMaterials().setUnlocalizedName("PileOSeeds").setTextureName(modid + ":PileOSeeds");
		
		Beans = new ItemMyFood(2, 2, false).setUnlocalizedName("Beans").setTextureName(modid + ":Beans");
		Peas = new ItemMyFood(2, 2, false).setUnlocalizedName("Peas").setTextureName(modid + ":Peas");
		ChilliPeppers = new ItemMyFood(1, 2, false).setUnlocalizedName("ChilliPeppers").setTextureName(modid + ":ChilliPeppers");

		RoastedCarrot = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedCarrot").setTextureName(modid + ":RoastedCarrot");
		RoastedBeans = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedBeans").setTextureName(modid + ":RoastedBeans");
		RoastedPeppers = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedPeppers").setTextureName(modid + ":RoastedPeppers");
		BakedPeas = new ItemMyFood(3, 4, false).setUnlocalizedName("BakedPeas").setTextureName(modid + ":BakedPeas");
		RoastedBeets = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedBeets").setTextureName(modid + ":RoastedBeets");

		SugarBeets = new ItemMyFoodSeed(1, 2, ExtendedFarmingBlocks.SugarBeet_Block).setUnlocalizedName("SugarBeets").setTextureName(modid + ":SugarBeet");
		Beets = new ItemMyFoodSeed(1, 2, ExtendedFarmingBlocks.Beets_Block).setUnlocalizedName("Beets").setTextureName(modid + ":Beets");
		
		BeetSoup = new ItemBowlFood(8).setUnlocalizedName("BeetSoup").setTextureName(modid + ":BeetSoup");

		QuartzHoe = new ItemQuartzHoe(ExtendedFarming.Quartz).setUnlocalizedName("QuartzHoe").setTextureName(modid + ":QuartzHoe");
		
		Plow = new ItemMaterials().setUnlocalizedName("Plow").setTextureName(modid + ":Plow").setFull3D();
		Mower = new ItemMaterials().setUnlocalizedName("Mower").setTextureName(modid + ":Mower").setFull3D();
		Sprayer = new ItemMaterials().setUnlocalizedName("Sprayer").setTextureName(modid + ":Sprayer").setFull3D();
		Seeder = new ItemMaterials().setUnlocalizedName("Seeder").setTextureName(modid + ":Seeder").setFull3D();
		Harvester = new ItemMaterials().setUnlocalizedName("Harvester").setTextureName(modid + ":Harvester").setFull3D();
		
		Engine = (new ItemTractorParts(1)).setUnlocalizedName("Engine").setTextureName(modid + ":Engine").setFull3D();
		Body = (new ItemTractorParts(1)).setUnlocalizedName("Body").setTextureName(modid + ":Body").setFull3D();
		DriveShaft = (new ItemTractorParts(1)).setUnlocalizedName("DriveShaft").setTextureName(modid + ":DriveShaft").setFull3D();
		Chair = (new ItemTractorParts(1)).setUnlocalizedName("Chair").setTextureName(modid + ":Chair").setFull3D();
		SteeringWheel = (new ItemTractorParts(1)).setUnlocalizedName("SteeringWheel").setTextureName(modid + ":SteeringWheel").setFull3D();
		Wheel = (new ItemTractorParts(1)).setUnlocalizedName("Wheel").setTextureName(modid + ":Wheel").setFull3D();
		
		Wrench = new ItemMaterials().setUnlocalizedName("Wrench").setTextureName(modid + ":Wrench");
		Spoon = new ItemMaterials().setUnlocalizedName("Spoon").setTextureName(modid + ":Spoon");
		
		GoatMilk_Bucket = new ItemBucketMilk().setUnlocalizedName("GoatMilk_Bucket").setTextureName(modid + ":GoatMilk_Bucket").setCreativeTab(ExtendedFarming.ItemsTab);
		RawGoatMeat = new ItemMyFood(3, 4, false).setUnlocalizedName("RawGoatMeat").setTextureName(modid + ":RawGoatMeat");
		GoatMeat = new ItemMyFood(6, 8, false).setUnlocalizedName("GoatMeat").setTextureName(modid + ":GoatMeat");
		GoatCheese = new ItemCustomCake(ExtendedFarmingBlocks.GoatCheese).setUnlocalizedName("GoatCheeseItem").setTextureName(modid + ":GoatCheeseItem").setCreativeTab(ExtendedFarming.ItemsTab);
		
		Flour = new ItemMaterials().setUnlocalizedName("Flour").setTextureName(modid + ":Flour");
		Doug = new ItemMaterials().setUnlocalizedName("Doug").setTextureName(modid + ":Doug");	
		RawApplePie = new ItemMaterials().setUnlocalizedName("RawApplePie").setTextureName(modid + ":RawApplePie");
		ApplePie = new ItemCustomCake(ExtendedFarmingBlocks.ApplePie).setUnlocalizedName("ApplePieItem").setTextureName(modid + ":ApplePieItem").setCreativeTab(ExtendedFarming.ItemsTab);

		WateringCan = new ItemWateringCan(false, false).setUnlocalizedName("WateringCan").setTextureName(modid + ":WateringCan");
		EmptyWateringCan = new ItemWateringCan(true, true).setUnlocalizedName("EmptyWateringCan").setTextureName(modid + ":EmptyWateringCan");
		LavaingCan = new ItemWateringCan(false, true).setUnlocalizedName("LavaingCan").setTextureName(modid + ":LavaingCan");
		
		UnfilteredFuel = new ItemFuelCannisters().setUnlocalizedName("UnfilteredFuel").setTextureName(modid + ":UnfilteredFuel");
		OrganicMaterial = new ItemMaterials().setUnlocalizedName("OrganicMaterial").setTextureName(modid + ":OrganicMaterial");
		BioFuel = new ItemFuelCannisters().setUnlocalizedName("BioFuel").setTextureName(modid + ":BioFuel");
		FilterPaper = new ItemMaterials().setUnlocalizedName("FilterPaper").setTextureName(modid + ":FilterPaper");
		EmptyCannister = new ItemFuelCannisters().setUnlocalizedName("EmptyCannister").setTextureName(modid + ":EmptyCannister");
		SunFlowerOil = new ItemFuelCannisters().setUnlocalizedName("SunFlowerOil").setTextureName(modid + ":SunFlowerOil");
		RapeseedOil = new ItemFuelCannisters().setUnlocalizedName("RapeseedOil").setTextureName(modid + ":RapeseedOil");
		FryingOil = new ItemFuelCannisters().setUnlocalizedName("FryingOil").setTextureName(modid + ":FryingOil");
		DirtyFryingOil = new ItemFuelCannisters().setUnlocalizedName("DirtyFryingOil").setTextureName(modid + ":DirtyFryingOil");

		PotatoChips = new ItemMyFood(4, 6, false).setUnlocalizedName("PotatoChips").setTextureName(modid + ":PotatoChips");
		RawPotatoChips = new ItemMyFood(1, 2, false).setUnlocalizedName("RawPotatoChips").setTextureName(modid + ":RawPotatoChips");
		PotatoCrisps = new ItemMyFood(4, 6, false).setUnlocalizedName("PotatoCrisps").setTextureName(modid + ":PotatoCrisps");
		RawPotatoCrisps = new ItemMyFood(1, 2, false).setUnlocalizedName("RawPotatoCrisps").setTextureName(modid + ":RawPotatoCrisps");
		FishAndChips = new ItemMyFood(8, 10, false).setUnlocalizedName("FishAndChips").setTextureName(modid + ":FishAndChips");
		
		metaCheat = new ItemCheat().setUnlocalizedName("Cheat");
		
		GameRegistry.registerItem(BambooSticksItem, "BambooSticksItem", modid);
		GameRegistry.registerItem(NetItem, "NetItem", modid);
		GameRegistry.registerItem(metaCheat, "Cheat", modid);
		
		GameRegistry.registerItem(BeanSeeds, "BeanSeed", modid);
		GameRegistry.registerItem(PeaSeeds, "PeaSeed", modid);
		GameRegistry.registerItem(ChilliPepperSeeds, "ChilliPepperSeeds", modid);		
		GameRegistry.registerItem(RapeseedSeeds, "RapeseedSeeds", modid);		
		GameRegistry.registerItem(PileOSeeds, "PileOSeeds", modid);		
		
		GameRegistry.registerItem(Beans, "BeansItem", modid);
		GameRegistry.registerItem(Peas, "PeasItem", modid);
		GameRegistry.registerItem(ChilliPeppers, "ChilliPeppersItem", modid);
		GameRegistry.registerItem(SugarBeets, "SugarBeets", modid);
		GameRegistry.registerItem(Beets, "BeetsItem", modid);
	
		GameRegistry.registerItem(RoastedCarrot, "RoastedCarrot", modid);
		GameRegistry.registerItem(RoastedBeans, "RoastedBeans", modid);
		GameRegistry.registerItem(RoastedPeppers, "RoastedPeppers", modid);
		GameRegistry.registerItem(RoastedBeets, "RoastedBeets", modid);
		GameRegistry.registerItem(BakedPeas, "BakedPeas", modid);

		GameRegistry.registerItem(BeetSoup, "BeetSoup", modid);
		
		GameRegistry.registerItem(QuartzHoe, "QuartzHoe", modid);
		
		GameRegistry.registerItem(Tractor, "Tractor", modid);
		GameRegistry.registerItem(Plow, "Plow", modid);
		GameRegistry.registerItem(Mower, "Mower", modid);
		GameRegistry.registerItem(Sprayer, "TractorSprayer", modid);
		GameRegistry.registerItem(Seeder, "TractorSeeder", modid);
		GameRegistry.registerItem(Harvester, "TractorHarvester", modid);

		GameRegistry.registerItem(Engine, "Engine", modid);
		GameRegistry.registerItem(Body, "Body", modid);
		GameRegistry.registerItem(DriveShaft, "DriveShaft", modid);
		GameRegistry.registerItem(Chair, "Chair", modid);
		GameRegistry.registerItem(SteeringWheel, "SteeringWheel", modid);
		GameRegistry.registerItem(Wheel, "Wheel", modid);

		GameRegistry.registerItem(Wrench, "Wrench", modid);
		GameRegistry.registerItem(Spoon, "Spoon", modid);
		
		GameRegistry.registerItem(GoatMilk_Bucket, "GoatMilk_Bucket", modid);
		GameRegistry.registerItem(RawGoatMeat, "RawGoatMeat", modid);
		GameRegistry.registerItem(GoatMeat, "GoatMeat", modid);
		GameRegistry.registerItem(GoatCheese, "GoatCheese", modid);
		GameRegistry.registerItem(Flour, "Flour", modid);
		GameRegistry.registerItem(Doug, "Doug", modid);
		GameRegistry.registerItem(RawApplePie, "RawApplePie", modid);
		GameRegistry.registerItem(ApplePie, "ApplePieItem", modid);
		GameRegistry.registerItem(RawPotatoChips, "RawPotatoChips", modid);
		GameRegistry.registerItem(PotatoChips, "PotatoChips", modid);
		GameRegistry.registerItem(RawPotatoCrisps, "RawPotatoCrisps", modid);
		GameRegistry.registerItem(PotatoCrisps, "PotatoCrisps", modid);
		GameRegistry.registerItem(FishAndChips, "FishAndChips", modid);

		GameRegistry.registerItem(EmptyWateringCan, "EmptyWateringCan", modid);
		GameRegistry.registerItem(WateringCan, "WateringCan", modid);
		GameRegistry.registerItem(LavaingCan, "LavaingCan", modid);
		
		GameRegistry.registerItem(EmptyCannister, "EmptyCannister", modid);
		GameRegistry.registerItem(SunFlowerOil, "SunFlowerOil", modid);
		GameRegistry.registerItem(RapeseedOil, "RapeseedOil", modid);
		GameRegistry.registerItem(FryingOil, "FryingOil", modid);
		GameRegistry.registerItem(DirtyFryingOil, "DirtyFryingOil", modid);
		GameRegistry.registerItem(UnfilteredFuel, "UnfilteredFuel", modid);
		GameRegistry.registerItem(BioFuel, "BioFuel", modid);
		GameRegistry.registerItem(OrganicMaterial, "OrganicMaterial", modid);
		GameRegistry.registerItem(FilterPaper, "FilterPaper", modid);
		



		/*RiceSeeds = new ItemSeeds(ExtendedFarmingBlocks.Rice, Blocks.water);
		Rice = new ItemMyFood(0, 2, false);
		
		GameRegistry.registerItem(Rice, "Rice", modid);
		GameRegistry.registerItem(RiceSeeds, "RiceSeeds", modid);
		 */
		
	}
}
