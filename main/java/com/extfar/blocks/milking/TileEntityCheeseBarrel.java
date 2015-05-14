package com.extfar.blocks.milking;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCheeseBarrel extends TileEntity 
{
	public boolean hasCheese;
	public boolean hasMilk;
	public int cheeseAmount;
	public float milkAmount;
	
	
	public boolean canUpdate() 
	{
		 return true;
	}

	@Override
    public void writeToNBT(NBTTagCompound nbttag)
    {
		super.writeToNBT(nbttag);
        nbttag.setBoolean("cheese", hasCheese);    
        nbttag.setBoolean("milk", hasMilk);    
        nbttag.setInteger("cheeseamount", cheeseAmount);
        nbttag.setFloat("milkamount", milkAmount);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttag)
    {
		super.readFromNBT(nbttag);
        this.hasCheese = nbttag.getBoolean("cheese"); 
        this.milkAmount = nbttag.getFloat("milkamount");
        this.hasMilk = nbttag.getBoolean("milk"); 
        this.cheeseAmount = nbttag.getInteger("cheeseamount");
    }

    
    public void setHasMilk(boolean w)
    {
    	this.hasMilk = w;
    }
    
    public void setMilkAmount(float f)
    {
    	this.milkAmount = f;
    }
    
    public void setHasCheese(boolean b)
    {
    	this.hasCheese = b;
    }
    
    public void setCheeseAmount(int a)
    {
    	this.cheeseAmount = a;
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
