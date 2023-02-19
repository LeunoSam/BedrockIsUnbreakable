package de.sajomon.bedrock_is_unbreakable.block;

import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.item.ModCreativeModeTab;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, BedrockIsUnbreakable.MOD_ID);
	
	public static final RegistryObject<Block> OBSIDIAN_BLOCK = registerBlock("obsidian_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(400f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_TAB);
	
	public static final RegistryObject<Block> OBSIDIAN_BRICK = registerBlock("obsidian_brick",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(400f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_TAB);
	
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
