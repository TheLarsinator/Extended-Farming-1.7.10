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
    	this.milkAmount = f;
    }

    public void setCheeseAmount(int a)
    {
    	this.cheeseAmount = a;
    }
    Random rand = new Random();	
    public void updateEntity()
    {
	if(this.milkAmount > 0 && this.cheeseAmount == 0 && this.worldObj.isRemote)
	{
    	System.out.println(this.milkAmount);
		((TileEntityCheeseBarrel) this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setMilkAmount(this.milkAmount - rand.nextFloat()/1);  		
		
		if(this.milkAmount > 4 && this.milkAmount <= 5F)
		{ 
	          // ((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(4);
           this.setCheeseAmount(0);         
		}
		else if(this.milkAmount > 3 && this.milkAmount <= 4)
		{
	      // ((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(3);
	       this.setCheeseAmount(1); 
		}
		else if(this.milkAmount > 2 && this.milkAmount <= 3)
		{
	      // ((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(2);
	       this.setCheeseAmount(2); 
		}
		else if(this.milkAmount > 1 && this.milkAmount <= 2)
		{
	       //((TileEntityCheeseBarrel)this.worldobj.getTileEntity(x, y, z)).setMilkAmount(1);
	       this.setCheeseAmount(3); 
		}
		else if(this.milkAmount < 0)
		{
	       this.setMilkAmount(0);
	       this.setCheeseAmount(3);
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
