package mods.omenamaito.registry;

import mods.omenamaito.OmenaMaitoTee;
import mods.omenamaito.items.ItemChalcedonyStoneCutter;
import mods.omenamaito.items.ItemGrater;
import mods.omenamaito.items.ItemToffyApple;
import mods.omenamaito.materials.OMTToolMaterials;
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
	
	public static void init() {
		register("grater", GRATER);
		register("chalcedony_knife",CHALCEDONY_KNIFE);
		register("chalcedony_stone_cutter", CHALCEDONY_STONE_CUTTER);

		register("toffy_apple", TOFFY_APPLE);
		register("chilled_toffy_apple", CHILLED_TOFFY_APPLE);
		register("ruffled_toffy_apple", RUFFLED_TOFFY_APPLE);
		register("golden_toffy_apple", GOLDEN_TOFFY_APPLE);
		register("green_toffy_apple", GREEN_TOFFY_APPLE);
	}
	
	public static void register(String name, Item item) {
		Registry.register(Registry.ITEM, OmenaMaitoTee.getId(name), item);
	}
}
