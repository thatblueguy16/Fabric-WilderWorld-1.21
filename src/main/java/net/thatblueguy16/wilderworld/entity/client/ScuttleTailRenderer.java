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
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailEntity;
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailVariant;

import java.util.Map;

public class ScuttleTailRenderer extends MobEntityRenderer<ScuttleTailEntity, ScuttleTailModel<ScuttleTailEntity>> {
    private static final Map<ScuttleTailVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ScuttleTailVariant.class), map ->{
                map.put(ScuttleTailVariant.MOSSBACK,
                        Identifier.of(WilderWorld.MOD_ID, "textures/entity/scuttle_tail/scuttle_tail_mossback.png"));
                map.put(ScuttleTailVariant.PURPLETAIL,
                        Identifier.of(WilderWorld.MOD_ID, "textures/entity/scuttle_tail/scuttle_tail_purpletail.png"));
                map.put(ScuttleTailVariant.MUDFOOT,
                        Identifier.of(WilderWorld.MOD_ID, "textures/entity/scuttle_tail/scuttle_tail_mudfoot.png"));
            });

    public static final EntityModelLayer SCUTTLETAIL = new EntityModelLayer(Identifier.of(WilderWorld.MOD_ID, "scuttletail"), "main");

    public ScuttleTailRenderer(EntityRendererFactory.Context context) {
        super(context, new ScuttleTailModel<>(context.getPart(ScuttleTailModel.SCUTTLETAIL)), .25f);
    }

    @Override
    public Identifier getTexture(ScuttleTailEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(ScuttleTailEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()){
            matrixStack.scale(0.5f, .5f, .5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
