package com.extfar.blocks.milking;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMilkingStation extends TileEntity 
{
	public boolean hasMilk;
	public int milkAmount;
	
	public boolean canUpdate() 
	{
		 return true;
	}

	@Override
    public void writeToNBT(NBTTagCompound nbttag)
    {
		super.writeToNBT(nbttag);
        nbttag.setBoolean("milk", hasMilk);    
        nbttag.setInteger("amount", milkAmount);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttag)
    {
		super.readFromNBT(nbttag);
        this.hasMilk = nbttag.getBoolean("milk"); 
        this.milkAmount = nbttag.getInteger("amount");
    }

    
    public void setHasMilk(boolean hasMilk)
    {
    	this.hasMilk = hasMilk;
    }
    
    public void setMilkAmount(int milkamount)
    {
    	this.milkAmount = milkamount;
    }
    
    public void updateEntity()
    {
    	this.setMilkAmount(this.milkAmount);
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
	public void onDataPacket(NetworkManager arg0, S35PacketUpdateTileEntity arg1) 
	{
	  readFromNBT(arg1.func_148857_g());
	}
	 
}
