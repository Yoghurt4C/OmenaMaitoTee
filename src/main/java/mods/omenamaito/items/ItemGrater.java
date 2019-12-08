package mods.omenamaito.items;

import mods.omenamaito.OmenaMaitoTee;
import mods.omenamaito.util.ExtendedRecipeRemainder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import java.util.List;

public class ItemGrater extends Item implements ExtendedRecipeRemainder {
    public static int maxDamage = 64;

    public ItemGrater() {
        super(new Item.Settings()
                .group(OmenaMaitoTee.OMTCoreGroup)
                .maxCount(1)
                .maxDamage(maxDamage)
        );
    }

    @Override
    public ItemStack getRemainderStack(ItemStack stack, PlayerEntity playerEntity) {
        if(playerEntity.isCreative()){
            return stack;
        }
        damage(stack);
        if(getDamage(stack) >= maxDamage){
            return ItemStack.EMPTY;
        }
        return stack;
    }


    public static int getDamage(ItemStack stack){
        checkTag(stack);
        return stack.getTag().getInt("Damage");
    }

    public static ItemStack damage(ItemStack stack){
        checkTag(stack);
        stack.getTag().putInt("Damage", getDamage(stack) + 1);
        return stack;
    }

    private static void checkTag(ItemStack stack){
        if(!stack.hasTag()){
            System.out.println("new tag");
            stack.setTag(new CompoundTag());
        }
        if(!stack.getTag().contains("Damage")){
            System.out.println("new damage");
            stack.getTag().putInt("Damage", 0);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipOptions) {
        if (!tooltipOptions.isAdvanced()) {
            tooltip.add(new LiteralText("Durability:").formatted(Formatting.GRAY).append(new LiteralText(" " + (maxDamage - getDamage(stack)) + " / " + (maxDamage)).formatted(Formatting.GRAY)));
        }
    }
}