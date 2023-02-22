package de.sajomon.bedrock_is_unbreakable.entity.custom;

import de.sajomon.bedrock_is_unbreakable.particle.ModParticles;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class BlueSlime extends Slime {

	public BlueSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
		super(p_33588_, p_33589_);
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.ATTACK_DAMAGE, 1.0f)
				.add(Attributes.MOVEMENT_SPEED, 0.5f)
				.add(Attributes.ATTACK_SPEED, 1.0f)
				.add(Attributes.MAX_HEALTH, 10.0).build();
	}
	
	@Override
	protected ParticleOptions getParticleType() {
		return ModParticles.BLUE_SLIME_PARTICLES.get();
	}
}
