FROM openjdk:17-jdk
EXPOSE 8080

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "-Duser.language=en", "-Duser.region=US","/app.jar"]

RUN curl -d "lastname=TestNone&firstname=Test&birthdate=1966-12-31&gender=F&address=1 Brookside St&phone=100-222-3333" -X POST http://localhost:8080/patient/add \
&& curl -d "lastname=TestBorderline&firstname=Test&birthdate=1945-06-24&gender=M&address=2 High St&phone=200-333-4444" -X POST http://localhost:8080/patient/add \
&& curl -d "lastname=TestInDanger&firstname=Test&birthdate=2004-06-18&gender=M&address=3 Club Road&phone=300-444-5555" -X POST http://localhost:8080/patient/add \
&& curl -d "lastname=TestEarlyOnset&firstname=Test&birthdate=2002-06-28&gender=F&address=4 Valley Dr&phone=400-555-6666" -X POST http://localhost:8080/patient/ad \