package net.thatblueguy16.wilderworld.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.item.custom.ChiselItem;
import net.thatblueguy16.wilderworld.item.custom.HammerItem;
import net.thatblueguy16.wilderworld.item.custom.LanternItem;

import java.util.List;

public class ModItems {
    public static final Item PLANT_FIBER = registerItem( "plant_fiber", new Item( new Item.Settings()));
    public static final Item SAPPHIRE = registerItem( "sapphire", new Item( new Item.Settings()));

    public static final Item MISTCALL_LANTERN = registerItem("mistcall_lantern",new LanternItem(new Item.Settings().maxDamage(32)));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item TORMENTIUM_INGOT = registerItem("tormentium_ingot", new Item(new Item.Settings()));

    public static final Item RAW_TORMENTIUM = registerItem("raw_tormentium", new Item(new Item.Settings()));
    public static final Item GLOWROOT_BULB = registerItem("glowroot_bulb", new Item(new Item.Settings().food(ModFoodComponents.GLOWROOT_BULB)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.wilderworld.glowroot_bulb.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item MASHED_GLOWROOT = registerItem("mashed_glowroot", new Item(new Item.Settings().food(ModFoodComponents.MASHED_GLOWROOT)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.wilderworld.mashed_glowroot.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item PEAT_CLUMP = registerItem("peat_clump", new Item(new Item.Settings()));
    public static final Item DRIED_PEAT_CLUMP = registerItem("dried_peat_clump", new Item(new Item.Settings().food(ModFoodComponents.DRIED_PEAT_CLUMP)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.wilderworld.dried_peat_clump.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item TORMENTIUM_SWORD = registerItem("tormentium_sword",
            new SwordItem(ModToolMaterials.TORMENTIUM,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TORMENTIUM, 3, -2.4f))));
 public static final Item TORMENTIUM_PICKAXE = registerItem("tormentium_pickaxe",
            new PickaxeItem(ModToolMaterials.TORMENTIUM,
                    new Item.Settings()
                            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TORMENTIUM,6,-3.2f))));
 public static final Item TORMENTIUM_AXE = registerItem("tormentium_axe",
            new AxeItem(ModToolMaterials.TORMENTIUM,
                    new Item.Settings()
                            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TORMENTIUM, 1.5f, -3.0f))));
 public static final Item TORMENTIUM_SHOVEL = registerItem("tormentium_shovel",
            new ShovelItem(ModToolMaterials.TORMENTIUM,
                    new Item.Settings()
                            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TORMENTIUM, 3, -2.4f))));
 public static final Item TORMENTIUM_HOE = registerItem("tormentium_hoe",
            new HoeItem(ModToolMaterials.TORMENTIUM,
                    new Item.Settings()
                            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TORMENTIUM, 0, -3.0f))));
    public static final Item TORMENTIUM_HAMMER = registerItem("tormentium_hammer",
            new PickaxeItem(ModToolMaterials.TORMENTIUM,
                    new Item.Settings()
                            .attributeModifiers(HammerItem.createAttributeModifiers(ModToolMaterials.TORMENTIUM,7,-3.4f))));
    public static final Item TORMENTIUM_HELMET = registerItem("tormentium_helmet",
            new ArmorItem(ModArmorMaterials.TORMENTIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(25))));
    public static final Item TORMENTIUM_CHESTPLATE = registerItem("tormentium_chestplate",
            new ArmorItem(ModArmorMaterials.TORMENTIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));
    public static final Item TORMENTIUM_LEGGINGS = registerItem("tormentium_leggings",
            new ArmorItem(ModArmorMaterials.TORMENTIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25))));
public static final Item TORMENTIUM_BOOTS = registerItem("tormentium_boots",
            new ArmorItem(ModArmorMaterials.TORMENTIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25))));

public static final Item SAPPHIRE_HORSE_ARMOR = registerItem("sapphire_horse_armor",
        new AnimalArmorItem(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

public static final Item WORLD_SMITHING_TEMPLATE = registerItem("world_smithing_template",
        SmithingTemplateItem.of(Identifier.of(WilderWorld.MOD_ID, "world"), FeatureFlags.VANILLA));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WilderWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WilderWorld.LOGGER.info("Registering Mod Items for " + WilderWorld.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLANT_FIBER);
            entries.add(SAPPHIRE);
        });

    }
}
