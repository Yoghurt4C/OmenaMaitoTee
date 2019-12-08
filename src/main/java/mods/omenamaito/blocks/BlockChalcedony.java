package mods.omenamaito.blocks;

import net.minecraft.block.GlassBlock;
import net.minecraft.client.block.ColoredBlock;
import net.minecraft.util.DyeColor;

public class BlockChalcedony extends GlassBlock implements ColoredBlock {
    public final DyeColor color;

    public BlockChalcedony(Settings settings, DyeColor color) {
        super(settings);
        this.color = color;
    }

    @Override
    public DyeColor getColor() {
        return color;
    }
}