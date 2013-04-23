package mageling.cake;

import mageling.cake.block.BlockCakeRegen;
import mageling.cake.block.BlockCakeTnt;
import mageling.cake.item.ItemCakeRegen;
import mageling.cake.item.ItemCakeTnt;
import mageling.cake.lib.Reference;
import mageling.cake.network.PacketHandler;
import mageling.cake.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Cakes {

    public static Block blockCakeTnt = new BlockCakeTnt(3333);
    public static Block blockCakeRegen = new BlockCakeRegen(3334);
    public static Item itemCakeTnt = new ItemCakeTnt(3331, blockCakeTnt)
            .setCreativeTab(CreativeTabs.tabFood);
    public static Item itemCakeRegen = new ItemCakeRegen(3332, blockCakeRegen)
            .setCreativeTab(CreativeTabs.tabFood);

    @Instance(Reference.MOD_ID)
    public static Cakes instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @ServerStarting
    public void serverStarting(FMLServerStartingEvent event) {

    }

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerBlock(blockCakeTnt, "cakeTnt");
        LanguageRegistry.addName(blockCakeTnt, "TNT Cake");

        GameRegistry.registerBlock(blockCakeRegen, "cakeRegen");
        LanguageRegistry.addName(blockCakeRegen, "Regeneration Cake");

        GameRegistry.registerItem(itemCakeTnt, "itemCakeTnt");
        LanguageRegistry.addName(itemCakeTnt, "TNT Cake");

        GameRegistry.registerItem(itemCakeRegen, "itemCakeRegen");
        LanguageRegistry.addName(itemCakeRegen, "Regeneration Cake");
    }

    // @SuppressWarnings("unchecked")
    @Init
    public void load(FMLInitializationEvent event) {

        GameRegistry.addRecipe(new ItemStack(itemCakeTnt, 1), new Object[] {
                "AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar,
                'C', Item.wheat, 'E', Block.tnt });

        GameRegistry.addRecipe(new ItemStack(itemCakeRegen, 1), new Object[] {
                "ABA", "BEB", "CBC", 'A', Item.bucketMilk, 'B', Item.ghastTear,
                'C', Item.wheat, 'E', Item.egg });

    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {

    }

}