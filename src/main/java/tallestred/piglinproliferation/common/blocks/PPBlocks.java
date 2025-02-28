package tallestred.piglinproliferation.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tallestred.piglinproliferation.PiglinProliferation;

@Mod.EventBusSubscriber(modid = PiglinProliferation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PPBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PiglinProliferation.MODID);
    public static final RegistryObject<Block> PIGLIN_BRUTE_HEAD = BLOCKS.register("piglin_brute_head", () -> new PiglinSkullBlock(PiglinSkullBlock.Types.PIGLIN_BRUTE, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PIGLIN_BRUTE_HEAD_WALL = BLOCKS.register("piglin_brute_wall_head", () -> new PiglinWallSkullBlock(PiglinSkullBlock.Types.PIGLIN_BRUTE, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ZOMBIFIED_PIGLIN_HEAD = BLOCKS.register("zombified_piglin_head", () -> new PiglinSkullBlock(PiglinSkullBlock.Types.ZOMBIFIED_PIGLIN, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ZOMBIFIED_PIGLIN_HEAD_WALL = BLOCKS.register("zombified_piglin_wall_head", () -> new PiglinWallSkullBlock(PiglinSkullBlock.Types.ZOMBIFIED_PIGLIN, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PIGLIN_ALCHEMIST_HEAD = BLOCKS.register("piglin_alchemist_head", () -> new PiglinSkullBlock(PiglinSkullBlock.Types.PIGLIN_ALCHEMIST, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PIGLIN_ALCHEMIST_HEAD_WALL = BLOCKS.register("piglin_alchemist_wall_head", () -> new PiglinWallSkullBlock(PiglinSkullBlock.Types.PIGLIN_ALCHEMIST, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    //public static final RegistryObject<Block> PIGLIN_TRAVELLER_HEAD = BLOCKS.register("piglin_traveller_head", () -> new PiglinSkullBlock(PiglinSkullBlock.Types.PIGLIN_TRAVELLER, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
    //public static final RegistryObject<Block> PIGLIN_TRAVELLER_HEAD_WALL = BLOCKS.register("piglin_traveller_wall_head", () -> new PiglinWallSkullBlock(PiglinSkullBlock.Types.PIGLIN_TRAVELLER, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));
}
