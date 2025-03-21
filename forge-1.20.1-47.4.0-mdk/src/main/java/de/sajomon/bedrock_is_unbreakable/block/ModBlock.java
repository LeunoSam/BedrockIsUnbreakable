package de.sajomon.bedrock_is_unbreakable.block;

import java.util.Objects;
import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

/**
 * A {@link ModBlock} contains the {@link RegistryObject} of the {@link Block}
 * and of the {@link Item} of a new registered block.
 * 
 * @author LeunoSam
 */
public class ModBlock {

    private String name;
    private RegistryObject<Block> block;
    private RegistryObject<Item> blockItem;

    <T extends Block> ModBlock(String name, Supplier<T> block, boolean hasItem) {
        super();
        this.name = name;
        this.block = ModBlocks.BLOCKS.register(name, block);
        if (hasItem) {
            registerBlockItem();
        }
    }

    private void registerBlockItem() {
        blockItem = ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public RegistryObject<Block> getBlock() {
        return block;
    }

    public RegistryObject<Item> getBlockItem() {
        return blockItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModBlock other = (ModBlock) obj;
        return Objects.equals(name, other.name);
    }
}
