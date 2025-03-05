pipeline {
    agent any
     tools {
         // Install the Maven version configured as "M3" and add it to the path.
         maven "M3"
     }
    stages {
        stage('Checkout') {
            steps {
                echo "-------- Checkout on GitHub ---------"
                git branch: 'main', url: 'https://github.com/doulaye12/blog-api.git'
            }
        }
        stage('Build') {
            steps {
                 sh "mvn clean package"
            }

            post {
                 //If Maven was able to run the tests, even if some of the test
                 //failed, record the test results and archive the jar file.
                 success {
                     //junit '**/target/surefire-reports/TEST-*.xml'
                     //archiveArtifacts 'target/*.jar'
                     archiveArtifacts artifacts: '**/*.jar', followSymlinks: false
                 }
            }
        }
        stage('Dockerize') {
            steps {
                echo "dockerize step should be done"
            }
        }
        stage('Docker Publish') {
            steps {
                echo "Publish step should be done"
            }
        }
        stage('Docker Compose') {
            steps {
                echo "Deployment step should be done"
            }
        }
    }
}
