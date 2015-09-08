package com.extfar.blocks.deepfrier.frier;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;
import com.extfar.core.RenderHelper;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderFrier extends TileEntitySpecialRenderer
{
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
		
		if(tile.foodType != -1)
		{
			ItemStack stack = new ItemStack(BlockFrier.Rfood[tile.foodType], 1, 0);
			EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack);

			ItemStack stack1 = new ItemStack(BlockFrier.Cfood[tile.foodType], 1, 0);
			EntityItem entItem1 = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack1);
		if (tile.hasPotato && !tile.isDone)
		{
			// Without the below line, the item will spazz out
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			// GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.3F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0D, -0.2D, 1.1D, 0F, 0.0F);
			RenderItem.renderInFrame = false;
		}
		else if (tile.hasPotato && tile.isDone)
		{
			// Without the below line, the item will spazz out
			entItem1.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			// GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.3F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 0D, -0.2D, 0.925D, 0F, 0.0F);
			RenderItem.renderInFrame = false;

		}
		}
		GL11.glPopMatrix(); // end
	}

	private ModelFrier model;

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2,
			double par4, double par6, float par8)
	{
		this.renderAModelAt((TileEntityFrier) par1TileEntity, par2, par4,
				par6, par8);
		
		TileEntityFrier tile = (TileEntityFrier)par1TileEntity;
		
		if(tile.hasOil && !tile.hasDirtyOil)
		{
			
			
        int[] displayList = RenderHelper.getFluidDisplayLists(tile.getWorldObj(), ExtendedFarmingBlocks.OilFluid, ExtendedFarmingBlocks.OilLiquid);
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_LIGHTING);
        
        this.bindTexture(TextureMap.locationBlocksTexture);
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glScalef(0.8f, 0.001f, 0.8f);
        GL11.glTranslatef(0.1f, 600f, 0.1f);
        GL11.glCallList(displayList[7]);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
		
		
		
		}
		
		else if(tile.hasOil && tile.hasDirtyOil)
		{
        int[] displayList = RenderHelper.getFluidDisplayLists(tile.getWorldObj(), ExtendedFarmingBlocks.DOilFluid, ExtendedFarmingBlocks.DOilLiquid);
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_LIGHTING);
        
        this.bindTexture(TextureMap.locationBlocksTexture);
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glScalef(0.8f, 0.001f, 0.8f);
        GL11.glTranslatef(0.1f, 600f, 0.1f);
        GL11.glCallList(displayList[7]);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
		}
	}
}
