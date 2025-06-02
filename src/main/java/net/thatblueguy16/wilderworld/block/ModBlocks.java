package net.thatblueguy16.wilderworld.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.custom.LumenPodBlock;
import net.thatblueguy16.wilderworld.block.custom.MagicBlock;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;
import static net.minecraft.block.Blocks.register;

public class ModBlocks {
    public static final Block CYPRESS_WOOD = registerBlock("cypress_wood",
            new PillarBlock(AbstractPlantStemBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block CYPRESS_PLANKS = registerBlock("cypress_planks",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6), AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(4f)
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block" ,
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()));

    public static final Block CYPRESS_LOG = registerBlock("cypress_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block CYPRESS_LEAVES = registerBlock("cypress_leaves",
            new LeavesBlock(AbstractBlock.Settings.create()
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block CYPRESS_STAIR = registerBlock("cypress_stair",
            new StairsBlock(ModBlocks.CYPRESS_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block CYPRESS_SLAB = registerBlock("cypress_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block CYPRESS_BUTTON = registerBlock("cypress_button",
            new ButtonBlock(BlockSetType.DARK_OAK, 40, AbstractBlock.Settings.create()
                            .strength(1f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
                            .noCollision()));
    public static final Block CYPRESS_PRESSURE_PLATE = registerBlock("cypress_pressure_plate",
            new PressurePlateBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                            .strength(1.5f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()));

    public static final Block CYPRESS_FENCE = registerBlock("cypress_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block CYPRESS_FENCE_GATE = registerBlock("cypress_fence_gate",
            new FenceGateBlock(WoodType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block CYPRESS_DOOR = registerBlock("cypress_door",
            new DoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque()));

    public static final Block CYPRESS_TRAPDOOR = registerBlock("cypress_trapdoor",
            new TrapdoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque()));

    public static final Block TORMENTIUM_BLOCK = registerBlock("tormentium_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .requiresTool()));

public static final Block RAW_TORMENTIUM_BLOCK = registerBlock("raw_tormentium_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .requiresTool()));

    public static final Block TORMENTIUM_ORE = registerBlock("tormentium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_TORMENTIUM_ORE = registerBlock("deepslate_tormentium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6), AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(4f)
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block DRIED_PEAT_BLOCK = registerBlock("dried_peat_block",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.MOSS_BLOCK)
                    .burnable()));

    public static final Block LUMENPOD_BLOCK = registerBlock("lumenpod_block",
            new LumenPodBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.FROGLIGHT)
                    .luminance(state ->state.get(LumenPodBlock.CLICKED) ? 15 :0 )));

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
