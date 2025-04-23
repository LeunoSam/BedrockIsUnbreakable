package de.sajomon.bedrock_is_unbreakable;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import de.sajomon.bedrock_is_unbreakable.item.ModCreativeModeTabs;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BedrockIsUnbreakable.MOD_ID)
public class BedrockIsUnbreakable {

    public static final String MOD_ID = "bedrock_is_unbreakable";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BedrockIsUnbreakable(IEventBus modEventBus, ModContainer modContainer) {

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
//
//        ModMobEffects.register(modEventBus);
//        ModPotions.register(modEventBus);
//
//        ModEntityTypes.register(modEventBus);
//        ModParticles.register(modEventBus);

    }

}
