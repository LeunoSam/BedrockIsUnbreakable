package de.sajomon.bedrock_is_unbreakable.item;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.world.food.FoodProperties;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.item.custom.KnifeItem;
import de.sajomon.bedrock_is_unbreakable.item.custom.ObsidianSteelPickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    private ModItems() {
        super();
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            BedrockIsUnbreakable.MOD_ID);

    // ingot
    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    public static final RegistryObject<Item> CRYING_OBSIDIAN_INGOT = ITEMS.register("crying_obsidian_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    public static final RegistryObject<Item> OBSIDIAN_IRON_ALLOY = ITEMS.register("obsidian_iron_alloy",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    public static final RegistryObject<Item> OBSIDIAN_STEEL = ITEMS.register("obsidian_steel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    // sticks
    public static final RegistryObject<Item> OBSIDIAN_STICK = ITEMS.register("obsidian_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_HANDLE = ITEMS.register("obsidian_handle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    // food
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new ItemNameBlockItem(ModBlocks.ONION_BLOCK.get(),
                    new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    public static final RegistryObject<Item> SLICED_ONION = ITEMS.register("sliced_onion",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build())));

    public static final RegistryObject<Item> ONOION_BREAD = ITEMS.register("onion_bread", 
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.8f).build())));

    // tools
    public static final RegistryObject<Item> OBSIDIAN_KNIFE = ITEMS.register("obsidian_knife",
            () -> new KnifeItem(ModToolTiers.OBSIDIAN, -1, -0.8f,
                    new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB), 20));

    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OBSIDIAN, 1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB))

    );

    public static final RegistryObject<Item> OBSIDIAN_STEEL_PICKAXE = ITEMS.register("obsidian_steel_pickaxe",
            () -> new ObsidianSteelPickaxeItem(ModToolTiers.OBSIDIAN_STEEL, 1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB))

    );

    // player / mob drops
    public static final RegistryObject<Item> BLUE_SLIME_BALL = ITEMS.register("blue_slime_ball",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    public static final RegistryObject<Item> PLAYER_TEARS = ITEMS.register("player_tears",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    // spawn eggs
    public static final RegistryObject<Item> BLUE_SLIME_SPAWN_EGG = ITEMS.register("blue_slime_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BLUE_SLIME, 984442, 4617149,
                    new Item.Properties().tab(ModCreativeModeTab.BEDROCK_IS_UNBREAKABLE_ITEM_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
