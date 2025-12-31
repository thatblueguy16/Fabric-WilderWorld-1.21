package net.thatblueguy16.wilderworld.world;

import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
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

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CYPRESS_KEY = registerKey("cypress_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_CYPRESS_KEY = registerKey("big_cypress_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_SPORECAP_KEY = registerKey("big_sporecap_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CATTAILS_KEY = registerKey("cattails_key");

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


        register(context, BIG_SPORECAP_KEY, Feature.HUGE_BROWN_MUSHROOM,
                new HugeMushroomFeatureConfig(
                        BlockStateProvider.of(ModBlocks.SPORECAP_BLOCK),
                        BlockStateProvider.of(Blocks.MUSHROOM_STEM),
                        3)
                );

        register(context, CATTAILS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        3,
                        3,
                        3,
                       PlacedFeatures.createEntry(
                               Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(
                                       BlockStateProvider.of(
                                               ModBlocks.TALL_CATTAILS.getDefaultState()
                                                       .with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER))))));



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(WilderWorld.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}