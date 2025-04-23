package de.sajomon.bedrock_is_unbreakable.block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.custom.BlueSlimeBlock;
import de.sajomon.bedrock_is_unbreakable.block.custom.OnionBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister
            .createBlocks(BedrockIsUnbreakable.MOD_ID);

    public static final ModBlock OBSIDIAN_BLOCK = create("obsidian_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(275f)
                    .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock OBSIDIAN_BLOCK_STAIRS = create("obsidian_block_stairs",
            () -> new StairBlock(OBSIDIAN_BLOCK.getBlock().get().defaultBlockState(), 
                    OBSIDIAN_BLOCK.getBlock().get().properties()));

    public static final ModBlock OBSIDIAN_BLOCK_SLAB = create("obsidian_block_slab",
            () -> new SlabBlock(OBSIDIAN_BLOCK.getBlock().get().properties()));

    public static final ModBlock OBSIDIAN_BRICK = create("obsidian_brick",
            () -> new Block(OBSIDIAN_BLOCK.getBlock().get().properties()));

    public static final ModBlock OBSIDIAN_BRICK_STAIRS = create("obsidian_brick_stairs",
            () -> new StairBlock(OBSIDIAN_BLOCK.getBlock().get().defaultBlockState(), 
                    OBSIDIAN_BLOCK.getBlock().get().properties()));

    public static final ModBlock OBSIDIAN_BRICK_SLAB = create("obsidian_brick_slab",
            () -> new SlabBlock(OBSIDIAN_BLOCK.getBlock().get().properties()));

    public static final ModBlock ONION_BLOCK = create("onions",
            () -> new OnionBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).noOcclusion().noCollission()),
            false);

    public static final ModBlock BLUE_SLIME_BLOCK = create("blue_slime_block",
            () -> new BlueSlimeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK)));

    public static final ModBlock ONION_GRASS = create("onion_grass",
            () -> new TallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));

    private static List<ModBlock> allBlocks;
    private static List<DeferredItem<Item>> creativeModeTabItems;

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static List<ModBlock> getAllBlocks() {
        if (allBlocks == null) {
            allBlocks = new ArrayList<>();
        }
        return allBlocks;
    }

    public static List<DeferredItem<Item>> getCreativeModeTabBlockItems() {
        if (creativeModeTabItems == null) {
            creativeModeTabItems = new ArrayList<>();
        }
        return creativeModeTabItems;
    }

    private static <T extends Block> ModBlock create(String name, Supplier<T> block) {
        return create(name, block, true);
    }

    private static <T extends Block> ModBlock create(String name, Supplier<T> block,
            boolean hasItem) {
        ModBlock modBlock = new ModBlock(name, block, hasItem);
        getAllBlocks().add(modBlock);
        if (hasItem) {
            getCreativeModeTabBlockItems().add(modBlock.getBlockItem());
        }
        return modBlock;
    }

    private ModBlocks() {
        super(); // hide
    }
}
