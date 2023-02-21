package de.sajomon.bedrock_is_unbreakable.event;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.entity.custom.BlueSlime;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID)
public class ModEvents {
	
	@Mod.EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(ModEntityTypes.BLUE_SLIME.get(), BlueSlime.setAttributes());
		}
	}

}
