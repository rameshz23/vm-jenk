def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
            options {
                buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
                }
	    parameters {

                string(name: 'jobID', defaultValue: '' )
                string(name: 'NEW_BUILDNUMBER', defaultValue: '' )
                //string(name: 'dns_action', defaultValue: '' )
                //file name:'input', description:'contains list of projects to be build'
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
		stage ('application'){
			steps {
				script {
					 echo "prepare environment "
                            		 currentBuild.displayName = "$env.NEW_BUILDNUMBER"
                                         common.prepareEnv()
                                         cleanWs()
				}
			}
		}
	}
}
}
