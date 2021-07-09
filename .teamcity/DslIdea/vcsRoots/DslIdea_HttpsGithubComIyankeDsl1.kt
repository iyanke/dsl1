package DslIdea.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object DslIdea_HttpsGithubComIyankeDsl1 : GitVcsRoot({
    uuid = "07d72c67-bd6a-461b-af6e-1e1c5785b180"
    name = "https://github.com/iyanke/dsl1/"
    url = "https://github.com/iyanke/dsl1"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "iyanke"
        password = "zxx70612cf7d0faead55254cb740f4374977cfb90553eab154064c1df14a1aa783eafbb95d2a1c13585775d03cbe80d301b"
    }
    param("useAlternates", "true")
})
