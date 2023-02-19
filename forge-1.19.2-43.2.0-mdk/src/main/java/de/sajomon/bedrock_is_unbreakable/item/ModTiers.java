package de.sajomon.bedrock_is_unbreakable.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
	
	public static final ForgeTier OBSIDIAN = new ForgeTier(3, 1400, 1f,
			1f, 5, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.OBSIDIAN_INGOT.get()));
	
}
