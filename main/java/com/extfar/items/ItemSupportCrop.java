package com.extfar.items;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSupportCrop extends Item
{
    private Block Crop;
    private int Support;

    public ItemSupportCrop(Block block, int support)
    {
        this.Crop = block;
        this.Support = support;
        this.setCreativeTab(ExtendedFarming.ItemsTab);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int i, int j, int k, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	System.out.println(Crop + ", " + Support);
    	
    	
    	if((world.getBlock(i, j-1, k) == Blocks.farmland || world.getBlock(i, j-1, k) == ExtendedFarmingBlocks.FarmSoulSand) && Support == 1 && world.getBlock(i, j, k) == ExtendedFarmingBlocks.BambooSticks)
    	{
    		world.setBlockToAir(i, j, k);
    		world.setBlock(i, j, k, Crop);
    		player.inventory.consumeInventoryItem(this);
    		return true;
    	}
    	else if((world.getBlock(i, j-1, k) == Blocks.farmland || world.getBlock(i, j-1, k) == ExtendedFarmingBlocks.FarmSoulSand) && Support == 2 && world.getBlock(i, j, k) == ExtendedFarmingBlocks.Net)
    	{
    		world.setBlockToAir(i, j, k);
    		world.setBlock(i, j, k, Crop);
    		player.inventory.consumeInventoryItem(this);
    		return true;
    	}
    	else if((world.getBlock(i, j-1, k) == Blocks.farmland || world.getBlock(i, j-1, k) == ExtendedFarmingBlocks.FarmSoulSand) && Support == 0)
    	{
    		world.setBlock(i, j, k, Crop);
    		player.inventory.consumeInventoryItem(this);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}