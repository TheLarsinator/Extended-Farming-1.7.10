package com.extfar.init;

import static com.extfar.init.ExtendedFarmingBlocks.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExtendedFarmingRecipes 
{
	public static void RecipeBook()
	{
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Pump), 1), new Object [] {" I ", "SHS", "BIB", 'B', Item.getItemFromBlock(Blocks.iron_block), 'I', Items.iron_ingot, 'S', Items.stick, 'H', Item.getItemFromBlock(ExtendedFarmingBlocks.Hose)});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.NetItem, 16), new Object [] {"BBB", "BBB", "BBB", 'B', Items.string});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Sprayer), 1), new Object [] {"III", " WH", " XH", 'I', Items.iron_ingot, 'W', Blocks.planks, 'X', Blocks.mossy_cobblestone, 'H', Hose});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Sprayer), 1), new Object [] {"III", "HW ", "HX ", 'I', Items.iron_ingot, 'W', Blocks.planks, 'X', Blocks.mossy_cobblestone, 'H', Hose});

		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(NetherPump), 1), new Object [] {" I ", "SHS", "BIB", 'B', Item.getItemFromBlock(Blocks.obsidian), 'I', Items.iron_ingot, 'S', Items.stick, 'H', Item.getItemFromBlock(ExtendedFarmingBlocks.NetherHose)});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(NetherSprayer), 1), new Object [] {"III", " WH", " XH", 'I', Items.iron_ingot, 'W', Blocks.iron_block, 'X', Blocks.obsidian, 'H', NetherHose});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(NetherSprayer), 1), new Object [] {"III", "HW ", "HX ", 'I', Items.iron_ingot, 'W', Blocks.iron_block, 'X', Blocks.obsidian, 'H', NetherHose});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.QuartzHoe, 1), new Object [] {"II ", " S ", " S ", 'I', Items.quartz, 'S', Items.stick});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.QuartzHoe, 1), new Object [] {" II", " S ", " S ", 'I', Items.quartz, 'S', Items.stick});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.BeetSoup, 1), new Object [] {"III", "III", " S ", 'I', ExtendedFarmingItems.RoastedBeets, 'S', Items.bowl});
		 
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.BambooSticksItem, 1), new Object[]{Items.stick, Items.reeds});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.BeanSeeds, 2), new Object[]{ExtendedFarmingItems.Beans});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.PeaSeeds, 2), new Object[]{ExtendedFarmingItems.Peas});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.ChilliPepperSeeds, 2), new Object[]{ExtendedFarmingItems.ChilliPeppers});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingBlocks.Hose, 8), new Object[]{Items.clay_ball, Items.clay_ball, Items.string});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingBlocks.NetherHose, 8), new Object[]{Hose, Hose, Hose, Hose, Hose, Hose, Hose, Hose, Blocks.obsidian});
		 GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, 2), new Object[]{ExtendedFarmingItems.SugarBeets});
		 GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 1), new Object[]{ExtendedFarmingItems.Beets});

		 GameRegistry.addSmelting(Items.carrot, new ItemStack(ExtendedFarmingItems.RoastedCarrot), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.Beans, new ItemStack(ExtendedFarmingItems.RoastedBeans), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.Peas, new ItemStack(ExtendedFarmingItems.BakedPeas), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.ChilliPeppers, new ItemStack(ExtendedFarmingItems.RoastedPeppers), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.Beets, new ItemStack(ExtendedFarmingItems.RoastedBeets), 3F);
	}
}
