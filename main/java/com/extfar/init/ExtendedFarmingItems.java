package com.extfar.init;

import net.minecraft.item.Item;

import com.extfar.core.ExtendedFarming;
import com.extfar.items.ItemCropSupport;
import com.extfar.items.ItemMyFood;
import com.extfar.items.ItemSupportCrop;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtendedFarmingItems 
{
	public static String modid = ExtendedFarming.modid;
	
	public static Item Beans;
	public static Item BeanSeeds;
	public static Item Peas;
	public static Item PeaSeeds;
	public static Item ChilliPeppers;
	public static Item ChilliPepperSeeds;
	public static Item RoastedCarrot;
	public static Item RoastedBeans;
	public static Item BakedPeas;
	public static Item RoastedPeppers;

	public static Item Rice;
	public static Item RiceSeeds;
	
	public static Item BambooSticksItem;
	public static Item NetItem;
		
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
		
		
		GameRegistry.registerItem(BambooSticksItem, "BambooSticksItem", modid);
		GameRegistry.registerItem(NetItem, "NetItem", modid);
		
		GameRegistry.registerItem(BeanSeeds, "BeanSeed", modid);
		GameRegistry.registerItem(PeaSeeds, "PeaSeed", modid);
		GameRegistry.registerItem(ChilliPepperSeeds, "ChilliPepperSeeds", modid);		
		
		GameRegistry.registerItem(Beans, "BeansItem", modid);
		GameRegistry.registerItem(Peas, "PeasItem", modid);
		GameRegistry.registerItem(ChilliPeppers, "ChilliPeppersItem", modid);
		GameRegistry.registerItem(RoastedCarrot, "RoastedCarrot", modid);
		GameRegistry.registerItem(RoastedBeans, "RoastedBeans", modid);
		GameRegistry.registerItem(RoastedPeppers, "RoastedPeppers", modid);
		GameRegistry.registerItem(BakedPeas, "BakedPeas", modid);
		/*RiceSeeds = new ItemSeeds(ExtendedFarmingBlocks.Rice, Blocks.water);
		Rice = new ItemMyFood(0, 2, false);
		
		GameRegistry.registerItem(Rice, "Rice", modid);
		GameRegistry.registerItem(RiceSeeds, "RiceSeeds", modid);
		 */
		
	}
}
