package fuzs.visualworkbench.common.integration.jei;

import fuzs.visualworkbench.common.VisualWorkbench;
import fuzs.visualworkbench.common.init.ModRegistry;
import fuzs.visualworkbench.common.world.inventory.VisualCraftingMenu;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.resources.Identifier;

@JeiPlugin
public class VisualWorkbenchJEIPlugin implements IModPlugin {
    private static final Identifier PLUGIN_ID = VisualWorkbench.id("crafting");

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(VisualCraftingMenu.class,
                ModRegistry.CRAFTING_MENU_TYPE.value(),
                RecipeTypes.CRAFTING,
                1,
                9,
                10,
                36);
    }
}
