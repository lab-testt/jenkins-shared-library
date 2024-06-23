// File: vars/dockerLoginAndPush.groovy

def call(body) {
    // Default parameters
    def params = [:]

    // Evaluate the body block, allowing overrides of defaults
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = params
    body()

    // Stage code
    stage('Docker Login and Push') {
        steps {
            script {
                withCredentials([usernamePassword(credentialsId: params.credentialsId ?: 'dockerhub', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
                }
                dockerImage.push('latest')
            }
        }
    }
}
