package com.euphony.defiled_lands_reborn.common.entity;

import com.euphony.defiled_lands_reborn.common.init.DLEntities;
import com.euphony.defiled_lands_reborn.config.ConfigHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;

import java.util.List;

public class GoldenBookWyrm extends BookWyrm {
    
    public GoldenBookWyrm(EntityType<? extends BookWyrm> type, Level world) {
        super(type, world);
    }

    @Override
    public List<EnchantmentInstance> getPossibleEnchantments() {
        var registry = level().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
        
        List<net.minecraft.world.item.enchantment.Enchantment> allowed =
                registry.stream()
                        .filter(net.minecraft.world.item.enchantment.Enchantment::isAllowedOnBooks)
                        .toList();
        
        List<EnchantmentInstance> list =
                EnchantmentHelper.selectEnchantment(
                        random,
                        Items.BOOK.getDefaultInstance(),
                        getEnchLevel(),
                        true
                );
        
        list.removeIf(e -> !allowed.contains(e.enchantment));
        
        return list;
    }
    
    @Override
    public boolean isGolden(AgeableMob mate) {
        double chance = ConfigHelper.common().entity.goldenBookWyrmProbabilityForOneGolden.get();
        
        if (mate instanceof GoldenBookWyrm) {
            chance = ConfigHelper.common().entity.goldenBookWyrmProbabilityForTwoGolden.get();
        }
        
        return random.nextDouble() <= chance;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mate) {
        if (mate instanceof BookWyrm) {
            
            int chance = (mate instanceof GoldenBookWyrm) ? 10 : 25;
            
            if (random.nextInt(chance) == 0) {
                GoldenBookWyrm child = DLEntities.GOLDEN_BOOK_WYRM.get().create(level);
                mixGenes(this, (BookWyrm) mate, child, random);
                return child;
            } else {
                BookWyrm child = DLEntities.BOOK_WYRM.get().create(level);
                mixGenes(this, (BookWyrm) mate, child, random);
                return child;
            }
        }
        
        return null;
    }
}
