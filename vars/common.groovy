import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.io.FileType
import groovy.json.JsonSlurper

def prepareEnv(){
    jobID = "fa6f7c2ae9364ad39ce13b015e444c6b"
    env.jsonfilename = "$jobID" + "." + "json"
    jsonFile1 = "$WORKSPACE/input.json"
    def json1 = readJSON file: jsonFile1
    env.os = json1['hostname']
    env.hostname = json1['ip']
    env.ip = json1['os']
    

    // condition to verify input json fileExists
    sh """
      if [ -f inputfile.json ]; then
         echo env.os
         echo env.hostname
      else
         echo no file found 
      fi
    """
 }
