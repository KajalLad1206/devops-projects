def buildJar()
{
    echo "building jar.......!"
    // sh 'cd java-maven-app'
    // sh 'mvn clean package'  
    dir('java-maven-app') {
        sh 'mvn clean package'
    }
}
def buildImage()
{
    echo "building an image....!"
    withCredentials([   
        usernamePassword(credentials:'dockerhub-credential', usernameVariable:'USER', passwordVariable:'PWD')
    ])
            
    sh 'docker build -t kajallad126/java-maven-app:1.4 .'
    sh 'echo "$PWD" | docker login -u "$USER"  --password-stdin'
    sh 'docker push kajallad126/java-maven-app:1.4'
}
def deployApp(){
    echo "deploying an application...!"
}
return this

