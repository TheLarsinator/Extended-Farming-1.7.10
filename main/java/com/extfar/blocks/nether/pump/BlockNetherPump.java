package com.extfar.blocks.nether.pump;

import java.util.List;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.extfar.blocks.nether.hose.BlockActiveNetherHose;
import com.extfar.blocks.nether.hose.BlockNetherHose;
import com.extfar.blocks.nether.hose.BlockNetherHoseBase;
import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherPump extends BlockNetherHoseBase implements ITileEntityProvider 
{
	public BlockNetherPump(Material rock) 
	{
		super(rock);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
		this.setTickRandomly(true);
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
		return new TileEntityNetherPump();
	}
	
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World p_149738_1_)
    {
        return 1;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
	
    /**
     * Ticks the block if it's been scheduled
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random random) 
    {
    	if(world.getBlock(i, j-1, k) == Blocks.lava)
    	{
    		
    	if(world.getBlock(i+1, j, k) instanceof BlockNetherHose)
    	{
    		world.setBlock(i+1, j, k, ExtendedFarmingBlocks.ActiveNetherHose, world.getBlockMetadata(i+1, j, k), 2);
    	}
    	if(world.getBlock(i-1, j, k) instanceof BlockNetherHose)
    	{
    		world.setBlock(i-1, j, k, ExtendedFarmingBlocks.ActiveNetherHose, world.getBlockMetadata(i-1, j, k), 2);
    	}
    	if(world.getBlock(i, j, k+1) instanceof BlockNetherHose)
    	{
    		world.setBlock(i, j, k+1, ExtendedFarmingBlocks.ActiveNetherHose, world.getBlockMetadata(i, j, k+1), 2);
    	}
    	if(world.getBlock(i, j, k-1) instanceof BlockNetherHose)
    	{
    		world.setBlock(i, j, k-1, ExtendedFarmingBlocks.ActiveNetherHose, world.getBlockMetadata(i+1, j, k-1), 2);
    	}
    	}
    	else
    	{
        	if(world.getBlock(i+1, j, k) instanceof BlockActiveNetherHose)
        	{
        		world.setBlock(i+1, j, k, ExtendedFarmingBlocks.PassiveNetherHose, world.getBlockMetadata(i+1, j, k), 2);
        	}
        	if(world.getBlock(i-1, j, k) instanceof BlockActiveNetherHose)
        	{
        		world.setBlock(i-1, j, k, ExtendedFarmingBlocks.PassiveNetherHose, world.getBlockMetadata(i-1, j, k), 2);
        	}
        	if(world.getBlock(i, j, k+1) instanceof BlockActiveNetherHose)
        	{
        		world.setBlock(i, j, k+1, ExtendedFarmingBlocks.PassiveNetherHose, world.getBlockMetadata(i, j, k+1), 2);
        	}
        	if(world.getBlock(i, j, k-1) instanceof BlockActiveNetherHose)
        	{
        		world.setBlock(i, j, k-1, ExtendedFarmingBlocks.PassiveNetherHose, world.getBlockMetadata(i+1, j, k-1), 2);
        	}
    	}
    }
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {

        this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

    	
        this.setBlockBoundsForItemRender();
    }
}
