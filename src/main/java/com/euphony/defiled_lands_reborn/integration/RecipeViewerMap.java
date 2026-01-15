package com.euphony.defiled_lands_reborn.integration;

import com.euphony.defiled_lands_reborn.common.corruption.DLCorruptionData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class RecipeViewerMap {
    public static List<Pair<Block, Block>> getCorruptionRecipes() {
        List<Pair<Block, Block>> list = new ArrayList<>();
        
        for (Block input : BuiltInRegistries.BLOCK) {
            Block output = DLCorruptionData.getResult(input);
            if (output != null) {
                list.add(Pair.of(input, output));
            }
        }
        
        return list;
    }
    
}
