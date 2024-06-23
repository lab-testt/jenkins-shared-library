// shared-library-repo/vars/dockerLoginAndPush.groovy

def call(String dockerImage, String credentialsId) {
    pipeline {
        agent any
        stages {
            stage('Docker Login and Push') {
                steps {
                    script {
                        withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                            sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
                        }
                        docker.image(dockerImage).push()
                    }
                }
            }
        }
    }
}
