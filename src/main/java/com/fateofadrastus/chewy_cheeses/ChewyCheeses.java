package com.fateofadrastus.chewy_cheeses;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import umpaz.brewinandchewin.BrewinAndChewin;
import umpaz.brewinandchewin.common.block.CheeseWheelBlock;
import umpaz.brewinandchewin.common.block.UnripeCheeseWheelBlock;

import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import net.yirmiri.dungeonsdelight.common.util.DDProperties;
import umpaz.brewinandchewin.neoforge.fluid.BnCFluidType;

import java.util.function.Supplier;

@Mod(ChewyCheeses.MODID)
public class ChewyCheeses {
    public static final String MODID = "chewy_cheeses";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID ,MODID);
    public static final DeferredRegister<FluidType> FLUIDS_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES,MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    /* ----------------------------------------------notes for adding a new cheese ----------------------------------------------------

    register block
    register unripe block
    register item for blocks
    add new cheese fluid type to cheese fluid
    register fluid
    block states
    block models
    coster model (in brewin and chewin file) - it is just the corner of cheese to go on a coaster, uses the cheese slice item from the mods
    fluid item display
    lang
    block textures
    recipes
    tags

     ---------------------------------------------------------------------------------------------------------------------------------*/

    // dungeons delight
    public static final DeferredBlock<Block> WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredBlock<Block> UNRIPE_WARDENZOLA_CHEESE_WHEEL;
    public static final DeferredItem<BlockItem> UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM;
    public static final DeferredItem<BlockItem> WARDENZOLA_CHEESE_WHEEL_ITEM;

    public static final DeferredHolder<FluidType, FluidType> WARDENZOLA_CHEESE_FLUID_TYPE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> WARDENZOLA_CHEESE;
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_WARDENZOLA_CHEESE;
    public static final BaseFlowingFluid.Properties WARDENZOLA_CHEESE_FLUID_PROPERTIES;

    static {
        if (ModList.get().isLoaded("dungeonsdelight")){
            WARDENZOLA_CHEESE_WHEEL = BLOCKS.register("wardenzola_cheese_wheel", () -> new CheeseWheelBlock(DDItems.WARDENZOLA_CRUMBLES, Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_WARDENZOLA_CHEESE_WHEEL = BLOCKS.register("unripe_wardenzola_cheese_wheel", () -> new UnripeCheeseWheelBlock(WARDENZOLA_CHEESE_WHEEL, Block.Properties.ofFullCopy(Blocks.CAKE)));
            UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(UNRIPE_WARDENZOLA_CHEESE_WHEEL,new Item.Properties().stacksTo(16).rarity(DDProperties.MONSTER));
            WARDENZOLA_CHEESE_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(WARDENZOLA_CHEESE_WHEEL, new Item.Properties().stacksTo(16).rarity(DDProperties.MONSTER));

            WARDENZOLA_CHEESE_FLUID_TYPE = FLUIDS_TYPES.register("wardenzola_cheese_type", BnCFluidType::new);
            WARDENZOLA_CHEESE = FLUIDS.register("wardenzola_cheese", () -> new BaseFlowingFluid.Source(ChewyCheeses.WARDENZOLA_CHEESE_FLUID_PROPERTIES));
            FLOWING_WARDENZOLA_CHEESE = FLUIDS.register("flowing_wardenzola_cheese", () -> new BaseFlowingFluid.Flowing(ChewyCheeses.WARDENZOLA_CHEESE_FLUID_PROPERTIES));
            WARDENZOLA_CHEESE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(WARDENZOLA_CHEESE_FLUID_TYPE, WARDENZOLA_CHEESE, FLOWING_WARDENZOLA_CHEESE);
        } else {
            WARDENZOLA_CHEESE_WHEEL = null;
            UNRIPE_WARDENZOLA_CHEESE_WHEEL = null;
            UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM = null;
            WARDENZOLA_CHEESE_WHEEL_ITEM = null;

            WARDENZOLA_CHEESE_FLUID_TYPE = null;
            WARDENZOLA_CHEESE = null;
            FLOWING_WARDENZOLA_CHEESE = null;
            WARDENZOLA_CHEESE_FLUID_PROPERTIES = null;
        }
    }

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
//            .title(Component.translatable("itemGroup.examplemod")) //The language key for the title of your CreativeModeTab
//            .withTabsBefore(CreativeModeTabs.COMBAT)
//            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
//            .displayItems((parameters, output) -> {
//                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
//            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ChewyCheeses(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        FLUIDS_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        //CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
        //    event.accept(EXAMPLE_BLOCK_ITEM);
        //}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    public static ResourceLocation getResourceLocation(String name){
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
