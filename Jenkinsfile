node() {

	stage('Code'){
		checkout scm
	}
	
	stage('Build Automation'){
		sh """
			ls -alrt
			mvn clean install
		"""
	}

	stage('Archive Artifacts'){

	} 
}
