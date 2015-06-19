package com.extfar.core.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.EnumMap;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.extfar.blocks.milking.TileEntityCheeseBarrel;
import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public enum PacketHandler 
{
	INSTANCE;
	
	private EnumMap<Side, FMLEmbeddedChannel> channels;
	
	private PacketHandler()
	{
		this.channels = NetworkRegistry.INSTANCE.newChannel("ExtendedFarming",  new TEExtendedFarmingCodec());
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            addClientHandler();
        }
        if(FMLCommonHandler.instance().getSide() == Side.SERVER)
        {
        	System.out.println("Server sided~");
        }
	}
	
	@SideOnly(Side.CLIENT)
    private void addClientHandler()
    {
        FMLEmbeddedChannel clientChannel = this.channels.get(Side.CLIENT);

        String tileLomCodec = clientChannel.findChannelHandlerNameForType(TEExtendedFarmingCodec.class);
        clientChannel.pipeline().addAfter(tileLomCodec, "TileEntityCheeseBarrelHandler", new TileEntityCheeseBarrelMessageHandler());
    }

    
    private static class TileEntityCheeseBarrelMessageHandler extends SimpleChannelInboundHandler<TileEntityCheeseBarrelMessage>
    {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, TileEntityCheeseBarrelMessage msg) throws Exception
        {
            World world = ExtendedFarming.proxy.getClientWorld();
            TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
            
            if (te instanceof TileEntityCheeseBarrel)
            {
            	TileEntityCheeseBarrel cheesebarrel = (TileEntityCheeseBarrel) te;

            	cheesebarrel.handlePacketData(msg.cheeseAmountt, msg.milkAmountt, msg.hasCheeset, msg.hasMilkt);
                
                //System.out.println("Getting Called!");
            }
        }
    }

    public static class BMMessage
    {
        int index;
    }

    public static class TileEntityCheeseBarrelMessage extends BMMessage
    {
        int x;
        int y;
        int z;
        
    	boolean hasCheeset;
    	boolean hasMilkt;
    	int cheeseAmountt;
    	float milkAmountt;
    }

    
    private class ClientToServerCodec extends FMLIndexedMessageToMessageCodec<BMMessage>
    {
    	public ClientToServerCodec()
    	{
    	}
    	
		@Override
		public void encodeInto(ChannelHandlerContext ctx, BMMessage msg, ByteBuf target) throws Exception 
		{
			target.writeInt(msg.index);
			
			
			switch(msg.index)
			{
			
			}
		}

		@Override
		public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, BMMessage msg) 
		{
			int index = source.readInt();
			
			System.out.println("Packet is recieved and being decoded");
			
			switch(index)
			{
			
			}
		}
    }
    
    private class TEExtendedFarmingCodec extends FMLIndexedMessageToMessageCodec<BMMessage>
    {
        public TEExtendedFarmingCodec()
        {
            addDiscriminator(0, TileEntityCheeseBarrelMessage.class);
        /*  addDiscriminator(1, TEOrientableMessage.class);
            addDiscriminator(2, TEPedestalMessage.class);
            addDiscriminator(3, TEPlinthMessage.class);
            addDiscriminator(4, TESocketMessage.class);
            addDiscriminator(5, TETeleposerMessage.class);
            addDiscriminator(6, TEWritingTableMessage.class);
            addDiscriminator(7, ParticleMessage.class);
            addDiscriminator(8, VelocityMessage.class);
            addDiscriminator(9, TEMasterStoneMessage.class);
            addDiscriminator(10, TEReagentConduitMessage.class);
            addDiscriminator(11, CurrentLPMessage.class);
            addDiscriminator(12, CurrentReagentBarMessage.class);
            addDiscriminator(13, CurrentAddedHPMessage.class);
            addDiscriminator(14, KeyboardMessage.class);*/
        }

        @Override
        public void encodeInto(ChannelHandlerContext ctx, BMMessage msg, ByteBuf target) throws Exception
        {
            target.writeInt(msg.index);

            switch (msg.index)
            {
                case 0:
                    target.writeInt(((TileEntityCheeseBarrelMessage) msg).x);
                    target.writeInt(((TileEntityCheeseBarrelMessage) msg).y);
                    target.writeInt(((TileEntityCheeseBarrelMessage) msg).z);
                   // System.out.println("Am I getting called?");
                    target.writeBoolean(((TileEntityCheeseBarrelMessage) msg).hasCheeset);
                    target.writeBoolean(((TileEntityCheeseBarrelMessage) msg).hasMilkt);
                    target.writeFloat(((TileEntityCheeseBarrelMessage) msg).milkAmountt);
                    target.writeInt(((TileEntityCheeseBarrelMessage) msg).cheeseAmountt);
                    break;
            }
        }


        @Override
        public void decodeInto(ChannelHandlerContext ctx, ByteBuf dat, BMMessage msg)
        {
            int index = dat.readInt();

            switch (index)
            {
                case 0:
                    ((TileEntityCheeseBarrelMessage) msg).x = dat.readInt();
                    ((TileEntityCheeseBarrelMessage) msg).y = dat.readInt();
                    ((TileEntityCheeseBarrelMessage) msg).z = dat.readInt();
                    
                    ((TileEntityCheeseBarrelMessage) msg).hasCheeset = dat.readBoolean();
                    ((TileEntityCheeseBarrelMessage) msg).hasMilkt = dat.readBoolean();
                    ((TileEntityCheeseBarrelMessage) msg).milkAmountt = dat.readFloat();
                    ((TileEntityCheeseBarrelMessage) msg).cheeseAmountt = dat.readInt();
                    break;
            }
        }
    }

    //Packets to be obtained
    public static Packet getPacket(TileEntityCheeseBarrel tileLom)
    {
        TileEntityCheeseBarrelMessage msg = new TileEntityCheeseBarrelMessage();
        msg.index = 0;
        msg.x = tileLom.xCoord;
        msg.y = tileLom.yCoord;
        msg.z = tileLom.zCoord;
        msg.cheeseAmountt = tileLom.cheeseAmount;
        msg.milkAmountt = tileLom.milkAmount;
        msg.hasCheeset = tileLom.hasCheese;
        msg.hasMilkt = tileLom.hasMilk;
        
        //System.out.println("Im getting the packet!");

        return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg);
    }
    
    public void sendTo(Packet message, EntityPlayerMP player)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }

    public void sendToAll(Packet message)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }

    public void sendToAllAround(Packet message, NetworkRegistry.TargetPoint point)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }
    
    public void sendToServer(Packet message)
    {
        this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        this.channels.get(Side.CLIENT).writeAndFlush(message).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
    }
}