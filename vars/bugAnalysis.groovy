def call() {
    sh 'mvn spotbugs:check > spotbugs-check-output.txt'
}
