package de.sajomon.bedrock_is_unbreakable.particle;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
            .create(BuiltInRegistries.PARTICLE_TYPE, BedrockIsUnbreakable.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_SLIME_PARTICLES = PARTICLE_TYPES
            .register("blue_slime_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventbus) {
        PARTICLE_TYPES.register(eventbus);
    }

}
