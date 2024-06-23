def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent any
        stages {
            stage('Clone Repository') {
                steps {
                    git branch: config.branch, credentialsId: config.credentialsId, url: config.url
                }
            }
        }
    }
}
