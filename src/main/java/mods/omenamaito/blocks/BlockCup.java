package mods.omenamaito.blocks;

import mods.omenamaito.registry.OMTBlocks;
import mods.omenamaito.registry.OMTCups;
import mods.omenamaito.registry.OMTProperties;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockCup extends GlassBlock {
    public static final DirectionProperty FACING;
    public static final VoxelShape BOUNDING_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);
    public BlockCup(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        return BOUNDING_SHAPE;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (!player.getMainHandStack().isEmpty()){
            return ActionResult.FAIL;
        } else {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            if (!player.inventory.insertStack(new ItemStack(state.getBlock().asItem()))){ player.dropItem(new ItemStack(state.getBlock().asItem()),false); }
            return ActionResult.SUCCESS;}
    }

    /*@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        super.appendProperties(stateManager);
        stateManager.add(VARIANT);
    }
    static {VARIANT= OMTProperties.VARIANT;}*/

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }
    static {
        FACING = HorizontalFacingBlock.FACING;
    }
    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView view, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing());
    }

    @Environment(EnvType.CLIENT)
    @Override
    public boolean isTranslucent(BlockState state, BlockView view, BlockPos pos) {
        return false;
    }
}
