package com.euphony.defiled_lands_reborn.common.item.tool;//

import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public interface DLToolMaterials {
    
    Tier UMBRIUM = new ForgeTier(
            2,
            302,
            6.0F,
            2.0F,
            14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.UMBRIUM_TOOL_MATERIALS)
    );
    
    Tier SCARLITE = new ForgeTier(
            2,
            1561,
            6.0F,
            2.0F,
            14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.SCARLITE_TOOL_MATERIALS)
    );
    
    Tier SCARLITE_RAZOR = new ForgeTier(
            2,
            31,
            6.0F,
            2.0F,
            14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.SCARLITE_RAZOR_TOOL_MATERIALS)
    );
    
    Tier RAVAGING = new ForgeTier(
            3,
            2107,
            8.0F,
            3.0F,
            10,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.RAVAGING_TOOL_MATERIALS)
    );
}
