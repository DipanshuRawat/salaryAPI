def call() {
    publishHTML([ 
        reportDir: 'security-reports',
        reportFiles: 'dependency-check-report.html',
        reportName: 'Dependency Report'
    ])
}
