def call() {
    pipeline {
        agent any
        stages {
            stage('Build Docker Image') {
                steps {
                    script {
                        dockerImage = docker.build("labbtest/Node.js-project:latest")
                    }
                }
            }
        }
    }
}
