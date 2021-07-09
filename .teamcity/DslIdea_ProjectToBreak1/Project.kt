package DslIdea_ProjectToBreak1

import DslIdea_ProjectToBreak1.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object Project : Project({
    id("DslIdea_ProjectToBreak1")
    parentId("DslIdea")
    name = "Project to break1"

    template(DslIdea_ProjectToBreak1_Template1)
})
