package com.fateofadrastus.chewy_cheeses.registry;

import com.fateofadrastus.chewy_cheeses.ChewyCheeses;
import com.fateofadrastus.chewy_cheeses.content.block.WardenzolaCheeseWheelBlock;
import net.jadenxgamer.netherexp.registry.JNEItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
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


    // Dungeons Delight
    public static final DeferredBlock<Block> WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> WARDENZOLA_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> WARDENZOLA_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_WARDENZOLA_CHEESE;
    public static final BaseFlowingFluid.Properties WARDENZOLA_CHEESE_FLUID_PROPERTIES;

    // Jaden's Nether Expansion
    public static final DeferredBlock<Block> GLOW_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_GLOW_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_GLOW_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> GLOW_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> GLOW_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> GLOW_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_GLOW_CHEESE;
    public static final BaseFlowingFluid.Properties GLOW_CHEESE_FLUID_PROPERTIES;

    // Environmental
    public static final FoodProperties FLAXEN_CHEESE_PROPERITIES;
    public static final DeferredItem<Item> TRUFFLE_CHEESE_WEDGE;
    public static final DeferredBlock<Block> TRUFFLE_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_TRUFFLE_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> TRUFFLE_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> TRUFFLE_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> TRUFFLE_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_TRUFFLE_CHEESE;
    public static final BaseFlowingFluid.Properties TRUFFLE_CHEESE_FLUID_PROPERTIES;

    static  {
        if (ModList.get().isLoaded("dungeonsdelight")){
            WARDENZOLA_CHEESE_WHEEL = BLOCKS.register("wardenzola_cheese_wheel", () -> new WardenzolaCheeseWheelBlock(DDItems.WARDENZOLA_CRUMBLES, Block.Properties.ofFullCopy(Blocks.CAKE)));
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
        if (ModList.get().isLoaded("netherexp")){
            GLOW_CHEESE_WHEEL =  BLOCKS.register("glow_cheese_wheel", () -> new CheeseWheelBlock(JNEItems.GLOWCHEESE , Block.Properties.ofFullCopy(Blocks.CAKE).lightLevel((p_152607_) -> 15)));
            UNRIPE_GLOW_CHEESE_WHEEL =  BLOCKS.register("unripe_glow_cheese_wheel", () -> new UnripeCheeseWheelBlock(GLOW_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE).lightLevel((p_152607_) -> 10)));
            GLOW_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(GLOW_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
            UNRIPE_GLOW_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_GLOW_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

            GLOW_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("glow_cheese_type", BnCFluidType::new);
            GLOW_CHEESE = FLUIDS.register("glow_cheese", () -> new BaseFlowingFluid.Source(Registry.GLOW_CHEESE_FLUID_PROPERTIES));
            FLOWING_GLOW_CHEESE = FLUIDS.register("flowing_glow_cheese", () -> new BaseFlowingFluid.Flowing(Registry.GLOW_CHEESE_FLUID_PROPERTIES));
            GLOW_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(GLOW_CHEESE_FLUID_TYPE, GLOW_CHEESE, FLOWING_GLOW_CHEESE);

        } else {
            GLOW_CHEESE_WHEEL = null;
            UNRIPE_GLOW_CHEESE_WHEEL = null;
            GLOW_CHEESE_WHEEL_ITEM = null;
            UNRIPE_GLOW_CHEESE_WHEEL_ITEM = null;

            GLOW_CHEESE_FLUID_TYPE = null;
            GLOW_CHEESE = null;
            FLOWING_GLOW_CHEESE = null;
            GLOW_CHEESE_FLUID_PROPERTIES = null;
        }
        if (ModList.get().isLoaded("environmental")) {
            FLAXEN_CHEESE_PROPERITIES = (new FoodProperties.Builder()).nutrition(4).saturationModifier(1.0F).build();
            TRUFFLE_CHEESE_WEDGE = ITEMS.register("truffle_cheese_wedge", () -> new Item((new Item.Properties()).food( FLAXEN_CHEESE_PROPERITIES )));
            TRUFFLE_CHEESE_WHEEL =  BLOCKS.register("truffle_cheese_wheel", () -> new CheeseWheelBlock(TRUFFLE_CHEESE_WEDGE , Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_TRUFFLE_CHEESE_WHEEL =  BLOCKS.register("unripe_truffle_cheese_wheel", () -> new UnripeCheeseWheelBlock(TRUFFLE_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE)));
            TRUFFLE_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(TRUFFLE_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
            UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_TRUFFLE_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

            TRUFFLE_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("truffle_cheese_type", BnCFluidType::new);
            TRUFFLE_CHEESE = FLUIDS.register("truffle_cheese", () -> new BaseFlowingFluid.Source(Registry.TRUFFLE_CHEESE_FLUID_PROPERTIES));
            FLOWING_TRUFFLE_CHEESE = FLUIDS.register("flowing_truffle_cheese", () -> new BaseFlowingFluid.Flowing(Registry.TRUFFLE_CHEESE_FLUID_PROPERTIES));
            TRUFFLE_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(TRUFFLE_CHEESE_FLUID_TYPE, TRUFFLE_CHEESE, FLOWING_TRUFFLE_CHEESE);

        } else {
            FLAXEN_CHEESE_PROPERITIES = null;
            TRUFFLE_CHEESE_WEDGE = null;
            TRUFFLE_CHEESE_WHEEL = null;
            UNRIPE_TRUFFLE_CHEESE_WHEEL = null;
            TRUFFLE_CHEESE_WHEEL_ITEM = null;
            UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM = null;

            TRUFFLE_CHEESE_FLUID_TYPE = null;
            TRUFFLE_CHEESE = null;
            FLOWING_TRUFFLE_CHEESE = null;
            TRUFFLE_CHEESE_FLUID_PROPERTIES = null;
        }
    }
}
