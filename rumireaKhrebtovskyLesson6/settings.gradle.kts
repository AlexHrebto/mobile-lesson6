pluginManagement {
    repositories {
        google()
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

rootProject.name = "ru.mirea.Khrebtovsky.Lesson6"
include(":app")
include(":app:internalfilestorage")
include(":app:notebook")
include(":app:employeedb")
include(":app:securesharedpreferences")
