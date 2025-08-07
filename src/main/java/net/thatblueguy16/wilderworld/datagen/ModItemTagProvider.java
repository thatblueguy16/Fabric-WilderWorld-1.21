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

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.TORMENTIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.TORMENTIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.TORMENTIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.TORMENTIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.TORMENTIUM_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TORMENTIUM_HELMET)
                .add(ModItems.TORMENTIUM_CHESTPLATE)
                .add(ModItems.TORMENTIUM_LEGGINGS)
                .add(ModItems.TORMENTIUM_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SAPPHIRE);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.WORLD_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CYPRESS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CYPRESS_LOG.asItem())
                .add(ModBlocks.CYPRESS_LOG.asItem())
                .add(ModBlocks.STRIPPED_CYPRESS_WOOD.asItem())
                .add(ModBlocks.FERRUSK_WOOD.asItem())
                .add(ModBlocks.FERRUSK_LOG.asItem())
                .add(ModBlocks.DEAD_FERRUSK_LOG.asItem())
                .add(ModBlocks.DEAD_FERRUSK_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CYPRESS_PLANKS.asItem())
                .add(ModBlocks.FERRUSK_PLANKS.asItem())
                .add(ModBlocks.DEAD_FERRUSK_PLANKS.asItem());


    }
}
