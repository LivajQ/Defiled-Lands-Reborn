package com.euphony.defiled_lands_reborn.integration.curios;

import com.euphony.defiled_lands_reborn.common.init.DLItems;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CuriosCompat {
    
    @SubscribeEvent
    public static void registerCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        ItemStack stack = event.getObject();

        if (stack.is(DLItems.SCARLITE_RING.get())) {
            event.addCapability(
                    CuriosCapability.ID_ITEM,
                    new ICapabilityProvider() {
                        
                        private final LazyOptional<ICurio> curio = LazyOptional.of(() -> new ICurio() {
                            @Override
                            public ItemStack getStack() {
                                return stack;
                            }
                            
                            @Override
                            public void curioTick(SlotContext slotContext) {
                                if (slotContext.entity() instanceof Player player) {
                                    if (player.tickCount % 200 == 0) {
                                        player.heal(1);
                                    }
                                }
                            }
                        });
                        
                        @Override
                        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                            return cap == CuriosCapability.ITEM ? curio.cast() : LazyOptional.empty();
                        }
                    }
            );
        }

        if (stack.is(DLItems.PHYTOPROSTASIA_AMULET.get())) {
            event.addCapability(
                    CuriosCapability.ID_ITEM,
                    new ICapabilityProvider() {
                        
                        private final LazyOptional<ICurio> curio = LazyOptional.of(() -> (ICurio) () -> stack);
                        
                        @Override
                        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                            return cap == CuriosCapability.ITEM ? curio.cast() : LazyOptional.empty();
                        }
                    }
            );
        }
    }
}
