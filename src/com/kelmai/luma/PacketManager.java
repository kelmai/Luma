package com.kelmai.luma;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 01.09.13
 * Time: 22:23
 */
public class PacketManager implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

    }
}
