pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "practice"
//include(":api")

include(":core-domain")
include(":core-utils")
include(":core-common")
include(":core-network")
include(":core-validation")
include(":core-ui")

include(":feature-auth")
include(":feature-users")
include(":app")

include(":core-database")

include(":feature-calculation")
include(":feature-deposits")
include(":core-session")
