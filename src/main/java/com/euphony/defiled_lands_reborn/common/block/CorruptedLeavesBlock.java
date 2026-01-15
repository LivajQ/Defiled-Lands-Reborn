package com.euphony.defiled_lands_reborn.common.block;

import com.euphony.defiled_lands_reborn.utils.CorruptionUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CorruptedLeavesBlock extends LeavesBlock {
    
    public CorruptedLeavesBlock(Properties properties) {
        super(properties.randomTicks());
    }
    
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        CorruptionUtils.spread(level, pos, state, random);
    }
    
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
    
    }
}
