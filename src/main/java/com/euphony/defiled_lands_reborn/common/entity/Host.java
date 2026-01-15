package com.euphony.defiled_lands_reborn.common.entity;

import com.euphony.defiled_lands_reborn.common.init.DLEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class Host extends Zombie {
    
    public Host(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }
    
    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.27F)
                .add(Attributes.ATTACK_DAMAGE, 5.0F)
                .add(Attributes.ARMOR, 2.0F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
    
    @Override
    public boolean isUnderWaterConverting() {
        return false;
    }
    
    @Override
    protected boolean isSunSensitive() {
        return false;
    }
    
    @Override
    protected void actuallyHurt(DamageSource damageSource, float amount) {
        if (this.isInvulnerableTo(damageSource)) {
            return;
        }
        
        float damageAfterArmor = this.getDamageAfterArmorAbsorb(damageSource, amount);
        float damageAfterMagic = this.getDamageAfterMagicAbsorb(damageSource, damageAfterArmor);
        
        float absorbed = amount - damageAfterMagic;
        
        if (absorbed > 0.0F && absorbed < Float.MAX_VALUE) {
            Entity attacker = damageSource.getEntity();
            if (attacker instanceof ServerPlayer player) {
                player.awardStat(Stats.DAMAGE_DEALT_ABSORBED, Math.round(absorbed * 10.0F));
            }
        }
        
        if (damageAfterMagic != 0.0F) {
            this.getCombatTracker().recordDamage(damageSource, damageAfterMagic);
            this.setHealth(this.getHealth() - damageAfterMagic);
            this.gameEvent(GameEvent.ENTITY_DAMAGE);
            
            spawnSlimes((int) damageAfterMagic);
        }
    }
    
    protected void spawnSlimes(int num) {
        Level level = level();
        if (level.isClientSide) return;
        
        int health = (int) getMaxHealth();
        int slimeNum = Math.min(num, health);
        
        while (slimeNum >= 2) {
            int size = (num > 8) ? 2 : 1;
            
            int k = slimeNum / 2;
            float dx = ((float) (k % 2) - 0.5F) * 0.5F;
            float dz = ((float) (k / 2) - 0.5F) * 0.5F;
            
            DefiledSlime slime = new DefiledSlime(DLEntities.DEFILED_SLIME.get(), level);
            slime.setSize(size, true);
            
            BlockPos pos = getOnPos();
            slime.setPos(pos.getX() + dx, pos.getY() + 1f, pos.getZ() + dz);
            slime.setYRot(random.nextFloat() * 360.0F);
            
            level.addFreshEntity(slime);
            
            slimeNum -= (size == 1) ? 2 : size * 4;
        }
    }
}
