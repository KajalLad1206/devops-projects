FROM node:18-alpine

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password

RUN mkdir -p /home/app

# copy all contents of app folder to the container
# copying only the files needed to run the app
COPY . /home/app
#COPY ./app /home/app // if all the  package.json and all app replated file in this folder than write 

# # set default dir so that next commands executes in /home/app dir
# WORKDIR /home/app

# # will execute npm install in /home/app because of WORKDIR
# RUN npm install

# no need for /home/app/server.js because of WORKDIR
CMD ["node", "/home/app/server.js"]
