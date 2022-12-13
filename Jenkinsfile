peline{
agent any
stages('CI CD Pipeline'){
  stage('Code Checkout'){
    steps{
        script{
            git credentialsId: '93fbadc6-1fc5-46d9-8bda-b67732367557', url: 'https://github.com/Mujeeb78/MavenBuild.git'            }
        }
    }
  
  stage('Build'){
    steps{
        script{
            sh "mvn clean install -Dmaven.test.skip=true"
        }
    }  
  }
  stage('Test'){
    steps{
        script{
            sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test"
        }
    }  
  }
}
}
