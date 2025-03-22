def call() {
    // Increase timeout to 1 hour
    timeout(time: 1, unit: 'HOURS') {
         sh './dependency-check/dependency-check/bin/dependency-check.sh --project "." --scan . --format HTML --out security-reports'
    }
}
