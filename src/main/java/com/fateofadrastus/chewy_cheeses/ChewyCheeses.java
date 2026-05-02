package com.fateofadrastus.chewy_cheeses;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.yirmiri.dungeonsdelight.core.registry.DDCreativeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import net.yirmiri.dungeonsdelight.common.util.DDProperties;

@Mod(ChewyCheeses.MODID)
public class ChewyCheeses {
    public static final String MODID = "chewy_cheeses";
    public static final Logger LOGGER = LogUtils.getLogger();

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

    public ChewyCheeses(IEventBus modEventBus, ModContainer modContainer) {
        //modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::modifyComponents);

        Registry.BLOCKS.register(modEventBus);
        Registry.ITEMS.register(modEventBus);
        Registry.FLUIDS_TYPES.register(modEventBus);
        Registry.FLUIDS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        //NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (ModList.get().isLoaded("dungeonsdelight") && event.getTab() == DDCreativeTabs.DUNGEONSDELIGHT.get()) {
            event.insertBefore(DDItems.WARDENZOLA.get().getDefaultInstance(), Registry.UNRIPE_WARDENZOLA_CHEESE_WHEEL_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public void modifyComponents(ModifyDefaultComponentsEvent event) {
        if (ModList.get().isLoaded("dungeonsdelight"))
            event.modify(DDItems.WARDENZOLA.get(), builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 16).set(DataComponents.RARITY,DDProperties.MONSTER));
    }


//    private void commonSetup(FMLCommonSetupEvent event) {
//
//    }
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event) {
//    }

    public static ResourceLocation getResourceLocation(String name){
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
