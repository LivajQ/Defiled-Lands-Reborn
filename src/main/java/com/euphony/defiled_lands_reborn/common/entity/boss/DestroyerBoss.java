package com.euphony.defiled_lands_reborn.common.entity.boss;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.UUID;

public class DestroyerBoss extends Monster {
    
    private final ServerBossEvent bossEvent;
    
    public boolean isLeaping;
    public boolean isShaking;
    public float deathTime;
    public float invulnerableTicks;
    
    private @Nullable UUID unlimitedLastHurtByPlayer;
    
    private static final EntityDataAccessor<Integer> DATA_ID_INV =
            SynchedEntityData.defineId(DestroyerBoss.class, EntityDataSerializers.INT);
    
    private static final EntityDataAccessor<Boolean> LEAPING =
            SynchedEntityData.defineId(DestroyerBoss.class, EntityDataSerializers.BOOLEAN);
    
    private static final int INVULNERABILITY_TIME = 200;
    
    public DestroyerBoss(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setMaxUpStep(1.0F);
        
        this.bossEvent = new ServerBossEvent(
                this.getDisplayName(),
                BossEvent.BossBarColor.PURPLE,
                BossEvent.BossBarOverlay.PROGRESS
        );
        this.bossEvent.setDarkenScreen(true);
    }
    
    
    @Override
    protected boolean shouldDropLoot() {
        return false;
    }
    
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_INV, 0);
        this.entityData.define(LEAPING, false);
    }
    
    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }
    
    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Invul", this.getInvulTime());
        tag.putBoolean("Leaping", this.isLeaping());
        if (unlimitedLastHurtByPlayer != null)
            tag.putUUID("LastHurtBy", unlimitedLastHurtByPlayer);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setInvulTime(tag.getInt("Invul"));
        this.setLeaping(tag.getBoolean("Leaping"));
        if (tag.hasUUID("LastHurtBy"))
            unlimitedLastHurtByPlayer = tag.getUUID("LastHurtBy");
        
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }
    
    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new DestroyerDoNothingGoal());
        this.goalSelector.addGoal(2, new DestroyerBigLeapGoal(this, 1.2f));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.FOLLOW_RANGE, 128)
                .add(Attributes.MOVEMENT_SPEED, 0.32D)
                .add(Attributes.ATTACK_DAMAGE, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }
    
    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        return false;
    }
    
    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
        if (!level().isClientSide && this.isLeaping() && onGround) {
            level().explode(this, getX(), getY(), getZ(), 3.0F, Level.ExplosionInteraction.MOB);
            setLeaping(false);
            Vec3 movement = this.getDeltaMovement();
            this.setDeltaMovement(new Vec3(movement.x, 0, movement.z));
            this.yya = 0;
        }
    }
    
    @Override
    public void aiStep() {
        super.aiStep();
        
        if (this.lastHurtByPlayer != null) {
            this.unlimitedLastHurtByPlayer = this.lastHurtByPlayer.getUUID();
        }
        
        if (this.unlimitedLastHurtByPlayer != null) {
            Player p = level().getPlayerByUUID(unlimitedLastHurtByPlayer);
            if (p == null || p.isRemoved()) {
                this.unlimitedLastHurtByPlayer = null;
            }
        }
        
        if (getInvulTime() > 0) {
            this.setDeltaMovement(0, 0.01f, 0);
            
            if (level().isClientSide) {
                for (int i = 0; i < 3; ++i) {
                    level().addParticle(
                            ParticleTypes.ENTITY_EFFECT,
                            getX() + random.nextGaussian(),
                            getY() + random.nextFloat() * 3.3f,
                            getZ() + random.nextGaussian(),
                            0.7, 0.7, 0.9
                    );
                    
                }
            }
        }
        
        if (isLeaping() && isInWater()) {
            setLeaping(false);
        }
    }
    
    public int getInvulTime() {
        return this.entityData.get(DATA_ID_INV);
    }
    
    public void setInvulTime(int time) {
        this.entityData.set(DATA_ID_INV, time);
    }
    
    public boolean isLeaping() {
        return this.entityData.get(LEAPING);
    }
    
    public void setLeaping(boolean value) {
        this.entityData.set(LEAPING, value);
    }
    
    public boolean isEntityUpsideDown() {
        String name = this.getName().getString();
        return "Dinnerbone".equals(name) || "Grumm".equals(name);
    }
    
    @Override
    protected void customServerAiStep() {
        if (this.getInvulTime() > 0) {
            int j1 = this.getInvulTime() - 1;
            
            if (j1 <= 0) {
                level().explode(this, getX(), getEyeY(), getZ(), 7.0F, Level.ExplosionInteraction.TNT);
                this.playSound(SoundEvents.WITHER_SPAWN, 10.0F, 1.0F);
            }
            
            this.setInvulTime(j1);
        } else {
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
    }
    
    @Override
    public int getMaxFallDistance() {
        return Integer.MAX_VALUE;
    }
    
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            entity.addDeltaMovement(new Vec3(0, 0.4D, 0));
            return true;
        }
        return false;
    }
    
    @Override
    public float getBlockExplosionResistance(Explosion explosion, BlockGetter level, BlockPos pos, BlockState state, FluidState fluid, float explosionPower) {
        
        float f = super.getBlockExplosionResistance(explosion, level, pos, state, fluid, explosionPower);
        
        if (!state.isAir() && !state.is(BlockTags.WITHER_IMMUNE)) {
            f = Math.min(2F, f);
        }
        
        return f;
    }
    
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source != damageSources().drown() && !(source.getEntity() instanceof MournerBoss)) {
            if (this.getInvulTime() > 0 && source != damageSources().fellOutOfWorld()) {
                return false;
            }
            return super.hurt(source, amount);
        }
        return false;
    }
    
    public void makeInvulnerable() {
        this.setInvulTime(200);
    }
    
    @Override
    protected void tickDeath() {
        ++this.deathTime;
        
        if (this.deathTime >= 180 && this.deathTime <= 200) {
            float f = (random.nextFloat() - 0.5F) * 8.0F;
            float f1 = (random.nextFloat() - 0.5F) * 4.0F;
            float f2 = (random.nextFloat() - 0.5F) * 8.0F;
            level().addParticle(ParticleTypes.EXPLOSION,
                    getX() + f,
                    getY() + 2.0D + f1,
                    getZ() + f2,
                    0.0D, 0.0D, 0.0D);
        }
        
        int xpBase = 50;
        
        if (!level().isClientSide) {
            if (this.deathTime > 150 && this.deathTime % 5 == 0) {
                Player p = this.unlimitedLastHurtByPlayer != null
                        ? level().getPlayerByUUID(this.unlimitedLastHurtByPlayer)
                        : null;
                
                int award = net.minecraftforge.event.ForgeEventFactory.getExperienceDrop(
                        this, p, Mth.floor(xpBase * 0.08F));
                
                ExperienceOrb.award((ServerLevel) level(), this.position(), award);
            }
            
            if (this.deathTime == 1 && !this.isSilent()) {
                this.level().globalLevelEvent(1028, this.blockPosition(), 0);
                this.playSound(SoundEvents.ENDER_DRAGON_DEATH, 10.0F, 1.0F);
            }
        }
        
        this.setDeltaMovement(0, 0.01f, 0);
        
        if (this.deathTime >= 200) {
            if (!level().isClientSide) {
                Player p = this.unlimitedLastHurtByPlayer != null
                        ? level().getPlayerByUUID(this.unlimitedLastHurtByPlayer)
                        : null;
                
                int award = net.minecraftforge.event.ForgeEventFactory.getExperienceDrop(
                        this, p, Mth.floor(xpBase * 0.2F));
                
                ExperienceOrb.award((ServerLevel) level(), this.position(), award);
                
                if (p != null) {
                    this.dropFromLootTable(damageSources().playerAttack(p), true);
                } else {
                    this.dropFromLootTable(damageSources().genericKill(), true);
                }
                
                this.remove(RemovalReason.KILLED);
                this.gameEvent(GameEvent.ENTITY_DIE);
            }
            
            for (int k = 0; k < 20; ++k) {
                double d2 = random.nextGaussian() * 0.02D;
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                level().addParticle(
                        ParticleTypes.EXPLOSION_EMITTER,
                        getX() + (random.nextFloat() * getBbWidth() * 2.0F) - getBbWidth(),
                        getY() + (random.nextFloat() * getBbHeight()),
                        getZ() + (random.nextFloat() * getBbWidth() * 2.0F) - getBbWidth(),
                        d2, d0, d1);
            }
        }
    }
    
    class DestroyerDoNothingGoal extends Goal {
        public DestroyerDoNothingGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
        
        @Override
        public boolean canUse() {
            return DestroyerBoss.this.getInvulTime() > 0;
        }
    }
    
    static class DestroyerBigLeapGoal extends Goal {
        private final DestroyerBoss destroyer;
        private final float leapYya;
        
        public DestroyerBigLeapGoal(DestroyerBoss destroyer, float leapYya) {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
            this.destroyer = destroyer;
            this.leapYya = leapYya;
        }
        
        @Override
        public boolean canUse() {
            LivingEntity livingEntity = destroyer.getTarget();
            if(livingEntity == null || !destroyer.onGround() || destroyer.isInWater()) return false;
            else {
                double d0 = destroyer.distanceToSqr(livingEntity);
                if (d0 >= 16.0D && d0 <= 1024.0D && destroyer.random.nextInt(7) == 0) return true;
                else return false;
            }
        }
        
        @Override
        public boolean canContinueToUse() {
            return false;
        }
        
        @Override
        public void start() {
            double d0 = destroyer.getTarget().getX() - destroyer.getX();
            double d1 = destroyer.getTarget().getZ() - destroyer.getZ();
            float f = Mth.sqrt((float) (d0 * d0 + d1 * d1));
            
            float enrage = 2.0F - destroyer.getHealth() / destroyer.getMaxHealth();
            Vec3 movement = destroyer.getDeltaMovement();
            double x = movement.x;
            double z = movement.z;
            if (f >= 1.0E-4F) {
                x = x * 1.4 + d0 / f * 1.5D * 0.800000011920929D;
                z = z * 1.4 + d1 / f * 1.5D * 0.800000011920929D;
            }
            x *= enrage;
            z *= enrage;
            Vec3 newMovement = new Vec3(x, leapYya, z);
            destroyer.setDeltaMovement(newMovement);
            this.destroyer.setLeaping(true);
            destroyer.getLookControl().setLookAt(destroyer.getTarget(), 10.0F, 10.0F);
        }
    }
}
