package de.sajomon.bedrock_is_unbreakable.block.custom;

import de.sajomon.bedrock_is_unbreakable.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class OnionBlock extends CropBlock {

	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);

	public OnionBlock(Properties props) {
		super(props);
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return ModItems.ONION.get();
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return 5;
	}

	@Override 
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}
}
