def call(String branchName, String repoUrl, String credentialsId) {
    git branch: branchName, url: repoUrl, credentialsId: credentialsId
}
