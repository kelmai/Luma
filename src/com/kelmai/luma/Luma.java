package com.kelmai.luma;

import com.kelmai.luma.blocks.BlockTutBox;
import com.kelmai.luma.blocks.tileEntities.TileEntityTutBox;
import com.kelmai.luma.client.ClientProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

/**
 * Created with IntelliJ IDEA. Tube Edition
 * User: KelMai
 * Date: 08.08.13
 * Time: 20:54
 */

// TODO Liquid Luma
// TODO WorldGen Luma lakes (?)
// TODO Slab Lamps (custom model?)
// TODO (Add Holiday Lights)
// TODO Add Lit Fences (Luma Fence or expand Wooden Fence? or both?)
// TODO Add Luma Stairs
// TODO Implement Texture Glow
// TODO (Implement outer Glow, like Redpower)


// General Mod Setup
@Mod(	        modid               = Luma.modID,
                name                = "Luma",
                version             = "0.1.1")

@NetworkMod (   clientSideRequired  = true,
                serverSideRequired  = false)

public class Luma {
    public static final String modID = "luma";

    @SidedProxy(clientSide="com.kelmai.luma.client.ClientProxy",
                serverSide="com.kelmai.luma.CommonProxy")

    public static CommonProxy proxy;

    public final static Block TutBox = new BlockTutBox(2020);

    @EventHandler
    public void load(FMLInitializationEvent event) {

        ConfigManager.initConfiguration(event);

        ItemManager.makeItems();
        BlockManager.makeBlocks();


        RecipeManager.makeRecipes();

        GameRegistry.registerBlock(TutBox, "blockTutBox");
        GameRegistry.registerTileEntity(TileEntityTutBox.class, "tileEntityTutBox");

        LanguageRegistry.addName(TutBox, "Tutorial Box");

        proxy.registerRenderers();
    }

    public static void log(String str) {
        System.out.println("Luma: " + str);
    }
}
