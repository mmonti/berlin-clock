pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        echo 'starting'
      }
    }
    stage('test1') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}