package mods.omenamaito.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public class VeryUnbakedYunomiModel implements UnbakedModel {
    @Override
    public Collection<Identifier> getModelDependencies() {
        return ImmutableList.of(
                new Identifier("omt:block/empty_yunomi"),
                new Identifier("omt:block/empty_cup"),
                new Identifier("omt:block/empty_summer_cup"));
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return TeaMakerModel.TEXTURES;
    }

    @Override
    @Nullable
    public BakedModel bake(ModelLoader modelLoader, Function<SpriteIdentifier, Sprite> spriteLoader, ModelBakeSettings modelBakeSettings, Identifier identifier) {
        final Identifier myJsonId = new Identifier("omt:block/empty_yunomi");
        final BakedModel exteriorModel = modelLoader.getOrLoadModel(myJsonId).bake(modelLoader, spriteLoader, modelBakeSettings, myJsonId);
        final Identifier myJsonId2 = new Identifier("omt:block/empty_summer_cup");
        final BakedModel exteriorModel2 = modelLoader.getOrLoadModel(myJsonId).bake(modelLoader, spriteLoader, modelBakeSettings, myJsonId2);
        final Identifier myJsonId3 = new Identifier("omt:block/empty_cup");
        final BakedModel exteriorModel3 = modelLoader.getOrLoadModel(myJsonId).bake(modelLoader, spriteLoader, modelBakeSettings, myJsonId3);
        return new YunomiModel(spriteLoader.apply(TeaMakerModel.TEXTURES.get(0)), spriteLoader, exteriorModel,exteriorModel2,exteriorModel3);
    }
}