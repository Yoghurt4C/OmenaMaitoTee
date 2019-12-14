package mods.omenamaito.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class OMTPotions {
    public static Potion IMMUNIZATION;
    public static Potion STRONG_IMMUNIZATION;

    private static Potion register(String name, Potion potion) {
        return (Potion) Registry.register(Registry.POTION, name, potion);
    }

    static {
        IMMUNIZATION=register("immunization", new Potion(new StatusEffectInstance[]{new StatusEffectInstance(OMTPotionEffects.IMMUNIZATION, 600,0)}));
        STRONG_IMMUNIZATION=register("strong_immunization", new Potion(new StatusEffectInstance[]{new StatusEffectInstance(OMTPotionEffects.IMMUNIZATION, 600,1)}));
    }
}
