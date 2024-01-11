pluginManagement {
    repositories {
        maven("https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
}

rootProject.name = "ops-demo"

include("ops-mvndm")
include("ops-common")

// ucenter
include("ops-ucenter-app")
include(":ops-ucenter-app:ops-ucenter-app-api")
include(":ops-ucenter-app:ops-ucenter-app-web")

rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
    project.children.forEach { p ->
        p.buildFileName = "${p.name}.gradle.kts"
    }
}
