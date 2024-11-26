package com.dragonclaw.gardening_decor.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import java.util.Optional;

public class DecorIvyPlant extends MultifaceBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7); // Age property from 0 to 7
    private final MultifaceSpreader spreader;

    public DecorIvyPlant(Properties settings) {
        super(settings);
        this.spreader = new MultifaceSpreader(this);
        this.registerDefaultState(this.defaultBlockState()
            .setValue(AGE, 7)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AGE); // Register the age property
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) > 0; // Only tick if age is greater than 0
    }
	

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		int age = state.getValue(AGE);
		//System.out.println("Current age: " + age);

		// Only proceed if age is greater than 0
		if (age > 0) {

			if (random.nextFloat() < 0.3F) { // Adjust probability as needed
				// Update the current block's state with decremented age
				world.setBlock(pos, state.setValue(AGE, Math.max(age - 1, 0)), 2);

				// Spread from random face toward random direction
				Optional<MultifaceSpreader.SpreadPos> spreadPosOptional = this.spreader.spreadFromRandomFaceTowardRandomDirection(state, world, pos, random);
				
				// If spreading was successful, update the target block
				spreadPosOptional.ifPresent(spreadPos -> {
					BlockPos targetPos = spreadPos.pos();
					BlockState targetState = world.getBlockState(targetPos);

					// Update the age of the target if it's part of a MultifaceBlock
					if (targetState.is(this)) { // Ensure we are still dealing with DecorIvyPlant
						// Set the new age value at the target position
						world.setBlock(targetPos, targetState.setValue(AGE, Math.max(age - 2, 0)), 2);
					}
				});
			}
		}
	}
	
	
	
	

}
