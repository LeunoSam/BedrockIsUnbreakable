package de.sajomon.bedrock_is_unbreakable.particle;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
			DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BedrockIsUnbreakable.MOD_ID);
	
	public static final RegistryObject<SimpleParticleType> BLUE_SLIME_PARTICLES =
			PARTICLE_TYPES.register("blue_slime_particles", () -> new SimpleParticleType(true));
	
	public static void register(IEventBus eventbus) {
		PARTICLE_TYPES.register(eventbus);
	}
	
}
