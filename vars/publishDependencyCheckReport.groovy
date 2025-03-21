def call() {
    publishHTML([ 
        allowMissing: false, 
        alwaysLinkToLastBuild: true, 
        reportDir: 'target', 
        reportFiles: 'dependency-check-report.html', 
        reportName: 'Dependency Check Report',
        keepAll: true
    ])
}
