package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.block.custom.AncientBog.GlowRootCrop;
import net.thatblueguy16.wilderworld.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SAPPHIRE_BLOCK);
        addDrop(ModBlocks.CYPRESS_LOG);

        addDrop(ModBlocks.STRIPPED_CYPRESS_LOG);
        addDrop(ModBlocks.STRIPPED_CYPRESS_WOOD);

        addDrop(ModBlocks.CYPRESS_PLANKS);
        addDrop(ModBlocks.CYPRESS_SLAB, slabDrops(ModBlocks.CYPRESS_SLAB));

        addDrop(ModBlocks.CYPRESS_STAIR);
        addDrop(ModBlocks.CYPRESS_WOOD);

        addDrop(ModBlocks.CYPRESS_BUTTON);
        addDrop(ModBlocks.CYPRESS_PRESSURE_PLATE);

        addDrop(ModBlocks.CYPRESS_FENCE);
        addDrop(ModBlocks.CYPRESS_FENCE_GATE);

        addDrop(ModBlocks.CYPRESS_DOOR, doorDrops(ModBlocks.CYPRESS_DOOR));
        addDrop(ModBlocks.CYPRESS_TRAPDOOR);

        addDrop(ModBlocks.DRIED_PEAT_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.CYPRESS_SAPLING);
        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.GLOWROOT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GlowRootCrop.AGE, GlowRootCrop.MAX_AGE));
        this.addDrop(ModBlocks.GLOWROOT_CROP, this.cropDrops(ModBlocks.GLOWROOT_CROP, ModItems.GLOWROOT, ModItems.GLOWROOT, builder2));

        addDrop(ModBlocks.SPORECAP);
        addDrop(ModBlocks.PEAT_BLOCK);

        addDrop(ModBlocks.SPORECAP_BLOCK, mushroomBlockDrops(ModBlocks.SPORECAP_BLOCK, ModBlocks.SPORECAP));
        addDrop(ModBlocks.FERRUSK_PLANKS);

        addDrop(ModBlocks.FERRUSK_SLAB, slabDrops(ModBlocks.FERRUSK_SLAB));
        addDrop(ModBlocks.FERRUSK_STAIR);

        addDrop(ModBlocks.FERRUSK_WOOD);
        addDrop(ModBlocks.FERRUSK_BUTTON);

        addDrop(ModBlocks.FERRUSK_PRESSURE_PLATE);
        addDrop(ModBlocks.FERRUSK_FENCE);

        addDrop(ModBlocks.FERRUSK_FENCE_GATE);
        addDrop(ModBlocks.FERRUSK_DOOR, doorDrops(ModBlocks.FERRUSK_DOOR));

        addDrop(ModBlocks.FERRUSK_TRAPDOOR);
        addDrop(ModBlocks.DEAD_FERRUSK_PLANKS);

        addDrop(ModBlocks.DEAD_FERRUSK_SLAB, slabDrops(ModBlocks.DEAD_FERRUSK_SLAB));
        addDrop(ModBlocks.FERRUSK_STAIR);

        addDrop(ModBlocks.DEAD_FERRUSK_WOOD);
        addDrop(ModBlocks.DEAD_FERRUSK_BUTTON);

        addDrop(ModBlocks.DEAD_FERRUSK_PRESSURE_PLATE);
        addDrop(ModBlocks.DEAD_FERRUSK_FENCE);

        addDrop(ModBlocks.DEAD_FERRUSK_FENCE_GATE);
        addDrop(ModBlocks.DEAD_FERRUSK_DOOR, doorDrops(ModBlocks.DEAD_FERRUSK_DOOR));

        addDrop(ModBlocks.DEAD_FERRUSK_TRAPDOOR);
        addDrop(ModBlocks.DEAD_FERRUSK_LOG);

        addDrop(ModBlocks.FERRUSK_LOG);
        addDrop(ModBlocks.MILKWEED);

        addDrop(ModBlocks.MILKWEED_TEAL);
        addDrop(ModBlocks.MILKWEED_LAVENDER);

        addDrop(ModBlocks.MILKWEED_YELLOW);
        addDrop(ModBlocks.MILKWEED_BLUE);

        addDrop(ModBlocks.BOG_MAW);
        addDrop(ModBlocks.BOG_BULB);

        addDrop(ModBlocks.CATTAILS);
        addDrop(ModBlocks.TALL_CATTAILS);

        addDrop(ModBlocks.WILD_GLOWROOT, dropslikeFern(ModBlocks.WILD_GLOWROOT, ModItems.GLOWROOT, 1, 1));
        addDrop(ModBlocks.CYPRESS_LEAVES, leavesDrops(ModBlocks.CYPRESS_LEAVES, ModBlocks.CYPRESS_SAPLING, 0.625f));



    }


    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
    public LootTable.Builder dropslikeFern(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
