package thelunaticist.siegemod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thelunaticist.siegemod.SiegeMod;
import thelunaticist.siegemod.blockentities.NexusBlockEntity;

public class Nexus extends BlockWithEntity {
    public Nexus(Settings settings){
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state){
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new NexusBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return checkType(type, SiegeMod.NEXUS_BLOCK_ENTITY, NexusBlockEntity::tick);
    }

    @Override
    @SuppressWarnings(value = "deprecation")
    public ActionResult  onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(!world.isClient) {
            SiegeMod.LOGGER.info("block was used");
        }
        return ActionResult.SUCCESS;
    }


}
