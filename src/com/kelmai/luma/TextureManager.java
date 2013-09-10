package com.kelmai.luma;

import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 24.08.13
 * Time: 22:44
 */
public class TextureManager {
    public static ResourceLocation[] textureFixtureOn = new ResourceLocation[16];
    public static ResourceLocation[] textureFixtureOff = new ResourceLocation[16];
    public static ResourceLocation[] textureFixtureOnBars = new ResourceLocation[16];
    public static ResourceLocation[] textureFixtureOffBars = new ResourceLocation[16];

    public static void makeTextures() {
        for (int i = 0; i < 16; i++) {

            textureFixtureOff[i] = new ResourceLocation("luma:textures/models/tex_fixture_off_" + i + ".png");
            textureFixtureOn[i] = new ResourceLocation("luma:textures/models/tex_fixture_on_" + i + ".png");
            textureFixtureOffBars[i] = new ResourceLocation("luma:textures/models/tex_fixture_off_bars_" + i + ".png");
            textureFixtureOnBars[i] = new ResourceLocation("luma:textures/models/tex_fixture_on_bars_" + i + ".png");

        }
    }
}
