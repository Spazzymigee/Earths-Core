package K_Team.EarthsCore;

import K_Team.EarthsCore.proxy.CommonProxy;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Configuration;

@Mod(modid="EarthsCore", name="Earths Core", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public class Main {

        @Instance(value = "EarthsCore")
        public static Main instance;
        
        
        @SidedProxy(clientSide="K_Team.EarthsCore.proxy.ClientProxy", serverSide="K_Team.EarthsCore.proxy.CommonProxy")
        public static CommonProxy proxy;

        
        //this
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            config.load();
            boolean doesOresGenerate = config.get(Configuration.CATEGORY_GENERAL, "Do Mod-ores Generate?", true).getBoolean(true);

            config.save();
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();

        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
        }


        public boolean doesOresGenerate;
}
