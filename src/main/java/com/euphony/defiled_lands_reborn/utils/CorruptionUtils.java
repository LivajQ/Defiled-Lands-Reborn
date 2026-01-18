package com.euphony.defiled_lands_reborn.utils;

import com.euphony.defiled_lands_reborn.common.corruption.DLCorruptionData;
import com.euphony.defiled_lands_reborn.common.tag.DLBiomeTags;
import com.euphony.defiled_lands_reborn.config.ConfigHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CorruptionUtils {
    
    public static void spread(Level level, BlockPos pos, BlockState state, RandomSource rand) {
        if (level.isClientSide()) return;
        
        if (canSpread(level, pos, rand) && rand.nextInt(3) == 0) {
            for (int i = 0; i < 4; ++i) {
                BlockPos targetPos = pos.offset(
                        rand.nextInt(5) - 2,
                        rand.nextInt(5) - 2,
                        rand.nextInt(5) - 2
                );
                
                if (targetPos.getY() <= -60 || targetPos.getY() >= 320) continue;
                if (!level.isLoaded(targetPos)) continue;
                
                BlockState targetState = level.getBlockState(targetPos);
                corrupt(level, targetPos, targetState);
            }
        }
    }
    
    public static boolean canSpread(Level level, BlockPos pos, RandomSource rand) {
        Holder<Biome> biome = level.getBiome(pos);
        return biome.is(DLBiomeTags.IS_DEFILED) || ConfigHelper.common().general.enableCorruptionSpread.get();
    }
    
    public static boolean corrupt(Level level, BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        
        if (isAlreadyDefiled(block)) return false;
        
        Block result = DLCorruptionData.getResult(block);
        if (result == null) return false;
        
        level.setBlockAndUpdate(pos, result.defaultBlockState());
        return true;
    }
    
    public static boolean isAlreadyDefiled(Block block) {
        return DLCorruptionData.getDefiledTargets().contains(block);
    }
}