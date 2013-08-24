package com.kelmai.luma.client;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.CommonProxy;
import com.kelmai.luma.blocks.renderers.ItemTutBoxRenderer;
import com.kelmai.luma.blocks.renderers.TileEntityTutBoxRenderer;
import com.kelmai.luma.blocks.tileEntities.TileEntityTutBox;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
        
    @Override
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTutBox.class, new TileEntityTutBoxRenderer());
        MinecraftForgeClient.registerItemRenderer(BlockManager.TutBox.blockID, new ItemTutBoxRenderer());
    }
        
}