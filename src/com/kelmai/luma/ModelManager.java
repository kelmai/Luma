package com.kelmai.luma;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 25.08.13
 * Time: 01:44
 */
public class ModelManager {
    public static IModelCustom modelFixture;

    public static void makeModels() {
        modelFixture = AdvancedModelLoader.loadModel("/assets/luma/models/fixture.obj");
    }


    public static void render(IModelCustom model, double x, double y, double z) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0f, (float) y + 0f, (float) z + 0f);
        GL11.glScalef(1f, 1f, 1f);
        // angle, x, y, z
        //GL11.glRotatef(90f, 1f, 0f, 0f);
        Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureTutBlock);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
