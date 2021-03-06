package com.extfar.blocks;

import com.extfar.core.ExtendedFarming;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDOilLiquid extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public IIcon[] fluidIcons;
    Fluid oil;

    public BlockDOilLiquid(Fluid fluid, Material material)
    {
        super(fluid, material);
        oil = fluid;
    }

    public IIcon getIcon(int side, int meta)
    {
        return side == 0 || side == 1 ? fluidIcons[0] : fluidIcons[1];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        fluidIcons = new IIcon[2];

        fluidIcons[0] = iconRegister.registerIcon(ExtendedFarming.modid + ":DOil_still");
        fluidIcons[1] = iconRegister.registerIcon(ExtendedFarming.modid + ":DOil_still");
        
        oil.setIcons(fluidIcons[0]);
    }

    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.canDisplace(world, x, y, z);
    }

    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.displaceIfPossible(world, x, y, z);
    }
}