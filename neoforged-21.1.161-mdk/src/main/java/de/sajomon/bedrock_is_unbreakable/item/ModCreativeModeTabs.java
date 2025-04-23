package de.sajomon.bedrock_is_unbreakable.item;

import java.util.List;
import java.util.function.Supplier;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, BedrockIsUnbreakable.MOD_ID);

    public static final Supplier<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_ITEM_TAB = registerTab(
            "bedrock_is_unbreakable_item_tab", ModItems.OBSIDIAN_INGOT, ModItems.getAllItems());

    public static final Supplier<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_BLOCK_TAB = registerTab(
            "bedrock_is_unbreakable_block_tab", ModBlocks.BLUE_SLIME_BLOCK.getBlockItem(),
            ModBlocks.getCreativeModeTabBlockItems());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

    private static Supplier<CreativeModeTab> registerTab(String name, DeferredItem<Item> icon,
            List<DeferredItem<Item>> items) {
        return TABS.register(name,
                () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + name))
                        .icon(() -> icon.get().getDefaultInstance())
                        .displayItems((parameters, output) -> {
                            for (DeferredItem<Item> item : items) {
                                output.accept(item.get());
                            }
                        }).build());
    }

    private ModCreativeModeTabs() {
        super();
    }
}
