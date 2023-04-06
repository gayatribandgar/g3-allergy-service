pipeline{
     agent any
     stages{
     stage('checkout'){
        steps{
        git branch:"main",url:'https://github.com/gayatribandgar/g3-allergy-service.git'
        
        }
         }
         stage('Build'){
            steps{
            sh 'chmod a+x mvnw'
            sh './mvnw clean package -DskipTests=true'
            }
          post{
          always{
          archiveArtifacts 'target/*.jar'
          }
          }
         }
         stage(DockerBuild){
         steps{
         sh 'docker build -t gayatribandgar/g3-allergy-service-demo:allergy-service .'
         }
         }
         
     }
}