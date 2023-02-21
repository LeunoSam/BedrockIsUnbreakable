package de.sajomon.bedrock_is_unbreakable;

import com.mojang.logging.LogUtils;

import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.entity.client.BlueSlimeRenderer;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BedrockIsUnbreakable.MOD_ID)
public class BedrockIsUnbreakable
{
	public static final String MOD_ID = "bedrock_is_unbreakable";
	private static final Logger LOGGER = LogUtils.getLogger();

	public BedrockIsUnbreakable() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModEntityTypes.register(modEventBus);

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		
	}

	
	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SuppressWarnings("removal")
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ModBlocks.ONION_BLOCK.get(), RenderType.cutout());
			EntityRenderers.register(ModEntityTypes.BLUE_SLIME.get(), BlueSlimeRenderer::new);
		}
	}
}
