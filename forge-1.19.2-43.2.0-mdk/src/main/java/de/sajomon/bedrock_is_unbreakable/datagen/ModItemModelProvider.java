package de.sajomon.bedrock_is_unbreakable.datagen;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
	super(generator, BedrockIsUnbreakable.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
	handheldItem(ModItems.OBSIDIAN_STEEL_PICKAXE);
	handheldItem(ModItems.OBSIDIAN_PICKAXE);
	handheldItem(ModItems.OBSIDIAN_KNIFE);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
	ResourceLocation itemLoc = new ResourceLocation(BedrockIsUnbreakable.MOD_ID, 
		"item/" + item.getId().getPath());
	return this.withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld"))
		.texture("layer0", itemLoc);
    }

}
