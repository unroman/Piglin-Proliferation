package tallestred.piglinproliferation.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tallestred.piglinproliferation.common.blocks.PPBlocks;

@Mixin(NoteBlock.class)
public abstract class NoteBlockMixin extends Block {
    public NoteBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "playNote", at = @At("TAIL"), cancellable = true)
    private void playNote(Entity p_261664_, BlockState p_261606_, Level p_261819_, BlockPos p_262042_, CallbackInfo ci) {
        if ((p_261819_.getBlockState(p_262042_.above()).is(PPBlocks.PIGLIN_ALCHEMIST_HEAD.get()) || p_261819_.getBlockState(p_262042_.above()).is(PPBlocks.PIGLIN_BRUTE_HEAD.get()) || p_261819_.getBlockState(p_262042_.above()).is(PPBlocks.ZOMBIFIED_PIGLIN_HEAD.get()))) {
            p_261819_.blockEvent(p_262042_, this, 0, 0);
            p_261819_.gameEvent(p_261664_, GameEvent.NOTE_BLOCK_PLAY, p_262042_); // Chicanary
        }
    }
}
