package fuzs.visualworkbench.common.config;

import fuzs.puzzleslib.common.api.config.v3.Config;
import fuzs.puzzleslib.common.api.config.v3.ConfigCore;

public class ServerConfig implements ConfigCore {
    @Config(description = "Leftover vanilla crafting tables will transform when trying to use them.")
    public boolean convertVanillaWorkbenchWhenInteracting = true;
}
