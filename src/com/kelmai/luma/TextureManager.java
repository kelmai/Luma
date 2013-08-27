package com.kelmai.luma;

import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 24.08.13
 * Time: 22:44
 */
public class TextureManager {
    public static ResourceLocation textureFixtureOff;
    public static ResourceLocation textureFixtureOn;

    public static void makeTextures() {
        textureFixtureOff = new ResourceLocation("luma:textures/models/tex_fixture_off.png");
        textureFixtureOn = new ResourceLocation("luma:textures/models/tex_fixture_on.png");
    }
}
