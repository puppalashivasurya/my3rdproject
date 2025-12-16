pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/puppalashivasurya/my3rdproject.git'
            }
        }

        stage('Build & Unit Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh '''
                      mvn sonar:sonar \
                      -Dsonar.projectKey=my3rdproject \
                      -Dsonar.projectName=my3rdproject
                    '''
                }
            }
        }

        stage('Sonar Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Trivy File System Scan') {
            steps {
                sh 'trivy fs --severity HIGH,CRITICAL --exit-code 1 .'
            }
        }
    }

    post {
        success {
            echo "✅ CI PASSED for my3rdproject"
        }
        failure {
            echo "❌ CI FAILED – Fix issues before merge"
        }
    }
}
