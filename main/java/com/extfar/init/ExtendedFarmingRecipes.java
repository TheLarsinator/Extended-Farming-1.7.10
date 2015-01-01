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

		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.BambooSticksItem, 1), new Object[]{Items.stick, Items.reeds});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.BeanSeeds, 2), new Object[]{ExtendedFarmingItems.Beans});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.PeaSeeds, 2), new Object[]{ExtendedFarmingItems.Peas});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingBlocks.Hose, 8), new Object[]{Items.clay_ball, Items.clay_ball, Items.string});

	}
}
