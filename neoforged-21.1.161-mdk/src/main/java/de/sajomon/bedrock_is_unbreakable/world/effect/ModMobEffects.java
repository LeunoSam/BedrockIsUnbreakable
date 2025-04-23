package de.sajomon.bedrock_is_unbreakable.world.effect;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.world.effect.custom.WeepingEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMobEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister
            .create(BuiltInRegistries.MOB_EFFECT, BedrockIsUnbreakable.MOD_ID);

    public static final Holder<MobEffect> WEEPING_EFFECT = EFFECTS.register("weeping_effect",
            () -> new WeepingEffect());

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    private ModMobEffects() {
        // hide
    }
}
