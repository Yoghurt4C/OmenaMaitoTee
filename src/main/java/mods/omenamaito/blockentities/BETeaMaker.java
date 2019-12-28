package mods.omenamaito.blockentities;

import mods.omenamaito.registry.OMTBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;

public class BETeaMaker extends BlockEntity {
    public BETeaMaker(){
        super(OMTBlockEntities.TEA_MAKER);
    }

    //private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public int amount=1;
    public String contentsID="minecraft:water";
    public boolean isMilk=false;
    public ItemStack input=null;
    public String tx="minecraft:textures/blocks/water_still.png";
    public String txMilk="minecraft:textures/blocks/water_still.png";

    /*@Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }*/

    public void fromTag(CompoundTag tag){
        super.fromTag(tag);

        if(tag.contains("Input")){
            this.input=ItemStack.fromTag(tag.getCompound("Input"));
        }

        this.amount=tag.getInt("Amount");
        this.isMilk=tag.getBoolean("Milk");
        this.tx=tag.getString("Texture");
        this.txMilk=tag.getString("Texture");
        //Inventories.fromTag(tag,items);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
            tag.putInt("Amount",this.amount);
            tag.putBoolean("Milk",this.isMilk);
            tag.putString("Texture",this.tx);
            tag.putString("Texture_Milk",this.txMilk);

            if(this.input!=null){
                tag.put("Input",this.input.toTag(new CompoundTag()));
            }
            //Inventories.toTag(tag,items);
            return tag;
    }
}
