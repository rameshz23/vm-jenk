def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    jobID= "fa6f7c2ae9364ad39ce13b015e444c6b"
    pipeline {
            options {
                buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
                }
	    //parameters {
		//string(name: 'jobID', defaultValue: '' )
                //string(name: 'NEW_BUILDNUMBER', defaultValue: '' )
	   // }    
	    
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
		                sh """ env > envfile
					cat envfile """// log.info 'Starting' 
				
		                script { 
			                   echo USER //log.info 'Starting'
			                   echo SHELL //log.warning 'Nothing to do!'
					currentBuild.displayName = "$env.NEW_BUILDNUMBER"
		                }
		            }
	        }
		stage ('application'){
			steps {
				script {
					echo "current build number: ${currentBuild.number}"
            				echo "previous build number: ${currentBuild.previousBuild.getNumber()}"
					
            
					 echo "prepare environment "
                            		// currentBuild.displayName = "$env.NEW_BUILDNUMBER"
                                         common.prepareEnv()
                                         cleanWs()
				}
			}
		}
            
        }
    }
}
