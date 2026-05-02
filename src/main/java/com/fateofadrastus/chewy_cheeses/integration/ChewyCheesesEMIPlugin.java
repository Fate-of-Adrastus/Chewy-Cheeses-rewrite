package com.fateofadrastus.chewy_cheeses.integration;

import com.fateofadrastus.chewy_cheeses.ChewyCheeses;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import umpaz.brewinandchewin.integration.emi.recipe.CheeseEmiRecipe;

@EmiEntrypoint
public class ChewyCheesesEMIPlugin implements EmiPlugin {
    public ChewyCheesesEMIPlugin() {
    }

    public void register(EmiRegistry registry){
        if (ChewyCheeses.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM != null )
            registry.addRecipe(new CheeseEmiRecipe(ChewyCheeses.getResourceLocation("/cheese/wardenzola"), EmiStack.of(ChewyCheeses.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM.get()), EmiStack.of(DDItems.WARDENZOLA.get())));

    }
}
