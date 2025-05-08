# Docker Demo project-1-3 Deploy Docker application with Docker Compose On Server

Deploy Docker application with Docker Compose On Server

### Technologies used:
Docker, Amazon ECR, Node.js, MongoDB, MongoExpress

### Project Objectives:
- Create a docker-compose file configured for deploying the Node.js app, MongoDB,  and MongoExpress
- Login to private Docker registry to fetch the app image
- Start the application container with MongoDB and MongoExpress services using docker compose
---
### Create the Docker Compose File to Remote Server
1. docker-compose sample:
    - https://github.com/kajallad/Devops-practice/Docker/my-node-app/mongo.yaml

### Login to the Private Docker Registry to Fetch the Image
1. pull the image from ECR
    - execute docker login command (can use the same aws docker login command from the push commands)
    - execute docker pull command (make sure you copy the ECR repository name and add the version tag)

### Start the App container with MongoDB and MongoExpress services
1. run the docker-compose command to deploy the Node.js app, MongoDB, and MongoExpress and start the containers
    - `docker-compose -f <yaml file> up`
    example : `docker-compose -f mongo.yaml up`
2. access node app at localhost:3000 and access mongo-express at localhost:8080