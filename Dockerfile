FROM maven:3.5-jdk-8-alpine as builder

WORKDIR /Applications/dev/projects/test
COPY pom.xml .
COPY src ./src

RUN mvn clean install spring-boot:repackage -DskipTests

FROM openjdk:8-jre-alpine

COPY --from=builder Applications/dev/projects/test/target/rest-api-0.0.1-SNAPSHOT.jar /rest-api.jar

CMD ["java","-Dserver.port=8080", "-Dspring.profiles.active=deploy", "-jar","/rest-api.jar"]
EXPOSE 8080
