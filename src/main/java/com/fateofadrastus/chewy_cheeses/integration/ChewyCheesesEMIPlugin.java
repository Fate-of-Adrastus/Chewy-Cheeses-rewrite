package com.fateofadrastus.chewy_cheeses.integration;

import com.fateofadrastus.chewy_cheeses.ChewyCheeses;
import com.fateofadrastus.chewy_cheeses.registry.Registry;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import umpaz.brewinandchewin.integration.emi.recipe.CheeseEmiRecipe;

@EmiEntrypoint
public class ChewyCheesesEMIPlugin implements EmiPlugin {
    public ChewyCheesesEMIPlugin() {
    }

    private void addIfPresent(EmiRegistry registry, String name, Item before, Item after){
        if (before != null && after != null && !name.isEmpty()){
            registry.addRecipe( new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/" + name), EmiStack.of(before), EmiStack.of(after)));
        }
    }
    private <T extends Item> void addIfPresent(EmiRegistry registry, String name, DeferredItem<T> before, Item after){
        if (before != null && after != null){
            addIfPresent(registry, name, before.get(), after);
        }
    }
    private <T extends Item> void addIfPresent(EmiRegistry registry, String name, Item before, DeferredItem<T> after){
        if (before != null && after != null){
            addIfPresent(registry, name, before, after.get());
        }
    }
    private <T extends Item> void addIfPresent(EmiRegistry registry, String name, DeferredItem<T> before, DeferredItem<T> after){
        if (before != null && after != null){
            addIfPresent(registry, name, before.get(), after.get());
        }
    }

    public void register(EmiRegistry registry){

        addIfPresent(registry, "pitcher", Registry.UNRIPE_PITCHER_CHEESE_WHEEL_ITEM, Registry.PITCHER_CHEESE_WHEEL_ITEM);
        addIfPresent(registry, "wardenzola", Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM, Registry.getWardenzolaCheeseWheelItem());
        addIfPresent(registry, "glowcheese", Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM, Registry.GLOW_CHEESE_WHEEL_ITEM);
        addIfPresent(registry, "dorblu", Registry.getUnripeDorbluCheeseWheelItem(), Registry.getDorbluCheeseWheelItem());
        addIfPresent(registry, "truffle", Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM, Registry.TRUFFLE_CHEESE_WHEEL_ITEM);
        addIfPresent(registry, "glowshroom", Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM, Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM);
        addIfPresent(registry, "shulker", Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM, Registry.SHULKER_CHEESE_WHEEL_ITEM);
        addIfPresent(registry, "fragrant", Registry.UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM, Registry.FRAGRANT_CHEESE_WHEEL_ITEM);
        addIfPresent(registry, "cheddar", Registry.getUnripeCheddarCheeseWheelItem(), Registry.getCheddarCheeseWheelItem());
        addIfPresent(registry, "goat", Registry.getUnripeGoatCheeseWheelItem(), Registry.getGoatCheeseWheelItem());
    }
}
