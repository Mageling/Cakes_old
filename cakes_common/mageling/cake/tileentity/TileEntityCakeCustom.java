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
    

    public TileEntityCakeCustom() {
        // TODO Auto-generated constructor stub
    }

    public void implementEffect(World par1World, EntityPlayer par5EntityPlayer) {
        if(this.isPotion) {
            par5EntityPlayer.addPotionEffect(new PotionEffect(this.effectType, this.effectDuration, this.effectPower));
        }
        if(this.isExploding) {
            par1World.createExplosion(par5EntityPlayer, par5EntityPlayer.posX, par5EntityPlayer.posY, par5EntityPlayer.posZ, this.explosionPower, true);
        }
    }
    
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.isExploding = par1NBTTagCompound.getBoolean("Exploding");
        this.isPotion = par1NBTTagCompound.getBoolean("Potion");
        this.effectType = par1NBTTagCompound.getInteger("PotionType");
        this.effectPower = par1NBTTagCompound.getInteger("PotionPower");
        this.effectDuration = par1NBTTagCompound.getInteger("PotionDuration");
        this.explosionPower = par1NBTTagCompound.getFloat("ExplosionPower");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Exploding", this.isExploding);
        par1NBTTagCompound.setBoolean("Potion", this.isPotion);
        par1NBTTagCompound.setInteger("PotionType", this.effectType);
        par1NBTTagCompound.setInteger("PotionPower", this.effectPower);
        par1NBTTagCompound.setInteger("PotionDuration", this.effectDuration);
        par1NBTTagCompound.setFloat("ExplosionPower", this.explosionPower);
    }

}
