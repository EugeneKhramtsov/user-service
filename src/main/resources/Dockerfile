FROM azul/zulu-openjdk:17
WORKDIR /home/jackkarter/study
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
ENTRYPOINT ["java","-jar","user-service.jar"]
