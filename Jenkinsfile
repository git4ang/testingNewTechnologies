pipeline {

    agent any
    stages {
        stage("start pipeline") {
            steps {
                echo "Starting the pipeline..."
            }
        }

        stage("DEV") {
            steps {
                sh "mvn clean compile"
            }
        }

        stage("TEST") {
            steps {
                sh "mvn test"
            }
        }

        stage("BUILD") {
                    steps {
                        sh "mvn package"
                    }
                }

        stage("end pipeline") {
            steps {
                echo "Ending the pipeline..."
            }
        }
    }
}