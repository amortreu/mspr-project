pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'Java11'
    }
    stages {
        stage('prepare') {
            steps {
                echo "Prepare"
            }
        }
        stage('build') {
            steps {
               sh 'mvn compile'
            }
        }
        stage('test') {
            steps {
               sh 'mvn test'
            }
        }
         stage('package') {
            steps {
               sh 'mvn package'
            }
        }
        stage('execute') {
            steps {
               //sh 'cd target && java -cp maven-hello-1.0.0-SNAPSHOT.jar fr.epsi.demo.Helloworld'
               echo "execute"
            }
        }
    }
     post {
        always {
            sh 'ls target/'
            //junit '**/surefire-reports/*.xml'
        }
    }
}
