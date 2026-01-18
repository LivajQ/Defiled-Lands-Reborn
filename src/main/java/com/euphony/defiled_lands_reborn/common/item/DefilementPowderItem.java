package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.utils.CorruptionUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class DefilementPowderItem extends Item {
    public DefilementPowderItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        
        if (!level.isClientSide()) {
            boolean success = CorruptionUtils.corrupt(level, pos, state);
            
            if (success) {
                Player player = context.getPlayer();
                if (player != null && !player.isCreative()) context.getItemInHand().shrink(1);
                spawnSmoke(level, pos);
                level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH,  SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }
        
        return InteractionResult.SUCCESS;
    }
    
    private void spawnSmoke(Level level, BlockPos pos) {
        if (!(level instanceof ServerLevel server)) return;
        
        for (int i = 0; i < 8; i++) {
            double x = pos.getX() + 0.5 + (level.random.nextDouble() - 0.5);
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + 0.5 + (level.random.nextDouble() - 0.5);
            
            server.sendParticles(
                    ParticleTypes.SMOKE,
                    x, y, z,
                    1,
                    0.0, 0.02, 0.0,
                    0.0
            );
        }
    }
    
}
