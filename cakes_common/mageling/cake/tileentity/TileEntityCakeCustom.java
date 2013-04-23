package mageling.cake.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCakeCustom extends TileEntity {

    boolean isExploding = false;
    boolean isPotion = false;
    int effectType = 0;
    int effectPower = 0;
    int effectDuration = 0;
    float explosionPower = 0f;

    public void implementEffect(World par1World, EntityPlayer par5EntityPlayer) {
        if (isPotion) {
            par5EntityPlayer.addPotionEffect(new PotionEffect(effectType,
                    effectDuration, effectPower));
        }
        if (isExploding) {
            par1World.createExplosion(par5EntityPlayer, par5EntityPlayer.posX,
                    par5EntityPlayer.posY, par5EntityPlayer.posZ,
                    explosionPower, true);
        }
    }

    public void setEffect(int par1, int par2, int par3) {
        effectType = par1;
        effectDuration = par2;
        effectPower = par3;
        isPotion = true;
    }

    public void setEffect(int par1, int par2) {
        this.setEffect(par1, par2, 0);
    }

    public void setExplosion(float par1) {
        explosionPower = par1;
        isExploding = true;
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        isExploding = par1NBTTagCompound.getBoolean("Exploding");
        isPotion = par1NBTTagCompound.getBoolean("Potion");
        effectType = par1NBTTagCompound.getInteger("PotionType");
        effectPower = par1NBTTagCompound.getInteger("PotionPower");
        effectDuration = par1NBTTagCompound.getInteger("PotionDuration");
        explosionPower = par1NBTTagCompound.getFloat("ExplosionPower");
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Exploding", isExploding);
        par1NBTTagCompound.setBoolean("Potion", isPotion);
        par1NBTTagCompound.setInteger("PotionType", effectType);
        par1NBTTagCompound.setInteger("PotionPower", effectPower);
        par1NBTTagCompound.setInteger("PotionDuration", effectDuration);
        par1NBTTagCompound.setFloat("ExplosionPower", explosionPower);
    }

}
