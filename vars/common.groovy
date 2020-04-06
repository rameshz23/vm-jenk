import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.io.FileType
import groovy.json.JsonSlurper

def prepareEnv(){
    jobID = "fa6f7c2ae9364ad39ce13b015e444c6b"
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
