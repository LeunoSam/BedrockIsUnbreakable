package de.sajomon.bedrock_is_unbreakable.event;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.entity.client.BlueSlimeRenderer;
import de.sajomon.bedrock_is_unbreakable.entity.custom.BlueSlime;
import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import de.sajomon.bedrock_is_unbreakable.particle.custom.BlueSlimeParticle;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID)
public class ModEvents {

	private ModEvents() {
		super();
	}

	@Mod.EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {

		private ModEventBusEvents() {
			super();
		}

		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(ModEntityTypes.BLUE_SLIME.get(), BlueSlime.createAttributes().build());
		}

		@SuppressWarnings("deprecation")
		@SubscribeEvent
		public static void commonSetup(FMLCommonSetupEvent event) {		
			event.enqueueWork(() ->
			SpawnPlacements.register(
					ModEntityTypes.BLUE_SLIME.get(),
					SpawnPlacements.Type.ON_GROUND, 
					Heightmap.Types.WORLD_SURFACE, 
					BlueSlime::checkSpawnRules)
					);
		}
	}

	@Mod.EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {

	    private ClientModEvents() {
		super();
	    }

	    @SubscribeEvent
	    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntityTypes.BLUE_SLIME.get(), BlueSlimeRenderer::new);
	    }
	    
	    @SubscribeEvent
	    public static void registerParticle(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ModParticles.BLUE_SLIME_PARTICLES.get(), BlueSlimeParticle.Provider::new);
	    }

	}

}
