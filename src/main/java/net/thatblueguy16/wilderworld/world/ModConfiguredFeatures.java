package net.thatblueguy16.wilderworld.world;

import com.google.common.base.Optional;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.collection.ListDeque;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.root.MangroveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacer;
import net.minecraft.world.gen.root.RootPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.*;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.thatblueguy16.wilderworld.util.ModTags;

import java.util.List;
import java.util.Set;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CYPRESS_KEY = registerKey("cypress_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYPRESS_KEY2 = registerKey("cypress_key2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_CYPRESS_KEY = registerKey("big_cypress_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_SPORECAP_KEY = registerKey("big_sporecap_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_FERRUSK_KEY = registerKey("dead_ferrusk_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FERRUSK_KEY = registerKey("ferrusk_key");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, CYPRESS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CYPRESS_LOG),
                new StraightTrunkPlacer(
                        12,
                        6,
                        4
                ),
                BlockStateProvider.of(ModBlocks.CYPRESS_LEAVES),
                new SpruceFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(0),
                        ConstantIntProvider.create(4)),
                new TwoLayersFeatureSize(
                        5,
                        0,
                        2)
                ).decorators(List.of(new LeavesVineTreeDecorator(1)))
                .decorators(List.of(new TrunkVineTreeDecorator())
                ).build());

        register(context, BIG_CYPRESS_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.CYPRESS_LOG),
                        new GiantTrunkPlacer(
                                16,
                                8,
                                6),
                        BlockStateProvider.of(ModBlocks.CYPRESS_LEAVES),
                        new SpruceFoliagePlacer(
                                ConstantIntProvider.create(2),
                                ConstantIntProvider.create(1),
                                ConstantIntProvider.create(8)),
                        new TwoLayersFeatureSize(
                                4,
                                0,
                                5)
                ).decorators(List.of(new LeavesVineTreeDecorator(1)))
                        .decorators(List.of(new TrunkVineTreeDecorator())
                        ).build());


        register(context, CYPRESS_KEY2, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.CYPRESS_LOG),
                        new LargeOakTrunkPlacer(
                                8,
                                4,
                                3),
                        BlockStateProvider.of(ModBlocks.CYPRESS_LEAVES),
                        new DarkOakFoliagePlacer(
                                ConstantIntProvider.create(1),
                                ConstantIntProvider.create(2)),
                        new TwoLayersFeatureSize(
                                3,
                                0,
                                2)
                ).decorators(List.of(new LeavesVineTreeDecorator(1)))
                        .decorators(List.of(new TrunkVineTreeDecorator())
                        ).build());

        register(context, BIG_SPORECAP_KEY, Feature.HUGE_BROWN_MUSHROOM,
                new HugeMushroomFeatureConfig(
                        BlockStateProvider.of(ModBlocks.SPORECAP_BLOCK),
                        BlockStateProvider.of(Blocks.MUSHROOM_STEM),
                        3)
                );

        register(context, DEAD_FERRUSK_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.DEAD_FERRUSK_LOG),
                        new LargeOakTrunkPlacer(
                                7,
                                2,
                                1),
                        BlockStateProvider.of(Blocks.AIR),
                        new DarkOakFoliagePlacer(
                                ConstantIntProvider.create(1),
                                ConstantIntProvider.create(2)),
                        new TwoLayersFeatureSize(
                                3,
                                0,
                                2)
                ).build());

        register(context, FERRUSK_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.FERRUSK_LOG),
                        new LargeOakTrunkPlacer(
                                7,
                                2,
                                1),
                        BlockStateProvider.of(Blocks.MANGROVE_LEAVES),
                        new JungleFoliagePlacer(
                                ConstantIntProvider.create(1),
                                ConstantIntProvider.create(2),
                                2),
                        new TwoLayersFeatureSize(
                                3,
                                0,
                                2)
                ).build());



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(WilderWorld.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}