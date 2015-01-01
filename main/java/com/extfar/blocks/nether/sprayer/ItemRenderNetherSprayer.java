package com.extfar.blocks.nether.sprayer;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderNetherSprayer implements IItemRenderer {

private ModelSprayer SprayerModel;

public ItemRenderNetherSprayer() {

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
	TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityNetherSprayer(), 0.0D, 0.0D, 0.0D, 0.0F);
}
}