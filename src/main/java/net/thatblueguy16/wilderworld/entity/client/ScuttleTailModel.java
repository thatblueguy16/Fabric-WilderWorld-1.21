package net.thatblueguy16.wilderworld.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailEntity;

public class ScuttleTailModel <T extends ScuttleTailEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SCUTTLETAIL = new EntityModelLayer(Identifier.of(WilderWorld.MOD_ID, "scuttletail"), "main");

    private final ModelPart hip;
    private final ModelPart head;

    public ScuttleTailModel(ModelPart root) {
        this.hip = root.getChild("hip");
        this.head = this.hip.getChild("head");

    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hip = modelPartData.addChild("hip", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 22.0F, 0.0F));

        ModelPartData head = hip.addChild("head", ModelPartBuilder.create().uv(31, 6).cuboid(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 13).cuboid(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(-2, 33).cuboid(1.5F, -1.25F, -5.5F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(8, 33).cuboid(-4.5F, -1.25F, -5.5F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.75F, -4.0F));

        ModelPartData body = hip.addChild("body", ModelPartBuilder.create().uv(0, 23).cuboid(-2.5F, -2.0F, -3.5F, 5.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -0.5F));

        ModelPartData tail = hip.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -0.5F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.25F, 3.5F));

        ModelPartData legs = hip.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.75F, 0.0F));

        ModelPartData leg1 = legs.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(-2.75F, 0.75F, -2.0F));

        ModelPartData cube_r1 = leg1.addChild("cube_r1", ModelPartBuilder.create().uv(25, 23).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.1745F));

        ModelPartData leg2 = legs.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(-2.75F, 0.75F, 2.0F));

        ModelPartData cube_r2 = leg2.addChild("cube_r2", ModelPartBuilder.create().uv(27, 13).cuboid(-3.0F, 0.0F, 1.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.1745F));

        ModelPartData leg3 = legs.addChild("leg3", ModelPartBuilder.create(), ModelTransform.pivot(2.75F, 0.75F, -2.0F));

        ModelPartData cube_r3 = leg3.addChild("cube_r3", ModelPartBuilder.create().uv(25, 29).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData leg4 = legs.addChild("leg4", ModelPartBuilder.create(), ModelTransform.pivot(2.75F, 0.75F, 2.0F));

        ModelPartData cube_r4 = leg4.addChild("cube_r4", ModelPartBuilder.create().uv(31, 0).cuboid(-3.0F, 0.0F, 1.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.1745F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(ScuttleTailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ScuttleTailAnimations.ANIM_SCUTTLETAIL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ScuttleTailAnimations.ANIM_SCUTTLETAIL_IDLE, ageInTicks, 1f);

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        hip.render(matrices, vertexConsumer, light, overlay, color);
    }

    public void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30f, 30f);
        headPitch = MathHelper.clamp(headPitch, -25f, 45f);

        float degToRad = 0.017453292f;

        this.head.yaw = (headYaw * 0.6f) * degToRad;
        this.head.pitch = (headPitch * 0.5f) * degToRad;
    }

    @Override
    public ModelPart getPart() {
        return hip;
    }
}