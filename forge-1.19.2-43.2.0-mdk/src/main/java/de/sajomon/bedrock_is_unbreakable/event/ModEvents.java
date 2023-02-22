package de.sajomon.bedrock_is_unbreakable.event;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.entity.client.BlueSlimeRenderer;
import de.sajomon.bedrock_is_unbreakable.entity.custom.BlueSlime;
import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import de.sajomon.bedrock_is_unbreakable.particle.custom.BlueSlimeParticle;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
			event.put(ModEntityTypes.BLUE_SLIME.get(), BlueSlime.setAttributes());
		}

		@SubscribeEvent
		public static void registerParticleProvider(final RegisterParticleProvidersEvent event) {
			event.register(ModParticles.BLUE_SLIME_PARTICLES.get(), BlueSlimeParticle.Provider::new); 
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

		@SuppressWarnings("removal")
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ModBlocks.ONION_BLOCK.get(), RenderType.cutout());
			EntityRenderers.register(ModEntityTypes.BLUE_SLIME.get(), BlueSlimeRenderer::new);
		}
	}

}
