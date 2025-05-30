package net.thatblueguy16.wilderworld.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;

import static net.minecraft.block.Blocks.register;

public class ModBlocks {
    public static final Block CYPRESS_WOOD = registerBlock("cypress_wood",
            new Block(AbstractPlantStemBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block CYPRESS_PLANKS = registerBlock("cypress_planks",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(WilderWorld.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(WilderWorld.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        WilderWorld.LOGGER.info("Registering Mod Blocks for" + WilderWorld.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CYPRESS_WOOD);
            entries.add(ModBlocks.CYPRESS_PLANKS);
        });
    }
}
