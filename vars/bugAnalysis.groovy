def call(String projectKeyName, String sonarToken) {
    withSonarQubeEnv('sonar') {
        withCredentials([string(credentialsId: sonarToken, variable: 'soanr_token')]) {
            sh '''
            mvn clean verify sonar:sonar \
              -Dsonar.projectKey=JAVA-Bug \
              -Dsonar.host.url=http://3.80.43.200:9000 \
              -Dsonar.login=${sonar_token}
            '''
        }
    }
}
