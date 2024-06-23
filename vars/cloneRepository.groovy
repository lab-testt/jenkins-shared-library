// File: vars/cloneRepository.groovy

def call(body) {
    // Default parameters
    def params = [:]

    // Evaluate the body block, allowing overrides of defaults
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = params
    body()

    // Stage code
    stage('Clone Repository') {
        steps {
            git branch: params.branch ?: 'main', credentialsId: params.credentialsId ?: 'github', url: params.url
        }
    }
}
