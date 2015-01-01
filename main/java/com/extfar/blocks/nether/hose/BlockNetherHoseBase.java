package com.extfar.blocks.nether.hose;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.extfar.init.ExtendedFarmingBlocks;

public class BlockNetherHoseBase extends Block{

	protected BlockNetherHoseBase(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(ExtendedFarmingBlocks.NetherHose);
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
    	if(this instanceof BlockNetherHose)
    	{
	EntityItem item = new EntityItem(world, i, j, k, new ItemStack(Item.getItemFromBlock(ExtendedFarmingBlocks.NetherHose)));
	if(!world.isRemote)
	{
	world.spawnEntityInWorld(item);
	}
    	}
    }
}
