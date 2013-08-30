package com.kelmai.luma;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
                version             = "0.2.0")

@NetworkMod (   clientSideRequired  = true,
                serverSideRequired  = false)

public class Luma {
    public static final String modID = "luma";
    public static Side side;
    public static CreativeTabs tab;

    @SidedProxy(clientSide="com.kelmai.luma.client.ClientProxy",
                serverSide="com.kelmai.luma.CommonProxy")

    public static CommonProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigManager.initConfiguration(event);
        tab = new CreativeTabs("tabLuma") {
            public ItemStack getIconItemStack() {
                return new ItemStack(ItemManager.itemChromaStone, 1, 0);
            }
        };
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabLuma", "en_US", "Luma");
    }
    @EventHandler
    public void load(FMLInitializationEvent event) {
        side = FMLCommonHandler.instance().getEffectiveSide();
        if (side == Side.CLIENT) {
            TextureManager.makeTextures();
            ModelManager.makeModels();
        }
        ItemManager.makeItems();
        BlockManager.makeBlocks();
        RecipeManager.makeRecipes();
        proxy.registerRenderers();
    }

    public static void log(String str) {
        System.out.println("Luma: " + str);
    }
}
