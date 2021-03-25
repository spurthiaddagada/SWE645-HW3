
node {
    stage ('git scm checkout') {
        git credentialsId: 'git', url: 'https://github.com/spurthiaddagada/SWE645-HW3.git'
    }
    stage ('mvn packaging') {
        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvnCmd = "${mvnHome}/bin/mvn"
        sh "echo ${mvnCmd}"
        sh "${mvnCmd} clean package"
        //sh "mvn clean package"
        
    }
    
    stage ('build docker image') {
        shortCommit = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        sh "echo $shortCommit > /tmp/testing.txt"
        sh "docker build -t manishkumar2020/jparest:$shortCommit ."
    }
    
    stage ('push docker image') {
        withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
            sh "docker login -u manishkumar2020 -p ${dockerHubPwd}"
        }
        shortCommit = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        sh "docker push manishkumar2020/jparest:$shortCommit"
    }
    
    //stage ('Invoke_pipeline') {
    //    build job: 'part2', propagate: true, wait: true
     //   }
        
    stage ('git chkout ARGOCD') {
        git branch: 'main', credentialsId: 'git-ssh', url: 'git@github.com:manishjangid/swe645_project.git'
      //  git credentialsId: 'git', url: 'https://github.com/manishjangid/swe645_project.git'
    }
    stage('Update image and push') {

    script {
      catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {

      withCredentials([sshUserPrivateKey(credentialsId: 'git-ssh', keyFileVariable: 'SSH_KEY')]) {
            sh "git config user.name manish"
            sh "ls"
            sh "cd prod"
            sh "cd prod;ls"
            sh 'export FF=`cat /tmp/testing.txt`;cd jpa; /home/manis/kustomize edit set image manishkumar2020/jparest:$FF;/home/manis/kustomize build > test_deployment.yaml; cp test_deployment.yaml deployment.yaml; git add deployment.yaml;git add kustomization.yaml; rm test_deployment.yaml'
            sh "git config user.name manish;git config user.email manish.jangid08@gmail.com;git commit -m 'Updating image ${env.BUILD_NUMBER} with build '"
            //sh "cd prod;git diff ; git add . ;  git push https://${GIT_USERNAME}:${encodedPassword}@github.com/manishjangid/swe645_project.git"
            ssh "echo $SSH_KEY"
            sh 'GIT_SSH_COMMAND="ssh -i $SSH_KEY" git push origin main'
         }
      }
    }
    }
}
