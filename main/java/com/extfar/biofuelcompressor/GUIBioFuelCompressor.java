package com.extfar.biofuelcompressor;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIBioFuelCompressor extends GuiContainer
{

	private TileEntityBioFuelCompressor BFCInventory;
	private static final ResourceLocation texture = new ResourceLocation(
			ExtendedFarming.modid, "textures/gui/BioFuelCompressorGUI.png");

	public GUIBioFuelCompressor(InventoryPlayer inventory, TileEntityBioFuelCompressor tileentity)
	{
		super(new ContainerBioFuelCompressor(inventory, tileentity));
		BFCInventory = tileentity;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everythin in front of the
	 * items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0xffffff);
	}

	/**s
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);

		if (BFCInventory.isBurning())
		{
			int burn = BFCInventory.getBurnTimeRemainingScaled(18);
			drawTexturedModalRect(j + 83, k + 15, 176, 0, 12, burn);
		}

		int update = BFCInventory.getCookProgressScaled(11);
		drawTexturedModalRect(j + 70, k + 34, 176, 19, 38, update);

	}
}