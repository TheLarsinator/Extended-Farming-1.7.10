package com.extfar.blocks.overworld.sprayer;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderSprayer implements IItemRenderer {

private ModelSprayer SprayerModel;

public ItemRenderSprayer() {

SprayerModel = new ModelSprayer();
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
	TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySprayer(), 0.0D, 0.0D, 0.0D, 0.0F);
}
}