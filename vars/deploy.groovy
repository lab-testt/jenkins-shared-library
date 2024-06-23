// File: vars/deploy.groovy

def call(body) {
    // Stage code
    stage('Deploy') {
        steps {
            sh 'docker-compose -f docker-compose.yml up -d'
        }
    }
}
