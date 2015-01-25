package com.extfar.items;

import net.minecraft.item.Item;

import com.extfar.core.ExtendedFarming;

public class ItemMaterials extends Item
{
    public ItemMaterials()
    {
        super();
        this.maxStackSize = 64;
        this.setCreativeTab(ExtendedFarming.ItemsTab);
        
    }
}
