job('Disk Space Check') {
    description 'testettette'
    steps {
        shell 'df'
    }
}

job('Daily Dose of Satisfaction') {
    description 'fhkgefhrkj;zefl'
    parameters {
    	stringParam('NAME', 'user', 'testeet')
    }
    steps {
        shell 'echo "Hello dear ${NAME}!"'
        shell 'date'
        shell 'echo "This is your DDoS number ${BUILD_NUMBER}."'
    }
}
