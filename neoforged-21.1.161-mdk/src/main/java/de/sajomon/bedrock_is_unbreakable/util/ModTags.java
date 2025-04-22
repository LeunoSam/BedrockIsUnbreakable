package de.sajomon.bedrock_is_unbreakable.util;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    private ModTags() {
        // Hide Constructor
    }

    public static class Blocks {

        private Blocks() {
            // Hide Constructor
        }

        public static final TagKey<Block> NEEDS_OBSIDIAN_TOOL = tag("needs_obsidian_tool");
        public static final TagKey<Block> INCORRECT_FOR_OBSIDIAN_TOOL = tag("incorrect_for_obsidian_tool");

        public static final TagKey<Block> NEEDS_OBSIDIAN_STEEL_TOOL = tag("needs_obsidian_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_OBSIDIAN_STEEL_TOOL = tag("incorrect_for_obsidian_steel_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID, name));
        }
    }

}
