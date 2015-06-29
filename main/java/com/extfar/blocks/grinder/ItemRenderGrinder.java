package com.extfar.blocks.grinder;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderGrinder implements IItemRenderer {

private ModelGrinder GrinderModel;

public ItemRenderGrinder() {

GrinderModel = new ModelGrinder();
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
	TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityGrinder(), 0.0D, 0.0D, 0.0D, 0.0F);
}
}