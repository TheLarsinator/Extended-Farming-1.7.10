package com.extfar.tractor.entity;

import com.extfar.core.ExtendedFarming;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHarvester extends Entity{

	public ResourceLocation HarvesterTexture = new ResourceLocation(ExtendedFarming.modid + ":textures/items/Tractor.png");

	public EntityHarvester(World p_i1582_1_) {
		super(p_i1582_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		
	}

}
