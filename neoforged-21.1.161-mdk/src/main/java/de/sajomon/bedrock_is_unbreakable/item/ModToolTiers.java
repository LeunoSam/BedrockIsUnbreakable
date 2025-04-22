package de.sajomon.bedrock_is_unbreakable.item;

import de.sajomon.bedrock_is_unbreakable.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier OBSIDIAN = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL, 1200, 11f, 4f, 15,
            () -> Ingredient.of(ModItems.OBSIDIAN_INGOT.get()));

    public static final Tier OBSIDIAN_STEEL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_STEEL_TOOL, 2500,
            12f, 4f, 20, () -> Ingredient.of(ModItems.OBSIDIAN_INGOT.get()));

}
