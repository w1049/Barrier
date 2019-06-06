package w1049344862.zjypingzhang;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

public class ClientProxy extends CommonProxy {
    public static final EventBus EVENT_BUS = new EventBus();
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
        this.EVENT_BUS.register(this);
		//Minecraft.getMinecraft().effectRenderer.addEffect(null);
        
	}
	 @SubscribeEvent
	    public void onUpdate(DisplayBlockUpdate evt){
		 if(evt.world.isRemote){
		 if(evt.block==CommonProxy.pingZhang&&evt.blockMetadata==1){
			 EntityFX e;
			 e=new PBarrier(evt.world, evt.x+0.5, evt.y+0.5, evt.z+0.5);
			 Minecraft.getMinecraft().effectRenderer.addEffect(e);
		 }
		 }
	 }
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
    public static class DisplayBlockUpdate extends BlockEvent
    {
        public final int x;
        public final int y;
        public final int z;
        public final World world;

        public DisplayBlockUpdate(int x, int y, int z, World world)
        {
            super(x, y, z, world, world.getBlock(x, y, z), world.getBlockMetadata(x, y, z));
            this.x = x;
            this.y = y;
            this.z = z;
            this.world = world;
        }
    }
}