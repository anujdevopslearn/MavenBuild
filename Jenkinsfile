node {

stage ('build'){
	checkout scm
	sh 'mvn clean install'
}

stage ('Test Cases Execution'){
	sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test'
}

stage ('Sonar Analysis'){
	sh 'mvn sonar:sonar -Durl=http://localhost:9000/sonar'
}
	
stage('Code Coverage ') {
    sh "curl -o coverage.json 'http://35.154.151.174:9000/sonar/api/measures/component?componentKey=com.java.example:java-example&metricKeys=coverage';sonarCoverage=`jq '.component.measures[].value' coverage.json`;if [ 1 -eq '\$(echo '\${sonarCoverage} >= 50'| bc)' ]; then echo 'Failed' ;exit 1;else echo 'Passed'; fi"
   }

stage ('Archive Artifacts'){
	archiveArtifacts artifacts: 'target/*.war'
}

input message: "QA Team Approval for Production Deployment?"

stage ('Production Deployment'){
	sh 'cp target/*.war /root/apache-tomcat-8.5.14/webapps'
}
}
