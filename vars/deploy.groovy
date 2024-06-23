// shared-library-repo/vars/deploy.groovy

def call(String dockerComposeFile) {
    pipeline {
        agent any
        stages {
            stage('Deploy') {
                steps {
                    sh "docker-compose -f ${dockerComposeFile} up -d"
                }
            }
        }
    }
}
