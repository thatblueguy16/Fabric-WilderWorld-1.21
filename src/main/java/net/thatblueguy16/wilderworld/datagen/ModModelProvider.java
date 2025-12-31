package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.block.custom.AncientBog.GlowRootCrop;
import net.thatblueguy16.wilderworld.block.custom.LumenPodBlock;
import net.thatblueguy16.wilderworld.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYPRESS_WOOD);

        BlockStateModelGenerator.BlockTexturePool cypressPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CYPRESS_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYPRESS_LOG);

        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CYPRESS_LOG).wood(ModBlocks.STRIPPED_CYPRESS_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CYPRESS_LOG).log(ModBlocks.STRIPPED_CYPRESS_LOG);

        blockStateModelGenerator.registerSingleton(ModBlocks.CYPRESS_LEAVES, TexturedModel.LEAVES);

        cypressPlanksPool.stairs(ModBlocks.CYPRESS_STAIR);
        cypressPlanksPool.slab(ModBlocks.CYPRESS_SLAB);

        cypressPlanksPool.button(ModBlocks.CYPRESS_BUTTON);
        cypressPlanksPool.pressurePlate(ModBlocks.CYPRESS_PRESSURE_PLATE);

        cypressPlanksPool.fence(ModBlocks.CYPRESS_FENCE);
        cypressPlanksPool.fenceGate(ModBlocks.CYPRESS_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.CYPRESS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CYPRESS_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIED_PEAT_BLOCK);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SPORECAP, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PEAT_BLOCK);
        blockStateModelGenerator.registerCrop(ModBlocks.GLOWROOT_CROP, GlowRootCrop.AGE, 0,1,2,3);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPORECAP_BLOCK);
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.LUMENPOD_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.LUMENPOD_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.LUMENPOD_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LumenPodBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        blockStateModelGenerator.registerLog(ModBlocks.FERRUSK_LOG).log(ModBlocks.FERRUSK_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.DEAD_FERRUSK_LOG).log(ModBlocks.DEAD_FERRUSK_LOG);

        blockStateModelGenerator.registerLog(ModBlocks.FERRUSK_WOOD).wood(ModBlocks.FERRUSK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.DEAD_FERRUSK_WOOD).wood(ModBlocks.DEAD_FERRUSK_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FERRUSK_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEAD_FERRUSK_LEAVES);

        BlockStateModelGenerator.BlockTexturePool deadferruskPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEAD_FERRUSK_PLANKS);
        BlockStateModelGenerator.BlockTexturePool ferruskPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FERRUSK_PLANKS);

        ferruskPlanksPool.stairs(ModBlocks.FERRUSK_STAIR);
        ferruskPlanksPool.slab(ModBlocks.FERRUSK_SLAB);

        ferruskPlanksPool.button(ModBlocks.FERRUSK_BUTTON);
        ferruskPlanksPool.pressurePlate(ModBlocks.FERRUSK_PRESSURE_PLATE);

        ferruskPlanksPool.fence(ModBlocks.FERRUSK_FENCE );
        ferruskPlanksPool.fenceGate(ModBlocks.FERRUSK_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.FERRUSK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.FERRUSK_TRAPDOOR);

        deadferruskPlanksPool.stairs(ModBlocks.DEAD_FERRUSK_STAIR);
        deadferruskPlanksPool.slab(ModBlocks.DEAD_FERRUSK_SLAB);

        deadferruskPlanksPool.button(ModBlocks.DEAD_FERRUSK_BUTTON);
        deadferruskPlanksPool.pressurePlate(ModBlocks.DEAD_FERRUSK_PRESSURE_PLATE);

        deadferruskPlanksPool.fence(ModBlocks.DEAD_FERRUSK_FENCE );
        deadferruskPlanksPool.fenceGate(ModBlocks.DEAD_FERRUSK_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.DEAD_FERRUSK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DEAD_FERRUSK_TRAPDOOR);

        blockStateModelGenerator.registerTintableCross(ModBlocks.CATTAILS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.TALL_CATTAILS, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.MILKWEED, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.MILKWEED_TEAL, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.MILKWEED_LAVENDER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.MILKWEED_YELLOW, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.MILKWEED_BLUE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_FERRUSK_LOG).wood(ModBlocks.STRIPPED_FERRUSK_WOOD);

        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DEAD_FERRUSK_LOG).log(ModBlocks.STRIPPED_DEAD_FERRUSK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_FERRUSK_LOG).log(ModBlocks.STRIPPED_FERRUSK_LOG);

        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DEAD_FERRUSK_LOG).log(ModBlocks.STRIPPED_DEAD_FERRUSK_LOG);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BOG_MAW, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerDoubleBlock(ModBlocks.BOG_BULB, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WILD_GLOWROOT, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.CYPRESS_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLANT_FIBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);

        itemModelGenerator.register(ModItems.MISTCALL_LANTERN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_PEAT_CLUMP, Models.GENERATED);

        itemModelGenerator.register(ModItems.LAVENDER_DYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEAT_CLUMP, Models.GENERATED);

        itemModelGenerator.register(ModItems.SCUTTLE_TAIL_SPAWN_EGG,
               new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty() ));
        itemModelGenerator.register(ModItems.BOG_MAW_SPAWN_EGG,
               new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty() ));





    }
}
