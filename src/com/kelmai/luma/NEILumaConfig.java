package com.kelmai.luma;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 31.08.13
 * Time: 00:35
 */
public class NEILumaConfig implements IConfigureNEI {
    public void loadConfig() {
        API.hideItems(BlockManager.NEIHiddenBlocks);
    }

    public String getName() {
        return Luma.modName;
    }
    public String getVersion() {
        return Luma.modVersion;
    }

}
