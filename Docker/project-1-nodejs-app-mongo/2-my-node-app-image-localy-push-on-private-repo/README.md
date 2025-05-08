# Docker Demo project-1-2 - Dockerize Nodejs application and push to private Docker registry
### Technologies used:
Docker, Node.js, Amazon ECR

### Project Objectives:
- Write Dockerfile to build a Docker image for a Nodejs application
- Create private Docker registry on AWS (Amazon ECR)
- Push Docker image to this private repository
---
### Create Dockerfile to Build a Docker Image
1. created Dockerfile

### Create private registry on AWS
1. login to AWS console, go to Services, select/search ECR (Elastic Container Registry)
2. create repository
    - name the repository similar to the nodejs app name/image
    - for AWS ECR, you create one repository per image (unique image)
    - you can have many versions (tags) of the same image in one repository

### Push Docker image to the private repo
NOTE: the commands for pushing will be shown in the 'View push commands' popup on the AWS console
1. select the repository and select 'View push commands' to see the commands for pushing to the repository
    - docker login
        - the aws login command executes docker login under the hood
        - do not have to do docker login everytime you need to push to the repo
2. make sure your image is built with the Dockerfile
3. tag your image with 'docker tag' command (make sure to have the exact version of the tag)
    - with this you are basically making a copy and renaming the image you built
4. run the docker push command
