package mods.omenamaito.client;

import grondag.fermion.client.ClientRegistrar;
import grondag.fermion.client.models.SimpleUnbakedModel;
import mods.omenamaito.client.models.VeryUnbakedModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;

import net.minecraft.client.render.RenderLayer;

import mods.omenamaito.registry.*;
import java.util.HashMap;

@SuppressWarnings("unused")
public class OmenaMaitoTeeClient implements ClientModInitializer {

    private static HashMap<String, SimpleUnbakedModel> models;
    public static final ClientRegistrar REGISTRAR = new ClientRegistrar("omt");

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
        REGISTRAR.modelVariant("tea_maker", new VeryUnbakedModel());
    }
}