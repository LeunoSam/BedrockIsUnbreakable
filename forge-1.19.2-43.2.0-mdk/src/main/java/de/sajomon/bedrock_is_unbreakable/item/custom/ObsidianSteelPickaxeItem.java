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
			Vec3 direction = player.getViewVector(0).scale(0.1);
			Vec3 location = player.getEyePosition(0).add(direction);
			int i;
			for (i = 0; level.getBlockState(new BlockPos(location)).toString().equals("Block{minecraft:air}")
					&& i < 30; i++) {
				location = location.add(direction);
			}
			System.out.println(level.getBlockState(new BlockPos(location))+ " " + i);
			System.out.println(location);
			if (level.destroyBlock(new BlockPos(location), false)) {
				player.getCooldowns().addCooldown(this, 5);
				player.getMainHandItem().hurtAndBreak(10, player, p41625 -> p41625.broadcastBreakEvent(hand));
			}
		}

		return super.use(level, player, hand);
	}

}
