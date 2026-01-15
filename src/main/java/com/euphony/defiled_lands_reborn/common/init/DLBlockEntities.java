package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.entity.block.ConjuringAltarBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLBlockEntities {
    
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<BlockEntityType<ConjuringAltarBlockEntity>> CONJURING_ALTAR_BE =
            BLOCK_ENTITY_TYPES.register(
                    "conjuring_altar",
                    () -> BlockEntityType.Builder.of(
                            ConjuringAltarBlockEntity::new,
                            DLBlocks.CONJURING_ALTAR.get()
                    ).build(null)
            );
}
