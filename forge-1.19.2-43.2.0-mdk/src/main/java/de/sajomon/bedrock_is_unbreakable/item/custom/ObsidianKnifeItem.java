package de.sajomon.bedrock_is_unbreakable.item.custom;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ObsidianKnifeItem extends Item {
	

	public ObsidianKnifeItem(Properties props) {
		super(props);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
			Inventory i = player.getInventory();
			if(i.contains(new ItemStack(ModItems.ONION.get()))) {
				i.add(new ItemStack(ModItems.SLICED_ONION.get()));
				player.getCooldowns().addCooldown(this, 10);
			}
		}
		return super.use(level, player, hand);
	}

}
