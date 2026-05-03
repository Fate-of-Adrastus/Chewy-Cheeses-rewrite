package com.fateofadrastus.chewy_cheeses.mixin;

import com.fateofadrastus.chewy_cheeses.registry.Registry;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import umpaz.brewinandchewin.integration.jei.CheeseAgingRecipe;

import java.util.ArrayList;
import java.util.List;

@Mixin(umpaz.brewinandchewin.integration.jei.BnCJEIRecipes.class)
public class CheeseAgingRecipeMixin {

    @ModifyReturnValue(method = "getCheeseRecipes", at = @At("TAIL"))
    public List<CheeseAgingRecipe> getOtherCheeseRecipes(List<CheeseAgingRecipe> original){
        if (original == null) original = new ArrayList<>();

        if (Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM != null )
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM.get(), DDItems.WARDENZOLA.get()));
        if (Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM != null && Registry.GLOW_CHEESE_WHEEL_ITEM != null) {
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM.get(), Registry.GLOW_CHEESE_WHEEL_ITEM.get()));
        }

        return original;
    }
}
