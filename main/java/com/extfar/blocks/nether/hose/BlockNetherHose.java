package com.extfar.blocks.nether.hose;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherHose extends BlockNetherHoseBase implements ITileEntityProvider 
{
	public static int rotangle = new Random().nextInt(3);

	public BlockNetherHose(Material rock) 
	{
		super(Material.rock);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
		this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	@Override
	public int getRenderType() {
		return -1;
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getTextureName()+"item");
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

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityNetherHose();
	}
	
	/**
	 * Called when the block is placed in the world. Used to check where other hoses are and to render correct connections
	 */
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		if((world.getBlock(i, j, k+1) instanceof BlockActiveNetherHose) || (world.getBlock(i-1, j, k) instanceof BlockActiveNetherHose) || (world.getBlock(i, j, k-1) instanceof BlockActiveNetherHose)|| (world.getBlock(i+1, j, k) instanceof BlockActiveNetherHose)||(world.getBlock(i, j, k-1) instanceof BlockActiveNetherHose)|| (world.getBlock(i, j-1, k) instanceof BlockActiveNetherHose)|| (world.getBlock(i, j+1, k) instanceof BlockActiveNetherHose))
		{
			world.setBlock(i, j, k, ExtendedFarmingBlocks.ActiveNetherHose, world.getBlockMetadata(i, j, k), 2);
		}
		int M = 0;
		//Checking where to connect with metadata
		if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 0;
			}
			else
			{
			M=16;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 1;
			}
			else
			{
			M=17;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 2;
			}
			else
			{
			M=18;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 3;
			}
			else
			{
			M=19;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 4;
			}
			else
			{
			M=20;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 5;
			}
			else
			{
			M=21;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 6;
			}
			else
			{
			M=22;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 7;
			}
			else
			{
			M=23;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 8;
			}
			else
			{
			M=24;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 9;
			}
			else
			{
			M=25;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 10;
			}
			else
			{
			M=26;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 11;
			}
			else
			{
			M=27;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 12;
			}
			else
			{
			M=28;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 13;
			}
			else
			{
			M=29;
			}		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 14;
			}
			else
			{
			M=30;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 15;
			}
			else
			{
			M=31;
			};
		}
			world.setBlockMetadataWithNotify(i, j, k, M, 2);
	}
	
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World p_149738_1_)
    {
        return 1;
    }
	
    /**
     * Ticks the block if it's been scheduled
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random random) 
    {
		if((world.getBlock(i, j, k+1) instanceof BlockActiveNetherHose) || (world.getBlock(i-1, j, k) instanceof BlockActiveNetherHose) || (world.getBlock(i, j, k-1) instanceof BlockActiveNetherHose)|| (world.getBlock(i+1, j, k) instanceof BlockActiveNetherHose)||(world.getBlock(i, j, k-1) instanceof BlockActiveNetherHose)|| (world.getBlock(i, j-1, k) instanceof BlockActiveNetherHose)|| (world.getBlock(i, j+1, k) instanceof BlockActiveNetherHose))
		{
			world.setBlock(i, j, k, ExtendedFarmingBlocks.ActiveNetherHose, world.getBlockMetadata(i, j, k), 2);
		}

		int M = 0;
		//Checking where to connect with metadata
		if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 0;
			}
			else
			{
			M=16;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 1;
			}
			else
			{
			M=17;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 2;
			}
			else
			{
			M=18;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 3;
			}
			else
			{
			M=19;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 4;
			}
			else
			{
			M=20;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 5;
			}
			else
			{
			M=21;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 6;
			}
			else
			{
			M=22;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 7;
			}
			else
			{
			M=23;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 8;
			}
			else
			{
			M=24;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 9;
			}
			else
			{
			M=25;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& !(world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 10;
			}
			else
			{
			M=26;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 11;
			}
			else
			{
			M=27;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 12;
			}
			else
			{
			M=28;
			}
		}
		else if(!(world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 13;
			}
			else
			{
			M=29;
			}		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && !(world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && (world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 14;
			}
			else
			{
			M=30;
			}
		}
		else if((world.getBlock(i, j, k+1) instanceof BlockNetherHoseBase) && (world.getBlock(i-1, j, k) instanceof BlockNetherHoseBase) && !(world.getBlock(i, j, k-1) instanceof BlockNetherHoseBase)&& (world.getBlock(i+1, j, k) instanceof BlockNetherHoseBase))
		{
			if(!(world.getBlock(i, j+1, k) instanceof BlockNetherHoseBase))
			{
			M = 15;
			}
			else
			{
			M=31;
			}
		}
			world.setBlockMetadataWithNotify(i, j, k, M, 2);
    	
    }

}
