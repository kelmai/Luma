package com.kelmai.luma.client;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.CommonProxy;
import com.kelmai.luma.ConfigManager;
import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import com.kelmai.luma.renderers.BlockLampRenderer;
import com.kelmai.luma.renderers.BlockTubeRenderer;
import com.kelmai.luma.renderers.ItemFixtureRenderer;
import com.kelmai.luma.renderers.TileEntityFixtureRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    public static int lampRenderType;
    public static int tubeRenderType;


    @Override
    public void registerRenderers() {
        lampRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockLampRenderer());

        tubeRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockTubeRenderer());




        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFixture.class, new TileEntityFixtureRenderer());


        MinecraftForgeClient.registerItemRenderer(BlockManager.blockFixtureOff.blockID, new ItemFixtureRenderer(false, false));
        MinecraftForgeClient.registerItemRenderer(BlockManager.blockFixtureOffInv.blockID, new ItemFixtureRenderer(false, true));
        MinecraftForgeClient.registerItemRenderer(BlockManager.blockFixtureOffBars.blockID, new ItemFixtureRenderer(true, false));
        MinecraftForgeClient.registerItemRenderer(BlockManager.blockFixtureOffBarsInv.blockID, new ItemFixtureRenderer(true, true));

    }
        
}