package de.sajomon.bedrock_is_unbreakable.item.custom;

import de.sajomon.bedrock_is_unbreakable.item.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ObsidianSteelPickaxeItem extends PickaxeItem {

    public ObsidianSteelPickaxeItem(Properties props) {
        super(ModToolTiers.OBSIDIAN_STEEL, props);
    }

    @Override
    public InteractionResult useOn(UseOnContext useContext) {
        Level level = useContext.getLevel();
        Player player = useContext.getPlayer();
        InteractionHand hand = useContext.getHand();
        BlockPos pos = useContext.getClickedPos();
        Block block = level.getBlockState(pos).getBlock();

        if (isActionAllowed(hand, level) && block.equals(Blocks.BEDROCK)) {
            destroyBlock(player, hand, level, pos);
        }

        return super.useOn(useContext);
    }

    private boolean isActionAllowed(InteractionHand hand, Level level) {
        return !level.isClientSide && hand == InteractionHand.MAIN_HAND;
    }

    private void destroyBlock(Player player, InteractionHand hand, Level level, BlockPos pos) {
        if (level.destroyBlock(pos, false)) {
            player.getCooldowns().addCooldown(this, 5);
            player.getMainHandItem().hurtAndBreak(10, player, player.getMainHandItem().getEquipmentSlot());
        }
    }

}
