package de.sajomon.bedrock_is_unbreakable.event;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.entity.client.BlueSlimeRenderer;
import de.sajomon.bedrock_is_unbreakable.entity.custom.BlueSlime;
import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import de.sajomon.bedrock_is_unbreakable.particle.custom.BlueSlimeParticle;
import de.sajomon.bedrock_is_unbreakable.potions.ModBrewingRecipes;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

//@EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID)
public class ModEvents {

    private ModEvents() {
        super();
    }

    @EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        private ModEventBusEvents() {
            super();
        }

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.BLUE_SLIME.get(), BlueSlime.createAttributes().build());
        }

        @SubscribeEvent
        public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
            event.register(ModEntityTypes.BLUE_SLIME.get(), SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE, BlueSlime::checkSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.REPLACE);
        }

    }

    @EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
            event.registerSpriteSet(ModParticles.BLUE_SLIME_PARTICLES.get(),
                    BlueSlimeParticle.Provider::new);
        }
    }

    @EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
    public static class GameModEvents {

        private GameModEvents() {
            super();
        }

        @SubscribeEvent
        public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
            ModBrewingRecipes.registerBrewingRecipes(event);
        }
    }

}
