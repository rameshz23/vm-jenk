def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    pipeline {
    agent any
    stages {
        stage ('Example') {
            steps {
                // log.info 'Starting' 
                script { 
                    log.info 'Starting'
                    log.warning 'Nothing to do!'
                }
            }
        }
    }
}
}
