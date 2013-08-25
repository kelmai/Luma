package com.kelmai.luma.blocks.renderers;

import com.kelmai.luma.ModelManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 21.08.13
 * Time: 21:06
 */
public class TileEntityFixtureRenderer extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        ModelManager.render(ModelManager.modelFixture, x, y, z);
    }
}