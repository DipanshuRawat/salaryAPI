def call(String projectKeyName, String sonarToken) {
    withSonarQubeEnv('sonar') {
        withCredentials([string(credentialsId: sonarToken, variable: 'SONARQUBE_TOKEN')]) {
            sh '''
            mvn clean verify sonar:sonar \
              -Dsonar.projectKey="${projectKey_name}" \
              -Dsonar.login="${SONARQUBE_TOKEN}"
            '''
        }
    }
}
