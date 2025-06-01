package net.thatblueguy16.wilderworld.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public  static final FoodComponent GLOWROOT_BULB = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,100),.1f ).build();

    public static final FoodComponent MASHED_GLOWROOT = new FoodComponent.Builder().nutrition(6).saturationModifier(4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600),1f).build();

    public static final FoodComponent DRIED_PEAT_CLUMP = new FoodComponent.Builder().nutrition(1).saturationModifier(.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 50),.1f).build();



}
