package com.extfar.core.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.extfar.biofuelcompressor.ContainerBioFuelCompressor;
import com.extfar.biofuelcompressor.GUIBioFuelCompressor;
import com.extfar.biofuelcompressor.TileEntityBioFuelCompressor;

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
		}

		return null;

	}
}