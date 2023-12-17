pipeline {
	agent any
//	agent { label "slave" }
	environment {
		gitURL="https://github.com/anujdevopslearn/MavenBuild.git"
	}
	stages{
		stage("Code Checkout"){
			steps{
				git changelog: false, credentialsId: 'GitHubCreds', poll: false, url: gitURL
			}
		}
		stage("Code Build"){
			steps{
				sh """
					ls -lart
					mvn clean install
				"""
			}
		}
	}
}
