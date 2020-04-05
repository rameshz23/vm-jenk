import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.io.FileType
import groovy.json.JsonSlurper

def prepareEnv(){

    env.jsonfilename = "$jobID" + "." + "json"

    // condition to verify input json fileExists
    sh """
      //if [ -f inputfile.json ]; then
         echo "file condition"
      else
         cp -f /var/vmlist/$env.jsonfilename $WORKSPACE/inputfile.json
      fi
    """
 }
