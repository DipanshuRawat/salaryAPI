def call(String slackChannel, String emailRecipients, String jobName, String buildNumber, String buildUrl) {
    slackSend(channel: slackChannel, color: 'danger', username: 'Jenkins CI', message: "Build Failed: Job Name: ${jobName}, Build No: ${buildNumber}, Build URL: ${buildUrl}")

    emailext(
        attachmentsPattern: "target/dependency-check-report.html, unit-test-report.txt, zap_report.html",
        body: """
            Hello,

            The Jenkins pipeline *${jobName}* has failed on *Build #${buildNumber}*.

            *Job Details:*
            - *Job Name:* ${jobName}
            - *Build Number:* ${buildNumber}
            - *Build URL:* ${buildUrl}

            Please review logs and reports for more details.

            Regards,  
            Jenkins CI
            Zero Downtime Crew
        """,
        subject: "Jenkins Pipeline FAILED: ${jobName} #${buildNumber}",
        to: emailRecipients
    )
}
