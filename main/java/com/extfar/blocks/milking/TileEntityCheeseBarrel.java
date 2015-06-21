package com.extfar.blocks.milking;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCheeseBarrel extends TileEntity 
{

	public int cheeseAmount;
	public float milkAmount;
	
	
	public boolean canUpdate() 
	{
		 return true;
	}


    
    public void setMilkAmount(float f)
    {
    	((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount = f;
    }

    public void setCheeseAmount(int a)
    {
    	this.cheeseAmount = a;
    }
    Random rand = new Random();	
    public void updateEntity()
    {
	if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount > 0 && this.cheeseAmount == 0 && this.worldObj.isRemote)
	{
    	System.out.println(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount);
		
		if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount > 4 && ((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount <= 5F)
		{ 
	          // ((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(4);
			((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setCheeseAmount(0);         
		}
		else if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount > 3 && ((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount <= 4)
		{
	      // ((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(3);
			((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setCheeseAmount(1); 
		}
		else if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount > 2 && ((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount <= 3)
		{
	      // ((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(2);
			((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setCheeseAmount(2); 
		}
		else if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount > 1 && ((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount <= 2)
		{
	       //((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(1);
			((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setCheeseAmount(3); 
		}
		else if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount < 0)
		{
			((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setMilkAmount(0);
			((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setCheeseAmount(3);
		}   		
	}
    }
    
    
	@Override
    public void writeToNBT(NBTTagCompound nbttag)
    {
		super.writeToNBT(nbttag);  
        nbttag.setInteger("cheeseamount", cheeseAmount);
        nbttag.setFloat("milkamount", milkAmount);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttag)
    {
		super.readFromNBT(nbttag);
        this.cheeseAmount = nbttag.getInteger("cheeseamount");
        this.milkAmount = nbttag.getFloat("milkamount");
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
