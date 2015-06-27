package com.extfar.blocks.grinder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;

public class TileEntityRenderGrinder extends TileEntitySpecialRenderer
{
	ItemStack stack = new ItemStack(Items.wheat, 1, 0);
	EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack);
	
	
	public TileEntityRenderGrinder()
	{
		model = new ModelGrinder();
		}

		public void renderAModelAt(TileEntityGrinder tile, double d, double d1, double d2, float f) {

		int rotation = 0;
		if(tile.getWorldObj() != null)
		{
		rotation = tile.getBlockMetadata();
		}
		if(tile.hasWheat)
		{
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/Grinder0.png"));
		}
		else
		{
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/Grinder1.png"));
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);
		model.renderAll(0.0625F);
		//Without the below line, the item will spazz out
		this.entItem.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		//GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.3F);
		GL11.glRotatef(180, 0, 1, 1);
		RenderManager.instance.renderEntityWithPosYaw(this.entItem, -0.1D, -0.1D, 1.2D, 0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix(); //end
		}

		private ModelGrinder model;

		public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
		{
		this.renderAModelAt((TileEntityGrinder)par1TileEntity, par2, par4, par6, par8);
		}
}
    






