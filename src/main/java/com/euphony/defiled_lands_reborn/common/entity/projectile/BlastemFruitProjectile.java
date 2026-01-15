package com.euphony.defiled_lands_reborn.common.entity.projectile;

import com.euphony.defiled_lands_reborn.common.init.DLEntities;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class BlastemFruitProjectile extends ThrowableItemProjectile implements ItemSupplier {
    
    protected boolean destructive;
    protected float damage, explosion;
    
    public BlastemFruitProjectile(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
        damage = 7.0F;
        explosion = 1.0F;
        destructive = true;
    }
    
    public BlastemFruitProjectile(Level level, LivingEntity thrower) {
        super(DLEntities.BLASTEM_FRUIT_PROJECTILE.get(), thrower, level);
        this.setItem(new ItemStack(DLItems.BLASTEM_FRUIT.get()));
        damage = 7.0F;
        explosion = 1.0F;
        destructive = true;
    }
    
    public BlastemFruitProjectile(EntityType<? extends BlastemFruitProjectile> type, Level level, LivingEntity thrower) {
        super(type, thrower, level);
        this.setItem(new ItemStack(DLItems.BLASTEM_FRUIT.get()));
        damage = 7.0F;
        explosion = 1.0F;
        destructive = true;
    }
    
    @Override
    protected Item getDefaultItem() {
        return DLItems.BLASTEM_FRUIT.get();
    }
    
    @Override
    public ItemStack getItem() {
        return new ItemStack(DLItems.BLASTEM_FRUIT.get());
    }
    
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }
    
    @Override
    protected void onHitEntity(EntityHitResult result) {
        result.getEntity().hurt(damageSources().thrown(this, this.getOwner()), damage);
    }
    
    @Override
    protected void onHitBlock(BlockHitResult result) {
        level().explode(this, getX(), getY(), getZ(), explosion, false,
                this.destructive ? Level.ExplosionInteraction.BLOCK : Level.ExplosionInteraction.NONE);
    }
    
    public float getDamage() {
        return damage;
    }
    
    public void setDamage(float damage) {
        this.damage = damage;
    }
    
    public void setDestructive(boolean destructive) {
        this.destructive = destructive;
    }
    
    public float getExplosion() {
        return explosion;
    }
    
    public void setExplosion(float explosion) {
        this.explosion = explosion;
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("Damage", damage);
        tag.putFloat("Explosion", explosion);
        tag.putBoolean("Destructive", destructive);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.damage = tag.getFloat("Damage");
        this.explosion = tag.getFloat("Explosion");
        this.destructive = tag.getBoolean("Destructive");
    }
}
