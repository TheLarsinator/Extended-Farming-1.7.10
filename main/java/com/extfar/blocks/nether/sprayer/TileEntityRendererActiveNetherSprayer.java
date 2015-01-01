package com.extfar.blocks.nether.sprayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;

public class TileEntityRendererActiveNetherSprayer extends TileEntitySpecialRenderer
{
		
		public TileEntityRendererActiveNetherSprayer(){
			model = new ModelSprayer();
			}

			public void renderAModelAt(TileEntityActiveNetherSprayer par1TileEntity, double d, double d1, double d2, float f) {

			int rotation = 0;
			if(par1TileEntity.getWorldObj() != null)
			{
			rotation = par1TileEntity.getBlockMetadata();
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/ActiveNetherSprayer.png"));
			GL11.glPushMatrix();
			GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
			GL11.glScalef(1F, -1F, -1F);
			GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);
			model.renderActive();
			GL11.glPopMatrix(); //end
			}

			private ModelSprayer model;

			public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
			{
			this.renderAModelAt((TileEntityActiveNetherSprayer)par1TileEntity, par2, par4, par6, par8);
			}
}