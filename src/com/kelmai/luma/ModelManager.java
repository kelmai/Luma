package com.kelmai.luma;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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



}
