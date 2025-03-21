package de.sajomon.bedrock_is_unbreakable.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Slime;
import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import net.minecraft.client.renderer.entity.SlimeRenderer;

public class BlueSlimeRenderer extends SlimeRenderer {

    public BlueSlimeRenderer(Context p_174391_) {
        super(p_174391_);
    }

    @Override
    public ResourceLocation getTextureLocation(Slime p_115974_) {
        return ResourceLocation.fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID,
                "textures/entity/slime/blue_slime.png");
    }
}
