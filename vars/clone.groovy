def call(String branchName, String repoUrl, String credentialsId) {
    checkout([
        $class: 'GitSCM',
        branches: [[name: branchName]],
        extensions: [],
        userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
    ])
}
