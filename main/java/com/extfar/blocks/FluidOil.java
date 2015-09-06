package com.extfar.blocks;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.FMLLog;

/**
 * Minecraft Forge Fluid Implementation
 *
 * This class is a fluid (liquid or gas) equivalent to "Item." It describes the nature of a fluid
 * and contains its general properties.
 *
 * These properties do not have inherent gameplay mechanics - they are provided so that mods may
 * choose to take advantage of them.
 *
 * Fluid implementations are not required to actively use these properties, nor are objects
 * interfacing with fluids required to make use of them, but it is encouraged.
 *
 * The default values can be used as a reference point for mods adding fluids such as oil or heavy
 * water.
 *
 * @author King Lemming
 *
 */
public class FluidOil extends Fluid
{

    public FluidOil(String fluidName)
    {
        this.fluidName = fluidName.toLowerCase(Locale.ENGLISH);
        this.unlocalizedName = fluidName;
    }

    public Fluid setUnlocalizedName(String unlocalizedName)
    {
        this.unlocalizedName = unlocalizedName;
        return this;
    }

    public Fluid setBlock(Block block)
    {
        if (this.block == null || this.block == block)
        {
            this.block = block;
        }
        else
        {
            FMLLog.warning("A mod has attempted to assign Block " + block + " to the Fluid '" + fluidName + "' but this Fluid has already been linked to the Block "
                    + this.block + ". You may have duplicate Fluid Blocks as a result. It *may* be possible to configure your mods to avoid this.");
        }
        return this;
    }

    public Fluid setLuminosity(int luminosity)
    {
        this.luminosity = luminosity;
        return this;
    }

    public Fluid setDensity(int density)
    {
        this.density = density;
        return this;
    }

    public Fluid setTemperature(int temperature)
    {
        this.temperature = temperature;
        return this;
    }

    public Fluid setViscosity(int viscosity)
    {
        this.viscosity = viscosity;
        return this;
    }

    public Fluid setGaseous(boolean isGaseous)
    {
        this.isGaseous = isGaseous;
        return this;
    }

    public Fluid setRarity(EnumRarity rarity)
    {
        this.rarity = rarity;
        return this;
    }

    /**
     * Returns 0 for "/terrain.png". ALL FLUID TEXTURES MUST BE ON THIS SHEET.
     */
    public final int getSpriteNumber()
    {
        return 0;
    }

    /* Default Accessors */
    public final int getLuminosity()
    {
        return this.luminosity;
    }

    public final int getDensity()
    {
        return this.density;
    }

    public final int getTemperature()
    {
        return this.temperature;
    }

    public final int getViscosity()
    {
        return this.viscosity;
    }

    public final boolean isGaseous()
    {
        return this.isGaseous;
    }

    public EnumRarity getRarity()
    {
        return rarity;
    }

    public int getColor()
    {
        return 0xFFFFFF;
    }

    @Override
    public final Fluid setStillIcon(IIcon stillIcon)
    {
        this.stillIcon = stillIcon;
        return this;
    }

    public final Fluid setFlowingIcon(IIcon flowingIcon)
    {
        this.flowingIcon = flowingIcon;
        return this;
    }

    public final Fluid setIcons(IIcon stillIcon, IIcon flowingIcon)
    {
        return this.setStillIcon(stillIcon).setFlowingIcon(flowingIcon);
    }

    public final Fluid setIcons(IIcon commonIcon)
    {
        return this.setStillIcon(commonIcon).setFlowingIcon(commonIcon);
    }

    public IIcon getIcon(){ return getStillIcon(); }

    public IIcon getStillIcon()
    {
        return this.stillIcon;
    }

    public IIcon getFlowingIcon()
    {
        return this.flowingIcon;
    }

    /* Stack-based Accessors */
    public int getLuminosity(FluidStack stack){ return getLuminosity(); }
    public int getDensity(FluidStack stack){ return getDensity(); }
    public int getTemperature(FluidStack stack){ return getTemperature(); }
    public int getViscosity(FluidStack stack){ return getViscosity(); }
    public boolean isGaseous(FluidStack stack){ return isGaseous(); }
    public EnumRarity getRarity(FluidStack stack){ return getRarity(); }
    public int getColor(FluidStack stack){ return getColor(); }
    public IIcon getIcon(FluidStack stack){ return getIcon(); }
    /* World-based Accessors */
    public int getLuminosity(World world, int x, int y, int z){ return getLuminosity(); }
    public int getDensity(World world, int x, int y, int z){ return getDensity(); }
    public int getTemperature(World world, int x, int y, int z){ return getTemperature(); }
    public int getViscosity(World world, int x, int y, int z){ return getViscosity(); }
    public boolean isGaseous(World world, int x, int y, int z){ return isGaseous(); }
    public EnumRarity getRarity(World world, int x, int y, int z){ return getRarity(); }
    public int getColor(World world, int x, int y, int z){ return getColor(); }
    public IIcon getIcon(World world, int x, int y, int z){ return getIcon(); }

}O