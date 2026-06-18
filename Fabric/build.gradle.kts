import fuzs.multiloader.extension.commonProject
import fuzs.multiloader.extension.packageName

plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
//    compileOnly(sharedLibs.jeiapi.common)
//    localRuntime(sharedLibs.jei.fabric)
}

//multiloader {
//    modFile {
//        json {
//            entrypoint(
//                "jei_mod_plugin",
//                "${project.group}.${project.commonProject.packageName}.integration.jei.VisualWorkbenchJEIPlugin"
//            )
//        }
//    }
//}
