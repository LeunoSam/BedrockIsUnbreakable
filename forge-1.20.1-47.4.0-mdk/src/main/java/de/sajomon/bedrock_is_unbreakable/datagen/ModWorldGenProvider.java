package de.sajomon.bedrock_is_unbreakable.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.worldgen.ModBiomeModifier;
import de.sajomon.bedrock_is_unbreakable.worldgen.ModConfiguredFeatures;
import de.sajomon.bedrock_is_unbreakable.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifier::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<Provider> registries,
            RegistrySetBuilder datapackEntriesBuilder) {
        super(output, registries, datapackEntriesBuilder, Set.of(BedrockIsUnbreakable.MOD_ID));
    }

}
