package mods.omenamaito.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ItemToffyApple extends Item {
	public ItemToffyApple(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		super.finishUsing(stack, world, user);
		PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;

		if (playerEntity == null || !playerEntity.abilities.creativeMode) {
			if (stack.isEmpty()) {
				return new ItemStack(Items.STICK);
			}

			if (playerEntity != null) {
				playerEntity.inventory.insertStack(new ItemStack(Items.STICK));
			}
		}

		return stack;
	}
}
