FROM maven:3.9.9-amazoncorretto-21-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar
ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost
ENTRYPOINT java -jar -Dspring.profile.active=prod app.jar