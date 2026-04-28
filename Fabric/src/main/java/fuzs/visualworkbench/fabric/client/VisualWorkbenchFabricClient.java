package fuzs.visualworkbench.fabric.client;

import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.visualworkbench.common.VisualWorkbench;
import fuzs.visualworkbench.common.client.VisualWorkbenchClient;
import net.fabricmc.api.ClientModInitializer;

public class VisualWorkbenchFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(VisualWorkbench.MOD_ID, VisualWorkbenchClient::new);
    }
}
