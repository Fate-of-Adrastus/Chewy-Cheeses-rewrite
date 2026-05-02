package com.fateofadrastus.chewy_cheeses;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.*;
import net.yirmiri.dungeonsdelight.common.util.DDProperties;
import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import umpaz.brewinandchewin.common.block.CheeseWheelBlock;
import umpaz.brewinandchewin.common.block.UnripeCheeseWheelBlock;
import umpaz.brewinandchewin.neoforge.fluid.BnCFluidType;

public class Registry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ChewyCheeses.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChewyCheeses.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID ,ChewyCheeses.MODID);
    public static final DeferredRegister<FluidType> FLUIDS_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES,ChewyCheeses.MODID);

    // dungeons delight
    public static final DeferredBlock<Block> WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> WARDENZOLA_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> WARDENZOLA_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_WARDENZOLA_CHEESE;
    public static final BaseFlowingFluid.Properties WARDENZOLA_CHEESE_FLUID_PROPERTIES;

    static  {
        if (ModList.get().isLoaded("dungeonsdelight")){
            WARDENZOLA_CHEESE_WHEEL = BLOCKS.register("wardenzola_cheese_wheel", () -> new CheeseWheelBlock(DDItems.WARDENZOLA_CRUMBLES, Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_WARDENZOLA_CHEESE_WHEEL = BLOCKS.register("unripe_wardenzola_cheese_wheel", () -> new UnripeCheeseWheelBlock(WARDENZOLA_CHEESE_WHEEL, Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(UNRIPE_WARDENZOLA_CHEESE_WHEEL,new Item.Properties().stacksTo(16).rarity(DDProperties.MONSTER));

            WARDENZOLA_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("wardenzola_cheese_type", BnCFluidType::new);
            WARDENZOLA_CHEESE = FLUIDS.register("wardenzola_cheese", () -> new BaseFlowingFluid.Source(Registry.WARDENZOLA_CHEESE_FLUID_PROPERTIES));
            FLOWING_WARDENZOLA_CHEESE = FLUIDS.register("flowing_wardenzola_cheese", () -> new BaseFlowingFluid.Flowing(Registry.WARDENZOLA_CHEESE_FLUID_PROPERTIES));
            WARDENZOLA_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(WARDENZOLA_CHEESE_FLUID_TYPE, WARDENZOLA_CHEESE, FLOWING_WARDENZOLA_CHEESE);
        } else {
            WARDENZOLA_CHEESE_WHEEL = null;
            UNRIPE_WARDENZOLA_CHEESE_WHEEL = null;
            UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM = null;

            WARDENZOLA_CHEESE_FLUID_TYPE = null;
            WARDENZOLA_CHEESE = null;
            FLOWING_WARDENZOLA_CHEESE = null;
            WARDENZOLA_CHEESE_FLUID_PROPERTIES = null;
        }
    }
}
