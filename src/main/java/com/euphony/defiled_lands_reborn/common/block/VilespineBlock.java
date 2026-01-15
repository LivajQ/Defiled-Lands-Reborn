package com.euphony.defiled_lands_reborn.common.block;

import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.common.tag.DLBlockTags;
import com.euphony.defiled_lands_reborn.common.tag.DLEntityTags;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

public class VilespineBlock extends Block {
    public static final BooleanProperty TOPMOST = BooleanProperty.create("topmost");
    
    public VilespineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TOPMOST, false));
    }
    
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        
        if (entity instanceof LivingEntity livingEntity) {
            
            if (livingEntity.getType().getTags().anyMatch(tag -> tag.equals(DLEntityTags.IS_DEFILED))) {
                return;
            }
            
            if (Utils.isModLoaded("curios")) {
                LazyOptional<ICuriosItemHandler> curiosInventory =
                        CuriosApi.getCuriosInventory(livingEntity);
                
                if (curiosInventory.isPresent()) {
                    ICuriosItemHandler inv = curiosInventory.orElse(null);
                    if (inv != null && inv.isEquipped(DLItems.PHYTOPROSTASIA_AMULET.get())) {
                        return;
                    }
                }
            }
            
            if (livingEntity instanceof Player player) {
                if (player.getInventory().contains(new ItemStack(DLItems.PHYTOPROSTASIA_AMULET.get()))) {
                    return;
                }
            }
            
            livingEntity.hurt(level.damageSources().cactus(), 3);
        }
    }
    
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);
        return belowState.is(DLBlockTags.BASE_DEFILED_SURFACE)
                || belowState.is(DLBlocks.VILESPINE.get());
    }
    
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        
        if (level.getBlockState(pos.above()).isAir() && !state.getValue(TOPMOST)) {
            state = state.setValue(TOPMOST, true);
        } else if (!level.getBlockState(pos.above()).isAir() && state.getValue(TOPMOST)) {
            state = state.setValue(TOPMOST, false);
        }
        
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOPMOST);
    }
    
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(
                TOPMOST,
                context.getLevel().getBlockState(context.getClickedPos().above()).isAir()
        );
    }
}
