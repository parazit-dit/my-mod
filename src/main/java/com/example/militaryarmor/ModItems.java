package com.example.militaryarmor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MilitaryArmorMod.MOD_ID);

    /** Все предметы мода — для творческой вкладки. */
    public static final List<DeferredItem<Item>> ALL = new ArrayList<>();

    // Военная
    public static final DeferredItem<Item> MILITARY_HELMET = armor("military_helmet", ModArmorMaterials.MILITARY, ArmorItem.Type.HELMET, ModArmorMaterials.MILITARY_DURABILITY);
    public static final DeferredItem<Item> MILITARY_CHESTPLATE = armor("military_chestplate", ModArmorMaterials.MILITARY, ArmorItem.Type.CHESTPLATE, ModArmorMaterials.MILITARY_DURABILITY);
    public static final DeferredItem<Item> MILITARY_LEGGINGS = armor("military_leggings", ModArmorMaterials.MILITARY, ArmorItem.Type.LEGGINGS, ModArmorMaterials.MILITARY_DURABILITY);
    public static final DeferredItem<Item> MILITARY_BOOTS = armor("military_boots", ModArmorMaterials.MILITARY, ArmorItem.Type.BOOTS, ModArmorMaterials.MILITARY_DURABILITY);

    // Тяжёлая штурмовая
    public static final DeferredItem<Item> HEAVY_HELMET = armor("heavy_helmet", ModArmorMaterials.HEAVY, ArmorItem.Type.HELMET, ModArmorMaterials.HEAVY_DURABILITY);
    public static final DeferredItem<Item> HEAVY_CHESTPLATE = armor("heavy_chestplate", ModArmorMaterials.HEAVY, ArmorItem.Type.CHESTPLATE, ModArmorMaterials.HEAVY_DURABILITY);
    public static final DeferredItem<Item> HEAVY_LEGGINGS = armor("heavy_leggings", ModArmorMaterials.HEAVY, ArmorItem.Type.LEGGINGS, ModArmorMaterials.HEAVY_DURABILITY);
    public static final DeferredItem<Item> HEAVY_BOOTS = armor("heavy_boots", ModArmorMaterials.HEAVY, ArmorItem.Type.BOOTS, ModArmorMaterials.HEAVY_DURABILITY);

    // Арктическая
    public static final DeferredItem<Item> ARCTIC_HELMET = armor("arctic_helmet", ModArmorMaterials.ARCTIC, ArmorItem.Type.HELMET, ModArmorMaterials.ARCTIC_DURABILITY);
    public static final DeferredItem<Item> ARCTIC_CHESTPLATE = armor("arctic_chestplate", ModArmorMaterials.ARCTIC, ArmorItem.Type.CHESTPLATE, ModArmorMaterials.ARCTIC_DURABILITY);
    public static final DeferredItem<Item> ARCTIC_LEGGINGS = armor("arctic_leggings", ModArmorMaterials.ARCTIC, ArmorItem.Type.LEGGINGS, ModArmorMaterials.ARCTIC_DURABILITY);
    public static final DeferredItem<Item> ARCTIC_BOOTS = armor("arctic_boots", ModArmorMaterials.ARCTIC, ArmorItem.Type.BOOTS, ModArmorMaterials.ARCTIC_DURABILITY);

    // Пояс подрывника
    public static final DeferredItem<Item> DEMOLITION_BELT = ITEMS.register("demolition_belt",
            () -> new DemolitionBeltItem(new Item.Properties().stacksTo(1)));
    static { ALL.add(DEMOLITION_BELT); }

    private static DeferredItem<Item> armor(String name, Holder<ArmorMaterial> material, ArmorItem.Type type, int durabilityMultiplier) {
        DeferredItem<Item> item = ITEMS.register(name, () -> new ArmorItem(
                material, type, new Item.Properties().durability(type.getDurability(durabilityMultiplier))));
        ALL.add(item);
        return item;
    }
}
