package com.extfar.blocks.milking;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderCheeseBarrel implements IItemRenderer {

private ModelCheeseBarrel CheeseBarrelModel;

public ItemRenderCheeseBarrel() {

CheeseBarrelModel = new ModelCheeseBarrel();
}

@Override
public boolean handleRenderType(ItemStack item, ItemRenderType type) {

return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
	TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCheeseBarrel(), 0.0D, 0.0D, 0.0D, 0.0F);
}
}