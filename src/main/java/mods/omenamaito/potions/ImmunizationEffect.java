package mods.omenamaito.potions;

import mods.omenamaito.registry.OMTPotionEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;

import static mods.omenamaito.registry.OMTPackets.removeEffect;

public class ImmunizationEffect extends StatusEffect {

    public ImmunizationEffect(){
        super(StatusEffectType.BENEFICIAL,121321);
    }

    @Override
    public boolean canApplyUpdateEffect(final int duration, final int amp){
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int i) {
        for (StatusEffectInstance effect:new ArrayList<>(entity.getStatusEffects())) {
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity player = entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null;
                if (entity.getStatusEffect(OMTPotionEffects.IMMUNIZATION).getAmplifier() == 0 & effect.getEffectType() == StatusEffects.HUNGER) {
                    player.removeStatusEffect(effect.getEffectType());
                    removeEffect(player, effect.getEffectType());
                } else if (effect.getEffectType() == StatusEffects.WITHER || effect.getEffectType() == StatusEffects.POISON || effect.getEffectType() == StatusEffects.HUNGER) {
                    player.removeStatusEffect(effect.getEffectType());
                    removeEffect(player, effect.getEffectType());
                }
            }
        }
    }
}
