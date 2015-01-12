package com.extfar.blocks.nether;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFarmSoulSand extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_149824_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_149823_b;
    private static final String __OBFID = "CL_00000241";

    public BlockFarmSoulSand()
    {
        super(Material.ground);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
   }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return AxisAlignedBB.getBoundingBox((double)(p_149668_2_ + 0), (double)(p_149668_3_ + 0), (double)(p_149668_4_ + 0), (double)(p_149668_2_ + 1), (double)(p_149668_3_ + 1), (double)(p_149668_4_ + 1));
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

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? (p_149691_2_ > 0 ? this.field_149824_a : this.field_149823_b) : Blocks.soul_sand.getBlockTextureFromSide(p_149691_1_);
    }

    
    public void setToNetherPlant(World world, int i, int j, int k)
    {
    	int metadata = world.getBlockMetadata(i, j+1, k);

        //Set crops to their Nether Counterparts        
        if(world.getBlock(i, j+1, k) == ExtendedFarmingBlocks.Beans)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherBeans, metadata, 2);
        if(world.getBlock(i, j+1, k) == ExtendedFarmingBlocks.Peas)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherPeas, metadata, 2);
        if(world.getBlock(i, j+1, k) == ExtendedFarmingBlocks.ChilliPepper)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherPeppers, metadata, 2);
        if(world.getBlock(i, j+1, k) == ExtendedFarmingBlocks.Beets)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherBeets, metadata, 2);
        
        
        if(world.getBlock(i, j+1, k) == Blocks.potatoes)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherPotatoes, metadata, 2);
        if(world.getBlock(i, j+1, k) == Blocks.carrots)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherCarrots, metadata, 2);
        if(world.getBlock(i, j+1, k) == Blocks.wheat)
        	world.setBlock(i, j+1, k, ExtendedFarmingBlocks.NetherWheat, metadata, 2);
    }
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (!this.func_149821_m(world, i, j, k) && !world.canLightningStrikeAt(i, j + 1, k))
        {
            int l = world.getBlockMetadata(i, j, k);

            if (l > 0)
            {
            	world.setBlockMetadataWithNotify(i, j, k, l - 1, 2);
            }
            else if (!this.func_149822_e(world, i, j, k))
            {
            	world.setBlock(i, j, k, Blocks.soul_sand);
            }
        }
        else
        {
        	world.setBlockMetadataWithNotify(i, j, k, 7, 2);
        }
        
    	int metadata = world.getBlockMetadata(i, j+1, k);

    	if(!world.isRemote)
    	{
    		this.setToNetherPlant(world, i, j, k);
    	}
    	else
    	{
    		this.setToNetherPlant(world, i, j, k);
    	}
    }

    /**
     * Block's chance to react to an entity falling on it.
     */
    public void onFallenUpon(World p_149746_1_, int p_149746_2_, int p_149746_3_, int p_149746_4_, Entity p_149746_5_, float p_149746_6_)
    {
        if (!p_149746_1_.isRemote && p_149746_1_.rand.nextFloat() < p_149746_6_ - 0.5F)
        {
            if (!(p_149746_5_ instanceof EntityPlayer) && !p_149746_1_.getGameRules().getGameRuleBooleanValue("mobGriefing"))
            {
                return;
            }

            p_149746_1_.setBlock(p_149746_2_, p_149746_3_, p_149746_4_, Blocks.soul_sand);
        }
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random random) 
    {
    	if(world.getBlockMetadata(i, j, k)>0)
    	{
		for(int a = 0; a <= 5; ++a)
		{
			for(int c = 0; c <= 5; ++c)
			{
		          world.spawnParticle("flame", i + a/5F, j+1F, k + c/5F, 0.0D, 0.01D, 0.0D);
			}
		}
    	}
    	int metadata = world.getBlockMetadata(i, j+1, k);

    	if(!world.isRemote)
    	{
    		this.setToNetherPlant(world, i, j, k);

    	}
    	else
    	{
    		this.setToNetherPlant(world, i, j, k);
    	}
	}
    private boolean func_149822_e(World p_149822_1_, int p_149822_2_, int p_149822_3_, int p_149822_4_)
    {
        byte b0 = 0;

        for (int l = p_149822_2_ - b0; l <= p_149822_2_ + b0; ++l)
        {
            for (int i1 = p_149822_4_ - b0; i1 <= p_149822_4_ + b0; ++i1)
            {
                Block block = p_149822_1_.getBlock(l, p_149822_3_ + 1, i1);

                if (block instanceof IPlantable && canSustainPlant(p_149822_1_, p_149822_2_, p_149822_3_, p_149822_4_, ForgeDirection.UP, (IPlantable)block))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_149821_m(World p_149821_1_, int p_149821_2_, int p_149821_3_, int p_149821_4_)
    {
        for (int l = p_149821_2_ - 4; l <= p_149821_2_ + 4; ++l)
        {
            for (int i1 = p_149821_3_; i1 <= p_149821_3_ + 1; ++i1)
            {
                for (int j1 = p_149821_4_ - 4; j1 <= p_149821_4_ + 4; ++j1)
                {
                    if (p_149821_1_.getBlock(l, i1, j1).getMaterial() == Material.lava)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
        Material material = p_149695_1_.getBlock(p_149695_2_, p_149695_3_ + 1, p_149695_4_).getMaterial();

        if (material.isSolid())
        {
            p_149695_1_.setBlock(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.soul_sand);
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Blocks.soul_sand.getItemDropped(0, p_149650_2_, p_149650_3_);
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(Blocks.soul_sand);
    }
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
    	return true;
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_149824_a = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getTextureName() + "_wet");
        this.field_149823_b = p_149651_1_.registerIcon(ExtendedFarming.modid + ":" + this.getTextureName() + "_dry");
    }
}