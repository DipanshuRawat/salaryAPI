def call(String emailRecipients, String jobName, String buildNumber, String buildUrl) {
    emailext(
        subject: "FAILURE: Job '${jobName}' (${buildNumber})",
        body: """
            Job: ${jobName}
            Build Number: ${buildNumber}
            Build URL: ${buildUrl}
        """,
        to: emailRecipients
    )
}
