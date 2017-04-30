node {

stage ('build'){
	sh 'mvn clean install'
}

stage ('Test Cases Execution'){
	sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test'
}

stage ('Sonar Analysis'){
	sh 'mvn sonar:sonar'
}
	
stage('Code Coverage ') {
    sh "curl -o result.json 'http://35.154.151.174:9000/sonar/api/resources?resource=com.java:example:java-example&metrics=coverage';sonarCoverage=`jq '.[].msr[].val' result.json`;if [ 1 -eq '\$(echo '\${sonarCoverage} >= 50'| bc)' ]; then echo 'Failed' ;exit 1;else echo 'Passed'; fi"
   }

stage ('Archive Artifacts'){

	archiveArtifacts artifacts: 'target/*.war'
}

input message: "QA Team Approval for Production Deployment?"

stage ('Production Deployment'){

	sh ''
}

}
