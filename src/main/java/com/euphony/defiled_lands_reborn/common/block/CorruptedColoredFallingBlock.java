package com.euphony.defiled_lands_reborn.common.block;

import net.minecraft.world.level.block.FallingBlock;

public class CorruptedColoredFallingBlock extends FallingBlock {
    private final int dustColor;
    
    public CorruptedColoredFallingBlock(int dustColor, Properties properties) {
        super(properties);
        this.dustColor = dustColor;
    }
    
    public int getDustColor() {
        return dustColor;
    }
}
