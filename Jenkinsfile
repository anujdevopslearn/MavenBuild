node {

stage ('build'){
	
	sh 'mvn clean install -DskipTests=true'
}

stage ('Test Cases Execution'){

	sh 'mvn clean install -DskipTests=false'
}

stage ('Sonar Analysis'){

	sh 'mvn clean sonar:sonar'
}

stage ('Archive Artifacts'){

	archiveArtifacts artifacts: 'target/*.war'
}

input message: "QA Team Approval for Production Deployment?"

stage ('Production Deployment'){

	sh ''
}

}
