pipeline{
    agent any

    stages{
        stage("Test"){
            steps{
                sh "./mvnw test"
            }
        }
        stage("Package & Deploy"){
            when{branch "master"}
            stages{
                stage("Package") {
                    when{branch "master"}
                    steps {
                        script{
                            sh "./mvnw package -DskipTests"
                        }
                    }
                }
                stage("Deploy"){
                    steps{
                        sh "scp -o StrictHostKeyChecking=no -t target/cadastros-0.0.1-SNAPSHOT.jar ubuntu@17.230.157.2:/home/ubuntu"
                        sh "ssh -o StrictHostKeyChecking=no -t ubuntu@17.230.157.2 'sudo systemctl restart votacao'"
                    }
                }
            }
        }
    }
}

