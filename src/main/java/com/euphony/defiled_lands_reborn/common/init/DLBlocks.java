package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.block.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class DLBlocks {
    
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DefiledLandsReborn.MOD_ID);
    
    // Forge requires BlockSetType to be registered statically
    public static final BlockSetType TENEBRA_BLOCK_SET = new BlockSetType("tenebra");
    
    // --- BLOCK REGISTRATION HELPERS ---
    
    private static <T extends Block> RegistryObject<T> register(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties props) {
        return BLOCKS.register(name, () -> factory.apply(props));
    }
    
    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties props) {
        RegistryObject<T> block = register(name, factory, props);
        DLItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
    
    // --- BLOCKS ---
    
    public static final RegistryObject<CorruptedBlock> DEFILED_STONE =
            registerWithItem("defiled_stone", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.STONE));
    
    public static final RegistryObject<CorruptedBlock> DEFILED_SANDSTONE =
            registerWithItem("defiled_sandstone", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE));
    
    public static final RegistryObject<CorruptedBlock> DEFILED_DIRT =
            registerWithItem("defiled_dirt", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.DIRT));
    
    public static final RegistryObject<CorruptedGrassBlock> DEFILED_GRASS_BLOCK =
            registerWithItem("defiled_grass_block", CorruptedGrassBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK));
    
    public static final RegistryObject<CorruptedColoredFallingBlock> DEFILED_GRAVEL =
            registerWithItem("defiled_gravel",
                    p -> new CorruptedColoredFallingBlock(-8356741, p),
                    BlockBehaviour.Properties.copy(Blocks.GRAVEL));
    
    public static final RegistryObject<CorruptedColoredFallingBlock> DEFILED_SAND =
            registerWithItem("defiled_sand",
                    p -> new CorruptedColoredFallingBlock(14406560, p),
                    BlockBehaviour.Properties.copy(Blocks.SAND));
    
    public static final RegistryObject<CorruptedLogBlock> TENEBRA_LOG =
            registerWithItem("tenebra_log", CorruptedLogBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
    
    public static final RegistryObject<CorruptedLeavesBlock> TENEBRA_LEAVES =
            registerWithItem("tenebra_leaves",
                    CorruptedLeavesBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    
    public static final RegistryObject<TenebraSaplingBlock> TENEBRA_SAPLING =
            registerWithItem("tenebra_sapling",
                    TenebraSaplingBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING));
    
    public static final RegistryObject<CorruptedBlock> TENEBRA_PLANKS =
            registerWithItem("tenebra_planks", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    
    public static final RegistryObject<HephaestiteOreBlock> HEPHAESTITE_ORE =
            registerWithItem("hephaestite_ore",
                    p -> new HephaestiteOreBlock(UniformInt.of(0, 2), p),
                    BlockBehaviour.Properties.copy(Blocks.COAL_ORE));
    
    public static final RegistryObject<HephaestiteBlock> HEPHAESTITE_BLOCK =
            registerWithItem("hephaestite_block", HephaestiteBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK));
    
    public static final RegistryObject<CorruptedBlock> UMBRIUM_ORE =
            registerWithItem("umbrium_ore", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.IRON_ORE));
    
    public static final RegistryObject<CorruptedBlock> UMBRIUM_BLOCK =
            registerWithItem("umbrium_block", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
    
    public static final RegistryObject<CorruptedBlock> SCARLITE_ORE =
            registerWithItem("scarlite_ore", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE));
    
    public static final RegistryObject<CorruptedBlock> SCARLITE_BLOCK =
            registerWithItem("scarlite_block", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
    
    public static final RegistryObject<VilespineBlock> VILESPINE =
            registerWithItem("vilespine", VilespineBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH));
    
    public static final RegistryObject<BlastemBlock> BLASTEM =
            registerWithItem("blastem", BlastemBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    
    public static final RegistryObject<ScuronotteBlock> SCURONOTTE =
            registerWithItem("scuronotte", ScuronotteBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM));
    
    public static final RegistryObject<HealingPadBlock> HEALING_PAD =
            registerWithItem("healing_pad", HealingPadBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    
    public static final RegistryObject<ConjuringAltarBlock> CONJURING_ALTAR =
            registerWithItem("conjuring_altar", ConjuringAltarBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    
    public static final RegistryObject<CorruptedBlock> DEFILED_STONE_BRICKS =
            registerWithItem("defiled_stone_bricks", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS));
    
    public static final RegistryObject<CorruptedBlock> DEFILED_CRACKED_STONE_BRICKS =
            registerWithItem("defiled_cracked_stone_bricks", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS));
    
    public static final RegistryObject<CorruptedBlock> DEFILED_MOSSY_STONE_BRICKS =
            registerWithItem("defiled_mossy_stone_bricks", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS));
    
    public static final RegistryObject<CorruptedBlock> DEFILED_MOSSY_STONE =
            registerWithItem("defiled_mossy_stone", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE));
    
    public static final RegistryObject<SlabBlock> DEFILED_STONE_SLAB =
            registerWithItem("defiled_stone_slab", SlabBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.STONE_SLAB));
    
    public static final RegistryObject<SlabBlock> DEFILED_SANDSTONE_SLAB =
            registerWithItem("defiled_sandstone_slab", SlabBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB));
    
    public static final RegistryObject<SlabBlock> DEFILED_STONE_BRICK_SLAB =
            registerWithItem("defiled_stone_brick_slab", SlabBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB));
    
    public static final RegistryObject<StairBlock> DEFILED_STONE_STAIRS =
            registerWithItem("defiled_stone_stairs",
                    p -> new StairBlock(DEFILED_STONE.get().defaultBlockState(), p),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS));
    
    public static final RegistryObject<StairBlock> DEFILED_SANDSTONE_STAIRS =
            registerWithItem("defiled_sandstone_stairs",
                    p -> new StairBlock(DEFILED_SANDSTONE.get().defaultBlockState(), p),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS));
    
    public static final RegistryObject<StairBlock> DEFILED_STONE_BRICK_STAIRS =
            registerWithItem("defiled_stone_brick_stairs",
                    p -> new StairBlock(DEFILED_STONE_BRICKS.get().defaultBlockState(), p),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS));
    
    public static final RegistryObject<SlabBlock> TENEBRA_SLAB =
            registerWithItem("tenebra_slab", SlabBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    
    public static final RegistryObject<StairBlock> TENEBRA_STAIRS =
            registerWithItem("tenebra_stairs",
                    p -> new StairBlock(TENEBRA_PLANKS.get().defaultBlockState(), p),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS));
    
    public static final RegistryObject<DoorBlock> TENEBRA_DOOR =
            registerWithItem("tenebra_door",
                    p -> new DoorBlock(p, TENEBRA_BLOCK_SET),
                    BlockBehaviour.Properties.copy(Blocks.OAK_DOOR));
    
    public static final RegistryObject<CorruptedBlock> RAVAGING_STONE =
            registerWithItem("ravaging_stone", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.STONE));
    
    public static final RegistryObject<CorruptedBlock> RAVAGING_BRICKS =
            registerWithItem("ravaging_bricks", CorruptedBlock::new,
                    BlockBehaviour.Properties.copy(Blocks.BRICKS));
}
