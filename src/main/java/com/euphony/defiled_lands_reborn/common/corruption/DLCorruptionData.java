package com.euphony.defiled_lands_reborn.common.corruption;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public final class DLCorruptionData {
    
    private static final Map<Block, Block> BLOCK_CONVERSIONS = new HashMap<>();
    private static final Map<TagKey<Block>, Block> TAG_CONVERSIONS = new HashMap<>();
    
    public static void clear() {
        BLOCK_CONVERSIONS.clear();
        TAG_CONVERSIONS.clear();
    }
    
    public static void addBlock(Block from, Block to) {
        BLOCK_CONVERSIONS.put(from, to);
    }
    
    public static void addTag(TagKey<Block> tag, Block to) {
        TAG_CONVERSIONS.put(tag, to);
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
