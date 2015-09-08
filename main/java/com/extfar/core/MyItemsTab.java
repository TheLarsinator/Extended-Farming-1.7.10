package com.extfar.core;


import com.extfar.init.ExtendedFarmingBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyItemsTab extends CreativeTabs
{
	public MyItemsTab(int i, String label) {
		super(i, label);
		this.setBackgroundImageName("item_search.png");

	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer);
	}
	
	@Override
	public boolean hasSearchBar()
	{
		return true;
	}
}
