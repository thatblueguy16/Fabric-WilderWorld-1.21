package net.thatblueguy16.wilderworld.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.thatblueguy16.wilderworld.item.ModItems;

public class GlowRootCrop extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = IntProperty.of("age", 0, 3);

    public GlowRootCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GLOWROOT_BULB;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
