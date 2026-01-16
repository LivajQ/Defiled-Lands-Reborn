package com.euphony.defiled_lands_reborn.datagen;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DLItemModelProvider extends ItemModelProvider {
    
    public DLItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, DefiledLandsReborn.MOD_ID, helper);
    }
    
    @Override
    protected void registerModels() {
        
        basicItem(DLItems.BLACK_HEART.get());
        basicItem(DLItems.BLASTEM_FRUIT.get());
        basicItem(DLItems.BLASTEM_SEED.get());
        basicItem(DLItems.BLAZING_BLASTEM_FRUIT.get());
        
        basicItem(DLItems.BOOK_WYRM_ANALYZER.get());
        
        basicItem(DLItems.BOOK_WYRM_SCALE.get());
        basicItem(DLItems.BOOK_WYRM_SCALE_BOOTS.get());
        basicItem(DLItems.BOOK_WYRM_SCALE_CHESTPLATE.get());
        basicItem(DLItems.BOOK_WYRM_SCALE_HELMET.get());
        basicItem(DLItems.BOOK_WYRM_SCALE_LEGGINGS.get());
        
        basicItem(DLItems.CALLING_STONE.get());
        
        basicItem(DLItems.RAW_BOOK_WYRM.get());
        basicItem(DLItems.COOKED_BOOK_WYRM.get());
        basicItem(DLItems.DEFILEMENT_POWDER.get());
        basicItem(DLItems.FOUL_CANDY.get());
        basicItem(DLItems.FOUL_SLIME.get());
        
        basicItem(DLItems.GOLDEN_BOOK_WYRM_SCALE.get());
        basicItem(DLItems.GOLDEN_BOOK_WYRM_SCALE_BOOTS.get());
        basicItem(DLItems.GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE.get());
        basicItem(DLItems.GOLDEN_BOOK_WYRM_SCALE_HELMET.get());
        basicItem(DLItems.GOLDEN_BOOK_WYRM_SCALE_LEGGINGS.get());
        
        basicItem(DLItems.HEPHAESTITE_SHARD.get());
        basicItem(DLItems.IDOL_SORROW.get());
        basicItem(DLItems.PHYTOPROSTASIA_AMULET.get());
        basicItem(DLItems.RAVAGING_ESSENCE.get());
        
        basicItem(DLItems.RAVAGING_INGOT.get());

        handheld(DLItems.RAVAGING_PELLET.get());
        handheld(DLItems.RAVAGING_PICKAXE.get());
        handheld(DLItems.RAVAGING_SHOVEL.get());
        handheld(DLItems.RAVAGING_AXE.get());
        
        basicItem(DLItems.REMORSEFUL_ESSENCE.get());
        basicItem(DLItems.REMORSEFUL_GEM.get());
        
        basicItem(DLItems.SCARLITE.get());
        handheld(DLItems.SCARLITE_RAZOR.get());
        handheld(DLItems.SCARLITE_REAVER.get());
        
        basicItem(DLItems.SCARLITE_RING.get());
        basicItem(DLItems.SCUTTLER_EYE.get());
        basicItem(DLItems.SPIKED_PELLET.get());
        
        handheld(DLItems.TEARS_FLAME.get());
        handheld(DLItems.TEARS_SHULKER.get());
        
        handheld(DLItems.THE_RAVAGER.get());
        handheld(DLItems.UMBRA_BLASTER.get());
        
        handheld(DLItems.UMBRIUM_AXE.get());
        handheld(DLItems.UMBRIUM_SWORD.get());
        handheld(DLItems.UMBRIUM_PICKAXE.get());
        handheld(DLItems.UMBRIUM_SHOVEL.get());
        handheld(DLItems.UMBRIUM_HOE.get());
        
        basicItem(DLItems.UMBRIUM_HELMET.get());
        basicItem(DLItems.UMBRIUM_CHESTPLATE.get());
        basicItem(DLItems.UMBRIUM_BOOTS.get());
        basicItem(DLItems.UMBRIUM_LEGGINGS.get());
        
        basicItem(DLItems.UMBRIUM_INGOT.get());
        basicItem(DLItems.UMBRIUM_NUGGET.get());
        basicItem(DLItems.UMBRIUM_PELLET.get());
        
        basicItem(DLBlocks.TENEBRA_DOOR.get().asItem());
        
        for (RegistryObject<Item> egg : DLItems.SPAWN_EGGS) {
            withExistingParent(egg.getId().getPath(), mcLoc("item/template_spawn_egg"));
        }
    }

    private void handheld(Item item) {
        getBuilder(BuiltInRegistries.ITEM.getKey(item).getPath())
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", modLoc("item/" + BuiltInRegistries.ITEM.getKey(item).getPath()));
    }
}
