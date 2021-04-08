folder('Tools') {
    description('Folder for miscellaneous tools.')
}

job('Tools/Job_DSL_TEST') {
	steps {
    	shell('echo Hello World!')
    }
}
