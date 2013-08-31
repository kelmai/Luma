package com.kelmai.luma.renderers;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.ModelManager;
import com.kelmai.luma.TextureManager;
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
    private static ResourceLocation textureOnBars;
    private static ResourceLocation textureOff;
    private static ResourceLocation textureOffBars;

    private static int onID;
    private static int onBarsID;
    private static int offID;
    private static int offBarsID;

    private static int onInvID;
    private static int onBarsInvID;
    private static int offInvID;
    private static int offBarsInvID;

    public TileEntityFixtureRenderer() {
        model = ModelManager.modelFixture;
        textureOff = TextureManager.textureFixtureOff;
        textureOffBars = TextureManager.textureFixtureOffBars;
        textureOn = TextureManager.textureFixtureOn;
        textureOnBars = TextureManager.textureFixtureOnBars;

        onID = BlockManager.blockFixtureOn.blockID;
        onBarsID = BlockManager.blockFixtureOnBars.blockID;
        offID = BlockManager.blockFixtureOff.blockID;
        offBarsID = BlockManager.blockFixtureOffBars.blockID;

        onInvID = BlockManager.blockFixtureOnInv.blockID;
        onBarsInvID = BlockManager.blockFixtureOnBarsInv.blockID;
        offInvID = BlockManager.blockFixtureOffInv.blockID;
        offBarsInvID = BlockManager.blockFixtureOffBarsInv.blockID;
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

        int curID = tileEntity.getBlockType().blockID;

        if (curID == onID || curID == offInvID) {
            GL11.glDisable(GL11.GL_LIGHTING);
            //GL11.glDisable(GL11.GL_AMBIENT);
            Minecraft.getMinecraft().renderEngine.func_110577_a(textureOn);
        } else if (curID == offID || curID == onInvID) {
            Minecraft.getMinecraft().renderEngine.func_110577_a(textureOff);
        } else if (curID == onBarsID || curID == offBarsInvID) {
            //GL11.glDisable(GL11.GL_);
            GL11.glDisable(GL11.GL_LIGHTING);
            Minecraft.getMinecraft().renderEngine.func_110577_a(textureOnBars);
        } else if (curID == offBarsID || curID == onBarsInvID) {
            Minecraft.getMinecraft().renderEngine.func_110577_a(textureOffBars);
        }

        model.renderAll();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

    }
}