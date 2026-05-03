package com.fateofadrastus.chewy_cheeses.content.block;

import net.minecraft.world.item.Item;
import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import org.jetbrains.annotations.NotNull;
import umpaz.brewinandchewin.common.block.CheeseWheelBlock;

import java.util.function.Supplier;

public class WardenzolaCheeseWheelBlock extends CheeseWheelBlock {

    public WardenzolaCheeseWheelBlock(Supplier<Item> cheeseWedgeType, Properties properties) {
        super(cheeseWedgeType, properties);
    }

    @Override
    public @NotNull Item asItem() {
        return DDItems.WARDENZOLA.get();
    }
}
