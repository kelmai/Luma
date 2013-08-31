package com.kelmai.luma.renderers;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.client.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 28.08.13
 * Time: 21:12
 */
public class BlockLampRenderer implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int meta = world.getBlockMetadata(x, y, z);
        Icon c = block.getIcon(1, meta);
        Icon b = block.getIcon(1, meta);

        int brightness = BlockManager.blockLumaLampOn.getMixedBrightnessForBlock(world, x, y, z);

        float u = c.getMinU();
        float v = c.getMinV();
        float U = c.getMaxU();
        float V = c.getMaxV();

        float u1 = b.getMinU();
        float v1 = b.getMinV();
        float U1 = b.getMaxU();
        float V1 = b.getMaxV();

        Tessellator tess = Tessellator.instance;
        tess.addTranslation(x, y, z);
        tess.setBrightness(brightness);
        tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        //Base
        tess.addVertexWithUV(0, 0, 0, u, v);
        tess.addVertexWithUV(1, 0, 0, u, V);
        tess.addVertexWithUV(1, 0, 1, U, V);
        tess.addVertexWithUV(0, 0, 1, U, v);
        //Top
        tess.addVertexWithUV(0, 1, 0, u, v);
        tess.addVertexWithUV(0, 1, 1, u, V);
        tess.addVertexWithUV(1, 1, 1, U, V);
        tess.addVertexWithUV(1, 1, 0, U, v);
        //East
        tess.addVertexWithUV(1, 1, 1, u, v);
        tess.addVertexWithUV(1, 0, 1, u, V);
        tess.addVertexWithUV(1, 0, 0, U, V);
        tess.addVertexWithUV(1, 1, 0, U, v);
        //West
        tess.addVertexWithUV(0, 1, 0, u, v);
        tess.addVertexWithUV(0, 0, 0, u, V);
        tess.addVertexWithUV(0, 0, 1, U, V);
        tess.addVertexWithUV(0, 1, 1, U, v);
        //North
        tess.addVertexWithUV(1, 1, 0, u, v);
        tess.addVertexWithUV(1, 0, 0, u, V);
        tess.addVertexWithUV(0, 0, 0, U, V);
        tess.addVertexWithUV(0, 1, 0, U, v);
        //South
        tess.addVertexWithUV(0, 1, 1, u, v);
        tess.addVertexWithUV(0, 0, 1, u, V);
        tess.addVertexWithUV(1, 0, 1, U, V);
        tess.addVertexWithUV(1, 1, 1, U, v);

        tess.addTranslation(-x, -y, -z);

        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return ClientProxy.lampRenderType;
    }
}
