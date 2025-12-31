package net.thatblueguy16.wilderworld.world;

import net.minecraft.world.gen.feature.*;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.thatblueguy16.wilderworld.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> CYPRESS_PLACED_KEY = registerKey("cypress_placed");
    public static final RegistryKey<PlacedFeature> BIG_CYPRESS_PLACED_KEY = registerKey("big_cypress_placed");
    public static final RegistryKey<PlacedFeature> BIG_SPORECAP_PLACED_KEY = registerKey("big_sporecap_placed_key");
    public static final RegistryKey<PlacedFeature> CATTAILS_PLACED_KEY = registerKey("cattails_placed_key");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CYPRESS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CYPRESS_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.25f, 2),
                        ModBlocks.CYPRESS_SAPLING
                ));

        register(context, BIG_CYPRESS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CYPRESS_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.CYPRESS_SAPLING
                ));

        register(context, BIG_SPORECAP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIG_SPORECAP_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.SPORECAP
                ));

        register(context, CATTAILS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CATTAILS_KEY),
                VegetationPlacedFeatures.modifiers(
                        3));


    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(WilderWorld.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}