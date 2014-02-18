package K_Team.EarthCore;

import K_Team.EarthCore.proxy.CommonProxy;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="MOD", name="Mod", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public class Main {


        @Instance(value = "DynamicID")
        public static Main instance;
        
        
        @SidedProxy(clientSide="net.K_Team.mod.proxy.ClientProxy", serverSide="net.K_Team.mod.proxy.CommonProxy")
        public static CommonProxy proxy;
        
        
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
        }
}