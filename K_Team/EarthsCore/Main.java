package K_Team.EarthsCore;

import K_Team.EarthsCore.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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

        int scandiumOreID;
        
        public static Block scandiumOre;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            config.load();
            boolean doesOresGenerate = config.get(Configuration.CATEGORY_GENERAL, "Do Mod-ores Generate?", true).getBoolean(true);
            
            int scandiumOreID = config.getBlock("Scandium Ore", 2620).getInt();

            config.save();
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                scandiumOre = new BlockOres(scandiumOreID).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("scandiumOre").setCreativeTab(CreativeTabs.tabBlock);

        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
        }


        public boolean doesOresGenerate;

}
