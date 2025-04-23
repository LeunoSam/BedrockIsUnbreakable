package de.sajomon.bedrock_is_unbreakable.world.feature;

import java.util.List;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {

	private ModPlacedFeatures() {
		// Hide constructor
	}
	
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
			DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BedrockIsUnbreakable.MOD_ID);
	
	public static final RegistryObject<PlacedFeature> ONION_GRASS_PLACED =
			PLACED_FEATURES.register("onion_grass_placed",
					() -> new PlacedFeature(ModConfiguredFeatures.ONION_GRASS.getHolder().get(),
							List.of(RarityFilter.onAverageOnceEvery(100), InSquarePlacement.spread(),
									PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	
	public static void register(IEventBus bus) {
		PLACED_FEATURES.register(bus);
	}

}
