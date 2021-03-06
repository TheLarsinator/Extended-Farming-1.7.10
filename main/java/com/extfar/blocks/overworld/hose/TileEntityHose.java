package com.extfar.blocks.overworld.hose;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHose extends TileEntity
{
	public static int renderID;
	public static boolean hasWater;
	
	@Override
    public void writeToNBT(NBTTagCompound nbttag)
    {
		super.writeToNBT(nbttag);  
        nbttag.setBoolean("hasWater", hasWater);
        nbttag.setInteger("renderID", renderID);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttag)
    {
		super.readFromNBT(nbttag);
        this.hasWater = nbttag.getBoolean("hasWater");
        this.renderID = nbttag.getInteger("renderID");
    }
	
	public void setRenderID(int ID)
	{
		this.renderID = ID;
	}
	
	public void setHasWater(boolean water)
	{
		this.hasWater = water;
	}
	
	@Override
	public Packet getDescriptionPacket() 
	{
	  NBTTagCompound nbt = new NBTTagCompound();
	  writeToNBT(nbt);
	  S35PacketUpdateTileEntity packet = new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, nbt);
	  return packet;
	 }
	
	@Override
	public void onDataPacket(NetworkManager networkmngr, S35PacketUpdateTileEntity packetupdate) 
	{
	  readFromNBT(packetupdate.func_148857_g());
	}
}
