package mods.omenamaito.client.models;

import grondag.fermion.client.models.SimpleModel;
import mods.omenamaito.registry.OMTCups;
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
import net.minecraft.block.Block;
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
import static mods.omenamaito.registry.OMTItems.CUPS;

public class YunomiModel extends SimpleModel{
    private final BakedModel YunomiJSONModel;
    private final BakedModel SummerCupJSONModel;
    private final BakedModel CupJSONModel;
    protected final Sprite[] fluidSprite=new Sprite[TEXTURES.size()];
    protected final Renderer renderer = RendererAccess.INSTANCE.getRenderer();
    protected final RenderMaterial outerMaterial = renderer.materialFinder().blendMode(0, BlendMode.TRANSLUCENT).find();

    public YunomiModel(Sprite sprite, Function<SpriteIdentifier, Sprite> spriteMap, BakedModel exteriorModel,BakedModel exteriorModel2,BakedModel exteriorModel3) {
        super(sprite, ModelHelper.MODEL_TRANSFORM_BLOCK);
        this.YunomiJSONModel=exteriorModel;
        this.SummerCupJSONModel=exteriorModel2;
        this.CupJSONModel=exteriorModel3;
        for (int i = 0; i < fluidSprite.length; i++) {
            fluidSprite[i] = spriteMap.apply(TEXTURES.get(i));
        }
    }

    @Override
    public final void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
        final QuadEmitter qe = context.getEmitter();
        final Direction up=Direction.UP;
        final Block block=state.getBlock();
        for(Object cup:CUPS.keySet()){
            if (block.asItem().equals(cup)) {
                if (block.asItem().toString().contains("_yunomi")){ context.fallbackConsumer().accept(YunomiJSONModel); }
                else if (block.asItem().toString().contains("_summer_cup")){ context.fallbackConsumer().accept(SummerCupJSONModel); }
                else {context.fallbackConsumer().accept(CupJSONModel);}
                int color=CUPS.getInt(cup);
                qe.material(outerMaterial)
                        .square(up, 0.375f, 0.375f, 0.625f, 0.625f, 0.625f)
                        .spriteColor(0, color,color,color,color)
                        .spriteBake(0, fluidSprite[0], MutableQuadView.BAKE_LOCK_UV)
                        .emit();
            }
        }
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        final QuadEmitter qe = context.getEmitter();
        final Direction up=Direction.UP;
        final Item item=stack.getItem();
        if (item.getTranslationKey().contains("_yunomi")){ context.fallbackConsumer().accept(YunomiJSONModel); }
        else if (item.getTranslationKey().contains("_summer_cup")){ context.fallbackConsumer().accept(SummerCupJSONModel); }
        else {context.fallbackConsumer().accept(CupJSONModel);}
        for(Object cup:CUPS.keySet()){
            if (item.equals(cup)) {
                int color=CUPS.getInt(cup);
                qe.material(outerMaterial)
                        .square(up, 0.375f, 0.375f, 0.625f, 0.625f, 0.625f)
                        .spriteColor(0, color,color,color,color)
                        .spriteBake(0, fluidSprite[0], MutableQuadView.BAKE_LOCK_UV)
                        .emit();
            }
        }
    }

    protected final void emitQuads(QuadEmitter qe) { }

    @Override
    protected Mesh createMesh() {
        final MeshBuilder mb = renderer.meshBuilder();
        emitQuads(mb.getEmitter());
        return mb.build();
    }
}