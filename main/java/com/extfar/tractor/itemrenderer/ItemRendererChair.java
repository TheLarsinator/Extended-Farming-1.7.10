package com.extfar.tractor.itemrenderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import com.extfar.tractor.entity.EntityChair;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererChair implements IItemRenderer
{
    protected EntityChair Chair;
    protected ModelBase modelChair;

    protected static RenderItem drawItems = new RenderItem();

    protected ResourceLocation texture;

    public ItemRendererChair(EntityChair Chair, ModelBase model, ResourceLocation texture)
    {
        this.Chair = Chair;
        this.modelChair = model;
        this.texture = texture;
    }

    protected void renderChair(ItemRenderType type, RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ)
    {
        GL11.glPushMatrix();
        this.transform(item, type);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.texture);
        this.modelChair.render(this.Chair, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void transform(ItemStack itemstack, ItemRenderType type)
    {
        final EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        long var10 = this.Chair.getEntityId() * 493286711L;
        var10 = var10 * var10 * 4392167121L + var10 * 98761L;
        final float var12 = (((var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        final float var13 = (((var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        final float var14 = (((var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;

        if (type == ItemRenderType.EQUIPPED)
        {
            GL11.glScalef(3.2F, 3.2F, 3.2F);
            GL11.glTranslatef(0.2F, 0.7F, 0.1F);
            GL11.glRotatef(70, 0F, 1F, 0F);

            if (player != null && player.ridingEntity != null && player.ridingEntity instanceof EntityChair)
            {
                GL11.glScalef(0.0F, 0.0F, 0.0F);
            }
        }

        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            GL11.glScalef(5.2F, 5.2F, 5.2F);
            GL11.glTranslatef(0.4F, 0.6F, 0.2F);
            GL11.glRotatef(50, 0F, -1F, 0F);

            if (player != null && player.ridingEntity != null && player.ridingEntity instanceof EntityChair)
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
                GL11.glScalef(2.2F, 2.2F, 2.2F);
                GL11.glRotatef(180, 0F, 1.4F, 0F);
                GL11.glTranslatef(0F, -1.2F, 0F);

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
                this.renderChair(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            case EQUIPPED_FIRST_PERSON:
                this.renderChair(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            case INVENTORY:
                this.renderChair(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            case ENTITY:
                this.renderChair(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
                break;

            default:
        }
    }
}
