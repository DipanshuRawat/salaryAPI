def call() {
    archiveArtifacts artifacts: '**/target/site/surefire-report.html, unit-test-report.txt, target/dependency-check-report.html, zap_report.html', allowEmptyArchive: true
}
