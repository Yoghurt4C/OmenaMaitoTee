package mods.omenamaito.client.models;

import grondag.fermion.client.models.SimpleModel;
import mods.omenamaito.registry.OMTCups;
import mods.omenamaito.registry.OMTItems;
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
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

import static mods.omenamaito.client.models.TeaMakerModel.TEXTURES;
import static mods.omenamaito.registry.OMTItems.*;

public class YunomiModel extends SimpleModel{
    private final BakedModel[] cupModels=new BakedModel[3];
    protected final Sprite[] fluidSprite=new Sprite[TEXTURES.size()];
    protected final Renderer renderer = RendererAccess.INSTANCE.getRenderer();
    protected final RenderMaterial outerMaterial = renderer.materialFinder().blendMode(0, BlendMode.SOLID).find();

    public YunomiModel(Sprite sprite, Function<SpriteIdentifier, Sprite> spriteMap, BakedModel exteriorModel,BakedModel exteriorModel2,BakedModel exteriorModel3) {
        super(sprite, ModelHelper.MODEL_TRANSFORM_BLOCK);
        cupModels[YUNOMI_CUP_MODEL_NUM]=exteriorModel;
        cupModels[SUMMER_CUP_MODEL_NUM]=exteriorModel2;
        cupModels[EMPTY_CUP_MODEL_NUM]=exteriorModel3;
        for (int i = 0; i < fluidSprite.length; i++) {
            fluidSprite[i] = spriteMap.apply(TEXTURES.get(i));
        }
    }

    @Override
    public final void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
        emitQuadsForItem(state.getBlock().asItem(), context);
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        emitQuadsForItem(stack.getItem(), context);
    }

    private void emitQuadsForItem(Item cup, RenderContext context) {
        final QuadEmitter qe = context.getEmitter();
        final Direction up=Direction.UP;

        int color=CUPS.getInt(cup);
        context.fallbackConsumer().accept(cupModels[(color >> 24) & 3]);

        // put solid alpha now that we've used the model index
        color |= 0xFF000000;

        qe.material(outerMaterial)
                .square(up, 0.375f, 0.375f, 0.625f, 0.625f, 0.625f)
                .spriteColor(0, color,color,color,color)
                .spriteBake(0, fluidSprite[0], MutableQuadView.BAKE_LOCK_UV)
                .emit();
    }

    protected final void emitQuads(QuadEmitter qe) {}

    @Override
    protected Mesh createMesh() {
        final MeshBuilder mb = renderer.meshBuilder();
        emitQuads(mb.getEmitter());
        return mb.build();
    }
}