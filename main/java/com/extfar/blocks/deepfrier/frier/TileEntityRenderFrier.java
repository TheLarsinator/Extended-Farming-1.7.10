package com.extfar.blocks.deepfrier.frier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;
import com.extfar.core.RenderHelper;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

public class TileEntityRenderFrier extends TileEntitySpecialRenderer
{
	ItemStack stack = new ItemStack(ExtendedFarmingItems.RawPotatoChips, 1, 0);
	EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D,
			0D, 0D, stack);

	ItemStack stack1 = new ItemStack(ExtendedFarmingItems.PotatoChips, 1, 0);
	EntityItem entItem1 = new EntityItem(Minecraft.getMinecraft().theWorld, 0D,
			0D, 0D, stack1);

	public TileEntityRenderFrier()
	{
		model = new ModelFrier();
	}

	public void renderAModelAt(TileEntityFrier tile, double d, double d1,
			double d2, float f)
	{

		int rotation = 0;
		if (tile.getWorldObj() != null)
		{
			rotation = tile.getBlockMetadata();
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(
				ExtendedFarming.modid, "textures/blocks/Frier.png"));

		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);

		model.renderAll(0.0625F);
		
	/*	if (tile.hasWheat && !tile.isDone)
		{
			// Without the below line, the item will spazz out
			this.entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			// GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.3F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(this.entItem, -0.1D, -0.1D, 1.2D, 0F, 0.0F);
			if (tile.wheatAmount == 2)
			{
				RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.1D, -0.3D, 1.2D, 0F, 0.0F);
			}
			RenderItem.renderInFrame = false;
		}
		else if (tile.hasWheat && tile.isDone)
		{
			// Without the below line, the item will spazz out
			this.entItem1.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			// GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.3F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(this.entItem1, -0.1D, -0.1D, 1.2D, 0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(this.entItem1, 0.1D, -0.3D, 1.2D, 0F, 0.0F);
			RenderItem.renderInFrame = false;

		}*/
		GL11.glPopMatrix(); // end
	}

	private ModelFrier model;

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2,
			double par4, double par6, float par8)
	{
		this.renderAModelAt((TileEntityFrier) par1TileEntity, par2, par4,
				par6, par8);
		
		TileEntityFrier tile = (TileEntityFrier)par1TileEntity;
		
		if(tile.hasOil)
		{
        int[] displayList = RenderHelper.getFluidDisplayLists(tile.getWorldObj(), ExtendedFarmingBlocks.OilFluid, ExtendedFarmingBlocks.MilkLiquid);
        GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.bindTexture(TextureMap.locationBlocksTexture);
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glScalef(0.8f, 0.1f, 0.79f);
        GL11.glTranslatef(0.1f, 5f, 0.2f);
        GL11.glCallList(displayList[7]);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
		}
	}
}
