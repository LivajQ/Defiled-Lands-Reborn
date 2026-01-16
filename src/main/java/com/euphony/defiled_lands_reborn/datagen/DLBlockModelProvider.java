package com.euphony.defiled_lands_reborn.datagen;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class DLBlockModelProvider extends BlockStateProvider {
    
    public DLBlockModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, DefiledLandsReborn.MOD_ID, helper);
    }
    
    @Override
    protected void registerStatesAndModels() {

        simpleCube(DLBlocks.DEFILED_STONE.get());
        simpleCube(DLBlocks.DEFILED_SANDSTONE.get());
        simpleCube(DLBlocks.DEFILED_DIRT.get());
        simpleCube(DLBlocks.DEFILED_GRAVEL.get());
        simpleCube(DLBlocks.DEFILED_SAND.get());
        
        simpleCube(DLBlocks.DEFILED_STONE_BRICKS.get());
        simpleCube(DLBlocks.DEFILED_CRACKED_STONE_BRICKS.get());
        simpleCube(DLBlocks.DEFILED_MOSSY_STONE_BRICKS.get());
        simpleCube(DLBlocks.DEFILED_MOSSY_STONE.get());
        
        simpleCube(DLBlocks.HEPHAESTITE_ORE.get());
        simpleCube(DLBlocks.HEPHAESTITE_BLOCK.get());
        simpleCube(DLBlocks.UMBRIUM_ORE.get());
        simpleCube(DLBlocks.UMBRIUM_BLOCK.get());
        simpleCube(DLBlocks.SCARLITE_ORE.get());
        simpleCube(DLBlocks.SCARLITE_BLOCK.get());
        simpleCube(DLBlocks.RAVAGING_STONE.get());
        simpleCube(DLBlocks.RAVAGING_BRICKS.get());
        
        // --- LOGS ---
        logBlock(DLBlocks.TENEBRA_LOG.get());
        
        // --- LEAVES ---
        simpleCube(DLBlocks.TENEBRA_LEAVES.get());
        
        // --- SAPLING ---
        simpleCross(DLBlocks.TENEBRA_SAPLING.get());
        
        // --- PLANKS ---
        simpleCube(DLBlocks.TENEBRA_PLANKS.get());
        
        // --- STAIRS ---
        stairsBlock(DLBlocks.DEFILED_STONE_STAIRS.get(),
                blockTexture(DLBlocks.DEFILED_STONE.get()));
        
        stairsBlock(DLBlocks.DEFILED_SANDSTONE_STAIRS.get(),
                blockTexture(DLBlocks.DEFILED_SANDSTONE.get()));
        
        stairsBlock(DLBlocks.DEFILED_STONE_BRICK_STAIRS.get(),
                blockTexture(DLBlocks.DEFILED_STONE_BRICKS.get()));
        
        stairsBlock(DLBlocks.TENEBRA_STAIRS.get(),
                blockTexture(DLBlocks.TENEBRA_PLANKS.get()));
        
        // --- SLABS ---
        slabBlock(DLBlocks.DEFILED_STONE_SLAB.get(),
                blockTexture(DLBlocks.DEFILED_STONE.get()),
                blockTexture(DLBlocks.DEFILED_STONE.get()));
        
        slabBlock(DLBlocks.DEFILED_SANDSTONE_SLAB.get(),
                blockTexture(DLBlocks.DEFILED_SANDSTONE.get()),
                blockTexture(DLBlocks.DEFILED_SANDSTONE.get()));
        
        slabBlock(DLBlocks.DEFILED_STONE_BRICK_SLAB.get(),
                blockTexture(DLBlocks.DEFILED_STONE_BRICKS.get()),
                blockTexture(DLBlocks.DEFILED_STONE_BRICKS.get()));
        
        slabBlock(DLBlocks.TENEBRA_SLAB.get(),
                blockTexture(DLBlocks.TENEBRA_PLANKS.get()),
                blockTexture(DLBlocks.TENEBRA_PLANKS.get()));
        
        doorBlock(DLBlocks.TENEBRA_DOOR.get(),
                modLoc("block/tenebra_door_bottom"),
                modLoc("block/tenebra_door_top")
        );
        
        //simpleCross(DLBlocks.SCURONOTTE.get());
        //simpleCross(DLBlocks.BLASTEM.get());
        
        //healingPadBlock(DLBlocks.HEALING_PAD.get());
        //simpleCube(DLBlocks.CONJURING_ALTAR.get());
        
        generateBlockItems();
    }
    
    // --- HELPERS ---
    
    private void generateBlockItems() {
        DLBlocks.BLOCKS.getEntries().forEach(block -> {
            Block b = block.get();
            
            if (b instanceof DoorBlock) return;
            
            if (b instanceof StairBlock ||
                    b instanceof SlabBlock ||
                    b instanceof LeavesBlock ||
                    b instanceof RotatedPillarBlock ||
                    b instanceof BushBlock) {
                
                simpleBlockItem(
                        b,
                        models().getExistingFile(
                                modLoc("block/" + block.getId().getPath())
                        )
                );
            }
        });
    }
    
    private void simpleCube(Block block) {
        simpleBlock(block);
        simpleBlockItem(block, cubeAll(block));
    }
    
    private void simpleCross(Block block) {
        simpleBlock(block, models().cross(name(block), blockTexture(block)));
        simpleBlockItem(block, models().cross(name(block), blockTexture(block)));
    }
    
    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
    
}
