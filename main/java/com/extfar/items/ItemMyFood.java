package com.extfar.items;

import com.extfar.core.ExtendedFarming;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemMyFood extends ItemFood 
{

	public ItemMyFood(int par1, float par3, boolean par4)
	{
		super(par1, par3, par4);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
	}

}
