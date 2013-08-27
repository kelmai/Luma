package com.kelmai.luma;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

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
