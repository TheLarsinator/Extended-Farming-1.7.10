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

public class ItemCropSupport extends Item
{
    private Block SupportBlock;

    public ItemCropSupport(Block block)
    {
        this.SupportBlock = block;
        this.setCreativeTab(ExtendedFarming.ItemsTab);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int i, int j, int k, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	if((world.getBlock(i, j, k) == Blocks.farmland || world.getBlock(i, j, k) == ExtendedFarmingBlocks.FarmSoulSand) && SupportBlock != ExtendedFarmingBlocks.Net)
    	{
    		world.setBlock(i, j+1, k, SupportBlock);
    		player.inventory.consumeInventoryItem(this);
        	System.out.println(world.getBlock(i, j, k));

    		return true;
    	}
    	else if(world.getBlock(i, j, k) == ExtendedFarmingBlocks.BambooSticks && SupportBlock == ExtendedFarmingBlocks.Net)
    	{
    		world.setBlock(i, j, k, SupportBlock);
    		player.inventory.consumeInventoryItem(this);
        	System.out.println(world.getBlock(i, j, k));

    		return true;
    	}
    	else
    	{
        	System.out.println(world.getBlock(i, j, k));

    		return false;
    	}
    }
}