package mods.omenamaito.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface ExtendedRecipeRemainder {

    default ItemStack getRemainderStack(ItemStack stack, PlayerEntity playerEntity){
        return ItemStack.EMPTY;
    }

}