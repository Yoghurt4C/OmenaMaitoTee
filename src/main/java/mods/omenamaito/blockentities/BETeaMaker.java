package mods.omenamaito.blockentities;

import mods.omenamaito.registry.OMTBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class BETeaMaker extends BlockEntity{
    public BETeaMaker(){
        super(OMTBlockEntities.TEA_MAKER);
    }

    public int amount=1;
    public String contentsID="minecraft:water";
    public boolean isMilk=false;
    public ItemStack input=null;
    public String tx="minecraft:textures/blocks/water_still.png";
    public String txMilk="minecraft:textures/blocks/water_still.png";

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
            return tag;
    }
}
