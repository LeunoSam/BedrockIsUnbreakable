package de.sajomon.bedrock_is_unbreakable.entity;

import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.entity.custom.BlueSlime;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
            .create(BuiltInRegistries.ENTITY_TYPE, BedrockIsUnbreakable.MOD_ID);

    public static final Supplier<EntityType<BlueSlime>> BLUE_SLIME = ENTITY_TYPES.register("blue_slime",
            () -> EntityType.Builder.of(BlueSlime::new, MobCategory.MONSTER).sized(2f, 2f).build(
                    ResourceLocation.fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID, "blue_slime").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
