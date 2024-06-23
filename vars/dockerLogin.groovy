def call() {
    pipeline {
        agent any
        stages {
            stage('Docker Login and Push') {
                steps {
                    script {
                        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                            sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
                        }
                        dockerImage.push('latest')
                    }
                }
            }
        }
    }
}
