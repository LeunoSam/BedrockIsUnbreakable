package de.sajomon.bedrock_is_unbreakable;

import com.mojang.logging.LogUtils;

import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import de.sajomon.bedrock_is_unbreakable.world.feature.ModConfiguredFeatures;
import de.sajomon.bedrock_is_unbreakable.world.feature.ModPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BedrockIsUnbreakable.MOD_ID)
public class BedrockIsUnbreakable {
	
	public static final String MOD_ID = "bedrock_is_unbreakable";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BedrockIsUnbreakable() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModEntityTypes.register(modEventBus);
		ModParticles.register(modEventBus);
		ModConfiguredFeatures.register(modEventBus);
		ModPlacedFeatures.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}
	
}
