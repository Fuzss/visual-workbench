plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
    modCompileOnly(sharedLibs.jeiapi.common)
    modLocalRuntime(sharedLibs.jei.fabric)
}

multiloader {
    modFile {
        json {
            entrypoint(
                "jei_mod_plugin",
                "${project.group}.integration.jei.VisualWorkbenchJEIPlugin"
            )
        }
    }
}
