# syntax=docker/dockerfile:1
FROM openjdk:17-jdk

COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]