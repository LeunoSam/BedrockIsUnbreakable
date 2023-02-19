package de.sajomon.bedrock_is_unbreakable.item.custom;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ObsidianKnifeItem extends SwordItem {
	
	private int count;

	
	public ObsidianKnifeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
		count = 0;
	}
	
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
			Inventory i = player.getInventory();
			int slot = i.findSlotMatchingItem(new ItemStack(ModItems.ONION.get()));
			if(slot != -1) {
				i.getItem(slot).shrink(1);
				player.drop(new ItemStack(ModItems.SLICED_ONION.get(), 4), true);
				if(count > 4) {
					i.add(new ItemStack(ModItems.PLAYER_TEARS.get()));
					count = 0;
				}
				player.getCooldowns().addCooldown(this, 5);
				count++;
			}
		}
		return super.use(level, player, hand);
	}

}
