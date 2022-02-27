package thelunaticist.siegemod.blockentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thelunaticist.siegemod.SiegeMod;

public class NexusBlockEntity extends BlockEntity {
    BlockPos aboveBlockPos;

    int cooldown = 100;

    public NexusBlockEntity(BlockPos pos, BlockState state){
        super(SiegeMod.NEXUS_BLOCK_ENTITY, pos, state);
        aboveBlockPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
    }

    public static void tick(World world, BlockPos pos, BlockState state, NexusBlockEntity blockEntity){
        if(blockEntity.cooldown == 0){
            assert(blockEntity.world != null);
            blockEntity.world.breakBlock(blockEntity.aboveBlockPos, true);
            blockEntity.cooldown = 100;
        }
        else{
            blockEntity.cooldown--;
        }
    }
}
