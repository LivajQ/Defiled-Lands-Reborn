package com.euphony.defiled_lands_reborn.common.entity;

import com.euphony.defiled_lands_reborn.config.CommonConfig;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

public class TwistedShambler extends Shambler {
    
    public TwistedShambler(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.setMaxUpStep(1.0F);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }
    
    @Override
    protected @NotNull SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource damageSource) {
        return SoundEvents.BLAZE_HURT;
    }
    
    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE, 22.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0D)
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 64.0D);
    }
    
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData spawnData, CompoundTag dataTag) {
        SpawnGroupData data = super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
        
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(ConfigHolder.common.twistedShamblerAttackDamage);
        this.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(ConfigHolder.common.twistedShamblerAttackSpeed);
        this.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(ConfigHolder.common.twistedShamblerAttackKnockback);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(ConfigHolder.common.twistedShamblerHealth);
        this.getAttribute(Attributes.ARMOR).setBaseValue(ConfigHolder.common.twistedShamblerArmor);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(ConfigHolder.common.twistedShamblerMovementSpeed);
        this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(ConfigHolder.common.twistedShamblerKnockbackResistance);
        this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(ConfigHolder.common.twistedShamblerFollowRange);
        
        this.setHealth(this.getMaxHealth());
        
        return data;
    }
    
    
    public static boolean checkTwistedShamblerSpawnRules(EntityType<? extends Monster> type, ServerLevelAccessor level, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        return pos.getY() <= 50
                && level.getDifficulty() != Difficulty.PEACEFUL
                && (spawnReason == MobSpawnType.SPAWNER || isDarkEnoughToSpawn(level, pos, random))
                && checkMobSpawnRules(type, level, spawnReason, pos, random);
    }
}
