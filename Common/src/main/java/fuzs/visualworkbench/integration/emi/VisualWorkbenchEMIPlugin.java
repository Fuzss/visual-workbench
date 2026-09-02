package fuzs.visualworkbench.integration.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.handler.CraftingRecipeHandler;
import fuzs.visualworkbench.init.ModRegistry;

@EmiEntrypoint
public class VisualWorkbenchEMIPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addRecipeHandler(ModRegistry.CRAFTING_MENU_TYPE.value(), new CraftingRecipeHandler());
    }
}
