package w1049344862.zjypingzhang;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ZJYPingZhang.MODID, name = ZJYPingZhang.NAME, version = ZJYPingZhang.VERSION, acceptedMinecraftVersions = "1.7.10")
public class ZJYPingZhang {
	public static final String MODID = "zjypingzhang";
	public static final String NAME = "ZJYPingZhang";
	public static final String VERSION = "1.1";
	public static final String Arthor = "Arthor:" + (5246700 * 100 + 2431) * 2;

	@Instance(ZJYPingZhang.MODID)
	public static ZJYPingZhang instance;

	@SidedProxy(clientSide = "w1049344862.zjypingzhang.ClientProxy", serverSide = "w1049344862.zjypingzhang.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}