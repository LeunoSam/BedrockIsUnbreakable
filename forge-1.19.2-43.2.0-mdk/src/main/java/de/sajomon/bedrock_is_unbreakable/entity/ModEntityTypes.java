package de.sajomon.bedrock_is_unbreakable.entity;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.entity.custom.BlueSlime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BedrockIsUnbreakable.MOD_ID);
	
	public static final RegistryObject<EntityType<BlueSlime>> BLUE_SLIME =
			ENTITY_TYPES.register("blue_slime",
					() -> EntityType.Builder.of(BlueSlime::new, MobCategory.MONSTER).sized(2f, 2f)
					.build(new ResourceLocation(BedrockIsUnbreakable.MOD_ID, "blue_slime").toString())
	);
	
	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}

}
