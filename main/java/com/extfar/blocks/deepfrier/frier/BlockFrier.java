package com.extfar.blocks.deepfrier.frier;

import java.util.Random;

import com.extfar.core.ExtendedFarming;
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
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFrier extends Block implements ITileEntityProvider
{

	public BlockFrier(Material material) 
	{
		super(material);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.6875F, 0.9375F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityFrier();
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
	public boolean isOpaqueCube()
	{
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
	      TileEntityFrier frier = ((TileEntityFrier)world.getTileEntity(x, y, z));
	      
	      if(heldItem != null && heldItem == ExtendedFarmingItems.RawPotatoChips && !frier.hasPotato && !frier.isDone && frier.hasOil && !frier.hasDirtyOil)
	      {
	    	  frier.setPotato(true);
	    	  player.inventory.consumeInventoryItem(ExtendedFarmingItems.RawPotatoChips);
	      }
	      else if(heldItem != null && heldItem == ExtendedFarmingItems.FryingOil && !frier.hasPotato && !frier.hasOil && !frier.isDone)
	      {
	    	  player.getHeldItem().stackSize = player.getHeldItem().stackSize -1;
	    	  //player.inventory.consumeInventoryItem(ExtendedFarmingItems.FryingOil);
	    	  player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.EmptyCannister));
	    	  frier.setOil(true);
	    	 // if(!world.isRemote)
	    	//	  player.dropItem(ExtendedFarmingItems.EmptyCannister, 1);
	    	  //player.inventory.setInventorySlotContents(player.inventory.getFirstEmptyStack(), new ItemStack(ExtendedFarmingItems.EmptyCannister));
	    	  
	      }
	      else if(heldItem == ExtendedFarmingItems.Spoon && frier.isDone && frier.hasPotato)
	      {
	    	  frier.setDone(false);
	    	  if(frier.oilUsage > 13)
	    	  {
	    	  frier.setDirtyOil(true);
	    	  frier.setOilUsage(0);
	    	  }
	    	  else
	    	  {
	    		  frier.setOilUsage(frier.oilUsage + 1);
	    	  }
	    	  frier.setPotato(false);
	    	  player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.PotatoChips, 1));
	      }
	      else if(heldItem == ExtendedFarmingItems.EmptyCannister && frier.hasDirtyOil && !frier.hasPotato && !frier.isDone)
	      {
	    	  frier.setDirtyOil(false);
	    	  frier.setOil(false);
	    	  player.getHeldItem().stackSize = player.getHeldItem().stackSize -1;
	    	  player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.DirtyFryingOil, 1));
	      }
	      else if(heldItem == ExtendedFarmingItems.RawPotatoChips && frier.hasDirtyOil)
	      {
	    	  if(!world.isRemote)
	    	  player.addChatMessage(new ChatComponentTranslation("You can't cook that in dirty oil!"));
	      }
		}
	      return true;
	}
	
}
