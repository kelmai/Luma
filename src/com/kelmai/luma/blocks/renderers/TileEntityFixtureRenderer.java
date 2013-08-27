package com.kelmai.luma.blocks.renderers;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.Luma;
import com.kelmai.luma.ModelManager;
import com.kelmai.luma.TextureManager;
import com.kelmai.luma.blocks.BlockFixture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 21.08.13
 * Time: 21:06
 */
public class TileEntityFixtureRenderer extends TileEntitySpecialRenderer {

    private static IModelCustom model;
    private static ResourceLocation textureOn;
    private static ResourceLocation textureOff;

    public TileEntityFixtureRenderer() {
        model = ModelManager.modelFixture;
        textureOff = TextureManager.textureFixtureOff;
        textureOn = TextureManager.textureFixtureOn;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        //ModelManager.render(ModelManager.modelFixture, x, y, z, true);

        GL11.glPushMatrix();
        //Luma.log("test "+tileEntity.blockMetadata);
        switch (tileEntity.getBlockMetadata()) {
            case 0:
                GL11.glTranslatef((float)x, (float)y + 1f, (float)z + 1f);
                GL11.glRotatef(180f, 1f, 0f, 0f);
                break;
            case 1:
                GL11.glTranslatef((float)x, (float)y + 1f, (float)z);
                GL11.glRotatef(-90f, 0f, 0f, 1f);
                break;
            case 2:
                GL11.glTranslatef((float)x + 1f, (float)y, (float)z);
                GL11.glRotatef(90f, 0f, 0f, 1f);
                break;
            case 3:
                GL11.glTranslatef((float)x, (float)y + 1f, (float)z);
                GL11.glRotatef(90f, 1f, 0f, 0f);
                break;
            case 4:
                GL11.glTranslatef((float)x, (float)y, (float)z + 1f);
                GL11.glRotatef(-90f, 1f, 0f, 0f);
                break;
            default:
                GL11.glTranslatef((float)x, (float)y, (float)z);
                break;

        }
        if (tileEntity.getBlockType().blockID == BlockManager.blockFixtureOff.blockID) {
            Minecraft.getMinecraft().renderEngine.func_110577_a(textureOff);
        } else {
            Minecraft.getMinecraft().renderEngine.func_110577_a(textureOn);
        }

        model.renderAll();
        GL11.glPopMatrix();

    }
}