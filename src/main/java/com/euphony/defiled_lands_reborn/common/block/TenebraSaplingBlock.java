package com.euphony.defiled_lands_reborn.common.block;

import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import com.euphony.defiled_lands_reborn.common.worldgen.features.tree.TenebraTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TenebraSaplingBlock extends SaplingBlock {
    public TenebraSaplingBlock(Properties props) {
        super(new TenebraTreeGrower(), props);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockState = level.getBlockState(blockpos);
        return blockState.is(DLBlocks.DEFILED_DIRT.get()) || blockState.is(DLBlocks.DEFILED_GRASS_BLOCK.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return this.mayPlaceOn(state, level, pos);
    }
}
