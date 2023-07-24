FROM openjdk:17
EXPOSE 8082
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service
ENTRYPOINT ["java","-jar","user-service"]