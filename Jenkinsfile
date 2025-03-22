@Library('my-Library') _

pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        BRANCH_NAME = 'main'
        REPO_URL = 'https://github.com/Snaatak-Skyops/salary-api.git'
        EMAIL_RECIPIENTS = "princerawat2108@gmail.com"
        ZAP_REPORT = 'zap_report.html'
        URL_ZAP_ATTACK = 'http://3.80.43.200:8080/actuator/health'
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWorkspace()
            }
        }

        stage('Clone Repository') {
            steps {
                clone(BRANCH_NAME, REPO_URL, 'Cred')
            }
        }

        stage('Dependency Scanning') {
            steps {
                dependencyScanning()
            }
        }

        stage('Publish Dependency Check Report') {
            steps {
                publishDependencyCheckReport()
            }
        }

        stage('Unit Tests') {
            steps {
                unitTests()
            }
        }

        stage('Static Code Analysis (SpotBugs)') {
            steps {
                sh 'mvn spotbugs:check > spotbugs-check-output.txt' 
            }
        }

        stage('Static Code Analysis (SpotBugs)') {
            steps {
                sh 'mvn spotbugs:check > spotbugs-check-output.txt'
            }
        }

        stage('DAST') {
            steps {
                dast(URL_ZAP_ATTACK, ZAP_REPORT)
            }
        }

        stage('Publish ZAP Report') {
            steps {
                publishZapReport(ZAP_REPORT)
            }
        }
    }

    post {
        always {
            postAlways()
        }

        success {
            postSuccess(EMAIL_RECIPIENTS, env.JOB_NAME, env.BUILD_NUMBER, env.BUILD_URL)
        }

        failure {
            postFailure(EMAIL_RECIPIENTS, env.JOB_NAME, env.BUILD_NUMBER, env.BUILD_URL)
        }
    }
}
