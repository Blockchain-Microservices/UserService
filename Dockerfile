FROM maven:3.9.0-eclipse-temurin-19-alpine AS MAVEN_BUILD

WORKDIR /build/

# COPY pom.xml /build
# COPY src /build/src

COPY . .

RUN mvn install

FROM openjdk:19-jdk-alpine3.16

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/user-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
