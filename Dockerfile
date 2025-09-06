FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jre-alpine

COPY --from=builder /target/*.jar app.jar

ENTRYPOINT ["java", "-jar","app.jar"]