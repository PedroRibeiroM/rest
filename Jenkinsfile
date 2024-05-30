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
                // Compilando o projeto
                bat './mvnw clean package'
            }
        }

        stage('Test') {
            steps {
                // Executando testes
                bat './mvnw test'
            }
        }

        stage('Static Analysis') {
            steps {
                // Executando análise estática de código (opcional)
                bat './mvnw checkstyle:check'
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Arquivando artefatos de build, como arquivos JAR ou WAR
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
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
