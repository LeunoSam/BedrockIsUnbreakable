package de.sajomon.bedrock_is_unbreakable.item;

import java.util.List;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ModToolTiers {

    public static final Tier OBSIDIAN;
    public static final Tier OBSIDIAN_STEEL;

    static {
        OBSIDIAN = TierSortingRegistry.registerTier(
                new ForgeTier(5, 1200, 10f, 4f, 15, ModTags.Blocks.NEEDS_OBSIDIAN_TOOL,
                        () -> Ingredient.of(ModItems.OBSIDIAN_INGOT.get())),
                ResourceLocation.fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID, "obsidian"),
                List.of(Tiers.NETHERITE), List.of());

        OBSIDIAN_STEEL = TierSortingRegistry.registerTier(
                new ForgeTier(6, 2500, 12f, 4f, 20, ModTags.Blocks.NEEDS_OBSIDIAN_STEEL_TOOL,
                        () -> Ingredient.of(ModItems.OBSIDIAN_STEEL.get())),
                ResourceLocation.fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID, "obsidian_steel"),
                List.of(ModToolTiers.OBSIDIAN), List.of());
    }

}
