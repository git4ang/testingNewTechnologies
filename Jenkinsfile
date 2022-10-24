pipeline {

    agent any
    stages {
        stage("start pipeline") {
            steps { echo "Starting the pipeline..." }
        }

//         stage("DEV") { steps { sh "mvn clean compile" } }
//         stage("TEST") { steps { sh "mvn test" } }

        stage("SONARQUBE") {
            steps {
                sh "mvn clean verify sonar:sonar \
                      -Dsonar.projectKey=newTechnologiesJ2E \
                      -Dsonar.host.url=http://172.16.194.155:9000 \
                      -Dsonar.login=sqp_bc8b37144c866929fce5bb44e925a8e8d1f2f33e"
            }
        }

//         stage("BUILD") { steps { sh "mvn package" } }

        stage("end pipeline") {
            steps { echo "Ending the pipeline..." }
        }
    }
}