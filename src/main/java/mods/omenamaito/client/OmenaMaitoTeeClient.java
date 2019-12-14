package mods.omenamaito.client;

import grondag.fermion.client.ClientRegistrar;
import grondag.fermion.client.models.SimpleUnbakedModel;
import mods.omenamaito.OmenaMaitoTee;
import mods.omenamaito.client.models.VeryUnbakedTeaMakerModel;
import mods.omenamaito.client.models.VeryUnbakedYunomiModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;

import net.minecraft.client.render.RenderLayer;

import mods.omenamaito.registry.*;

import java.util.HashMap;

import static mods.omenamaito.materials.OMTBeverageList.BEVERAGES;

@SuppressWarnings("unused")
public class OmenaMaitoTeeClient implements ClientModInitializer {

    private static HashMap<String, SimpleUnbakedModel> models;
    public static final ClientRegistrar REGISTRAR = new ClientRegistrar(OmenaMaitoTee.modid);
    public static final String[] beverages=new String[BEVERAGES.size()];

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                OMTBlocks.CHALCEDONY,
                OMTBlocks.ORANGE_CHALCEDONY,
                OMTBlocks.WHITE_CHALCEDONY,
                OMTBlocks.GLOWING_CHALCEDONY,
                OMTBlocks.GLOWING_ORANGE_CHALCEDONY,
                OMTBlocks.GLOWING_WHITE_CHALCEDONY,
                OMTBlocks.CHALCEDONY_LAMP,
                OMTBlocks.ORANGE_CHALCEDONY_LAMP,
                OMTBlocks.WHITE_CHALCEDONY_LAMP
        );
        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                OMTBlocks.TEA_MAKER
        );
        REGISTRAR.modelVariant("tea_maker", new VeryUnbakedTeaMakerModel());
        for (String beverage:BEVERAGES) {
            REGISTRAR.modelVariant(beverage+"_cup",new VeryUnbakedYunomiModel());
            REGISTRAR.modelVariant(beverage+"_summer_cup",new VeryUnbakedYunomiModel());
            REGISTRAR.modelVariant(beverage+"_yunomi",new VeryUnbakedYunomiModel());
        }
    }
}