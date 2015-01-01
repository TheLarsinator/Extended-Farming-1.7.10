package com.extfar.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMyWaterCrops extends BlockCrops
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149867_a;
    private Item SeedItem;
    private Item CropItem;
    private int RenderType;
    private int Stages;

    public BlockMyWaterCrops(Item seed, Item crop, int render, int stages)
    {
        super();
        this.SeedItem = seed;
        this.CropItem = crop;
        this.RenderType = render;
        this.Stages = stages;     
    }
    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        return  true;
    }
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
    	if(world.getBlock(x, y+1, z) == Blocks.water && world.getBlock(x, y, z) == Blocks.dirt)
    	{
        return true;
    	}
    	else
    	{
    	return false;
    	}
    }

    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == Blocks.dirt;
    }
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ < 7)
        {
        	if(p_149691_2_ == 6)
        	{
            p_149691_2_ = 5;
        	}
        	return this.field_149867_a[p_149691_2_ >> 1];
        }
        else
        {
        return this.field_149867_a[3];
        }
    }
    protected Item func_149866_i()
    {
        return SeedItem;
    }

    protected Item func_149865_P()
    {
        return CropItem;
    }
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return RenderType;
    }

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_149867_a = new IIcon[Stages];

        for (int i = 0; i < this.field_149867_a.length; ++i)
        {
            this.field_149867_a[i] = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getUnlocalizedName() + "_stage_" + i);
        }
    }
}
