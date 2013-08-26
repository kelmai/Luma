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




    public ItemFixtureRenderer() {

    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
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
                renderTutBox(0f, 0f, 0f, 1f);
                return;
            }

            case INVENTORY:{
                renderTutBox(0f, 0f, 0f, 1f);
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

        // Disable Lighting Calculations
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);



        //FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/OBJTutorial/textures/models/TutBox.png");
        Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureFixture);
        ModelManager.modelFixture.renderAll();

        // Re-enable Lighting Calculations
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
