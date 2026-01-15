package com.euphony.defiled_lands_reborn.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class Scuttler extends Spider {
    
    public Scuttler(EntityType<? extends Spider> entityType, Level level) {
        super(entityType, level);
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 16.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.34F);
    }
    
    public static boolean isDarkEnoughToSpawn(ServerLevelAccessor level, BlockPos pos, RandomSource random) {
        int brightness = level.getLevel().isThundering()
                ? level.getMaxLocalRawBrightness(pos, 10)
                : level.getMaxLocalRawBrightness(pos);
        
        if (brightness >= 8) {
            return random.nextInt(16) == 0;
        }
        
        return brightness <= random.nextInt(8);
    }
    
    public static boolean checkScuttlerSpawnRules(
            EntityType<? extends Monster> type,
            ServerLevelAccessor level,
            MobSpawnType spawnReason,
            BlockPos pos,
            RandomSource random
    ) {
        return level.getDifficulty() != Difficulty.PEACEFUL
                && (spawnReason == MobSpawnType.SPAWNER || isDarkEnoughToSpawn(level, pos, random))
                && checkMobSpawnRules(type, level, spawnReason, pos, random);
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new ScuttlerAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new ScuttlerTargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new ScuttlerTargetGoal<>(this, IronGolem.class));
    }
    
    static class ScuttlerAttackGoal extends MeleeAttackGoal {
        public ScuttlerAttackGoal(Scuttler scuttler) {
            super(scuttler, 1.0F, true);
        }
        
        @Override
        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }
        
        @Override
        public boolean canContinueToUse() {
            if (this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget(null);
                return false;
            }
            return super.canContinueToUse();
        }
    }
    
    static class ScuttlerTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public ScuttlerTargetGoal(Scuttler scuttler, Class<T> entityTypeToTarget) {
            super(scuttler, entityTypeToTarget, true);
        }
        
        @Override
        public boolean canUse() {
            return super.canUse();
        }
    }
}
