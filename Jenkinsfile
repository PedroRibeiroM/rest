pipeline {
    agent any

    environment {
        // Variáveis de ambiente, se necessário
        JAVA_HOME = tool name: 'JDK11', type: 'jdk'
    }

    stages {
        stage('Checkout') {
            steps {
                // Puxando o código do repositório
                git url: 'https://github.com/PedroRibeiroM/rest.git', branch: 'master'
            }
        }

       stage('Build') {
                   steps {
                       // Compilando o projeto com Gradle
                       sh './gradlew clean build'
                   }
               }

               stage('Test') {
                   steps {
                       // Executando testes com Gradle
                       sh './gradlew test'
                   }
               }

               stage('Static Analysis') {
                   steps {
                       // Executando análise estática de código, se necessário
                       sh './gradlew check'
                   }
               }

               stage('Archive Artifacts') {
                   steps {
                       // Arquivando artefatos de build, como arquivos JAR ou WAR
                       archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
                   }
               }

               stage('Deploy') {
                   steps {
                       // Exemplo de deploy - pode ser para um servidor de aplicação ou serviço em nuvem
                       // sh 'scp build/libs/*.jar user@server:/path/to/deploy'
                       // ou
                       // sh './deploy.sh'
                   }
               }
           }

           post {
               success {
                   echo 'Pipeline completada com sucesso!'
               }
               failure {
                   echo 'Pipeline falhou!'
               }
           }
       }