package com.euphony.defiled_lands_reborn.datagen;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.datagen.tag.BlockTagGenerator;
import com.euphony.defiled_lands_reborn.datagen.tag.ItemTagGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = DefiledLandsReborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DLDataGenerator {
    
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existing = event.getExistingFileHelper();
        
        BlockTagGenerator blockTags = new BlockTagGenerator(output, event.getLookupProvider(), existing);
        generator.addProvider(event.includeServer(), blockTags);
        
        generator.addProvider(event.includeServer(), new ItemTagGenerator(output, event.getLookupProvider(), blockTags.contentsGetter(), existing));
        
        generator.addProvider(event.includeServer(), new RecipeGenerator(output));

        generator.addProvider(event.includeClient(), new DLItemModelProvider(output, existing));
        
        generator.addProvider(event.includeClient(), new DLBlockModelProvider(output, existing));
        
        // generator.addProvider(event.includeServer(), new DLLootTableProvider(output));
        
        generator.addProvider(true,
                new PackMetadataGenerator(output)
                        .add(
                                PackMetadataSection.TYPE,
                                new PackMetadataSection(
                                        Component.literal("Resources for Defiled Lands Reborn"),
                                        15,
                                        Map.of(PackType.CLIENT_RESOURCES, 15)
                                )
                        )
        );
    }
}
