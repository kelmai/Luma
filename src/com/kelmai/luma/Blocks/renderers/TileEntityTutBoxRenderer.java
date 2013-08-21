package com.kelmai.luma.blocks.renderers;

import com.kelmai.luma.blocks.models.ModelTutBox;
import com.kelmai.luma.blocks.tileEntities.TileEntityTutBox;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 21.08.13
 * Time: 21:06
 */
public class TileEntityTutBoxRenderer extends TileEntitySpecialRenderer
{
    private ModelTutBox modelTutBox = new ModelTutBox();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        modelTutBox.render((TileEntityTutBox)tileEntity, x, y, z);
    }
}