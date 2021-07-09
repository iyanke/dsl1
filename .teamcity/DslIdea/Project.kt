package DslIdea

import DslIdea.buildTypes.*
import DslIdea.vcsRoots.*
import DslIdea.vcsRoots.DslIdea_HttpsGithubComIyankeDsl1
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.versionedSettings

object Project : Project({
    id("DslIdea")
    parentId("_Root")
    name = "DSL IDEA"

    vcsRoot(DslIdea_HttpUnit1413LabsIntelliJNetSvnIdea)
    vcsRoot(DslIdea_HttpsGithubComIyankeDsl1)

    buildType(DslIdea_IdeaTest)

    params {
        password("system.teamcity.debug.dump.parameters", "zxx49a26687813dd72245f2b24babecd2a3")
    }

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "${DslIdea_HttpsGithubComIyankeDsl1.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            allowEditingOfProjectSettings = false
            param("context.a123", "123")
            param("context.depoyment.uri1", "345")
            param("context.deployment.git.repository.uri", "123")
            param("context.depoyment.git.repository.uri", "345")
        }
    }

    cleanup {
        keepRule {
            id = "KEEP_RULE_70"
            keepAtLeast = builds(3)
            dataToKeep = everything()
            applyPerEachBranch = true
            preserveArtifactsDependencies = true
        }
    }
})
