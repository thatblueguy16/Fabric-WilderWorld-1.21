package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE,
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, .25f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, .25f, 100, "sapphire");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE,RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STRING, 2)
                .input(ModItems.PLANT_FIBER)
                .criterion("has_plant_fiber", conditionsFromItem(ModItems.PLANT_FIBER))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "string_from_plant_fiber"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_PLANKS, 4)
                .input(ModBlocks.CYPRESS_LOG)
                .criterion("has_cypress_log", conditionsFromItem(ModBlocks.CYPRESS_LOG))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_planks_from_cypress_log"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_PLANKS, 4)
                .input(ModBlocks.CYPRESS_WOOD)
                .criterion("has_cypress_wood", conditionsFromItem(ModBlocks.CYPRESS_WOOD))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_planks_from_cypress_wood"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CRAFTING_TABLE, 1)
                .pattern("   ")
                .pattern("xx ")
                .pattern("xx ")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "crafting_table_from_cypress_planks"));

    }
}
