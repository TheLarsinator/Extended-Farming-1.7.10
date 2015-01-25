package com.extfar.blocks.overworld.sprayer;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.extfar.blocks.BlockCropSupport;
import com.extfar.blocks.overworld.hose.BlockActiveHose;
import com.extfar.blocks.overworld.hose.BlockHoseBase;
import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockActiveSprayer extends BlockHoseBase implements ITileEntityProvider 
{

	public BlockActiveSprayer(Material material) 
	{
		super(Material.water);
		this.setCreativeTab(null);
		this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
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
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {

        this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

    	
        this.setBlockBoundsForItemRender();
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
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int p_149664_5_) 
    {
    	
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
		return new TileEntityActiveSprayer();
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int i, int j, int k, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
	    int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
	    par1World.setBlockMetadataWithNotify(i, j, k, l, 2);
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
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		for(int xCoord = -3; xCoord < 4; ++xCoord)
		{
				for(int zCoord = -3; zCoord < 4; ++zCoord)
				{
					if(world.getBlock(xCoord, j-1, zCoord)==Blocks.farmland)
					{
						world.setBlockMetadataWithNotify(xCoord, j-1, zCoord, 100, 2);
					}
				}
		}
        return true;
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random random) 
    {
		int[] x = {-3, -2, -1, 0, 1, 2, 3};
		int[] y = {-1, 0, 1};
		int[] z = {-3, -2, -1, 0, 1, 2, 3};
		int l;
	/*	for(int xCoord = -3; xCoord < 4; ++xCoord)
		{
				for(int zCoord = -3; zCoord < 4; ++zCoord)
				{
					Block block = world.getBlock(k +xCoord, j+1, zCoord);
					int metadata = world.getBlockMetadata(xCoord, j+1, zCoord);
					if(block instanceof BlockCrops || block instanceof BlockCropSupport)
					{
						world.setBlock(i+xCoord, j-1, k+zCoord, Blocks.farmland, 7, 2);

					}
					world.setBlock(i+xCoord, j-1, k+zCoord, Blocks.farmland, 7, 2);
					
					int a = i + xCoord;
					int b = j - 1;
					int c = k + zCoord;
					
					System.out.println("X: " + a + ", Y: " + b + ", Z: " + c);
				}
		}*/

		if(world.isRemote)
		{
		for(int xCoord = -4; xCoord < 5; ++xCoord)
		{
				for(int zCoord = -4; zCoord < 5; ++zCoord)
				{
					if(world.getBlock(i+xCoord, j-1, k+zCoord)==Blocks.farmland)
					{
						world.setBlockMetadataWithNotify(i+xCoord, j-1, k+zCoord, 7, 2);
					}
				}
		}
		}
		for(float a = -5.0F; a <= 5F; ++a)
		{
			for(float c = -5.0F; c <= 5.0F; ++c)
			{
		          world.spawnParticle("splash", i + 0.7D, j+1F, k + 0.7D, (double)a/10, 0.0D, (double)c/10);
			}
		}
          
          
    	if((world.getBlock(i, j, k-1) instanceof BlockActiveHose)||(world.getBlock(i+1, j, k) instanceof BlockActiveHose)||(world.getBlock(i-1, j, k) instanceof BlockActiveHose)||(world.getBlock(i, j+1, k) instanceof BlockActiveHose)||(world.getBlock(i, j-1, k) instanceof BlockActiveHose)||(world.getBlock(i, j, k+1) instanceof BlockActiveHose))
    	{

    	}
    	else
    	{
    		world.setBlock(i, j, k, ExtendedFarmingBlocks.Sprayer, world.getBlockMetadata(i, j, k), 2);
    	}

    }
    
    

}
