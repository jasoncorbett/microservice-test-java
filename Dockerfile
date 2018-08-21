FROM maven:3.5-jdk-8 AS BUILD_SYSTEM

COPY src /usr/src/helloworld/src
COPY pom.xml /usr/src/helloworld/

RUN mvn -f /usr/src/helloworld/pom.xml clean:package

FROM openjdk:8-jdk

COPY --from BUILD_SYSTEM /tmp/target/*.jar /helloworld.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/helloworld.jar"]


