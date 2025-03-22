def call(String projectKey, String credentialsId) {
    sh 'mvn spotbugs:check > spotbugs-check-output.txt'
}
