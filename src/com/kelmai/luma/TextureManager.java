package com.kelmai.luma;

import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 24.08.13
 * Time: 22:44
 */
public class TextureManager {
    public static ResourceLocation textureTutBlock;
    public static ResourceLocation textureTutBlock2;

    public static void makeTextures() {
        textureTutBlock = new ResourceLocation("luma:textures/models/TutBox.png");
        textureTutBlock2 = new ResourceLocation("luma:textures/models/TutBox.png");
    }
}
