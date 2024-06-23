// shared-library-repo/vars/buildDockerImage.groovy

def call(String dockerImage) {
    pipeline {
        agent any {
            docker {
                image 'node:14'
            }
        }
        stages {
            stage('Build Docker Image') {
                steps {
                    script {
                        dockerImage = docker.build(dockerImage)
                    }
                }
            }
        }
    }
}
