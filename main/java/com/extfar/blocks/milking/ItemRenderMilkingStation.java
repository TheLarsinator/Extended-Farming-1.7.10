package com.extfar.blocks.milking;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import com.extfar.tractor.entity.EntityMilkingStation;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRenderMilkingStation implements IItemRenderer
{
    protected EntityMilkingStation MilkingStation;
    protected ModelMilkingStation modelMilkingStation;

    protected static RenderItem drawItems = new RenderItem();

    protected ResourceLocation texture;

    public ItemRenderMilkingStation(EntityMilkingStation MilkingStation, ModelMilkingStation model, ResourceLocation texture)
    {
        this.MilkingStation = MilkingStation;
        this.modelMilkingStation = model;
        this.texture = texture;
    }

    protected void renderMilkingStation(ItemRenderType type, RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ)
    {
        GL11.glPushMatrix();
        this.transform(item, type);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.texture);
        this.modelMilkingStation.renderItem(this.MilkingStation, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void transform(ItemStack itemstack, ItemRenderType type)
    {
        final EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        long var10 = this.MilkingStation.getEntityId() * 493286711L;
        var10 = var10 * var10 * 4392167121L + var10 * 98761L;
        final float var12 = (((var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        final float var13 = (((var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        final float var14 = (((var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;

        if (type == ItemRenderType.EQUIPPED)
        {
            GL11.glScalef(2.5F, 2.5F, 2.5F);
            GL11.glTranslatef(0.25F, 0.7F, 0.2F);
            GL11.glRotatef(00, 0F, 0F, 0F);

            if (player != null && player.ridingEntity != null && player.ridingEntity instanceof EntityMilkingStation)
            {
                GL11.glScalef(0.0F, 0.0F, 0.0F);
            }
        }

        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            GL11.glScalef(3.5F, 3.5F, 3.5F);
            GL11.glTranslatef(0.4F, 0.5F, 0.1F);
            GL11.glRotatef(0, 0F, -1F, 0F);

            if (player != null && player.ridingEntity != null && player.ridingEntity instanceof EntityMilkingStation)
            {
                GL11.glScalef(0.0F, 0.0F, 0.0F);
            }
        }

        GL11.glTranslatef(var12, var13 - 0.1F, var14);
        GL11.glScalef(-0.4F, -0.4F, 0.4F);

        if (type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY)
        {
            if (type == ItemRenderType.INVENTORY)
            {
                GL11.glScalef(2.4F, 2.4F, 2.4F);
                GL11.glRotatef(180, 0F, 1.4F, 0F);
                GL11.glTranslatef(0F, -1.1F, 0F);

            }
            else
            {
                GL11.glTranslatef(0F, -4F, 0F);
                GL11.glScalef(3F, 3F, 3F);
                GL11.glRotatef(Sys.getTime() / 90F % 360F, 0F, 1F, 0F);
            }
/*
            GL11.glScalef(1.3F, 1.3F, 1.3F);
            GL11.glTranslatef(0, -1.5F, 0);*/
        }
    }

    /** IItemRenderer implementation **/

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        switch (type)
        {
            case ENTITY:
                return true;

            case EQUIPPED:
                return true;

            case EQUIPPED_FIRST_PERSON:
                return true;

            case INVENTORY:
                return true;

            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch (type)
        {
            case EQUIPPED:
                this.renderMilkingStation(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            case EQUIPPED_FIRST_PERSON:
                this.renderMilkingStation(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            case INVENTORY:
                this.renderMilkingStation(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            case ENTITY:
                this.renderMilkingStation(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            default:
        }
    }
}
