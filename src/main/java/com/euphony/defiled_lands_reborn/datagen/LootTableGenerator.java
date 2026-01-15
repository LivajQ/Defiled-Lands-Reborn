package com.euphony.defiled_lands_reborn.datagen;

import com.euphony.defiled_lands_reborn.datagen.loot.BlockLootGenerator;
import com.euphony.defiled_lands_reborn.datagen.loot.EntityLootGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(PackOutput output) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(EntityLootGenerator::new, LootContextParamSets.ENTITY),
                new SubProviderEntry(BlockLootGenerator::new, LootContextParamSets.BLOCK)
        ));
    }

    /*
    @Override
    protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {

    }

     */
}
