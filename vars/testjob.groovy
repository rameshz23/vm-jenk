def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
            options {
                buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
                }
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
