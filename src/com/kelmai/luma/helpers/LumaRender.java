package com.kelmai.luma.helpers;

import net.minecraft.client.renderer.Tessellator;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 30.08.13
 * Time: 20:23
 */
public class LumaRender {
    public static Tessellator t = Tessellator.instance;

    public void drawSide(int side, double posX, double posY, double posZ, double width, double height, double uvStartX, double uvStartY, double uvEndX, double uvEndY) {
        switch (side) {
            case 0: // Bottom
//                t.addVertexWithUV(0, 0, 0, uvStartX, v); //tl
//                t.addVertexWithUV(1, 0, 0, uvEndX, V); //bl
//                t.addVertexWithUV(1, 0, 1, U, V); //br
//                t.addVertexWithUV(0, 0, 1, U, v); //
                break;
            case 1: // Top
//    tess.addVertexWithUV(0, 1, 0, u, v);
//    tess.addVertexWithUV(0, 1, 1, u, V);
//    tess.addVertexWithUV(1, 1, 1, U, V);
//    tess.addVertexWithUV(1, 1, 0, U, v);
                break;
            case 2: // North
//    tess.addVertexWithUV(1, 1, 0, u, v);
//    tess.addVertexWithUV(1, 0, 0, u, V);
//    tess.addVertexWithUV(0, 0, 0, U, V);
//    tess.addVertexWithUV(0, 1, 0, U, v);
                break;
            case 3: // South
//    tess.addVertexWithUV(0, 1, 1, u, v);
//    tess.addVertexWithUV(0, 0, 1, u, V);
//    tess.addVertexWithUV(1, 0, 1, U, V);
//    tess.addVertexWithUV(1, 1, 1, U, v);
                break;
            case 4: // West
//    tess.addVertexWithUV(0, 1, 0, u, v);
//    tess.addVertexWithUV(0, 0, 0, u, V);
//    tess.addVertexWithUV(0, 0, 1, U, V);
//    tess.addVertexWithUV(0, 1, 1, U, v);
                break;
            case 5: // East
//    tess.addVertexWithUV(1, 1, 1, u, v);
//    tess.addVertexWithUV(1, 0, 1, u, V);
//    tess.addVertexWithUV(1, 0, 0, U, V);
//    tess.addVertexWithUV(1, 1, 0, U, v);
                break;
        }

    }

//    //Base
//    tess.addVertexWithUV(0, 0, 0, u, v);
//    tess.addVertexWithUV(1, 0, 0, u, V);
//    tess.addVertexWithUV(1, 0, 1, U, V);
//    tess.addVertexWithUV(0, 0, 1, U, v);
//    //Top
//    tess.addVertexWithUV(0, 1, 0, u, v);
//    tess.addVertexWithUV(0, 1, 1, u, V);
//    tess.addVertexWithUV(1, 1, 1, U, V);
//    tess.addVertexWithUV(1, 1, 0, U, v);
//    //East
//    tess.addVertexWithUV(1, 1, 1, u, v);
//    tess.addVertexWithUV(1, 0, 1, u, V);
//    tess.addVertexWithUV(1, 0, 0, U, V);
//    tess.addVertexWithUV(1, 1, 0, U, v);
//    //West
//    tess.addVertexWithUV(0, 1, 0, u, v);
//    tess.addVertexWithUV(0, 0, 0, u, V);
//    tess.addVertexWithUV(0, 0, 1, U, V);
//    tess.addVertexWithUV(0, 1, 1, U, v);
//    //North
//    tess.addVertexWithUV(1, 1, 0, u, v);
//    tess.addVertexWithUV(1, 0, 0, u, V);
//    tess.addVertexWithUV(0, 0, 0, U, V);
//    tess.addVertexWithUV(0, 1, 0, U, v);
//    //South
//    tess.addVertexWithUV(0, 1, 1, u, v);
//    tess.addVertexWithUV(0, 0, 1, u, V);
//    tess.addVertexWithUV(1, 0, 1, U, V);
//    tess.addVertexWithUV(1, 1, 1, U, v);

}
