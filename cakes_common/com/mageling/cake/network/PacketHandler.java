package com.mageling.cake.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;


public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        
        PacketCake packetCake = PacketTypeHandler.buildPacket(packet.data);
        
        packetCake.execute(manager, player)

    }

}
