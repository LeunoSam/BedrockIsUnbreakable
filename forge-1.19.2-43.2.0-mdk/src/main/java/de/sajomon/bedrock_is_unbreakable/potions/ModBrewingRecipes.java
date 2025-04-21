package de.sajomon.bedrock_is_unbreakable.potions;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModBrewingRecipes {

    public static final ModBrewingRecipe WEEPING_POTION = new ModBrewingRecipe(Potions.AWKWARD,
            ModItems.PLAYER_TEARS.get(), ModPotions.WEEPING_POTION.get());

    public static void setup() {
        BrewingRecipeRegistry.addRecipe(WEEPING_POTION);
    }

}
