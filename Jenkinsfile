node() {

	def sonarScanner = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
	stage('Code'){
		checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/anujdevopslearn/MavenBuild']]]
	}
	
	stage('Build Automation'){
		sh """
			ls -alrt
			mvn clean install
		"""
	}

	stage('Archive Artifacts'){

	}
	
	stage('Code Review'){
		withSonarQubeEnv(credentialsId: 'SonarQubeCreds') {
			//sh "${sonarScanner}/bin/sonar-scanner"
		}
	}
	
	stage('Deployment'){
		deploy adapters: [tomcat9(credentialsId: 'TomcatCreds', path: '', url: 'http://3.233.237.166:8080/')], contextPath: 'CounterApp', onFailure: false, war: 'target/*.war'
	}	
	
	stage('Notification'){
		
	}
}
