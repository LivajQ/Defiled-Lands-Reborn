package com.euphony.defiled_lands_reborn.event;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.corruption.DLCorruptionReloadListener;
import com.euphony.defiled_lands_reborn.common.entity.projectile.BlastemFruitProjectile;
import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import com.euphony.defiled_lands_reborn.common.init.DLEffects;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ExplosionEvent;

import java.util.List;

import static com.euphony.defiled_lands_reborn.utils.ItemUtils.addTooltip;

@Mod.EventBusSubscriber(modid = DefiledLandsReborn.MOD_ID)
public class DLEvents {
    
    @SubscribeEvent
    public static void registerTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> components = event.getToolTip();
        
        if (stack.is(DLItems.PHYTOPROSTASIA_AMULET.get())) {
            addTooltip(components, "item.defiled_lands_reborn.phytoprostasia_amulet.tooltip");
        } else if (stack.is(DLItems.RAVAGING_PELLET.get())) {
            addTooltip(components, "item.defiled_lands_reborn.ravaging_pellet.tooltip");
        } else if (stack.is(DLItems.IDOL_SORROW.get())) {
            addTooltip(components, "item.defiled_lands_reborn.idol_sorrow.tooltip");
        } else if (stack.is(DLItems.SPIKED_PELLET.get())) {
            addTooltip(components, "item.defiled_lands_reborn.spiked_pellet.tooltip");
        } else if (stack.is(DLItems.CALLING_STONE.get())) {
            addTooltip(components, "item.defiled_lands_reborn.calling_stone.tooltip");
        } else if (stack.is(DLItems.RAVAGING_AXE.get())) {
            addTooltip(components, "item.defiled_lands_reborn.ravaging_axe.tooltip");
        } else if (stack.is(DLItems.RAVAGING_PICKAXE.get())) {
            addTooltip(components, "item.defiled_lands_reborn.ravaging_pickaxe.tooltip");
        } else if (stack.is(DLItems.RAVAGING_SHOVEL.get())) {
            addTooltip(components, "item.defiled_lands_reborn.ravaging_shovel.tooltip");
        } else if (stack.is(DLBlocks.HEPHAESTITE_BLOCK.get().asItem())) {
            addTooltip(components, "block.defiled_lands_reborn.hephaestite_block.tooltip");
        } else if (stack.is(DLBlocks.HEPHAESTITE_ORE.get().asItem())) {
            addTooltip(components, "block.defiled_lands_reborn.hephaestite_ore.tooltip");
        }
        
    }
    
    @SubscribeEvent
    public static void onFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();
        
        if (item == DLItems.HEPHAESTITE_SHARD.get()) {
            event.setBurnTime(200);
        } else if (item == DLBlocks.HEPHAESTITE_BLOCK.get().asItem()) {
            event.setBurnTime(2000);
        }
    }
    
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        MobEffectInstance effect = entity.getEffect(DLEffects.VULNERABILITY.get());
        
        if (effect != null) {
            float amplifier = effect.getAmplifier() + 1;
            float multiplier = 1 + (0.2F * amplifier);
            event.setAmount(event.getAmount() * multiplier);
        }
    }
    
    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Detonate event) {
        if (event.getExplosion().getDirectSourceEntity() instanceof BlastemFruitProjectile) {
            event.getAffectedEntities().removeIf(ent -> ent instanceof ItemEntity);
        }
    }
    
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!event.getLevel().isClientSide() && event.getPlayer() != null) {
            ItemStack item = event.getPlayer().getMainHandItem();
            
            if (item.is(DLItemTags.RAVAGING_TOOLS)) {
                BlockState state = event.getState();
                event.setCanceled(true);
                state.getBlock().destroy(event.getLevel(), event.getPos(), state);
                event.getLevel().destroyBlock(event.getPos(), false);
            }
        }
    }
    
    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(new DLCorruptionReloadListener());
    }
}
