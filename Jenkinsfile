@Library('my-Library') _

pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        branch_name = 'main'
        repo_url = 'https://github.com/Snaatak-Skyops/salary-api.git'
        EMAIL_RECIPIENTS = "princerawat2108@gmail.com"
        ZAP_REPORT = 'zap_report.html'
        Url_ZAP_Attack = 'http://3.80.43.200:8080/actuator/health'
        SONARQUBE_URL = 'http://3.80.43.200:9000/'
        // SONAR_PROJECT_KEY = 'salary-api'
        // projectKey_name = 'JAVA-Bug'
        // SONAR_CREDENTIALS_ID = 'sonar_token' // Using the correct credential ID
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWorkspace()
            }
        }

        stage('Clone Repository') {
            steps {
                clone(branch_name, repo_url, 'Cred')
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

        stage('Bug Analysis') {
            steps {
                bugAnalysis('Staticcode', 'sonar_token') // Passing correct credential ID
            }
        }

        stage('DAST') {
            steps {
                dast(Url_ZAP_Attack, ZAP_REPORT)
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
