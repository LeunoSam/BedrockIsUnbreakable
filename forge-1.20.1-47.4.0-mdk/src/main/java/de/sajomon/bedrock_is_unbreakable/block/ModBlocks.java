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
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister
            .create(ForgeRegistries.BLOCKS, BedrockIsUnbreakable.MOD_ID);

    public static final ModBlock OBSIDIAN_BLOCK = create("obsidian_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(275f)
                    .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock OBSIDIAN_BLOCK_STAIRS = create("obsidian_block_stairs",
            () -> new StairBlock(() -> OBSIDIAN_BLOCK.getBlock().get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(275f)
                            .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock OBSIDIAN_BLOCK_SLAB = create("obsidian_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(275f)
                    .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock OBSIDIAN_BRICK = create("obsidian_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(275f)
                    .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock OBSIDIAN_BRICK_STAIRS = create("obsidian_brick_stairs",
            () -> new StairBlock(() -> OBSIDIAN_BRICK.getBlock().get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(275f)
                            .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock OBSIDIAN_BRICK_SLAB = create("obsidian_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(275f)
                    .requiresCorrectToolForDrops().explosionResistance(2000f)));

    public static final ModBlock ONION_BLOCK = create("onions",
            () -> new OnionBlock(
                    BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()),
            false);

    public static final ModBlock BLUE_SLIME_BLOCK = create("blue_slime_block",
            () -> new BlueSlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)));

    public static final ModBlock ONION_GRASS = create("onion_grass",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));

    private static List<ModBlock> allBlocks;
    private static List<RegistryObject<Item>> creativeModeTabItems;

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static List<ModBlock> getAllBlocks() {
        if (allBlocks == null) {
            allBlocks = new ArrayList<>();
        }
        return allBlocks;
    }

    public static List<RegistryObject<Item>> getCreativeModeTabBlockItems() {
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
