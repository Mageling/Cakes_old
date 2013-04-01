package com.mageling.cake;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;

import com.mageling.cake.lib.Reference;




@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
//@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Cakes {
    
    @Instance(Reference.MOD_ID)
    public static Cakes instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    /**@ServerStarting
    public void serverStarting(FMLServerStartingEvent event) {

        // Initialize the custom commands
        CommandHandler.initCommands(event);
    }*/
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

        // Initialize the log helper
        LogHelper.init();

        // Load the localization files into the LanguageRegistry
        LocalizationHandler.loadLanguages();

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + "\\ee3\\" + Reference.MOD_ID + ".cfg"));

        // Conduct the version check and log the result
        VersionHelper.execute();

        // Initialize the Version Check Tick Handler (Client only)
        TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);

        // Initialize the Render Tick Handler (Client only)
        proxy.registerRenderTickHandler();

        // Register the KeyBinding Handler (Client only)
        proxy.registerKeyBindingHandler();

        // Register the Sound Handler (Client only)
        proxy.registerSoundHandler();

        // Initialize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }
    
    @SuppressWarnings("unchecked")
    @Init
    public void load(FMLInitializationEvent event) {
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {

        // Initialize the Addon Handler
        AddonHandler.init();
}