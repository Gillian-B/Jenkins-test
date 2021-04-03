job('Disk Space Check') {
    description 'testettette'
    steps {
        shell 'df'
    }
}
