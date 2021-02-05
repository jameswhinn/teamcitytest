import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2020.2"

project {
    description = "Contains all other projects"

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(Teamcitytest)
}


object Teamcitytest : Project({
    name = "Teamcitytest"

    vcsRoot(Teamcitytest_HttpsGithubComJameswhinnTeamcitytestGitRefsHeadsMain)

    buildType(Teamcitytest_Build)
})

object Teamcitytest_Build : BuildType({
    name = "Build"

    vcs {
        root(Teamcitytest_HttpsGithubComJameswhinnTeamcitytestGitRefsHeadsMain)
    }

    steps {
        script {
            scriptContent = "echo 'Hello world!'"
        }
    }

    triggers {
        vcs {
        }
    }
})

object Teamcitytest_HttpsGithubComJameswhinnTeamcitytestGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/jameswhinn/teamcitytest.git#refs/heads/main"
    url = "https://github.com/jameswhinn/teamcitytest.git"
    branch = "refs/heads/main"
})
