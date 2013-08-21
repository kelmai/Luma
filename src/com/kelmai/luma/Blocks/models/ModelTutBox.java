package com.kelmai.luma.blocks.models;

import com.kelmai.luma.Luma;
import com.kelmai.luma.blocks.tileEntities.TileEntityTutBox;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import sun.java2d.pipe.RenderingEngine;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 21.08.13
 * Time: 17:06
 */


public class ModelTutBox extends ModelBase {
    private IModelCustom modelTutBox;
    private ResourceLocation theTexture;

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

        theTexture = new ResourceLocation(Luma.modID, "/assets/luma/textures/models/TutBox.png");

        //FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/OBJTutorial/textures/models/TutBox.png");
        Minecraft.getMinecraft().renderEngine.func_110577_a(theTexture);

        // Render the object, using modelTutBox.renderAll();
        this.render();

        // Pop this matrix from the stack.
        GL11.glPopMatrix();
    }
}
