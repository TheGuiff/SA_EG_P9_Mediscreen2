FROM openjdk:17-jdk

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "-Duser.language=en", "-Duser.region=US","/app.jar"]