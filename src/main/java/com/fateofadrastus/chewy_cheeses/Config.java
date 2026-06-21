package com.fateofadrastus.chewy_cheeses;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue USE_CHEESE_TAB = BUILDER
            .comment("Add a tab with all cheeses.")
            .define("useCheeseTab", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
