package de.sajomon.bedrock_is_unbreakable.item.custom;

import java.util.List;
import java.util.Random;

import de.sajomon.bedrock_is_unbreakable.BedrockIsUnbreakable;
import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class KnifeItem extends SwordItem {

    private int possibility;
    private Random rand;

    /**
     * Creates SwordItem with the given params. Possibility has to be between 0 and
     * 100.
     * 
     * @param tier
     * @param attackDamage
     * @param attackSpeed
     * @param properties
     * @param possibility  If possibility is for example 20 there is a 20% chance
     *                     that the player gets a tear while slicing onions. If
     *                     possibility <= 0, there is a 0% chance, else if
     *                     possibility >= 100, there is a 100% chance.
     */
    public KnifeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties, int possibility) {
        super(tier, properties);
        this.possibility = possibility;
        rand = new Random();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            tryCuttingOnions(player, level, hand);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> components,
            TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            components.add(Component
                    .translatable(ResourceLocation
                            .fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID, "press_shift").toString())
                    .withStyle(ChatFormatting.GRAY));
        } else {
            components.add(Component
                    .translatable(ResourceLocation
                            .fromNamespaceAndPath(BedrockIsUnbreakable.MOD_ID, "info_knife_item").toString())
                    .withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, context, components, tooltipFlag);
    }

    private void tryCuttingOnions(Player player, Level level, InteractionHand hand) {
        Inventory inventory = player.getInventory();
        int slot = inventory.findSlotMatchingItem(new ItemStack(ModItems.ONION.get()));
        if (slot != -1) {
            cutOnion(player, inventory, slot);
            cryRandomly(player, inventory, level);
            player.getMainHandItem().hurtAndBreak(5, player, player.getMainHandItem().getEquipmentSlot());
            player.getCooldowns().addCooldown(this, 5);
        }
    }

    private void cutOnion(Player player, Inventory inventory, int onionSlot) {
        inventory.getItem(onionSlot).shrink(1);
        player.drop(new ItemStack(ModItems.SLICED_ONION.get(), 4), true);
    }

    private void cryRandomly(Player player, Inventory inventory, Level level) {
        if (rand.nextInt(100) + 1 > possibility) {
            return;
        }
        inventory.add(new ItemStack(ModItems.PLAYER_TEARS.get()));
        player.hurt(level.damageSources().sting(player), 1f);
        player.giveExperiencePoints(2);
    }

}
