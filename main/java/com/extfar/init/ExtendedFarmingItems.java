package com.extfar.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;

import com.extfar.blocks.ItemMyFoodSeed;
import com.extfar.core.ExtendedFarming;
import com.extfar.items.ItemBowlFood;
import com.extfar.items.ItemCropSupport;
import com.extfar.items.ItemMaterials;
import com.extfar.items.ItemMyFood;
import com.extfar.items.ItemQuartzHoe;
import com.extfar.items.ItemSupportCrop;
import com.extfar.items.ItemTractor;
import com.extfar.items.ItemTractorParts;

import cpw.mods.fml.common.registry.GameRegistry;

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

	public static Item Rice;
	public static Item RiceSeeds;
	
	public static Item BambooSticksItem;
	public static Item NetItem;
	
	public static Item QuartzHoe;
	
	public static Item GoatMilk_Bucket;
	public static Item GoatMeat;
	public static Item RawGoatMeat;
	
	
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

		
	public static void init()
	{

		BambooSticksItem = new ItemCropSupport(ExtendedFarmingBlocks.BambooSticks).setUnlocalizedName("BambooSticksItem").setTextureName(modid + ":BambooSticks");
		NetItem = new ItemCropSupport(ExtendedFarmingBlocks.Net).setUnlocalizedName("NetItem").setTextureName(modid + ":Net");
				
		BeanSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.Beans, 1).setUnlocalizedName("BeanSeeds").setTextureName(modid + ":BeanSeeds");
		PeaSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.Peas, 2).setUnlocalizedName("PeaSeeds").setTextureName(modid + ":PeaSeeds");
		ChilliPepperSeeds = new ItemSupportCrop(ExtendedFarmingBlocks.ChilliPepper, 1).setUnlocalizedName("ChilliPepperSeeds").setTextureName(modid + ":ChilliPepperSeeds");
		
		Beans = new ItemMyFood(2, 2, false).setUnlocalizedName("Beans").setTextureName(modid + ":Beans");
		Peas = new ItemMyFood(2, 2, false).setUnlocalizedName("Peas").setTextureName(modid + ":Peas");
		ChilliPeppers = new ItemMyFood(1, 2, false).setUnlocalizedName("ChilliPeppers").setTextureName(modid + ":ChilliPeppers");

		RoastedCarrot = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedCarrot").setTextureName(modid + ":RoastedCarrot");
		RoastedBeans = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedBeans").setTextureName(modid + ":RoastedBeans");
		RoastedPeppers = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedPeppers").setTextureName(modid + ":RoastedPeppers");
		BakedPeas = new ItemMyFood(3, 4, false).setUnlocalizedName("BakedPeas").setTextureName(modid + ":BakedPeas");
		RoastedBeets = new ItemMyFood(3, 4, false).setUnlocalizedName("RoastedBeets").setTextureName(modid + ":RoastedBeets");

		SugarBeets = new ItemMyFoodSeed(1, 2, ExtendedFarmingBlocks.SugarBeet).setUnlocalizedName("SugarBeets").setTextureName(modid + ":SugarBeet");
		Beets = new ItemMyFoodSeed(1, 2, ExtendedFarmingBlocks.Beets).setUnlocalizedName("Beets").setTextureName(modid + ":Beets");
		
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
		
		GoatMilk_Bucket = new ItemBucketMilk().setUnlocalizedName("GoatMilk_Bucket").setTextureName(modid + ":GoatMilk_Bucket");
		RawGoatMeat = new ItemMyFood(3, 4, false).setUnlocalizedName("RawGoatMeat").setTextureName(modid + ":RawGoatMeat");
		GoatMeat = new ItemMyFood(6, 8, false).setUnlocalizedName("GoatMeat").setTextureName(modid + ":GoatMeat");
		
		
		GameRegistry.registerItem(BambooSticksItem, "BambooSticksItem", modid);
		GameRegistry.registerItem(NetItem, "NetItem", modid);
		
		GameRegistry.registerItem(BeanSeeds, "BeanSeed", modid);
		GameRegistry.registerItem(PeaSeeds, "PeaSeed", modid);
		GameRegistry.registerItem(ChilliPepperSeeds, "ChilliPepperSeeds", modid);		
		
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
		
		GameRegistry.registerItem(GoatMilk_Bucket, "GoatMilk_Bucket", modid);
		GameRegistry.registerItem(RawGoatMeat, "RawGoatMeat", modid);
		GameRegistry.registerItem(GoatMeat, "GoatMeat", modid);

		/*RiceSeeds = new ItemSeeds(ExtendedFarmingBlocks.Rice, Blocks.water);
		Rice = new ItemMyFood(0, 2, false);
		
		GameRegistry.registerItem(Rice, "Rice", modid);
		GameRegistry.registerItem(RiceSeeds, "RiceSeeds", modid);
		 */
		
	}
}
