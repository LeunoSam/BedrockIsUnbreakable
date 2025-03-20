package de.sajomon.bedrock_is_unbreakable.item;

import java.util.List;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, BedrockIsUnbreakable.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_ITEM_TAB = registerTab(
            "bedrock_is_unbreakable_item_tab", ModItems.OBSIDIAN_INGOT,
            List.of(ModItems.OBSIDIAN_INGOT));

//    public static final RegistryObject<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_ITEM_TAB = TABS
//            .register("bedrock_is_unbreakable_item_tab",
//                    () -> CreativeModeTab.builder()
//                            .icon(() -> ModItems.OBSIDIAN_INGOT.get().getDefaultInstance())
//                            .displayItems((parameters, output) -> {
//                                output.accept(ModItems.OBSIDIAN_INGOT.get());
//                            }).build());

    public static final RegistryObject<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_BLOCK_TAB = TABS
            .register("bedrock_is_unbreakable_block_tab", () -> CreativeModeTab.builder().build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

    private static RegistryObject<CreativeModeTab> registerTab(String name,
            RegistryObject<Item> icon, List<RegistryObject<Item>> items) {
        return TABS.register(name, () -> CreativeModeTab.builder()
                .icon(() -> icon.get().getDefaultInstance()).displayItems((parameters, output) -> {
                    for (RegistryObject<Item> item : items) {
                        output.accept(item.get());
                    }
                }).build());
    }

    private ModCreativeModeTab() {
        super();
    }
}
