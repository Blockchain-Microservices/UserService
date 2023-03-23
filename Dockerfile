FROM openjdk:19
MAINTAINER dashkin.dima
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/user-service-0.0.1.jar"]