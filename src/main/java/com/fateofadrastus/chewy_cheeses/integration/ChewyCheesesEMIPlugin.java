package com.fateofadrastus.chewy_cheeses.integration;

import com.fateofadrastus.chewy_cheeses.ChewyCheeses;
import com.fateofadrastus.chewy_cheeses.registry.Registry;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import net.hardzi.farmerspizzeria.FarmerspizzeriaMod;
import net.hardzi.farmerspizzeria.init.FarmerspizzeriaModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import umpaz.brewinandchewin.integration.emi.recipe.CheeseEmiRecipe;

@EmiEntrypoint
public class ChewyCheesesEMIPlugin implements EmiPlugin {
    public ChewyCheesesEMIPlugin() {
    }

    public void register(EmiRegistry registry){
        if (Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM != null )
            registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/wardenzola"), EmiStack.of(Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM.get()), EmiStack.of(DDItems.WARDENZOLA.get())));

        if (Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM != null && Registry.GLOW_CHEESE_WHEEL_ITEM != null)
            registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/glowcheese"), EmiStack.of(Registry.UNRIPE_GLOW_CHEESE_WHEEL_ITEM.get()), EmiStack.of(Registry.GLOW_CHEESE_WHEEL_ITEM.get())));

        if (ModList.get().isLoaded("farmerspizzeria"))
            registry.addRecipe(new CheeseEmiRecipe(ResourceLocation.fromNamespaceAndPath(FarmerspizzeriaMod.MODID, "/cheese/dorblu"), EmiStack.of(FarmerspizzeriaModBlocks.UNRIPE_DORBLU_CHEESE_WHEEL.asItem()), EmiStack.of(FarmerspizzeriaModBlocks.DORBLU_CHEESE_WHEEL.asItem())));

        if (Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM != null && Registry.TRUFFLE_CHEESE_WHEEL_ITEM != null )
            registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/truffle"), EmiStack.of(Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM.get()), EmiStack.of(Registry.TRUFFLE_CHEESE_WHEEL_ITEM.get())));

        if (Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM != null && Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM != null )
            registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/glowshroom"), EmiStack.of(Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM.get()), EmiStack.of(Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM.get())));

        if (Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM != null && Registry.SHULKER_CHEESE_WHEEL_ITEM != null )
            registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/shulker"), EmiStack.of(Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM.get()), EmiStack.of(Registry.SHULKER_CHEESE_WHEEL_ITEM.get())));

        registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/pitcher"), EmiStack.of(Registry.UNRIPE_PITCHER_CHEESE_WHEEL_ITEM.get()), EmiStack.of(Registry.PITCHER_CHEESE_WHEEL_ITEM.get())));
    }
}
