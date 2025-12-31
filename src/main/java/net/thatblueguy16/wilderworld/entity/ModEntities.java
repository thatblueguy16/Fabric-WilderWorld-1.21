package net.thatblueguy16.wilderworld.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.entity.custom.BogMawEntity;
import net.thatblueguy16.wilderworld.entity.custom.ScuttleTailEntity;

import java.security.PublicKey;

public class ModEntities {
    public static final EntityType<ScuttleTailEntity> ScuttleTail = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(WilderWorld.MOD_ID, "scuttle_tail"),
            EntityType.Builder.create(ScuttleTailEntity:: new, SpawnGroup.CREATURE)
                    .dimensions(.5f, .25f).build());
    public static final EntityType<BogMawEntity> BogMaw = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(WilderWorld.MOD_ID, "bog_maw"),
            EntityType.Builder.create(BogMawEntity:: new, SpawnGroup.CREATURE)
                    .dimensions(1f, .75f).build());


    public static void registerModEntities() {
        WilderWorld.LOGGER.info("Register Mod Entities for" + WilderWorld.MOD_ID);
    }

}
