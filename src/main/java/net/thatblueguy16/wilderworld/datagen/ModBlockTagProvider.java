package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.thatblueguy16.wilderworld.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CYPRESS_LOG)
                .add(ModBlocks.CYPRESS_WOOD)
                .add(ModBlocks.CYPRESS_PLANKS);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.CYPRESS_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CYPRESS_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS);

        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.CYPRESS_LEAVES);


    }
}
