package mods.omenamaito.registry;

import mods.omenamaito.blockentities.BETeaMaker;
import mods.omenamaito.blocks.BlockChalcedony;
import mods.omenamaito.blocks.BlockTeaMaker;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import mods.omenamaito.OmenaMaitoTee;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OMTBlocks {
    public static Block FLINT_BLOCK=new Block(Block.Settings.copy(Blocks.STONE));
    public static Block CHALCEDONY=new BlockChalcedony(Block.Settings.copy(Blocks.STONE).nonOpaque(), DyeColor.LIGHT_BLUE);
    public static Block ORANGE_CHALCEDONY=new BlockChalcedony(Block.Settings.copy(OMTBlocks.CHALCEDONY), DyeColor.ORANGE);
    public static Block WHITE_CHALCEDONY=new BlockChalcedony(Block.Settings.copy(OMTBlocks.CHALCEDONY), DyeColor.WHITE);
    public static Block GLOWING_CHALCEDONY=new BlockChalcedony(FabricBlockSettings.copy(Blocks.STONE).lightLevel(15).nonOpaque().build(), DyeColor.LIGHT_BLUE);
    public static Block GLOWING_ORANGE_CHALCEDONY=new BlockChalcedony(FabricBlockSettings.copy(OMTBlocks.GLOWING_CHALCEDONY).build(), DyeColor.ORANGE);
    public static Block GLOWING_WHITE_CHALCEDONY=new BlockChalcedony(FabricBlockSettings.copy(OMTBlocks.GLOWING_CHALCEDONY).build(), DyeColor.WHITE);
    public static Block CHALCEDONY_LAMP=new BlockChalcedony(FabricBlockSettings.copy(Blocks.GLASS).lightLevel(15).nonOpaque().build(), DyeColor.LIGHT_BLUE);
    public static Block ORANGE_CHALCEDONY_LAMP=new BlockChalcedony(FabricBlockSettings.copy(OMTBlocks.CHALCEDONY_LAMP).build(), DyeColor.ORANGE);
    public static Block WHITE_CHALCEDONY_LAMP=new BlockChalcedony(FabricBlockSettings.copy(OMTBlocks.CHALCEDONY_LAMP).build(), DyeColor.WHITE);

    public static Block TEA_MAKER=new BlockTeaMaker(Block.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());

    public static void init() {
        register("flint_block",FLINT_BLOCK);
        register("chalcedony",CHALCEDONY);
        register("orange_chalcedony",ORANGE_CHALCEDONY);
        register("white_chalcedony",WHITE_CHALCEDONY);
        register("glowing_chalcedony",GLOWING_CHALCEDONY);
        register("glowing_orange_chalcedony",GLOWING_ORANGE_CHALCEDONY);
        register("glowing_white_chalcedony",GLOWING_WHITE_CHALCEDONY);
        register("chalcedony_lamp",CHALCEDONY_LAMP);
        register("orange_chalcedony_lamp",ORANGE_CHALCEDONY_LAMP);
        register("white_chalcedony_lamp",WHITE_CHALCEDONY_LAMP);
        register("tea_maker",TEA_MAKER);
    }

    public static BlockItem register(String name, Block block, Item.Settings settings) {
        Identifier id = OmenaMaitoTee.getId(name);
        Registry.register(Registry.BLOCK, id, block);
        BlockItem item = new BlockItem(block, settings);
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        Registry.register(Registry.ITEM, id, item);
        return item;
    }

    public static BlockItem register(String name, Block block) {
        return register(name, block, new Item.Settings().group(OmenaMaitoTee.OMTCoreGroup));
    }
}