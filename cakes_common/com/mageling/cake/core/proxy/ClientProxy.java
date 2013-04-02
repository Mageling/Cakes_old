package com.mageling.cake.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    
    @Override
    public void registerRenderers() {
        MinecraftForgeClient.preloadTexture(ITEMS_PNG);
        MinecraftForgeClient.preloadTexture(BLOCKS_PNG);
    }

}
