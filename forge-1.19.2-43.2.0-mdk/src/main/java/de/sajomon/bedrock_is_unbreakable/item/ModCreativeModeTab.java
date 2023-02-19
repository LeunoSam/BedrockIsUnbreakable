package de.sajomon.bedrock_is_unbreakable.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
	
	public static final CreativeModeTab BEDROCK_IS_UNBREAKABLE_TAB =
	new CreativeModeTab("bedrock_is_unbreakable_tab") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.OBSIDIAN_INGOT.get());
		}
	};

}
