package com.extfar.blocks.deepfrier.frier;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFrier extends TileEntity
{
	public boolean hasOil;
	public boolean hasDirtyOil;
	public boolean hasPotato;
	public int oilUsage = 0;
	public boolean isDone;
	public float progress;
	public int foodType;
	
    public boolean canUpdate()
    {
    	return true;
    }
	
    public void setPotato(boolean potato)
    {
    	this.hasPotato = potato;
    }
    public void setOil(boolean oil)
    {
    	this.hasOil = oil;
    }
    public void setDirtyOil(boolean oil)
    {
    	this.hasDirtyOil = oil;
    }
    public void setDone(boolean done)
    {
    	this.isDone = done;
    }
    public void setProgress(float work)
    {
    	this.progress = work;
    }
    public void setOilUsage(int oil)
    {
    	this.oilUsage = oil;
    }
    public void setFoodType(int item)
    {
    	this.foodType = item;
    }
    
    public void updateEntity()
    {
    	//System.out.println(this.progress);
    /*	System.out.print("Dirty Oil: ");
    	System.out.println(this.hasDirtyOil);

    	System.out.print("Oil Usage: ");
    	System.out.println(this.oilUsage);
    	
    	System.out.print("Has Oil: ");
    	System.out.println(this.hasOil);*/
    	if(this.hasOil && this.hasPotato && !this.isDone && !this.hasDirtyOil)
    	{
    		this.setProgress(this.progress + 0.01F);
    		
    		if(this.progress > 10)
    		{
    			this.isDone = true;
    			this.setProgress(0);
    			//this.setOilUsage(oilUsage + 1);
    		}
    	}
    } 
    
    
    
	@Override
    public void writeToNBT(NBTTagCompound nbttag)
    {
		super.writeToNBT(nbttag);  
        nbttag.setBoolean("potato", hasPotato);
        nbttag.setBoolean("oil", hasOil);
        nbttag.setBoolean("Doil", hasDirtyOil);
        nbttag.setInteger("oilusage", oilUsage);
        nbttag.setBoolean("done", isDone);
        nbttag.setFloat("work", progress);
        nbttag.setInteger("food", foodType);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttag)
    {
		super.readFromNBT(nbttag);
        this.hasPotato = nbttag.getBoolean("potato");
        this.hasOil= nbttag.getBoolean("oil");
        this.hasDirtyOil= nbttag.getBoolean("Doil");
        this.oilUsage = nbttag.getInteger("oilusage");
        this.isDone = nbttag.getBoolean("done");
        this.progress = nbttag.getFloat("work");
        this.foodType = nbttag.getInteger("food");
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
