package net.thatblueguy16.wilderworld.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.custom.GlowRootCrop;
import net.thatblueguy16.wilderworld.block.custom.LumenPodBlock;
import net.thatblueguy16.wilderworld.block.custom.MagicBlock;
import net.thatblueguy16.wilderworld.block.custom.TallCattailsPlant;
import net.thatblueguy16.wilderworld.world.tree.ModSaplingGenerator;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {


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
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block CYPRESS_WOOD = registerBlock("cypress_wood",
            new PillarBlock(AbstractPlantStemBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CYPRESS_LOG = registerBlock("stripped_cypress_log",
            new PillarBlock(AbstractPlantStemBlock.Settings.copy(STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CYPRESS_WOOD = registerBlock("stripped_cypress_wood",
            new PillarBlock(AbstractPlantStemBlock.Settings.copy(STRIPPED_OAK_WOOD)));

    public static final Block CYPRESS_PLANKS = registerBlock("cypress_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CYPRESS_LEAVES = registerBlock("cypress_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)
                    .nonOpaque()
                    .ticksRandomly()
                    .strength(0.2f)
                    .mapColor(MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES)));

    public static final Block CYPRESS_SAPLING = registerBlock("cypress_sapling",
        new SaplingBlock(ModSaplingGenerator.CYPRESS, AbstractBlock.Settings.copy(OAK_SAPLING)));

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

    public static final PlantBlock BROMELIAD = (PlantBlock) registerBlock("bromeliad",
            new FlowerBlock(StatusEffects.LUCK, 20, AbstractBlock.Settings.copy(POPPY)
                    .nonOpaque()));

    public static final Block GLOWROOT = registerBlockWithoutBlockItem("glowroot",
            new GlowRootCrop(AbstractBlock.Settings.copy(POTATOES)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.CROP)));

    public static final Block SPORECAP = registerBlock("sporecap",
            new SaplingBlock(ModSaplingGenerator.SPORECAP,AbstractBlock.Settings.copy(BROWN_MUSHROOM)));


    public static final Block PEAT_BLOCK = registerBlock("peat_block",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.MOSS_BLOCK)
                    .burnable()));

    public static final Block SPORECAP_BLOCK = registerBlock("sporecap_block",
            new MushroomBlock(AbstractBlock.Settings.copy(BROWN_MUSHROOM_BLOCK)
                    .sounds(BlockSoundGroup.FUNGUS)));

    public static final Block FERRUSK_LOG = registerBlock("ferrusk_log",
            new PillarBlock(AbstractBlock.Settings.copy(OAK_LOG)));

    public static final Block DEAD_FERRUSK_LOG = registerBlock("dead_ferrusk_log",
            new PillarBlock(AbstractBlock.Settings.copy(OAK_LOG)));

    public static final Block FERRUSK_WOOD = registerBlock("ferrusk_wood",
            new PillarBlock(AbstractBlock.Settings.copy(OAK_WOOD)));

    public static final Block DEAD_FERRUSK_WOOD = registerBlock("dead_ferrusk_wood",
            new PillarBlock(AbstractBlock.Settings.copy(OAK_WOOD)));

    public static final Block FERRUSK_SAPLING = registerBlock("ferrusk_sapling",
            new SaplingBlock(ModSaplingGenerator.FERRUSK, AbstractBlock.Settings.copy(OAK_SAPLING)));

    public static final Block DEAD_FERRUSK_SAPLING = registerBlock("dead_ferrusk_sapling",
        new SaplingBlock(ModSaplingGenerator.DEAD_FERRUSK, AbstractBlock.Settings.copy(OAK_SAPLING)));

    public static final Block FERRUSK_LEAVES = registerBlock("ferrusk_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)
                    .nonOpaque()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES)
                    .burnable()));

    public static final Block DEAD_FERRUSK_LEAVES = registerBlock("dead_ferrusk_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)
                    .nonOpaque()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES)
                    .burnable()));

    public static final Block FERRUSK_PLANKS = registerBlock("ferrusk_planks",
            new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));

    public static final Block DEAD_FERRUSK_PLANKS = registerBlock("dead_ferrusk_planks",
            new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));

    public static final Block FERRUSK_STAIR = registerBlock("ferrusk_stair",
            new StairsBlock(ModBlocks.FERRUSK_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block FERRUSK_SLAB = registerBlock("ferrusk_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block FERRUSK_BUTTON = registerBlock("ferrusk_button",
            new ButtonBlock(BlockSetType.DARK_OAK, 40, AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .noCollision()));
    public static final Block FERRUSK_PRESSURE_PLATE = registerBlock("ferrusk_pressure_plate",
            new PressurePlateBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(1.5f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block FERRUSK_FENCE = registerBlock("ferrusk_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block FERRUSK_FENCE_GATE = registerBlock("ferrusk_fence_gate",
            new FenceGateBlock(WoodType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block FERRUSK_DOOR = registerBlock("ferrusk_door",
            new DoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque()));

    public static final Block FERRUSK_TRAPDOOR = registerBlock("ferrusk_trapdoor",
            new TrapdoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque()));

    public static final Block DEAD_FERRUSK_STAIR = registerBlock("dead_ferrusk_stair",
            new StairsBlock(ModBlocks.DEAD_FERRUSK_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block DEAD_FERRUSK_SLAB = registerBlock("dead_ferrusk_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block DEAD_FERRUSK_BUTTON = registerBlock("dead_ferrusk_button",
            new ButtonBlock(BlockSetType.DARK_OAK, 40, AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .noCollision()));
    public static final Block DEAD_FERRUSK_PRESSURE_PLATE = registerBlock("dead_ferrusk_pressure_plate",
            new PressurePlateBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(1.5f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block DEAD_FERRUSK_FENCE = registerBlock("dead_ferrusk_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block DEAD_FERRUSK_FENCE_GATE = registerBlock("dead_ferrusk_fence_gate",
            new FenceGateBlock(WoodType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block DEAD_FERRUSK_DOOR = registerBlock("dead_ferrusk_door",
            new DoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque()));

    public static final Block DEAD_FERRUSK_TRAPDOOR = registerBlock("dead_ferrusk_trapdoor",
            new TrapdoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque()));

    public static final Block CATTAILS = registerBlock("cattails",
            new ShortPlantBlock(AbstractBlock.Settings.copy(SHORT_GRASS)));

public static final Block TALL_CATTAILS = registerBlock("tall_cattails",
            new TallCattailsPlant(AbstractBlock.Settings.copy(SUNFLOWER)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(WilderWorld.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
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
