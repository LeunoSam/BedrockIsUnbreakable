package de.sajomon.bedrock_is_unbreakable.potions;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

public class ModBrewingRecipes {

    public static final ModBrewingRecipe WEEPING_POTION = new ModBrewingRecipe(Potions.AWKWARD,
            ModItems.PLAYER_TEARS.get(), ModPotions.WEEPING_POTION);

    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        WEEPING_POTION.registerRecipe(event.getBuilder());
    }

}
