package com.euphony.defiled_lands_reborn.common.corruption;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DLCorruptionData {
    
    private static final Map<Block, Block> BLOCK_CONVERSIONS = new HashMap<>();
    private static final Map<TagKey<Block>, Block> TAG_CONVERSIONS = new HashMap<>();
    private static final Set<Block> DEFILED_TARGETS = new HashSet<>();
    
    public static void clear() {
        BLOCK_CONVERSIONS.clear();
        TAG_CONVERSIONS.clear();
        DEFILED_TARGETS.clear();
    }
    
    public static void addBlock(Block from, Block to) {
        BLOCK_CONVERSIONS.put(from, to);
    }
    
    public static void addTag(TagKey<Block> tag, Block to) {
        TAG_CONVERSIONS.put(tag, to);
    }
    
    public static void sync() {
        DEFILED_TARGETS.clear();
        DEFILED_TARGETS.addAll(DLCorruptionData.BLOCK_CONVERSIONS.values());
        DEFILED_TARGETS.addAll(DLCorruptionData.TAG_CONVERSIONS.values());
    }
    
    public static Set<Block> getDefiledTargets() {
        return DEFILED_TARGETS;
    }
    
    @Nullable
    public static Block getResult(Block block) {
        Block direct = BLOCK_CONVERSIONS.get(block);
        if (direct != null)
            return direct;

        for (Map.Entry<TagKey<Block>, Block> entry : TAG_CONVERSIONS.entrySet()) {
            if (block.defaultBlockState().is(entry.getKey())) return entry.getValue();
        }
        
        return null;
    }
}
