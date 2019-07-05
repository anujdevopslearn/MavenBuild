node('master') {

stage ('checkout code'){
	checkout scm
}
	
stage ('Build'){
	sh "mvn clean install"
}

stage ('Test Cases Execution'){
	sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test"
}

stage ('Sonar Analysis'){
	//sh 'mvn sonar:sonar -Dsonar.host.url=http://localhost:80'
}

stage ('Publish Junit HTML Report') {
      publishHTML(target: [allowMissing: true, alwaysLinkToLastBuild: false, keepAll: true,
                reportDir: 'target/reports/html', reportFiles: 'index.html', reportName: 'Test Suite HTML Report' ])
}

stage ('Archive Artifacts'){
	archiveArtifacts artifacts: 'target/*.war'
}
	
stage ('Deployment'){
	sh 'cp target/*.war /opt/tomcat8/webapps'
}
}
