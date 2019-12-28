package mods.omenamaito.items;

import mods.omenamaito.registry.OMTItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.potion.PotionUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static mods.omenamaito.registry.OMTPackets.removeEffect;

public class BlockItemCup extends BlockItem {

    public BlockItemCup(Settings settings, Block cup) {
        super(cup, settings);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public int getMaxUseTime(ItemStack stack) {return 16;}

    @Override
    @Nullable
    public ActionResult useOnBlock(ItemUsageContext context) {
        return context.getPlayer().isSneaking() ? super.useOnBlock(context) : ActionResult.PASS;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
        ServerPlayerEntity player = entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null;
        if (!world.isClient &
                stack.getItem().equals(OMTItems.MILK_YUNOMI.asItem())|stack.getItem().equals(OMTItems.LIME_JUICE_YUNOMI.asItem())|
                stack.getItem().equals(OMTItems.MILK_SUMMER_CUP.asItem())|stack.getItem().equals(OMTItems.LIME_JUICE_SUMMER_CUP.asItem())|
                stack.getItem().equals(OMTItems.MILK_CUP.asItem())|stack.getItem().equals(OMTItems.LIME_JUICE_CUP.asItem())) {
            for (StatusEffectInstance effect:new ArrayList<>(entity.getStatusEffects())) {
                if(effect.getEffectType().getType()==StatusEffectType.HARMFUL) {
                    entity.removeStatusEffect(effect.getEffectType());
                    removeEffect(player, effect.getEffectType());
                }
            }
        }
        else if (!world.isClient &
                stack.getItem().equals(OMTItems.MINT_TEA_YUNOMI.asItem())|stack.getItem().equals(OMTItems.MINT_TEA_SUMMER_CUP.asItem())|stack.getItem().equals(OMTItems.MINT_TEA_CUP.asItem())){
            for (StatusEffectInstance effect:new ArrayList<>(entity.getStatusEffects())){
                entity.removeStatusEffect(effect.getEffectType());
                removeEffect(player,effect.getEffectType());
                entity.addStatusEffect(new StatusEffectInstance(effect.getEffectType(),effect.getDuration()+6000,effect.getAmplifier()));
            }
        }
        return super.finishUsing(stack, world, entity);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.getItem().getFoodComponent()!=null) {
            for (Pair<StatusEffectInstance, Float> effect : stack.getItem().getFoodComponent().getStatusEffects()) {
                TranslatableText text;
                text = new TranslatableText(effect.getKey().getTranslationKey(), new Object[0]);
                if(effect.getKey().getAmplifier() > 0) { text.append(" ").append(new TranslatableText("potion.potency." + effect.getKey().getAmplifier())); }
                if(effect.getKey().getDuration() > 20) { text.append(" (").append(StatusEffectUtil.durationToString(effect.getKey(), effect.getValue())).append(")"); }
                        text.formatted(Formatting.GRAY);
                tooltip.add(text);
            }
            if(stack.getItem().equals(OMTItems.MILK_YUNOMI.asItem())|stack.getItem().equals(OMTItems.LIME_JUICE_YUNOMI.asItem())|
                    stack.getItem().equals(OMTItems.MILK_SUMMER_CUP.asItem())|stack.getItem().equals(OMTItems.LIME_JUICE_SUMMER_CUP.asItem())|
                    stack.getItem().equals(OMTItems.MILK_CUP.asItem())|stack.getItem().equals(OMTItems.LIME_JUICE_CUP.asItem())) {
                tooltip.add(new TranslatableText("tooltip.omt.clear_harmful_effects").formatted(Formatting.GRAY));
            }
            if(stack.getItem().equals(OMTItems.MINT_TEA_YUNOMI.asItem())|stack.getItem().equals(OMTItems.MINT_TEA_SUMMER_CUP.asItem())|stack.getItem().equals(OMTItems.MINT_TEA_CUP.asItem())){
                tooltip.add(new TranslatableText("tooltip.omt.prolong_effect").formatted(Formatting.GRAY));
            }
        }
    }
}
