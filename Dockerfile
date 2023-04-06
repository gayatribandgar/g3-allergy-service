FROM openjdk:17
EXPOSE 9011
ADD /target/AllergyService-0.0.1-SNAPSHOT.jar  g3-allergy-service.jar
ENTRYPOINT [ "java" ,"-jar","g3-allergy-service.jar"]