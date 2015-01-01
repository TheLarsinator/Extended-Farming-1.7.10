package com.extfar.blocks.nether.sprayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;

public class TileEntityRendererNetherSprayer extends TileEntitySpecialRenderer
{
		
		public TileEntityRendererNetherSprayer(){
			model = new ModelSprayer();
			}

			public void renderAModelAt(TileEntityNetherSprayer tile, double d, double d1, double d2, float f) {

			int rotation = 0;
			if(tile.getWorldObj() != null)
			{
			rotation = tile.getBlockMetadata();
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/NetherSprayer.png"));
			GL11.glPushMatrix();
			GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
			GL11.glScalef(1F, -1F, -1F);
			GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);
			model.renderPassive();
			GL11.glPopMatrix(); //end
			}

			private ModelSprayer model;

			public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
			{
			this.renderAModelAt((TileEntityNetherSprayer)par1TileEntity, par2, par4, par6, par8);
			}
}