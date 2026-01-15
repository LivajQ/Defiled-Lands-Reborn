package com.euphony.defiled_lands_reborn.common.block;

import com.euphony.defiled_lands_reborn.common.tag.DLBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ScuronotteBlock extends BushBlock {
    
    protected static final VoxelShape SHAPE =
            Block.box(5.0F, 0.0F, 5.0F, 11.0F, 6.0F, 11.0F);
    
    public ScuronotteBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolid();
    }
    
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState soil = level.getBlockState(below);
        return soil.is(DLBlockTags.BASE_DEFILED_SURFACE);
    }
}
