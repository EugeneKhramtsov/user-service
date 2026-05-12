FROM azul/zulu-openjdk:17
WORKDIR /home/jackkarter/study/user-service
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","user-service.jar","--spring.datasource.url=jdbc:postgresql://172.17.0.2:5432/userdb","--spring.zipkin.base-url=172.17.0.3"]
