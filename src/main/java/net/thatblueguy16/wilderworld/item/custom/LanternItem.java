package net.thatblueguy16.wilderworld.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class LanternItem extends Item {

    public LanternItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        // Check cooldown
        if (player.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(stack);
        }

        if (!world.isClient) {
            // Radius and mob selection
            double radius = 16.0;
            List<LivingEntity> entities = world.getEntitiesByClass(
                    LivingEntity.class,
                    player.getBoundingBox().expand(radius),
                    e -> e != player && !(e instanceof PlayerEntity)
            );

            for (LivingEntity mob : entities) {
                mob.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 40, 0, false, false));
            }

        }

        player.getItemCooldownManager().set(this, 100);


        return TypedActionResult.success(stack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.wilderworld.mistcall_lantern.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.wilderworld.mistcall_lantern"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
