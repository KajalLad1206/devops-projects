# Docker Demo project-1-4 Persist data with Docker Volumes

### Technologies used:
Docker, Node.js, MongoDB

### Project Objectives:
- Persist data of a MongoDB container by attaching a Docker volume to it
---
### Update Docker Compose File and Configure the Volume
1. add volumes at the services level
2. reference the added volumes within the needed services
3. docker-compose file with volumes
    - https://github.com/KajalLad1206/devops-projects/blob/main/Docker/project-1-nodejs-app-mongo/4-my-node-app-deploy-on-server-with-docker-volume/mongo.yaml
4. access the app and make some data changes
    - access node app at localhost:3000
    - or access mongo-express ui at localhost:8080
5. restart the containers with docker-compose
6. the data should be persisted
