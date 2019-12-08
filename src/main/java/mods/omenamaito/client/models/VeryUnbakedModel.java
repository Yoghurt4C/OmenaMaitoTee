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
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;

public class VeryUnbakedModel implements UnbakedModel {
    @Override
    public Collection<Identifier> getModelDependencies() {
        return ImmutableList.of(new Identifier("omt:block/tea_maker"));
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return Collections.emptyList();
    }

    @Override
    @Nullable
    public BakedModel bake(ModelLoader modelLoader, Function<SpriteIdentifier, Sprite> spriteLoader, ModelBakeSettings modelBakeSettings, Identifier identifier) {
        final Identifier myJsonId = new Identifier("omt:block/tea_maker");
        final BakedModel exteriorModel = modelLoader.getOrLoadModel(myJsonId).bake(modelLoader, spriteLoader, modelBakeSettings, myJsonId);
        return new TeaMakerModel(spriteLoader.apply(TeaMakerModel.TEXTURES.get(0)), spriteLoader, exteriorModel);
    }
}