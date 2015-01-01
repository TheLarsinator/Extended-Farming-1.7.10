package com.extfar.blocks.nether.sprayer;

import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.extfar.blocks.nether.hose.BlockActiveNetherHose;
import com.extfar.blocks.nether.hose.BlockNetherHoseBase;
import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherSprayer extends BlockNetherHoseBase implements ITileEntityProvider 
{

	public BlockNetherSprayer(Material material) 
	{
		super(material);
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
		return new TileEntityNetherSprayer();
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
     * Ticks the block if it's been scheduled
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random random) 
    {
    	if((world.getBlock(i, j, k-1) instanceof BlockActiveNetherHose)||(world.getBlock(i+1, j, k) instanceof BlockActiveNetherHose)||(world.getBlock(i-1, j, k) instanceof BlockActiveNetherHose)||(world.getBlock(i, j+1, k) instanceof BlockActiveNetherHose)||(world.getBlock(i, j-1, k) instanceof BlockActiveNetherHose)||(world.getBlock(i, j, k+1) instanceof BlockActiveNetherHose))
    	{
    		world.setBlock(i, j, k, ExtendedFarmingBlocks.ActiveNetherSprayer, world.getBlockMetadata(i, j, k), 2);
    	}

    }

}
