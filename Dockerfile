FROM openjdk
WORKDIR /app
COPY target/lanchonete-api-0.0.1-SNAPSHOT.jar /app/spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]