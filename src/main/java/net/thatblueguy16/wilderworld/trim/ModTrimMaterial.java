package net.thatblueguy16.wilderworld.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.item.ModItems;

import java.util.Map;

public class ModTrimMaterial {
    public static final RegistryKey<ArmorTrimMaterial> SAPPHIRE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(WilderWorld.MOD_ID, "sapphire"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, SAPPHIRE, Registries.ITEM.getEntry(ModItems.SAPPHIRE),
                Style.EMPTY.withColor(TextColor.parse("#00001C").getOrThrow()),0.9f);

    }



    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimMaterialKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimMaterialKey.getValue().getPath(),item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimMaterialKey.getValue())).fillStyle(style));

        registerable.register(armorTrimMaterialKey, trimMaterial);


    }
}
