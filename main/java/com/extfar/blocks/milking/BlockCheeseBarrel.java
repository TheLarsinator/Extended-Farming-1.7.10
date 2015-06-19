package com.extfar.blocks.milking;

import java.util.Random;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingItems;
import com.lom.lotsomobsinit.LotsOMobsItems;
import com.lom.lotsomobstileentity.saltbath.TileEntitySaltBath;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCheeseBarrel extends Block implements ITileEntityProvider
{

	public BlockCheeseBarrel(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setCreativeTab(ExtendedFarming.ItemsTab);

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
	      if(heldItem != null && heldItem.getItem() == Items.wooden_sword)
	      {
	    	  System.out.print("Has Cheese: ");
	    	  System.out.println(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasCheese);
	    	  System.out.print("Has Milk: ");
	    	  System.out.println(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasMilk);
	    	  
	      }
	      if(heldItem != null && heldItem.getItem() == ExtendedFarmingItems.GoatMilk_Bucket && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasCheese == false && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasMilk == false)
	      {
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setHasMilk(true);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(5);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(0);         
	          player.inventory.consumeInventoryItem(ExtendedFarmingItems.GoatMilk_Bucket);
	          player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
	      }
	      if(heldItem == null && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasCheese == true)
	      {
	    	  player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.GoatCheese, 1));
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setHasMilk(false);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setHasCheese(false);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(0);
	          ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(0);         
	      }
	      return false;
	}
	
  /*  public void randomDisplayTick(World world, int x, int y, int z, Random rand) 
    {
    	if(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasMilk && !((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).hasCheese && world.isRemote)
    	{
        	System.out.println(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount);
    		((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount - rand.nextFloat()/1);  		
    		
    		if(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount > 4 && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount <= 5F)
    		{ 
  	          // ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(4);
	           ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(0);         
    		}
    		else if(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount > 3 && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount <= 4)
    		{
    	      // ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(3);
    	       ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(1); 
    		}
    		else if(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount > 2 && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount <= 3)
    		{
    	      // ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(2);
    	       ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(2); 
    		}
    		else if(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount > 1 && ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount <= 2)
    		{
    	       //((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(1);
    	       ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(3); 
    		}
    		else if(((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).milkAmount < 0)
    		{
    	       ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setMilkAmount(0);
    	       ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setCheeseAmount(3);
 	           ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setHasMilk(false);
 	           ((TileEntityCheeseBarrel)world.getTileEntity(x, y, z)).setHasCheese(true);
    		}   		
    	}
    }*/



}
