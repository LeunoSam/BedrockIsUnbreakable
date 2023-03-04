package de.sajomon.bedrock_is_unbreakable.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ObsidianSteelPickaxeItem extends PickaxeItem {

	public ObsidianSteelPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties props) {
		super(tier, attackDamage, attackSpeed, props);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
			Vec3 direction = player.getViewVector(0).scale(0.01);
			Vec3 eyes = player.getEyePosition(0);
			Vec3 location = eyes.add(direction);
			
			while (level.getBlockState(new BlockPos(location)).toString().equals("Block{minecraft:air}")
					&& absVec3(substractVec3(eyes, location)) <= 4) {
				location = location.add(direction);
			}
			if (level.destroyBlock(new BlockPos(location), false)) {
				player.getCooldowns().addCooldown(this, 5);
				player.getMainHandItem().hurtAndBreak(10, player, p41625 -> p41625.broadcastBreakEvent(hand));
			}
		}

		return super.use(level, player, hand);
	}
	
	private static double absVec3(Vec3 v) {
		return Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
	}
	
	private static Vec3 substractVec3(Vec3 v, Vec3 sub) {
		return v.add(new Vec3(-sub.x, -sub.y, -sub.z));
	}
}
