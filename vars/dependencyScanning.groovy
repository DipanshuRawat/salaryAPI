def call() {
    sh 'mvn org.owasp:dependency-check-maven:check'
}
