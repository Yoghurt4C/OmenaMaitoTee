package mods.omenamaito.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.render.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.ModelIdentifier;
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
        ModelRotation rotation = ModelRotation.X0_Y0;
        if (identifier instanceof ModelIdentifier) {
            final String variant = ((ModelIdentifier) identifier).getVariant();
            if (variant.contains("east")) {
                rotation = ModelRotation.X0_Y90;
            } else if (variant.contains("south")) {
                rotation = ModelRotation.X0_Y180;
            } else if (variant.contains("west")) {
                rotation = ModelRotation.X0_Y270;
            }
        }
        final Identifier myJsonId = new Identifier("omt:block/empty_yunomi");
        final BakedModel exteriorModel = modelLoader.getOrLoadModel(myJsonId).bake(modelLoader, spriteLoader, rotation, myJsonId);
        final Identifier myJsonId2 = new Identifier("omt:block/empty_summer_cup");
        final BakedModel exteriorModel2 = modelLoader.getOrLoadModel(myJsonId2).bake(modelLoader, spriteLoader, rotation, myJsonId2);
        final Identifier myJsonId3 = new Identifier("omt:block/empty_cup");
        final BakedModel exteriorModel3 = modelLoader.getOrLoadModel(myJsonId3).bake(modelLoader, spriteLoader, rotation, myJsonId3);
        return new YunomiModel(spriteLoader.apply(TeaMakerModel.TEXTURES.get(0)), spriteLoader, exteriorModel,exteriorModel2,exteriorModel3);
    }
}