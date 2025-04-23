package de.sajomon.bedrock_is_unbreakable.potions;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.world.effect.ModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister
            .create(BuiltInRegistries.POTION, BedrockIsUnbreakable.MOD_ID);

    public static final Holder<Potion> WEEPING_POTION = POTIONS.register("weeping_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.WEEPING_EFFECT, 400)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    private ModPotions() {
        super(); // hide
    }
}
