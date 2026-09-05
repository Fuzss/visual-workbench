package fuzs.visualworkbench.neoforge.mixin.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import fuzs.visualworkbench.handler.BlockConversionHandler;
import net.minecraft.client.resources.model.BlockStateModelLoader;
import net.minecraft.world.level.block.state.BlockState;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(BlockStateModelLoader.class)
abstract class BlockStateModelLoaderNeoForgeMixin {

    @WrapWithCondition(method = "lambda$loadBlockStateDefinitions$10",
                       at = @At(value = "INVOKE",
                                target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"),
                       slice = @Slice(to = @At(value = "FIELD",
                                               target = "Lnet/minecraft/client/resources/model/BlockStateModelLoader;missingModel:Lnet/minecraft/client/resources/model/BlockStateModelLoader$LoadedModel;",
                                               opcode = Opcodes.GETFIELD)))
    private boolean loadBlockStateDefinitions(Logger logger, String format, Object arg1, Object arg2, @Local(argsOnly = true) BlockState blockState) {
        return !BlockConversionHandler.getBlockConversions().containsValue(blockState.getBlock());
    }
}
