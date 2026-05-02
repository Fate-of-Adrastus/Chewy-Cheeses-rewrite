package com.fateofadrastus.chewy_cheeses.util;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;

public class MixinUtils {

    public static InteractionResult placeCheese(BlockPlaceContext placeContext, Block blockToPlace){
        Level level = placeContext.getLevel();
        if (!blockToPlace.isEnabled(level.enabledFeatures()) || !placeContext.canPlace()) return InteractionResult.FAIL;

        BlockState blockState = MixinUtils.getPlacementState(placeContext, blockToPlace);
        if (blockState == null ) return  InteractionResult.FAIL;

        BlockPos blockPos = placeContext.getClickedPos();
        if (!level.setBlock(blockPos, blockState, 11))
            return InteractionResult.FAIL;

        ItemStack itemStack = placeContext.getItemInHand();
        Player player = placeContext.getPlayer();
        SoundType soundType = blockToPlace.getSoundType(blockToPlace.defaultBlockState(),level,blockPos,player);

        BlockItem.updateCustomBlockEntityTag( level, player,blockPos, itemStack);
        blockToPlace.setPlacedBy(level, blockPos, blockState, player, itemStack);
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
        }

        itemStack.consume(1, player);
        level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(player, blockState));
        level.playSound(
                player,
                blockPos,
                soundType.getPlaceSound(),
                SoundSource.BLOCKS,
                (soundType.getVolume() + 1.0F) / 2.0F,
                soundType.getPitch() * 0.8F
        );

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
    private static BlockState getPlacementState(BlockPlaceContext placeContext, Block blockToPlace){
        BlockState blockstate = blockToPlace.getStateForPlacement(placeContext);
        return blockstate != null && canPlace(placeContext, blockstate) ? blockstate : null;
    }
    private static boolean canPlace(BlockPlaceContext context, BlockState state) {
        Player player = context.getPlayer();
        CollisionContext collisioncontext = player == null ? CollisionContext.empty() : CollisionContext.of(player);
        return (state.canSurvive(context.getLevel(), context.getClickedPos()))
                && context.getLevel().isUnobstructed(state, context.getClickedPos(), collisioncontext);
    }

}
