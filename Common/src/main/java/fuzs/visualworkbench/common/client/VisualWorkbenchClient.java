package fuzs.visualworkbench.common.client;

import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.client.core.v1.context.BlockEntityRenderersContext;
import fuzs.puzzleslib.common.api.client.core.v1.context.BlockStateResolverContext;
import fuzs.puzzleslib.common.api.client.core.v1.context.MenuScreensContext;
import fuzs.puzzleslib.common.api.client.event.v1.ClientTagsUpdatedCallback;
import fuzs.puzzleslib.common.api.client.renderer.v1.model.ModelLoadingHelper;
import fuzs.puzzleslib.common.api.event.v1.core.EventPhase;
import fuzs.visualworkbench.common.VisualWorkbench;
import fuzs.visualworkbench.common.client.handler.BlockStateTranslator;
import fuzs.visualworkbench.common.client.renderer.blockentity.CraftingTableBlockEntityRenderer;
import fuzs.visualworkbench.common.handler.BlockConversionHandler;
import fuzs.visualworkbench.common.init.ModRegistry;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.BlockStateModelLoader;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;

public class VisualWorkbenchClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        ClientTagsUpdatedCallback.EVENT.register(EventPhase.FIRST,
                BlockConversionHandler.onClientTagsUpdated(ModRegistry.UNALTERED_WORKBENCHES_BLOCK_TAG,
                        VisualWorkbench.BLOCK_PREDICATE)::accept);
    }

    @Override
    public void onRegisterBlockStateResolver(BlockStateResolverContext context) {
        BlockConversionHandler.getBlockConversions().forEach((Block oldBlock, Block newBlock) -> {
            context.registerBlockStateResolver(newBlock,
                    (ResourceManager resourceManager, Executor executor) -> {
                        return ModelLoadingHelper.loadBlockState(resourceManager, oldBlock, executor);
                    },
                    (BlockStateModelLoader.LoadedModels loadedModels, BiConsumer<BlockState, BlockStateModel.UnbakedRoot> blockStateConsumer) -> {
                        Map<BlockState, BlockState> blockStates = BlockStateTranslator.INSTANCE.convertAllBlockStates(
                                newBlock,
                                oldBlock);
                        for (BlockState blockState : newBlock.getStateDefinition().getPossibleStates()) {
                            BlockStateModel.UnbakedRoot model = loadedModels.models().get(blockStates.get(blockState));
                            if (model != null) {
                                blockStateConsumer.accept(blockState, model);
                            } else {
                                VisualWorkbench.LOGGER.warn("Missing model for variant: '{}'", blockState);
                                blockStateConsumer.accept(blockState, ModelLoadingHelper.missingModel());
                            }
                        }
                    });
        });
    }

    @Override
    public void onRegisterMenuScreens(MenuScreensContext context) {
        context.registerMenuScreen(ModRegistry.CRAFTING_MENU_TYPE.value(), CraftingScreen::new);
    }

    @Override
    public void onRegisterBlockEntityRenderers(BlockEntityRenderersContext context) {
        context.registerBlockEntityRenderer(ModRegistry.CRAFTING_TABLE_BLOCK_ENTITY_TYPE.value(),
                CraftingTableBlockEntityRenderer::new);
    }
}
