package chalkboardmods.smashing.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LargePotBlock extends PotBlock{
    public LargePotBlock(Properties properties) {
        super(properties);
    }

    public static final VoxelShape SHAPE = Shapes.join(Shapes.join(Block.box(2, 0, 2, 14, 6, 14), Block.box(4, 6, 4, 12, 7, 12), BooleanOp.OR), Block.box(3, 7, 3, 13, 9, 13), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
