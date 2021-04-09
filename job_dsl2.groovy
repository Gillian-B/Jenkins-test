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
        stringParam('DISPLAY_NAME', null, '“Display name for the job')
    }
    steps {
        dsl {
            text("job(\"${DISPLAY_NAME}\") {\n    description(\"${GITHUB_NAME})\n\"}")
        }
    }
}
