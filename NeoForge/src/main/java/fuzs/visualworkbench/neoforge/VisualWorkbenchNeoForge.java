package fuzs.visualworkbench.neoforge;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.visualworkbench.common.VisualWorkbench;
import fuzs.visualworkbench.common.data.tags.ModBlockTagsProvider;
import net.neoforged.fml.common.Mod;

@Mod(VisualWorkbench.MOD_ID)
public class VisualWorkbenchNeoForge {

    public VisualWorkbenchNeoForge() {
        ModConstructor.construct(VisualWorkbench.MOD_ID, VisualWorkbench::new);
        DataProviderBuilder.of(VisualWorkbench.MOD_ID).addProvider(ModBlockTagsProvider::new);
    }
}
