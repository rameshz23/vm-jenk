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
            
        }
    }
}
