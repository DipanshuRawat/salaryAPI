def call(String projectKeyName, String sonarCredentialsId) {
    withSonarQubeEnv('sonar') {
        withCredentials([string(credentialsId: sonarCredentialsId, variable: 'SONAR_TOKEN')]) {
            sh """
            mvn clean verify sonar:sonar \
              -Dsonar.projectKey=${projectKeyName} \
              -Dsonar.host.url=http://3.80.43.200:9000 \
              -Dsonar.login="$SONAR_TOKEN"
            """
        }
    }
    waitForQualityGate()
}
