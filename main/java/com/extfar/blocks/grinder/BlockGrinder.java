package com.extfar.blocks.grinder;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.extfar.animals.entity.EntityGoat;
import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingItems;

public class BlockGrinder extends Block implements ITileEntityProvider
{

	public BlockGrinder(Material material) 
	{
		super(material);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityGrinder();
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
	public void onEntityWalking(World world, int i, int j, int k, Entity entity) 
	{

	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	   
	      ItemStack heldItem = player.getHeldItem();

	      return false;
	}
	
}
