package de.sajomon.bedrock_is_unbreakable.entity.custom;

import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.WorldgenRandom;

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

    public static boolean checkSpawnRules(EntityType<BlueSlime> entityType,
            ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        if (spawnType == MobSpawnType.SPAWNER || spawnType == MobSpawnType.SPAWN_EGG) {
            return true;
        }

        if (isBlueSlimeSpawnable(level, pos, random)) {
            return checkMobSpawnRules(entityType, level, spawnType, pos, random);
        }

        return false;
    }

    private static boolean isBlueSlimeSpawnable(ServerLevelAccessor level, BlockPos pos,
            RandomSource random) {
        return isDay(level) && isSlimeChunk(level, pos) && nextHeightRandom(random, pos.getY());
    }

    private static boolean nextHeightRandom(RandomSource random, int y) {
        if (y < 100) {
            return false;
        }
        if (y > 160) {
            return true;
        }
        return random.nextInt((200 - y) / 20) == 0;
    }

    private static boolean isDay(ServerLevelAccessor level) {
        return (level.dayTime() % 24000) < 12999;
    }

    private static boolean isSlimeChunk(ServerLevelAccessor level, BlockPos pos) {
        ChunkPos chunkpos = new ChunkPos(pos);
        return WorldgenRandom.seedSlimeChunk(chunkpos.x, chunkpos.z,
                ((WorldGenLevel) level).getSeed(), 987234911L).nextInt(10) == 0;
    }

}
