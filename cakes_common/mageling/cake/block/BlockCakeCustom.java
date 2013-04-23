package mageling.cake.block;

import mageling.cake.tileentity.TileEntityCakeCustom;
import net.minecraft.block.BlockCake;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCakeCustom extends BlockCake {

    public BlockCakeCustom(int par1) {
        super(par1);
        // TODO Auto-generated constructor stub
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3,
            int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
            float par8, float par9) {
        this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4,
            EntityPlayer par5EntityPlayer) {
        this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
    }

    private void eatCakeSlice(World par1World, int par2, int par3, int par4,
            EntityPlayer par5EntityPlayer) {

        par5EntityPlayer.getFoodStats().addStats(2, 0.1F);
        this.getEffect(par1World, par2, par3, par4, par5EntityPlayer);
        int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

        if (l >= 6) {
            par1World.setBlockToAir(par2, par3, par4);
        } else {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
        }

    }

    public void getEffect(World par1World, int par2, int par3, int par4,
            EntityPlayer par5EntityPlayer) {
        TileEntityCakeCustom te = (TileEntityCakeCustom) par1World
                .getBlockTileEntity(par2, par3, par4);
        te.implementEffect(par1World, par5EntityPlayer);
    }

    public TileEntity createNewTileEntity(World par1World) {
        return new TileEntityCakeCustom();
    }
}
