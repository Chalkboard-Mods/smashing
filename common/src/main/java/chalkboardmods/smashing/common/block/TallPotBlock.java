package chalkboardmods.smashing.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TallPotBlock extends PotBlock{
    public TallPotBlock(Properties properties) {
        super(properties);
    }

    public static final VoxelShape SHAPE = Shapes.join(Shapes.join(Block.box(5, 0, 5, 11, 12, 11), Block.box(6, 12, 6, 10, 13, 10), BooleanOp.OR), Block.box(5, 13, 5, 11, 15, 11), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
