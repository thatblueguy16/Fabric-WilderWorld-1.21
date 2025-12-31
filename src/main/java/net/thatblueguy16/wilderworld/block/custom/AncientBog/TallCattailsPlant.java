package net.thatblueguy16.wilderworld.block.custom.AncientBog;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;

import java.util.Collections;
import java.util.List;

public class TallCattailsPlant extends TallPlantBlock {
    public TallCattailsPlant(Settings settings) {
        super(settings);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        // Only drop if the block is the lower half
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return Collections.emptyList();
        }
        return super.getDroppedStacks(state, builder);
    }

}
