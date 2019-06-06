package w1049344862.zjypingzhang;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import w1049344862.zjypingzhang.ClientProxy.DisplayBlockUpdate;

public class BlockPingZhang extends Block {
	private boolean isVisible;
	//private IIcon Pt=null/*透明材质*/;
	//private IIcon Pb=null/*玻璃材质*/;
	public BlockPingZhang() {
		super(Material.rock);
		this.setBlockName("pingZhang");
		this.setStepSound(soundTypeGlass);
		this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockUnbreakable();
        this.setResistance(6000001.0F);
        this.disableStats();
        this.setBlockTextureName("zjypingzhang:ping_zhang");
	}
	public boolean isVisible()
	{
		return isVisible;
	}
	@Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return -1;
    }
	@Override
    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return "zjypingzhang:ping_zhang";
    }
	@Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z,
			EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
		w.setBlockMetadataWithNotify(x, y, z, 0, 3);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube()
    {
        return false;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public float getAmbientOcclusionLightValue()
    {
        return 1.0F;
    }

    @Override
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
    }
 /*   @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister r)
    {
        Pt = r.registerIcon("zjypingzhang:ping_zhang1");
        Pb = r.registerIcon("zjypingzhang:ping_zhang2");
    }*/
/*	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return meta == 0 ? Pt : Pb;
	}*/
	
	@Override
	public void updateTick(World w, int x, int y, int z, Random random)
	{
		isVisible = false;
		i(w, x, y, z);
	}
	@Override
	public void randomDisplayTick(World w, int x, int y, int z, Random random)
	{
		i(w, x, y, z);

	}
	
    public void i(World w,int x,int y,int z){
		if (w.isRemote)
		{
			ItemStack i = FMLClientHandler.instance().getClient().thePlayer.getCurrentEquippedItem();
			isVisible = false;
			if (i != null)
			{
				Item it = i.getItem();
				if ((it instanceof ItemBlock) && Block.getBlockFromItem(it) == this)
					isVisible = true;
			}
			if (isVisible)
			{
				w.setBlock(x, y, z, this, 1, 3);
			} else
			{
				w.setBlock(x, y, z, this, 0, 3);
			}
	        ClientProxy.DisplayBlockUpdate evt =  new DisplayBlockUpdate(x, y, z,w);
	        ClientProxy.EVENT_BUS.post(evt);
		}	
    }
    @Override
    @SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World w, int x, int y, int z)
	{
		return w.getBlockMetadata(x, y, z) == 0 ? AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0) : super.getSelectedBoundingBoxFromPool(w, x, y, z);
	}
}
