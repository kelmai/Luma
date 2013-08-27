package com.kelmai.luma.blocks.renderers;

import com.kelmai.luma.ModelManager;
import com.kelmai.luma.TextureManager;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 21.08.13
 * Time: 21:12
 */
public class ItemFixtureRenderer implements IItemRenderer {

    private boolean bars;
    private boolean inverted;

    public ItemFixtureRenderer(boolean bars, boolean inverted) {
        this.inverted = inverted;
        this.bars = bars;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type) {
            case ENTITY:{
                renderTutBox(0f, 0f, 0f, 1f);
                return;
            }

            case EQUIPPED:{
                renderTutBox(0f, 0f, 1.5f, 1.2f);
                return;
            }

            case INVENTORY:{
                renderTutBox(0f, -.5f, 0f, 1.2f);
                return;
            }

            case EQUIPPED_FIRST_PERSON:{
                renderTutBox(0f, 1f, 1f, 1f);
                return;
            }

            default:return;
        }
    }

    private void renderTutBox(float x, float y, float z, float scale) {
        GL11.glPushMatrix();

        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);

        if (this.bars) {
            if (this.inverted) {
                Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureFixtureOnBars);
            } else {
                Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureFixtureOffBars);
            }
        } else {
            if (this.inverted) {
                Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureFixtureOn);
            } else {
                Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureFixtureOff);
            }
        }
        ModelManager.modelFixture.renderAll();

        GL11.glPopMatrix();
    }
}
