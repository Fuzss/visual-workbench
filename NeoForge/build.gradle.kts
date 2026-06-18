plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modApi(sharedLibs.puzzleslib.neoforge)
//    compileOnly(sharedLibs.jeiapi.common)
//    localRuntime(sharedLibs.jei.neoforge)
}
