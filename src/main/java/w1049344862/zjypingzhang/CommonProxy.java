package w1049344862.zjypingzhang;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class CommonProxy {
		public static Block pingZhang = new BlockPingZhang();
//		public static Block zjy = new BlockZjy();
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(pingZhang, ItemPingZhang.class, "ping_zhang");
		//GameRegistry.registerBlock(zjy, "zjy_block");
	}

	public void init(FMLInitializationEvent event) {
       // MinecraftForge.EVENT_BUS.register(this);
	}

	public void postInit(FMLPostInitializationEvent event) {

	}/*
    @SubscribeEvent
	public void onBreakGuangGao(BreakEvent evt){
		if(evt.block==pingZhang){
		evt.getPlayer().inventory.addItemStackToInventory(new ItemStack(this.zjy));
		ItemStack i = new ItemStack(Items.diamond);
		int r = evt.world.rand.nextInt(5);
		i.setStackDisplayName(r==0?"Hello ZJY!":r==1?"You Are Guy!":r==2?"Look At Barrier!":r==3?"You May Need Huaji":"Made By 1049344862");
		evt.getPlayer().inventory.addItemStackToInventory(i);
		}
	}
    
    public static class BlockZjy extends Block{
		public BlockZjy() {
			super(Material.ground);
			this.setBlockTextureName("zjypingzhang:zjy");
			this.setBlockName("ZjyBlock");
		}
    }*/
}