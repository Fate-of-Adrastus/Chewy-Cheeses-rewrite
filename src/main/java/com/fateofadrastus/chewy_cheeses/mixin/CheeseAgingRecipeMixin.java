package com.fateofadrastus.chewy_cheeses.mixin;

import com.fateofadrastus.chewy_cheeses.registry.Registry;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import umpaz.brewinandchewin.integration.jei.CheeseAgingRecipe;

import java.util.ArrayList;
import java.util.List;

@Mixin(umpaz.brewinandchewin.integration.jei.BnCJEIRecipes.class)
public class CheeseAgingRecipeMixin {

    @Unique
    private void chewy_Cheeses_rewrite$addIfPresent(List<CheeseAgingRecipe> registry, Item before, Item after){
        if (before != null && after != null){
            registry.add(new CheeseAgingRecipe(before, after));
        }
    }
    @Unique
    private <T extends Item> void chewy_Cheeses_rewrite$addIfPresent(List<CheeseAgingRecipe> registry, DeferredItem<T> before, Item after){
        if (before != null && after != null){
            chewy_Cheeses_rewrite$addIfPresent(registry, before.get(), after);
        }
    }
    @Unique
    private <T extends Item> void chewy_Cheeses_rewrite$addIfPresent(List<CheeseAgingRecipe> registry, Item before, DeferredItem<T> after){
        if (before != null && after != null){
            chewy_Cheeses_rewrite$addIfPresent(registry, before, after.get());
        }
    }
    @Unique
    private <T extends Item> void chewy_Cheeses_rewrite$addIfPresent(List<CheeseAgingRecipe> registry, DeferredItem<T> before, DeferredItem<T> after){
        if (before != null && after != null){
            chewy_Cheeses_rewrite$addIfPresent(registry, before.get(), after.get());
        }
    }

    @ModifyReturnValue(method = "getCheeseRecipes", at = @At("TAIL"))
    public List<CheeseAgingRecipe> getOtherCheeseRecipes(List<CheeseAgingRecipe> registry){
        if (registry == null) registry = new ArrayList<>();

        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_PITCHER_CHEESE_WHEEL_ITEM, Registry.PITCHER_CHEESE_WHEEL_ITEM);
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM, Registry.getWardenzolaCheeseWheelItem());
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM, Registry.GLOW_CHEESE_WHEEL_ITEM);
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.getUnripeDorbluCheeseWheelItem(), Registry.getDorbluCheeseWheelItem());
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM, Registry.TRUFFLE_CHEESE_WHEEL_ITEM);
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM, Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM);
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM, Registry.SHULKER_CHEESE_WHEEL_ITEM);
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM, Registry.FRAGRANT_CHEESE_WHEEL_ITEM);
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.getUnripeCheddarCheeseWheelItem(), Registry.getCheddarCheeseWheelItem());
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.getUnripeGoatCheeseWheelItem(), Registry.getGoatCheeseWheelItem());
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.getUnripeTandTCheeseWheelItem(), Registry.getTandTCheeseWheelItem());
        chewy_Cheeses_rewrite$addIfPresent(registry, Registry.getUnripeTandTCherryCheeseWheelItem(), Registry.getTandTCherryCheeseWheelItem());

        return registry;
    }
}
