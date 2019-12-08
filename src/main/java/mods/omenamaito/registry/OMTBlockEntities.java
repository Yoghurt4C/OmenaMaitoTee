package mods.omenamaito.registry;

import mods.omenamaito.OmenaMaitoTee;
import mods.omenamaito.blockentities.BETeaMaker;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class OMTBlockEntities {
    public static final BlockEntityType<BETeaMaker> TEA_MAKER=register("tea_maker",BlockEntityType.Builder.create(BETeaMaker::new,OMTBlocks.TEA_MAKER).build(null));

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> build) {
        return Registry.register(Registry.BLOCK_ENTITY, OmenaMaitoTee.getId(name), build);
    }
}
