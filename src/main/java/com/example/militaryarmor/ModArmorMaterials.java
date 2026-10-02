package com.example.militaryarmor;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, MilitaryArmorMod.MOD_ID);

    // Прочность = множитель * базовое значение слота (железо 15, незерит 37)
    public static final int MILITARY_DURABILITY = 30;
    public static final int HEAVY_DURABILITY = 40;
    public static final int ARCTIC_DURABILITY = 22;

    // Обычная военная броня (камуфляж)
    public static final Holder<ArmorMaterial> MILITARY = register("military",
            3, 6, 8, 3, 11, 15, SoundEvents.ARMOR_EQUIP_IRON, Items.IRON_INGOT, 2.0f, 0.05f);

    // Тяжёлая штурмовая: больше защиты и сопротивление отбрасыванию
    public static final Holder<ArmorMaterial> HEAVY = register("heavy",
            4, 7, 9, 4, 13, 9, SoundEvents.ARMOR_EQUIP_NETHERITE, Items.IRON_INGOT, 3.0f, 0.1f);

    // Арктическая: лёгкая, хорошо зачаровывается
    public static final Holder<ArmorMaterial> ARCTIC = register("arctic",
            2, 5, 7, 3, 9, 20, SoundEvents.ARMOR_EQUIP_LEATHER, Items.WHITE_WOOL, 0.0f, 0.0f);

    private static Holder<ArmorMaterial> register(String name, int boots, int leggings, int chestplate,
                                                  int helmet, int body, int enchantability,
                                                  Holder<SoundEvent> sound, Item repair,
                                                  float toughness, float knockbackResistance) {
        return MATERIALS.register(name, () -> {
            EnumMap<ArmorItem.Type, Integer> defense = new EnumMap<>(ArmorItem.Type.class);
            defense.put(ArmorItem.Type.BOOTS, boots);
            defense.put(ArmorItem.Type.LEGGINGS, leggings);
            defense.put(ArmorItem.Type.CHESTPLATE, chestplate);
            defense.put(ArmorItem.Type.HELMET, helmet);
            defense.put(ArmorItem.Type.BODY, body);

            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MilitaryArmorMod.MOD_ID, name);
            return new ArmorMaterial(defense, enchantability, sound,
                    () -> Ingredient.of(repair),
                    List.of(new ArmorMaterial.Layer(id)),
                    toughness, knockbackResistance);
        });
    }
}
