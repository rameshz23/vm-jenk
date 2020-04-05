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
            stage('This one should be skipped') {
                when {
                    expression { false }
                }
                steps {
                    echo "this should be skipped, but it does not ("
                }
            }
            
           // stage('Back-end') {
           // agent {
           //     docker { image 'maven:3-alpine' }
           // }
           // steps {
           //     sh 'mvn --version'
           // }
        //}
        stage ('Example') {
            		steps {
		                sh """ env > envfile """// log.info 'Starting' 
		                script { 
			                   echo $envfile.USER //log.info 'Starting'
			                   echo $envfile.SHELL //log.warning 'Nothing to do!'
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
