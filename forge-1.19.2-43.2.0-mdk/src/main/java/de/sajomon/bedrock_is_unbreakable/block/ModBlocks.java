package de.sajomon.bedrock_is_unbreakable.block;

import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.custom.OnionBlock;
import de.sajomon.bedrock_is_unbreakable.item.ModCreativeModeTab;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
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
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(300f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_BLOCK_TAB);
	
	public static final RegistryObject<Block> OBSIDIAN_BLOCK_STAIRS = registerBlock("obsidian_block_stairs",
			() -> new StairBlock(() -> ModBlocks.OBSIDIAN_BLOCK.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE).strength(300f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_BLOCK_TAB);
	
	public static final RegistryObject<Block> OBSIDIAN_BLOCK_SLAB = registerBlock("obsidian_block_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(300f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_BLOCK_TAB);
	
	public static final RegistryObject<Block> OBSIDIAN_BRICK = registerBlock("obsidian_brick",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(300f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_BLOCK_TAB);
	
	public static final RegistryObject<Block> OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
			() -> new StairBlock(() -> ModBlocks.OBSIDIAN_BRICK.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE).strength(300f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_BLOCK_TAB);
	
	public static final RegistryObject<Block> OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(300f).
					requiresCorrectToolForDrops().explosionResistance(2000f)),
			ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_BLOCK_TAB);
	
	public static final RegistryObject<Block> ONION_BLOCK = BLOCKS.register("onions",
			() -> new OnionBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES))
			);
	
	
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
