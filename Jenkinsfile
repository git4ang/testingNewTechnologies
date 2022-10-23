pipeline {

    agent any
    stages {
        stage("start pipeline") {
            steps {
                echo "Starting the pipeline..."
            }
        }

        /*
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
        */

        stage("SONARQUBE") {
            steps {
                sh "mvn clean verify sonar:sonar "
                    "-Dsonar.projectKey=newTechnologiesTest "
                    "-Dsonar.host.url=http://localhost:9000 "
                    "-Dsonar.login=sqp_4abec21ee8285dd55d625435e2d4abd2b0b4b3dd"
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