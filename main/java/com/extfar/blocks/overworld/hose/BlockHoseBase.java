package com.extfar.blocks.overworld.hose;

import java.util.Random;

import com.extfar.blocks.nether.hose.BlockNetherHose;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockHoseBase extends Block{

	protected BlockHoseBase(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(ExtendedFarmingBlocks.Hose);
    }
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
    
    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int p_149664_5_) 
    {
    	if(this instanceof BlockHose)
    	{
	EntityItem item = new EntityItem(world, i, j, k, new ItemStack(Item.getItemFromBlock(ExtendedFarmingBlocks.Hose)));
	if(!world.isRemote)
	{
	world.spawnEntityInWorld(item);
	}
    }
    }
}
