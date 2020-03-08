FROM adoptopenjdk/openjdk11
LABEL "Description" = "API Service"
COPY target/*.jar api-service.jar
ENTRYPOINT ["java", "-jar", "/api-service.jar"]
