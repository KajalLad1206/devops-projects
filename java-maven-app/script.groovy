def buildJar()
{
    echo "building jar.......!"
     sh 'cd java-maven-app'
     sh 'mvn clean package'  
    // dir('java-maven-app') {
    //     sh 'mvn clean package'
    // }
}
def buildImage()
{
    echo "building an image....!"
    withCredentials([
    usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
    ]) {
        sh 'echo Logging into Docker...'
        sh 'docker build -t username/java-maven-app:1.4 java-maven-app/'
        sh 'echo $PWD | docker login -u $USER  --password-stdin'
        sh 'docker push username/java-maven-app:1.4'
    }
}
def deployApp() {
    echo "deploying an application...!"
}
return this

