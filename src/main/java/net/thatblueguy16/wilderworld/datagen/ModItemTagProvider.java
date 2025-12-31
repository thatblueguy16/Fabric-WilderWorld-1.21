package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.tag.ItemTags;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.item.ModItems;
import net.thatblueguy16.wilderworld.util.ModTags;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.SAPPHIRE);

        getOrCreateTagBuilder(ItemTags.SWORDS);

        getOrCreateTagBuilder(ItemTags.PICKAXES);

        getOrCreateTagBuilder(ItemTags.AXES);

        getOrCreateTagBuilder(ItemTags.SHOVELS);

        getOrCreateTagBuilder(ItemTags.HOES);


        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SAPPHIRE);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES);


        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CYPRESS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CYPRESS_LOG.asItem())
                .add(ModBlocks.CYPRESS_LOG.asItem())
                .add(ModBlocks.STRIPPED_CYPRESS_WOOD.asItem())
                .add(ModBlocks.FERRUSK_WOOD.asItem())
                .add(ModBlocks.FERRUSK_LOG.asItem())
                .add(ModBlocks.DEAD_FERRUSK_LOG.asItem())
                .add(ModBlocks.DEAD_FERRUSK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DEAD_FERRUSK_LOG.asItem())
                .add(ModBlocks.STRIPPED_FERRUSK_LOG.asItem())
                .add(ModBlocks.STRIPPED_DEAD_FERRUSK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_FERRUSK_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CYPRESS_PLANKS.asItem())
                .add(ModBlocks.FERRUSK_PLANKS.asItem())
                .add(ModBlocks.DEAD_FERRUSK_PLANKS.asItem());




    }
}
