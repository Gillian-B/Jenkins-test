folder('Tools') {
    description('Folder for miscellaneous tools.')
}

job('Tools/Job_DSL_TEST') {
	steps {
    	shell('echo Hello World!')
    }
}

job('Tools/clone-repository') {
    parameters {
    	stringParam('GIT_REPOSITORY_URL', null, 'Git URL of the repository to clone')
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
        shell 'git clone ${GIT_REPOSITORY_URL}'
    }
}

job('Tools/SEED') {
    parameters {
    	stringParam('GITHUB_NAME', null, 'GitHub repository owner/repo_name')
        stringParam('DISPLAY_NAME', null, 'Display name for the job')
    }
    steps {
        dsl {
            text("job(\"\${DISPLAY_NAME}\") {\n    description(\"\${GITHUB_NAME}\")\n}")
        }
    }
}

job('Tools/SEED2') {
    parameters {
    	stringParam('GITHUB_NAME', null, 'GitHub repository owner/repo_name')
        stringParam('DISPLAY_NAME', null, 'Display name for the job')
    }
    steps {
        dsl {
            text('''job(\"\${DISPLAY_NAME}\") {
    description(\"\${GITHUB_NAME}\")
}''')
        }
    }
}

job('testscm') {
    scm {
        github('Gillian-B/Jenkins-test', 'master')
    }
    wrappers {
        preBuildCleanup()
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        shell 'make fclean'
        shell 'make'
        shell 'make tests_run'
        shell 'make clean'
    }
}
