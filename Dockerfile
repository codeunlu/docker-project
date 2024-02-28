FROM openjdk:21-jdk-slim AS build
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean
RUN ./mvnw package -Dmaven.test.skip=true

FROM openjdk:21-jdk-slim
WORKDIR app
COPY --from=build target/*.jar docker-app.jar
ENTRYPOINT ["java", "-jar", "docker-app.jar"]