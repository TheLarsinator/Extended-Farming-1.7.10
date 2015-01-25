package com.extfar.items;

import net.minecraft.item.Item;

import com.extfar.core.ExtendedFarming;

public class ItemTractorParts extends Item
{
    public ItemTractorParts(int var1)
    {
        super();
		this.setHasSubtypes(true);
        this.maxStackSize = 1;
        this.setCreativeTab(ExtendedFarming.ItemsTab);
        
    }
}