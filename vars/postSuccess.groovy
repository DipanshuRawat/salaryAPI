def call(String slackChannel, String emailRecipients, String jobName, String buildNumber, String buildUrl) {
    slackSend(channel: slackChannel, color: 'good', username: 'Jenkins CI', message: "Build Successful: Job Name: ${jobName}, Build No: ${buildNumber}, Build URL: ${buildUrl}")

    emailext(
        attachmentsPattern: "target/dependency-check-report.html, unit-test-report.txt, zap_report.html",
        body: """
            Hello,

            The Jenkins pipeline *${jobName}* has completed successfully on *Build #${buildNumber}*.

            *Build Details:*
            - *Job Name:* ${jobName}
            - *Build Number:* ${buildNumber}
            - *Build URL:* ${buildUrl}

            You can find the following reports attached:
            - Dependency Check Report
            - Unit Test Report
            - ZAP Report

            Best regards,  
            Jenkins CI
            Zero Downtime Crew
        """,
        subject: "Jenkins Build SUCCESS: ${jobName} #${buildNumber}",
        to: emailRecipients
    )
}
