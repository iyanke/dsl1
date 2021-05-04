import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ideaDuplicates
import jetbrains.buildServer.configs.kotlin.v2019_2.ideaInspections
import jetbrains.buildServer.configs.kotlin.v2019_2.ideaRunner
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.SvnVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    vcsRoot(HttpUnit1413LabsIntelliJNetSvnIdea)

    buildType(IdeaTest)

    params {
        password("system.teamcity.debug.dump.parameters", "zxx49a26687813dd72245f2b24babecd2a3")
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

    subProject(ProjectToBreak1)
}

object IdeaTest : BuildType({
    name = "IDEA_test"

    params {
        param("444", "%system.teamcity.debug.dump.parameters%")
        param("system.path.macro.MAVEN.REPOSITORY", ".m2")
        param("env.JDK_16", """C:\Java_16""")
    }

    vcs {
        root(HttpUnit1413LabsIntelliJNetSvnIdea)
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

object HttpUnit1413LabsIntelliJNetSvnIdea : SvnVcsRoot({
    name = "http://UNIT-1413.Labs.IntelliJ.Net/svn/idea/"
    url = "http://UNIT-1413.Labs.IntelliJ.Net/svn/idea/"
    userName = "admin1"
    password = "zxxb7b6b3cd34f24f95"
})


object ProjectToBreak1 : Project({
    name = "Project to break1"

    template(ProjectToBreak1_Template1)
})

object ProjectToBreak1_Template1 : Template({
    name = "template1"

    steps {
        script {
            id = "RUNNER_14"
            scriptContent = "echo template"
        }
    }
})
