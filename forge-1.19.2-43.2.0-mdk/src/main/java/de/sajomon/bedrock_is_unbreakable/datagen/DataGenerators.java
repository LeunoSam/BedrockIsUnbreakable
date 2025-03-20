package de.sajomon.bedrock_is_unbreakable.datagen;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BedrockIsUnbreakable.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherDate(GatherDataEvent event) {
	DataGenerator generator = event.getGenerator();
	ExistingFileHelper fileHelper = event.getExistingFileHelper();
	
	generator.addProvider(event.includeClient(), 
		new ModItemModelProvider(generator, fileHelper)
		);
    }
    
}
