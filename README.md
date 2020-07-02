# Bookstore-microservice


Requirements:
Apache Maven 3.3
Java 1.8
Getting Started
Clone and build the project

```
git clone https://github.com/Hlulani/afrikana-microservice.git
cd bookstore-microservice 
mvn spring-boot:run
```

# Database Setup

MSSQL is used as a datasource for this application. Integration tests use H2 (in-memory database) instead. The config for each one can be found in src/main/resources/application.properties

To run MSSQL locally via docker:

```
   docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=MyPass@word" -e "MSSQL_PID=Express" -p 1433:1433 -d --name=sql microsoft/mssql-server-linux:latest
   
   Run: mssql -u sa -p MyPass@word
```
   
   ### Connect to MSSQL
Create a new database inside your schema and name it: afrikana.

For command line use: https://www.npmjs.com/package/sql-cli

## Using Intellij database manager.

```
 CREATE DATABASE bookstore;
```
