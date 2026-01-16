package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.entity.*;
import com.euphony.defiled_lands_reborn.common.entity.boss.DestroyerBoss;
import com.euphony.defiled_lands_reborn.common.entity.boss.MournerBoss;
import com.euphony.defiled_lands_reborn.common.entity.projectile.BlastemFruitProjectile;
import com.euphony.defiled_lands_reborn.common.entity.projectile.BlazingBlastemFruitProjectile;
import com.euphony.defiled_lands_reborn.common.entity.projectile.RavagerProjectile;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = DefiledLandsReborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DLEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DefiledLandsReborn.MOD_ID);
    
    // -------------------------
    // ENTITY REGISTRATION
    // -------------------------
    
    public static final RegistryObject<EntityType<DefiledSlime>> DEFILED_SLIME =
            registerMob("defiled_slime", 0xbe6d91, 0xc873a0,
                    () -> EntityType.Builder.of(DefiledSlime::new, MobCategory.MONSTER)
                            .sized(0.52F, 0.52F)
                            .clientTrackingRange(10));
    
    public static final RegistryObject<EntityType<BookWyrm>> BOOK_WYRM =
            registerMob("book_wyrm", 0x412c41, 0xfef9e4,
                    () -> EntityType.Builder.of(BookWyrm::new, MobCategory.CREATURE)
                            .sized(0.9F, 0.9F)
                            .clientTrackingRange(10));
    
    public static final RegistryObject<EntityType<GoldenBookWyrm>> GOLDEN_BOOK_WYRM =
            registerMob("golden_book_wyrm", 0xf1ca00, 0xfef9e4,
                    () -> EntityType.Builder.of(GoldenBookWyrm::new, MobCategory.CREATURE)
                            .sized(0.9F, 0.9F)
                            .clientTrackingRange(10));
    
    public static final RegistryObject<EntityType<Scuttler>> SCUTTLER =
            registerMob("scuttler", 0x211823, 0xce0bff,
                    () -> EntityType.Builder.of(Scuttler::new, MobCategory.MONSTER)
                            .sized(1.4F, 0.9F)
                            .clientTrackingRange(8));
    
    public static final RegistryObject<EntityType<Host>> HOST =
            registerMob("host", 0x3a3a3a, 0xc873a0,
                    () -> EntityType.Builder.of(Host::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8));
    
    public static final RegistryObject<EntityType<Shambler>> SHAMBLER =
            registerMob("shambler", 0x171717, 0xebebeb,
                    () -> EntityType.Builder.of(Shambler::new, MobCategory.MONSTER)
                            .sized(0.6F, 2.9F)
                            .clientTrackingRange(8));
    
    public static final RegistryObject<EntityType<TwistedShambler>> TWISTED_SHAMBLER =
            registerMob("twisted_shambler", 0x171717, 0xf62e2e,
                    () -> EntityType.Builder.of(TwistedShambler::new, MobCategory.MONSTER)
                            .sized(0.6F, 2.9F)
                            .clientTrackingRange(8));
    
    public static final RegistryObject<EntityType<MournerBoss>> MOURNER =
            registerMob("the_mourner", 0x262626, 0xf9f9f9,
                    () -> EntityType.Builder.of(MournerBoss::new, MobCategory.MONSTER)
                            .sized(0.7F, 2.4F)
                            .fireImmune()
                            .clientTrackingRange(10));
    
    public static final RegistryObject<EntityType<DestroyerBoss>> DESTROYER =
            registerMob("the_destroyer", 0xa9a9a9, 0xf9f9f9,
                    () -> EntityType.Builder.of(DestroyerBoss::new, MobCategory.MONSTER)
                            .sized(0.7F, 2.4F)
                            .fireImmune()
                            .clientTrackingRange(10));
    
    // -------------------------
    // PROJECTILES
    // -------------------------
    
    public static final RegistryObject<EntityType<RavagerProjectile>> RAVAGER_PROJECTILE =
            registerMisc("ravager_projectile",
                    () -> EntityType.Builder.<RavagerProjectile>of(RavagerProjectile::new, MobCategory.MISC)
                            .sized(0.3125F, 0.3125F)
                            .clientTrackingRange(4)
                            .updateInterval(10));
    
    public static final RegistryObject<EntityType<BlastemFruitProjectile>> BLASTEM_FRUIT_PROJECTILE =
            registerMisc("blastem_fruit_projectile",
                    () -> EntityType.Builder.<BlastemFruitProjectile>of(BlastemFruitProjectile::new, MobCategory.MISC)
                            .sized(0.3125F, 0.3125F)
                            .clientTrackingRange(4)
                            .updateInterval(10));
    
    public static final RegistryObject<EntityType<BlazingBlastemFruitProjectile>> BLAZING_BLASTEM_FRUIT_PROJECTILE =
            registerMisc("blazing_blastem_fruit_projectile",
                    () -> EntityType.Builder.<BlazingBlastemFruitProjectile>of(BlazingBlastemFruitProjectile::new, MobCategory.MISC)
                            .sized(0.3125F, 0.3125F)
                            .clientTrackingRange(4)
                            .updateInterval(10));
    
    // -------------------------
    // REGISTRATION HELPERS
    // -------------------------
    
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> builder) {
        ResourceLocation id = Utils.prefix(name);
        return ENTITIES.register(name, () -> builder.get().build(id.toString()));
    }
    
    private static <T extends Mob> RegistryObject<EntityType<T>> registerMob(String name, int eggPrimary, int eggSecondary, Supplier<EntityType.Builder<T>> builder) {
        RegistryObject<EntityType<T>> type = register(name, builder);
        
        RegistryObject<Item> egg = DLItems.ITEMS.register(
                name + "_spawn_egg",
                () -> new ForgeSpawnEggItem(
                        type,
                        eggPrimary,
                        eggSecondary,
                        new Item.Properties()
                )
        );
        
        DLItems.SPAWN_EGGS.add(egg);
        return type;
    }
    
    private static <T extends Entity> RegistryObject<EntityType<T>> registerMisc(String name, Supplier<EntityType.Builder<T>> builder) {
        return register(name, builder);
    }
    
    // -------------------------
    // SPAWN PLACEMENTS
    // -------------------------
    
    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(DEFILED_SLIME.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                DefiledSlime::checkDefiledSlimeSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(BOOK_WYRM.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BookWyrm::checkAnimalSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(GOLDEN_BOOK_WYRM.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                GoldenBookWyrm::checkAnimalSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(SCUTTLER.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Scuttler::checkScuttlerSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(HOST.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Zombie::checkMonsterSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(SHAMBLER.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Shambler::checkShamblerSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(TWISTED_SHAMBLER.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                TwistedShambler::checkTwistedShamblerSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(MOURNER.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
        
        event.register(DESTROYER.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND);
    }
    
    
    // -------------------------
    // ENTITY ATTRIBUTES
    // -------------------------
    
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(DEFILED_SLIME.get(), Monster.createMonsterAttributes().build());
        event.put(BOOK_WYRM.get(), BookWyrm.createAttributes().build());
        event.put(GOLDEN_BOOK_WYRM.get(), GoldenBookWyrm.createAttributes().build());
        event.put(SCUTTLER.get(), Scuttler.createAttributes().build());
        event.put(HOST.get(), Host.createAttributes().build());
        event.put(SHAMBLER.get(), Shambler.createAttributes().build());
        event.put(TWISTED_SHAMBLER.get(), TwistedShambler.createAttributes().build());
        event.put(MOURNER.get(), MournerBoss.createAttributes().build());
        event.put(DESTROYER.get(), DestroyerBoss.createAttributes().build());
    }
}
