package com.extfar.blocks.trees;

import java.util.Random;

import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFruitLeaf extends BlockLeaves  implements IGrowable
{

    private IIcon[] IconArray;
    private int Stages;

	public BlockFruitLeaf(int stageAmount) 
	{
		super();
		Stages = stageAmount;
	}

	@Override
	public String[] func_150125_e()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_,
			int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
	{
        return p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_,
			int p_149852_3_, int p_149852_4_, int p_149852_5_)
	{
        return true;
	}

	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_,
			int p_149853_3_, int p_149853_4_, int p_149853_5_)
	{
        this.func_149863_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
		
	}
    public void func_149863_m(World p_149863_1_, int p_149863_2_, int p_149863_3_, int p_149863_4_)
    {
        int l = p_149863_1_.getBlockMetadata(p_149863_2_, p_149863_3_, p_149863_4_) + MathHelper.getRandomIntegerInRange(p_149863_1_.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        p_149863_1_.setBlockMetadataWithNotify(p_149863_2_, p_149863_3_, p_149863_4_, l, 2);
    }
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.IconArray = new IIcon[Stages];

        for (int i = 0; i < this.IconArray.length; ++i)
        {
            this.IconArray[i] = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getTextureName() + "_stage_" + i);
        }
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 7)
        {
        	if(meta == 6)
        	{
        		meta = 5;
        	}
        	return this.IconArray[meta >> 1];
        }
        else
        {
        return this.IconArray[3];
        }
    }
}
