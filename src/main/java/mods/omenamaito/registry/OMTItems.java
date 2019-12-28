package mods.omenamaito.registry;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mods.omenamaito.OmenaMaitoTee;
import mods.omenamaito.items.BlockItemCup;
import mods.omenamaito.items.ItemChalcedonyStoneCutter;
import mods.omenamaito.items.ItemGrater;
import mods.omenamaito.items.ItemToffyApple;
import mods.omenamaito.materials.OMTToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

public class OMTItems {
	public static Item GRATER=new ItemGrater();
	public static SwordItem CHALCEDONY_KNIFE=new SwordItem(OMTToolMaterials.CHALCEDONY, 3, -2.4F, new Item.Settings().group(OmenaMaitoTee.OMTCoreGroup));
	public static ItemChalcedonyStoneCutter CHALCEDONY_STONE_CUTTER=new ItemChalcedonyStoneCutter(OMTToolMaterials.CHALCEDONY, 2, -2.8F, new Item.Settings().group(OmenaMaitoTee.OMTCoreGroup));

	public static Item TOFFY_APPLE = new ItemToffyApple(new Item.Settings().recipeRemainder(Items.STICK).group(OmenaMaitoTee.OMTFoodGroup).maxCount(64).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build()));
	public static Item CHILLED_TOFFY_APPLE = new ItemToffyApple(new Item.Settings().recipeRemainder(Items.STICK).group(OmenaMaitoTee.OMTFoodGroup).maxCount(64).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0),1f).alwaysEdible().build()));
	public static Item RUFFLED_TOFFY_APPLE = new ItemToffyApple(new Item.Settings().recipeRemainder(Items.STICK).group(OmenaMaitoTee.OMTFoodGroup).maxCount(64).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600, 0),1f).alwaysEdible().build()));
	public static Item GOLDEN_TOFFY_APPLE = new ItemToffyApple(new Item.Settings().recipeRemainder(Items.STICK).group(OmenaMaitoTee.OMTFoodGroup).maxCount(64).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0),1f).alwaysEdible().build()));
	public static Item GREEN_TOFFY_APPLE = new ItemToffyApple(new Item.Settings().recipeRemainder(Items.STICK).group(OmenaMaitoTee.OMTFoodGroup).maxCount(64).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 600, 0),1f).alwaysEdible().build()));

	//potion effects because why not
	static StatusEffectInstance instantHealth=new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,0);
	static StatusEffectInstance instantHealth2=new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,1);
	static StatusEffectInstance regen=new StatusEffectInstance(StatusEffects.REGENERATION,200,0);
	static StatusEffectInstance immunization=new StatusEffectInstance(OMTPotionEffects.IMMUNIZATION,600,0);
	static StatusEffectInstance immunization2=new StatusEffectInstance(OMTPotionEffects.IMMUNIZATION,600,1);

	public static BlockItemCup EMPTY_CUP=new BlockItemCup(new Item.Settings().group(OmenaMaitoTee.OMTCoreGroup),OMTCups.EMPTY_CUP);
	public static BlockItemCup MILK_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_CUP);
	public static BlockItemCup TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.TEA_CUP);
	public static BlockItemCup MILK_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_TEA_CUP);
	public static BlockItemCup GREEN_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.GREEN_TEA_CUP);
	public static BlockItemCup MILK_GREEN_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_GREEN_TEA_CUP);
	public static BlockItemCup BLACK_COCOA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BLACK_COCOA_CUP);
	public static BlockItemCup MILK_COCOA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_COCOA_CUP);
	public static BlockItemCup FRUITS_JUICE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.FRUITS_JUICE_CUP);
	public static BlockItemCup FRUIT_SHAKES_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.FRUIT_SHAKES_CUP);
	public static BlockItemCup HOT_LEMONADE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.HOT_LEMONADE_CUP);
	public static BlockItemCup MILK_LEMONADE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_LEMONADE_CUP);
	public static BlockItemCup COFFEE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.COFFEE_CUP);
	public static BlockItemCup MILK_COFFEE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_COFFEE_CUP);
	public static BlockItemCup EARL_GRAY_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.EARL_GRAY_TEA_CUP);
	public static BlockItemCup MILK_EARL_GRAY_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_EARL_GRAY_TEA_CUP);
	public static BlockItemCup APPLE_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.APPLE_TEA_CUP);
	public static BlockItemCup APPLE_MILK_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.APPLE_MILK_TEA_CUP);
	public static BlockItemCup LIME_JUICE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.LIME_JUICE_CUP);
	public static BlockItemCup TOMATO_JUICE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.TOMATO_JUICE_CUP);
	public static BlockItemCup BERRY_JUICE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BERRY_JUICE_CUP);
	public static BlockItemCup BERRY_SHAKES_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BERRY_SHAKES_CUP);
	public static BlockItemCup GRAPE_JUICE_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.SPEED,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.GRAPE_JUICE_CUP);
	public static BlockItemCup MINT_TEA_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MINT_TEA_CUP);

	public static BlockItemCup EMPTY_SUMMER_CUP=new BlockItemCup(new Item.Settings().group(OmenaMaitoTee.OMTCoreGroup),OMTCups.EMPTY_SUMMER_CUP);
	public static BlockItemCup MILK_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_SUMMER_CUP);
	public static BlockItemCup TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.TEA_SUMMER_CUP);
	public static BlockItemCup MILK_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_TEA_SUMMER_CUP);
	public static BlockItemCup GREEN_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.GREEN_TEA_SUMMER_CUP);
	public static BlockItemCup MILK_GREEN_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_GREEN_TEA_SUMMER_CUP);
	public static BlockItemCup BLACK_COCOA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BLACK_COCOA_SUMMER_CUP);
	public static BlockItemCup MILK_COCOA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_COCOA_SUMMER_CUP);
	public static BlockItemCup FRUITS_JUICE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.FRUITS_JUICE_SUMMER_CUP);
	public static BlockItemCup FRUIT_SHAKES_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.FRUIT_SHAKES_SUMMER_CUP);
	public static BlockItemCup HOT_LEMONADE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.HOT_LEMONADE_SUMMER_CUP);
	public static BlockItemCup MILK_LEMONADE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_LEMONADE_SUMMER_CUP);
	public static BlockItemCup COFFEE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.COFFEE_SUMMER_CUP);
	public static BlockItemCup MILK_COFFEE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_COFFEE_SUMMER_CUP);
	public static BlockItemCup EARL_GRAY_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.EARL_GRAY_TEA_SUMMER_CUP);
	public static BlockItemCup MILK_EARL_GRAY_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_EARL_GRAY_TEA_SUMMER_CUP);
	public static BlockItemCup APPLE_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.APPLE_TEA_SUMMER_CUP);
	public static BlockItemCup APPLE_MILK_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.APPLE_MILK_TEA_SUMMER_CUP);
	public static BlockItemCup LIME_JUICE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.LIME_JUICE_SUMMER_CUP);
	public static BlockItemCup TOMATO_JUICE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.TOMATO_JUICE_SUMMER_CUP);
	public static BlockItemCup BERRY_JUICE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BERRY_JUICE_SUMMER_CUP);
	public static BlockItemCup BERRY_SHAKES_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BERRY_SHAKES_SUMMER_CUP);
	public static BlockItemCup GRAPE_JUICE_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.SPEED,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.GRAPE_JUICE_SUMMER_CUP);
	public static BlockItemCup MINT_TEA_SUMMER_CUP=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MINT_TEA_SUMMER_CUP);

	public static BlockItemCup EMPTY_YUNOMI=new BlockItemCup(new Item.Settings().group(OmenaMaitoTee.OMTCoreGroup),OMTCups.EMPTY_YUNOMI);
	public static BlockItemCup MILK_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_YUNOMI);
	public static BlockItemCup TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.TEA_YUNOMI);
	public static BlockItemCup MILK_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_TEA_YUNOMI);
	public static BlockItemCup GREEN_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.GREEN_TEA_YUNOMI);
	public static BlockItemCup MILK_GREEN_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_GREEN_TEA_YUNOMI);
	public static BlockItemCup BLACK_COCOA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BLACK_COCOA_YUNOMI);
	public static BlockItemCup MILK_COCOA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_COCOA_YUNOMI);
	public static BlockItemCup FRUITS_JUICE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.FRUITS_JUICE_YUNOMI);
	public static BlockItemCup FRUIT_SHAKES_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.FRUIT_SHAKES_YUNOMI);
	public static BlockItemCup HOT_LEMONADE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.HOT_LEMONADE_YUNOMI);
	public static BlockItemCup MILK_LEMONADE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_LEMONADE_YUNOMI);
	public static BlockItemCup COFFEE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.COFFEE_YUNOMI);
	public static BlockItemCup MILK_COFFEE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_COFFEE_YUNOMI);
	public static BlockItemCup EARL_GRAY_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.EARL_GRAY_TEA_YUNOMI);
	public static BlockItemCup MILK_EARL_GRAY_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization2,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MILK_EARL_GRAY_TEA_YUNOMI);
	public static BlockItemCup APPLE_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.APPLE_TEA_YUNOMI);
	public static BlockItemCup APPLE_MILK_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(immunization,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.APPLE_MILK_TEA_YUNOMI);
	public static BlockItemCup LIME_JUICE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.LIME_JUICE_YUNOMI);
	public static BlockItemCup TOMATO_JUICE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.TOMATO_JUICE_YUNOMI);
	public static BlockItemCup BERRY_JUICE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BERRY_JUICE_YUNOMI);
	public static BlockItemCup BERRY_SHAKES_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,0),1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.BERRY_SHAKES_YUNOMI);
	public static BlockItemCup GRAPE_JUICE_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(new StatusEffectInstance(StatusEffects.SPEED,600,0),1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.GRAPE_JUICE_YUNOMI);
	public static BlockItemCup MINT_TEA_YUNOMI=new BlockItemCup(new Item.Settings().food(new FoodComponent.Builder().hunger(0).statusEffect(instantHealth,1f).statusEffect(regen,1f).build()).group(OmenaMaitoTee.OMTFoodGroup),OMTCups.MINT_TEA_YUNOMI);



	public static void init() {
		register("grater", GRATER);
		register("chalcedony_knife",CHALCEDONY_KNIFE);
		register("chalcedony_stone_cutter", CHALCEDONY_STONE_CUTTER);

		register("toffy_apple", TOFFY_APPLE);
		register("chilled_toffy_apple", CHILLED_TOFFY_APPLE);
		register("ruffled_toffy_apple", RUFFLED_TOFFY_APPLE);
		register("golden_toffy_apple", GOLDEN_TOFFY_APPLE);
		register("green_toffy_apple", GREEN_TOFFY_APPLE);

		register("empty_cup",EMPTY_CUP);
		register("hot_milk_cup",MILK_CUP);
		register("tea_cup",TEA_CUP);
		register("milk_tea_cup",MILK_TEA_CUP);
		register("green_tea_cup",GREEN_TEA_CUP);
		register("milk_green_tea_cup",MILK_GREEN_TEA_CUP);
		register("black_cocoa_cup",BLACK_COCOA_CUP);
		register("milk_cocoa_cup",MILK_COCOA_CUP);
		register("fruits_juice_cup",FRUITS_JUICE_CUP);
		register("fruit_shakes_cup",FRUIT_SHAKES_CUP);
		register("hot_lemonade_cup",HOT_LEMONADE_CUP);
		register("milk_lemonade_cup",MILK_LEMONADE_CUP);
		register("coffee_cup",COFFEE_CUP);
		register("milk_coffee_cup",MILK_COFFEE_CUP);
		register("earl_gray_tea_cup",EARL_GRAY_TEA_CUP);
		register("milk_earl_gray_tea_cup",MILK_EARL_GRAY_TEA_CUP);
		register("apple_tea_cup",APPLE_TEA_CUP);
		register("apple_milk_tea_cup",APPLE_MILK_TEA_CUP);
		register("lime_juice_cup",LIME_JUICE_CUP);
		register("tomato_juice_cup",TOMATO_JUICE_CUP);
		register("berry_juice_cup",BERRY_JUICE_CUP);
		register("berry_shakes_cup",BERRY_SHAKES_CUP);
		register("grape_juice_cup",GRAPE_JUICE_CUP);
		register("mint_tea_cup",MINT_TEA_CUP);

		register("empty_summer_cup",EMPTY_SUMMER_CUP);
		register("hot_milk_summer_cup",MILK_SUMMER_CUP);
		register("tea_summer_cup",TEA_SUMMER_CUP);
		register("milk_tea_summer_cup",MILK_TEA_SUMMER_CUP);
		register("green_tea_summer_cup",GREEN_TEA_SUMMER_CUP);
		register("milk_green_tea_summer_cup",MILK_GREEN_TEA_SUMMER_CUP);
		register("black_cocoa_summer_cup",BLACK_COCOA_SUMMER_CUP);
		register("milk_cocoa_summer_cup",MILK_COCOA_SUMMER_CUP);
		register("fruits_juice_summer_cup",FRUITS_JUICE_SUMMER_CUP);
		register("fruit_shakes_summer_cup",FRUIT_SHAKES_SUMMER_CUP);
		register("hot_lemonade_summer_cup",HOT_LEMONADE_SUMMER_CUP);
		register("milk_lemonade_summer_cup",MILK_LEMONADE_SUMMER_CUP);
		register("coffee_summer_cup",COFFEE_SUMMER_CUP);
		register("milk_coffee_summer_cup",MILK_COFFEE_SUMMER_CUP);
		register("earl_gray_tea_summer_cup",EARL_GRAY_TEA_SUMMER_CUP);
		register("milk_earl_gray_tea_summer_cup",MILK_EARL_GRAY_TEA_SUMMER_CUP);
		register("apple_tea_summer_cup",APPLE_TEA_SUMMER_CUP);
		register("apple_milk_tea_summer_cup",APPLE_MILK_TEA_SUMMER_CUP);
		register("lime_juice_summer_cup",LIME_JUICE_SUMMER_CUP);
		register("tomato_juice_summer_cup",TOMATO_JUICE_SUMMER_CUP);
		register("berry_juice_summer_cup",BERRY_JUICE_SUMMER_CUP);
		register("berry_shakes_summer_cup",BERRY_SHAKES_SUMMER_CUP);
		register("grape_juice_summer_cup",GRAPE_JUICE_SUMMER_CUP);
		register("mint_tea_summer_cup",MINT_TEA_SUMMER_CUP);

		register("empty_yunomi",EMPTY_YUNOMI);
		register("hot_milk_yunomi",MILK_YUNOMI);
		register("tea_yunomi",TEA_YUNOMI);
		register("milk_tea_yunomi",MILK_TEA_YUNOMI);
		register("green_tea_yunomi",GREEN_TEA_YUNOMI);
		register("milk_green_tea_yunomi",MILK_GREEN_TEA_YUNOMI);
		register("black_cocoa_yunomi",BLACK_COCOA_YUNOMI);
		register("milk_cocoa_yunomi",MILK_COCOA_YUNOMI);
		register("fruits_juice_yunomi",FRUITS_JUICE_YUNOMI);
		register("fruit_shakes_yunomi",FRUIT_SHAKES_YUNOMI);
		register("hot_lemonade_yunomi",HOT_LEMONADE_YUNOMI);
		register("milk_lemonade_yunomi",MILK_LEMONADE_YUNOMI);
		register("coffee_yunomi",COFFEE_YUNOMI);
		register("milk_coffee_yunomi",MILK_COFFEE_YUNOMI);
		register("earl_gray_tea_yunomi",EARL_GRAY_TEA_YUNOMI);
		register("milk_earl_gray_tea_yunomi",MILK_EARL_GRAY_TEA_YUNOMI);
		register("apple_tea_yunomi",APPLE_TEA_YUNOMI);
		register("apple_milk_tea_yunomi",APPLE_MILK_TEA_YUNOMI);
		register("lime_juice_yunomi",LIME_JUICE_YUNOMI);
		register("tomato_juice_yunomi",TOMATO_JUICE_YUNOMI);
		register("berry_juice_yunomi",BERRY_JUICE_YUNOMI);
		register("berry_shakes_yunomi",BERRY_SHAKES_YUNOMI);
		register("grape_juice_yunomi",GRAPE_JUICE_YUNOMI);
		register("mint_tea_yunomi",MINT_TEA_YUNOMI);

		encodeCup(OMTItems.EMPTY_CUP,0x354FF4);
		encodeCup(OMTItems.MILK_CUP,0xFFFFFF);
		encodeCup(OMTItems.TEA_CUP,0xB41A06);
		encodeCup(OMTItems.MILK_TEA_CUP,0xF2A682);
		encodeCup(OMTItems.GREEN_TEA_CUP,0x76DD4E);
		encodeCup(OMTItems.MILK_GREEN_TEA_CUP,0xCAF9B8);
		encodeCup(OMTItems.BLACK_COCOA_CUP,0x231712);
		encodeCup(OMTItems.MILK_COCOA_CUP,0x7F543F);
		encodeCup(OMTItems.FRUITS_JUICE_CUP,0xF3C85E);
		encodeCup(OMTItems.FRUIT_SHAKES_CUP,0xFDE8B2);
		encodeCup(OMTItems.HOT_LEMONADE_CUP,0xFEE960);
		encodeCup(OMTItems.MILK_LEMONADE_CUP,0xFCF2AE);
		encodeCup(OMTItems.COFFEE_CUP,0x231712);
		encodeCup(OMTItems.MILK_COFFEE_CUP,0x7F543F);
		encodeCup(OMTItems.EARL_GRAY_TEA_CUP,0xC69B9B);
		encodeCup(OMTItems.MILK_EARL_GRAY_TEA_CUP,0xC69B9B);
		encodeCup(OMTItems.APPLE_TEA_CUP,0xE43A47);
		encodeCup(OMTItems.APPLE_MILK_TEA_CUP,0xE2B5B9);
		encodeCup(OMTItems.LIME_JUICE_CUP,0xB9EA66);
		encodeCup(OMTItems.TOMATO_JUICE_CUP,0xD91616);
		encodeCup(OMTItems.BERRY_JUICE_CUP,0xD149A6);
		encodeCup(OMTItems.BERRY_SHAKES_CUP,0xF5CDEC);
		encodeCup(OMTItems.GRAPE_JUICE_CUP,0xA43FB9);
		encodeCup(OMTItems.MINT_TEA_CUP,0x4EDDAD);

		encodeCup(OMTItems.EMPTY_SUMMER_CUP,0x354FF4);
		encodeCup(OMTItems.MILK_SUMMER_CUP,0xFFFFFF);
		encodeCup(OMTItems.TEA_SUMMER_CUP,0xB41A06);
		encodeCup(OMTItems.MILK_TEA_SUMMER_CUP,0xF2A682);
		encodeCup(OMTItems.GREEN_TEA_SUMMER_CUP,0x76DD4E);
		encodeCup(OMTItems.MILK_GREEN_TEA_SUMMER_CUP,0xCAF9B8);
		encodeCup(OMTItems.BLACK_COCOA_SUMMER_CUP,0x231712);
		encodeCup(OMTItems.MILK_COCOA_SUMMER_CUP,0x7F543F);
		encodeCup(OMTItems.FRUITS_JUICE_SUMMER_CUP,0xF3C85E);
		encodeCup(OMTItems.FRUIT_SHAKES_SUMMER_CUP,0xFDE8B2);
		encodeCup(OMTItems.HOT_LEMONADE_SUMMER_CUP,0xFEE960);
		encodeCup(OMTItems.MILK_LEMONADE_SUMMER_CUP,0xFCF2AE);
		encodeCup(OMTItems.COFFEE_SUMMER_CUP,0x231712);
		encodeCup(OMTItems.MILK_COFFEE_SUMMER_CUP,0x7F543F);
		encodeCup(OMTItems.EARL_GRAY_TEA_SUMMER_CUP,0xC69B9B);
		encodeCup(OMTItems.MILK_EARL_GRAY_TEA_SUMMER_CUP,0xC69B9B);
		encodeCup(OMTItems.APPLE_TEA_SUMMER_CUP,0xE43A47);
		encodeCup(OMTItems.APPLE_MILK_TEA_SUMMER_CUP,0xE2B5B9);
		encodeCup(OMTItems.LIME_JUICE_SUMMER_CUP,0xB9EA66);
		encodeCup(OMTItems.TOMATO_JUICE_SUMMER_CUP,0xD91616);
		encodeCup(OMTItems.BERRY_JUICE_SUMMER_CUP,0xD149A6);
		encodeCup(OMTItems.BERRY_SHAKES_SUMMER_CUP,0xF5CDEC);
		encodeCup(OMTItems.GRAPE_JUICE_SUMMER_CUP,0xA43FB9);
		encodeCup(OMTItems.MINT_TEA_SUMMER_CUP,0x4EDDAD);

		encodeCup(OMTItems.EMPTY_YUNOMI,0x354FF4);
		encodeCup(OMTItems.MILK_YUNOMI,0xFFFFFF);
		encodeCup(OMTItems.TEA_YUNOMI,0xB41A06);
		encodeCup(OMTItems.MILK_TEA_YUNOMI,0xF2A682);
		encodeCup(OMTItems.GREEN_TEA_YUNOMI,0x76DD4E);
		encodeCup(OMTItems.MILK_GREEN_TEA_YUNOMI,0xCAF9B8);
		encodeCup(OMTItems.BLACK_COCOA_YUNOMI,0x231712);
		encodeCup(OMTItems.MILK_COCOA_YUNOMI,0x7F543F);
		encodeCup(OMTItems.FRUITS_JUICE_YUNOMI,0xF3C85E);
		encodeCup(OMTItems.FRUIT_SHAKES_YUNOMI,0xFDE8B2);
		encodeCup(OMTItems.HOT_LEMONADE_YUNOMI,0xFEE960);
		encodeCup(OMTItems.MILK_LEMONADE_YUNOMI,0xFCF2AE);
		encodeCup(OMTItems.COFFEE_YUNOMI,0x231712);
		encodeCup(OMTItems.MILK_COFFEE_YUNOMI,0x7F543F);
		encodeCup(OMTItems.EARL_GRAY_TEA_YUNOMI,0xC69B9B);
		encodeCup(OMTItems.MILK_EARL_GRAY_TEA_YUNOMI,0xC69B9B);
		encodeCup(OMTItems.APPLE_TEA_YUNOMI,0xE43A47);
		encodeCup(OMTItems.APPLE_MILK_TEA_YUNOMI,0xE2B5B9);
		encodeCup(OMTItems.LIME_JUICE_YUNOMI,0xB9EA66);
		encodeCup(OMTItems.TOMATO_JUICE_YUNOMI,0xD91616);
		encodeCup(OMTItems.BERRY_JUICE_YUNOMI,0xD149A6);
		encodeCup(OMTItems.BERRY_SHAKES_YUNOMI,0xF5CDEC);
		encodeCup(OMTItems.GRAPE_JUICE_YUNOMI,0xA43FB9);
		encodeCup(OMTItems.MINT_TEA_YUNOMI,0x4EDDAD);
	}
	
	public static void register(String name, Item item) {
		Registry.register(Registry.ITEM, OmenaMaitoTee.getId(name), item);
	}

	public static int YUNOMI_CUP_MODEL_NUM = 0;
	public static int SUMMER_CUP_MODEL_NUM = 1;
	public static int EMPTY_CUP_MODEL_NUM = 2;

	public static void encodeCup(BlockItemCup cup, int rgbColor) {
		final String cupString = cup.toString();
		final int modelNum = cupString.contains("_yunomi") ? YUNOMI_CUP_MODEL_NUM : cupString.contains("_summer_cup") ? SUMMER_CUP_MODEL_NUM : EMPTY_CUP_MODEL_NUM;
		CUPS.put(cup, (modelNum << 24) | rgbColor);
	}

	public static Object2IntOpenHashMap<Item> CUPS = new Object2IntOpenHashMap();
	static {

	}
}
