package com.extfar.blocks.nether.hose;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.blocks.overworld.hose.ModelHose;
import com.extfar.core.ExtendedFarming;

public class TileEntityRendererNetherHose extends TileEntitySpecialRenderer
{
	
	public TileEntityRendererNetherHose(){
		
		model = new ModelHose();
		}

		public void renderAModelAt(TileEntityNetherHose tile, double d, double d1, double d2, float f) {

		int rotation = 0;
		int metadata = tile.getBlockMetadata();
		if(tile.getWorldObj() != null)
		{
		rotation = tile.getBlockMetadata();
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/NetherHose.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
		switch(metadata)
		{
		case 0:
			model.renderCenter();
			break;
		case 1:
			model.renderSide2();
			break;
		case 2:
			model.renderSide3();
			break;
		case 3:
			model.renderSide4();
			break;
		case 4:
			model.renderSide1();
			break;
		case 5:
			model.renderCorner2();
			break;
		case 6:
			model.renderTCross2();
			break;
		case 7:
			model.renderCross();
			break;
		case 8:
			model.renderCorner3();
			break;
		case 9:
			model.renderTCross3();
			break;
		case 10:
			model.renderLine2();
			break;
		case 11:
			model.renderCorner4();
			break;
		case 12:
			model.renderCorner1();
			break;
		case 13:
			model.renderLine1();
			break;
		case 14:
			model.renderTCross4();
			break;
		case 15:
			model.renderTCross1();
			break;
			
		case 16:
			model.renderCenterT();
			break;
		case 17:
			model.renderSide2T();
			break;
		case 18:
			model.renderSide3T();
			break;
		case 19:
			model.renderSide4T();
			break;
		case 20:
			model.renderSide1T();
			break;
		case 21:
			model.renderCorner2T();
			break;
		case 22:
			model.renderTCross2T();
			break;
		case 23:
			model.renderCrossT();
			break;
		case 24:
			model.renderCorner3T();
			break;
		case 25:
			model.renderTCross3T();
			break;
		case 26:
			model.renderLine2T();
			break;
		case 27:
			model.renderCorner4T();
			break;
		case 28:
			model.renderCorner1T();
			break;
		case 29:
			model.renderLine1T();
			break;
		case 30:
			model.renderTCross4T();
			break;
		case 31:
			model.renderTCross1T();
			break;
		}
		GL11.glPopMatrix(); //end
		}

		private ModelHose model;

		public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
		{
		this.renderAModelAt((TileEntityNetherHose)par1TileEntity, par2, par4, par6, par8);
		}
}