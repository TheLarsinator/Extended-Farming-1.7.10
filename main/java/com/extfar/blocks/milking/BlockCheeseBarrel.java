package com.extfar.blocks.milking;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingItems;

public class BlockCheeseBarrel extends Block implements ITileEntityProvider
{

	public BlockCheeseBarrel(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
		this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.7F, 0.9F);

	}

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World p_149738_1_)
    {
        return 1;
    }
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityCheeseBarrel();
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
	* called everytime the player right clicks this block
	*/
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	   
	      ItemStack heldItem = player.getHeldItem();
	      Random rand = new Random();
	      if(heldItem != null && heldItem.getItem() == Items.wooden_sword)
	      {
	    	  System.out.print("Has Milk: ");
	    	  System.out.println(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount);
	    	  System.out.print("Has Cheese: ");
	    	  System.out.println(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).cheeseAmount);
	    	  
	      }
	      else if(heldItem != null && heldItem.getItem() == ExtendedFarmingItems.GoatMilk_Bucket && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).cheeseAmount == 0 && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount == 0)
	      {
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(5);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(0);         
	          player.inventory.consumeInventoryItem(ExtendedFarmingItems.GoatMilk_Bucket);
	          player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
	      }
	      if(heldItem == null && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).cheeseAmount == 3)
	      {
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(0);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(0);    
	    	  player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.GoatCheese));

	      }

	      return true;
	}
	
    public void randomDisplayTick(World worldObj, int xCoord, int yCoord, int zCoord, Random rand) 
    {

    }



}
