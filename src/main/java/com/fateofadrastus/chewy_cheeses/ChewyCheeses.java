package com.fateofadrastus.chewy_cheeses;

import com.fateofadrastus.chewy_cheeses.registry.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

import net.yirmiri.dungeonsdelight.core.registry.DDItems;
import net.yirmiri.dungeonsdelight.common.util.DDProperties;
import net.yirmiri.dungeonsdelight.core.registry.DDCreativeTabs;
import net.mcreator.sniffer.init.SnifferModItems;
import net.mcreator.sniffer.init.SnifferModTabs;
import alabaster.hearthandharvest.common.registry.HHModItems;
import umpaz.brewinandchewin.common.registry.BnCCreativeTabs;
import umpaz.brewinandchewin.common.registry.BnCItems;



@Mod(ChewyCheeses.MODID)
public class ChewyCheeses {
    public static final String MODID = "chewy_cheeses";
    public static final Logger LOGGER = LogUtils.getLogger();

    /*---------------------------------------------- notes for adding a new cheese ----------------------------------------------------*//*

    register blocks, fluids & items
    add textures
    add block models & block states
    fluid item display & coaster model
    lang
    recipes & tags

    /*---------------------------------------------------------------------------------------------------------------------------------*/

    public ChewyCheeses(IEventBus modEventBus, ModContainer modContainer) {
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
        if (event.getTab() == BnCCreativeTabs.TAB_BREWIN_AND_CHEWIN){

            if ( ModList.get().isLoaded("environmental") ) {
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.TRUFFLE_CHEESE_WEDGE.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.TRUFFLE_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.UNRIPE_TRUFFLE_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            if ( ModList.get().isLoaded("quark") || ModList.get().isLoaded("darkerdepths") ) {
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.GLOWSHROOM_CHEESE_WEDGE.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.GLOWSHROOM_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.UNRIPE_GLOWSHROOM_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            if ( ModList.get().isLoaded("endersdelight") ) {
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.SHULKER_CHEESE_WEDGE.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.SHULKER_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.UNRIPE_SHULKER_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.PITCHER_CHEESE_WEDGE.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.PITCHER_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(BnCItems.SCARLET_CHEESE_WEDGE.getDefaultInstance(), Registry.UNRIPE_PITCHER_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (ModList.get().isLoaded("sniffer") && event.getTab() == SnifferModTabs.SNIFFER.get()){
                event.insertBefore(SnifferModItems.S_9.get().getDefaultInstance(), Registry.UNRIPE_FRAGRANT_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertBefore(SnifferModItems.S_9.get().getDefaultInstance(), Registry.FRAGRANT_CHEESE_WHEEL_ITEM.get().getDefaultInstance() , CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public void modifyComponents(ModifyDefaultComponentsEvent event) {
        if (ModList.get().isLoaded("dungeonsdelight"))
            event.modify(DDItems.WARDENZOLA.get(), builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 16).set(DataComponents.RARITY,DDProperties.MONSTER));
        if (ModList.get().isLoaded("hearthandharvest")) {
            event.modify(HHModItems.GOAT_CHEESE_WHEEL.get(), builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 16));
            event.modify(HHModItems.UNRIPE_GOAT_CHEESE_WHEEL.get(), builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 16));
            event.modify(HHModItems.CHEDDAR_CHEESE_WHEEL.get(), builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 16));
            event.modify(HHModItems.UNRIPE_CHEDDAR_CHEESE_WHEEL.get(), builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 16));
        }
    }



    public static ResourceLocation getResourceLocation(String name){
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
