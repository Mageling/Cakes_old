package mageling.cake.block;

import net.minecraft.block.BlockCake;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockCakeTnt extends BlockCake {

    public BlockCakeTnt(int par1) {
        super(par1);
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3,
            int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
            float par8, float par9) {
        this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }

    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4,
            EntityPlayer par5EntityPlayer) {
        this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
    }

    protected void eatCakeSlice(World par1World, int par2, int par3, int par4,
            EntityPlayer par5EntityPlayer) {
        if (par5EntityPlayer.canEat(false)) {
            par5EntityPlayer.getFoodStats().addStats(2, 0.1F);
            int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

            if (l >= 6) {
                par1World.setBlockToAir(par2, par3, par4);
            } else {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
            }
        }
        par1World.createExplosion(par5EntityPlayer, par5EntityPlayer.posX,
                par5EntityPlayer.posY, par5EntityPlayer.posZ, 2.5F, true);
    }

}
