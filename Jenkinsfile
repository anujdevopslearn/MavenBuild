node() {

	def sonarScanner = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
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
	
	stage ('Deployment'){
		ansiblePlaybook colorized: true, disableHostKeyChecking: true, playbook: 'deploy.yml'
    
	stage('Code Review'){
		withSonarQubeEnv(credentialsId: 'SonarQubeCreds') {
			//sh "${sonarScanner}/bin/sonar-scanner"
		}
	}
	
	stage('Deployment'){
	sh 'Deployed'
	}	
	
	stage('Notification'){
		
	}
}
