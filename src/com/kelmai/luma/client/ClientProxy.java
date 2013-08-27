package com.kelmai.luma.client;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.CommonProxy;
import com.kelmai.luma.blocks.renderers.ItemFixtureRenderer;
import com.kelmai.luma.blocks.renderers.TileEntityFixtureRenderer;
import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
        
    @Override
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFixture.class, new TileEntityFixtureRenderer());
        MinecraftForgeClient.registerItemRenderer(BlockManager.blockFixtureOff.blockID, new ItemFixtureRenderer());
    }
        
}