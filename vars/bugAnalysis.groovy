def call(String projectKeyName, String sonarToken) {
    withSonarQubeEnv('sonar') {
        withCredentials([string(credentialsId: sonarToken, variable: 'SONARQUBE_TOKEN')]) {
            sh '''
            mvn clean verify sonar:sonar \
                -Dsonar.projectKey="${projectKeyName}" \
                -Dsonar.token="${SONARQUBE_TOKEN}"
            '''
        }
    }
}
