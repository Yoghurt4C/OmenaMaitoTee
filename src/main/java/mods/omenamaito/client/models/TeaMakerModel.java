package mods.omenamaito.client.models;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.BlendMode;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import grondag.fermion.client.models.SimpleModel;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class TeaMakerModel extends SimpleModel{
    private final BakedModel TeaMakerJSONModel;
    public static final List<SpriteIdentifier> TEXTURES = ImmutableList.of(
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("minecraft:block/water_still")),

            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("minecraft:block/quartz_block_top")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("omenamaitotee:block/summer_cup")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("omenamaitotee:block/jp_cup"))
            );

    protected final Sprite fluidBase;
    protected final Sprite[] fluidSprite=new Sprite[TEXTURES.size()];
    protected final Renderer renderer = RendererAccess.INSTANCE.getRenderer();
    protected final RenderMaterial outerMaterial = renderer.materialFinder().blendMode(0, BlendMode.TRANSLUCENT).find();

    public TeaMakerModel(Sprite sprite, Function<SpriteIdentifier, Sprite> spriteMap, BakedModel exteriorModel) {
        super(sprite, ModelHelper.MODEL_TRANSFORM_BLOCK);
        this.TeaMakerJSONModel=exteriorModel;
        fluidBase = spriteMap.apply(new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("minecraft:block/water_still")));
        for (int i = 0; i < fluidSprite.length; i++) {
            fluidSprite[i] = spriteMap.apply(TEXTURES.get(i));
        }
    }

    @Override
    public final void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
        final QuadEmitter qe = context.getEmitter();
        context.fallbackConsumer().accept(TeaMakerJSONModel);
        emitQuads(qe);
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        final QuadEmitter qe = context.getEmitter();
        context.fallbackConsumer().accept(TeaMakerJSONModel);
        emitQuads(qe);
    }

    @Override
    protected Mesh createMesh() {
        final MeshBuilder mb = renderer.meshBuilder();
        emitQuads(mb.getEmitter());
        return mb.build();
    }

    protected final void emitQuads(QuadEmitter qe) {
        emitFluidFace(qe, Direction.UP);
        emitFluidSide(qe, Direction.EAST);
        emitFluidSide(qe, Direction.WEST);
        emitFluidSide(qe,Direction.NORTH);
        emitFluidSide(qe,Direction.SOUTH);
    }

    protected void emitFluidFace(QuadEmitter qe, Direction face) {
        qe.material(outerMaterial)
                .square(face, 0.26f, 0.26f, 0.74f, 0.74f, 0.32f)
                .spriteColor(0, -1, -1, -1, -1)
                .spriteBake(0, fluidBase, MutableQuadView.BAKE_LOCK_UV)
                .emit();
    }
    protected void emitFluidSide(QuadEmitter qe, Direction face) {
        qe.material(outerMaterial)
                .square(face, 0.3f, 0.15f, 0.7f, 0.68f, 0.26f)
                .spriteColor(0, -1, -1, -1, -1)
                .spriteBake(0, fluidBase, MutableQuadView.BAKE_LOCK_UV)
                .emit();
    }
}