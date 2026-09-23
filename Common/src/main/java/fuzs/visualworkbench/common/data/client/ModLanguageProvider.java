package fuzs.visualworkbench.common.data.client;

import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.visualworkbench.common.init.ModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(ModRegistry.UNALTERED_WORKBENCHES_BLOCK_TAG, "Unaltered Workbenches");
    }

    @Override
    protected boolean mustHaveTranslationKey(Holder.Reference<?> holder, String translationKey) {
        return !(holder.value() instanceof Block) && super.mustHaveTranslationKey(holder, translationKey);
    }
}
