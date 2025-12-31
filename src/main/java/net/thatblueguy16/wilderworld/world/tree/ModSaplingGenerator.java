package net.thatblueguy16.wilderworld.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

public abstract class ModSaplingGenerator {
    public static final SaplingGenerator CYPRESS = new SaplingGenerator("cypress",
            0.1F,
            Optional.of(ModConfiguredFeatures.BIG_CYPRESS_KEY),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.CYPRESS_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
    );

    public static final  SaplingGenerator SPORECAP = new SaplingGenerator("sporecap",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.BIG_SPORECAP_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
            );




    @Nullable
    protected abstract RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees);

    @Nullable
    protected abstract RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random);
}
