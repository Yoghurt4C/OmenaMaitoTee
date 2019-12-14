package mods.omenamaito.registry;

import grondag.fermion.registrar.Registrar;
import mods.omenamaito.OmenaMaitoTee;
import mods.omenamaito.potions.ImmunizationEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum OMTPotionEffects {
	;
	public static final StatusEffect IMMUNIZATION = Registry.register(Registry.STATUS_EFFECT, new Identifier(OmenaMaitoTee.modid,"immunization"), new ImmunizationEffect());
}