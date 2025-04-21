package de.sajomon.bedrock_is_unbreakable.world.effect;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.world.effect.custom.WeepingEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMobEffects {

    private ModMobEffects() {
    }

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
            BedrockIsUnbreakable.MOD_ID);

    public static final RegistryObject<MobEffect> WEEPING_EFFECT = EFFECTS.register("weeping_effect", 
            () -> new WeepingEffect(MobEffectCategory.NEUTRAL, 21));
    
    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
    
}
