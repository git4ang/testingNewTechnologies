pipeline {

    agent any
    stages {
        stage("start pipeline") {
            steps { echo "Starting the pipeline..." }
        }

        /*
        stage("DEV") {
            steps { sh "mvn clean compile" }
        }
        stage("TEST") {
            steps { sh "mvn test" }
        }
        */

        stage("SONARQUBE") {
            steps {
                sh "mvn clean verify sonar:sonar \
                      -Dsonar.projectKey=newTechnologiesTest \
                      -Dsonar.host.url=http://localhost:9000 \
                      -Dsonar.login=sqp_5239e42e7bf251055592ffd36bc066ce11a0eeb3"
            }
        }

        stage("BUILD") {
                    steps { sh "mvn package" }
                }

        stage("end pipeline") {
            steps { echo "Ending the pipeline..." }
        }
    }
}