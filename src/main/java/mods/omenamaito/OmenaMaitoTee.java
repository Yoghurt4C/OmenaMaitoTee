package mods.omenamaito;

import mods.omenamaito.registry.OMTBlocks;
import mods.omenamaito.registry.OMTCups;
import mods.omenamaito.registry.OMTItems;
import mods.omenamaito.registry.OMTPackets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class OmenaMaitoTee implements ModInitializer {

	public static ItemGroup OMTCoreGroup = FabricItemGroupBuilder.build(
			new Identifier("omenamaitotee", "core_group"),
			() -> new ItemStack(OMTBlocks.TEA_MAKER));
	public static ItemGroup OMTFoodGroup = FabricItemGroupBuilder.build(
			new Identifier("omenamaitotee", "food_group"),
			() -> new ItemStack(OMTItems.TOFFY_APPLE));

	@Override
	public void onInitialize() {
		OMTItems.init();
		OMTBlocks.init();
		OMTCups.init();
		OMTPackets.init();
	}

	public static Identifier getId(String name) {
		return new Identifier("omt", name);
	}
	public static final String modid="omt";
}
