# ### STAGE 1: Build ###
# FROM node:16.10-alpine AS build
# WORKDIR /usr/src/app
# COPY package.json package-lock.json ./
# RUN npm install
# COPY . .
# RUN npm run build
# ### STAGE 2: Run ###
# FROM nginx:1.17.1-alpine
# COPY nginx.conf /etc/nginx/nginx.conf
# COPY --from=build /usr/src/app/dist/digicamp-frontend /usr/share/nginx/html

# pulling base image

#FROM node:latest as node

# Setting the remote DIR to /app

#WORKDIR /Frontend

# COPY the current folder

#COPY . .

# run npm i (install all the dependencies)

#RUN npm install

#EXPOSE 4200

# this will generate dist

#CMD ["npm", "run", "start"]

FROM node
EXPOSE 4200
RUN mkdir -p /usr/src/app
WORKdir /usr/src/app
COPY package.json package.json

RUN npm install -g @angular/cli@latest
COPY . . 

CMD ["npm", "start"]
