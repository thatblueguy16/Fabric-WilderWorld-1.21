package net.thatblueguy16.wilderworld.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.entity.custom.BogMawEntity;
import net.thatblueguy16.wilderworld.entity.custom.BogMawVariant;
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailEntity;
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailVariant;

import java.util.Map;

public class BogMawRenderer extends MobEntityRenderer<BogMawEntity, BogMawModel<BogMawEntity>> {
    private static final Map<BogMawVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BogMawVariant.class), map ->{
                map.put(BogMawVariant.DEFAULT,
                        Identifier.of(WilderWorld.MOD_ID, "textures/entity/bog_maw/bog_maw.png"));
                map.put(BogMawVariant.PURPLE,
                        Identifier.of(WilderWorld.MOD_ID, "textures/entity/bog_maw/bog_maw_purple.png"));
                map.put(BogMawVariant.GREEN,
                        Identifier.of(WilderWorld.MOD_ID, "textures/entity/bog_maw/bog_maw_green.png"));
            });

    public static final EntityModelLayer BOGMAW = new EntityModelLayer(Identifier.of(WilderWorld.MOD_ID, "bogmaw"), "main");

    public BogMawRenderer(EntityRendererFactory.Context context) {
        super(context, new BogMawModel<>(context.getPart(BogMawModel.BOGMAW)), .25f);
    }

    @Override
    public Identifier getTexture(BogMawEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(BogMawEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()){
            matrixStack.scale(0.5f, .5f, .5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
