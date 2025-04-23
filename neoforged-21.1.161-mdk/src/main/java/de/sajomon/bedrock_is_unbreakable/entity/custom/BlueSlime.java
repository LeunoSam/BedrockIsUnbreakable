package de.sajomon.bedrock_is_unbreakable.entity.custom;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class BlueSlime extends Slime {

    public BlueSlime(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected ParticleOptions getParticleType() {
        return ModParticles.BLUE_SLIME_PARTICLES.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createMobAttributes().add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.5f).add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MAX_HEALTH, 10.0);
    }

    public static boolean checkSpawnRules(EntityType<BlueSlime> entityType, ServerLevelAccessor level,
            MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        if (spawnType == MobSpawnType.SPAWNER || spawnType == MobSpawnType.SPAWN_EGG) {
            return true;
        } else {
            if (checkMobSpawnRules(entityType, level, spawnType, pos, random) && pos.getY() > 100
                    && (level.dayTime() % 24000) < 12999) {
                BedrockIsUnbreakable.LOGGER.info("BlueSlime spawned!");
                return true;
            } else {
                return false;
            }
        }
    }

}
