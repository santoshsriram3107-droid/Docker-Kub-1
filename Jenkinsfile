pipeline {
    agent any

    environment {
        IMAGE_NAME = "my-java-app"
        CONTAINER_NAME = "java-app-live"
    }

    stages {
        // --- CONTINUOUS INTEGRATION (CI) ---
        stage('Checkout Code') {
            steps {
                // Pulls the latest code from GitHub when you commit
                checkout scm
            }
        }

        stage('CI: Build & Test') {
            steps {
                // Runs your Maven build command automatically
                sh 'mvn clean package -DskipTests'
            }
        }

        // --- CONTINUOUS DEPLOYMENT (CD) ---
        stage('CD: Build Docker Image') {
            steps {
                // Packages the compiled app into a Docker image using Docker Desktop
                sh "docker build -t ${IMAGE_NAME}:latest ."
            }
        }

        stage('CD: Deploy to Local Environment') {
            steps {
                sh """
                    # Stops the old container if it's running
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true

                    # Automatically launches the new version live
                    docker run -d --name ${CONTAINER_NAME} -p 8081:8081 ${IMAGE_NAME}:latest
                """
            }
        }
    }
}