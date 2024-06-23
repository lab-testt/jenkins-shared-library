// File: vars/buildDockerImage.groovy

def call(body) {
    // Default parameters
    def params = [:]

    // Evaluate the body block, allowing overrides of defaults
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = params
    body()

    // Stage code
    stage('Build Docker Image') {
        steps {
            script {
                dockerImage = docker.build("${params.dockerImage}:latest")
            }
        }
    }
}
