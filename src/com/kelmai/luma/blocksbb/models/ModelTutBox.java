package com.kelmai.luma.blocksbb.models;

import com.kelmai.luma.TextureManager;
import com.kelmai.luma.blocksbb.tileEntities.TileEntityTutBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 21.08.13
 * Time: 17:06
 */


public class ModelTutBox extends ModelBase {
    private IModelCustom modelTutBox;

    public ModelTutBox() {
        modelTutBox = AdvancedModelLoader.loadModel("/assets/luma/models/TutBox.obj");
    }

    public void render() {
        modelTutBox.renderAll();
    }

    public void render(TileEntityTutBox box, double x, double y, double z) {
        // Push a blank matrix onto the stack
        GL11.glPushMatrix();

        // Move the object into the correct position on the block (because the OBJ's origin is the center of the object)
        GL11.glTranslatef((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);

        // Scale our object to about half-size in all directions (the OBJ file is a little large)
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        GL11.glRotatef(90f, 90f, 1f, 0f);

        //FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/OBJTutorial/textures/models/TutBox.png");
        Minecraft.getMinecraft().renderEngine.func_110577_a(TextureManager.textureTutBlock);

        // Render the object, using modelTutBox.renderAll();
        this.render();

        // Pop this matrix from the stack.
        GL11.glPopMatrix();
    }
}
