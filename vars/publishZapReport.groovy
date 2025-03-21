def call(String zapReport) {
    publishHTML([ 
        allowMissing: false, 
        alwaysLinkToLastBuild: false, 
        reportDir: '', 
        reportFiles: zapReport, 
        reportName: 'ZAP Report',
        keepAll: true
    ])
}
