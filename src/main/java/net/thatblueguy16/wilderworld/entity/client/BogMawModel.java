package net.thatblueguy16.wilderworld.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.entity.ModEntities;
import net.thatblueguy16.wilderworld.entity.custom.BogMawEntity;
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailEntity;

public class BogMawModel<T extends BogMawEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BOGMAW = new EntityModelLayer(Identifier.of(WilderWorld.MOD_ID, "bogmaw"), "main");
    private final ModelPart hip;
    private final ModelPart head;
    public BogMawModel(ModelPart root) {
        this.hip = root.getChild("hip");
        this.head = this.hip.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hip = modelPartData.addChild("hip", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 17.0F, 0.0F));

        ModelPartData head = hip.addChild("head", ModelPartBuilder.create().uv(86, 83).cuboid(-7.0F, -3.0F, -11.0F, 14.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, -10.0F));

        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(67, 25).cuboid(-8.0F, 0.0F, -11.0F, 16.0F, 3.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

        ModelPartData body = hip.addChild("body", ModelPartBuilder.create().uv(0, 25).cuboid(-6.0F, -4.0F, -10.0F, 12.0F, 8.0F, 21.0F, new Dilation(0.0F))
                .uv(61, 55).cuboid(0.0F, -10.0F, -10.0F, 0.0F, 6.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData legs = hip.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

        ModelPartData leg1 = legs.addChild("leg1", ModelPartBuilder.create().uv(89, 12).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F))
                .uv(98, 104).cuboid(0.0F, 0.0F, 2.0F, 0.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(104, 54).cuboid(-3.0F, 6.0F, -5.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, 0.0F, -5.0F));

        ModelPartData leg2 = legs.addChild("leg2", ModelPartBuilder.create().uv(89, 0).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F))
                .uv(93, 104).cuboid(0.0F, 0.0F, 2.0F, 0.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(86, 99).cuboid(-2.0F, 6.0F, -5.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, -5.0F));

        ModelPartData leg3 = legs.addChild("leg3", ModelPartBuilder.create().uv(67, 40).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.0F))
                .uv(86, 104).cuboid(0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 3.0F, new Dilation(0.0F))
                .uv(104, 59).cuboid(-2.0F, 8.0F, -5.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -2.0F, 8.0F));

        ModelPartData leg4 = legs.addChild("leg4", ModelPartBuilder.create().uv(104, 64).cuboid(-3.0F, 8.0F, -5.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(86, 40).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.0F))
                .uv(104, 69).cuboid(0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, -2.0F, 8.0F));

        ModelPartData tail = hip.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, 0.0F, -1.0F, 20.0F, 0.0F, 24.0F, new Dilation(0.0F))
                .uv(0, 55).cuboid(-5.0F, -3.0F, -1.0F, 10.0F, 6.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 12.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void setAngles(BogMawEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(BogMawAnimations.ANIM_BOGMAW_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BogMawAnimations.ANIM_BOGMAW_IDLE, ageInTicks, .5f);
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