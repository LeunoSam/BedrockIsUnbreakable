package de.sajomon.bedrock_is_unbreakable.block.custom;

import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlueSlimeBlock extends SlimeBlock{

	public BlueSlimeBlock(Properties prop) {
		super(prop);
	}
	
	@Override
	public boolean isSlimeBlock(BlockState state) {
		return true;
	}
	
	@Override
	public boolean isStickyBlock(BlockState state) {
		return true;
	}

	@Override
	public boolean canStickTo(BlockState state, BlockState other) {
		return true;
	}

}
