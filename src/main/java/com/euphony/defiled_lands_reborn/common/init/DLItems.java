package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.item.*;
import com.euphony.defiled_lands_reborn.common.item.armor.DLArmorMaterials;
import com.euphony.defiled_lands_reborn.common.item.food.DLFoods;
import com.euphony.defiled_lands_reborn.common.item.tool.DLToolMaterials;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public class DLItems {
    
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DefiledLandsReborn.MOD_ID);
    
    public static final Collection<RegistryObject<Item>> SPAWN_EGGS = new ArrayList<>();
    
    public static final RegistryObject<HephaestiteShardItem> HEPHAESTITE_SHARD =
            register("hephaestite_shard", HephaestiteShardItem::new);
    
    public static final RegistryObject<Item> UMBRIUM_INGOT =
            register("umbrium_ingot", Item::new);
    
    public static final RegistryObject<Item> UMBRIUM_NUGGET =
            register("umbrium_nugget", Item::new);
    
    public static final RegistryObject<Item> SCARLITE =
            register("scarlite", Item::new);
    
    public static final RegistryObject<Item> BLASTEM_SEED =
            register("blastem_seed", Item::new);
    
    public static final RegistryObject<BlastemFruitItem> BLASTEM_FRUIT =
            register("blastem_fruit", BlastemFruitItem::new);
    
    public static final RegistryObject<BlazingBlastemFruitItem> BLAZING_BLASTEM_FRUIT =
            register("blazing_blastem_fruit", BlazingBlastemFruitItem::new);
    
    public static final RegistryObject<DefilementPowderItem> DEFILEMENT_POWDER =
            register("defilement_powder", DefilementPowderItem::new);
    
    public static final RegistryObject<Item> SCUTTLER_EYE =
            register("scuttler_eye", p -> new Item(p.food(DLFoods.SCUTTLER_EYE)));
    
    public static final RegistryObject<Item> BLACK_HEART =
            register("black_heart", p -> new Item(p.food(DLFoods.BLACK_HEART)));
    
    public static final RegistryObject<Item> FOUL_SLIME =
            register("foul_slime", Item::new);
    
    public static final RegistryObject<Item> FOUL_CANDY =
            register("foul_candy", p -> new Item(p.food(DLFoods.FOUL_CANDY)));
    
    public static final RegistryObject<Item> RAW_BOOK_WYRM =
            register("raw_book_wyrm", p -> new Item(p.food(DLFoods.RAW_BOOK_WYRM)));
    
    public static final RegistryObject<Item> COOKED_BOOK_WYRM =
            register("cooked_book_wyrm", p -> new Item(p.food(DLFoods.COOKED_BOOK_WYRM)));
    
    public static final RegistryObject<Item> BOOK_WYRM_SCALE =
            register("book_wyrm_scale", Item::new);
    
    public static final RegistryObject<Item> GOLDEN_BOOK_WYRM_SCALE =
            register("golden_book_wyrm_scale", Item::new);
    
    public static final RegistryObject<AxeItem> UMBRIUM_AXE =
            register("umbrium_axe",
                    p -> new AxeItem(DLToolMaterials.UMBRIUM, 6.0f, -3.1F, p));
    
    public static final RegistryObject<HoeItem> UMBRIUM_HOE =
            register("umbrium_hoe",
                    p -> new HoeItem(DLToolMaterials.UMBRIUM, -2, -1.0F, p));
    
    public static final RegistryObject<PickaxeItem> UMBRIUM_PICKAXE =
            register("umbrium_pickaxe",
                    p -> new PickaxeItem(DLToolMaterials.UMBRIUM, 1, -2.8F, p));
    
    public static final RegistryObject<ShovelItem> UMBRIUM_SHOVEL =
            register("umbrium_shovel",
                    p -> new ShovelItem(DLToolMaterials.UMBRIUM, 1.5f, -3.0F, p));
    
    public static final RegistryObject<SwordItem> UMBRIUM_SWORD =
            register("umbrium_sword",
                    p -> new SwordItem(DLToolMaterials.UMBRIUM, 3, -2.4F, p));
    
    public static final RegistryObject<ScarliteReaverItem> SCARLITE_REAVER =
            register("scarlite_reaver", ScarliteReaverItem::new);
    
    public static final RegistryObject<ScarliteRazorItem> SCARLITE_RAZOR =
            register("scarlite_razor", ScarliteRazorItem::new);
    
    public static final RegistryObject<ArmorItem> UMBRIUM_HELMET =
            register("umbrium_helmet",
                    p -> new ArmorItem(DLArmorMaterials.UMBRIUM, ArmorItem.Type.HELMET, p));
    
    public static final RegistryObject<ArmorItem> UMBRIUM_CHESTPLATE =
            register("umbrium_chestplate",
                    p -> new ArmorItem(DLArmorMaterials.UMBRIUM, ArmorItem.Type.CHESTPLATE, p));
    
    public static final RegistryObject<ArmorItem> UMBRIUM_LEGGINGS =
            register("umbrium_leggings",
                    p -> new ArmorItem(DLArmorMaterials.UMBRIUM, ArmorItem.Type.LEGGINGS, p));
    
    public static final RegistryObject<ArmorItem> UMBRIUM_BOOTS =
            register("umbrium_boots",
                    p -> new ArmorItem(DLArmorMaterials.UMBRIUM, ArmorItem.Type.BOOTS, p));
    
    public static final RegistryObject<ArmorItem> BOOK_WYRM_SCALE_HELMET =
            register("book_wyrm_scale_helmet",
                    p -> new ArmorItem(DLArmorMaterials.BOOK_WYRM_SCALE, ArmorItem.Type.HELMET, p));
    
    public static final RegistryObject<ArmorItem> BOOK_WYRM_SCALE_CHESTPLATE =
            register("book_wyrm_scale_chestplate",
                    p -> new ArmorItem(DLArmorMaterials.BOOK_WYRM_SCALE, ArmorItem.Type.CHESTPLATE, p));
    
    public static final RegistryObject<ArmorItem> BOOK_WYRM_SCALE_LEGGINGS =
            register("book_wyrm_scale_leggings",
                    p -> new ArmorItem(DLArmorMaterials.BOOK_WYRM_SCALE, ArmorItem.Type.LEGGINGS, p));
    
    public static final RegistryObject<ArmorItem> BOOK_WYRM_SCALE_BOOTS =
            register("book_wyrm_scale_boots",
                    p -> new ArmorItem(DLArmorMaterials.BOOK_WYRM_SCALE, ArmorItem.Type.BOOTS, p));
    
    public static final RegistryObject<ArmorItem> GOLDEN_BOOK_WYRM_SCALE_HELMET =
            register("golden_book_wyrm_scale_helmet",
                    p -> new ArmorItem(DLArmorMaterials.GOLDEN_BOOK_WYRM_SCALE, ArmorItem.Type.HELMET, p));
    
    public static final RegistryObject<ArmorItem> GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE =
            register("golden_book_wyrm_scale_chestplate",
                    p -> new ArmorItem(DLArmorMaterials.GOLDEN_BOOK_WYRM_SCALE, ArmorItem.Type.CHESTPLATE, p));
    
    public static final RegistryObject<ArmorItem> GOLDEN_BOOK_WYRM_SCALE_LEGGINGS =
            register("golden_book_wyrm_scale_leggings",
                    p -> new ArmorItem(DLArmorMaterials.GOLDEN_BOOK_WYRM_SCALE, ArmorItem.Type.LEGGINGS, p));
    
    public static final RegistryObject<ArmorItem> GOLDEN_BOOK_WYRM_SCALE_BOOTS =
            register("golden_book_wyrm_scale_boots",
                    p -> new ArmorItem(DLArmorMaterials.GOLDEN_BOOK_WYRM_SCALE, ArmorItem.Type.BOOTS, p));
    
    public static final RegistryObject<UmbraBlasterItem> UMBRA_BLASTER =
            register("umbra_blaster", p -> new UmbraBlasterItem(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<ConcussionSmasherItem> CONCUSSION_SMASHER =
            register("concussion_smasher", p -> new ConcussionSmasherItem(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<BookWyrmAnalyzerItem> BOOK_WYRM_ANALYZER =
            register("book_wyrm_analyzer", BookWyrmAnalyzerItem::new);
    
    public static final RegistryObject<Item> CALLING_STONE =
            register("calling_stone", Item::new);
    
    public static final RegistryObject<Item> RAVAGING_ESSENCE =
            register("ravaging_essence",
                    p -> new Item(p));
    
    public static final RegistryObject<Item> RAVAGING_INGOT =
            register("ravaging_ingot",
                    p -> new Item(p));
    
    
    public static final RegistryObject<AxeItem> RAVAGING_AXE =
            register("ravaging_axe",
                    p -> new AxeItem(DLToolMaterials.RAVAGING, 5.0f, -3.0F, p));
    
    public static final RegistryObject<PickaxeItem> RAVAGING_PICKAXE =
            register("ravaging_pickaxe",
                    p -> new PickaxeItem(DLToolMaterials.RAVAGING, 1, -2.8F, p));
    
    public static final RegistryObject<ShovelItem> RAVAGING_SHOVEL =
            register("ravaging_shovel",
                    p -> new ShovelItem(DLToolMaterials.RAVAGING, 1.5f, -3.0F, p));
    
    public static final RegistryObject<RavagerItem> THE_RAVAGER =
            register("the_ravager", p -> new RavagerItem(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> UMBRIUM_PELLET =
            register("umbrium_pellet", Item::new);
    
    public static final RegistryObject<Item> SPIKED_PELLET =
            register("spiked_pellet", Item::new);
    
    public static final RegistryObject<Item> RAVAGING_PELLET =
            register("ravaging_pellet", Item::new);
    
    
    public static final RegistryObject<Item> IDOL_SORROW =
            register("idol_sorrow", Item::new);
    
    public static final RegistryObject<Item> REMORSEFUL_ESSENCE =
            register("remorseful_essence", Item::new);
    
    public static final RegistryObject<Item> REMORSEFUL_GEM =
            register("remorseful_gem", Item::new);
    
    public static final RegistryObject<TearsItem> TEARS_FLAME =
            register("tears_flame", TearsItem.Flame::new);
    
    public static final RegistryObject<TearsItem> TEARS_SHULKER =
            register("tears_shulker", TearsItem.Shulker::new);
    
    
    public static final RegistryObject<Item> SCARLITE_RING =
            register("scarlite_ring",
                    p -> new Item(p.stacksTo(1)));
    
    public static final RegistryObject<Item> PHYTOPROSTASIA_AMULET =
            register("phytoprostasia_amulet", Item::new);
    
    private static <T extends Item> RegistryObject<T> register(String name, Function<Item.Properties, T> factory) {
        return ITEMS.register(name, () -> factory.apply(new Item.Properties()));
    }
    
    private static RegistryObject<BlockItem> register(String name, Supplier<? extends Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
