package de.sajomon.bedrock_is_unbreakable.world.feature;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {
	
	private ModConfiguredFeatures() {
		// Hide constructor
	}

	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
			DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BedrockIsUnbreakable.MOD_ID);

	public static final RegistryObject<ConfiguredFeature<?, ?>> ONION_GRASS =
			CONFIGURED_FEATURES.register("onion_grass",
				() -> new ConfiguredFeature<>(Feature.FLOWER,
						new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
								new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ONION_GRASS.get())))
								))
				);

	public static void register(IEventBus bus) {
		CONFIGURED_FEATURES.register(bus);
	}

}
