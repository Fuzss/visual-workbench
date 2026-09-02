package fuzs.visualworkbench.integration.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import fuzs.visualworkbench.init.ModRegistry;

@EmiEntrypoint
public class VisualWorkbenchEmiPlugin implements EmiPlugin {

    @Override
    public void register(EmiRegistry registry) {
        registry.addRecipeHandler(ModRegistry.CRAFTING_MENU_TYPE.value(), new VisualWorkbenchEmiRecipeHandler());
    }
}
