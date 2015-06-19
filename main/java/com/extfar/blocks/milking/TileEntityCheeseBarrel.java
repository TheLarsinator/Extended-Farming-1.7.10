package com.extfar.blocks.milking;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
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
        this.hasMilk = nbttag.getBoolean("milk"); 
        this.cheeseAmount = nbttag.getInteger("cheeseamount");
        this.milkAmount = nbttag.getFloat("milkamount");
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
    Random rand = new Random();	
    public void updateEntity()
    {
	if(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).hasMilk && !((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).hasCheese && this.worldObj.isRemote)
	{
    	System.out.println(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount);
		((TileEntityCheeseBarrel) this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setMilkAmount(((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).milkAmount - rand.nextFloat()/1);  		
		
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
	       ((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setHasMilk(false);
	       ((TileEntityCheeseBarrel)this.worldObj.getTileEntity(xCoord, yCoord, zCoord)).setHasCheese(true);
		}   		
	}
    }
	
	/*@Override
	public Packet getDescriptionPacket() 
	{
	  NBTTagCompound nbt = new NBTTagCompound();
	  writeToNBT(nbt);
	  S35PacketUpdateTileEntity packet = new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, nbt);
	  return packet;
	 }*/
	
	/*public void sendChangeToServer(){
	    ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
	    DataOutputStream outputStream = new DataOutputStream(bos);
	    try {
	        outputStream.writeInt(xCoord);
	        outputStream.writeInt(yCoord);
	        outputStream.writeInt(zCoord);
	        //write the relevant information here... exemple:
	        outputStream.writeInt(cheeseAmount);
	        outputStream.writeFloat(milkAmount);
	        outputStream.writeBoolean(hasCheese);
	        outputStream.writeBoolean(hasMilk);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	               
	    Packet250CustomPayload packet = new Packet250CustomPayload();
	    packet.channel = "GenericRandom";
	    packet.data = bos.toByteArray();
	    packet.length = bos.size();

	    PacketDispatcher.sendPacketToServer(packet);
	}
	*/
	/*@Override
	public void onDataPacket(NetworkManager networkmngr, S35PacketUpdateTileEntity packetupdate) 
	{
	  readFromNBT(packetupdate.func_148857_g());
	}
	*/
	@Override
	public Packet getDescriptionPacket() 
	{
	  NBTTagCompound nbt = new NBTTagCompound();
	  writeToNBT(nbt);
	  S35PacketUpdateTileEntity packet = new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, nbt);
	  return packet;
	 }
	
/*	@Override
	public void onDataPacket(NetworkManager networkmngr, S35PacketUpdateTileEntity packetupdate) 
	{
	  readFromNBT(packetupdate.func_148857_g());
	}
    
    public void handlePacketData(int cheesecontent, float milkcontent, boolean cheese, boolean milk)
    {
    	this.cheeseAmount = cheesecontent;
    	this.milkAmount = milkcontent;
    	this.hasCheese = cheese;
    	this.hasMilk = milk;
    }*/
}
