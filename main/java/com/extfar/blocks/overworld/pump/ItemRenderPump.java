package com.extfar.blocks.overworld.pump;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderPump implements IItemRenderer {

private ModelPump PumpModel;

public ItemRenderPump() {

PumpModel = new ModelPump();
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
	TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPump(), 0.0D, 0.0D, 0.0D, 0.0F);
}
}