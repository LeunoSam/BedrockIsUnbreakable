package de.sajomon.bedrock_is_unbreakable.potions;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;

public record ModBrewingRecipe(Holder<Potion> input, Item ingredient, Holder<Potion> output) {

    public void registerRecipe(PotionBrewing.Builder builder) {
        builder.addMix(input, ingredient, output);
    }
}
