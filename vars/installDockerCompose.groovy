// File: vars/installDockerCompose.groovy

def call(body) {
    // Stage code
    stage('Install Docker Compose') {
        steps {
            sh '''
                apk update
                apk add --no-cache curl jq
                COMPOSE_VERSION=$(curl -s https://api.github.com/repos/docker/compose/releases/latest | jq -r .tag_name)
                curl -L "https://github.com/docker/compose/releases/download/${COMPOSE_VERSION}/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
                chmod +x /usr/local/bin/docker-compose
                docker-compose --version
            '''
        }
    }
}
