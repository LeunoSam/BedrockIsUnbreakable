package de.sajomon.bedrock_is_unbreakable.item;

import java.util.List;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, BedrockIsUnbreakable.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_ITEM_TAB = registerTab(
            "bedrock_is_unbreakable_item_tab", ModItems.OBSIDIAN_INGOT, ModItems.getAllItems());

    public static final RegistryObject<CreativeModeTab> BEDROCK_IS_UNBREAKABLE_BLOCK_TAB = registerTab(
            "bedrock_is_unbreakable_block_tab", ModBlocks.BLUE_SLIME_BLOCK.getBlockItem(),
            ModBlocks.getCreativeModeTabBlockItems());

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

    private ModCreativeModeTabs() {
        super();
    }
}
