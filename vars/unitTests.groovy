def call() {
    script {
        def status = sh(script: '''
            mvn clean test surefire-report:report-only site -DgenerateReports=false | tee unit-test-report.txt
            echo "Unit tests completed."
        ''', returnStatus: true)

        if (status == 0) {
            echo "Unit tests passed."
        } else {
            echo "Unit tests failed."
            error("Unit Tests Failed!")
        }
    }
}
