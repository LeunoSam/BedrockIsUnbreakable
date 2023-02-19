package de.sajomon.bedrock_is_unbreakable.item;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.item.custom.ObsidianKnifeItem;
import net.minecraft.world.food.FoodProperties;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, BedrockIsUnbreakable.MOD_ID);
	
	public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));
	
	public static final RegistryObject<Item> CRYING_OBSIDIAN_INGOT = ITEMS.register("crying_obsidian_ingot",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));
	
	public static final RegistryObject<Item> OBSIDIAN_STICK = ITEMS.register("obsidian_stick",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));
	
	public static final RegistryObject<Item> ONION = ITEMS.register("onion",
			() -> new ItemNameBlockItem(ModBlocks.ONION_BLOCK.get(), 
					new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB))
			);
	
	public static final RegistryObject<Item> OBSIDIAN_KNIFE = ITEMS.register("obsidian_knife",
			() -> new ObsidianKnifeItem(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)
					.stacksTo(1).durability(100)));
	
	public static final RegistryObject<Item> SLICED_ONION = ITEMS.register("sliced_onion",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));
	
	public static final RegistryObject<Item> PLAYER_TEARS = ITEMS.register("player_tears",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
