package net.thatblueguy16.wilderworld.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(WilderWorld.MOD_ID));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS =createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(WilderWorld.MOD_ID));
        }
    }
}
