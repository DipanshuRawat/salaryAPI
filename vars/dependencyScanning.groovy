def call() {
    // Increase timeout to 1 hour
    timeout(time: 1, unit: 'HOURS') {
        sh 'mvn org.owasp:dependency-check-maven:check -Dformat=HTML -DoutputDirectory=target || true' 
    }
}
