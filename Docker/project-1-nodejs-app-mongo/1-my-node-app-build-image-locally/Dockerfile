FROM node:18-alpine

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password

RUN mkdir -p /home/app
# copying only the files needed to run the app
# COPY . /home/app

# set current directory so that next commands executes in /home/app dir
WORKDIR /home/app
COPY package*.json ./
# RUN npm ci --only=production
RUN npm install
COPY . . 
# no need for /home/app/server.js because of WORKDIR
CMD ["node", "server.js"]
