FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM maven:3.8.2-jdk-11
#WORKDIR /app
#COPY . .
#RUN mvn clean install
#CMD mvn spring-boot:run
EXPOSE 19999