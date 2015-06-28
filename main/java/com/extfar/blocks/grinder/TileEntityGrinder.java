package com.extfar.blocks.grinder;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGrinder extends TileEntity
{
	public boolean hasWheat;
	public boolean hasSlab;
	public int wheatAmount;
	
    public boolean canUpdate()
    {
    	return true;
    }
	
    public void setWheatAmount(int wheats)
    {
    	this.wheatAmount = wheats;
    }
    public void setWheat(boolean wheat)
    {
    	this.hasWheat = wheat;
    }
    public void setSlab(boolean slab)
    {
    	this.hasSlab = slab;
    }
      
    public void updateEntity()
    {
    	this.setWheat(this.hasWheat);
    	this.setSlab(this.hasSlab);
    	this.setWheatAmount(this.wheatAmount);
    } 
    
	@Override
    public void writeToNBT(NBTTagCompound nbttag)
    {
		super.writeToNBT(nbttag);  
        nbttag.setBoolean("wheat", hasWheat);
        nbttag.setBoolean("slab", hasSlab);
        nbttag.setInteger("wheatamount", wheatAmount);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttag)
    {
		super.readFromNBT(nbttag);
        this.hasWheat = nbttag.getBoolean("wheat");
        this.hasSlab= nbttag.getBoolean("slab");
        this.wheatAmount = nbttag.getInteger("wheatamount");
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
