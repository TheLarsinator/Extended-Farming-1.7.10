package com.extfar.blocks.milking;

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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMilkingStation extends Block implements ITileEntityProvider
{

	public BlockMilkingStation(Material material) 
	{
		super(material);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityMilkingStation();
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
		//System.out.println("Someone walks on me!");
		if(entity instanceof EntityGoat && ((TileEntityMilkingStation)world.getTileEntity(i, j, k)).milkAmount < 8)
		{
			((TileEntityMilkingStation)world.getTileEntity(i, j, k)).setMilkAmount(((TileEntityMilkingStation)world.getTileEntity(i, j, k)).milkAmount +1);
		}
		entity.motionX *= 0.1D;
		entity.motionZ *= 0.1D;
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	   
	      ItemStack heldItem = player.getHeldItem();
	   /*   if(heldItem != null)
	      {
	    	  System.out.println(((TileEntityMilkingStation)world.getTileEntity(x, y, z)).milkAmount);
	      }*/
	      if(heldItem != null && heldItem.getItem() == Items.bucket && ((TileEntityMilkingStation)world.getTileEntity(x, y, z)).milkAmount >= 1 && player.inventory.getFirstEmptyStack() != -1)
	      {
	          ((TileEntityMilkingStation)world.getTileEntity(x, y, z)).setMilkAmount(((TileEntityMilkingStation)world.getTileEntity(x, y, z)).milkAmount - 1);
	          player.inventory.consumeInventoryItem(Items.bucket);
	          player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.GoatMilk_Bucket, 1));
	      }
	      else if(heldItem != null && heldItem.getItem() == Items.bucket && ((TileEntityMilkingStation)world.getTileEntity(x, y, z)).milkAmount >= 1 && player.inventory.getFirstEmptyStack() == -1)
	      {
	          ((TileEntityMilkingStation)world.getTileEntity(x, y, z)).setMilkAmount(((TileEntityMilkingStation)world.getTileEntity(x, y, z)).milkAmount - 1);
	          player.inventory.consumeInventoryItem(Items.bucket);
	          if(!world.isRemote)
	          player.dropItem(ExtendedFarmingItems.GoatMilk_Bucket, 1);
	      }
	      return false;
	}
    
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	{
		if(par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
		    this.setBlockBounds(0.0F, 1.0F, -0.3F, 1F, 2F, 0F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		    this.setBlockBounds(0F, 1.0F, 1.0F, 1F, 2F, 1.3F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		  this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		  super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 2)
		{
		    this.setBlockBounds(-0.3F, 1.0F, 0.0F, 0F, 2F, 1F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		    this.setBlockBounds(1F, 1.0F, 0.0F, 1.3F, 2F, 1F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		  this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		  super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 3)
		{
		    this.setBlockBounds(0.0F, 1.0F, -0.3F, 1F, 2F, 0F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		    this.setBlockBounds(0F, 1.0F, 1.0F, 1F, 2F, 1.3F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		  this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		  super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
		    this.setBlockBounds(-0.3F, 1.0F, 0.0F, 0F, 2F, 1F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		    this.setBlockBounds(1F, 1.0F, 0.0F, 1.3F, 2F, 1F);
		    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		  this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		  super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		
	    this.setBlockBoundsForItemRender();
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
