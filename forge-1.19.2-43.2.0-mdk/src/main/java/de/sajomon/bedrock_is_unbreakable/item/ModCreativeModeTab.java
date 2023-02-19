package de.sajomon.bedrock_is_unbreakable.item;

import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

	public static final CreativeModeTab BEDROCK_IS_UNBREAKABLE_ITEM_TAB =
			new CreativeModeTab("bedrock_is_unbreakable_item_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.OBSIDIAN_INGOT.get());
		}
	};

	public static final CreativeModeTab BEDROCK_IS_UNBREAKABLE_BLOCK_TAB =
			new CreativeModeTab("bedrock_is_unbreakable_block_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.OBSIDIAN_BLOCK.get());
		}
	};

}
