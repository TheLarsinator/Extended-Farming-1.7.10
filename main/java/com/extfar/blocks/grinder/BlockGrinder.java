package com.extfar.blocks.grinder;

import java.util.Random;
import com.extfar.init.ExtendedFarmingItems;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;

public class BlockGrinder extends Block implements ITileEntityProvider
{

	public BlockGrinder(Material material) 
	{
		super(material);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
		this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.7F, 0.9F);
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	   
		if(player.getHeldItem() != null)
		{
	      Item heldItem = player.getHeldItem().getItem();
	      int stack = player.getHeldItem().stackSize;
	      TileEntityGrinder grinder = ((TileEntityGrinder)world.getTileEntity(x, y, z));
	      
	      if(heldItem != null && heldItem == Items.wheat && stack >= 2 && grinder.wheatAmount == 0 && !grinder.isDone)
	      {
	    	  grinder.setWheat(true);
	    	  grinder.setWheatAmount(2);
	    	  player.inventory.consumeInventoryItem(Items.wheat);
	    	  player.inventory.consumeInventoryItem(Items.wheat);
	      }
	      else if(heldItem != null && heldItem == Items.wheat && grinder.wheatAmount != 2 && !grinder.isDone)
	      {
	    	  grinder.setWheat(true);
	    	  grinder.setWheatAmount(grinder.wheatAmount +1);
	    	  player.inventory.consumeInventoryItem(Items.wheat);
	      }
	      else if(heldItem != null && heldItem == Item.getItemFromBlock(Blocks.cobblestone) && grinder.wheatAmount == 2 && grinder.hasWheat && !grinder.isDone)
	      {
	    	  grinder.setSlab(true);
	    	  player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.cobblestone));
	      }
	      else if(heldItem != null && grinder.isDone)
	      {
	    	  grinder.setDone(false);
	    	  grinder.setSlab(false);
	    	  grinder.setWheat(false);
	    	  grinder.setWheatAmount(0);
	    	  player.inventory.addItemStackToInventory(new ItemStack(Blocks.cobblestone));
	    	  player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.Flour, 2));
	      }
		}
	      return true;
	}
	
}


