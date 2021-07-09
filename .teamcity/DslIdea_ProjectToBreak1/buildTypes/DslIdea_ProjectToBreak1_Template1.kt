package DslIdea_ProjectToBreak1.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object DslIdea_ProjectToBreak1_Template1 : Template({
    name = "template1"

    steps {
        script {
            id = "RUNNER_14"
            scriptContent = "echo template"
        }
    }
})
