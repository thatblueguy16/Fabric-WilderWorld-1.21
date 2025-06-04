package net.thatblueguy16.wilderworld.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator CYPRESS = new SaplingGenerator(WilderWorld.MOD_ID + ":cypress",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CYPRESS_KEY), Optional.empty());

}
