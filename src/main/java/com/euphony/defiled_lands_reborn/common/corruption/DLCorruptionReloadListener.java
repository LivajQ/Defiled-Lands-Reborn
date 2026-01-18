package com.euphony.defiled_lands_reborn.common.corruption;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.tags.TagKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class DLCorruptionReloadListener extends SimpleJsonResourceReloadListener {
    
    public DLCorruptionReloadListener() {
        super(new Gson(), "corruption");
    }
    
    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons, ResourceManager resourceManager, ProfilerFiller profiler) {
        DLCorruptionData.clear();
        
        for (JsonElement element : jsons.values()) {
            JsonObject obj = element.getAsJsonObject();
            
            for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                String key = entry.getKey();
                ResourceLocation targetId = ResourceLocation.tryParse(entry.getValue().getAsString());
                Block target = BuiltInRegistries.BLOCK.get(targetId);
                
                if (target == null) {
                    DefiledLandsReborn.LOGGER.warn("Unknown target block: {}", targetId);
                    continue;
                }
                
                // Tag-based conversion
                if (key.startsWith("#")) {
                    ResourceLocation tagId = ResourceLocation.tryParse(key.substring(1));
                    TagKey<Block> tag = TagKey.create(Registries.BLOCK, tagId);
                    DLCorruptionData.addTag(tag, target);
                }
                // Direct block conversion
                else {
                    ResourceLocation fromId = ResourceLocation.tryParse(key);
                    Block from = BuiltInRegistries.BLOCK.get(fromId);
                    
                    if (from == null) {
                        DefiledLandsReborn.LOGGER.warn("Unknown source block: {}", fromId);
                        continue;
                    }
                    
                    DLCorruptionData.addBlock(from, target);
                }
            }
        }
        DLCorruptionData.sync();
    }
}
