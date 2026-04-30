package com.fateofadrastus.chewy_cheeses;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = ChewyCheeses.MODID, value = Dist.CLIENT )
public class ClientEvents {

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        if (ModList.get().isLoaded("dungeonsdelight")) {
            event.registerFluidType(new IClientFluidTypeExtensions() {
                public @NotNull ResourceLocation getStillTexture() {
                    return ChewyCheeses.getResourceLocation("block/wardenzola_cheese_still");
                }

                public @NotNull ResourceLocation getFlowingTexture() {
                    return ChewyCheeses.getResourceLocation("block/wardenzola_cheese_flow");
                }
            }, new FluidType[]{ChewyCheeses.WARDENZOLA_CHEESE_FLUID_TYPE.get()});
        }
    }
}
