package com.extfar.init;

import static com.extfar.init.ExtendedFarmingBlocks.*;
import static com.extfar.init.ExtendedFarmingItems.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

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
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer), 1), new Object [] {"III", " WH", " XH", 'I', Items.iron_ingot, 'W', Blocks.planks, 'X', Blocks.mossy_cobblestone, 'H', Hose});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer), 1), new Object [] {"III", "HW ", "HX ", 'I', Items.iron_ingot, 'W', Blocks.planks, 'X', Blocks.mossy_cobblestone, 'H', Hose});

		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(NetherPump), 1), new Object [] {" I ", "SHS", "BIB", 'B', Item.getItemFromBlock(Blocks.obsidian), 'I', Items.iron_ingot, 'S', Items.stick, 'H', Item.getItemFromBlock(ExtendedFarmingBlocks.NetherHose)});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(NetherSprayer), 1), new Object [] {"III", " WH", " XH", 'I', Items.iron_ingot, 'W', Blocks.iron_block, 'X', Blocks.obsidian, 'H', NetherHose});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(NetherSprayer), 1), new Object [] {"III", "HW ", "HX ", 'I', Items.iron_ingot, 'W', Blocks.iron_block, 'X', Blocks.obsidian, 'H', NetherHose});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.QuartzHoe, 1), new Object [] {"II ", " S ", " S ", 'I', Items.quartz, 'S', Items.stick});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.QuartzHoe, 1), new Object [] {" II", " S ", " S ", 'I', Items.quartz, 'S', Items.stick});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Tractor, 1), new Object [] {" SC", "BET", "W W", 'T', Blocks.chest, 'S', ExtendedFarmingItems.SteeringWheel, 'B', ExtendedFarmingItems.Body, 'E', ExtendedFarmingItems.Engine, 'C', ExtendedFarmingItems.Chair, 'W', ExtendedFarmingItems.DriveShaft});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Plow, 1), new Object [] {"III", "SSS", "BBB", 'I', Blocks.iron_block, 'S', Items.stick, 'B', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Mower, 1), new Object [] {"III", "S S", "B B", 'I', Blocks.iron_block, 'S', Items.stick, 'B', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Sprayer, 1), new Object [] {"III", "SSS", "BBB", 'I', Blocks.iron_block, 'S', ExtendedFarmingBlocks.Hose, 'B', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Seeder, 1), new Object [] {"ICI", " B ", "BBB", 'I', Blocks.iron_block, 'C', Blocks.chest, 'B', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Harvester, 1), new Object [] {"BBB", "III", "BBB", 'I', Blocks.iron_block, 'C', Blocks.chest, 'B', Items.iron_ingot});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Engine, 1), new Object [] {"I I", "BBB", 'I', Items.iron_ingot, 'B', Blocks.iron_block});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.SteeringWheel, 1), new Object [] {"III", "I I", "III", 'I', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Chair, 1), new Object [] {"  L", "LLL", "I I", 'L', Items.leather, 'I', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Wheel, 1), new Object [] {"OOO", "ORO", "OOO", 'O', Blocks.obsidian, 'R', Blocks.redstone_block});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Body, 1), new Object [] {" I ", "LBB", "III", 'I', Items.iron_ingot, 'B', Blocks.iron_block, 'L', Blocks.redstone_lamp});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.DriveShaft, 1), new Object [] {"WIW", 'W', ExtendedFarmingItems.Wheel, 'I', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Wrench, 1), new Object [] {"S", "S", "S", 'S', Items.iron_ingot});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.Spoon, 1), new Object [] {"SS ", " S ", " S ", 'S', Items.iron_ingot});

		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(MilkingStation), 1), new Object [] {"F F", "WHW", "WCW", 'F', Blocks.fence, 'W', Blocks.planks, 'C', Items.cauldron, 'H', Hose});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(CheeseBarrel), 1), new Object [] {"W W", "W W", "WWW", 'W', Blocks.planks});
		 GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Grinder), 1), new Object [] {"C", "B", 'C', Blocks.cobblestone, 'B', CheeseBarrel});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.BeetSoup, 1), new Object [] {"III", "III", " S ", 'I', ExtendedFarmingItems.RoastedBeets, 'S', Items.bowl});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.RawApplePie, 1), new Object [] {"A A", "III", "AAA", 'A', ExtendedFarmingItems.Doug, 'I', Items.apple});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.EmptyWateringCan, 1), new Object [] {"I  ", " I ", "  B", 'B', Items.bucket, 'I', Items.iron_ingot});

		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingBlocks.OilExtractor, 1), new Object [] {"BHB", "BSB", "BCB", 'B', Blocks.brick_block, 'H', Blocks.hopper, 'C', ExtendedFarmingItems.EmptyCannister, 'S', Items.stick});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingBlocks.BioFuelCompressor, 1), new Object [] {"BHB", "BOB", "BCB", 'B', Blocks.brick_block, 'H', Blocks.hopper, 'C', ExtendedFarmingItems.EmptyCannister, 'O', Blocks.obsidian});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingBlocks.BioFuelFiltrator, 1), new Object [] {"BBB", "BPB", "BCB", 'B', Blocks.brick_block, 'H', Blocks.hopper, 'C', ExtendedFarmingItems.EmptyCannister, 'P', Blocks.planks});
		 
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.EmptyCannister, 3), new Object [] {"BBB", "BSB", "BBB", 'B', Items.iron_ingot, 'S', Blocks.glass});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.FilterPaper, 3), new Object [] {"BBB", "B B", "BBB", 'B', Items.paper});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingBlocks.DeepFrier, 1), new Object [] {"BGB", "BRB", "BBB", 'B', Items.iron_ingot, 'G', Blocks.glass, 'R', Items.redstone});
		 GameRegistry.addRecipe(new ItemStack(ExtendedFarmingItems.FishAndChips, 1), new Object [] {"C", "F", "P", 'C', ExtendedFarmingItems.PotatoChips, 'F', Items.cooked_fished, 'P', Items.paper});

		 
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.BambooSticksItem, 1), new Object[]{Items.stick, Items.reeds});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.BeanSeeds, 2), new Object[]{ExtendedFarmingItems.Beans});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.PeaSeeds, 2), new Object[]{ExtendedFarmingItems.Peas});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.ChilliPepperSeeds, 2), new Object[]{ExtendedFarmingItems.ChilliPeppers});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingBlocks.Hose, 8), new Object[]{Items.clay_ball, Items.clay_ball, Items.string});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingBlocks.NetherHose, 8), new Object[]{Hose, Hose, Hose, Hose, Hose, Hose, Hose, Hose, Blocks.obsidian});
		 GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, 2), new Object[]{ExtendedFarmingItems.SugarBeets});
		 GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 1), new Object[]{ExtendedFarmingItems.Beets});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.Doug, 1, 1), new Object[]{ExtendedFarmingItems.Flour, Items.water_bucket});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.FryingOil, 2, 1), new Object[]{ExtendedFarmingItems.RapeseedOil, ExtendedFarmingItems.SunFlowerOil});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.RawPotatoChips, 3, 1), new Object[]{Items.potato, Items.potato});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.RawPotatoCrisps, 2, 1), new Object[]{Items.potato});
		 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.PileOSeeds, 1, 1), new Object[]{ExtendedFarmingItems.RapeseedSeeds, ExtendedFarmingItems.RapeseedSeeds, ExtendedFarmingItems.RapeseedSeeds, ExtendedFarmingItems.RapeseedSeeds, ExtendedFarmingItems.RapeseedSeeds});

		 Item[] vegetables = {Peas, Beans, ChilliPeppers, Beets, SugarBeets, Items.potato, Items.poisonous_potato, Items.carrot, Items.wheat, Item.getItemFromBlock(Blocks.tallgrass), Item.getItemFromBlock(Blocks.leaves), Item.getItemFromBlock(Blocks.leaves2), Item.getItemFromBlock(Blocks.vine), Items.apple};  
		 int[] vegetableValue = {2, 2, 1, 2, 1, 2, 1, 2, 3, 1, 1, 1, 1, 2};  
		 
		 for(int i = 0; i< vegetables.length; i++)
		 {
			 GameRegistry.addShapelessRecipe(new ItemStack(ExtendedFarmingItems.OrganicMaterial, vegetableValue[i], 1), new Object[]{vegetables[i], vegetables[i], vegetables[i], vegetables[i], vegetables[i], vegetables[i], vegetables[i], vegetables[i], vegetables[i]});
		 }
		 
		 GameRegistry.addSmelting(ExtendedFarmingItems.RawGoatMeat, new ItemStack(ExtendedFarmingItems.GoatMeat), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.Beans, new ItemStack(ExtendedFarmingItems.RoastedBeans), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.Peas, new ItemStack(ExtendedFarmingItems.BakedPeas), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.ChilliPeppers, new ItemStack(ExtendedFarmingItems.RoastedPeppers), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.Beets, new ItemStack(ExtendedFarmingItems.RoastedBeets), 3F);
		 GameRegistry.addSmelting(ExtendedFarmingItems.RawApplePie, new ItemStack(ExtendedFarmingItems.ApplePie), 3F);
	}
}
