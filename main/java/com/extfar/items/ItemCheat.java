package com.extfar.items;

import com.extfar.blocks.BlockCropSupport;
import com.extfar.blocks.BlockCrops;
import com.extfar.core.ExtendedFarming;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCheat extends Item
{
    public ItemCheat()
    {
        super();
        this.maxStackSize = 64;
        //this.setCreativeTab(ExtendedFarming.ItemsTab);
        
    }
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stac, EntityPlayer player, World world, int i, int j, int k, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	if(world.getBlock(i, j, k) instanceof BlockCropSupport || world.getBlock(i, j, k) instanceof BlockCrops)
    	{
    		world.setBlockMetadataWithNotify(i, j, k, world.getBlockMetadata(i, j, k)+1, 2);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
