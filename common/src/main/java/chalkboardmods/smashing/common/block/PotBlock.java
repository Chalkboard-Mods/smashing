package chalkboardmods.smashing.common.block;

import chalkboardmods.smashing.core.other.SmashingSoundTypes;
import chalkboardmods.smashing.core.registry.SmashingBlocks;
import chalkboardmods.smashing.core.registry.SmashingSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class PotBlock extends FallingBlock {
    public PotBlock(Properties properties) {
        super(properties);
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        return SmashingSoundTypes.POT.get();
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos pos = hit.getBlockPos();
        Random random = new Random();
        level.removeBlock(pos, false);
        this.spawnDestroyParticles(level, null, pos, state);
        dropResources(state, level, pos);
        level.addAlwaysVisibleParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.035D, 0.0D);
        level.playSound((Player) null, pos, SmashingSounds.POT_SMASH.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    @Override
    public void onLand(Level level, BlockPos pos, BlockState blockState, BlockState blockState2, FallingBlockEntity fallingBlock) {
        Random random = new Random();

        if (!level.getBlockState(pos.below()).is(BlockTags.WOOL)) {
            level.removeBlock(pos, false);
            this.spawnDestroyParticles(level, null, pos, blockState);
            dropResources(blockState, level, pos);
            level.addAlwaysVisibleParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.035D, 0.0D);
            level.playSound((Player) null, pos, SmashingSounds.POT_SMASH.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack) {
        Random random = new Random();
        int i = 0;
        if (random.nextBoolean()) {
            i = random.nextInt(5);
        }
        super.popExperience(level, pos, i);
    }

    public static final VoxelShape SHAPE = Shapes.join(Shapes.join(Block.box(4, 7, 4, 12, 9, 12), Block.box(5, 6, 5, 11, 7, 11), BooleanOp.OR), Block.box(4, 0, 4, 12, 6, 12), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
