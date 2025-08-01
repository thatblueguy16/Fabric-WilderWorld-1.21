package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.util.ModTags;

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

                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_TORMENTIUM_ORE)

                .add(ModBlocks.TORMENTIUM_ORE)
                .add(ModBlocks.MAGIC_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_TORMENTIUM_ORE)
                .add(ModBlocks.TORMENTIUM_ORE)

                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CYPRESS_LOG)
                .add(ModBlocks.CYPRESS_WOOD)

                .add(ModBlocks.CYPRESS_FENCE_GATE)
                .add(ModBlocks.CYPRESS_FENCE)

                .add(ModBlocks.CYPRESS_DOOR)
                .add(ModBlocks.CYPRESS_TRAPDOOR)

                .add(ModBlocks.CYPRESS_STAIR)
                .add(ModBlocks.CYPRESS_SLAB)

                .add(ModBlocks.CYPRESS_PLANKS)
                .add(ModBlocks.FERRUSK_LOG)

                .add(ModBlocks.FERRUSK_WOOD)
                .add(ModBlocks.DEAD_FERRUSK_LOG)

                .add(ModBlocks.DEAD_FERRUSK_WOOD);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.CYPRESS_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CYPRESS_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS);

        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.CYPRESS_LEAVES);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CYPRESS_LOG)
                .add(ModBlocks.STRIPPED_CYPRESS_LOG)
                .add(ModBlocks.STRIPPED_CYPRESS_WOOD)
                .add(ModBlocks.CYPRESS_WOOD)
                .add(ModBlocks.FERRUSK_LOG)
                .add(ModBlocks.FERRUSK_WOOD)
                .add(ModBlocks.DEAD_FERRUSK_LOG)
                .add(ModBlocks.DEAD_FERRUSK_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.CYPRESS_PLANKS);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_TORMENTIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);



    }
}
