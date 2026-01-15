package com.euphony.defiled_lands_reborn.datagen.loot;

import com.euphony.defiled_lands_reborn.common.init.DLEntities;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class EntityLootGenerator implements LootTableSubProvider {
    
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> out) {
        
        out.accept(DLEntities.BOOK_WYRM.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.BOOK_WYRM_SCALE.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.RAW_BOOK_WYRM.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                                .apply(SmeltItemFunction.smelted().when(LootItemKilledByPlayerCondition.killedByPlayer()))
                        )
        );
        
        out.accept(DLEntities.GOLDEN_BOOK_WYRM.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.GOLDEN_BOOK_WYRM_SCALE.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.RAW_BOOK_WYRM.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                                .apply(SmeltItemFunction.smelted().when(LootItemKilledByPlayerCondition.killedByPlayer()))
                        )
        );
        
        out.accept(DLEntities.HOST.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.FOUL_SLIME.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                        )
        );

        out.accept(DLEntities.SCUTTLER.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.SCUTTLER_EYE.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.STRING))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(-1, 1)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );

        out.accept(DLEntities.SHAMBLER.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.BLACK_HEART.get()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceCondition.randomChance(0.5F))
                        )
        );

        out.accept(DLEntities.TWISTED_SHAMBLER.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.BLACK_HEART.get()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceCondition.randomChance(0.5F))
                        )
        );

        out.accept(DLEntities.DEFILED_SLIME.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.FOUL_SLIME.get()))
                                .when(LootItemEntityPropertyCondition.hasProperties(
                                        LootContext.EntityTarget.THIS,
                                        EntityPredicate.Builder.entity()
                                                .subPredicate(SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))
                                ))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 1.0F))
                        )
        );
        
        out.accept(DLEntities.DESTROYER.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.RAVAGING_ESSENCE.get()))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(8)))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.DEFILEMENT_POWDER.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 16)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 4.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.UMBRIUM_INGOT.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 4.0F))
                        )
        );
        
        out.accept(DLEntities.MOURNER.getId(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.REMORSEFUL_ESSENCE.get()))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(8)))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.DEFILEMENT_POWDER.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 16)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 4.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.UMBRIUM_INGOT.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 4.0F))
                        )
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(DLItems.SCARLITE.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.0F, 4.0F))
                        )
        );
    }
}

