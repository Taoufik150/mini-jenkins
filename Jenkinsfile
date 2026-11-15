pipeline {

    agent any

    tools {
        nodejs 'NodeJS-22'
    }

    options {
        timeout(time: 10, unit: 'MINUTES')
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Environment') {
            steps {
                sh '''
                    java -version
                    mvn -version
                    node -v
                    npm -v
                '''
            }
        }

        stage('Backend - Build & Test') {
            steps {
                dir('backend') {
                    sh 'mvn -B clean verify'
                }
            }
            post {
                always {
                    junit 'backend/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Frontend - Test') {
            steps {
                dir('frontend') {
                    sh 'npm test'
                }
            }
        }

        stage('Frontend - Build') {
            steps {
                dir('frontend') {
                    sh 'npm run build'
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'backend/target/*.jar, frontend/dist/**', fingerprint: true
            }
        }

        stage('Deploy (simule)') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploiement simule : seulement sur la branche main'
            }
        }
    }

    post {
        success {
            echo "SUCCESS sur ${env.BRANCH_NAME}"
        }
        failure {
            echo "FAILURE sur ${env.BRANCH_NAME}"
        }
    }
}
