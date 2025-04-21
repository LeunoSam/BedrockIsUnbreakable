package de.sajomon.bedrock_is_unbreakable.world.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WeepingEffect extends MobEffect {

    public WeepingEffect() {
        super(MobEffectCategory.NEUTRAL, 10611967);
    }
    
    @Override
    public void applyEffectTick(LivingEntity entity, int amplitude) {
        entity.getLootTable();
        super.applyEffectTick(entity, amplitude);
    }
    

}
