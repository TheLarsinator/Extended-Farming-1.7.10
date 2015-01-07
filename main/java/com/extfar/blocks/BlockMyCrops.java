package com.extfar.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMyCrops extends BlockCrops
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149867_a;
    private int SeedItem;
    private int CropItem;
    private int RenderType;
    private int Stages;
    private int Support;
    private int x;
    private int y;
    private int z;

    public BlockMyCrops(int seed, int crop, int render, int stages, int support)
    {
        super();
        this.SeedItem = seed;
        this.CropItem = crop;
        this.RenderType = render;
        this.Stages = stages;     
        this.Support = support;
    }

    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int tile) 
    {
    	if(Support == 1)
    	{
    		world.setBlock(i, j, k, ExtendedFarmingBlocks.BambooSticks);
    	}
    	else if(Support == 2)
    	{
    		world.setBlock(i, j, k, ExtendedFarmingBlocks.Net);
    	}
    	else if(Support == 0)
    	{
    		
    	}
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
        switch(SeedItem)
        {
        case 1:
        	return ExtendedFarmingItems.BeanSeeds;
        case 2:
        	return ExtendedFarmingItems.PeaSeeds;
        case 3:
        	return ExtendedFarmingItems.ChilliPepperSeeds;
        case 100:
        	return null;
        case 101:
        	return Items.wheat_seeds;
        case 0:
        default:
        	return null;
        }
    }

    protected Item getCrop()
    {
        switch(CropItem)
        {
        case 1:
        	return ExtendedFarmingItems.Beans;
        case 2:
        	return ExtendedFarmingItems.Peas;
        case 3:
        	return ExtendedFarmingItems.ChilliPeppers;
        case 4:
        	return ExtendedFarmingItems.SugarBeets;
        case 101:
        	return ExtendedFarmingItems.RoastedBeans;
        case 102:
        	return ExtendedFarmingItems.BakedPeas;
        case 103:
        	return ExtendedFarmingItems.RoastedPeppers;
        case 104:
        	return Items.baked_potato;
        case 105:
        	return ExtendedFarmingItems.RoastedCarrot;
        case 106:
        	return Items.bread; 	
        default:
        	return null;
        }
    }
    
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return p_149650_1_ == 7 ? this.getCrop() : this.func_149866_i();
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return p_149745_1_.nextInt(4);
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
            this.field_149867_a[i] = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getTextureName() + "_stage_" + i);
        }
    }
}
