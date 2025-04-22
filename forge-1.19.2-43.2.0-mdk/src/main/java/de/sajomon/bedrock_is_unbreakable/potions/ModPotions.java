package de.sajomon.bedrock_is_unbreakable.potions;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.world.effect.ModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister
            .create(ForgeRegistries.POTIONS, BedrockIsUnbreakable.MOD_ID);

    public static final RegistryObject<Potion> WEEPING_POTION = POTIONS.register("weeping_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.WEEPING_EFFECT.get(), 400, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    private ModPotions() {
        super(); // hide
    }
}
