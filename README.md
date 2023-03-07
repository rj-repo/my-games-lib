# my-games-lib

MyGamesLib is backend part of the application which allow to adding users by Google's account, added games to those users and attaching games (title, rating and cover from Metacritic). The security part (authorization) is handling by Keycloak server. The backend is ***resource-server***.

The goal of this application is to teach some aspects and implementation of authentication and authorization.

### Technology stack
- authorization server
  - Keycloak
- backend framework
  - Spring Boot (with Spring JPA, Spring Security, [library for easier configuration - ch4mpy/spring-addons](https://github.com/ch4mpy/spring-addons))
    - Flyway for database migration etc.
- database
  - PostgreSQL
- additionally
  - Docker to run the app (not for Keycloak)
 
### How to run it
To run this application, we will need:
 - ### Docker
 - ### Keycloak
 
 Before building docker containers you need to configure Keycloak. Basic and necessary configuration you will found here - [Keycloak - basic configuration](https://github.com/ch4mpy/spring-addons/tree/master/samples/tutorials#3-prerequisites)
 
 About docker, just go to **src/docker** folder and run the following command: **docker-compose up**. This part launch spring-boot and create database.
 
