package mods.omenamaito.items;

import mods.omenamaito.registry.OMTItems;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import javax.annotation.Nullable;

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
            for (StatusEffectInstance effect : entity.getStatusEffects()) {
                removeEffect(player, effect.getEffectType());
            }
        }
        else if (!world.isClient &
                stack.getItem().equals(OMTItems.MINT_TEA_YUNOMI.asItem())|stack.getItem().equals(OMTItems.MINT_TEA_SUMMER_CUP.asItem())|stack.getItem().equals(OMTItems.MINT_TEA_CUP.asItem())){
            for (StatusEffectInstance effect:entity.getStatusEffects()){
                removeEffect(player,effect.getEffectType());
                entity.addStatusEffect(new StatusEffectInstance(effect.getEffectType(),effect.getDuration()+6000,effect.getAmplifier()));
            }
        }
        return super.finishUsing(stack, world, entity);
    }
}
