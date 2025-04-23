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
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BedrockIsUnbreakable.MOD_ID);

    // ingot
    public static final DeferredItem<Item> OBSIDIAN_INGOT = create("obsidian_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRYING_OBSIDIAN_INGOT = create("crying_obsidian_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OBSIDIAN_IRON_ALLOY = create("obsidian_iron_alloy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OBSIDIAN_STEEL = create("obsidian_steel",
            () -> new Item(new Item.Properties()));

    // sticks
    public static final DeferredItem<Item> OBSIDIAN_STICK = create("obsidian_stick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_HANDLE = create("obsidian_handle",
            () -> new Item(new Item.Properties()));

    // food
    public static final DeferredItem<Item> ONION = create("onion", () -> 
        new ItemNameBlockItem(ModBlocks.ONION_BLOCK.getBlock().get(), new Item.Properties()));

    public static final DeferredItem<Item> SLICED_ONION = create("sliced_onion", () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f).build())));

    public static final DeferredItem<Item> ONION_BREAD = create("onion_bread", () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build())));

    // tools
    public static final DeferredItem<Item> OBSIDIAN_KNIFE = create("obsidian_knife",
            () -> new KnifeItem(ModToolTiers.OBSIDIAN, -1, -0.8f,
                    new Item.Properties().attributes(KnifeItem.createAttributes(ModToolTiers.OBSIDIAN, -1f, -0.8f)),
                    20));

    public static final DeferredItem<Item> OBSIDIAN_HOE = create("obsidian_hoe",
            () -> new HoeItem(ModToolTiers.OBSIDIAN,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.OBSIDIAN, -4f, 0f))));

    public static final DeferredItem<Item> OBSIDIAN_AXE = create("obsidian_axe",
            () -> new AxeItem(ModToolTiers.OBSIDIAN,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.OBSIDIAN, 4f, -3f))));

    public static final DeferredItem<Item> OBSIDIAN_SHOVEL = create("obsidian_shovel",
            () -> new ShovelItem(ModToolTiers.OBSIDIAN,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.OBSIDIAN, 0.5f, -3f))));

    public static final DeferredItem<Item> OBSIDIAN_PICKAXE = create("obsidian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OBSIDIAN,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.OBSIDIAN, 0, -2.8f))));

    public static final DeferredItem<Item> OBSIDIAN_STEEL_PICKAXE = create("obsidian_steel_pickaxe",
            () -> new ObsidianSteelPickaxeItem(
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.OBSIDIAN, 1f, -2.8f))));

    // player / mob drops
    public static final DeferredItem<Item> BLUE_SLIME_BALL = create("blue_slime_ball",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLAYER_TEARS = create("player_tears", () -> new Item(new Item.Properties()));

    // spawn eggs
    public static final DeferredItem<Item> BLUE_SLIME_SPAWN_EGG = create("blue_slime_spawn_egg", 
            () -> new DeferredSpawnEggItem(ModEntityTypes.BLUE_SLIME, 984442, 4617149, new Item.Properties()));

    private static List<DeferredItem<Item>> allItems;

    public static List<DeferredItem<Item>> getAllItems() {
        if (allItems == null) {
            allItems = new ArrayList<>();
        }
        return allItems;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> create(String name, Supplier<Item> item) {
        DeferredItem<Item> itemObject = ITEMS.register(name, item);
        getAllItems().add(itemObject);
        return itemObject;
    }

    private ModItems() {
        super();
    }
}
