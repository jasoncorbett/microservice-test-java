FROM openjdk:8-jdk AS BUILD_SYSTEM

COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/

RUN ./mvnw package

FROM openjdk:8-jdk

COPY --from BUILD_SYSTEM /tmp/target/*.jar /helloworld.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/helloworld.jar"]


