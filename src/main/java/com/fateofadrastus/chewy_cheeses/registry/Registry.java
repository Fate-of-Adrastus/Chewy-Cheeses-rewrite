package com.fateofadrastus.chewy_cheeses.registry;

import com.fateofadrastus.chewy_cheeses.ChewyCheeses;
import com.fateofadrastus.chewy_cheeses.content.block.WardenzolaCheeseWheelBlock;
import net.hardzi.farmerspizzeria.init.FarmerspizzeriaModItems;
import net.jadenxgamer.netherexp.registry.JNEItems;
import net.mcreator.sniffer.item.S9Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
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
import net.mcreator.sniffer.init.SnifferModItems;

import static net.mcreator.sniffer.init.SnifferModItems.S_9;

public class Registry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ChewyCheeses.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChewyCheeses.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID ,ChewyCheeses.MODID);
    public static final DeferredRegister<FluidType> FLUIDS_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES,ChewyCheeses.MODID);

    // Farmer's Pizzeria
    public static Item getDorbluCheeseWheelItem(){ return FarmerspizzeriaModItems.DORBLU_CHEESE_WHEEL.asItem(); }
    public static Item getUnripeDorbluCheeseWheelItem(){ return FarmerspizzeriaModItems.UNRIPE_DORBLU_CHEESE_WHEEL.asItem(); }

    // Dungeons Delight
    public static final DeferredBlock<Block> WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM;
    public static Item getWardenzolaCheeseWheelItem(){ return DDItems.WARDENZOLA.get(); }

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
    public static final FoodProperties TRUFFLE_CHEESE_PROPERITIES;
    public static final DeferredItem<Item> TRUFFLE_CHEESE_WEDGE;
    public static final DeferredBlock<Block> TRUFFLE_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_TRUFFLE_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> TRUFFLE_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> TRUFFLE_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> TRUFFLE_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_TRUFFLE_CHEESE;
    public static final BaseFlowingFluid.Properties TRUFFLE_CHEESE_FLUID_PROPERTIES;

    // Quark / Darker depths
    public static final FoodProperties GLOWSHROOM_CHEESE_PROPERITIES;
    public static final DeferredItem<Item> GLOWSHROOM_CHEESE_WEDGE;
    public static final DeferredBlock<Block> GLOWSHROOM_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_GLOWSHROOM_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> GLOWSHROOM_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> GLOWSHROOM_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> GLOWSHROOM_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_GLOWSHROOM_CHEESE;
    public static final BaseFlowingFluid.Properties GLOWSHROOM_CHEESE_FLUID_PROPERTIES;

    // Ender's delight
    public static final FoodProperties SHULKER_CHEESE_PROPERITIES;
    public static final DeferredItem<Item> SHULKER_CHEESE_WEDGE;
    public static final DeferredBlock<Block> SHULKER_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_SHULKER_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_SHULKER_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> SHULKER_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> SHULKER_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SHULKER_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_SHULKER_CHEESE;
    public static final BaseFlowingFluid.Properties SHULKER_CHEESE_FLUID_PROPERTIES;

    // Sniffer Delicacies
    public static final DeferredBlock<Block> FRAGRANT_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_FRAGRANT_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> FRAGRANT_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> FRAGRANT_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> FRAGRANT_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_FRAGRANT_CHEESE;
    public static final BaseFlowingFluid.Properties FRAGRANT_CHEESE_FLUID_PROPERTIES;

    public static final DeferredHolder<FluidType, FluidType> SNIFFERS_MILK_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SNIFFERS_MILK;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_SNIFFERS_MILK;
    public static final BaseFlowingFluid.Properties SNIFFERS_MILK_FLUID_PROPERTIES;




    // minecraft
    public static final FoodProperties PITCHER_CHEESE_PROPERITIES;
    public static final DeferredItem<Item> PITCHER_CHEESE_WEDGE;
    public static final DeferredBlock<Block> PITCHER_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_PITCHER_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_PITCHER_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> PITCHER_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> PITCHER_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> PITCHER_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_PITCHER_CHEESE;
    public static final BaseFlowingFluid.Properties PITCHER_CHEESE_FLUID_PROPERTIES;

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
            TRUFFLE_CHEESE_PROPERITIES = (new FoodProperties.Builder()).nutrition(4).saturationModifier(1.0F).build();
            TRUFFLE_CHEESE_WEDGE = ITEMS.register("truffle_cheese_wedge", () -> new Item((new Item.Properties()).food( TRUFFLE_CHEESE_PROPERITIES )));
            TRUFFLE_CHEESE_WHEEL =  BLOCKS.register("truffle_cheese_wheel", () -> new CheeseWheelBlock(TRUFFLE_CHEESE_WEDGE , Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_TRUFFLE_CHEESE_WHEEL =  BLOCKS.register("unripe_truffle_cheese_wheel", () -> new UnripeCheeseWheelBlock(TRUFFLE_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE)));
            TRUFFLE_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(TRUFFLE_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
            UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_TRUFFLE_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

            TRUFFLE_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("truffle_cheese_type", BnCFluidType::new);
            TRUFFLE_CHEESE = FLUIDS.register("truffle_cheese", () -> new BaseFlowingFluid.Source(Registry.TRUFFLE_CHEESE_FLUID_PROPERTIES));
            FLOWING_TRUFFLE_CHEESE = FLUIDS.register("flowing_truffle_cheese", () -> new BaseFlowingFluid.Flowing(Registry.TRUFFLE_CHEESE_FLUID_PROPERTIES));
            TRUFFLE_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(TRUFFLE_CHEESE_FLUID_TYPE, TRUFFLE_CHEESE, FLOWING_TRUFFLE_CHEESE);

        } else {
            TRUFFLE_CHEESE_PROPERITIES = null;
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
        if (ModList.get().isLoaded("quark") || ModList.get().isLoaded("darkerdepths")){
            GLOWSHROOM_CHEESE_PROPERITIES = (new FoodProperties.Builder()).nutrition(4).saturationModifier(1.0F).build();
            GLOWSHROOM_CHEESE_WEDGE = ITEMS.register("glowshroom_cheese_wedge", () -> new Item((new Item.Properties()).food( GLOWSHROOM_CHEESE_PROPERITIES )));
            GLOWSHROOM_CHEESE_WHEEL =  BLOCKS.register("glowshroom_cheese_wheel", () -> new CheeseWheelBlock(GLOWSHROOM_CHEESE_WEDGE , Block.Properties.ofFullCopy(Blocks.CAKE).sound(SoundType.SLIME_BLOCK).lightLevel((p_152607_) -> 10)));
            UNRIPE_GLOWSHROOM_CHEESE_WHEEL =  BLOCKS.register("unripe_glowshroom_cheese_wheel", () -> new UnripeCheeseWheelBlock(GLOWSHROOM_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE).lightLevel((p_152607_) -> 1)));
            GLOWSHROOM_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(GLOWSHROOM_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
            UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_GLOWSHROOM_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

            GLOWSHROOM_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("glowshroom_cheese_type", BnCFluidType::new);
            GLOWSHROOM_CHEESE = FLUIDS.register("glowshroom_cheese", () -> new BaseFlowingFluid.Source(Registry.GLOWSHROOM_CHEESE_FLUID_PROPERTIES));
            FLOWING_GLOWSHROOM_CHEESE = FLUIDS.register("flowing_glowshroom_cheese", () -> new BaseFlowingFluid.Flowing(Registry.GLOWSHROOM_CHEESE_FLUID_PROPERTIES));
            GLOWSHROOM_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(GLOWSHROOM_CHEESE_FLUID_TYPE, GLOWSHROOM_CHEESE, FLOWING_GLOWSHROOM_CHEESE);

        } else {
            GLOWSHROOM_CHEESE_PROPERITIES = null;
            GLOWSHROOM_CHEESE_WEDGE = null;
            GLOWSHROOM_CHEESE_WHEEL = null;
            UNRIPE_GLOWSHROOM_CHEESE_WHEEL = null;
            GLOWSHROOM_CHEESE_WHEEL_ITEM = null;
            UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM = null;

            GLOWSHROOM_CHEESE_FLUID_TYPE = null;
            GLOWSHROOM_CHEESE = null;
            FLOWING_GLOWSHROOM_CHEESE = null;
            GLOWSHROOM_CHEESE_FLUID_PROPERTIES = null;
        }
        if (ModList.get().isLoaded("endersdelight")){
            SHULKER_CHEESE_PROPERITIES = (new FoodProperties.Builder()).nutrition(4).saturationModifier(1.0F).effect( () -> new MobEffectInstance(MobEffects.LEVITATION, 100, 0, false, false), 1.0F).alwaysEdible().build();
            SHULKER_CHEESE_WEDGE = ITEMS.register("shulker_cheese_wedge", () -> new Item((new Item.Properties()).food( SHULKER_CHEESE_PROPERITIES )));
            SHULKER_CHEESE_WHEEL =  BLOCKS.register("shulker_cheese_wheel", () -> new CheeseWheelBlock(SHULKER_CHEESE_WEDGE , Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_SHULKER_CHEESE_WHEEL =  BLOCKS.register("unripe_shulker_cheese_wheel", () -> new UnripeCheeseWheelBlock(SHULKER_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE)));
            SHULKER_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(SHULKER_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
            UNRIPE_SHULKER_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_SHULKER_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

            SHULKER_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("shulker_cheese_type", BnCFluidType::new);
            SHULKER_CHEESE = FLUIDS.register("shulker_cheese", () -> new BaseFlowingFluid.Source(Registry.SHULKER_CHEESE_FLUID_PROPERTIES));
            FLOWING_SHULKER_CHEESE = FLUIDS.register("flowing_shulker_cheese", () -> new BaseFlowingFluid.Flowing(Registry.SHULKER_CHEESE_FLUID_PROPERTIES));
            SHULKER_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(SHULKER_CHEESE_FLUID_TYPE, SHULKER_CHEESE, FLOWING_SHULKER_CHEESE);

        } else {
            SHULKER_CHEESE_PROPERITIES = null;
            SHULKER_CHEESE_WEDGE = null;
            SHULKER_CHEESE_WHEEL = null;
            UNRIPE_SHULKER_CHEESE_WHEEL = null;
            SHULKER_CHEESE_WHEEL_ITEM = null;
            UNRIPE_SHULKER_CHEESE_WHEEL_ITEM = null;

            SHULKER_CHEESE_FLUID_TYPE = null;
            SHULKER_CHEESE = null;
            FLOWING_SHULKER_CHEESE = null;
            SHULKER_CHEESE_FLUID_PROPERTIES = null;
        }
        if (ModList.get().isLoaded("sniffer")) {
            FRAGRANT_CHEESE_WHEEL =  BLOCKS.register("fragrant_cheese_wheel", () -> new CheeseWheelBlock(S_9, Block.Properties.ofFullCopy(Blocks.CAKE))); // s_9 is the cheese wedge item
            UNRIPE_FRAGRANT_CHEESE_WHEEL =  BLOCKS.register("unripe_fragrant_cheese_wheel", () -> new UnripeCheeseWheelBlock(FRAGRANT_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE)));
            FRAGRANT_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(FRAGRANT_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
            UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_FRAGRANT_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

            FRAGRANT_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("fragrant_cheese_type", BnCFluidType::new);
            FRAGRANT_CHEESE = FLUIDS.register("fragrant_cheese", () -> new BaseFlowingFluid.Source(Registry.FRAGRANT_CHEESE_FLUID_PROPERTIES));
            FLOWING_FRAGRANT_CHEESE = FLUIDS.register("flowing_fragrant_cheese", () -> new BaseFlowingFluid.Flowing(Registry.FRAGRANT_CHEESE_FLUID_PROPERTIES));
            FRAGRANT_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(FRAGRANT_CHEESE_FLUID_TYPE, FRAGRANT_CHEESE, FLOWING_FRAGRANT_CHEESE);

            SNIFFERS_MILK_FLUID_TYPE = FLUIDS_TYPES.register("sniffers_milk_type", BnCFluidType::new);
            SNIFFERS_MILK = FLUIDS.register("sniffers_milk", () -> new BaseFlowingFluid.Source(Registry.SNIFFERS_MILK_FLUID_PROPERTIES));
            FLOWING_SNIFFERS_MILK = FLUIDS.register("flowing_sniffers_milk", () -> new BaseFlowingFluid.Flowing(Registry.SNIFFERS_MILK_FLUID_PROPERTIES));
            SNIFFERS_MILK_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(SNIFFERS_MILK_FLUID_TYPE, SNIFFERS_MILK, FLOWING_SNIFFERS_MILK);



        } else {
            FRAGRANT_CHEESE_WHEEL = null;
            UNRIPE_FRAGRANT_CHEESE_WHEEL = null;
            FRAGRANT_CHEESE_WHEEL_ITEM = null;
            UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM = null;

            FRAGRANT_CHEESE_FLUID_TYPE = null;
            FRAGRANT_CHEESE = null;
            FLOWING_FRAGRANT_CHEESE = null;
            FRAGRANT_CHEESE_FLUID_PROPERTIES = null;

            SNIFFERS_MILK_FLUID_TYPE = null;
            SNIFFERS_MILK = null;
            FLOWING_SNIFFERS_MILK = null;
            SNIFFERS_MILK_FLUID_PROPERTIES = null;
        }



        PITCHER_CHEESE_PROPERITIES = (new FoodProperties.Builder()).nutrition(4).saturationModifier(1.0F).build();
        PITCHER_CHEESE_WEDGE = ITEMS.register("pitcher_cheese_wedge", () -> new Item((new Item.Properties()).food( PITCHER_CHEESE_PROPERITIES )));
        PITCHER_CHEESE_WHEEL =  BLOCKS.register("pitcher_cheese_wheel", () -> new CheeseWheelBlock(PITCHER_CHEESE_WEDGE , Block.Properties.ofFullCopy(Blocks.CAKE)));
        UNRIPE_PITCHER_CHEESE_WHEEL =  BLOCKS.register("unripe_pitcher_cheese_wheel", () -> new UnripeCheeseWheelBlock(PITCHER_CHEESE_WHEEL , Block.Properties.ofFullCopy(Blocks.CAKE)));
        PITCHER_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(PITCHER_CHEESE_WHEEL, new Item.Properties().stacksTo(16));
        UNRIPE_PITCHER_CHEESE_WHEEL_ITEM =  ITEMS.registerSimpleBlockItem(UNRIPE_PITCHER_CHEESE_WHEEL, new Item.Properties().stacksTo(16));

        PITCHER_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("pitcher_cheese_type", BnCFluidType::new);
        PITCHER_CHEESE = FLUIDS.register("pitcher_cheese", () -> new BaseFlowingFluid.Source(Registry.PITCHER_CHEESE_FLUID_PROPERTIES));
        FLOWING_PITCHER_CHEESE = FLUIDS.register("flowing_pitcher_cheese", () -> new BaseFlowingFluid.Flowing(Registry.PITCHER_CHEESE_FLUID_PROPERTIES));
        PITCHER_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(PITCHER_CHEESE_FLUID_TYPE, PITCHER_CHEESE, FLOWING_PITCHER_CHEESE);

    }
}
