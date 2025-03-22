package de.sajomon.bedrock_is_unbreakable.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import de.sajomon.bedrock_is_unbreakable.entity.ModEntityTypes;
import de.sajomon.bedrock_is_unbreakable.item.custom.KnifeItem;
import de.sajomon.bedrock_is_unbreakable.item.custom.ObsidianSteelPickaxeItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            BedrockIsUnbreakable.MOD_ID);

    // ingot
    public static final RegistryObject<Item> OBSIDIAN_INGOT = create("obsidian_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYING_OBSIDIAN_INGOT = create("crying_obsidian_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_IRON_ALLOY = create("obsidian_iron_alloy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_STEEL = create("obsidian_steel",
            () -> new Item(new Item.Properties()));

    // sticks
    public static final RegistryObject<Item> OBSIDIAN_STICK = create("obsidian_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_HANDLE = create("obsidian_handle",
            () -> new Item(new Item.Properties()));

    // food
    public static final RegistryObject<Item> ONION = create("onion", () -> {
        ItemNameBlockItem newOnion = new ItemNameBlockItem(ModBlocks.ONION_BLOCK.getBlock().get(),
                new Item.Properties());
        ComposterBlock.COMPOSTABLES.put(newOnion.asItem(), 0.65f);
        return newOnion;
    });

    public static final RegistryObject<Item> SLICED_ONION = create("sliced_onion", () -> {
        Item newSlicedOnion = new Item(
                new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build()));
        ComposterBlock.COMPOSTABLES.put(newSlicedOnion.asItem(), 0.5f);
        return newSlicedOnion;
    });

    public static final RegistryObject<Item> ONOION_BREAD = create("onion_bread",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.8f).build())));

    // tools
    public static final RegistryObject<Item> OBSIDIAN_KNIFE = create("obsidian_knife",
            () -> new KnifeItem(ModToolTiers.OBSIDIAN, 0, 3f, new Item.Properties(), 20));

    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = create("obsidian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OBSIDIAN, 1, 0f, new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_STEEL_PICKAXE = create("obsidian_steel_pickaxe",
            () -> new ObsidianSteelPickaxeItem(ModToolTiers.OBSIDIAN_STEEL, 1, 0f, new Item.Properties())

    );

    // player / mob drops
    public static final RegistryObject<Item> BLUE_SLIME_BALL = create("blue_slime_ball",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLAYER_TEARS = create("player_tears",
            () -> new Item(new Item.Properties()));

    // spawn eggs
    public static final RegistryObject<Item> BLUE_SLIME_SPAWN_EGG = create("blue_slime_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BLUE_SLIME, 984442, 4617149, new Item.Properties()));

    private static List<RegistryObject<Item>> allItems;

    public static List<RegistryObject<Item>> getAllItems() {
        if (allItems == null) {
            allItems = new ArrayList<>();
        }
        return allItems;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> create(String name, Supplier<Item> item) {
        RegistryObject<Item> itemObject = ITEMS.register(name, item);
        getAllItems().add(itemObject);
        return itemObject;
    }

    private ModItems() {
        super();
    }
}
