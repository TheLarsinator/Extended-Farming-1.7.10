package com.extfar.core.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.extfar.blocks.biofuel.biofuelcompressor.ContainerBioFuelCompressor;
import com.extfar.blocks.biofuel.biofuelcompressor.GUIBioFuelCompressor;
import com.extfar.blocks.biofuel.biofuelcompressor.TileEntityBioFuelCompressor;
import com.extfar.blocks.biofuel.biofuelfiltrator.ContainerBioFuelFiltrator;
import com.extfar.blocks.biofuel.biofuelfiltrator.GUIBioFuelFiltrator;
import com.extfar.blocks.biofuel.biofuelfiltrator.TileEntityBioFuelFiltrator;
import com.extfar.blocks.biofuel.oilextractor.ContainerOilExtractor;
import com.extfar.blocks.biofuel.oilextractor.GUIOilExtractor;
import com.extfar.blocks.biofuel.oilextractor.TileEntityOilExtractor;

import cpw.mods.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		switch(id) {
		case 1:
			if (tileEntity != null && tileEntity instanceof TileEntityBioFuelCompressor) {
				return new ContainerBioFuelCompressor(player.inventory, (TileEntityBioFuelCompressor) tileEntity);
			}
			break;
		case 2:
			if (tileEntity != null && tileEntity instanceof TileEntityOilExtractor) {
				return new ContainerOilExtractor(player.inventory, (TileEntityOilExtractor) tileEntity);
			}
			break;
		case 3:
			if (tileEntity != null && tileEntity instanceof TileEntityBioFuelFiltrator) {
				return new ContainerBioFuelFiltrator(player.inventory, (TileEntityBioFuelFiltrator) tileEntity);
			}
			break;
		}
		return null;
	}

	public Object getClientGuiElement(int id, EntityPlayer player, World world,int x, int y, int z) {		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		switch(id) {
		case 1:
			if (tileEntity != null && tileEntity instanceof TileEntity) {

				return new GUIBioFuelCompressor(player.inventory, (TileEntityBioFuelCompressor) tileEntity);
			}
			break;
		case 2:
			if (tileEntity != null && tileEntity instanceof TileEntity) {

				return new GUIOilExtractor(player.inventory, (TileEntityOilExtractor) tileEntity);
			}
			break;
		case 3:
			if (tileEntity != null && tileEntity instanceof TileEntity) {

				return new GUIBioFuelFiltrator(player.inventory, (TileEntityBioFuelFiltrator) tileEntity);
			}
			break;
		}

		return null;

	}
}