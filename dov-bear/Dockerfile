# start with this linux server
FROM node:20

#build the application
WORKDIR /app

#everything after this is in /app
#copy files into directory
COPY main.js .
COPY package.json . 
COPY package-lock.json . 
COPY public public 
COPY views views 

#Build the application - this run is for building
RUN npm ci

# run the application 
# define environment variable
ENV PORT=3000
ENV INSTANCE_NAME ="dov-bear"

#expose this port - reference environment variable
EXPOSE ${PORT} 

#run the program 
ENTRYPOINT SERVER_PORT=${PORT} node main.js
