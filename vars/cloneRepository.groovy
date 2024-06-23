// shared-library-repo/vars/cloneRepository.groovy

def call(String credentialsId, String repositoryUrl) {
    pipeline {
        agent any
        stages {
            stage('Clone Repository') {
                steps {
                    git branch: 'main', credentialsId: credentialsId, url: repositoryUrl
                }
            }
        }
    }
}
