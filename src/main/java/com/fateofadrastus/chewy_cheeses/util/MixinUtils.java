package com.fateofadrastus.chewy_cheeses.util;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class MixinUtils {
    public static InteractionResult placeCheese(BlockPlaceContext placeContext, Block blockToPlace){
        if (placeContext == null || !placeContext.canPlace()) return InteractionResult.FAIL;

        BlockState blockState = blockToPlace.getStateForPlacement(placeContext);
        if (blockState == null ) return  InteractionResult.FAIL;

        BlockPos blockPos = placeContext.getClickedPos();
        Level world = placeContext.getLevel();
        if (!world.setBlock(blockPos, blockState, 11))
            return InteractionResult.FAIL;

        ItemStack itemStack = placeContext.getItemInHand();
        Player playerEntity = placeContext.getPlayer();
        SoundType blockSoundGroup = blockToPlace.getSoundType(blockToPlace.defaultBlockState(),world,blockPos,playerEntity);

        itemStack.consume(1, playerEntity);
        world.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(playerEntity, blockState));
        world.playSound(playerEntity,
                blockPos,
                blockSoundGroup.getPlaceSound(),
                SoundSource.BLOCKS,
                blockSoundGroup.getVolume(),
                blockSoundGroup.getPitch()
        );

        return InteractionResult.SUCCESS;
    }
}
