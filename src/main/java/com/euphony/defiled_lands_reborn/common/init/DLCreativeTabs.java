package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLCreativeTabs {
    
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<CreativeModeTab> DEFILED_TAB =
            TABS.register("defiled_lands_reborn", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.tabDefiledLands"))
                            .icon(() -> new ItemStack(DLBlocks.DEFILED_GRASS_BLOCK.get()))
                            .displayItems((parameters, output) -> {

                                output.accept(DLBlocks.DEFILED_GRASS_BLOCK.get());
                                output.accept(DLBlocks.DEFILED_STONE.get());
                                output.accept(DLBlocks.DEFILED_SAND.get());
                                output.accept(DLBlocks.DEFILED_SANDSTONE.get());
                                output.accept(DLBlocks.DEFILED_DIRT.get());
                                output.accept(DLBlocks.DEFILED_GRAVEL.get());
                                
                                output.accept(DLBlocks.TENEBRA_LOG.get());
                                output.accept(DLBlocks.TENEBRA_LEAVES.get());
                                output.accept(DLBlocks.TENEBRA_SAPLING.get());
                                output.accept(DLBlocks.TENEBRA_PLANKS.get());
                                
                                output.accept(DLBlocks.HEPHAESTITE_ORE.get());
                                output.accept(DLBlocks.HEPHAESTITE_BLOCK.get());
                                output.accept(DLBlocks.UMBRIUM_ORE.get());
                                output.accept(DLBlocks.UMBRIUM_BLOCK.get());
                                output.accept(DLBlocks.SCARLITE_ORE.get());
                                output.accept(DLBlocks.SCARLITE_BLOCK.get());
                                
                                output.accept(DLBlocks.DEFILED_STONE_BRICKS.get());
                                output.accept(DLBlocks.DEFILED_CRACKED_STONE_BRICKS.get());
                                output.accept(DLBlocks.DEFILED_MOSSY_STONE_BRICKS.get());
                                output.accept(DLBlocks.DEFILED_MOSSY_STONE.get());
                                
                                output.accept(DLBlocks.DEFILED_STONE_SLAB.get());
                                output.accept(DLBlocks.DEFILED_SANDSTONE_SLAB.get());
                                output.accept(DLBlocks.DEFILED_STONE_BRICK_SLAB.get());
                                
                                output.accept(DLBlocks.DEFILED_STONE_STAIRS.get());
                                output.accept(DLBlocks.DEFILED_SANDSTONE_STAIRS.get());
                                output.accept(DLBlocks.DEFILED_STONE_BRICK_STAIRS.get());
                                
                                output.accept(DLBlocks.TENEBRA_SLAB.get());
                                output.accept(DLBlocks.TENEBRA_STAIRS.get());
                                output.accept(DLBlocks.TENEBRA_DOOR.get());
                                
                                output.accept(DLBlocks.RAVAGING_STONE.get());
                                output.accept(DLBlocks.RAVAGING_BRICKS.get());
                                
                                output.accept(DLBlocks.VILESPINE.get());
                                output.accept(DLBlocks.BLASTEM.get());
                                output.accept(DLBlocks.SCURONOTTE.get());
                                
                                output.accept(DLBlocks.HEALING_PAD.get());
                                output.accept(DLBlocks.CONJURING_ALTAR.get());
  
                                output.accept(DLItems.HEPHAESTITE_SHARD.get());
                                output.accept(DLItems.UMBRIUM_INGOT.get());
                                output.accept(DLItems.UMBRIUM_NUGGET.get());
                                output.accept(DLItems.SCARLITE.get());
                                
                                output.accept(DLItems.UMBRIUM_HELMET.get());
                                output.accept(DLItems.UMBRIUM_CHESTPLATE.get());
                                output.accept(DLItems.UMBRIUM_LEGGINGS.get());
                                output.accept(DLItems.UMBRIUM_BOOTS.get());
                                
                                output.accept(DLItems.BOOK_WYRM_SCALE_HELMET.get());
                                output.accept(DLItems.BOOK_WYRM_SCALE_CHESTPLATE.get());
                                output.accept(DLItems.BOOK_WYRM_SCALE_LEGGINGS.get());
                                output.accept(DLItems.BOOK_WYRM_SCALE_BOOTS.get());
                                
                                output.accept(DLItems.GOLDEN_BOOK_WYRM_SCALE_HELMET.get());
                                output.accept(DLItems.GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE.get());
                                output.accept(DLItems.GOLDEN_BOOK_WYRM_SCALE_LEGGINGS.get());
                                output.accept(DLItems.GOLDEN_BOOK_WYRM_SCALE_BOOTS.get());
                                
                                output.accept(DLItems.BLASTEM_SEED.get());
                                output.accept(DLItems.BLASTEM_FRUIT.get());
                                output.accept(DLItems.BLAZING_BLASTEM_FRUIT.get());
                                output.accept(DLItems.DEFILEMENT_POWDER.get());
                                
                                output.accept(DLItems.SCUTTLER_EYE.get());
                                output.accept(DLItems.BLACK_HEART.get());
                                output.accept(DLItems.FOUL_SLIME.get());
                                output.accept(DLItems.FOUL_CANDY.get());
                                output.accept(DLItems.RAW_BOOK_WYRM.get());
                                output.accept(DLItems.COOKED_BOOK_WYRM.get());
                                output.accept(DLItems.BOOK_WYRM_SCALE.get());
                                output.accept(DLItems.GOLDEN_BOOK_WYRM_SCALE.get());
                                
                                output.accept(DLItems.UMBRIUM_AXE.get());
                                output.accept(DLItems.UMBRIUM_HOE.get());
                                output.accept(DLItems.UMBRIUM_PICKAXE.get());
                                output.accept(DLItems.UMBRIUM_SHOVEL.get());
                                output.accept(DLItems.UMBRIUM_SWORD.get());
                                
                                output.accept(DLItems.SCARLITE_REAVER.get());
                                output.accept(DLItems.SCARLITE_RAZOR.get());
                                
                                output.accept(DLItems.UMBRA_BLASTER.get());
                                output.accept(DLItems.CONCUSSION_SMASHER.get());
                                
                                output.accept(DLItems.BOOK_WYRM_ANALYZER.get());
                                
                                output.accept(DLItems.CALLING_STONE.get());
                                output.accept(DLItems.RAVAGING_ESSENCE.get());
                                output.accept(DLItems.RAVAGING_INGOT.get());
                                
                                output.accept(DLItems.RAVAGING_AXE.get());
                                output.accept(DLItems.RAVAGING_PICKAXE.get());
                                output.accept(DLItems.RAVAGING_SHOVEL.get());
                                
                                output.accept(DLItems.THE_RAVAGER.get());
                                output.accept(DLItems.UMBRIUM_PELLET.get());
                                output.accept(DLItems.SPIKED_PELLET.get());
                                output.accept(DLItems.RAVAGING_PELLET.get());
                                
                                output.accept(DLItems.IDOL_SORROW.get());
                                output.accept(DLItems.REMORSEFUL_ESSENCE.get());
                                output.accept(DLItems.REMORSEFUL_GEM.get());
                                output.accept(DLItems.TEARS_FLAME.get());
                                output.accept(DLItems.TEARS_SHULKER.get());
                                
                                output.accept(DLItems.SCARLITE_RING.get());
                                output.accept(DLItems.PHYTOPROSTASIA_AMULET.get());
                                
                                // Spawn eggs
                                DLItems.SPAWN_EGGS.forEach(egg -> output.accept(egg.get()));
                            })
                            .build()
            );
}
