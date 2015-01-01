package com.extfar.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCropSupport extends Block
{
    private int RenderType;
    private int dropID;
    
	public BlockCropSupport(Material material, int render, int item) {
		super(material);
		this.RenderType = render;
		this.dropID = item;
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getTextureName());
    }
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return RenderType;
    }
    /**
     * is the block farmland
     */
    protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.farmland || block == ExtendedFarmingBlocks.FarmSoulSand;
    }
    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int i, int j, int k, Block block)
    {
		EntityItem bamboo = new EntityItem(world, (double)i, (double)j, (double)k, new ItemStack(ExtendedFarmingItems.BambooSticksItem));
		EntityItem net = new EntityItem(world, (double)i, (double)j, (double)k, new ItemStack(ExtendedFarmingItems.NetItem));

	   if(world.getBlock(i, j-1, k) != Blocks.farmland)
	   {
		   if(world.getBlock(i, j-1, k) != ExtendedFarmingBlocks.FarmSoulSand)
		   {
    	   if(world.isRemote == false)
    	   {
    		   switch(dropID)
    		   {
    		   case 1:
    	    		world.spawnEntityInWorld(bamboo);
    	    		break;
    		   case 2:
    	    		world.spawnEntityInWorld(net);
    	    		world.spawnEntityInWorld(bamboo);
    	    		break;
    		   }
    	   }
		   
		
		   world.setBlockToAir(i, j, k);
		   }
	   }
    }
    
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int tile) 
    {
    	if(this == ExtendedFarmingBlocks.Net)
    	{
    		world.setBlock(i, j, k, ExtendedFarmingBlocks.BambooSticks);
    	}
    }

	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		   switch(dropID)
		   {
		   case 1:
	    		return ExtendedFarmingItems.BambooSticksItem;
		   case 2:
	    		return ExtendedFarmingItems.NetItem;
	    	default:
	    		return null;
		   }
        
    }
}
