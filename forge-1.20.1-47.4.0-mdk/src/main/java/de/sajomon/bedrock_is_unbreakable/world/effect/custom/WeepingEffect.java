package de.sajomon.bedrock_is_unbreakable.world.effect.custom;

import java.util.Random;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WeepingEffect extends MobEffect {

    private Random random = new Random();

    public WeepingEffect() {
        super(MobEffectCategory.NEUTRAL, 10611967);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (isApplicable(entity)) {
            dropTears(entity);
        }
        super.applyEffectTick(entity, amplifier);
    }

    private void dropTears(LivingEntity entity) {
        ItemEntity itementity = createItemEntity(entity.level(), entity.getX(), entity.getY(), entity.getZ());
        itementity.setThrower(entity.getUUID());
        entity.level().addFreshEntity(itementity);
    }

    private ItemEntity createItemEntity(Level level, double x, double y, double z) {
        ItemStack stack = new ItemStack(ModItems.PLAYER_TEARS.get());
        stack.setCount(random.nextInt(5));

        ItemEntity itementity = new ItemEntity(level, x, y, z, stack);

        return itementity;
    }

    private boolean isApplicable(LivingEntity entity) {
        return !entity.level().isClientSide() && !entity.isBaby() && entity.deathTime == 1;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

}
