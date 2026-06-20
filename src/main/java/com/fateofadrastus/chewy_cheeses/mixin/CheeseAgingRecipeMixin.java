package com.fateofadrastus.chewy_cheeses.mixin;

import com.fateofadrastus.chewy_cheeses.registry.Registry;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.neoforged.fml.ModList;
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

        if (ModList.get().isLoaded("dungeonsdelight") && Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM != null )
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM.get(), Registry.getWardenzolaCheeseWheelItem()));
        if (Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM != null && Registry.GLOW_CHEESE_WHEEL_ITEM != null)
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM.get(), Registry.GLOW_CHEESE_WHEEL_ITEM.get()));
        if (ModList.get().isLoaded("farmerspizzeria"))
            original.add(new CheeseAgingRecipe(Registry.getDorbluCheeseWheelItem(), Registry.getUnripeDorbluCheeseWheelItem()));
        if (Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM != null && Registry.TRUFFLE_CHEESE_WHEEL_ITEM != null)
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM.get(), Registry.TRUFFLE_CHEESE_WHEEL_ITEM.get()));
        if (Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM != null && Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM != null)
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM.get(), Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM.get()));
        if (Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM != null && Registry.SHULKER_CHEESE_WHEEL_ITEM != null)
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM.get(), Registry.SHULKER_CHEESE_WHEEL_ITEM.get()));
        if (Registry.UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM != null && Registry.FRAGRANT_CHEESE_WHEEL_ITEM != null)
            original.add(new CheeseAgingRecipe(Registry.UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM.get(), Registry.FRAGRANT_CHEESE_WHEEL_ITEM.get()));

        original.add(new CheeseAgingRecipe(Registry.UNRIPE_PITCHER_CHEESE_WHEEL_ITEM.get(), Registry.PITCHER_CHEESE_WHEEL_ITEM.get()));

        return original;
    }
}
