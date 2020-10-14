pipeline {
    agent any
    tools { 
        maven 'M3'
    }
    stages {
        stage ('checkout') {
            steps {
                git branch: 'main', url:'https://github.com/MohBat68/simple-boot.git'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage ('Test') {
            steps {
                echo "-=- Test Project -=-" 
                sh 'mvn test'
            }
            post {
                success { 
                    junit 'target/surefire-reports/*.xml'
                }    
            }
        }
        stage ('Code coverage') {
            steps {
                jacoco(
                    classPattern: 'target/classes',
                    sourcePattern: 'src/main/java',
                    exclusionPattern: 'src/test*'
                )
            }
        }
          stage ('Sanity check') {
            steps {
                echo "-=- Sanity check Test Project -=-" 
                sh 'mvn --batch-mode checkstyle:checkstyle pmd:pmd'
            }
            post {
                always { 
                    recordIssues enabledForFailure: true, tools: [checkStyle(), pmdParser(pattern: '**/target/pmd.xml')]
                }    
            }
        }
    }
}