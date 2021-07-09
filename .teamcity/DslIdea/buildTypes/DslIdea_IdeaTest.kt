package DslIdea.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.ideaDuplicates
import jetbrains.buildServer.configs.kotlin.v2019_2.ideaInspections
import jetbrains.buildServer.configs.kotlin.v2019_2.ideaRunner

object DslIdea_IdeaTest : BuildType({
    name = "IDEA_test"

    params {
        param("444", "%system.teamcity.debug.dump.parameters%")
        param("system.path.macro.MAVEN.REPOSITORY", ".m2")
        param("env.JDK_16", """C:\Java_16""")
    }

    vcs {
        root(DslIdea.vcsRoots.DslIdea_HttpUnit1413LabsIntelliJNetSvnIdea)
    }

    steps {
        ideaRunner {
            pathToProject = ""
            jdk {
                name = "1.6"
                path = "%env.JDK_16%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            jdk {
                name = "1.8"
                path = "%env.JDK_18%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            pathvars {
                variable("MAVEN_REPOSITORY", "%system.path.macro.MAVEN.REPOSITORY%")
            }
            jvmArgs = "-Xmx256m"
        }
        ideaDuplicates {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = ""
            jdk {
                name = "1.6"
                path = "%env.JDK_16%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            jdk {
                name = "1.8"
                path = "%env.JDK_18%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            pathvars {
                variable("MAVEN_REPOSITORY", "%system.path.macro.MAVEN.REPOSITORY%")
            }
            jvmArgs = "-Xmx1G -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
            lowerBound = 10
            discardCost = 0
            distinguishMethods = true
            distinguishTypes = true
            distinguishLiterals = true
            extractSubexpressions = true
        }
        ideaInspections {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = ""
            jdk {
                name = "1.6"
                path = "%env.JDK_16%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            jdk {
                name = "1.8"
                path = "%env.JDK_18%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            pathvars {
                variable("MAVEN_REPOSITORY", "%system.path.macro.MAVEN.REPOSITORY%")
            }
            jvmArgs = "-Xmx512m -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
        }
    }
})
