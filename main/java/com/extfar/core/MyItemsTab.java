package com.extfar.core;


import com.extfar.init.ExtendedFarmingBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyItemsTab extends CreativeTabs
{
	public MyItemsTab(int i, String label) {
		super(label);

	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer);
	}
}
