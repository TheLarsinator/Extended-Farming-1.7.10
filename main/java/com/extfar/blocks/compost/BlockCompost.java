package com.extfar.blocks.compost;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;

public class BlockCompost extends Block implements ITileEntityProvider
{

	public BlockCompost(Material material) 
	{
		super(material);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityCompost();
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
	    return 1;
	}
	
	@Override
	public int getRenderType() {
	    return -1;
	}

	@Override
	public boolean isOpaqueCube(){
	return false;
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int i, int j, int k, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
	    int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
	    par1World.setBlockMetadataWithNotify(i, j, k, l, 2);
	    
	    
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	   
		ItemStack item = player.getHeldItem();
		int grass = ((TileEntityCompost)world.getTileEntity(x, y, z)).grassLevel;
		if(item != null && ((TileEntityCompost)world.getTileEntity(x, y, z)).grassLevel < 64)
		{
			if(item.getItem() == Item.getItemFromBlock(Blocks.waterlily) || item.getItem() == Item.getItemFromBlock(Blocks.tallgrass) || item.getItem() == Item.getItemFromBlock(Blocks.leaves) || item.getItem() == Item.getItemFromBlock(Blocks.red_flower) || item.getItem() == Item.getItemFromBlock(Blocks.yellow_flower))
			{
				int itemamount = item.stackSize;
				((TileEntityCompost)world.getTileEntity(x, y, z)).setgrassLevel(grass + itemamount);
				item.stackSize = 0;
			}
		}
		else if(item.getItem() != null)
		{
			System.out.println(grass);
		}
	    return false;
	}
	
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
        p_149670_5_.motionX *= 0.1D;
        p_149670_5_.motionZ *= 0.1D;
    }
	
}