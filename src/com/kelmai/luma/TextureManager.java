package com.kelmai.luma;

import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 24.08.13
 * Time: 22:44
 */
public class TextureManager {
    public static ResourceLocation textureFixture;

    public static void makeTextures() {
        textureFixture = new ResourceLocation("luma:textures/models/tex_fixture.png");
    }
}
