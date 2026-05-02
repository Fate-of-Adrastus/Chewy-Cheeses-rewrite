package com.fateofadrastus.chewy_cheeses.mixin;

import com.fateofadrastus.chewy_cheeses.Registry;
import com.fateofadrastus.chewy_cheeses.util.MixinUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.fml.ModList;
import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class PlaceWardenzolaMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    public void onPlaceWardenzola(UseOnContext context, CallbackInfoReturnable<InteractionResult> callbackInfo){
        if ( Registry.WARDENZOLA_CHEESE_WHEEL != null && context.getItemInHand().is(DDItems.WARDENZOLA.get())){
            callbackInfo.setReturnValue(MixinUtils.placeCheese(new BlockPlaceContext(context), Registry.WARDENZOLA_CHEESE_WHEEL.get()));
        }
    }

}
