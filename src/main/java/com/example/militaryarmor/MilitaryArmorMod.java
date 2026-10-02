package com.example.militaryarmor;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(MilitaryArmorMod.MOD_ID)
public class MilitaryArmorMod {
    public static final String MOD_ID = "militaryarmor";

    public MilitaryArmorMod(IEventBus modEventBus) {
        ModArmorMaterials.MATERIALS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        modEventBus.addListener(this::addToCreativeTab);
    }

    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            ModItems.ALL.forEach(event::accept);
        }
    }
}
